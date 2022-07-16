package com.example.mecha.mecha.mechaHistory;

import android.media.Image;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.mecha.R;
import com.example.mecha.model.RecyclerViewAdapterCompletedPurchases;
import com.example.mecha.model.RecyclerViewAdapterPurchased;

import java.util.ArrayList;

public class MechaPurchasesFragment extends Fragment {

    View view;

    private ArrayList<Image> profilePicture = new ArrayList<>();
    private ArrayList<String> namaCustomer = new ArrayList<>();
    private ArrayList<String> itemPurchased = new ArrayList<>();
    private ArrayList<String> jumlahBarang = new ArrayList<>();
    private ArrayList<String> harga = new ArrayList<>();
    private ArrayList<String> totalHarga = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_mecha_purchases, container, false);

        getDataPurchased();

        return view;
    }

    private void prosesRecyclerViewAdapter() {
        RecyclerView recyclerView = view.findViewById(R.id.recycleViewPurchased);
        RecyclerViewAdapterPurchased adapter = new RecyclerViewAdapterPurchased(namaCustomer, itemPurchased, jumlahBarang, harga, totalHarga, getContext());

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    private void getDataPurchased() {
        namaCustomer.add("CameronWilliamson");
        itemPurchased.add("Mesin Motor");
        jumlahBarang.add("1 Barang");
        harga.add("Rp700.000");
        totalHarga.add("Rp720.000");

        namaCustomer.add("EstherHoward");
        itemPurchased.add("Mesin Motor");
        jumlahBarang.add("1 Barang");
        harga.add("Rp700.000");
        totalHarga.add("Rp720.000");

        namaCustomer.add("BrooklynSimmons");
        itemPurchased.add("Mesin Motor");
        jumlahBarang.add("1 Barang");
        harga.add("Rp700.000");
        totalHarga.add("Rp720.000");

        prosesRecyclerViewAdapter();
    }
}