package com.stoppasung.stoppasung.ui.model.request;

import com.stoppasung.stoppasung.model.pilihan.Role;

public class FeedBackRequest {

    private String feedback;
    private String resep;
    private Role role;

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
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
