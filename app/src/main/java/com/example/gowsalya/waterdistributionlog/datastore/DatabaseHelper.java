package com.example.gowsalya.waterdistributionlog.datastore;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by gowsalya on 17/11/16.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME="Farming";
    private static final int DATABASE_VERSION=2;


    public static final String TABLE_USER="user";

    public static final String USER_NAME="username";
    public static final String USER_STATE="state";
    public static final String USER_DISTRICT="district";
    public static final String USER_PHONE="phone";
    public static final String USER_MAIL="email";



    DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+TABLE_USER+" ("+USER_NAME+" TEXT,"+USER_STATE+" TEXT,"+USER_DISTRICT+" TEXT,"+USER_PHONE+" TEXT,"+USER_MAIL+" TEXT)");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);

        // Create tables again
        onCreate(db);
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
    }

    public void addUserDetails(String[] userDetails ){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(USER_NAME,userDetails[0]);
        values.put(USER_STATE,userDetails[1]);
        values.put(USER_DISTRICT,userDetails[2]);
        values.put(USER_PHONE,userDetails[3]);
        values.put(USER_MAIL,userDetails[4]);
        db.insert(TABLE_USER,null,values);
        db.close();
    }

    public boolean isRegistered(){

        String selectQuery = "SELECT  * FROM " + TABLE_USER;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        boolean registered=false;
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            registered=true;
        }
            return registered;
    }

}