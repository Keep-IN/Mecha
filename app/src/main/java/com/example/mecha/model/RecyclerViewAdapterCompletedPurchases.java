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

public class RecyclerViewAdapterCompletedPurchases extends RecyclerView.Adapter<RecyclerViewAdapterCompletedPurchases.ViewHolder> {

    private ArrayList<String> waktuPembelian = new ArrayList<>();
    private ArrayList<String> namaBarang = new ArrayList<>();
    private ArrayList<String> jumlahBarang = new ArrayList<>();
    private ArrayList<String> totalBelanja = new ArrayList<>();
    private Context context;

    public RecyclerViewAdapterCompletedPurchases(ArrayList<String> waktuPembelian, ArrayList<String> namaBarang, ArrayList<String> jumlahBarang, ArrayList<String> totalBelanja, Context context) {
        this.waktuPembelian = waktuPembelian;
        this.namaBarang = namaBarang;
        this.jumlahBarang = jumlahBarang;
        this.totalBelanja = totalBelanja;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_completed_purchases, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.waktuPembelianView.setText(waktuPembelian.get(position));
        holder.namaBarangView.setText(namaBarang.get(position));
        holder.jumlahBarangView.setText(jumlahBarang.get(position));
        holder.totalBelanjaView.setText(totalBelanja.get(position));

        holder.purchasesCompletedLihat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, waktuPembelian.get(holder.getAdapterPosition()), Toast.LENGTH_SHORT).show();
            }
        });

//        holder.purchasesCompletedLihat.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                Toast.makeText(context, posisiLowongan.get(holder.getAdapterPosition()), Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(context, TransactionDetailCompletedOrderActivity.class);
//
//                intent.putExtra("waktu_pembelian", waktuPembelian.get(holder.getAdapterPosition()));
//                intent.putExtra("nama_barang", namaBarang.get(holder.getAdapterPosition()));
//                intent.putExtra("jumlah_barang", jumlahBarang.get(holder.getAdapterPosition()));
//                intent.putExtra("totalB_belanja", totalBelanja.get(holder.getAdapterPosition()));
//
//                context.startActivities(new Intent[]{intent});
//
//
//            }
//        });

    }

    @Override
    public int getItemCount() {
        return waktuPembelian.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        LinearLayout linearLayoutItemCompletedPurchases;
        TextView waktuPembelianView;
        TextView namaBarangView;
        TextView jumlahBarangView;
        TextView totalBelanjaView;
        MaterialCardView purchasesCompletedLihat;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            linearLayoutItemCompletedPurchases = itemView.findViewById(R.id.linearLayoutItemCompletedPurchases);
            waktuPembelianView = itemView.findViewById(R.id.waktuPembelianView);
            namaBarangView = itemView.findViewById(R.id.namaBarangView);
            jumlahBarangView = itemView.findViewById(R.id.jumlahBarangView);
            totalBelanjaView = itemView.findViewById(R.id.totalBelanjaView);
            purchasesCompletedLihat = itemView.findViewById(R.id.purchasesCompletedLihat);
        }
    }
}
