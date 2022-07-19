package com.example.mecha.mecha;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.mecha.R;
import com.example.mecha.mecha.mechaHistory.MechaHistoryFragment;
import com.example.mecha.mecha.mechaHome.MechaHomeFragment;
import com.example.mecha.mecha.mechaSettings.MechaSettingsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class MechaMenuActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationMecha;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mecha_menu);
        mAuth = FirebaseAuth.getInstance();
            bottomNavigationMecha = findViewById(R.id.bottom_navigation_mecha);
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MechaHomeFragment()).commit();
            bottomNavigationMecha.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selected_fragment = null;
                    switch (item.getItemId()) {
                        case R.id.nav_home:
                            selected_fragment = new MechaHomeFragment();
                            break;
                        case R.id.nav_history:
                            selected_fragment = new MechaHistoryFragment();
                            break;
                        case R.id.nav_settings:
                            selected_fragment = new MechaSettingsFragment();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selected_fragment).commit();

                    return true;
                }
            });

        }
    }

