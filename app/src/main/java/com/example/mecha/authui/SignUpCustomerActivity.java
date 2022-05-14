package com.example.mecha.authui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mecha.R;

public class SignUpCustomerActivity extends AppCompatActivity {

    Button signUpCustomerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_customer);

        signUpCustomerButton = findViewById(R.id.signUpCustomerButton);

        signUpCustomerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUpCustomerActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}