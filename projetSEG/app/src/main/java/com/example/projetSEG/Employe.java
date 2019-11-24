package com.example.projetSEG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;



//PAGE POUR UN EMPLOYE
public class Employe extends AppCompatActivity {

    //USER NAME CONNECTED
    String nameOfUser;

    DatabaseReference dataEmploye;
    String key;
    String id;
    boolean hasClinicInfo = false;

    TextView viewAdresse;
    TextView viewTel;
    TextView viewNom;
    TextView viewAssurance;
    TextView viewPaiment;

    EditText editAdresse;
    EditText editTel;
    EditText editNom;
    EditText editAssurance;
    EditText editPaiment;

    Button cancel;
    Button accept;
    Button change;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employe);

        TextView title = findViewById(R.id.textViewEmploye);
        Intent intent = getIntent();
        nameOfUser = intent.getStringExtra("name");
        title.setText("Bienvenue " +nameOfUser+ "! Vous êtes connecté en tant qu'employé");

        dataEmploye = FirebaseDatabase.getInstance().getReference("Employe");

        editAdresse = findViewById(R.id.editAdresse);
        viewAdresse = findViewById(R.id.viewAdresse);
        editTel = findViewById(R.id.editTel);
        viewTel = findViewById(R.id.viewTel);
        editNom = findViewById(R.id.editNom);
        viewNom = findViewById(R.id.viewNom);
        editAssurance = findViewById(R.id.editAssurance);
        viewAssurance = findViewById(R.id.viewAssurance);
        editPaiment = findViewById(R.id.editPaiment);
        viewPaiment = findViewById(R.id.viewPaiment);

        cancel = findViewById(R.id.btnCancel);
        accept = findViewById(R.id.btnAccept);
        change = findViewById(R.id.btnChange);

    }

    //LIRE DATABASE
    @Override
    protected void onStart() {
        super.onStart();
        dataEmploye.addValueEventListener((new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    //GET INFO DATABASE

                    HashMap info = (HashMap) postSnapshot.getValue();
                    key = postSnapshot.getKey();
                    String username = (String) info.get("username");

                    //SET VIEW INFORMATION
                    HashMap clinic = (HashMap) info.get("clinique");

                    if (nameOfUser.equals(username)) {
                        id = key;
                        if (clinic != null) {
                            viewAdresse.setText(clinic.get("adresse").toString());
                            viewTel.setText(clinic.get("telephone").toString());
                            viewNom.setText(clinic.get("nom").toString());
                            viewAssurance.setText(clinic.get("assurance").toString());
                            viewPaiment.setText(clinic.get("paiment").toString());
                            hasClinicInfo = true;
                        }

                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        }));


    }

    //METHODE POUR APPLIQUER LA POSSIBILITE DE MODIFIER LES INFORMATIONS DE LA CLINIQUE
    public void change(View view) {

        cancel.setVisibility(View.VISIBLE);
        accept.setVisibility(View.VISIBLE);
        change.setVisibility(View.GONE);

        String adresse = viewAdresse.getText().toString();
        editAdresse.setText(adresse);
        editAdresse.setVisibility(View.VISIBLE);
        viewAdresse.setVisibility(View.GONE);

        String tel = viewTel.getText().toString();
        editTel.setText(tel);
        editTel.setVisibility(View.VISIBLE);
        viewTel.setVisibility(View.GONE);

        String nom = viewNom.getText().toString();
        editNom.setText(nom);
        editNom.setVisibility(View.VISIBLE);
        viewNom.setVisibility(View.GONE);

        String assurance = viewAssurance.getText().toString();
        editAssurance.setText(assurance);
        editAssurance.setVisibility(View.VISIBLE);
        viewAssurance.setVisibility(View.GONE);

        String paiment = viewPaiment.getText().toString();
        editPaiment.setText(paiment);
        editPaiment.setVisibility(View.VISIBLE);
        viewPaiment.setVisibility(View.GONE);
    }

    //METHODE POUR ACCEPTER LE CHANGEMENT DINFORMATION DE LA CLINIQUE
    public void accept(View view) {

        //PHONE is a number
        Boolean isNumber;
        try {
            Double.parseDouble(editTel.getText().toString());
            isNumber = true;
        } catch(NumberFormatException e){
            isNumber = false;
        }
        //INPUT VERIFICATION
        if (editAdresse.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), "Entrez une adresse", Toast.LENGTH_LONG).show();
        } else if (editTel.getText().toString().equals("") || !isNumber) {
            Toast.makeText(getApplicationContext(), "Entrez un téléphone valide", Toast.LENGTH_LONG).show();
        } else if (editNom.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), "Entrez un nom de clinique", Toast.LENGTH_LONG).show();
        }else if (editAssurance.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), "Entrez un type d'assurance", Toast.LENGTH_LONG).show();
        }else if (editPaiment.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), "Entrez une méthode de paiment", Toast.LENGTH_LONG).show();
        }else {
        //IS ACCEPTED
            cancel.setVisibility(View.GONE);
            accept.setVisibility(View.GONE);
            change.setVisibility(View.VISIBLE);

            String adresse = editAdresse.getText().toString();
            viewAdresse.setText(adresse);
            editAdresse.setVisibility(View.GONE);
            viewAdresse.setVisibility(View.VISIBLE);

            String tel = editTel.getText().toString();
            viewTel.setText(tel);
            editTel.setVisibility(View.GONE);
            viewTel.setVisibility(View.VISIBLE);

            String nom = editNom.getText().toString();
            viewNom.setText(nom);
            editNom.setVisibility(View.GONE);
            viewNom.setVisibility(View.VISIBLE);

            String assurance = editAssurance.getText().toString();
            viewAssurance.setText(assurance);
            editAssurance.setVisibility(View.GONE);
            viewAssurance.setVisibility(View.VISIBLE);

            String paiment = editPaiment.getText().toString();
            viewPaiment.setText(paiment);
            editPaiment.setVisibility(View.GONE);
            viewPaiment.setVisibility(View.VISIBLE);

            //UPDATE FIREBASE

            Clinic clinic = new Clinic(adresse, tel, nom, assurance, paiment);
            dataEmploye.child(id).child("clinique").setValue(clinic);

        }
    }

    //METHOD TO GO BACK
    public void cancel(View view) {

        cancel.setVisibility(View.GONE);
        accept.setVisibility(View.GONE);
        change.setVisibility(View.VISIBLE);
        editAdresse.setVisibility(View.GONE);
        viewAdresse.setVisibility(View.VISIBLE);
        editTel.setVisibility(View.GONE);
        viewTel.setVisibility(View.VISIBLE);
        editNom.setVisibility(View.GONE);
        viewNom.setVisibility(View.VISIBLE);
        editAssurance.setVisibility(View.GONE);
        viewAssurance.setVisibility(View.VISIBLE);
        editPaiment.setVisibility(View.GONE);
        viewPaiment.setVisibility(View.VISIBLE);

    }

    public void service(View view) {

        if (!hasClinicInfo) {
            Toast.makeText(getApplicationContext(), "Entrez les informations des la clinique AVANT", Toast.LENGTH_LONG).show();
        } else {
            Intent intent = new Intent(Employe.this, ClinicService.class);
            intent.putExtra("id", id);
            startActivity(intent);
        }

    }
    public void heure(View view) {
        if (!hasClinicInfo) {
            Toast.makeText(getApplicationContext(), "Entrez les informations des la clinique AVANT", Toast.LENGTH_LONG).show();
        } else {
            Intent intent = new Intent(Employe.this, ClinicHour.class);
            intent.putExtra("id", id);
            startActivity(intent);
        }
    }
    public void shifts(View view) {
        if (!hasClinicInfo) {
            Toast.makeText(getApplicationContext(), "Entrez les informations des la clinique AVANT", Toast.LENGTH_LONG).show();
        } else {
            Intent intent = new Intent(Employe.this, Shifts.class);
            intent.putExtra("id", id);
            startActivity(intent);
        }

    }
}
