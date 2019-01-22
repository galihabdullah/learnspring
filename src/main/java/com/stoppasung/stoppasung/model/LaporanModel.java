package com.stoppasung.stoppasung.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "laporan")
public class LaporanModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nama_pasien")
    private String namaPasien;

    @Column(name = "alamat_pasien")
    private String alamatPasien;

    @Column(name = "kondisi_pasien")
    private String kondisiPasien;

    @Column(name = "photo_pasien")
    private String photoPasien;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamaPasien() {
        return namaPasien;
    }

    public void setNamaPasien(String namaPasien) {
        this.namaPasien = namaPasien;
    }

    public String getAlamatPasien() {
        return alamatPasien;
    }

    public void setAlamatPasien(String alamatPasien) {
        this.alamatPasien = alamatPasien;
    }

    public String getKondisiPasien() {
        return kondisiPasien;
    }

    public void setKondisiPasien(String kondisiPasien) {
        this.kondisiPasien = kondisiPasien;
    }

    public String getPhotoPasien() {
        return photoPasien;
    }

    public void setPhotoPasien(String photoPasien) {
        this.photoPasien = photoPasien;
    }
}
