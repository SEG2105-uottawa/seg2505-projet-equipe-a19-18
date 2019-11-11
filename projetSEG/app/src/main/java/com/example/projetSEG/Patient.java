package com.example.projetSEG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;


public class Patient extends MainActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient);

        TextView title = findViewById(R.id.textViewPatient);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        title.setText("Bienvenue " +name+ "! Vous êtes connecté en tant que patient");

    }
}
