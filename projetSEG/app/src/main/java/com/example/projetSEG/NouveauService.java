package com.example.projetSEG;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

//PAGE POUR CREER UN NOUVEAU SERVICE (ADMIN)
public class NouveauService extends AppCompatActivity {

    private DatabaseReference data = FirebaseDatabase.getInstance().getReference();
    private DatabaseReference service = data.child("Service");

    EditText description;
    Spinner spinner;
    String serviceID;

    Button creer, cancel, accept;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nouveau_service);

        spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.role, R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adapter2);
        description = findViewById(R.id.description);

        creer = findViewById(R.id.buttonCreerService);
        cancel = findViewById(R.id.btnCancelChange);
        accept = findViewById(R.id.btnAcceptChange);

        Intent intent = getIntent();
        serviceID = intent.getStringExtra("service");

        //DISTINCTION ENTRE creeer ET modifier
        if (serviceID == null) {

            accept.setVisibility(View.GONE);
            cancel.setVisibility(View.GONE);
            creer.setVisibility(View.VISIBLE);

        } else {
            accept.setVisibility(View.VISIBLE);
            cancel.setVisibility(View.VISIBLE);
            creer.setVisibility(View.GONE);
        }

    }

    //CREER SERVICE FIREBASE
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
