package com.example.auctionhub;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String TAG="DatabaseHelper";
    private static final String TABLE_NAME = "Registration";
    private static final String COl1 ="ID";
    private static final String COl2 ="Name";
    private static final String COl4 ="Phone";
    private static final String COl5 ="License";
    private static final String COl6 ="DriverID";



    public DatabaseHelper(@Nullable Context context) {
        super(context, TABLE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
String createTable = "CREATE TABLE"+ TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT,"+COl2+"TEXT,"+COl4+"INTEGER,"+COl5+"TEXT,"+COl6+"INTEGER)";
sqLiteDatabase.execSQL(createTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP IF TABLE IF EXISTS"+ TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public boolean addData(String item){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COl2,item);

        contentValues.put(COl4,item);
        contentValues.put(COl5,item);
        contentValues.put(COl6,item);

        Log.d(TAG,"addData: Adding"+item+"to"+TABLE_NAME);
        long result = sqLiteDatabase.insert(TABLE_NAME, null,contentValues);
        if(result == -1){
            return false;
        }else{
            return true;
        }
    }

}
