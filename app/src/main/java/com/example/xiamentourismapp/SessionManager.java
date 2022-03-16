package com.example.xiamentourismapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

public class SessionManager {
    // LogCat tag
    private static String TAG = SessionManager.class.getSimpleName();
    Context context;

    // Shared Preferences
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    // Shared pref mode
    int PRIVATE_MODE = 0;

    // Shared preferences file name
    private static final String PREF_NAME = "TEST";

    private static final String KEY_IS_LOGGED_IN = "IS_LOGGED_IN";
    private static final String CURRENT_USER_EMAIL = "CURRENT_USER";


    public SessionManager(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = sharedPreferences.edit();
    }

    public void setLogin(boolean isLoggedIn, String userEmail) {

        editor.putBoolean(KEY_IS_LOGGED_IN, isLoggedIn);
        editor.putString(CURRENT_USER_EMAIL, userEmail);
        // commit changes
        editor.commit();

        Log.d(TAG, "User login session modified!");
    }

    public boolean isLoggedIn() {
        sharedPreferences.getString(CURRENT_USER_EMAIL, null);
        return sharedPreferences.getBoolean(KEY_IS_LOGGED_IN, false);
    }
    public String getCurrentUserEmail(){
        return  sharedPreferences.getString(CURRENT_USER_EMAIL, null);
    }
}

