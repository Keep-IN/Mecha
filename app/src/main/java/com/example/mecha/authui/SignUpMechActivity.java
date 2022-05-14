package com.example.mecha.authui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mecha.R;

public class SignUpMechActivity extends AppCompatActivity {

    Button signUpMechButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_mech);

        signUpMechButton = findViewById(R.id.signUpMechButton);

        signUpMechButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public
            void onClick(View view) {
                Intent intent = new Intent(SignUpMechActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}