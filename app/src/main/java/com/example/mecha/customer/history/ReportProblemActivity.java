package com.example.mecha.customer.history;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.mecha.R;

public class ReportProblemActivity extends AppCompatActivity {

    ImageButton btnback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_problem);

        btnback = findViewById(R.id.btnBack);
        btnback.setOnClickListener(view -> finish());

        Intent intent = getIntent();

        String alamatPerbaikan = intent.getStringExtra("alamat_perbaikan");
        String waktuPerbaikan = intent.getStringExtra("waktu_perbaikan");

        TextView waktuPerbaikanView = findViewById(R.id.waktuPerbaikanView);
        TextView alamatPerbaikanView = findViewById(R.id.alamatPerbaikanView);

        waktuPerbaikanView.setText(alamatPerbaikan);
        alamatPerbaikanView.setText(waktuPerbaikan);
    }
}