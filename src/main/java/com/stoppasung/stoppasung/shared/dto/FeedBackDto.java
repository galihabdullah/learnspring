package com.stoppasung.stoppasung.shared.dto;

import com.stoppasung.stoppasung.model.pilihan.Role;

import java.util.Date;

public class FeedBackDto {

    private final long serialVersionUID = 1L;
    private Date createAt;
    private Date updateAt;
    private String feedBack;
    private String resep;
    private Role role;
    private LaporanDto laporanDto;

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public LaporanDto getLaporanDto() {
        return laporanDto;
    }

    public void setLaporanDto(LaporanDto laporanDto) {
        this.laporanDto = laporanDto;
    }

    public String getFeedBack() {
        return feedBack;
    }

    public void setFeedBack(String feedBack) {
        this.feedBack = feedBack;
    }

    public String getResep() {
        return resep;
    }

    public void setResep(String resep) {
        this.resep = resep;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
