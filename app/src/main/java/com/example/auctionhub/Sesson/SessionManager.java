package com.example.auctionhub.Sesson;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.example.auctionhub.Login.LoginActivity;
import com.example.auctionhub.Login.LogoutActivity;



public class SessionManager {
    SharedPreferences sharedPreferences;
    public SharedPreferences.Editor editor;
    public Context context;
    int PRIVATE_MODE=0;

    private static final String PREF_NAME="LOGIN";


    public SessionManager(Context context){
        this.context=context;
        sharedPreferences=context.getSharedPreferences(PREF_NAME,PRIVATE_MODE);
    }




    public void logout(){
        editor.clear();
        editor.commit();
        Intent intent=new Intent(context, LoginActivity.class);
        context.startActivity(intent);
        ((LogoutActivity)context).finish();

    }


}
