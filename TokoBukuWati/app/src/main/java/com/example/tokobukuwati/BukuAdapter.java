package com.example.tokobukuwati;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class BukuAdapter extends RecyclerView.Adapter<BukuAdapter.BukuViewHolder> {
    private Context context;
    private ArrayList<Buku> bukus;
    private Button btn;

    public BukuAdapter(Context mcontext, ArrayList<Buku> bukuwati) {
        context = mcontext;
        bukus = bukuwati;

    }

    @NonNull
    @Override
    public BukuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_buku,parent, false);
        return new BukuViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull BukuAdapter.BukuViewHolder holder, int position) {
        Buku bukubaru = bukus.get(position);
        String gambar = bukubaru.getGambar();
        String judul = bukubaru.getJudul();
        String deskripsi = bukubaru.getDeskripsi();
        String penulis = bukubaru.getPenulis();
        String harga = bukubaru.getHarga();

        holder.tvbuku.setText(judul);
        holder.tvdeskripsi.setText(deskripsi);
        holder.tvpenulis.setText(penulis);
        holder.tvharga.setText(harga);
        Glide
                .with(context)
                .load(gambar)
                .centerCrop()
                .into(holder.imgdata);
    }

    @Override
    public int getItemCount() {
        return bukus.size();
    }

    public class BukuViewHolder extends RecyclerView.ViewHolder {
        public ImageView imgdata;
        public TextView tvbuku;
        public TextView tvdeskripsi;
        public TextView tvpenulis;
        public TextView tvharga;

        public BukuViewHolder(@NonNull View itemview) {
            super(itemview);
            imgdata = itemview.findViewById(R.id.img_Buku);
            tvbuku = itemview.findViewById(R.id.tv_Buku);
            tvdeskripsi = itemview.findViewById(R.id.tv_deskripsi);
            tvpenulis = itemview.findViewById(R.id.tv_namapenulis);
            tvharga = itemview.findViewById(R.id.tv_harga);

            btn = itemview.findViewById(R.id.btn_tambah) ;
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    intent = new Intent(context, DetailActivity.class);
                    intent.putExtra(DetailActivity.gambar, bukus.get(BukuViewHolder.this.getAdapterPosition()).getGambar());
                    intent.putExtra(DetailActivity.judul, bukus.get(BukuViewHolder.this.getAdapterPosition()).getJudul());
                    intent.putExtra(DetailActivity.penulis, bukus.get(BukuViewHolder.this.getAdapterPosition()).getPenulis());
                    intent.putExtra(DetailActivity.harga, bukus.get(BukuViewHolder.this.getAdapterPosition()).getHarga());
                    intent.putExtra(DetailActivity.deskripsi, bukus.get(BukuViewHolder.this.getAdapterPosition()).getDeskripsi());
                    context.startActivity(intent);

                }
            });
        }
    }
}
