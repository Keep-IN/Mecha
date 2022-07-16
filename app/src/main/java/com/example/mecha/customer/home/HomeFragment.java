package com.example.mecha.customer.home;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mecha.R;
import com.example.mecha.authui.LoginActivity;
import com.example.mecha.mecha.AcceptingServicesActivity;

public class HomeFragment extends Fragment {

    CardView emergencyFixBtn, tireFixBtn, vehicleServiceBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_home, container, false);

        emergencyFixBtn = view.findViewById(R.id.emergencyFixBtn);
        tireFixBtn = view.findViewById(R.id.tireFixBtn);
        vehicleServiceBtn = view.findViewById(R.id.vehicleServiceBtn);

        emergencyFixBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backHome = new Intent(getActivity(), EmergencyFixActivity.class);
                startActivity(backHome);
            }
        });

        tireFixBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backHome = new Intent(getActivity(), TireFixActivity.class);
                startActivity(backHome);
            }
        });

        vehicleServiceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backHome = new Intent(getActivity(), VehicleServiceActivity.class);
                startActivity(backHome);
            }
        });

        return view;
    }
}