package com.stoppasung.stoppasung.controller;

import com.stoppasung.stoppasung.services.UserService;
import com.stoppasung.stoppasung.shared.dto.UserDto;
import com.stoppasung.stoppasung.shared.utils.Utils;
import com.stoppasung.stoppasung.ui.model.request.UserLoginRequest;
import com.stoppasung.stoppasung.ui.model.request.UserRegistrationRequest;
import com.stoppasung.stoppasung.ui.model.response.UserLoginResponse;
import com.stoppasung.stoppasung.ui.model.response.UserRegistrationResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.validation.Valid;
import java.io.IOException;
import java.util.Map;

@RestController
@CrossOrigin
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    Utils utils;


    @PostMapping("/registration")
    public UserRegistrationResponse registration(@Valid @RequestBody UserRegistrationRequest userReq) throws AddressException, MessagingException, IOException {
        UserRegistrationResponse returnValue = new UserRegistrationResponse();
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userReq, userDto);

        UserDto createUser = userService.createUser(userDto);
        utils.sendmail(createUser.getEmail(), createUser.getFullName(), createUser.getEmailVerificationToken());
        BeanUtils.copyProperties(createUser, returnValue);
        return returnValue;
    }

    @GetMapping("/verification")
    public Map<String, Object> userVerification(@RequestParam(value = "token") String token){
            return userService.getUserByToken(token);
    }

    @PostMapping("/login")
    public UserLoginResponse login(@Valid @RequestBody UserLoginRequest userLoginRequest){
        UserLoginResponse returnValue = new UserLoginResponse();
        UserDto login = new UserDto();
        BeanUtils.copyProperties(userLoginRequest, login);
        UserDto userDto = userService.getUser(login);
        BeanUtils.copyProperties(userDto, returnValue);
        return returnValue;
    }
}
