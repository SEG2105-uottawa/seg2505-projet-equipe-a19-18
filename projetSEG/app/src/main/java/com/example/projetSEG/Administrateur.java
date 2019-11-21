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

import java.util.ArrayList;
import java.util.List;

//PAGE POUR UN ADMIN
public class Administrateur extends AppCompatActivity {

    ListView listViewUsers;
    List<User> users = new ArrayList<>();

    private DatabaseReference data = FirebaseDatabase.getInstance().getReference();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administrateur);

        listViewUsers = (ListView) findViewById(R.id.list);

        data = FirebaseDatabase.getInstance().getReference("users");

        TextView action = findViewById(R.id.action);
        Intent intent = getIntent();
        String actionName = intent.getStringExtra("nouveauService");
        action.setText(actionName);
    }

    private boolean deleteUser(String id) {
        DatabaseReference dR = FirebaseDatabase.getInstance().getReference("users").child(id);
        dR.removeValue();
        Toast.makeText(getApplicationContext(), "User Deleted", Toast.LENGTH_LONG).show();
        return true;
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
