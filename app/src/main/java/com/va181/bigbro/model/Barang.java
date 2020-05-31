package com.va181.bigbro.model;

import com.google.gson.annotations.SerializedName;

public class Barang {
    @SerializedName("id")
    private int id;
    @SerializedName("namaBarang")
    private String namaBarang;
    @SerializedName("jumlah")
    private String jumlah;
    @SerializedName("gambar")
    private String gambar;
    @SerializedName("jenis")
    private String jenis;

    public Barang(int id, String namaBarang, String jumlah, String gambar, String jenis) {
        this.id = id;
        this.namaBarang = namaBarang;
        this.jumlah = jumlah;
        this.gambar = gambar;
        this.jenis = jenis;
    }

    public int getId() {
        return id;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public String getJumlah() {
        return jumlah;
    }

    public String getGambar() {
        return gambar;
    }

    public String getJenis() {
        return jenis;
    }
}
