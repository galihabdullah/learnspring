package com.stoppasung.stoppasung.model;

import com.stoppasung.stoppasung.model.pilihan.Role;
import com.stoppasung.stoppasung.model.pilihan.UserStatus;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tb_user")
public class UserModel extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long idUser;

    @NotNull
    @Column(name = "user_email", unique = true)
    private String email;

    @NotNull
    @Column(name = "user_password")
    private String password;

    @NotNull
    @Column(name = "nama_lengkap")
    private String fullName;

    @NotNull
    @Column(name = "user_phone")
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private Role role;

    @NotNull
    @Column(name = "email_verification_token")
    private String emailVerificationToken;

    @NotNull
    @Column(name = "email_verification_status")
    private UserStatus userStatus;

    @Column(name = "password_reset_token")
    private String passwordResetToken;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "userModel")
    private UserDetailModel userDetailModel;


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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserDetailModel getUserDetailModel() {
        return userDetailModel;
    }

    public void setUserDetailModel(UserDetailModel userDetailModel) {
        this.userDetailModel = userDetailModel;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getEmailVerificationToken() {
        return emailVerificationToken;
    }

    public void setEmailVerificationToken(String emailVerificationToken) {
        this.emailVerificationToken = emailVerificationToken;
    }

    public UserStatus getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(UserStatus userStatus) {
        this.userStatus = userStatus;
    }

    public String getPasswordResetToken() {
        return passwordResetToken;
    }

    public void setPasswordResetToken(String passwordResetToken) {
        this.passwordResetToken = passwordResetToken;
    }
}
