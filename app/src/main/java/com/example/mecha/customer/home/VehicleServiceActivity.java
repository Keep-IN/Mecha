package com.example.mecha.customer.home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.mecha.MapsActivity;
import com.example.mecha.R;

public class VehicleServiceActivity extends AppCompatActivity {

    ImageButton btnback;
    CardView gantiOliMotorBtn, injeksiMotorBtn, karburatorMotorBtn;
    Button btn_order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle_service);

        btnback = findViewById(R.id.btnBack);
        btnback.setOnClickListener(view -> finish());

        btnback = findViewById(R.id.btnBack);
        btnback.setOnClickListener(view -> finish());

        btn_order = findViewById(R.id.btnOrder);

        gantiOliMotorBtn = findViewById(R.id.gantiOliMotorBtn);
        gantiOliMotorBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }

            private void showDialog() {


                final Dialog dialog = new Dialog(VehicleServiceActivity.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.bottomsheetlayout);

                TextView title = (TextView)dialog.findViewById(R.id.tittleMogok);
                TextView subTitle = (TextView)dialog.findViewById(R.id.subTitlemogok);
                TextView detailNum1 = (TextView)dialog.findViewById(R.id.detailNum1);
                TextView detailNum2 = (TextView)dialog.findViewById(R.id.detailNum2);
                TextView priceRange = (TextView)dialog.findViewById(R.id.priceRange);

                title.setText("Ganti Oli Motor");
                subTitle.setText("Layanan Penggantian Oli Motor");
                detailNum1.setText("Layanan Penggantian Oli Motor di lokasi pelanggan");
                detailNum2.setText("Mengganti Oli lama dengan yang baru");
                priceRange.setText("Mulai dari Rp50.000");

                Button btnOrder = dialog.findViewById(R.id.btnOrder);

                btnOrder.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(VehicleServiceActivity.this, MapsActivity.class);
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

        injeksiMotorBtn = findViewById(R.id.injeksiMotorBtn);
        injeksiMotorBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }

            private void showDialog() {


                final Dialog dialog = new Dialog(VehicleServiceActivity.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.bottomsheetlayout);

                TextView title = (TextView)dialog.findViewById(R.id.tittleMogok);
                TextView subTitle = (TextView)dialog.findViewById(R.id.subTitlemogok);
                TextView detailNum1 = (TextView)dialog.findViewById(R.id.detailNum1);
                TextView detailNum2 = (TextView)dialog.findViewById(R.id.detailNum2);
                TextView priceRange = (TextView)dialog.findViewById(R.id.priceRange);

                title.setText("Injeksi Motor");
                subTitle.setText("Layanan Perawatan Motor Bermesin Injeksi");
                detailNum1.setText("Layanan Perawatan Motor bermesin injeksi di lokasi pelanggan");
                detailNum2.setText("Pengecekan kualitas mesin Motor Injeksi");
                priceRange.setText("Mulai dari Rp 60.000");

                Button btnOrder = dialog.findViewById(R.id.btnOrder);

                btnOrder.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(VehicleServiceActivity.this, MapsActivity.class);
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

        karburatorMotorBtn = findViewById(R.id.karburatorMotorBtn);
        karburatorMotorBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }

            private void showDialog() {


                final Dialog dialog = new Dialog(VehicleServiceActivity.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.bottomsheetlayout);

                TextView title = (TextView)dialog.findViewById(R.id.tittleMogok);
                TextView subTitle = (TextView)dialog.findViewById(R.id.subTitlemogok);
                TextView detailNum1 = (TextView)dialog.findViewById(R.id.detailNum1);
                TextView detailNum2 = (TextView)dialog.findViewById(R.id.detailNum2);
                TextView priceRange = (TextView)dialog.findViewById(R.id.priceRange);

                title.setText("Karburator Motor");
                subTitle.setText("Layanan Perawatan Motor Bermesin Karburator");
                detailNum1.setText("Layanan Perawatan Motor bermesin karburator di lokasi pelanggan");
                detailNum2.setText("Pengecekan kualitas mesin Motor Karburator");
                priceRange.setText("Mulai dari Rp 60.000");

                Button btnOrder = dialog.findViewById(R.id.btnOrder);

                btnOrder.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(VehicleServiceActivity.this, MapsActivity.class);
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
    }
}