package com.example.projetSEG;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

//PAGE POUR SUPPRIMER UN COMPTE PATIENT OU EMPLOYE PAR UN ADMIN
public class SupprimerCompte extends AppCompatActivity {


    DatabaseReference dataEmploye, dataPatient;

    ListView list;
    ArrayList<String> array = new ArrayList<>();
    ArrayAdapter<String> adapter;

    int selectedItem = -1;

    ArrayList<String> keyList = new ArrayList<>();

    //String id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supprimer_compte);

        dataEmploye = FirebaseDatabase.getInstance().getReference("Employe");
        dataPatient = FirebaseDatabase.getInstance().getReference("Patient");

        list = findViewById(R.id.listeCompte);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,array);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedItem = position;
            }
        });

        //Doit trouver une moyen inserer employe et client
        /*
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
        */
    }





    public void supprime(View view) {

        /*
        if (selectedItem == -1) {
            Toast.makeText(getApplicationContext(), "Choisir un service", Toast.LENGTH_LONG).show();
        } else {

            String serviceID = keyList.get(selectedItem);
            data.child(serviceID).setValue(null);
            array.remove(selectedItem);
            keyList.remove(selectedItem);

        }
         */
    }

}
