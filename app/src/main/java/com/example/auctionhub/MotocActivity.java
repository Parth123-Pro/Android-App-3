package com.example.auctionhub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.auctionhub.Login.LoginActivity;

public class MotocActivity extends AppCompatActivity {
    TextView tv1,tv2,tv3;
    ImageView im1,im2;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motoc);

        tv1=(TextView)findViewById(R.id.ontitle);
        tv2=(TextView)findViewById(R.id.onprice);
        tv3=(TextView)findViewById(R.id.ondetail);
        im1=(ImageView) findViewById(R.id.onthumbnail);
        im2=(ImageView) findViewById(R.id.imageView);
        b1=(Button) findViewById(R.id.onbtn);

        Intent intent=getIntent();
        String Title=intent.getExtras().getString("Title");
        String Price=intent.getExtras().getString("Price");
        String Detail=intent.getExtras().getString("Detail");
        int image=intent.getExtras().getInt("Thumbnail");
        //long l=intent.getExtras().getLong("Button");

        tv1.setText(Title);
        tv2.setText(Price);
        tv3.setText(Detail);
        im1.setImageResource(image);

        Auction ac = new Auction(tv1.getText().toString());
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1= new Intent(getApplicationContext(), BidnowActivity.class);
                startActivity(intent1);

            }
        });







    }
}
