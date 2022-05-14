package com.example.mecha.authui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mecha.HomeActivity;
import com.example.mecha.R;

public class LoginActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Button loginButton;
    Button signUpButton;
    TextView forgotPasswordText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Spinner roleUserDropdown = (Spinner) findViewById(R.id.roleUserDropdown);
        loginButton = findViewById(R.id.loginButton);
        forgotPasswordText = findViewById(R.id.forgotPasswordText);
        signUpButton = findViewById(R.id.signUpButton);

        ArrayAdapter<CharSequence> myAdapterRoleUser = new ArrayAdapter<>(
                LoginActivity.this,
                android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.roleUser)
        );
        myAdapterRoleUser.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        roleUserDropdown.setAdapter(myAdapterRoleUser);
        roleUserDropdown.setOnItemSelectedListener(this);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });

        forgotPasswordText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, ForgotPasswordActivity.class));
            }
        });

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, SignUpChooseRoleActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String sSelected = adapterView.getItemAtPosition(i).toString();
        Toast.makeText(this, sSelected, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}