package com.example.mecha.customer.settings;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mecha.R;
import com.example.mecha.authui.LoginActivity;
import com.example.mecha.authui.SignUpCustomerActivity;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import java.util.HashMap;
import java.util.Map;

public class SettingEditProfileActivity extends AppCompatActivity {

    ImageView imgBtnBack;
    EditText edt_name,edt_address,edt_email,edt_phone;
    Button toSave;
    FirebaseFirestore mstore;
    TextView yahaha;
    private FirebaseAuth mAuth;
    private GoogleMap gMap;
    String userid,Password,Repassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_edit_profile);

        imgBtnBack = findViewById(R.id.img_btn_arrow_back);
        imgBtnBack.setOnClickListener(view -> finish());

        mAuth = FirebaseAuth.getInstance();
        mstore = FirebaseFirestore.getInstance();
        edt_name = findViewById(R.id.edt_name);
        edt_address = findViewById(R.id.edt_address);
        edt_email = findViewById(R.id.edt_email);
        edt_phone = findViewById(R.id.edt_phone);
        toSave =findViewById(R.id.toSave);

//        String nama = edt_name.getText().toString();
//        String address = edt_address.getText().toString();
//        String email = edt_email.getText().toString();
//        String phone = edt_phone.getText().toString();

        if (mAuth.getCurrentUser() != null) {
            userid= mAuth.getCurrentUser().getUid();
            DocumentReference documentReference = mstore.collection("Users").document(userid);
            documentReference.addSnapshotListener(new EventListener<DocumentSnapshot>() {
                @Override
                public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException error) {
                    edt_email.setText(documentSnapshot.getString("Email"));
                    edt_name.setText(documentSnapshot.getString("Nama"));
                    edt_phone.setText(documentSnapshot.getString("Telepon"));
                }
            });
        }


        toSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mAuth.getCurrentUser() != null) {
                    String nama = edt_name.getText().toString();
                    String address = edt_address.getText().toString();
                    String email = edt_email.getText().toString();
                    String phone = edt_phone.getText().toString();

                    userid= mAuth.getCurrentUser().getUid();
//                    DocumentReference documentReference = mstore.collection("Users").document(userid);
//                    documentReference.addSnapshotListener(new EventListener<DocumentSnapshot>() {
//                        @Override
//                        public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException error) {
//                            yahaha.setText(documentSnapshot.getString("Password"));
//                        }
//                    });


                    DocumentReference df = mstore.collection("Users").document(userid);
                    Map<String, Object> userInfo = new HashMap<>();



//                    userInfo.put("Password",yahaha);
                    userInfo.put("Nama",nama);
                    userInfo.put("Email",email);
                    userInfo.put("Telepon",phone);

                    //level
                    userInfo.put("isCustomer","1");

                    df.set(userInfo).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            Toast.makeText(SettingEditProfileActivity.this, "Berhasil !", Toast.LENGTH_SHORT).show();

                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(SettingEditProfileActivity.this, "Gagal !", Toast.LENGTH_SHORT).show();
                        }
                    });

                }
            }

        });


    }
}