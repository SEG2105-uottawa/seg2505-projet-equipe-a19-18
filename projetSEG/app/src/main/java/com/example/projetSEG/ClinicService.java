package com.example.projetSEG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

//PAGE POUR PRESENTER LES SERVICE OFFERT DE LA CLINIQUE
public class ClinicService extends AppCompatActivity {

    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clinic_service);

        Intent intent = getIntent();
        id = intent.getStringExtra("id");



    }

    public void ajout(View view) {
        Intent intent = new Intent(ClinicService.this, ListeServices.class);
        Bundle extras = new Bundle();
        extras.putString("fromEmploye", "true");
        extras.putString("id",id);
        intent.putExtras(extras);
        startActivity(intent);
    }
}
