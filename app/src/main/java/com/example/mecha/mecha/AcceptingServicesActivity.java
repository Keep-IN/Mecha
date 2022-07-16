package com.example.mecha.mecha;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.mecha.R;
import com.example.mecha.model.RecyclerViewAdapterAcceptingServices;
import com.example.mecha.model.RecyclerViewAdapterCompletedOrders;

import java.util.ArrayList;

public class AcceptingServicesActivity extends AppCompatActivity {

    ImageButton btnback;

    private ArrayList<String> namaCustomer = new ArrayList<>();
    private ArrayList<String> informasiKendaraan = new ArrayList<>();
    private ArrayList<String> jenisPerbaikan = new ArrayList<>();
    private ArrayList<String> hargaPerbaikan = new ArrayList<>();
    private ArrayList<String> alamatPerbaikan = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accepting_services);

        btnback = findViewById(R.id.btnBack);
        btnback.setOnClickListener(view -> finish());

        getDataAcceptingServices();
    }

    private void prosesRecyclerViewAdapter() {
        RecyclerView recyclerView = findViewById(R.id.recycleViewAcceptingServices);
        RecyclerViewAdapterAcceptingServices adapter = new RecyclerViewAdapterAcceptingServices(namaCustomer, informasiKendaraan, jenisPerbaikan, hargaPerbaikan, alamatPerbaikan, this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void getDataAcceptingServices() {
        namaCustomer.add("Ummi Arra");
        informasiKendaraan.add("Vario B 4299 KXK");
        jenisPerbaikan.add("Mogok Dijalan");
        hargaPerbaikan.add("Rp 30.000");
        alamatPerbaikan.add("Jl. Pamungkas, Sleman. DI Yogyakarta");

        namaCustomer.add("Ara Cowmel");
        informasiKendaraan.add("Beat B 4299 KXK");
        jenisPerbaikan.add("Tambal Ban Motor");
        hargaPerbaikan.add("Rp 20.000");
        alamatPerbaikan.add("Jl. Pamungkas, Sleman. DI Yogyakarta");

        namaCustomer.add("Doraemon");
        informasiKendaraan.add("Revo B 4299 KXK");
        jenisPerbaikan.add("Mogok Dijalan");
        hargaPerbaikan.add("Rp 30.000");
        alamatPerbaikan.add("Jl. Pamungkas, Sleman. DI Yogyakarta");

        namaCustomer.add("Maemunah");
        informasiKendaraan.add("Vario B 4299 KXK");
        jenisPerbaikan.add("Mogok Dijalan");
        hargaPerbaikan.add("Rp 30.000");
        alamatPerbaikan.add("Jl. Pamungkas, Sleman. DI Yogyakarta");

        namaCustomer.add("Udin");
        informasiKendaraan.add("Vario B 4299 KXK");
        jenisPerbaikan.add("Mogok Dijalan");
        hargaPerbaikan.add("Rp 30.000");
        alamatPerbaikan.add("Jl. Pamungkas, Sleman. DI Yogyakarta");

        namaCustomer.add("Sapri");
        informasiKendaraan.add("Vario B 4299 KXK");
        jenisPerbaikan.add("Mogok Dijalan");
        hargaPerbaikan.add("Rp 30.000");
        alamatPerbaikan.add("Jl. Pamungkas, Sleman. DI Yogyakarta");

        prosesRecyclerViewAdapter();
    }
}