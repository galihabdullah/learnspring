package com.stoppasung.stoppasung.ui.model.request;

import com.stoppasung.stoppasung.model.pilihan.Kota;

public class LaporanRequest {

    private String namaPasien;
    private String kondisiPasien;
    private String alamatPasien;
    private Kota kota;
    private String photoPasien;
    private String jenisKelamin;
    private String usia;
    private String emailPelapor;
    private String emailDokter;

    public String getEmailDokter() {
        return emailDokter;
    }

    public void setEmailDokter(String emailDokter) {
        this.emailDokter = emailDokter;
    }

    public String getNamaPasien() {
        return namaPasien;
    }

    public void setNamaPasien(String namaPasien) {
        this.namaPasien = namaPasien;
    }

    public String getKondisiPasien() {
        return kondisiPasien;
    }

    public void setKondisiPasien(String kondisiPasien) {
        this.kondisiPasien = kondisiPasien;
    }

    public String getAlamatPasien() {
        return alamatPasien;
    }

    public void setAlamatPasien(String alamatPasien) {
        this.alamatPasien = alamatPasien;
    }

    public Kota getKota() {
        return kota;
    }

    public void setKota(Kota kota) {
        this.kota = kota;
    }

    public String getPhotoPasien() {
        return photoPasien;
    }

    public void setPhotoPasien(String photoPasien) {
        this.photoPasien = photoPasien;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getUsia() {
        return usia;
    }

    public void setUsia(String usia) {
        this.usia = usia;
    }

    public String getEmailPelapor() {
        return emailPelapor;
    }

    public void setEmailPelapor(String emailPelapor) {
        this.emailPelapor = emailPelapor;
    }
}
