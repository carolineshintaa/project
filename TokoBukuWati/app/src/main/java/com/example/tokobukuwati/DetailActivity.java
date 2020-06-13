package com.example.tokobukuwati;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {
    public static final String judul="judul";
    public static final String penulis="penulis";
    public static final String harga="harga";
    public static final String deskripsi="deskripsi";
    public static final String gambar="NULL";
    public ImageView imgdata;
    public TextView tvpenulis;
    public TextView tvjudul;
    public TextView tvdeskripsi;
    public TextView tvharga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvjudul = findViewById(R.id.tv_Buku);
        tvpenulis = findViewById(R.id.tv_namapenulis);
        tvharga = findViewById(R.id.tv_harga);
        tvdeskripsi = findViewById(R.id.tv_deskripsi);
        imgdata = findViewById(R.id.img_Buku);

        String simpanjudul = getIntent().getStringExtra(judul);
        String simpanharga = getIntent().getStringExtra(harga);
        String simpandeskripsi = getIntent().getStringExtra(deskripsi);
        String simpanpenulis = getIntent().getStringExtra(penulis);
        String simpangambar = getIntent().getStringExtra(gambar);

        tvjudul.setText(simpanjudul);
        tvpenulis.setText(simpanpenulis);
        tvharga.setText(simpanharga);
        tvdeskripsi.setText(simpandeskripsi);
        Glide
                .with(this)
                .load(simpangambar)
                .centerCrop()
                .into(imgdata);
    }
}
