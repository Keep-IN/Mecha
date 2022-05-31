package com.example.mecha.customer.settings;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.mecha.R;

public class ChangePasswordCustomerActivity extends AppCompatActivity {

    ImageButton btnback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password_customer);

        btnback = findViewById(R.id.btn_back);
        btnback.setOnClickListener(view -> finish());
    }
}