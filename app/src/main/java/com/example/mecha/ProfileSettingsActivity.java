package com.example.mecha;

import androidx.activity.OnBackPressedDispatcher;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ProfileSettingsActivity extends AppCompatActivity {

    ImageView imgBtnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_settings);

        imgBtnBack = findViewById(R.id.img_btn_arrow_back);
        imgBtnBack.setOnClickListener(view -> finish());
    }
}