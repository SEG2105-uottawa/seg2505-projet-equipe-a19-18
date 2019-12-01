package com.example.projetSEG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class RendezVous extends AppCompatActivity {

    DatabaseReference dataEmploye;
    String id;
    Integer numberPatient;
    int clic = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rendez_vous);

        Intent intent = getIntent();
        id = intent.getStringExtra("employe");

        dataEmploye = FirebaseDatabase.getInstance().getReference("Employe");


        dataEmploye.addValueEventListener((new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {

                    HashMap info = (HashMap) postSnapshot.getValue();
                    HashMap clinic = (HashMap) info.get("clinique");

                    if (clinic != null) {
                        if (id.equals(postSnapshot.getKey())) {
                            if (clinic.get("patients") != null) {
                                Integer number = (int) (long) clinic.get("patients");
                                numberPatient = number;
                            } else {
                                numberPatient = 0;
                            }
                        }
                    }
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        }));
    }

    public void walkin(View view) {

        if (clic == 0) {
            numberPatient++;
            dataEmploye.child(id).child("clinique").child("patients").setValue(numberPatient);
            Toast.makeText(getApplicationContext(), "Enregitré", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getApplicationContext(), "Déjà enregitré", Toast.LENGTH_LONG).show();
        }

        clic++;
    }
}
