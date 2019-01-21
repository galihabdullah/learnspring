package com.stoppasung.stoppasung.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "user")
public class UserModel extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
    private UserDetailModel userDetailModel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
