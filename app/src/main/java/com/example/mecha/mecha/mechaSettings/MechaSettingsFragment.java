package com.example.mecha.mecha.mechaSettings;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mecha.R;
import com.example.mecha.authui.LoginActivity;
import com.example.mecha.customer.settings.ChangePasswordCustomerActivity;
import com.example.mecha.customer.settings.SettingEditProfileActivity;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

public class MechaSettingsFragment extends Fragment {

    ImageButton btnEdit;
    RelativeLayout btn_changePassword;
    RelativeLayout btn_helpCenter;
    RelativeLayout btn_logout;
    View view;
    private FirebaseAuth mAuth;
    private FirebaseFirestore mstore;
    private StorageReference storageReference;
    ImageView profilePicture;
    TextView tv_username, tv_email;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_mecha_settings, container, false);
        mAuth = FirebaseAuth.getInstance();

        mstore = FirebaseFirestore.getInstance();
        storageReference = FirebaseStorage.getInstance().getReference();




            if (mAuth.getCurrentUser() != null) {
                StorageReference profileRef = storageReference.child("Users/" + mAuth.getCurrentUser().getUid() + "/profile.jpg");
                profileRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        Picasso.get().load(uri).into(profilePicture);
                    }
                });

            }
            tv_username = view.findViewById(R.id.tv_username);
            tv_email = view.findViewById(R.id.tv_email);
            if (mAuth.getCurrentUser() != null) {
                String userid = mAuth.getCurrentUser().getUid();
                DocumentReference documentReference = mstore.collection("Users").document(userid);
                documentReference.addSnapshotListener(new EventListener<DocumentSnapshot>() {
                    @Override
                    public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException error) {
                        tv_username.setText(documentSnapshot.getString("Nama"));
                        tv_email.setText(documentSnapshot.getString("Email"));

                    }
                });
            }
            btnEdit = view.findViewById(R.id.btn_edit);
            btnEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent moveProfileStg = new Intent(getActivity(), SettingEditMechaProfileActivity.class);
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
                    Intent intent = new Intent(getActivity(), ChangePasswordMechaActivity.class);
                    startActivity(intent);
                }
            });

            profilePicture = view.findViewById(R.id.profilePicture);
            profilePicture.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mAuth.getCurrentUser() != null) {

                        Intent openGalleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                        startActivityForResult(openGalleryIntent, 1000);
                    }
                }
            });
            return view;
        }

        private void showLogOutAlertDialog () {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.AlertDialogTheme);
            view = LayoutInflater.from(getActivity()).inflate(
                    R.layout.layout_warning_dialog, (ConstraintLayout) view.findViewById(R.id.layoutDialogContainer)
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
                    mAuth.signOut();
                    alertDialog.dismiss();

                    Toast.makeText(getActivity(), "Logging Out", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getActivity(), LoginActivity.class));
                    getActivity().finish();
                }
            });

            view.findViewById(R.id.buttonCancel).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    alertDialog.dismiss();

//                Toast.makeText(getActivity(), "Canceling", Toast.LENGTH_SHORT).show();
                }
            });

            if (alertDialog.getWindow() != null) {
                alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable());
            }
            alertDialog.show();
        }

    }

