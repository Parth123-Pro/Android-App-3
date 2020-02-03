package com.example.auctionhub;

import android.content.Context;
import android.widget.Button;

public class Auction {
    private static String AuctionBidNow;
    private String Title;
    private String Price;
    private String Detail;
    private int Thumbnail;
    private Button buttonAdd;
    private  Context context;

  public Auction(Context context) {
        this.context = context;

    }




   /* public void setButton(long button) {
        this.button = button;
    }*/





    public Auction(String title, String price, String detail, int thumbnail) {
        Title = title;
        Price = price;
        Detail = detail;
        Thumbnail = thumbnail;

       // buttonAdd = button;

    }
    public Auction(String titlebidnow){
        AuctionBidNow = titlebidnow;
    }

    public Auction() {

    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }


    public static String getTitleBidNow() {
        return AuctionBidNow;
    }

    public String getDetail() {
        return Detail;
    }

    public void setDetail(String detail) {
        Detail = detail;
    }

    public int getThumbnail() {
        return Thumbnail;
    }
    public Button getButton() {
        return buttonAdd;
    }
    public void setThumbnail(int thumbnail) {
        Thumbnail = thumbnail;
    }
}
