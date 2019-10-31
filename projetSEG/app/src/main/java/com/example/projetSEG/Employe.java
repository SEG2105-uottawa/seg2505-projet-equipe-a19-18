package com.example.projetSEG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Employe extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employe);

        TextView title = findViewById(R.id.textViewEmploye);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        title.setText("Bienvenue " +name+ "! Vous êtes connecté en tant qu'employé");
    }
}
