package com.example.projetSEG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RateClinic extends AppCompatActivity {

    DatabaseReference dataEmploye;
    String id;

    RatingBar rateBar;
    EditText txtComment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate_clinic);

        dataEmploye = FirebaseDatabase.getInstance().getReference("Employe");

        Intent intent = getIntent();
        id = intent.getStringExtra("employe");
        rateBar = findViewById(R.id.ratingBar);
        txtComment = findViewById(R.id.txtComment);
    }

    public void soumettre(View view) {

        Rating rating = new Rating(rateBar.getRating(), txtComment.getText().toString());
        dataEmploye.child(id).child("clinique").child("rating").push().setValue(rating);

        Intent intent = new Intent(RateClinic.this, ListeClinique.class );
        startActivity(intent);
    }
}
