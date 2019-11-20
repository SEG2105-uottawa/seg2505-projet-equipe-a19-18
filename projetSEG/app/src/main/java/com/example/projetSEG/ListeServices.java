package com.example.projetSEG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

public class ListeServices extends AppCompatActivity {

    Button modifier, supprimer, ajouter;

    DatabaseReference dataService;
    ArrayList<ServiceObject> serviceList;

    String id, service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_services);

        modifier = findViewById(R.id.btnModifier);
        supprimer = findViewById(R.id.btnSupprimer);
        ajouter = findViewById(R.id.btnAjouter);

        Intent intent = getIntent();
        String fromEmploye = intent.getStringExtra("fromEmploye");

        if(fromEmploye == null) {
            modifier.setVisibility(View.VISIBLE);
            supprimer.setVisibility(View.VISIBLE);
            ajouter.setVisibility(View.GONE);
        } else if (fromEmploye.equals("true")) {
            modifier.setVisibility(View.GONE);
            supprimer.setVisibility(View.GONE);
            ajouter.setVisibility(View.VISIBLE);
        }


        dataService = FirebaseDatabase.getInstance().getReference("Service");
        serviceList = new ArrayList<>();

    }

    @Override
    protected void onStart() {
        super.onStart();

        dataService.addValueEventListener((new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                serviceList.clear();
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    Object infoRaw = postSnapshot.getValue();
                    HashMap info = (HashMap) infoRaw;

                    id = (String) info.get("id");
                    service = (String) info.get("service");

                    ServiceObject serviceObject = new ServiceObject(id, service);
                    serviceList.add(serviceObject);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        }));
    }
}
