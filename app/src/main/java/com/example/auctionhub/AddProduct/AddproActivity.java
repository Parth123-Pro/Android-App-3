package com.example.auctionhub.AddProduct;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.auctionhub.DbHandler;
import com.example.auctionhub.R;

import java.text.DecimalFormat;

public class AddproActivity extends AppCompatActivity {


    EditText did1, date, time;
    Button addpro,addbtn;
    DbHandler DB;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addpro);
        did1 = (EditText) findViewById(R.id.y_did);
        date = (EditText) findViewById(R.id.date);
        time = (EditText) findViewById(R.id.time);
        addpro = (Button) findViewById(R.id.addpro);
        addbtn = (Button) findViewById(R.id.addbtn);

        DB = new DbHandler(this);

                addpro.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        DecimalFormat formatVal = new DecimalFormat("##.##");
                        EditText pricel = (EditText) findViewById(R.id.priceperl);
                        TextView totalcost = (TextView) findViewById(R.id.totalcost1);
                        double pricell = Double.parseDouble(pricel.getText().toString());
                        double totalcosttt = Double.parseDouble(totalcost.getText().toString());
                        double totallitter = totalcosttt/pricell;
                        TextView liters = (TextView) findViewById(R.id.totalliter);
                        liters.setText(formatVal.format(totallitter));
                        EditText beforeOdo = (EditText) findViewById(R.id.lastodometer);
                        TextView fuelInLitres = (TextView) findViewById(R.id.totalliter);
                        EditText finalOdo = (EditText) findViewById(R.id.odometer);
                        double beforeOdoval = Double.parseDouble(beforeOdo.getText().toString());
                        double fuel = Double.parseDouble(fuelInLitres.getText().toString());
                        double afterodo = Double.parseDouble(finalOdo.getText().toString());
                        double mileage = (afterodo-beforeOdoval) / fuel;
                        TextView result = (TextView) findViewById(R.id.average);
                        result.setText(formatVal.format(mileage));
                        Toast.makeText(getApplicationContext(), "Mileage Calculated Succesfully and Displayed", Toast.LENGTH_LONG).show();


                    }});

                addbtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        String date1 = date.getText().toString();
                        String time1 = time.getText().toString();
                        String did11= did1.getText().toString();
                     //   double codometer1= finalOdoval.getText();
                     //   String lodometer1= did.getText().toString();
                      //  String price1= did.getText().toString();
                      //  String totalPrice1= did.getText().toString();
                     //   String liter1= did.getText().toString();
                     //   String average1= did.getText().toString();

                     /*   Boolean checkinsertdata=DB.averagedata();
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