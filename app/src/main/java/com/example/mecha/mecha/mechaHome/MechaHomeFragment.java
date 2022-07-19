package com.example.mecha.mecha.mechaHome;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mecha.R;
import com.example.mecha.mecha.AcceptingServicesActivity;


public class MechaHomeFragment extends Fragment {
    CardView incomingService,acceptingService;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_mecha_home, container, false);

        incomingService = view.findViewById(R.id.incoming_service);
        acceptingService = view.findViewById(R.id.accepting_service);

        acceptingService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent accepting = new Intent(getActivity(), AcceptingServicesActivity.class);
                startActivity(accepting);
            }
        });
        return view;
    }
}