package com.example.projetSEG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ListeServices extends AppCompatActivity {

    Button modifier, supprimer, ajouter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_services);

        modifier = findViewById(R.id.btnModifier);
        supprimer = findViewById(R.id.btnSupprimer);
        ajouter = findViewById(R.id.btnAjouter);


        Intent intent = getIntent();
        String fromEmploye = intent.getStringExtra("fromEmploye");

        if(fromEmploye == null) {
            modifier.setVisibility(View.VISIBLE);
            supprimer.setVisibility(View.VISIBLE);
            ajouter.setVisibility(View.GONE);
        } else if (fromEmploye.equals("true")) {
            modifier.setVisibility(View.GONE);
            supprimer.setVisibility(View.GONE);
            ajouter.setVisibility(View.VISIBLE);
        }




    }
}
