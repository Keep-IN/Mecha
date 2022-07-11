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

public class TireFixActivity extends AppCompatActivity {

    ImageButton btnback;
    CardView gantiBanBtn, gantiVelgBanBtn;
    Button btn_order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tire_fix);

        btnback = findViewById(R.id.btnBack);
        btnback.setOnClickListener(view -> finish());

        btn_order = findViewById(R.id.btnOrder);

        gantiBanBtn = findViewById(R.id.gantiBanBtn);
        gantiBanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }

            private void showDialog() {


                final Dialog dialog = new Dialog(TireFixActivity.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.bottomsheetlayout);

                TextView title = (TextView)dialog.findViewById(R.id.tittleMogok);
                TextView subTitle = (TextView)dialog.findViewById(R.id.subTitlemogok);
                TextView detailNum1 = (TextView)dialog.findViewById(R.id.detailNum1);
                TextView detailNum2 = (TextView)dialog.findViewById(R.id.detailNum2);
                TextView priceRange = (TextView)dialog.findViewById(R.id.priceRange);

                title.setText("Ganti Ban");
                subTitle.setText("Layanan Penggantian Ban ");
                detailNum1.setText("Layanan Penggantian Ban di lokasi pelanggan");
                detailNum2.setText("Mengganti Ban lama dengan yang baru");
                priceRange.setText("Mulai dari Rp 125.000");

                Button btnOrder = dialog.findViewById(R.id.btnOrder);

                btnOrder.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(TireFixActivity.this, MapsActivity.class);
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

        gantiVelgBanBtn = findViewById(R.id.gantiVelgBanBtn);
        gantiVelgBanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }

            private void showDialog() {


                final Dialog dialog = new Dialog(TireFixActivity.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.bottomsheetlayout);

                TextView title = (TextView)dialog.findViewById(R.id.tittleMogok);
                TextView subTitle = (TextView)dialog.findViewById(R.id.subTitlemogok);
                TextView detailNum1 = (TextView)dialog.findViewById(R.id.detailNum1);
                TextView detailNum2 = (TextView)dialog.findViewById(R.id.detailNum2);
                TextView priceRange = (TextView)dialog.findViewById(R.id.priceRange);

                title.setText("Ganti Velg Ban");
                subTitle.setText("Layanan Penggantian Velg Ban");
                detailNum1.setText("Layanan Penggantian velg Ban di lokasi pelanggan");
                detailNum2.setText("Penggantian velg pada ban sesuai standar");
                priceRange.setText("Mulai dari Rp 125.000");

                Button btnOrder = dialog.findViewById(R.id.btnOrder);

                btnOrder.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(TireFixActivity.this, MapsActivity.class);
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