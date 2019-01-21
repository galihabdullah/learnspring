package com.stoppasung.stoppasung.services;

import com.stoppasung.stoppasung.shared.dto.UserDto;

public interface UserService {
    UserDto createUser(UserDto userDto);
    UserDto getUser(String email, String password);
}
