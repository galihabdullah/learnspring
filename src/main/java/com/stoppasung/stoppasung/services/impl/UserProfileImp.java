package com.stoppasung.stoppasung.services.impl;

import com.stoppasung.stoppasung.Repository.UserProfileRepository;
import com.stoppasung.stoppasung.Repository.UserRepository;
import com.stoppasung.stoppasung.error.ResourceNotFoundException;
import com.stoppasung.stoppasung.model.UserProfileModel;
import com.stoppasung.stoppasung.services.UserProfileService;
import com.stoppasung.stoppasung.shared.dto.UserProfileDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserProfileImp implements UserProfileService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserProfileRepository userProfileRepository;

    @Override
    public UserProfileDto addUserProfil(Long idUser, UserProfileDto userProfileDto) {
        UserProfileModel userProfileModel = userProfileRepository.findByUserModelIdUser(idUser);
        if(userProfileModel == null) throw new ResourceNotFoundException("User tidak ditemukan");
        BeanUtils.copyProperties(userProfileDto, userProfileModel);
        UserProfileModel userProfileModel1 = userProfileRepository.save(userProfileModel);
        UserProfileDto returnValue = new UserProfileDto();
        BeanUtils.copyProperties(userProfileModel1, returnValue);
        return returnValue;
    }

    @Override
    public UserProfileDto loadByUserId(Long idUser) {
        UserProfileDto returnValue = new UserProfileDto();
        UserProfileModel userProfileModel = userProfileRepository.findByUserModelIdUser(idUser);
        if(userProfileModel == null) throw new ResourceNotFoundException("Id User tidak ditemukan");
        BeanUtils.copyProperties(userProfileModel, returnValue);
        return returnValue;

    }


}
