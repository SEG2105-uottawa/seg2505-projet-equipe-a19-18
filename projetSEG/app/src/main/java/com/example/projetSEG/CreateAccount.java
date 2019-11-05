package com.example.projetSEG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class CreateAccount extends AppCompatActivity {

    EditText Mdp, Mdp2 , txtUser;
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

        if (!Mdp2.getText().toString().equals(Mdp.getText().toString())) {
            Toast.makeText(getApplicationContext(), "Mot de passe différent.", Toast.LENGTH_LONG).show();
        } else if(!(txtUser.getText().toString().equals(""))&&!(Mdp.getText().toString().equals(""))){

            User user = new User(txtUser.getText().toString(), Mdp.getText().toString());
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

        if (!Mdp2.getText().toString().equals(Mdp.getText().toString())) {
            Toast.makeText(getApplicationContext(), "Mot de passe différent.", Toast.LENGTH_LONG).show();
        } else if(!(txtUser.getText().toString().equals("")&&!(Mdp.getText().toString().equals("")))){

            User user = new User(txtUser.getText().toString(), Mdp.getText().toString());
            employe.push().setValue(user);

            Intent intent = new Intent(CreateAccount.this, Employe.class);
            intent.putExtra("name", txtUser.getText().toString());
            startActivity(intent);

        } else{
            Toast.makeText(getApplicationContext(), "Entrez un mot de passe et un nom d'utilisateur.", Toast.LENGTH_LONG).show();
        }
    }
}
