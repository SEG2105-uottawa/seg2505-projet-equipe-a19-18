package com.example.projetSEG;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
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

    ListView list;
    ArrayList<String> array = new ArrayList<>();
    ArrayAdapter<String> adapter;

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
        list = findViewById(R.id.listViewService);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,array);
        list.setAdapter(adapter);
        dataService.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                String value = dataSnapshot.getValue(ServiceObject.class).toString();
                array.add(value);
                adapter.notifyDataSetChanged();
            }
            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
            }
            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
            }
            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });


    }

}
