package com.example.auctionhub.Resetpassword;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.auctionhub.Login.LoginActivity;
import com.example.auctionhub.R;

public class ResetpasswordActivity extends AppCompatActivity {

    TextView t1;
    EditText e1,e2;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resetpassword);
        t1=(TextView)findViewById(R.id.restv1);
        e1=(EditText) findViewById(R.id.resedt1);
        e2=(EditText) findViewById(R.id.resedt2);
        b1=(Button) findViewById(R.id.resbtn);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(e1.getText().toString().isEmpty())
                {
                    e1.setError("Password Field Is Required");
                }
                if(e2.getText().toString().isEmpty())
                {
                    e2.setError("Password Field Is Required");
                }
                Intent intent=new Intent(ResetpasswordActivity.this, LoginActivity.class);
                startActivity(intent);

            }
        });

    }
}
