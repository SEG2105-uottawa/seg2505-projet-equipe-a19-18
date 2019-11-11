package com.example.projetSEG;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Spinner;
import android.content.Intent;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class MainActivity extends AppCompatActivity {

    private DatabaseReference dataPatient = FirebaseDatabase.getInstance().getReference("Patient");
    private DatabaseReference dataEmploye = FirebaseDatabase.getInstance().getReference("Employe");


    EditText _txtUser, _txtPass;
    Spinner _spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        _txtPass = findViewById(R.id.txtPass);
        _txtUser = findViewById(R.id.txtUser);
        _spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.usertype, R.layout.support_simple_spinner_dropdown_item);
        _spinner.setAdapter(adapter);


    }

    public void login(View view){
        if (_txtUser.getText().toString().equals("admin")&& _txtPass.getText().toString().equals("5T5ptQ")&& _spinner.getSelectedItem().toString().equals("administrateur")) {
            Intent intent = new Intent(MainActivity.this, Administrateur.class);
            startActivity(intent);
        } else {
            Toast.makeText(getApplicationContext(), "Mot de passe ou nom d'utilisateur invalide", Toast.LENGTH_LONG).show();
        }
    }

    public getUsername(){

    }

    public getPassword(){

    }

    public String getUser(){
        if(_spinner.getSelectedItem().toString().equals("administrateur")){
            final String administrateur = "administrateur";
            return administrateur;
        }
        final String patient = "patient";
        if(_spinner.getSelectedItem().toString().equals(patient)){
            return patient;
        }
        return "employe";

    }

    public void createAccount(View view) {
        Intent intent = new Intent(MainActivity.this, CreateAccount.class);
        startActivity(intent);
    }
}