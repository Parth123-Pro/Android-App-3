package com.example.auctionhub;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.auctionhub.AddProduct.AddproActivity;
import com.example.auctionhub.Login.LoginActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment  {

    View v;
    private RecyclerView myrecyclerView;
    private List<Auction> auctions;

FloatingActionButton flotbtn;

/*ntext c;

    public HomeFragment(Context c) {
        this.c = c;
    }*/

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v=inflater.inflate(R.layout.fragment_home,container,false);
        myrecyclerView=(RecyclerView) v.findViewById(R.id.homerecycle1);
        flotbtn=(FloatingActionButton)v.findViewById(R.id.floatingActionButton);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getContext(),auctions);
        myrecyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
        myrecyclerView.setAdapter(recyclerViewAdapter);

        flotbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
Intent i=new Intent(getContext(),AddproActivity.class);
startActivity(i);
           }
        });

        return v;


    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        auctions = new ArrayList<>();
        auctions.add(new Auction("RELAX SOFA","45000(KWD)","There are few survivals of ancient Greek and Roman Sofa, but a number of images in reliefs, painted pottery and other media. It was normally made of wood, but expensive examples were often fitted with metalwork elements, which have a better chance of survival. ",R.drawable.p1));
        auctions.add(new Auction("CHAIR","8500(KWD)","There are few survivals of ancient Greek and Roman Chair, but a number of images in reliefs, painted pottery and other media. It was normally made of wood, but expensive examples were often fitted with metalwork elements, which have a better chance of survival. ",R.drawable.p2));
        auctions.add(new Auction("LAMP","7000(KWD)","There are few survivals of ancient Greek and Roman Lamp, but a number of images in reliefs, painted pottery and other media. It was normally made of wood, but expensive examples were often fitted with metalwork elements, which have a better chance of survival. ",R.drawable.p5));
        auctions.add(new Auction("CONTAINER","4000(KWD)","There are few survivals of ancient Greek and Roman Container, but a number of images in reliefs, painted pottery and other media. It was normally made of wood, but expensive examples were often fitted with metalwork elements, which have a better chance of survival. ",R.drawable.p4));
        auctions.add(new Auction("SOFA","22000(KWD)","There are few survivals of ancient Greek and Roman Big Sofa, but a number of images in reliefs, painted pottery and other media. It was normally made of wood, but expensive examples were often fitted with metalwork elements, which have a better chance of survival. ",R.drawable.p6));


    }
}




