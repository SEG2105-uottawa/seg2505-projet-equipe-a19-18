package com.example.projetSEG;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;

public class ListeClinique extends AppCompatActivity {

    DatabaseReference dataEmploye;

    ListView list;
    ArrayList<String> array = new ArrayList<>();
    ArrayAdapter<String> adapter;

    int selectedItem = -1;
    ArrayList<Clinic> clinicList = new ArrayList<>();
    ArrayList<String> keyList = new ArrayList<>();
    String clinicName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_clinique);

        dataEmploye = FirebaseDatabase.getInstance().getReference("Employe");

        list = findViewById(R.id.listClinic);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,array);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedItem = position;
            }
        });

        dataEmploye.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                HashMap info = (HashMap) dataSnapshot.getValue();
                HashMap clinic = (HashMap) info.get("clinique");

                if (clinic != null) { //evite un probleme si lemploye na pas defini de clinic
                    String clinicName = (String) clinic.get("nom");

                    String value = clinicName;

                    keyList.add(dataSnapshot.getKey());
                    array.add(value);

                }

                adapter.notifyDataSetChanged();

            }
            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                adapter.notifyDataSetChanged();
            }
            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
                adapter.notifyDataSetChanged();
            }
            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });

    }

    public void book(View view) {

    }

    public void rate(View view) {
        if (selectedItem == -1) {
            Toast.makeText(getApplicationContext(), "Choisir une clinique", Toast.LENGTH_LONG).show();
        } else {
            clinicName = keyList.get(selectedItem);


            Intent intent = new Intent(ListeClinique.this, RateClinic.class);
            intent.putExtra("clinique", clinicName);
            startActivity(intent);
        }
    }
}
