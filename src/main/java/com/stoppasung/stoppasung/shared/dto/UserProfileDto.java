package com.stoppasung.stoppasung.shared.dto;

import com.stoppasung.stoppasung.model.pilihan.Kota;

import java.io.Serializable;

public class UserProfileDto implements Serializable {

    private static final long serialVersionUID = 7639797832019752179L;
    private String alamat;
    private Kota kota;
    private String bio;
    private String photoProfile;

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public Kota getKota() {
        return kota;
    }

    public void setKota(Kota kota) {
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
