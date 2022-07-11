package com.example.mecha.customer.history;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.mecha.R;

public class TransactionDetailCompletedOrderActivity extends AppCompatActivity {

    ImageButton btnback;
    Button btnReportProblem;
    TextView alamatPerbaikanView, waktuPerbaikanView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction_detail_completed_order);

        btnback = findViewById(R.id.btnBack);
        btnback.setOnClickListener(view -> finish());

        alamatPerbaikanView = findViewById(R.id.alamatPerbaikanView);
        waktuPerbaikanView = findViewById(R.id.waktuPerbaikanView);
        btnReportProblem = findViewById(R.id.btnReportProblem);

        getIncomingExtra();
    }

    private void getIncomingExtra() {
//        if (getIntent().hasExtra("alamat_perbaikan") && getIntent().hasExtra("waktu_perbaikan")) {
            String alamatPerbaikan = getIntent().getStringExtra("alamat_perbaikan");
            String waktuPerbaikan = getIntent().getStringExtra("waktu_perbaikan");

            setDataActivity(alamatPerbaikan, waktuPerbaikan);
//        }

        btnReportProblem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentToReportProblemActivity = new Intent(getApplicationContext(), ReportProblemActivity.class);

                intentToReportProblemActivity.putExtra("alamat_perbaikan", alamatPerbaikan);
                intentToReportProblemActivity.putExtra("waktu_perbaikan", waktuPerbaikan);

                startActivity(intentToReportProblemActivity);
            }
        });
    }

    private void setDataActivity(String alamatPerbaikan, String waktuPerbaikan) {
        alamatPerbaikanView.setText(alamatPerbaikan);
        waktuPerbaikanView.setText(waktuPerbaikan);
    }
}