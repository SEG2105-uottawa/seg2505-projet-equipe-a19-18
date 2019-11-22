package com.example.projetSEG;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;



//PAGE POUR UN ADMIN
public class Administrateur extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administrateur);


        TextView action = findViewById(R.id.action);
        Intent intent = getIntent();
        //POUR VOIR SI LE NOUVEAU SERVICE A BIEN ETE CREE
        String actionName = intent.getStringExtra("nouveauService");
        action.setText(actionName);
    }



    public void nouveauService(View view){
        Intent intent = new Intent(Administrateur.this, NouveauService.class);
        startActivity(intent);
    }
    public void listeServices(View view){
        Intent intent = new Intent(Administrateur.this, ListeServices.class);
        startActivity(intent);
    }
    public void supprimerCompte(View view) {
        Intent intent = new Intent(Administrateur.this, SupprimerCompte.class);
        startActivity(intent);
    }
}
