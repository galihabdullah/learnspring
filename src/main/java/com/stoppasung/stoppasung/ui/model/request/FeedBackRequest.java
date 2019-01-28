package com.stoppasung.stoppasung.ui.model.request;

import com.stoppasung.stoppasung.model.pilihan.Role;

public class FeedBackRequest {

    private String feedBack;
    private String resep;

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
}
