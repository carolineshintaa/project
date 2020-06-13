package com.example.tokobukuwati;

public class Buku {
    private String gambar;
    private String judul;
    private String penulis;
    private String harga;
    private String deskripsi;

    public Buku(String datagambar, String datajudul, String datapenulis, String dataharga, String datadeskripsi) {
        gambar = datagambar;
        judul = datajudul;
        penulis = datapenulis;
        harga = dataharga;
        deskripsi = datadeskripsi;
    }

    public String getGambar() {
        return gambar;
    }

    public String getJudul() {
        return judul;
    }

    public String getPenulis() {
        return penulis;
    }

    public String getHarga() {
        return harga;
    }

    public String getDeskripsi() {
        return deskripsi;
    }
}