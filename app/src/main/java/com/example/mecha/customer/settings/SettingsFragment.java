package com.example.mecha.customer.settings;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mecha.R;
import com.example.mecha.customer.home.EmergencyFixActivity;

public class SettingsFragment extends Fragment {

    ImageButton btnEdit;
    RelativeLayout btn_changePassword;
    RelativeLayout btn_helpCenter;
    RelativeLayout btn_logout;
    View view;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_settings, container, false);

        btnEdit = view.findViewById(R.id.btn_edit);

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent moveProfileStg = new Intent(getActivity(), SettingEditProfileActivity.class);
                startActivity(moveProfileStg);
            }
        });

        btn_logout = view.findViewById(R.id.rl_logout);
        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showLogOutAlertDialog();
            }
        });

        btn_changePassword = view.findViewById(R.id.rl_changePassword);
        btn_changePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ChangePasswordCustomerActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }

    private void showLogOutAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.AlertDialogTheme);
        view = LayoutInflater.from(getActivity()).inflate(
                R.layout.layout_warning_dialog,(ConstraintLayout)view.findViewById(R.id.layoutDialogContainer)
        );
        builder.setView(view);
        ((TextView) view.findViewById(R.id.textTitle)).setText("Warning");
        ((TextView) view.findViewById(R.id.textMessage)).setText("Are you sure to log out?");
        ((Button) view.findViewById(R.id.buttonYes)).setText("Confirm");
        ((Button) view.findViewById(R.id.buttonCancel)).setText("Cancel");

        final AlertDialog alertDialog = builder.create();

        view.findViewById(R.id.buttonYes).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
                Toast.makeText(getActivity(), "Confirm", Toast.LENGTH_SHORT).show();
            }
        });

        view.findViewById(R.id.buttonCancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
                Toast.makeText(getActivity(), "Logging Out", Toast.LENGTH_SHORT).show();
            }
        });

        if (alertDialog.getWindow() != null) {
            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable());
        }
        alertDialog.show();
    }
}