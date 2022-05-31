package com.example.mecha.customer.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.mecha.R;
import com.example.mecha.customer.CustomerMenuActivity;

public class FixActivity extends AppCompatActivity {

    ImageButton button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fix);

        button = findViewById(R.id.backHome);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FixActivity.this, CustomerMenuActivity.class);
                startActivity(intent);
            }
        });
    }
}