package com.stoppasung.stoppasung.ui.model.response;

import com.stoppasung.stoppasung.model.pilihan.Role;
import com.stoppasung.stoppasung.model.pilihan.UserStatus;

public class UserLoginResponse {

    private Long idUser;
    private String email;
    private Role role;
    private UserStatus userStatus;
    private String fullName;
    private String photoProfile;
    private UserProfileResponse userProfile;

    public UserProfileResponse getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfileResponse userProfile) {
        this.userProfile = userProfile;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public UserStatus getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(UserStatus userStatus) {
        this.userStatus = userStatus;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhotoProfile() {
        return photoProfile;
    }

    public void setPhotoProfile(String photoProfile) {
        this.photoProfile = photoProfile;
    }
}
