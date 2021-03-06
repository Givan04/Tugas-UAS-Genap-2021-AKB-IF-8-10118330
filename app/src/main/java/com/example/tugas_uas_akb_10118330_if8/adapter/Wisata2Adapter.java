package com.example.tugas_uas_akb_10118330_if8.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.example.tugas_uas_akb_10118330_if8.R;
import com.example.tugas_uas_akb_10118330_if8.maps.MapsWisata2Activity;
import com.example.tugas_uas_akb_10118330_if8.model.Wisata2;

import java.util.ArrayList;

public class Wisata2Adapter extends RecyclerView.Adapter<Wisata2Adapter.ViewHolder> {
    private Context context;
    private ArrayList<Wisata2> wisata2s;

    private DatabaseReference ref;

    public Wisata2Adapter(Context context, ArrayList<Wisata2> wisata2s){
        this.context= context;
        this.wisata2s = wisata2s;
        ref = FirebaseDatabase.getInstance("https://uas-akb-10118330-if8-default-rtdb.asia-southeast1.firebasedatabase.app")
                .getReference().child("kabupaten_bandung");
    }
    @Override
    public Wisata2Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_wisata2, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(Wisata2Adapter.ViewHolder holder, int position) {
        holder.tvPreviewWisata2.setText(wisata2s.get(position).getNama_tempat());
        Glide.with(context)
                .load(wisata2s.get(position).getGambar_tempat())
                .into(holder.ivPreviewWisata2);

        holder.itemView.setOnClickListener(view -> {
            Intent detailWisata2 = new Intent(context.getApplicationContext(), MapsWisata2Activity.class);
            detailWisata2.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            detailWisata2.putExtra("nama_tempat", wisata2s.get(position).getNama_tempat());
            detailWisata2.putExtra("biaya_masuk", wisata2s.get(position).getBiaya_masuk());
            detailWisata2.putExtra("alamat_tempat", wisata2s.get(position).getAlamat_tempat());
            detailWisata2.putExtra("gambar_tempat", wisata2s.get(position).getGambar_tempat());
            detailWisata2.putExtra("latitude", wisata2s.get(position).getLatitude());
            detailWisata2.putExtra("longitude", wisata2s.get(position).getLongitude());
            context.startActivity(detailWisata2);
        });
    }

    @Override
    public int getItemCount() {
        return wisata2s.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivPreviewWisata2;
        TextView tvPreviewWisata2;

        public ViewHolder(View itemView) {
            super(itemView);
            ivPreviewWisata2 = itemView.findViewById(R.id.ivPreviewWisata2);
            tvPreviewWisata2 = itemView.findViewById(R.id.tvPreviewWisata2);
        }
    }
}
