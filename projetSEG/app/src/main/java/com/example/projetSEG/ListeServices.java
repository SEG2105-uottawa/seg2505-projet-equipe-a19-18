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
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

//PAGE POUR AFFICHER LES SERVICES DISPONIBLES (ADMIN - SUPPRIMER ET MODIFIER) (EMPLOYE - AJOUTER A LA CLINIQUE)
public class ListeServices extends AppCompatActivity {

    DatabaseReference dataEmploye;
    Button modifier, supprimer, ajouter;

    DatabaseReference dataService;

    ListView list;
    ArrayList<String> array = new ArrayList<>();
    ArrayAdapter<String> adapter;

    int selectedItem = -1;
    ArrayList<ServiceObject> objectList = new ArrayList<>();
    ArrayList<String> keyList = new ArrayList<>();

    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_services);

        dataEmploye = FirebaseDatabase.getInstance().getReference("Employe");

        modifier = findViewById(R.id.btnModifier);
        supprimer = findViewById(R.id.btnSupprimer);
        ajouter = findViewById(R.id.btnAjouter);


        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        if (extras != null) {
            String fromEmploye = extras.getString("fromEmploye");
            id = extras.getString("id");

            //DISTINCTION ENTRE ADMIN ET EMPLOYE
            if(fromEmploye == null) {
                modifier.setVisibility(View.VISIBLE);
                supprimer.setVisibility(View.VISIBLE);
                ajouter.setVisibility(View.GONE);
            } else if (fromEmploye.equals("true")) {
                modifier.setVisibility(View.GONE);
                supprimer.setVisibility(View.GONE);
                ajouter.setVisibility(View.VISIBLE);
            }
        }





        //LIRE DATABASE POUR AFFICHER LA LISTE DES SERVICE
        dataService = FirebaseDatabase.getInstance().getReference("Service");
        list = findViewById(R.id.listViewService);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,array);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedItem = position;
            }
        });



        dataService.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                String value = dataSnapshot.getValue(ServiceObject.class).toString();
                array.add(value);
                adapter.notifyDataSetChanged();
                objectList.add(dataSnapshot.getValue(ServiceObject.class));
                keyList.add(dataSnapshot.getKey());
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

        if (selectedItem == -1) {
            Toast.makeText(getApplicationContext(), "Choisir un service", Toast.LENGTH_LONG).show();
        } else {
            ServiceObject object = objectList.get(selectedItem);
            dataEmploye.child(id).child("clinique").child("service").push().setValue(object);

            Intent intent = new Intent(ListeServices.this, ClinicService.class);
            intent.putExtra("id", id);
            startActivity(intent);
        }

    }

}
