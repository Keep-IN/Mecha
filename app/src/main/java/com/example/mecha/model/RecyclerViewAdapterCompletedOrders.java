package com.example.mecha.model;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mecha.R;

import java.util.ArrayList;

public class RecyclerViewAdapterCompletedOrders extends RecyclerView.Adapter<RecyclerViewAdapterCompletedOrders.ViewHolder> {

    private ArrayList<String> alamatPerbaikan = new ArrayList<>();
    private ArrayList<String> statusPerbaikan = new ArrayList<>();
    private ArrayList<String> waktuPerbaikan = new ArrayList<>();
    private Context context;

    public RecyclerViewAdapterCompletedOrders(ArrayList<String> alamatPerbaikan, ArrayList<String> statusPerbaikan, ArrayList<String> waktuPerbaikan, Context context) {
        this.alamatPerbaikan = alamatPerbaikan;
        this.statusPerbaikan = statusPerbaikan;
        this.waktuPerbaikan = waktuPerbaikan;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_completed, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.alamatPerbaikanView.setText(alamatPerbaikan.get(position));
        holder.statusPerbaikanView.setText(statusPerbaikan.get(position));
        holder.waktuPerbaikanView.setText(waktuPerbaikan.get(position));

//        holder.buttonLihat.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(context, posisiLowongan.get(holder.getAdapterPosition()), Toast.LENGTH_SHORT).show();
//            }
//        });

//        holder.buttonLihat.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                Toast.makeText(context, posisiLowongan.get(holder.getAdapterPosition()), Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(context, JobDetailActivity.class);
//
//                intent.putExtra("posisi_lowongan", posisiLowongan.get(holder.getAdapterPosition()));
//                intent.putExtra("nama_perusahaan", namaPerusahaan.get(holder.getAdapterPosition()));
//                intent.putExtra("alamat_lowongan", alamatLowongan.get(holder.getAdapterPosition()));
//                intent.putExtra("minimal_pendidikan", minimalPendidikan.get(holder.getAdapterPosition()));
//                intent.putExtra("gaji", gaji.get(holder.getAdapterPosition()));
//                intent.putExtra("tenggat_lowongan", tenggatLowongan.get(holder.getAdapterPosition()));
//
//                context.startActivities(new Intent[]{intent});
//
//
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return alamatPerbaikan.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        LinearLayout linearLayoutItemCompletedOrders;
        TextView alamatPerbaikanView;
        TextView statusPerbaikanView;
        TextView waktuPerbaikanView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            linearLayoutItemCompletedOrders = itemView.findViewById(R.id.linearLayoutItemCompletedOrders);
            alamatPerbaikanView = itemView.findViewById(R.id.alamatPerbaikanView);
            statusPerbaikanView = itemView.findViewById(R.id.statusPerbaikanView);
            waktuPerbaikanView = itemView.findViewById(R.id.waktuPerbaikanView);
        }
    }
}
