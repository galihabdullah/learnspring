package com.stoppasung.stoppasung.controller;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.stoppasung.stoppasung.services.UserProfileService;
import com.stoppasung.stoppasung.services.UserService;
import com.stoppasung.stoppasung.shared.dto.UserDto;
import com.stoppasung.stoppasung.shared.dto.UserProfileDto;
import com.stoppasung.stoppasung.shared.utils.Utils;
import com.stoppasung.stoppasung.ui.model.request.UserLoginRequest;
import com.stoppasung.stoppasung.ui.model.request.UserProfileRequest;
import com.stoppasung.stoppasung.ui.model.request.UserRegistrationRequest;
import com.stoppasung.stoppasung.ui.model.response.UserLoginResponse;
import com.stoppasung.stoppasung.ui.model.response.UserProfileResponse;
import com.stoppasung.stoppasung.ui.model.response.UserRegistrationResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    Utils utils;

    @Autowired
    UserProfileService userProfileService;


    @PostMapping("/registration")
    public UserRegistrationResponse registration(@Valid @RequestBody UserRegistrationRequest userReq){
        UserRegistrationResponse returnValue = new UserRegistrationResponse();
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userReq, userDto);

        UserDto createUser = userService.createUser(userDto);
        BeanUtils.copyProperties(createUser, returnValue);
        return returnValue;
    }

    @GetMapping("/verification")
    public Map<String, Object> userVerification(@RequestParam(value = "token") String token){
            return userService.getUserByEmailVerificationToken(token);
    }

    @PostMapping("/login")
    public UserLoginResponse login(@Valid @RequestBody UserLoginRequest userLoginRequest){
        UserLoginResponse returnValue = new UserLoginResponse();
        UserDto login = new UserDto();
        BeanUtils.copyProperties(userLoginRequest, login);
        UserDto userDto = userService.getUser(login);
        UserProfileResponse userProfileResponse = new UserProfileResponse();
        BeanUtils.copyProperties(userDto, returnValue);
        BeanUtils.copyProperties(userDto.getUserProfile(), userProfileResponse);
        returnValue.setUserProfile(userProfileResponse);
        return returnValue;
    }

    @GetMapping("/resetpassword")
    public Map<String, Object> resetPassword(@RequestParam(value = "email") String email){
        return userService.resetPassword(email);
    }

    @PutMapping("/resetpassword")
    public Map<String, Object> newPassword(@RequestParam(value = "token") String token, @Valid @RequestBody UserRegistrationRequest userRegistrationRequest){
        HashMap<String, Object> returnValue = new HashMap<>();
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userRegistrationRequest, userDto);
        userDto.setPasswordResetToken(token);
        userService.setNewPassword(userDto);
        returnValue.put("status", "sukses");
        return returnValue;
    }

    @PutMapping("{idUser}/profile")
    public UserProfileResponse addUserProfile(@PathVariable(value = "idUser") Long idUser,
                                              @Valid @RequestBody UserProfileRequest userProfileRequest){
        UserProfileResponse returnValue = new UserProfileResponse();
        UserProfileDto profileDto = new UserProfileDto();
        BeanUtils.copyProperties(userProfileRequest, profileDto);
        UserProfileDto profile = userProfileService.addUserProfil(idUser, profileDto);
        BeanUtils.copyProperties(profile, returnValue);
        return returnValue;
    }

    @GetMapping("{idUser}/profile")
    public UserProfileResponse getUserProfile(@PathVariable(value = "idUser") Long idUser){
        UserProfileResponse returnValue = new UserProfileResponse();
        UserProfileDto userProfile = userProfileService.loadByUserId(idUser);
        BeanUtils.copyProperties(userProfile, returnValue);
        return returnValue;
    }

}
