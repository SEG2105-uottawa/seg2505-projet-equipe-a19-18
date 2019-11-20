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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Employe extends AppCompatActivity {

    DatabaseReference dataEmploye;
    HashMap<String,String> list;

    String nameOfUser;

    String key, username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employe);

        TextView title = findViewById(R.id.textViewEmploye);
        Intent intent = getIntent();
        nameOfUser = intent.getStringExtra("name");
        title.setText("Bienvenue " +nameOfUser+ "! Vous êtes connecté en tant qu'employé");


        dataEmploye = FirebaseDatabase.getInstance().getReference("Employe");
        list = new HashMap<>();
    }

    @Override
    protected void onStart() {
        super.onStart();
        dataEmploye.addValueEventListener((new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list.clear();
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    Object infoRaw = postSnapshot.getValue();
                    key = postSnapshot.getKey();
                    HashMap info = (HashMap) infoRaw;
                    username = (String) info.get("username");


                    list.put(key,username);


                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        }));
    }

    public void change(View view) {
        Button cancel = findViewById(R.id.btnCancel);
        Button accept = findViewById(R.id.btnAccept);
        Button change = findViewById(R.id.btnChange);
        EditText editAdresse = findViewById(R.id.editAdresse);
        TextView viewAdresse = findViewById(R.id.viewAdresse);
        EditText editTel = findViewById(R.id.editTel);
        TextView viewTel = findViewById(R.id.viewTel);
        EditText editNom = findViewById(R.id.editNom);
        TextView viewNom = findViewById(R.id.viewNom);
        EditText editAssurance = findViewById(R.id.editAssurance);
        TextView viewAssurance = findViewById(R.id.viewAssurance);
        EditText editPaiment = findViewById(R.id.editPaiment);
        TextView viewPaiment = findViewById(R.id.viewPaiment);


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

    public void accept(View view) {

        Button cancel = findViewById(R.id.btnCancel);
        Button accept = findViewById(R.id.btnAccept);
        Button change = findViewById(R.id.btnChange);
        EditText editAdresse = findViewById(R.id.editAdresse);
        TextView viewAdresse = findViewById(R.id.viewAdresse);
        EditText editTel = findViewById(R.id.editTel);
        TextView viewTel = findViewById(R.id.viewTel);
        EditText editNom = findViewById(R.id.editNom);
        TextView viewNom = findViewById(R.id.viewNom);
        EditText editAssurance = findViewById(R.id.editAssurance);
        TextView viewAssurance = findViewById(R.id.viewAssurance);
        EditText editPaiment = findViewById(R.id.editPaiment);
        TextView viewPaiment = findViewById(R.id.viewPaiment);

        //PHONE is a number
        Boolean isNumber;
        try {
            Double.parseDouble(editTel.getText().toString());
            isNumber = true;
        } catch(NumberFormatException e){
            isNumber = false;
        }


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


            Set set = list.entrySet();
            Iterator iterator = set.iterator();
            while(iterator.hasNext()) {
                Map.Entry entry = (Map.Entry)iterator.next();
                if (nameOfUser.equals(entry.getValue().toString())) {
                    Clinic clinic = new Clinic(adresse, tel, nom, assurance, paiment);
                    dataEmploye.child(entry.getKey().toString()).child("clinique").setValue(clinic);
                }
            }


        }
    }

    public void cancel(View view) {
        Button cancel = findViewById(R.id.btnCancel);
        Button accept = findViewById(R.id.btnAccept);
        Button change = findViewById(R.id.btnChange);
        EditText editAdresse = findViewById(R.id.editAdresse);
        TextView viewAdresse = findViewById(R.id.viewAdresse);
        EditText editTel = findViewById(R.id.editTel);
        TextView viewTel = findViewById(R.id.viewTel);
        EditText editNom = findViewById(R.id.editNom);
        TextView viewNom = findViewById(R.id.viewNom);
        EditText editAssurance = findViewById(R.id.editAssurance);
        TextView viewAssurance = findViewById(R.id.viewAssurance);
        EditText editPaiment = findViewById(R.id.editPaiment);
        TextView viewPaiment = findViewById(R.id.viewPaiment);
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
        Intent intent = new Intent(Employe.this, ClinicService.class);
        startActivity(intent);
    }
    public void heure(View view) {
        Intent intent = new Intent(Employe.this, ClinicHour.class);
        startActivity(intent);
    }
    public void shifts(View view) {
        Intent intent = new Intent(Employe.this, Shifts.class);
        startActivity(intent);
    }
}
