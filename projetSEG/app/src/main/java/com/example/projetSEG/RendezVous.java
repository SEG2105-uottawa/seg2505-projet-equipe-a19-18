package com.example.projetSEG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class RendezVous extends AppCompatActivity {

    DatabaseReference dataEmploye;
    String id;
    Integer numberPatient;
    int clic = 0;

    final long yearInMilli = DateUtils.YEAR_IN_MILLIS;
    final long dayInMilli = DateUtils.DAY_IN_MILLIS;
    Button btntxt;
    TextView txt;
    CalendarView calendar;
    long todayDate;
    int jour, mois;

    ArrayList<String> arr = new ArrayList<>();
    boolean valide = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rendez_vous);

        Intent intent = getIntent();
        id = intent.getStringExtra("employe");


        btntxt = findViewById(R.id.btntxt);
        txt = findViewById(R.id.txtInfo);
        calendar = findViewById(R.id.calendar);
        todayDate = System.currentTimeMillis();
        calendar.setMinDate(todayDate);
        calendar.setMaxDate(todayDate+yearInMilli);


        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener(){
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                jour = dayOfMonth;
                mois = month+1;
                btntxt.setText("Réserver un rendez-vous le\n"+jour+" / "+mois);

                valide = true;
                for (int i = 0; i < arr.size(); i++) {
                    String v = arr.get(i);
                    String[] sep = v.split("-");
                    if (sep[0].equals(Integer.toString(jour)) && sep[1].equals(Integer.toString(mois))) {
                        valide = false;
                    }
                }
                if (valide) {
                    txt.setText("Valide");
                } else {
                    txt.setText("Non valide");
                }

            }
        });



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

                            HashMap<String, String> reserve = (HashMap) clinic.get("reserves");
                            if (reserve != null) {
                                for(Map.Entry<String, String> entry : reserve.entrySet()) {
                                    arr.add(entry.getValue());
                                }
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
            Toast.makeText(getApplicationContext(), "Enregitré : Walk-In", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getApplicationContext(), "Walk-In déjà enregitré", Toast.LENGTH_LONG).show();
        }

        clic++;
    }

    public void reserve(View view) {

        if (valide) {
            String val = jour+"-"+mois;
            dataEmploye.child(id).child("clinique").child("reserves").push().setValue(val);
            Toast.makeText(getApplicationContext(), "Réservé", Toast.LENGTH_LONG).show();
            valide = false;
            txt.setText("Non valide");
        } else {
            Toast.makeText(getApplicationContext(), "NON VALIDE", Toast.LENGTH_LONG).show();
        }

    }
}
