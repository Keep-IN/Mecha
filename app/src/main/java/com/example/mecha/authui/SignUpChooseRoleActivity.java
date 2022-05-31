package com.example.mecha.authui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.mecha.R;

public class SignUpChooseRoleActivity extends AppCompatActivity {

    ImageButton mechRoleButton;
    ImageButton mechCustomerButton;
    ImageButton btnback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_choose_role);

        btnback = findViewById(R.id.btnBack);
        btnback.setOnClickListener(view -> finish());

        mechRoleButton = findViewById(R.id.mechRoleButton);
        mechCustomerButton = findViewById(R.id.mechCustomerButton);

        mechRoleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUpChooseRoleActivity.this, SignUpMechActivity.class);
                startActivity(intent);
//                finish();
            }
        });

        mechCustomerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUpChooseRoleActivity.this, SignUpCustomerActivity.class);
                startActivity(intent);
//                finish();
            }
        });
    }
}