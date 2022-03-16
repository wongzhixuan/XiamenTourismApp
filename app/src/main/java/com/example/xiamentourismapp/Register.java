package com.example.xiamentourismapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Register extends AppCompatActivity {
    private EditText uname, email, pwd, rptpwd;
    private Button login, signup;
    private DatabaseHelper databaseHelper;
    private static final String KEY_EMPTY = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        SessionManager sessionManager = new SessionManager(getApplicationContext());
        if(sessionManager.isLoggedIn() == true){
            // User is logged in
            Intent intent = new Intent(Register.this, Navigation.class);
            startActivity(intent);
        }


        // link widgets
        uname = findViewById(R.id.etName);
        email = findViewById(R.id.etEmail);
        pwd = findViewById(R.id.etPwd);
        rptpwd = findViewById(R.id.etPwdRepeat);
        signup = findViewById(R.id.btn_SignUp);
        login = findViewById(R.id.btn_goToLogin);
        databaseHelper = new DatabaseHelper(this);

        // sign up
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = uname.getText().toString().trim();
                String emailAddress = email.getText().toString().trim().toLowerCase(Locale.ROOT);
                String password = pwd.getText().toString().trim();
                String repeatPwd = rptpwd.getText().toString().trim();

                if(validateInput(username, emailAddress, password,repeatPwd)){
                    boolean checkEmail = databaseHelper.checkUserEmail(emailAddress);
                    if(!checkEmail){
                        boolean insert = databaseHelper.insertData(emailAddress, username, password);
                        if(insert){
                            Toast.makeText(Register.this, "You have successfully registered", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), Login.class);
                            startActivity(intent);
                        }
                        else{
                            Toast.makeText(Register.this, "Registration Failed!", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(Register.this, "Email already registered! Please login!", Toast.LENGTH_SHORT).show();
                    }
                }

            }

            private boolean validateInput(String username, String emailAddress, String password, String  repeatPwd){

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

                // If username is empty
                if(KEY_EMPTY.equals(username)){
                    uname.setError("Username cannot be empty");
                    uname.requestFocus();
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

                // If repeat password is empty
                if(KEY_EMPTY.equals(repeatPwd)){
                    rptpwd.setError("Confirm password cannot be empty");
                    rptpwd.requestFocus();
                    return false;
                }

                // If password and repeat password is match
                if(!password.equals(repeatPwd)){
                    rptpwd.setError("Password and Confirm password does not match");
                    rptpwd.requestFocus();
                    return false;
                }
                return true;
            }
        });

        // direct to login
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Register.this, Login.class);
                startActivity(intent);
            }
        });
    }
}