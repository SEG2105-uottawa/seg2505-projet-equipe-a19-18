package com.example.projetSEG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Administrateur extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administrateur);
    }

    public void NouveauService(View view){
        Intent intent = new Intent(Administrateur.this, NouveauService.class);
        startActivity(intent);
    }
    public void ListeServices(View view){
        Intent intent = new Intent(Administrateur.this, ListeServices.class);
        startActivity(intent);
    }
    public void SupprimerCompte(View view) {
        Intent intent = new Intent(Administrateur.this, SupprimerCompte.class);
        startActivity(intent);
    }
}
