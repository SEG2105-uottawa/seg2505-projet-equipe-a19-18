package com.example.projetSEG;


import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.sql.DatabaseMetaData;

public class User {
    public String password, username;

    public User() {

    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }


}