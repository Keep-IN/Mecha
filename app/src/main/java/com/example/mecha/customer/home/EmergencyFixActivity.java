package com.example.mecha.customer.home;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mecha.MapsActivity;
import com.example.mecha.R;
import com.example.mecha.authui.LoginActivity;
//import com.example.mecha.customer.CustomerMenuActivity;

public class EmergencyFixActivity extends AppCompatActivity {

    ImageButton btnback;
    CardView mogokBtn, tambalBanBtn;
    Button btn_order;
    TextView tv_username,tv_email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency_fix);

        btnback = findViewById(R.id.btnBack);
        btnback.setOnClickListener(view -> finish());

        btn_order = findViewById(R.id.btnOrder);

        mogokBtn = findViewById(R.id.mogokBtn);
        mogokBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }

            private void showDialog() {


                final Dialog dialog = new Dialog(EmergencyFixActivity.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.bottomsheetlayout);

                TextView title = (TextView)dialog.findViewById(R.id.tittleMogok);
                TextView subTitle = (TextView)dialog.findViewById(R.id.subTitlemogok);
                TextView detailNum1 = (TextView)dialog.findViewById(R.id.detailNum1);
                TextView detailNum2 = (TextView)dialog.findViewById(R.id.detailNum2);
                TextView priceRange = (TextView)dialog.findViewById(R.id.priceRange);

                title.setText("Mogok dijalan");
                subTitle.setText("layanan mogok dijalan");
                detailNum1.setText("Layanan melakukan perbaikan motor di lokasi pelanggan");
                detailNum2.setText("Harga orderan dihitung berdasarkan jarak tempuh");
                priceRange.setText("Mulai dari Rp 50.000");

                Button btnOrder = dialog.findViewById(R.id.btnOrder);

                btnOrder.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(EmergencyFixActivity.this, MapsActivity.class);
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

        tambalBanBtn = findViewById(R.id.tambalBanBtn);
        tambalBanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }

            private void showDialog() {

                final Dialog dialog = new Dialog(EmergencyFixActivity.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.bottomsheetlayout);

                TextView title = (TextView)dialog.findViewById(R.id.tittleMogok);
                TextView subTitle = (TextView)dialog.findViewById(R.id.subTitlemogok);
                TextView detailNum1 = (TextView)dialog.findViewById(R.id.detailNum1);
                TextView detailNum2 = (TextView)dialog.findViewById(R.id.detailNum2);
                TextView priceRange = (TextView)dialog.findViewById(R.id.priceRange);

                title.setText("Tambal Ban Motor");
                subTitle.setText("Layanan Penambalan Ban Motor");
                detailNum1.setText("Layanan Penambalan Ban Motor yang bocor di lokasi pelanggan");
                detailNum2.setText("Menambal lubang - lubang yang ada pada Ban Motor");
                priceRange.setText("Mulai dari Rp 35.000");
//                Button proceed = (Button)dialog.findViewById(R.id.button);

                Button btnOrder = dialog.findViewById(R.id.btnOrder);

                btnOrder.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(EmergencyFixActivity.this, MapsActivity.class);
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