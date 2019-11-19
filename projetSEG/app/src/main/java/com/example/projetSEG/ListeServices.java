package com.example.projetSEG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ListeServices extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_services);

        Button modifier = findViewById(R.id.btnModifier);
        Button supprimer = findViewById(R.id.btnSupprimer);
        Button ajouter = findViewById(R.id.btnAjouter);
        Intent intent = getIntent();
        String fromEmploye = intent.getStringExtra("fromEmploye");
        if(fromEmploye == "true") {
            modifier.setVisibility(View.GONE);
            supprimer.setVisibility(View.GONE);
            ajouter.setVisibility(View.VISIBLE);
        }
    }
}
