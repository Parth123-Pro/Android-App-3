package com.example.auctionhub;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.auctionhub.Registration.RegistrationActivity;
import com.example.auctionhub.Splash.SplashActivity;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadLocale();
        setContentView(R.layout.activity_main);

        ImageView imageView = findViewById(R.id.imageView2);
        TextView textView = findViewById(R.id.next);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegistrationActivity.class);
                startActivity(intent);
            }
        });

        Button changeLang=findViewById(R.id.langauge_b);
        changeLang.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                showChangeLangaugeDialog();

            }


        });
    }


    private void showChangeLangaugeDialog() {
        final String[] listItems = {"हिंदी","English"};
        final AlertDialog.Builder mBuilder=new AlertDialog.Builder(this);
        mBuilder.setTitle("Choose Langauge...");
        mBuilder.setSingleChoiceItems(listItems,-1,new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (which == 0)
                {
                    setLocale("hi");
                    recreate();
                }else if (which == 1)
                {
                    setLocale("en");
                    recreate();
                }
                dialog.dismiss();
            }
        });
        AlertDialog mDialog = mBuilder.create();
            mDialog.show();


    }

    private void setLocale(String lang) {
        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale= locale;
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        SharedPreferences.Editor editor=getSharedPreferences("Settings",MODE_PRIVATE).edit();
        editor.putString("My_Lang",lang);
        editor.apply();
    }

    public void loadLocale(){
        SharedPreferences prefs = getSharedPreferences("Settings", Activity.MODE_PRIVATE);
        String langauge = prefs.getString("My_Lang","");
        setLocale(langauge);

    }

}
