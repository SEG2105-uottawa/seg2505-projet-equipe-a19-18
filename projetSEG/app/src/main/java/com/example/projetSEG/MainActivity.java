package com.example.projetSEG;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.security.MessageDigest;

public class MainActivity extends AppCompatActivity {

    private DatabaseReference data = FirebaseDatabase.getInstance().getReference("users");
    //private static final String TAG = "EmailPassword";
    //private FirebaseAuth mAuth;
    private DatabaseReference dataPatient = FirebaseDatabase.getInstance().getReference("Patient");
    private DatabaseReference dataEmploye = FirebaseDatabase.getInstance().getReference("Employe");

    private FirebaseAuth firebaseAuth;

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

        firebaseAuth = FirebaseAuth.getInstance();

        //mAuth = FirebaseAuth.getInstance();
        //findViewById(R.id.btnLogin).setOnClickListener((View.OnClickListener) this);
    }

    public void login(View view) {
        if (_txtUser.getText().toString().equals("admin") && _txtPass.getText().toString().equals("5T5ptQ") && _spinner.getSelectedItem().toString().equals("administrateur")) {
            Intent intent = new Intent(MainActivity.this, Administrateur.class);
            startActivity(intent);
        } else if (_txtUser.getText().toString().equals("employe") && _txtPass.getText().toString().equals("employe") && _spinner.getSelectedItem().toString().equals("employe")) {
            Intent intent = new Intent(MainActivity.this, Employe.class);
            intent.putExtra("name", _txtUser.getText().toString());
            startActivity(intent);
        } else if (_txtUser.getText().toString().equals("patient") && _txtPass.getText().toString().equals("patient") && _spinner.getSelectedItem().toString().equals("patient")) {
            Intent intent = new Intent(MainActivity.this, Patient.class);
            intent.putExtra("name", _txtUser.getText().toString());
            startActivity(intent);
        } else {
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

/**
    private void createAccount(String userName, String password) {
        Log.d(TAG, "createAccount:" + userName);
        if (!validateForm()) {
            return;
        }

        // [START create_user_with_email]
        mAuth.createUserWithEmailAndPassword(userName, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithuserName:success");
                            FirebaseUser user = mAuth.getCurrentUser();

                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithuserName:failure", task.getException());
                            Toast.makeText(MainActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                        }

                    }
                });
        // [END create_user_with_email]
    }

    private void signIn(String userName, String password) {
        Log.d(TAG, "signIn:" + userName);
        if (!validateForm()) {
            return;
        }


        // [START sign_in_with_email]
        mAuth.signInWithEmailAndPassword(userName, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();

                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(MainActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                        }

                    }
                });
        // [END sign_in_with_email]
    }



    private boolean validateForm() {
        boolean valid = true;

        String userName = _txtUser.getText().toString();
        if (TextUtils.isEmpty(userName)) {
            _txtUser.setError("Required.");
            valid = false;
        } else {
            _txtUser.setError(null);
        }

        String password = _txtPass.getText().toString();
        if (TextUtils.isEmpty(password)) {
            _txtPass.setError("Required.");
            valid = false;
        } else {
            _txtPass.setError(null);
        }

        return valid;
    }
*/






}

       /** data.addListenerForSingleValueEvent(new ValueEventListener() {


            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnap : dataSnapshot.getChildren()) {
                    if (loggedUser != null && username.equals(loggedUser.getUsername()) && password.equals(loggedUser.getPassword())) {
                        intent = new Intent(MainActivity.this, Employe.class);
                        startActivity(intent);
                        break;
                } else {
                    intent = null;
                }
                }
            if (intent==null) {
                Toast.makeText(getApplicationContext(),"Incorrect username/password.", Toast.LENGTH_SHORT).show();
            }
        }
        }
        );

    */