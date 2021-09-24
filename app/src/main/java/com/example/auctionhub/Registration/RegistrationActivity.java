package com.example.auctionhub.Registration;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.auctionhub.BottomActivity;
import com.example.auctionhub.DBHelper;
import com.example.auctionhub.R;

public class RegistrationActivity extends AppCompatActivity {

    TextView t11, t22;
    EditText name, phone, license, did;
    Button regBtn;
    DBHelper DB;


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
        DB = new DBHelper(this);




        t22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegistrationActivity.this, BottomActivity.class);
                startActivity(intent);
            }
        });


        regBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String name1 = name.getText().toString();
                String phone1 = phone.getText().toString();
                String licence1= license.getText().toString();
                String did1= did.getText().toString();

                Boolean checkinsertdata=DB.insertuserdata(name1,phone1,licence1,did1);
                if(checkinsertdata){
                Toast.makeText(RegistrationActivity.this,"New Entry Added",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(RegistrationActivity.this,"New Entry Not Added",Toast.LENGTH_SHORT).show();

                }




            }
        });



    }



}