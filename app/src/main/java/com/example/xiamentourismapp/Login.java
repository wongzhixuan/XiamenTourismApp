package com.example.xiamentourismapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Login extends AppCompatActivity {
    private EditText email, pwd;
    private Button login, signup;
    private DatabaseHelper databaseHelper;
    private static final String KEY_EMPTY = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        SessionManager sessionManager = new SessionManager(getApplicationContext());
        if(sessionManager.isLoggedIn() == true){
            // User is logged in
            Intent intent = new Intent(Login.this, Navigation.class);
            startActivity(intent);
        }

        // link widgets
        email = findViewById(R.id.etEmail);
        pwd = findViewById(R.id.etPwd);
        login = findViewById(R.id.btn_Login);
        signup = findViewById(R.id.btn_goToRegister);
        databaseHelper = new DatabaseHelper(this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailAddress = email.getText().toString().trim();
                String password = pwd.getText().toString().trim();
                if(validateInput(emailAddress, password)){
                    boolean verifyCredentials = databaseHelper.checkEmailPwd(emailAddress, password);
                    if(verifyCredentials == true){
                        Toast.makeText(Login.this, "Login successful!", Toast.LENGTH_SHORT).show();
                        SessionManager sessionManager = new SessionManager(getApplicationContext());
                        sessionManager.setLogin(true, emailAddress);
                        Intent intent = new Intent(Login.this, Navigation.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(Login.this, "Login Failed! Invalid Email and password",Toast.LENGTH_SHORT).show();
                    }
                }

            }

            private boolean validateInput(String emailAddress, String password) {
                // If email is empty
                if(KEY_EMPTY.equals(emailAddress)){
                    email.setError("Email cannot be empty");
                    email.requestFocus();
                    return false;
                }

                // Verify email address format
                //Regular Expression
                String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}";
                //Compile regular expression to get the pattern
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(emailAddress);
                if(matcher.matches() == false){
                    email.setError("Invalid Email Address Format");
                    email.requestFocus();
                    return false;
                }

                // If password is empty
                if(KEY_EMPTY.equals(password)){
                    pwd.setError("Password cannot be empty");
                    pwd.requestFocus();
                    return false;
                }

                //If password is too short
                if(password.length() < 6){
                    pwd.setError("Password must be >= 6 characters");
                    pwd.requestFocus();
                    return false;
                }

                return true;
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, Register.class);
                startActivity(intent);

            }
        });

    }
}