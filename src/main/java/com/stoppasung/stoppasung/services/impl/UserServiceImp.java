package com.stoppasung.stoppasung.services.impl;

import com.stoppasung.stoppasung.Repository.UserProfileRepository;
import com.stoppasung.stoppasung.Repository.UserRepository;
import com.stoppasung.stoppasung.error.ResourceNotFoundException;
import com.stoppasung.stoppasung.model.UserProfileModel;
import com.stoppasung.stoppasung.model.pilihan.Role;
import com.stoppasung.stoppasung.model.UserModel;
import com.stoppasung.stoppasung.model.pilihan.UserStatus;
import com.stoppasung.stoppasung.services.UserService;
import com.stoppasung.stoppasung.shared.dto.UserDto;
import com.stoppasung.stoppasung.shared.dto.UserProfileDto;
import com.stoppasung.stoppasung.shared.utils.Utils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImp implements UserService {

    private final String url = "http://stoppasung.herokuapp.com/";

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserProfileRepository userProfileRepository;

    @Autowired
    Utils utils;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDto createUser(UserDto userDto){
        if(userRepository.findByEmail(userDto.getEmail()) != null) throw new RuntimeException("Record Already Exist");
        String encryptedPassword = bCryptPasswordEncoder.encode(userDto.getPassword());
        UserModel userModel = new UserModel();
        UserProfileModel userProfileModel = new UserProfileModel();
        BeanUtils.copyProperties(userDto, userModel);
        String emailVerificationToken = utils.generateVericationToken(20);
        userModel.setEmailVerificationToken(emailVerificationToken);
        userModel.setUserStatus(UserStatus.INACTIVE);
        userModel.setPassword(encryptedPassword);
        UserModel stored = userRepository.save(userModel);
        userProfileModel.setUserModel(stored);
        userProfileRepository.save(userProfileModel);
        String message = "Silahkan verifikasi email anda dengan klik link dibawah ini \n " + url + "user/verification?token=" + emailVerificationToken;
        try {
            utils.sendmail(userModel.getEmail(), userModel.getFullName(), message);
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        UserDto returnValue = new UserDto();
        BeanUtils.copyProperties(stored, returnValue);
        return returnValue;
    }

    @Override
    public UserDto getUser(UserDto login) {
        UserModel userModel = userRepository.findByEmail(login.getEmail());
        if(userModel == null) throw new ResourceNotFoundException("email: " + login.getEmail() + " not registered");
        if(bCryptPasswordEncoder.matches(login.getPassword(), userModel.getPassword()))
        {
            if(userModel.getUserStatus() == UserStatus.INACTIVE) throw new ResourceNotFoundException("email " + login.getEmail() + " belum diverifikasi");
            UserDto returnValue = new UserDto();
            UserProfileModel userProfileModel = userProfileRepository.findByUserModelIdUser(userModel.getIdUser());
            UserProfileDto userProfileDto = new UserProfileDto();
            BeanUtils.copyProperties(userProfileModel, userProfileDto);
            BeanUtils.copyProperties(userModel, returnValue);
            returnValue.setUserProfile(userProfileDto);
            return returnValue;
        }else{
            throw new ResourceNotFoundException("password salah");
        }

    }

    public Map<String, Object> getUserByEmailVerificationToken(String token){
        HashMap returnValue = new HashMap();
        UserModel userModel = userRepository.findByEmailVerificationToken(token);
        if(userModel == null) throw new ResourceNotFoundException("token invalid");
        userModel.setUserStatus(UserStatus.ACTIVE);
        userRepository.save(userModel);
        returnValue.put("message", "sukses");
        return returnValue;
    }

    public HashMap<String, Object> resetPassword(String email) {
        HashMap returnValue = new HashMap();
        String token = utils.generateVericationToken(6);
        UserModel userModel = userRepository.findByEmail(email);
        if(userModel == null) throw new ResourceNotFoundException("email " + email + " not found");
        userModel.setPasswordResetToken(token);
        userRepository.save(userModel);
        String message = "Silahkan klik link  \n " + url + "resetpassword?token=" + token + " untuk reset password";
        try {
            utils.sendmail(userModel.getEmail(), userModel.getFullName(), message);
            returnValue.put("message", "reset token berhasil dikirim");
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return returnValue;
    }

    public UserDto setNewPassword(UserDto userDto){
        UserModel userModel = userRepository.findByPasswordResetToken(userDto.getPasswordResetToken());
        if(userModel == null) throw new ResourceNotFoundException("token tidak sesuai");
        String encryptedPassword = bCryptPasswordEncoder.encode(userDto.getPassword());
        userModel.setPassword(encryptedPassword);
        userModel.setPasswordResetToken("0");
        UserModel userModel1 = userRepository.save(userModel);
        UserDto returnValue = new UserDto();
        BeanUtils.copyProperties(userModel1, returnValue);
        return returnValue;

    }
}
