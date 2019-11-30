package com.example.projetSEG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

//PAGE POUR UN EMPLOYE
public class Patient extends MainActivity {

    EditText rAdresse, rHeure, rService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient);

        TextView title = findViewById(R.id.textViewPatient);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        title.setText("Bienvenue " +name+ "! Vous êtes connecté en tant que patient");

        rAdresse = findViewById(R.id.rAdresse);
        rHeure = findViewById(R.id.rHeure);
        rService = findViewById(R.id.rService);

    }

    public void recherche(View view) {

        Intent intent = new Intent(Patient.this, ListeClinique.class);

        String adresse = rAdresse.getText().toString();
        String heure = rHeure.getText().toString();
        String service = rService.getText().toString();

        int nombreDeCritere = 0;
        if (!adresse.equals("")) {
            nombreDeCritere++;
            intent.putExtra("adresse", adresse);
        }
        if (!heure.equals("")) {
            nombreDeCritere++;
            intent.putExtra("heure", heure);
        }
        if (!service.equals("")) {
            nombreDeCritere++;
            intent.putExtra("service", service);
        }

        if (nombreDeCritere > 1) {
            Toast.makeText(getApplicationContext(), "Choisir au maximum un critère", Toast.LENGTH_LONG).show();
        } else {
            startActivity(intent);
        }

    }
}
