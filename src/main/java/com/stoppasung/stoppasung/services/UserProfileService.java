package com.stoppasung.stoppasung.services;

import com.stoppasung.stoppasung.shared.dto.UserProfileDto;

public interface UserProfileService {
    UserProfileDto addUserProfil(Long idUser, UserProfileDto userProfileDto);
    UserProfileDto loadByUserId(Long idUser);
}
