package com.stoppasung.stoppasung.services;

import com.stoppasung.stoppasung.shared.dto.UserDto;

import java.util.Map;

public interface UserService {
    UserDto createUser(UserDto userDto);
    UserDto getUser(UserDto userDto);
    Map<String, Object> getUserByEmailVerificationToken(String token);
    UserDto getUserByEmail(UserDto userDto);
}
