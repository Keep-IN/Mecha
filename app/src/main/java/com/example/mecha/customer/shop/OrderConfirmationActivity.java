package com.example.mecha.customer.shop;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mecha.R;
import com.example.mecha.authui.LoginActivity;
import com.example.mecha.customer.CustomerMenuActivity;
import com.example.mecha.customer.home.HomeFragment;
import com.example.mecha.customer.settings.ChangePasswordCustomerActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

public class OrderConfirmationActivity extends AppCompatActivity {
    TextView namaJalan;
    FirebaseFirestore mstore;
    private FirebaseAuth mAuth;
    Button btn_order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_confirmation);

        namaJalan = findViewById(R.id.namaJalan);
        btn_order = findViewById(R.id.btn_order);
        mAuth = FirebaseAuth.getInstance();
        mstore = FirebaseFirestore.getInstance();

        String userid= mAuth.getCurrentUser().getUid();
        DocumentReference documentReference = mstore.collection("Order").document(userid);
        documentReference.addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException error) {
                namaJalan.setText(documentSnapshot.getString("Alamat"));

            }
        });

        btn_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(OrderConfirmationActivity.this, CustomerMenuActivity.class));
                finish();
            }
        });
    }
}