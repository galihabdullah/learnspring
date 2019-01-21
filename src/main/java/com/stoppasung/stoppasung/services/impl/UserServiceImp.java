package com.stoppasung.stoppasung.services.impl;

import com.stoppasung.stoppasung.Repository.UserRepository;
import com.stoppasung.stoppasung.error.ResourceNotFoundException;
import com.stoppasung.stoppasung.model.Role;
import com.stoppasung.stoppasung.model.UserModel;
import com.stoppasung.stoppasung.model.UserStatus;
import com.stoppasung.stoppasung.services.UserService;
import com.stoppasung.stoppasung.shared.dto.UserDto;
import com.stoppasung.stoppasung.shared.utils.Utils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    Utils utils;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDto createUser(UserDto userDto){
        if(userRepository.findByEmail(userDto.getEmail()) != null) throw new RuntimeException("Record Already Exist");
        String encryptedPassword = bCryptPasswordEncoder.encode(userDto.getPassword());
        UserModel userModel = new UserModel();
        BeanUtils.copyProperties(userDto, userModel);
        String emailVerificationToken = utils.generateVericationToken(20);
        userModel.setEmailVerificationToken(emailVerificationToken);
        userModel.setUserStatus(UserStatus.INACTIVE);
        userModel.setRole(Role.pelapor);
        userModel.setPassword(bCryptPasswordEncoder.encode(encryptedPassword));
        UserModel stored = userRepository.save(userModel);
        UserDto returnValue = new UserDto();
        BeanUtils.copyProperties(stored, returnValue);
        return returnValue;
    }

    @Override
    public UserDto getUser(String email, String password) {
        UserModel userModel = userRepository.findByEmail(email);
        if(userModel == null) throw new ResourceNotFoundException("email: " + email + " not registered");
        if(bCryptPasswordEncoder.matches(password, userModel.getPassword()));
        UserDto returnValue = new UserDto();
        BeanUtils.copyProperties(userModel, returnValue);
        return returnValue;
    }

}
