package com.example.projetSEG;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

//PAGE POUR AFFICHER LES HEURES DE TRAVAIL DE L EMPLOYE
public class Shifts extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shifts);
    }

    public void change(View view) {
        Button cancel = findViewById(R.id.btnCancel1);
        Button accept = findViewById(R.id.btnAccept1);
        Button change = findViewById(R.id.btnChange1);

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

    //METHODE POUR ACCEPTER LE CHANGEMENT DINFORMATION DE LA CLINIQUE
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



    }

    //METHOD TO GO BACK
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
}
