package com.example.auctionhub;


import android.content.Context;

import java.util.List;

public class Fuel {

    private String DID;
    private String date;
    private String time;
    private String odometer;
    private String totalcost;
    private String liter;
    private Context context;

    public Fuel(Context context) {
        this.context = context;

    }

    public String getDID() {
        return DID;
    }

    public void setDID(String DID) {
        this.DID = DID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getOdometer() {
        return odometer;
    }

    public void setOdometer(String odometer) {
        this.odometer = odometer;
    }

    public String getTotalcost() {
        return totalcost;
    }

    public void setTotalcost(String totalcost) {
        this.totalcost = totalcost;
    }

    public String getLiter() {
        return liter;
    }

    public void setLiter(String liter) {
        this.liter = liter;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public Fuel(String did1, String date1, String time1, String odometer1, String totalcost1, String liter1) {

DID=did1;
date=date1;
time=time1;
odometer=odometer1;
totalcost=totalcost1;
liter=liter1;



    }



}


