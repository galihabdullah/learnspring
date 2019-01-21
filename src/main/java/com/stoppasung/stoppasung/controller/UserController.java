package com.stoppasung.stoppasung.controller;

import com.stoppasung.stoppasung.Repository.UserRepository;
import com.stoppasung.stoppasung.model.Role;
import com.stoppasung.stoppasung.model.UserModel;
import com.stoppasung.stoppasung.services.UserService;
import com.stoppasung.stoppasung.shared.dto.UserDto;
import com.stoppasung.stoppasung.ui.model.request.UserLoginRequest;
import com.stoppasung.stoppasung.ui.model.request.UserRegistrationRequest;
import com.stoppasung.stoppasung.ui.model.response.UserLoginResponse;
import com.stoppasung.stoppasung.ui.model.response.UserRegistrationResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin
public class UserController {

    @Autowired
    UserService userService;


    @PostMapping("/registration")
    public UserRegistrationResponse registration(@Valid @RequestBody UserRegistrationRequest userReq){
        UserRegistrationResponse returnValue = new UserRegistrationResponse();
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userReq, userDto);

        UserDto createUser = userService.createUser(userDto);
        BeanUtils.copyProperties(createUser, returnValue);
        return returnValue;
    }

    @PostMapping("/login")
    public UserLoginResponse login(@Valid @RequestBody UserLoginRequest userLoginRequest){
        UserLoginResponse returnValue = new UserLoginResponse();
        UserDto userDto = userService.getUser(userLoginRequest.getEmail(), userLoginRequest.getPassword());
        BeanUtils.copyProperties(userDto, returnValue);
        return returnValue;
    }
}
