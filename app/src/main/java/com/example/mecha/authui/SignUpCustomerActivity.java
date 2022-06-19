package com.example.mecha.authui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.mecha.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class SignUpCustomerActivity extends AppCompatActivity {

    FirebaseFirestore mstore;
    private FirebaseAuth mAuth;
    Button signUpCustomerButton;
    EditText et_nama,et_email,et_telepon,et_password,et_repassword;
    ImageButton btnback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_customer);

        btnback = findViewById(R.id.btnBack);
        btnback.setOnClickListener(view -> finish());

        mAuth = FirebaseAuth.getInstance();
        mstore = FirebaseFirestore.getInstance();
        signUpCustomerButton = findViewById(R.id.signUpCustomerButton);

        signUpCustomerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                daftarkanUser();
            }

            private void daftarkanUser() {
                et_email = findViewById(R.id.et_email);
                et_nama =   findViewById(R.id.et_nama);
                et_telepon = findViewById(R.id.et_telepon);
                et_password = findViewById(R.id.et_password);
                et_repassword = findViewById(R.id.et_password);

                String email = et_email.getText().toString();
                String nama = et_nama.getText().toString();
                String telepon = et_telepon.getText().toString();
                String password = et_password.getText().toString();
                String repassword = et_repassword.getText().toString();



                if (nama.isEmpty() || email.isEmpty() || telepon.isEmpty() || password.isEmpty() || repassword.isEmpty()) {
                    Toast.makeText(SignUpCustomerActivity.this, "Tidak boleh kosong !", Toast.LENGTH_LONG).show();
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

                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(SignUpCustomerActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    FirebaseUser uuser = mAuth.getCurrentUser();
//                            User user = new User(username, email, password, repassword);
                                    DocumentReference df = mstore.collection("Users").document((uuser.getUid()));
                                    Map<String,Object> userInfo = new HashMap<>();
                                    userInfo.put("Nama",nama);
                                    userInfo.put("Email",email);
                                    userInfo.put("Telepon",telepon);
                                    userInfo.put("Password",password);
                                    userInfo.put("Repassword",repassword);
                                    //level
                                    userInfo.put("isCustomer","1");
                                    //
                                    df.set(userInfo).addOnCompleteListener(new OnCompleteListener<Void>() {

                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            Toast.makeText(SignUpCustomerActivity.this, "Berhasil", Toast.LENGTH_LONG).show();

                                            showLogin();
                                        }
                                    });
                                } else {
                                    Toast.makeText(SignUpCustomerActivity.this, "Gagal daftar !",
                                            Toast.LENGTH_LONG).show();

                                }
                            }
                        });
            }
        });
    }
    private void showLogin() {
        Intent intent = new Intent(SignUpCustomerActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

}