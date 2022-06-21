package com.example.mecha.authui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.mecha.MapsActivity;
import com.example.mecha.customer.CustomerMenuActivity;
import com.example.mecha.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseFirestore mstore;
    ImageButton button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();
        mstore = FirebaseFirestore.getInstance();
        button = findViewById(R.id.toLogin);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                if (mAuth.getCurrentUser() != null) {
                    DocumentReference df = FirebaseFirestore.getInstance().collection("Users").document(FirebaseAuth.getInstance().getCurrentUser().getUid());
                    df.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                        @Override
                        public void onSuccess(DocumentSnapshot documentSnapshot) {
                            if(documentSnapshot.getString("isMech")!=null){
                                startActivity(new Intent(MainActivity.this, CustomerMenuActivity.class));
                                Toast.makeText(MainActivity.this, "Masuk Sebagai Mekanik", Toast.LENGTH_LONG).show();
                                finish();
                            }
                            if(documentSnapshot.getString("isCustomer")!=null){
                                startActivity(new Intent(MainActivity.this, CustomerMenuActivity.class));
                                finish();
                            }
                        }
                    });

                }
                startActivity(intent);
                finish();
            }
        });

    }

}