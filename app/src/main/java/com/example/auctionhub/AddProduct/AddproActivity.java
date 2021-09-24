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

import com.example.auctionhub.DBHelper;
import com.example.auctionhub.R;
import com.example.auctionhub.Registration.RegistrationActivity;

import java.text.DecimalFormat;

public class AddproActivity extends AppCompatActivity {


    EditText did1, date, time;
    Button addpro,addlit,addbtn;
    DBHelper DB;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addpro);

        did1 = (EditText) findViewById(R.id.y_did);
        date = (EditText) findViewById(R.id.date);
        time = (EditText) findViewById(R.id.time);
        addpro = (Button) findViewById(R.id.addpro);
        addlit = (Button) findViewById(R.id.btncalc);
        addbtn = (Button) findViewById(R.id.addbtn);

        DB = new DBHelper(this);


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
/*
                        String date1 = date.getText().toString();
                        String time1 = time.getText().toString();
                        String did11= did1.getText().toString();
                        String codometer1= .getText().toString();
                        String lodometer1= did.getText().toString();
                        String price1= did.getText().toString();
                        String totalPrice1= did.getText().toString();
                        String liter1= did.getText().toString();
                        String average1= did.getText().toString();

                        Boolean checkinsertdata=DB.insertuserdata(name1,phone1,licence1,did1);
                        if(checkinsertdata){
                            Toast.makeText(AddproActivity.this,"New Entry Added",Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(AddproActivity.this,"New Entry Not Added",Toast.LENGTH_SHORT).show();

                        }*/

                    }
                });

}
}