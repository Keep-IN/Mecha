package com.example.mecha.authui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mecha.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignUpMechActivity extends AppCompatActivity {

    Button signUpMechButton;
    private FirebaseAuth mAuth;
    EditText et_nama,et_email,et_telepon,et_password,et_repassword,et_address;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_mech);


        mAuth = FirebaseAuth.getInstance();
        signUpMechButton = findViewById(R.id.signUpMechButton);

        signUpMechButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                daftarkanUser();
            }
        });
    }
    private void daftarkanUser() {
        et_email = findViewById(R.id.et_email);
        et_nama =   findViewById(R.id.et_nama);
        et_telepon = findViewById(R.id.et_telepon);
        et_password = findViewById(R.id.et_password);
        et_repassword = findViewById(R.id.et_password);
        et_address = findViewById(R.id.et_address);


        String email = et_email.getText().toString();
        String nama = et_nama.getText().toString();
        String address = et_address.getText().toString();
        String telepon = et_telepon.getText().toString();
        String password = et_password.getText().toString();
        String repassword = et_repassword.getText().toString();



        if (nama.isEmpty() || email.isEmpty() || address.isEmpty() || telepon.isEmpty() || password.isEmpty() || repassword.isEmpty()) {
            Toast.makeText(SignUpMechActivity.this, "Tidak boleh kosong !", Toast.LENGTH_LONG).show();
            et_nama.requestFocus();
            return;
        }
        if (nama.length() < 3) {
            et_nama.setError("Less length");
            et_nama.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            et_email.setError("Email tidak valid !");
            et_email.requestFocus();
            return;}
        if (!repassword.equals(password)) {
            et_repassword.setError("Password harus sama !");
            return;
        }

        if (password.length() < 6) {
            et_password.setError("Less length");
            et_password.requestFocus();
            return;
        }
        if (!Patterns.PHONE.matcher(telepon).matches()){
            et_telepon.setError("Telephone tidak valid !");
        }

        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(SignUpMechActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    FirebaseUser user = mAuth.getCurrentUser();
                    Toast.makeText(SignUpMechActivity.this, "Berhasil", Toast.LENGTH_LONG).show();

                    showLogin();

                }else {
                    Toast.makeText(SignUpMechActivity.this, "Gagal daftar !",
                            Toast.LENGTH_LONG).show();}

            }
        });
    }


private void showLogin() {
        Intent intent = new Intent(SignUpMechActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
        }

        }
