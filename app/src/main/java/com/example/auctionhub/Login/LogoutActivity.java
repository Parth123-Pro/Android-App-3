package com.example.auctionhub.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.auctionhub.R;
import com.example.auctionhub.Sesson.SessionManager;

import java.util.HashMap;
import java.util.HashSet;

public class LogoutActivity extends AppCompatActivity {
    Button l1;
    TextView name,email;
    SessionManager sessionManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logout);
        sessionManager=new SessionManager(this);


        name=findViewById(R.id.username);
        email=findViewById(R.id.useremail);
        l1=findViewById(R.id.logbtn);

        Intent intent=getIntent();
        String extra_name=intent.getStringExtra("name");
        String extra_email=intent.getStringExtra("email");
        name.setText(extra_name);
        email.setText(extra_email);

        l1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              sessionManager.logout();



            }
        });

    }
}
