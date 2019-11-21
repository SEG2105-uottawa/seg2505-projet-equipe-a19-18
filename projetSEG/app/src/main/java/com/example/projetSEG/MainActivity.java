package com.example.projetSEG;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;

//PAGE DE LOGIN
public class MainActivity extends AppCompatActivity {

    DatabaseReference dataPatient, dataEmploye;
    ArrayList<User> patientList, employeList;

    EditText _txtUser, _txtPass;
    Spinner _spinner;

    String username;
    String password;
    String prenom, nom;
    String courriel;

    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _txtPass = findViewById(R.id.txtPass);
        _txtUser = findViewById(R.id.txtUser);
        _spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.usertype, R.layout.support_simple_spinner_dropdown_item);
        _spinner.setAdapter(adapter);

        password = null;

        dataPatient = FirebaseDatabase.getInstance().getReference("Patient");
        dataEmploye = FirebaseDatabase.getInstance().getReference("Employe");
        patientList = new ArrayList<>();
        employeList = new ArrayList<>();
    }

    //LIRE FIREBASE POUR AVOIR LA LISTE DE PATIENT ET D EMPLOYE
    @Override
    protected void onStart() {
        super.onStart();

        dataPatient.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                patientList.clear();
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    Object infoRaw = postSnapshot.getValue();
                    HashMap info = (HashMap) infoRaw;

                    password = (String) info.get("password");
                    //ERRorRRr
                   // password = Seg256.encrypt(password.getText().toString());
                    username = (String) info.get("username");
                    nom = (String) info.get("nom");
                    prenom = (String) info.get("prenom");
                    courriel = (String) info.get("courriel");




                    User user = new User(username, password, nom, prenom, courriel);
                    patientList.add(user);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });

        dataEmploye.addValueEventListener((new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                employeList.clear();
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    Object infoRaw = postSnapshot.getValue();
                    HashMap info = (HashMap) infoRaw;

                    password = (String) info.get("password");
                    username = (String) info.get("username");
                    nom = (String) info.get("nom");
                    prenom = (String) info.get("prenom");
                    courriel = (String) info.get("courriel");

                    User user = new User(username, password, nom, prenom, courriel);
                    employeList.add(user);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        }));
    }

    //VERIFICATION POUR UN LOGIN ACCEPTER
    public void login(View view) {

        User user;
        String username = _txtUser.getText().toString();
        String password = _txtPass.getText().toString();
        String type = _spinner.getSelectedItem().toString();
        Boolean connect = false;


        if (type.equals("administrateur") && username.equals("admin") && password.equals("5T5ptQ")) {
            connect = true;
            Intent intent = new Intent(MainActivity.this, Administrateur.class);
            startActivity(intent);
        } else if (type.equals("employe")) {
            for (int i = 0; i < employeList.size(); i++) {
                user = employeList.get(i);
                if (username.equals(user.username) && password.equals(user.password)) {
                    connect = true;
                    Intent intent = new Intent(MainActivity.this, Employe.class);
                    intent.putExtra("name", _txtUser.getText().toString());
                    startActivity(intent);
                }
            }
            if (connect == false) {
                Toast.makeText(getApplicationContext(), "Mot de passe ou nom d'utilisateur invalide", Toast.LENGTH_LONG).show();
            }
        } else if (type.equals("patient")) {
            for (int i = 0; i < patientList.size(); i++) {
                user = patientList.get(i);
                if (username.equals(user.username) && password.equals(user.password)) {
                    connect = true;
                    Intent intent = new Intent(MainActivity.this, Patient.class);
                    intent.putExtra("name", _txtUser.getText().toString());
                    startActivity(intent);
                }
            }
            if (connect == false) {
                Toast.makeText(getApplicationContext(), "Mot de passe ou nom d'utilisateur invalide", Toast.LENGTH_LONG).show();
            }
        } else if (connect == false) {
            Toast.makeText(getApplicationContext(), "Mot de passe ou nom d'utilisateur invalide", Toast.LENGTH_LONG).show();
        }
    }


    public static String encrypt(String myPassword) {
        try {
            MessageDigest digest = MessageDigest.getInstance("HADY-111");
            byte[] hash = digest.digest(myPassword.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer();

            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public void createNewAccount(View view) {
        Intent intent = new Intent(MainActivity.this, CreateAccount.class);
        startActivity(intent);
    }
}