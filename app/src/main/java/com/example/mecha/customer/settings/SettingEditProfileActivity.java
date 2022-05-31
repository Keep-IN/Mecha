package com.example.mecha.customer.settings;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.example.mecha.R;

public class SettingEditProfileActivity extends AppCompatActivity {

    ImageView imgBtnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_edit_profile);

        imgBtnBack = findViewById(R.id.img_btn_arrow_back);
        imgBtnBack.setOnClickListener(view -> finish());
    }
}