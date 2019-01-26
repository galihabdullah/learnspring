package com.stoppasung.stoppasung.model;

import com.stoppasung.stoppasung.model.pilihan.Kota;

import javax.persistence.*;

@Entity
@Table(name = "laporan")
public class LaporanModel extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_laporan")
    private String idLaporan;

    @Column(name = "nama_pasien")
    private String namaPasien;

    @Column(name = "alamat_pasien")
    private String alamatPasien;

    @Column(name = "kota")
    private Kota kota;

    @Column(name = "kondisi_pasien")
    private String kondisiPasien;

    @Column(name = "photo_pasien")
    private String photoPasien;

    @Column(name = "jenis_kelamin")
    private String jenisKelamin;

    @Column(name = "usia")
    private String usia;

    @Column(name = "email_pelapor")
    private String emailPelapor;

    @Column(name = "email_dokter")
    private String emailDokter;

    public String getEmailPelapor() {
        return emailPelapor;
    }

    public void setEmailPelapor(String emailPelapor) {
        this.emailPelapor = emailPelapor;
    }

    public String getEmailDokter() {
        return emailDokter;
    }

    public void setEmailDokter(String emailDokter) {
        this.emailDokter = emailDokter;
    }

    public Kota getKota() {
        return kota;
    }

    public void setKota(Kota kota) {
        this.kota = kota;
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

    public String getIdLaporan() {
        return idLaporan;
    }

    public void setIdLaporan(String idLaporan) {
        this.idLaporan = idLaporan;
    }
}

