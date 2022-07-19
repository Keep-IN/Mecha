package com.example.mecha.mecha;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.mecha.R;
import com.example.mecha.adapter.UserAdapter;
import com.example.mecha.model.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;


import java.util.ArrayList;
import java.util.List;

public class AcceptingServicesActivity extends AppCompatActivity {

    FirebaseFirestore mstore;
    private List<User> list =new ArrayList<>();
    private UserAdapter userAdapter;

    ImageButton btnback;
    ProgressDialog progressDialog;


    RecyclerView recyclerView;

//    private ArrayList<String> namaCustomer = new ArrayList<>();
//    private ArrayList<String> informasiKendaraan = new ArrayList<>();
//    private ArrayList<String> jenisPerbaikan = new ArrayList<>();
//    private ArrayList<String> hargaPerbaikan = new ArrayList<>();
//    private ArrayList<String> alamatPerbaikan = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accepting_services);
        userAdapter =new UserAdapter(getApplicationContext(),list);
        recyclerView = findViewById(R.id.recycleViewAcceptingServices);
        btnback = findViewById(R.id.btnBack);
        btnback.setOnClickListener(view -> finish());

        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setTitle("Loading");
        progressDialog.setMessage("Sedang mengambil data..");
        progressDialog.show();
        mstore = FirebaseFirestore.getInstance();


        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL,false);
        DividerItemDecoration decoration = new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(decoration);
        recyclerView.setAdapter(userAdapter);
        progressDialog.show();





        mstore.collection("Order")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @SuppressLint("NotifyDataSetChanged")
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        list.clear();
                        if (task.isSuccessful()){
                            for(QueryDocumentSnapshot document : task.getResult()){
                                User user = new User(document.getString("nama"),document.getString("alamat"),document.getString("harga"),document.getString("jenisorderan"));
                                list.add(user);
                            }
                            userAdapter.notifyDataSetChanged();
                        }else{
                            Toast.makeText(getApplicationContext(), "Data gagal diambil", Toast.LENGTH_SHORT).show();
                        }
                        progressDialog.dismiss();
                    }
                });
    }
}