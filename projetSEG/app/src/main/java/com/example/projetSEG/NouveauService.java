package com.example.projetSEG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class NouveauService<adapter2> extends AppCompatActivity {

    private DatabaseReference data = FirebaseDatabase.getInstance().getReference();
    private DatabaseReference service = data.child("Service");

    EditText description;
    Spinner spinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nouveau_service);

        spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.role, R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adapter2);
        description = findViewById(R.id.description);
    }

    public void Creation (View view) {



        if (description.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), "Veuillez donner une description", Toast.LENGTH_LONG).show();
        } else if (spinner.getSelectedItem().toString().equals("")) {
            Toast.makeText(getApplicationContext(), "Veuillez choisir un role", Toast.LENGTH_LONG).show();
        } else {

            ServiceObject newService = new ServiceObject(description.getText().toString(), spinner.getSelectedItem().toString());
            service.push().setValue(newService);

            Intent intent = new Intent(NouveauService.this, Administrateur.class);
            intent.putExtra("nouveauService", "Le service à bien été créé");
            startActivity(intent);
        }
    }
}
