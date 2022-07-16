package com.example.mecha.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mecha.R;
import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;

public class RecyclerViewAdapterPurchased extends RecyclerView.Adapter<RecyclerViewAdapterPurchased.ViewHolder> {

    private ArrayList<String> namaCustomer = new ArrayList<>();
    private ArrayList<String> itemPurchased = new ArrayList<>();
    private ArrayList<String> jumlahBarang = new ArrayList<>();
    private ArrayList<String> harga = new ArrayList<>();
    private ArrayList<String> totalHarga = new ArrayList<>();
    private Context context;

    public RecyclerViewAdapterPurchased(ArrayList<String> namaCustomer, ArrayList<String> itemPurchased, ArrayList<String> jumlahBarang, ArrayList<String> harga, ArrayList<String> totalHarga, Context context) {
        this.namaCustomer = namaCustomer;
        this.itemPurchased = itemPurchased;
        this.jumlahBarang = jumlahBarang;
        this.harga = harga;
        this.totalHarga = totalHarga;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_purchased_history, parent, false);
        RecyclerViewAdapterPurchased.ViewHolder holder = new RecyclerViewAdapterPurchased.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.namaCustomerView.setText(namaCustomer.get(position));
        holder.itemPurchasedView.setText(itemPurchased.get(position));
        holder.jumlahBarangView.setText(jumlahBarang.get(position));
        holder.hargaView.setText(harga.get(position));
        holder.totalHargaView.setText(totalHarga.get(position));

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
        TextView itemPurchasedView;
        TextView jumlahBarangView;
        TextView hargaView;
        TextView totalHargaView;
        MaterialCardView acceptingServicesLihat;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            linearLayoutItemAcceptingServices = itemView.findViewById(R.id.linearLayoutItemAcceptingServices);
            namaCustomerView = itemView.findViewById(R.id.namaCustomerView);
            itemPurchasedView = itemView.findViewById(R.id.itemPurchasedView);
            jumlahBarangView = itemView.findViewById(R.id.jumlahBarangView);
            hargaView = itemView.findViewById(R.id.hargaView);
            totalHargaView = itemView.findViewById(R.id.totalHargaView);
            acceptingServicesLihat = itemView.findViewById(R.id.acceptingServicesLihat);
        }
    }
}
