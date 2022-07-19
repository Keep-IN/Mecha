package com.example.mecha.authui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mecha.customer.CustomerMenuActivity;
import com.example.mecha.R;
import com.example.mecha.customer.home.HomeFragment;
import com.example.mecha.mecha.AcceptingServicesActivity;
import com.example.mecha.mecha.MechaMenuActivity;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class LoginActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    EditText et_password, et_email;
    Button loginButton;
    Button signUpButton;
    Button skipLogin;
    TextView forgotPasswordText;
    Spinner roleUserDropdown;
    private FirebaseAuth mAuth;
    private FirebaseFirestore mstore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        skipLogin = findViewById(R.id.skipBtn);

        skipLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                Intent intent = new Intent(LoginActivity.this, CustomerMenuActivity.class);
//                Intent intent = new Intent(LoginActivity.this, MechaMenuActivity.class);
                startActivity(intent);
                finish();
            }
        });

        mAuth = FirebaseAuth.getInstance();
        mstore = FirebaseFirestore.getInstance();
        et_email = findViewById(R.id.et_email);
        et_password = findViewById(R.id.et_password);
        roleUserDropdown = (Spinner) findViewById(R.id.roleUserDropdown);
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

        if (mAuth.getCurrentUser() != null) {
            DocumentReference df = FirebaseFirestore.getInstance().collection("Users").document(FirebaseAuth.getInstance().getCurrentUser().getUid());
            df.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                @Override
                public void onSuccess(DocumentSnapshot documentSnapshot) {
                    if(documentSnapshot.getString("isMech")!=null){
                        startActivity(new Intent(LoginActivity.this, MechaMenuActivity.class));
                        Toast.makeText(LoginActivity.this, "Masuk Sebagai Mekanik", Toast.LENGTH_LONG).show();
                        finish();
                    }
                    if(documentSnapshot.getString("isCustomer")!=null){
                        startActivity(new Intent(LoginActivity.this, CustomerMenuActivity.class));
                        finish();
                    }
                }
            });

        }

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginUser();
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

    private void loginUser() {
        EditText et_email = findViewById(R.id.et_email);
        EditText et_password = findViewById(R.id.et_password);

        String email = et_email.getText().toString();
        String password = et_password.getText().toString();

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            et_email.setError("Email tidak valid !");
            et_email.requestFocus();
            return;
        }
        if (password.isEmpty()) {
            et_email.setError("Tidak boleh kosong!");
            et_email.requestFocus();
            return;
        }
        if (email.isEmpty()) {
            et_email.setError("Tidak boleh kosong!");
            et_email.requestFocus();
            return;
        }
        mAuth.signInWithEmailAndPassword(email, password)

                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        if (mAuth.getCurrentUser() != null) {
                            DocumentReference df = FirebaseFirestore.getInstance().collection("Users").document(FirebaseAuth.getInstance().getCurrentUser().getUid());
                            df.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                                @Override
                                public void onSuccess(DocumentSnapshot documentSnapshot) {
                                    if(documentSnapshot.getString("isMech")!=null){
                                        startActivity(new Intent(LoginActivity.this, MechaMenuActivity.class));
                                        Toast.makeText(LoginActivity.this, "Masuk Sebagai Mekanik", Toast.LENGTH_LONG).show();
                                        finish();
                                    }
                                    if(documentSnapshot.getString("isCustomer")!=null){
                                        startActivity(new Intent(LoginActivity.this, CustomerMenuActivity.class));
                                        finish();
                                    }
                                }
                            });

                        }
//                        checkLevel(authResult.getUser().getUid());

                    }
                });
//        private void checkLevel (String uid){
//            DocumentReference df = mstore.collection("Users").document(uid);
//            df.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//                @Override
//                public void onSuccess(DocumentSnapshot documentSnapshot) {
//                    Log.d(TAG, "onSuccess: " + documentSnapshot.getData());
//                    if (documentSnapshot.getString("isUser") != null)
//                        startActivity(new Intent(signin.this, HomePencariKerjaActivity.class));
//                    finish();
//                }
//            });
//        }
    }
}