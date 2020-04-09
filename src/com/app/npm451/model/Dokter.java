/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.npm451.model;

/**
 *
 * @author WORKGROUP
 */
public class Dokter {
    private String idDokter;
    private String nama;
    private String spesialis;
    private String alamat;
    private String umur;

    public Dokter() {
    }

    public Dokter(String idDokter, String nama, String spesialis, String alamat, String umur) {
        this.idDokter = idDokter;
        this.nama = nama;
        this.spesialis = spesialis;
        this.alamat = alamat;
        this.umur = umur;
    }

    public String getIdDokter() {
        return idDokter;
    }

    public void setIdDokter(String idDokter) {
        this.idDokter = idDokter;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getSpesialis() {
        return spesialis;
    }

    public void setSpesialis(String spesialis) {
        this.spesialis = spesialis;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getUmur() {
        return umur;
    }

    public void setUmur(String umur) {
        this.umur = umur;
    }
    
    
}
