package com.example.projetSEG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Employe extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employe);

        TextView title = findViewById(R.id.textViewEmploye);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        title.setText("Bienvenue " +name+ "! Vous êtes connecté en tant qu'employé");
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

        editAdresse.setVisibility(View.VISIBLE);
        viewAdresse.setVisibility(View.GONE);

        editTel.setVisibility(View.VISIBLE);
        viewTel.setVisibility(View.GONE);

        editNom.setVisibility(View.VISIBLE);
        viewNom.setVisibility(View.GONE);

        editAssurance.setVisibility(View.VISIBLE);
        viewAssurance.setVisibility(View.GONE);

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
