package com.example.mecha.customer.history;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.example.mecha.MapsActivity;
import com.example.mecha.R;
import com.example.mecha.customer.home.EmergencyFixActivity;
import com.example.mecha.model.RecyclerViewAdapterCompletedOrders;
import com.example.mecha.model.RecyclerViewAdapterCompletedPurchases;

import java.util.ArrayList;

public class PurchasesFragment extends Fragment {

    View view;
    Button lacakBtn;

    private ArrayList<String> waktuPembelian = new ArrayList<>();
    private ArrayList<String> namaBarang = new ArrayList<>();
    private ArrayList<String> jumlahBarang = new ArrayList<>();
    private ArrayList<String> totalBelanja = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_purchases, container, false);

        getDataCompletedPurchases();

        lacakBtn = view.findViewById(R.id.lacakBtn);
        lacakBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }

            private void showDialog() {


                final Dialog dialog = new Dialog(getContext());
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.lacak_pesanan_bottom_sheet_layout);

//                TextView title = (TextView)dialog.findViewById(R.id.tittleMogok);
//                TextView subTitle = (TextView)dialog.findViewById(R.id.subTitlemogok);
//                TextView detailNum1 = (TextView)dialog.findViewById(R.id.detailNum1);
//                TextView detailNum2 = (TextView)dialog.findViewById(R.id.detailNum2);
//                TextView priceRange = (TextView)dialog.findViewById(R.id.priceRange);
//
//                title.setText("Mogok dijalan");
//                subTitle.setText("layanan mogok dijalan");
//                detailNum1.setText("Layanan melakukan perbaikan motor di lokasi pelanggan");
//                detailNum2.setText("Harga orderan dihitung berdasarkan jarak tempuh");
//                priceRange.setText("Mulai dari Rp 50.000");

                Button btnOrder = dialog.findViewById(R.id.btnOrder);

                btnOrder.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(getContext(), MapsActivity.class);
                        startActivity(intent);
                    }
                });

                dialog.show();
                dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
                dialog.getWindow().setGravity(Gravity.BOTTOM);
            }
        });

        return view;
    }

    private void prosesRecyclerViewAdapter() {
        RecyclerView recyclerView = view.findViewById(R.id.recycleViewCompletedPurchases);
        RecyclerViewAdapterCompletedPurchases adapter = new RecyclerViewAdapterCompletedPurchases(waktuPembelian, namaBarang, jumlahBarang, totalBelanja, getContext());

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    private void getDataCompletedPurchases() {
        waktuPembelian.add("24 April 2022");
        namaBarang.add("Mesin Motor");
        jumlahBarang.add("1 Barang");
        totalBelanja.add("Rp700.000");

        waktuPembelian.add("24 April 2022");
        namaBarang.add("Pelumas Rantai");
        jumlahBarang.add("2 Barang");
        totalBelanja.add("Rp80.000");

        waktuPembelian.add("24 April 2022");
        namaBarang.add("Obeng");
        jumlahBarang.add("1 Barang");
        totalBelanja.add("Rp30.000");

        prosesRecyclerViewAdapter();
    }
}