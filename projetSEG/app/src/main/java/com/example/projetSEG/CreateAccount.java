package com.example.projetSEG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;


public class CreateAccount extends AppCompatActivity {

    EditText Mdp, Mdp2 , txtUser;


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
        } else if(Mdp2.getText().toString().equals(Mdp.getText().toString())&&!txtUser.getText().toString().equals(null)&&txtUser.getText().toString().equals(" ")&&!Mdp.getText().toString().equals(null)){
            Intent intent = new Intent(CreateAccount.this, Patient.class);
            /*verifier si le employe a un id*/
            /*a rentrer pour verifier qu'il a le droit de faire les changements par la suite}*/
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
        } else if(!(txtUser.getText().toString()==null)&&!(Mdp.getText().toString()==(null))){
            Intent intent = new Intent(CreateAccount.this, Employe.class);
            /*verifier si le employe a un id*/
            /*a rentrer pour verifier qu'il a le droit de faire les changements par la suite}*/
            startActivity(intent);
        } else{
            Toast.makeText(getApplicationContext(), "Entrez un mot de passe et un nom d'utilisateur.", Toast.LENGTH_LONG).show();
        }
    }
}
