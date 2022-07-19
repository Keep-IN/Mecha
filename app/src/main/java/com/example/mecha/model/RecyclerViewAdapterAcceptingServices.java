package com.example.mecha.model;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mecha.R;
import com.example.mecha.customer.history.TransactionDetailCompletedOrderActivity;
import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;

public class RecyclerViewAdapterAcceptingServices extends RecyclerView.Adapter<RecyclerViewAdapterAcceptingServices.ViewHolder> {

    private ArrayList<String> namaCustomer = new ArrayList<>();
    private ArrayList<String> informasiKendaraan = new ArrayList<>();
    private ArrayList<String> jenisPerbaikan = new ArrayList<>();
    private ArrayList<String> hargaPerbaikan = new ArrayList<>();
    private ArrayList<String> alamatPerbaikan = new ArrayList<>();
    private Context context;

    public RecyclerViewAdapterAcceptingServices(ArrayList<String> namaCustomer, ArrayList<String> informasiKendaraan, ArrayList<String> jenisPerbaikan, ArrayList<String> hargaPerbaikan, ArrayList<String> alamatPerbaikan, Context context) {
        this.namaCustomer = namaCustomer;
        this.informasiKendaraan = informasiKendaraan;
        this.jenisPerbaikan = jenisPerbaikan;
        this.hargaPerbaikan = hargaPerbaikan;
        this.alamatPerbaikan = alamatPerbaikan;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_accepting_services, parent, false);
        ViewHolder holder = new RecyclerViewAdapterAcceptingServices.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.namaCustomerView.setText(namaCustomer.get(position));
        holder.informasiKendaraanView.setText(informasiKendaraan.get(position));
        holder.jenisPerbaikanView.setText(jenisPerbaikan.get(position));
        holder.hargaPerbaikanView.setText(hargaPerbaikan.get(position));
        holder.alamatPerbaikanView.setText(alamatPerbaikan.get(position));

//        holder.acceptingServiceLihat.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(context, namaCustomer.get(holder.getAdapterPosition()), Toast.LENGTH_SHORT).show();
//            }
//        });

//        holder.acceptingServiceLihat.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                Toast.makeText(context, posisiLowongan.get(holder.getAdapterPosition()), Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(context, TransactionDetailCompletedOrderActivity.class);
//
//                intent.putExtra("alamat_perbaikan", alamatPerbaikan.get(holder.getAdapterPosition()));
//                intent.putExtra("waktu_perbaikan", waktuPerbaikan.get(holder.getAdapterPosition()));
//
//                context.startActivities(new Intent[]{intent});
//
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return namaCustomer.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        LinearLayout linearLayoutItemAcceptingServices;
        TextView namaCustomerView;
        TextView informasiKendaraanView;
        TextView jenisPerbaikanView;
        TextView hargaPerbaikanView;
        TextView alamatPerbaikanView;
        MaterialCardView acceptingServicesLihat;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            linearLayoutItemAcceptingServices = itemView.findViewById(R.id.linearLayoutItemAcceptingServices);
            namaCustomerView = itemView.findViewById(R.id.nama);
            informasiKendaraanView = itemView.findViewById(R.id.informasiKendaraanView);
            jenisPerbaikanView = itemView.findViewById(R.id.jenisorderan);
            hargaPerbaikanView = itemView.findViewById(R.id.harga);
            alamatPerbaikanView = itemView.findViewById(R.id.alamat);
            acceptingServicesLihat = itemView.findViewById(R.id.acceptingServicesLihat);
        }
    }
}
