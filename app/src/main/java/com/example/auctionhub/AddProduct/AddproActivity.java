package com.example.auctionhub.AddProduct;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.auctionhub.DbHandler;
import com.example.auctionhub.R;
import com.example.auctionhub.Registration.RegistrationActivity;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Locale;

public class AddproActivity extends AppCompatActivity {


    EditText did1, date, time;
    Button addpro,addbtn;
    TextView liters,average;
    DbHandler DB;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addpro);
        final Calendar myCalendar = Calendar.getInstance();

        date = (EditText) findViewById(R.id.date);
        final DatePickerDialog.OnDateSetListener date1 = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }

            private void updateLabel() {

                String myFormat = "MM/dd/yy"; //In which you need put here
                SimpleDateFormat sdf = null;
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                    sdf = new SimpleDateFormat(myFormat, Locale.US);
                }

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    date.setText(sdf.format(myCalendar.getTime()));
                }
            }

        };
        date.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(AddproActivity.this, date1, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });


        time = (EditText) findViewById(R.id.time);
        did1 = (EditText) findViewById(R.id.y_did);
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

                        liters = (TextView) findViewById(R.id.totalliter);
                        liters.setText(formatVal.format(totallitter));
                        EditText beforeOdo = (EditText) findViewById(R.id.lastodometer);
                        TextView fuelInLitres = (TextView) findViewById(R.id.totalliter);
                        EditText finalOdo = (EditText) findViewById(R.id.odometer);
                        double beforeOdoval = Double.parseDouble(beforeOdo.getText().toString());
                        double fuel = Double.parseDouble(fuelInLitres.getText().toString());
                        double afterodo = Double.parseDouble(finalOdo.getText().toString());

                        double mileage = (afterodo-beforeOdoval) / fuel;

                        average = (TextView) findViewById(R.id.average);
                        average.setText(formatVal.format(mileage));
                        Toast.makeText(getApplicationContext(), "Mileage Calculated Succesfully and Displayed", Toast.LENGTH_LONG).show();


                    }});

                addbtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        String date1 = date.getText().toString()+"\n";
                        String time1 = time.getText().toString();
                        String Did1 = did1.getText().toString();
                        String liter1 = liters.getText().toString();
                        String average1 = average.getText().toString();
                        DbHandler dbHandler = new DbHandler(AddproActivity.this);
                        dbHandler.insertAverageDetails(date1,time1,Did1,liter1,average1);
                        Toast.makeText(getApplicationContext(), "Details Inserted Successfully",Toast.LENGTH_SHORT).show();


                    }
                });

}


}