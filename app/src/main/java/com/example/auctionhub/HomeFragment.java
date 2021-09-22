package com.example.auctionhub;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.auctionhub.AddProduct.AddproActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment  {

    View v;
    private List<Fuel> fuel;





    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v=inflater.inflate(R.layout.fragment_home,container,false);
        RecyclerView myrecyclerView = (RecyclerView) v.findViewById(R.id.homerecycle1);

        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getContext(),fuel);
        myrecyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
        myrecyclerView.setAdapter(recyclerViewAdapter);


        return v;


    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fuel = new ArrayList<>();
        fuel.add(new Fuel("12345","01/01/2021","12:00AM","1000KM","$1000","45.0L"));
        fuel.add(new Fuel("22345","01/01/2021","12:00AM","1000KM","$1000","45.0L"));
        fuel.add(new Fuel("32345","01/01/2021","12:00AM","1000KM","$1000","45.0L"));
        fuel.add(new Fuel("42345","01/01/2021","12:00AM","1000KM","$1000","45.0L"));
        fuel.add(new Fuel("52345","01/01/2021","12:00AM","1000KM","$1000","45.0L"));
        fuel.add(new Fuel("62345","01/01/2021","12:00AM","1000KM","$1000","45.0L"));



    }
}




