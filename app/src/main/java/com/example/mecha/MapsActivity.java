package com.example.mecha;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mecha.customer.PaymentActivity;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.mecha.databinding.ActivityMapsBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;
    private boolean oke = false;
    TextView lat,lon,alamat,namaCustomer;
    Button callMechaBtn;
    FirebaseFirestore mstore;
    private FirebaseAuth mAuth;
    String userid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        lat = findViewById(R.id.latitudemap);
        lon = findViewById(R.id.longitudemap);
        alamat = findViewById(R.id.alamatMap);
        namaCustomer = findViewById(R.id.namaCustomer);
        callMechaBtn = findViewById(R.id.btnCallMecha);
        mAuth = FirebaseAuth.getInstance();
        mstore = FirebaseFirestore.getInstance();

        Geocoder geocoder = new Geocoder(this, Locale.getDefault());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{
                    Manifest.permission.ACCESS_FINE_LOCATION
            }, 100);
        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 500, 0, new LocationListener() {
            List<Address> addressList = null;
            @Override
            public void onLocationChanged(@NonNull Location location) {
                try {
                    addressList = geocoder.getFromLocation(location.getLatitude(),location.getLongitude(),1);
                    if(addressList !=null){
                        Address returnAdd = addressList.get(0);
                        StringBuilder stringBuilder = new StringBuilder(" ");
                        for (int i=0;i<returnAdd.getMaxAddressLineIndex();i++){
                            stringBuilder.append(returnAdd.getAddressLine(i)).append("\n");
                        }
                        Log.w("My location Address",stringBuilder.toString());
                    }else{
                        Log.w("My location Address","no address");
                    }
                } catch (IOException e){
                    e.printStackTrace();
                }
                if (oke) {

                    String addressLines = addressList.get(0).getAddressLine(0);
                    LatLng lokasisekarang = new LatLng(location.getLatitude(),location.getLongitude());
                    mMap.addMarker(new MarkerOptions().position(lokasisekarang).title("Lokasi Sekarang"));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(lokasisekarang));

                    lat.setText(String.valueOf(location.getLatitude()));
                    lon.setText(String.valueOf(location.getLongitude()));
                    alamat.setText(addressLines);

                    userid= mAuth.getCurrentUser().getUid();
                    DocumentReference documentReference = mstore.collection("Users").document(userid);
                    documentReference.addSnapshotListener(new EventListener<DocumentSnapshot>() {
                        @Override
                        public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException error) {
                            namaCustomer.setText(documentSnapshot.getString("Nama"));
                        }
                    });
                    String ambilNama = namaCustomer.getText().toString();

                    callMechaBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {


                            FirebaseUser user = mAuth.getCurrentUser();
                            DocumentReference df = mstore.collection("Order").document((user.getUid()));
                            Map<String,Object> userInfo = new HashMap<>();
                            userInfo.put("nama",ambilNama);
                            userInfo.put("jenisorderan","Mogok di jalan");
                            userInfo.put("harga","Rp. 50000");
                            userInfo.put("alamat",addressLines);
                            df.set(userInfo);

                            Intent paymentOrder = new Intent(MapsActivity.this, PaymentActivity.class);
                            startActivity(paymentOrder);
                        }
                    });

                }
            }
        });


    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        oke = true;

        // Add a marker in Sydney and move the camera
//        LatLng sydney = new LatLng(-34, 151);
//        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mMap.setMyLocationEnabled(true);
    }
}