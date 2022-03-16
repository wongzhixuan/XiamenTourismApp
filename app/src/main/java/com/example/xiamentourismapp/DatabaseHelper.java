package com.example.xiamentourismapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.net.Uri;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DBname = "XiamenTourism.db";
    // Constructor
    public DatabaseHelper(@Nullable Context context) {
        super(context, DBname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE USERS(userEmail TEXT PRIMARY KEY, userName TEXT, password TEXT, imageURL TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS USERS");
    }

    // to insert data
    public boolean insertData(String userEmail, String userName, String password){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("userEmail", userEmail);
        contentValues.put("userName", userName);
        contentValues.put("password", password);
        long result = sqLiteDatabase.insert("USERS", null, contentValues);
        if(result == 1){
            return false;
        }
        else{
            return true;
        }
    }

    // to check the userEmail
    public boolean checkUserEmail(String userEmail){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM USERS WHERE userEmail = ?", new String[]{userEmail});
        if (cursor.getCount() > 0){
            return true;
        }
        else{
            return false;
        }
    }

    // verify if the email and pwd match
    public boolean checkEmailPwd(String userEmail, String password){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM USERS WHERE userEmail = ? and password = ?", new String[]{userEmail, password});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    // retrieve user data from database
    public Cursor getUserData(String userEmail){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM USERS WHERE userEmail = ?", new String[]{userEmail});
        return cursor;
    }

    // update user data
    public boolean updateData(String userEmail, String userName, String password){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("userEmail", userEmail);
        contentValues.put("userName", userName);
        contentValues.put("password", password);
        sqLiteDatabase.update("USERS", contentValues,"userEmail = ?", new String[]{userEmail});
        return true;
    }
    // update user name
    public boolean updateName(String userEmail,String userName){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("userEmail", userEmail);
        contentValues.put("userName", userName);
        sqLiteDatabase.update("USERS", contentValues,"userEmail = ?", new String[]{userEmail});
        return true;
    }
    // update profile image
    public boolean updateImage(String userEmail, String imageURL){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("imageURL", imageURL);
        sqLiteDatabase.update("USERS",contentValues, "userEmail = ?", new String[]{userEmail});
        return true;
    }
    // delete user account
    public Integer deleteData(String userEmail){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        return sqLiteDatabase.delete("USERS", "userEmail = ?", new String[]{userEmail});
    }

}
