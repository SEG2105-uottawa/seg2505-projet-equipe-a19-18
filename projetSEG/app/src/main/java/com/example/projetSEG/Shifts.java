package com.example.projetSEG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;


//PAGE POUR AFFICHER LES HEURES DE TRAVAIL DE L EMPLOYE
public class Shifts extends AppCompatActivity {

    DatabaseReference dataEmploye;
    String key;
    String id;

    TextView viewLundi;
    TextView viewMardi;
    TextView viewMercredi;
    TextView viewJeudi;
    TextView viewVendredi;

    EditText editLundi;
    EditText editMardi;
    EditText editMercredi;
    EditText editJeudi;
    EditText editVendredi;

    Button cancel;
    Button accept;
    Button change;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shifts);

        Intent intent = getIntent();
        id = intent.getStringExtra("id");

        dataEmploye = FirebaseDatabase.getInstance().getReference("Employe");

        viewLundi = findViewById(R.id.viewLundi);
        viewMardi = findViewById(R.id.viewMardi);
        viewMercredi = findViewById(R.id.viewMercredi);
        viewJeudi = findViewById(R.id.viewJeudi);
        viewVendredi = findViewById(R.id.viewVendredi);

        editLundi = findViewById(R.id.editLundi);
        editMardi = findViewById(R.id.editMardi);
        editMercredi = findViewById(R.id.editMercredi);
        editJeudi = findViewById(R.id.editJeudi);
        editVendredi = findViewById(R.id.editVendredi);

        cancel = findViewById(R.id.btnCancel1);
        accept = findViewById(R.id.btnAccept1);
        change = findViewById(R.id.btnChange1);

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

                    //SET VIEW INFORMATION
                    HashMap mesHeures = (HashMap) info.get("mesHeures");
                    if (id.equals(key) && mesHeures != null) {
                        viewLundi.setText(mesHeures.get("lundi").toString());
                        viewMardi.setText(mesHeures.get("mardi").toString());
                        viewMercredi.setText(mesHeures.get("mercredi").toString());
                        viewJeudi.setText(mesHeures.get("jeudi").toString());
                        viewVendredi.setText(mesHeures.get("vendredi").toString());

                    }

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        }));


    }

    public void change(View view) {

        cancel.setVisibility(View.VISIBLE);
        accept.setVisibility(View.VISIBLE);
        change.setVisibility(View.GONE);

        String Lundi = viewLundi.getText().toString();
        editLundi.setText(Lundi);
        editLundi.setVisibility(View.VISIBLE);
        viewLundi.setVisibility(View.GONE);

        String Mardi = viewMardi.getText().toString();
        editMardi.setText(Mardi);
        editMardi.setVisibility(View.VISIBLE);
        viewMardi.setVisibility(View.GONE);

        String Mercredi = viewMercredi.getText().toString();
        editMercredi.setText(Mercredi);
        editMercredi.setVisibility(View.VISIBLE);
        viewMercredi.setVisibility(View.GONE);

        String Jeudi = viewJeudi.getText().toString();
        editJeudi.setText(Jeudi);
        editJeudi.setVisibility(View.VISIBLE);
        viewJeudi.setVisibility(View.GONE);

        String Vendredi = viewVendredi.getText().toString();
        editVendredi.setText(Vendredi);
        editVendredi.setVisibility(View.VISIBLE);
        viewVendredi.setVisibility(View.GONE);

    }

    //METHODE POUR ACCEPTER LE CHANGEMENT
    public void accept(View view) {

        cancel.setVisibility(View.GONE);
        accept.setVisibility(View.GONE);
        change.setVisibility(View.VISIBLE);

        String Lundi = editLundi.getText().toString();
        viewLundi.setText(Lundi);
        editLundi.setVisibility(View.GONE);
        viewLundi.setVisibility(View.VISIBLE);

        String Mardi = editMardi.getText().toString();
        viewMardi.setText(Mardi);
        editMardi.setVisibility(View.GONE);
        viewMardi.setVisibility(View.VISIBLE);

        String Mercredi = editMercredi.getText().toString();
        viewMercredi.setText(Mercredi);
        editMercredi.setVisibility(View.GONE);
        viewMercredi.setVisibility(View.VISIBLE);

        String Jeudi = editJeudi.getText().toString();
        viewJeudi.setText(Jeudi);
        editJeudi.setVisibility(View.GONE);
        viewJeudi.setVisibility(View.VISIBLE);

        String Vendredi = editVendredi.getText().toString();
        viewVendredi.setText(Vendredi);
        editVendredi.setVisibility(View.GONE);
        viewVendredi.setVisibility(View.VISIBLE);


        //UPDATE FIREBASE
        ShiftsObject mesHeures = new ShiftsObject(Lundi, Mardi, Mercredi, Jeudi, Vendredi);
        dataEmploye.child(id).child("mesHeures").setValue(mesHeures);

    }

    //METHOD TO GO BACK
    public void cancel(View view) {

        cancel.setVisibility(View.GONE);
        accept.setVisibility(View.GONE);
        change.setVisibility(View.VISIBLE);
        editLundi.setVisibility(View.GONE);
        viewLundi.setVisibility(View.VISIBLE);
        editMardi.setVisibility(View.GONE);
        viewMardi.setVisibility(View.VISIBLE);
        editMercredi.setVisibility(View.GONE);
        viewMercredi.setVisibility(View.VISIBLE);
        editJeudi.setVisibility(View.GONE);
        viewJeudi.setVisibility(View.VISIBLE);
        editVendredi.setVisibility(View.GONE);
        viewVendredi.setVisibility(View.VISIBLE);

    }
}
