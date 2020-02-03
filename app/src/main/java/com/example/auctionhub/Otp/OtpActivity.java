package com.example.auctionhub.Otp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.auctionhub.Forgotpassword.ForgotpasswordActivity;
import com.example.auctionhub.R;
import com.example.auctionhub.Resetpassword.ResetpasswordActivity;

public class OtpActivity extends AppCompatActivity {

    TextView t1,t2;
    EditText e1;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);
        t1=(TextView)findViewById(R.id.otptext1);
        e1=(EditText)findViewById(R.id.otpedt1);
        b1=(Button)findViewById(R.id.otpbtn);
        t2=(TextView)findViewById(R.id.otplink1);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(OtpActivity.this, ResetpasswordActivity.class);
                startActivity(intent);

            }
        });
        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2=new Intent(OtpActivity.this, ForgotpasswordActivity.class);
                startActivity(intent2);
            }
        });
    }
}
