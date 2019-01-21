package com.stoppasung.stoppasung.ui.model.response;

import com.stoppasung.stoppasung.model.Role;
import com.stoppasung.stoppasung.model.UserStatus;

public class UserLoginResponse {

    private Long idUser;
    private String email;
    private Role role;
    private UserStatus userStatus;

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
}
