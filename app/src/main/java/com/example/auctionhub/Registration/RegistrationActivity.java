package com.example.auctionhub.Registration;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.auctionhub.BottomActivity;
import com.example.auctionhub.DatabaseHelper;
import com.example.auctionhub.R;

public class RegistrationActivity extends AppCompatActivity {

    TextView t11, t22;
    EditText name, phone, license, did;
    Button regBtn;
    DatabaseHelper mDatabaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        t11 = findViewById(R.id.rt1);
        name = findViewById(R.id.d_name);

        phone = findViewById(R.id.d_phone);
        license = findViewById(R.id.d_licence);
        did = findViewById(R.id.d_did);
        regBtn=findViewById(R.id.btnreg);
        t22 = findViewById(R.id.linklog1);
        t22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegistrationActivity.this, BottomActivity.class);
                startActivity(intent);
            }
        });

        mDatabaseHelper = new DatabaseHelper(this);
        regBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String name1 = name.getText().toString();
                String phone1 = phone.getText().toString();
                String licence1= license.getText().toString();
                String did1= did.getText().toString();

             /*   Boolean checkinsert=mDatabaseHelper.result();*/


            }
        });



    }



}