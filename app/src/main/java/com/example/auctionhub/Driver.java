package com.example.auctionhub;

import android.content.Context;

public class Driver {

    private String name1;
    private String licence;
    private String phone;
    private String did;
    private Context context;

    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public void setLicence(String licence) {
        this.licence = licence;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setContext(Context context) {
        this.context = context;
    }

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

    public Driver(String name11, String licence1, String phone1,String did1){
        name1=name11;
        licence=licence1;
        phone=phone1;
        did=did1;
    }

}
