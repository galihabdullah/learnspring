package com.stoppasung.stoppasung.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tb_user_detail")
public class UserDetailModel extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUserDetail;

    @Column(name = "alamat")
    private String alamat;

    @Column(name = "kota")
    private String kota;

    @Lob
    @Column(name = "bio")
    private String bio;

    @Column(name = "photo_profile")
    private String photoProfile;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_user")
    private UserModel userModel;

    public UserModel getUserModel() {
        return userModel;
    }

    public void setUserModel(UserModel userModel) {
        this.userModel = userModel;
    }

    public Long getIdUserDetail() {
        return idUserDetail;
    }

    public void setIdUserDetail(Long idUserDetail) {
        this.idUserDetail = idUserDetail;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getKota() {
        return kota;
    }

    public void setKota(String kota) {
        this.kota = kota;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getPhotoProfile() {
        return photoProfile;
    }

    public void setPhotoProfile(String photoProfile) {
        this.photoProfile = photoProfile;
    }
}
