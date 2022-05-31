package com.example.mecha.customer.home;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageButton;

import com.example.mecha.R;

public class EmergencyFixActivity extends AppCompatActivity {

    ImageButton btnback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency_fix);

        btnback = findViewById(R.id.btnBack);
        btnback.setOnClickListener(view -> finish());
    }
}