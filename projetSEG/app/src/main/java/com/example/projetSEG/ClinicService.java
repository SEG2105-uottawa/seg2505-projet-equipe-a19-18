package com.example.projetSEG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ClinicService extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clinic_service);
    }

    public void ajout(View view) {
        Intent intent = new Intent(ClinicService.this, ListeServices.class);
        intent.putExtra("fromEmploye", "true");
        startActivity(intent);
    }
}
