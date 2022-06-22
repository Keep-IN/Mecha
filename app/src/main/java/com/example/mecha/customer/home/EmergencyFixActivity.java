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
import android.widget.Toast;

import com.example.mecha.MapsActivity;
import com.example.mecha.R;
import com.example.mecha.authui.LoginActivity;
import com.example.mecha.customer.CustomerMenuActivity;

public class EmergencyFixActivity extends AppCompatActivity {

    ImageButton btnback;
    CardView mogokBtn;
    Button btn_order;

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