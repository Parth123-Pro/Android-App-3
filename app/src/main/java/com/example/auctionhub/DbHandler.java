package com.example.auctionhub;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.HashMap;

public class DbHandler extends SQLiteOpenHelper {
    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "usersdb";
    private static final String TABLE_Users = "userdetails";
    private static final String TABLE_Average = "Average";

    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_PH = "phone";
    private static final String KEY_LIC = "licence";
    private static final String KEY_DId = "DId";

    private static final String KEY_DATE="date";
    private static final String KEY_TIME="time";
    private static final String KEY_DID2="DId2";
    private static final String KEY_LITER="liter";
    private static final String KEY_AVERAGE="average";


    public DbHandler(Context context){
        super(context,DB_NAME, null, DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db){
        String CREATE_TABLE = "CREATE TABLE " + TABLE_Users + "("
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_NAME + " TEXT,"
                + KEY_PH + " TEXT,"
                + KEY_LIC + " TEXT,"
                + KEY_DId + " TEXT"+ ")";
        db.execSQL(CREATE_TABLE);

        String CREATE_TABLE2 = "CREATE TABLE " + TABLE_Average + "("
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_DATE + " TEXT,"
                + KEY_TIME + " TEXT,"
                + KEY_DID2 + " TEXT,"
                + KEY_LITER + " TEXT,"
                +KEY_AVERAGE + " TEXT"+")";
        db.execSQL(CREATE_TABLE2);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        // Drop older table if exist
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_Users);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_Average);
        // Create tables again
        onCreate(db);
    }

    public void insertUserDetails(String name, String phone, String licence, String DId){
        //Get the Data Repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();
        //Create a new map of values, where column names are the keys
        ContentValues cValues = new ContentValues();
        cValues.put(KEY_NAME, name);
        cValues.put(KEY_PH, phone);
        cValues.put(KEY_LIC, licence);
        cValues.put(KEY_DId, DId);
        // Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(TABLE_Users,null, cValues);
        db.close();
    }

    public void insertAverageDetails(String date, String time, String DId2, String liter, String average){
        //Get the Data Repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();
        //Create a new map of values, where column names are the keys
        ContentValues cValues = new ContentValues();
        cValues.put(KEY_DATE, date);
        cValues.put(KEY_TIME,time);
        cValues.put(KEY_DID2,DId2);
        cValues.put(KEY_LITER, liter);
        cValues.put(KEY_AVERAGE,average);
        // Insert the new row, returning the primary key value of the new row
        long newRowId2 = db.insert(TABLE_Average,null, cValues);
        db.close();
    }
    // Get User Details
    public ArrayList<HashMap<String, String>> GetUsers(){
        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<HashMap<String, String>> userList = new ArrayList<>();
        String query = "SELECT name, phone, licence FROM "+ TABLE_Users;
        Cursor cursor = db.rawQuery(query,null);
        while (cursor.moveToNext()){
            HashMap<String,String> user = new HashMap<>();
            user.put("name",cursor.getString(cursor.getColumnIndex(KEY_NAME)));
            user.put("phone",cursor.getString(cursor.getColumnIndex(KEY_PH)));
            user.put("licence",cursor.getString(cursor.getColumnIndex(KEY_LIC)));
            userList.add(user);
        }
        return  userList;
    }

    public ArrayList<HashMap<String, String>> GetAverage(){
        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<HashMap<String, String>> AverageList = new ArrayList<>();
        String query = "SELECT * FROM "+ TABLE_Average;
        Cursor cursor = db.rawQuery(query,null);
        while (cursor.moveToNext()){
            HashMap<String,String> user1 = new HashMap<>();
            user1.put("date",cursor.getString(cursor.getColumnIndex(KEY_DATE)));
            user1.put("time",cursor.getString(cursor.getColumnIndex(KEY_TIME)));
            user1.put("DId2",cursor.getString(cursor.getColumnIndex(KEY_DID2)));
            user1.put("liter",cursor.getString(cursor.getColumnIndex(KEY_LITER)));
            user1.put("average",cursor.getString(cursor.getColumnIndex(KEY_AVERAGE)));
            AverageList.add(user1);
        }
        return  AverageList;
    }

}