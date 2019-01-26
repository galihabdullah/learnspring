package com.stoppasung.stoppasung.shared.dto;

import com.stoppasung.stoppasung.model.pilihan.Role;

public class FeedBackDto {

    private final long serialVersionUID = 1L;
    private String feedBack;
    private String resep;
    private Role role;
    private LaporanDto laporanDto;

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
