package com.example.projetSEG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class NouveauService extends AppCompatActivity {

    private DatabaseReference data = FirebaseDatabase.getInstance().getReference();
    private DatabaseReference service = data.child("Service");

    EditText description;
    View spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nouveau_service);
    }

    public void Creation (View view) {

        description = findViewById(R.id.description);
        spinner = findViewById(R.id.spinner);

        if (description.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), "Veuillez donner une description", Toast.LENGTH_LONG).show();
        } else if (spinner.equals("")) {
            Toast.makeText(getApplicationContext(), "Veuillez choisir un role", Toast.LENGTH_LONG).show();
        } else {
            Intent intent = new Intent(NouveauService.this, Administrateur.class);
            startActivity(intent);
        }
    }
}
