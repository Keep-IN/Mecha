package com.example.mecha.model;

public class User {
    String nama,alamat,harga,jenisorderan;

    public User(){

    }

    public User(String nama,String alamat,String harga,String jenisorderan){
        this.nama = nama;
        this.alamat = alamat;
        this.harga = harga;
        this.jenisorderan = jenisorderan;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getJenisorderan() {
        return jenisorderan;
    }

    public void setJenisorderan(String jenisorderan) {
        this.jenisorderan = jenisorderan;
    }
}
