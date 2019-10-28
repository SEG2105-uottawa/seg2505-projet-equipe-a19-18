package com.example.momo_willie.seg_projet4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Button;
import android.widget.Spinner;
import android.content.Intent;



public class MainActivity extends AppCompatActivity {

    EditText _txtUser, _txtPass;
    Button _btnLogin, _btnRegister;
    Spinner _spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        _txtPass = (EditText) findViewById(R.id.txtPass);
        _txtUser = (EditText) findViewById(R.id.txtUser);
        _btnLogin = (Button) findViewById(R.id.btnLogin);
        _spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.usertype, R.layout.support_simple_spinner_dropdown_item);
        _spinner.setAdapter(adapter);


        /*Jutilise la methode login(View view) pour implementer ce qui suit....



        _btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                String item = _spinner.getSelectedItem().toString();
                if (_txtUser.getText().toString().equals("admin")&& _txtPass.getText().toString().equals("5T5ptQ")&& item.equals("administateur")) {
                    Intent intent = new Intent(MainActivity.this, Administateur.class);
                    startActivity(intent);
                }
                else if (_txtUser.getText().toString().equals("employee")&& _txtPass.getText().toString().equals("employee")&& item.equals("employee")) {
                    Intent intent = new Intent(MainActivity.this, Employee.class);
                    startActivity(intent);
                }
                else if (_txtUser.getText().toString().equals("patient") && _txtPass.getText().toString().equals("patient") && item.equals("patient")) {
                    Intent intent = new Intent(MainActivity.this, Patient.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                }
            }
        });

        */
    }

    public void login(View view){

        if (_txtUser.getText().toString().equals("admin")&& _txtPass.getText().toString().equals("5T5ptQ")&& _spinner.getSelectedItem().toString().equals("administrateur")) {
            Intent intent = new Intent(MainActivity.this, Administrateur.class);
            startActivity(intent);
        }
        else if (_txtUser.getText().toString().equals("employe")&& _txtPass.getText().toString().equals("employe")&& _spinner.getSelectedItem().toString().equals("employe")) {
            Intent intent = new Intent(MainActivity.this, Employe.class);
            startActivity(intent);
        }
        else if (_txtUser.getText().toString().equals("patient") && _txtPass.getText().toString().equals("patient") && _spinner.getSelectedItem().toString().equals("patient")) {
            Intent intent = new Intent(MainActivity.this, Patient.class);
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