package com.example.projetSEG;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Spinner;
import android.content.Intent;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class MainActivity extends AppCompatActivity {


    private DatabaseReference data = FirebaseDatabase.getInstance().getReference();

    EditText _txtUser, _txtPass;
    Spinner _spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        _txtPass = findViewById(R.id.txtPass);
        _txtUser = findViewById(R.id.txtUser);
        _spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.usertype, R.layout.support_simple_spinner_dropdown_item);
        _spinner.setAdapter(adapter);


    }

    public void login(View view){

        if (_txtUser.getText().toString().equals("admin")&& _txtPass.getText().toString().equals("5T5ptQ")&& _spinner.getSelectedItem().toString().equals("administrateur")) {
            Intent intent = new Intent(MainActivity.this, Administrateur.class);
            startActivity(intent);
        }
        else if (_txtUser.getText().toString().equals("employe")&& _txtPass.getText().toString().equals("employe")&& _spinner.getSelectedItem().toString().equals("employe")) {
            Intent intent = new Intent(MainActivity.this, Employe.class);
            intent.putExtra("name", _txtUser.getText().toString());
            startActivity(intent);
        }
        else if (_txtUser.getText().toString().equals("patient") && _txtPass.getText().toString().equals("patient") && _spinner.getSelectedItem().toString().equals("patient")) {
            Intent intent = new Intent(MainActivity.this, Patient.class);
            intent.putExtra("name", _txtUser.getText().toString());
            startActivity(intent);
        } else {
            Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
        }
    }

    public void createAccount(View view) {
        Intent intent = new Intent(MainActivity.this, CreateAccount.class);
        startActivity(intent);
    }
}