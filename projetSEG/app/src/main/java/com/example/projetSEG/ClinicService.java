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

import java.util.ArrayList;
import java.util.HashMap;

//PAGE POUR PRESENTER LES SERVICE OFFERT DE LA CLINIQUE
public class ClinicService extends AppCompatActivity {

    String id;

    DatabaseReference dataEmploye;
    DatabaseReference data;

    ListView list;
    ArrayList<String> array = new ArrayList<>();
    ArrayAdapter<String> adapter;

    int selectedItem = -1;


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

    public void ajout(View view) {
        Intent intent = new Intent(ClinicService.this, ListeServices.class);
        Bundle extras = new Bundle();
        extras.putString("fromEmploye", "true");
        extras.putString("id",id);
        intent.putExtras(extras);
        startActivity(intent);
    }
}
