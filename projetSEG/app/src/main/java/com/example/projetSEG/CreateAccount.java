package com.example.projetSEG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class CreateAccount extends AppCompatActivity {

    EditText Mdp2, Mdp;
    Button btnCreerEmploye, btnCreerPatient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
    }
    public void createAccountPatient(View view) {

        Mdp = (EditText) findViewById(R.id.txtMdp);
        Mdp2 = (EditText) findViewById(R.id.txtMdp2);
        if (Mdp2.getText().toString().equals(Mdp.getText().toString())) {
            Intent intent = new Intent(CreateAccount.this, Patient.class);
            /*verifier si le employe a un id*/
            /*a rentrer pour verifier qu'il a le droit de faire les changements par la suite}*/
            startActivity(intent);
        }
    }

    public void createAccountEmploye(View view) {

        Mdp = (EditText) findViewById(R.id.txtMdp);
        Mdp2 = (EditText) findViewById(R.id.txtMdp2);
        if (Mdp2.getText().toString().equals(Mdp.getText().toString())/*verifier le employe id au besoin ici}*/) {
            Intent intent = new Intent(CreateAccount.this, Employe.class);
            /*verifier si le employe a un id*/
            /*a rentrer pour verifier qu'il a le droit de faire les changements par la suite}*/
            startActivity(intent);
        }
        else {
            Toast.makeText(getApplicationContext(), "Mot de passe différent", Toast.LENGTH_LONG).show();
        }
    }
}
