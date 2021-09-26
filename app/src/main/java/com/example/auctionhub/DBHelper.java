package com.example.auctionhub;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {


    public DBHelper(@Nullable Context context) {
        super(context, "Userdata.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table Driverdetails(name TEXT,phone TEXT,licence Text,did TEXT primary key )");
        DB.execSQL("create Table Average(date TEXT,time TEXT,did1 TEXT,codometer Text,lodometer TEXT,priceperl TEXT,totalcost TEXT,liter TEXT,average TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("drop Table if exists Driverdetails");
        DB.execSQL("drop Table if exists Average");
    }

    public Boolean insertuserdata(String name, String phone, String licence, String did){

        SQLiteDatabase DB=this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        contentValues.put("phone",phone);
        contentValues.put("licence",licence);
        contentValues.put("did",did);
        long result = DB.insert("Driverdetails",null,contentValues);
        return result != -1;
    }

    public Boolean averagedata(String date, String time, String did1, String codometer, String lodometer,String priceperl,String totalcost,String liter,String average){

        SQLiteDatabase DB=this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("date",date);
        contentValues.put("time",time);
        contentValues.put("did1",did1);
        contentValues.put("codometer",codometer);
        contentValues.put("lodometer",lodometer);
        contentValues.put("priceperl",priceperl);
        contentValues.put("totalcost",totalcost);
        contentValues.put("liter",liter);
        contentValues.put("average",average);
        long result = DB.insert("Average",null,contentValues);
        return result != -1;
    }


    public Cursor readallData()
    {
        SQLiteDatabase DB=this.getWritableDatabase();
        return DB.rawQuery("Select * from Driverdetails", null);

    }
}
