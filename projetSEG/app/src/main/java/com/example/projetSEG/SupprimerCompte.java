package com.example.projetSEG;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

//PAGE POUR SUPPRIMER UN COMPTE PATIENT OU EMPLOYE PAR UN ADMIN
public class SupprimerCompte extends AppCompatActivity {


        ListView listViewUsers;
        List<User> users = new ArrayList<>();

            private DatabaseReference data = FirebaseDatabase.getInstance().getReference();


            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_supprimer_compte);

                listViewUsers = (ListView) findViewById(R.id.list);

                data = FirebaseDatabase.getInstance().getReference("users");
            }

        private boolean deleteUser(String id) {
            DatabaseReference dR = FirebaseDatabase.getInstance().getReference("users").child(id);
            dR.removeValue();
            Toast.makeText(getApplicationContext(), "User Deleted", Toast.LENGTH_LONG).show();
            return true;
        }
    }
