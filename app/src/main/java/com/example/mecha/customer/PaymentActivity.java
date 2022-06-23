package com.example.mecha.customer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.mecha.R;
import com.example.mecha.customer.home.EmergencyFixActivity;

public class PaymentActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    RadioGroup rgPayment;
    RadioButton dana, bca, bri, mandiri, cod;
    Button confirmBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        rgPayment = (RadioGroup)findViewById(R.id.rgPayment);
        dana = (RadioButton)findViewById(R.id.rbDana);
        bca = (RadioButton)findViewById(R.id.rbBCA);
        bri = (RadioButton)findViewById(R.id.rbBRI);
        mandiri = (RadioButton)findViewById(R.id.rbMandiri);
        cod = (RadioButton)findViewById(R.id.rbCOD);
        confirmBtn = (Button)findViewById(R.id.btnConfirmPayment);

        rgPayment.setOnCheckedChangeListener(this);

        confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validate()) {
                    Intent backHome = new Intent(PaymentActivity.this, CustomerMenuActivity.class);
                    startActivity(backHome);
                }
            }
        });
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        if (i == R.id.rbDana) {
            Toast.makeText(this, "Metode pembayaran Dana", Toast.LENGTH_SHORT).show();
        }
        if (i == R.id.rbBCA) {
            Toast.makeText(this, "Metode pembayaran Bank BCA", Toast.LENGTH_SHORT).show();
        }
        if (i == R.id.rbBRI) {
            Toast.makeText(this, "Metode pembayaran Bank BRI", Toast.LENGTH_SHORT).show();
        }
        if (i == R.id.rbMandiri) {
            Toast.makeText(this, "Metode pembayaran Bank Mandiri", Toast.LENGTH_SHORT).show();
        }
        if (i == R.id.rbCOD) {
            Toast.makeText(this, "Metode pembayaran Cash On Delivery", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean validate() {
        if (!dana.isChecked() && !bca.isChecked() && !bri.isChecked() && !mandiri.isChecked() && !cod.isChecked()) {
            Toast.makeText(this, "Pilih metode pembayaran lebih dulu", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}