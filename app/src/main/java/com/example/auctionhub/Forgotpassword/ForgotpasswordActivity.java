package com.example.auctionhub.Forgotpassword;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.auctionhub.Login.LoginActivity;
import com.example.auctionhub.Otp.OtpActivity;
import com.example.auctionhub.R;

public class ForgotpasswordActivity extends AppCompatActivity {

    TextView t1,t2;
    EditText e1;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotpassword);

        t1=(TextView)findViewById(R.id.tf1);
        e1=(EditText)findViewById(R.id.fmail1);
        b1=(Button)findViewById(R.id.fbtn1);
        t2=(TextView)findViewById(R.id.ft23);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(ForgotpasswordActivity.this, OtpActivity.class);
                startActivity(intent1);
                if(e1.getText().toString().isEmpty())
                {
                    e1.setError("Email Is Required");
                }
            }
        });
        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ForgotpasswordActivity.this, LoginActivity.class);

                startActivity(intent);
            }
        });
    }
}
