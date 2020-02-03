package com.example.auctionhub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.auctionhub.R;

public class BidnowActivity extends AppCompatActivity {

    TextView t1,t2,t3;
    EditText e1,e2;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bidnow);

        t1=(TextView)findViewById(R.id.bidtv1);
        t2=(TextView)findViewById(R.id.auctiontitlebid);
        t3=(TextView)findViewById(R.id.bidlink);
        e1=(EditText) findViewById(R.id.bidet1);
        e2=(EditText) findViewById(R.id.bidet2);
        b1=(Button) findViewById(R.id.bidbtn);



        Intent in = getIntent();
        String Title=in.getExtras().getString("Title");



        t2.setText(Title);



    }
}
