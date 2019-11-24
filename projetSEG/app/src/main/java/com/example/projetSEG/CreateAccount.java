package com.example.projetSEG;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

//PAGE POUR CREER UN NOUVEAU COMPTE
public class CreateAccount extends AppCompatActivity {

    //INFORMATION POUR USER
    EditText Mdp, Mdp2 , txtUser, prenom, nom, courriel;

    String username;

    //FIREBASE
    private DatabaseReference data = FirebaseDatabase.getInstance().getReference();
    private DatabaseReference patient = data.child("Patient");
    private DatabaseReference employe = data.child("Employe");
    ArrayList<String> usernameList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        Mdp = findViewById(R.id.txtMdp);
        Mdp2 = findViewById(R.id.txtMdp2);
        txtUser = findViewById(R.id.txtUser);
        prenom = findViewById(R.id.txtPrenom);
        nom = findViewById(R.id.txtNom);
        courriel = findViewById(R.id.txtEmail);

        usernameList = new ArrayList<>();

    }

    //LIRE FIREBASE POUR AVOIR LA LISTE DE PATIENT ET D EMPLOYE
    @Override
    protected void onStart() {
        super.onStart();
        patient.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {

                    HashMap info = (HashMap) postSnapshot.getValue();
                    username = (String) info.get("username");
                    usernameList.add(username);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });

        employe.addValueEventListener((new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {

                    HashMap info = (HashMap) postSnapshot.getValue();
                    username = (String) info.get("username");
                    usernameList.add(username);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        }));
    }

    //CREER NOUVEAU ACCOUNT PATIENT FIREBASE
    public void createAccountPatient(View view) {

        if (usedUsername(txtUser.getText().toString())) {
            Toast.makeText(getApplicationContext(), "Utilisateur déjà utilisé", Toast.LENGTH_LONG).show();
        } else if (!Mdp2.getText().toString().equals(Mdp.getText().toString())) {
            Toast.makeText(getApplicationContext(), "Mot de passe différent.", Toast.LENGTH_LONG).show();
        } else if(!(txtUser.getText().toString().equals(""))&&!(Mdp.getText().toString().equals(""))){

            User user = new User(txtUser.getText().toString(), Mdp.getText().toString(),
                    nom.getText().toString(), prenom.getText().toString(), courriel.getText().toString());
            patient.push().setValue(user);

            Intent intent = new Intent(CreateAccount.this, Patient.class);
            intent.putExtra("name", txtUser.getText().toString());
            startActivity(intent);
        } else{
            Toast.makeText(getApplicationContext(), "Entrez un mot de passe et un nom d'utilisateur.", Toast.LENGTH_LONG).show();
        }
    }

    //CREER NOUVEAU ACCOUNT EMPLOYE FIREBASE
    public void createAccountEmploye(View view) {

        if (usedUsername(txtUser.getText().toString())) {
            Toast.makeText(getApplicationContext(), "Utilisateur déjà utilisé", Toast.LENGTH_LONG).show();
        } else if (!Mdp2.getText().toString().equals(Mdp.getText().toString())) {
            Toast.makeText(getApplicationContext(), "Mot de passe différent.", Toast.LENGTH_LONG).show();
        } else if(!(txtUser.getText().toString().equals(""))&&!(Mdp.getText().toString().equals(""))){

            User user = new User(txtUser.getText().toString(), Mdp.getText().toString(),
                    nom.getText().toString(), prenom.getText().toString(), courriel.getText().toString());
            employe.push().setValue(user);

            Intent intent = new Intent(CreateAccount.this, Employe.class);
            intent.putExtra("name", txtUser.getText().toString());
            startActivity(intent);
        } else{
            Toast.makeText(getApplicationContext(), "Entrez un mot de passe et un nom d'utilisateur.", Toast.LENGTH_LONG).show();
        }
    }

    private boolean usedUsername (String username) {

        boolean used = false;
        for (int i = 0; i < usernameList.size(); i++) {
            if (username.equals(usernameList.get(i))) {
                used = true;
            }
        }
        return used;
    }
}
