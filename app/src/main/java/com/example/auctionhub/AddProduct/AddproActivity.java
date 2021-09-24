package com.example.auctionhub.AddProduct;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.auctionhub.R;

import java.text.DecimalFormat;

public class AddproActivity extends AppCompatActivity {


    EditText did, date, time;
    Button addpro,addlit,addbtn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addpro);

        did = (EditText) findViewById(R.id.y_did);
        date = (EditText) findViewById(R.id.date);
        time = (EditText) findViewById(R.id.time);
        addpro = (Button) findViewById(R.id.addpro);
        addlit = (Button) findViewById(R.id.btncalc);
        addbtn = (Button) findViewById(R.id.addbtn);



        addlit.setOnClickListener(new View.OnClickListener()
        {
                                      @Override
                                      public void onClick(View v)
                                      {

                                          EditText pricel = (EditText) findViewById(R.id.priceperl);
                                          TextView totalcost = (TextView) findViewById(R.id.totalcost1);

                                          double pricell = Double.parseDouble(pricel.getText().toString());
                                          double totalcosttt = Double.parseDouble(totalcost.getText().toString());

                                          double totallitter = totalcosttt/pricell;
                                          DecimalFormat formatVal = new DecimalFormat("##.##");
                                          TextView liters = (TextView) findViewById(R.id.totalliter);
                                          liters.setText(formatVal.format(totallitter));
                                          Toast.makeText(getApplicationContext(), "Total Liter Calculated Succesfully and displayed", Toast.LENGTH_LONG).show();

                                      }
        });

                addpro.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        EditText beforeOdo = (EditText) findViewById(R.id.lastodometer);
                        TextView fuelInLitres = (TextView) findViewById(R.id.totalliter);
                        EditText finalOdo = (EditText) findViewById(R.id.odometer);
                        double beforeOdoval = Double.parseDouble(beforeOdo.getText().toString());
                        double fuel = Double.parseDouble(fuelInLitres.getText().toString());
                        double afterodo = Double.parseDouble(finalOdo.getText().toString());
                        double mileage = (afterodo-beforeOdoval) / fuel;
                        DecimalFormat formatVal = new DecimalFormat("##.##");
                        TextView result = (TextView) findViewById(R.id.average);
                        result.setText(formatVal.format(mileage));
                        Toast.makeText(getApplicationContext(), "Mileage Calculated Succesfully and displayed", Toast.LENGTH_LONG).show();


                    }});

                addbtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                });

}
}