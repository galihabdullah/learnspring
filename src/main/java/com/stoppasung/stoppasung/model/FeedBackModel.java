package com.stoppasung.stoppasung.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.stoppasung.stoppasung.model.pilihan.Role;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "tb_feedback_laporan")
public class FeedBackModel extends AuditModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "feedback")
    private String feedback;

    @Column(name = "resep")
    private String resep;

    @Column(name = "role")
    private Role role;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_laporan", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private LaporanModel laporanModel;

    public LaporanModel getLaporanModel() {
        return laporanModel;
    }

    public void setLaporanModel(LaporanModel laporanModel) {
        this.laporanModel = laporanModel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
