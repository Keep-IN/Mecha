package com.example.mecha.customer.history;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mecha.R;
import com.example.mecha.model.RecyclerViewAdapterCompletedOrders;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class OrdersFragment extends Fragment {
    FirebaseFirestore mstore;
    private FirebaseAuth mAuth;
    TextView alamat,jam;
    Calendar calendar;
    SimpleDateFormat simpleDateFormat;

    View view;

    private ArrayList<String> alamatPerbaikan = new ArrayList<>();
    private ArrayList<String> statusPerbaikan = new ArrayList<>();
    private ArrayList<String> waktuPerbaikan = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_orders, container, false);

        alamat = view.findViewById(R.id.alamat);
        mAuth = FirebaseAuth.getInstance();
        mstore = FirebaseFirestore.getInstance();
        calendar = Calendar.getInstance();
        jam = view.findViewById(R.id.jam);
        simpleDateFormat= new SimpleDateFormat("HH:mm:ss");

        String date = simpleDateFormat.format(calendar.getTime());


        String userid= mAuth.getCurrentUser().getUid();
        DocumentReference documentReference = mstore.collection("Order").document(userid);
        documentReference.addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException error) {
                alamat.setText(documentSnapshot.getString("Alamat"));
                jam.setText(date);

            }
        });

        getDataCompletedOrders();

        return view;
    }

    private void prosesRecyclerViewAdapter() {
        RecyclerView recyclerView = view.findViewById(R.id.recycleViewCompletedOrders);
        RecyclerViewAdapterCompletedOrders adapter = new RecyclerViewAdapterCompletedOrders(alamatPerbaikan, statusPerbaikan, waktuPerbaikan, getContext());

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    private void getDataCompletedOrders() {
        alamatPerbaikan.add("Jl.Boulevard");
        statusPerbaikan.add("Completed");
        waktuPerbaikan.add("01 Apr 11:35 AM");

        alamatPerbaikan.add("Jl.Degolan");
        statusPerbaikan.add("Completed");
        waktuPerbaikan.add("29 Mar 07.20 AM");

        alamatPerbaikan.add("Jl.Tengah Hutan");
        statusPerbaikan.add("Completed");
        waktuPerbaikan.add("17 Mar 09.59 AM");

        alamatPerbaikan.add("Jl.Boulevard");
        statusPerbaikan.add("Completed");
        waktuPerbaikan.add("01 Apr 11:35 AM");

        alamatPerbaikan.add("Jl.Degolan");
        statusPerbaikan.add("Completed");
        waktuPerbaikan.add("29 Mar 07.20 AM");

        alamatPerbaikan.add("Jl.Tengah Hutan");
        statusPerbaikan.add("Completed");
        waktuPerbaikan.add("17 Mar 09.59 AM");

        prosesRecyclerViewAdapter();
    }

}