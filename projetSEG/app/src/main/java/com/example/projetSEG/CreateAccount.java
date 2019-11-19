package com.example.projetSEG;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class CreateAccount extends AppCompatActivity {

    EditText Mdp, Mdp2 , txtUser, prenom, nom, courriel;
    private DatabaseReference data = FirebaseDatabase.getInstance().getReference();
    private DatabaseReference patient = data.child("Patient");
    private DatabaseReference employe = data.child("Employe");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

    }
    public void createAccountPatient(View view) {

        Mdp = findViewById(R.id.txtMdp);
        Mdp2 = findViewById(R.id.txtMdp2);
        txtUser = findViewById(R.id.txtUser);
        prenom = findViewById(R.id.txtPrenom);
        nom = findViewById(R.id.txtNom);
        courriel = findViewById(R.id.txtEmail);

        if (!Mdp2.getText().toString().equals(Mdp.getText().toString())) {
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

    public void createAccountEmploye(View view) {

        Mdp = findViewById(R.id.txtMdp);
        Mdp2 = findViewById(R.id.txtMdp2);
        txtUser = findViewById(R.id.txtUser);
        prenom = findViewById(R.id.txtPrenom);
        nom = findViewById(R.id.txtNom);
        courriel = findViewById(R.id.txtEmail);

        if (!Mdp2.getText().toString().equals(Mdp.getText().toString())) {
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
}
