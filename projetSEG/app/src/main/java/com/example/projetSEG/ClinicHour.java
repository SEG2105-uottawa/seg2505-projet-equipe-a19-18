package com.example.projetSEG;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.TextView;

//PAGE POUR AFFICHER LES HEURES DE LA CLINIQUE
public class ClinicHour extends AppCompatActivity {

    CalendarView calendarView;
    TextView viewHoraire;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clinic_hour);

        calendarView =  findViewById(R.id.calendarView);
        viewHoraire =  findViewById(R.id.viewHoraire);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                viewHoraire.setText(Integer.toString(dayOfMonth));
            }
        });
    }
}
