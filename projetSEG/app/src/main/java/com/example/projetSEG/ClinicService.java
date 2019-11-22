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

//PAGE POUR PRESENTER LES SERVICE OFFERT DE LA CLINIQUE
public class ClinicService extends AppCompatActivity {

    String id;

    DatabaseReference dataEmploye;
    DatabaseReference data;

    ListView list;
    ArrayList<String> array = new ArrayList<>();
    ArrayAdapter<String> adapter;

    int selectedItem = -1;

    ArrayList<String> keyList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clinic_service);

        Intent intent = getIntent();
        id = intent.getStringExtra("id");

        dataEmploye = FirebaseDatabase.getInstance().getReference("Employe");


        list = findViewById(R.id.listeOffert);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,array);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedItem = position;
            }
        });


        data = dataEmploye.child(id).child("clinique").child("service");

        data.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                String value = dataSnapshot.getValue(ServiceObject.class).toString();
                array.add(value);
                adapter.notifyDataSetChanged();
                keyList.add(dataSnapshot.getKey());

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

    public void ajout(View view) {
        Intent intent = new Intent(ClinicService.this, ListeServices.class);
        intent.putExtra("id", id);
        startActivity(intent);
    }

    public void supprime(View view) {

        if (selectedItem == -1) {
            Toast.makeText(getApplicationContext(), "Choisir un service", Toast.LENGTH_LONG).show();
        } else {

            String serviceID = keyList.get(selectedItem);
            data.child(serviceID).setValue(null);
            array.remove(selectedItem);
            keyList.remove(selectedItem);

        }

    }
}
