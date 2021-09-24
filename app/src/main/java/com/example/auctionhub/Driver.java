package com.example.auctionhub;

import android.content.Context;

public class Driver {

    private String name1;
    private String licence;
    private String phone;
    private Context context;

    public String getName1() {
        return name1;
    }

    public String getLicence() {
        return licence;
    }

    public String getPhone() {
        return phone;
    }

    public Context getContext() {
        return context;
    }

    public Driver(String name11, String licence1, String phone1){
        name1=name11;
        licence=licence1;
        phone=phone1;
    }

}
