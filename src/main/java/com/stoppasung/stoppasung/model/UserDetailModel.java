package com.stoppasung.stoppasung.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tb_user_detail")
public class UserDetailModel extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUserDetail;

    private String tempatTinggal;

    @Lob
    private String biography;

    private String photoPrfile;


    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_user", nullable = false)
    private UserModel user;

    public Long getIdUserDetail() {
        return idUserDetail;
    }

    public void setIdUserDetail(Long idUserDetail) {
        this.idUserDetail = idUserDetail;
    }

    public String getTempatTinggal() {
        return tempatTinggal;
    }

    public void setTempatTinggal(String tempatTinggal) {
        this.tempatTinggal = tempatTinggal;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getPhotoPrfile() {
        return photoPrfile;
    }

    public void setPhotoPrfile(String photoPrfile) {
        this.photoPrfile = photoPrfile;
    }
}
