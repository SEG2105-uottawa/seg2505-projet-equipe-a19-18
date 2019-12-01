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
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class InfoClinic extends AppCompatActivity {

    DatabaseReference dataEmploye;
    String id;

    ListView list;
    ArrayList<String> array = new ArrayList<>();
    ArrayAdapter<String> adapter;

    TextView cAdresse, cTelephone, cNom, cAssurance, cPaiment;
    TextView cLundi, cMardi, cMercredi, cJeudi, cVendredi;
    TextView eval;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_clinic);

        Intent intent = getIntent();
        id = intent.getStringExtra("employe");

        dataEmploye = FirebaseDatabase.getInstance().getReference("Employe");

        cAdresse = findViewById(R.id.cAdresse);
        cTelephone = findViewById(R.id.cTelephone);
        cNom = findViewById(R.id.cNom);
        cAssurance = findViewById(R.id.cAssurance);
        cPaiment = findViewById(R.id.cPaiment);
        cLundi = findViewById(R.id.cLundi);
        cMardi = findViewById(R.id.cMardi);
        cMercredi = findViewById(R.id.cMercredi);
        cJeudi = findViewById(R.id.cJeudi);
        cVendredi = findViewById(R.id.cVendredi);
        eval = findViewById(R.id.eval);

        list = findViewById(R.id.cService);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,array);
        list.setAdapter(adapter);


        dataEmploye.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                HashMap info = (HashMap) dataSnapshot.getValue();
                if (id.equals(dataSnapshot.getKey())) {

                    HashMap clinic = (HashMap) info.get("clinique");
                    if (clinic != null) {
                        cAdresse.setText("Adresse : "+clinic.get("adresse"));
                        cTelephone.setText("Telephone : "+clinic.get("telephone"));
                        cNom.setText("Nom : "+clinic.get("nom"));
                        cAssurance.setText("Assurance : "+clinic.get("assurance"));
                        cPaiment.setText("Paiment : "+clinic.get("paiment"));

                        HashMap clinicHour = (HashMap) clinic.get("clinicHour");
                        if (clinicHour != null) {
                            cLundi.setText("Lundi : "+clinicHour.get("lundi"));
                            cMardi.setText("Mardi : "+clinicHour.get("mardi"));
                            cMercredi.setText("Mercredi : "+clinicHour.get("mercredi"));
                            cJeudi.setText("Jeudi : "+clinicHour.get("jeudi"));
                            cVendredi.setText("Vendredi : "+clinicHour.get("vendredi"));
                        }

                        HashMap<String, HashMap> idService = (HashMap) clinic.get("service");
                        if (idService != null) {
                            for(Map.Entry<String, HashMap> entry : idService.entrySet()) {
                                HashMap v = entry.getValue();
                                ServiceObject service = new ServiceObject(v.get("id").toString(), v.get("service").toString());
                                array.add(service.toString());
                            }
                        }

                        float rating = 0;
                        int nEval = 0;
                        HashMap<String, HashMap> rate = (HashMap) clinic.get("rating");
                        if (rate != null) {
                            for(Map.Entry<String, HashMap> entry : rate.entrySet()) {
                                HashMap<String, Float> v = entry.getValue();
                                rating +=  ((Number)v.get("star")).floatValue();
                                nEval++;
                            }
                            eval.setText("Services          Évaluation : "+rating/nEval);
                        } else {
                            eval.setText("Services          Évaluation : Non évalué");
                        }
                    }
                }
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
