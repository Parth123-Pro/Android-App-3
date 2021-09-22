package com.example.auctionhub.AddProduct;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.auctionhub.R;

public class AddproActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    EditText did, date, time, odometer,l_odometer, price, total;
    Button addpro;
    String[] courses = {"CNG", "Diesel",
            "Gasoline", "Ethanol"};
    static Double fuelInDB = 0.0;
    static Double totalFuelInDB = 0.0;
    static Double totalFuelCost = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addpro);
        did = (EditText) findViewById(R.id.y_did);
        date = (EditText) findViewById(R.id.date);
        time = (EditText) findViewById(R.id.time);
        odometer = (EditText) findViewById(R.id.odometer);
        l_odometer=(EditText) findViewById(R.id.lastodometer);
        price = (EditText) findViewById(R.id.priceperl);
        total = (EditText) findViewById(R.id.totalcost1);
        addpro=(Button) findViewById(R.id.addpro);
        addpro.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
/*
                newreadf = Float.parseFloat(String.valueOf(odometer));
                oldreadf = Float.parseFloat(String.valueOf(l_odometer));
                fuelf = Float.parseFloat(String.valueOf(price));
                pricef = Float.parseFloat(String.valueOf(total));

                averagef = (newreadf - oldreadf) / fuelf;
                priceAvgf = averagef / pricef;

                new_reading = Float.toString(newreadf);

                price = Float.toString(pricef);
                average = Float.toString(averagef);
                priceAvg = Float.toString(priceAvgf); */

            }
        });
        Spinner spino = findViewById(R.id.fuletype);



        spino.setOnItemSelectedListener(this);

        // Create the instance of ArrayAdapter
        // having the list of courses
        ArrayAdapter ad
                = new ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                courses);

        // set simple layout resource file
        // for each item of spinner
        ad.setDropDownViewResource(
                android.R.layout
                        .simple_spinner_dropdown_item);

        // Set the ArrayAdapter (ad) data on the
        // Spinner which binds data to spinner
        spino.setAdapter(ad);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }



}