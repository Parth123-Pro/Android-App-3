package com.example.auctionhub;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.auctionhub.R;

import java.util.ArrayList;
import java.util.List;

public class ChatFragment extends Fragment {

    View v;
    private List<Driver> driver;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      //  return super.onCreateView(R.layout.fragment_home, container, savedInstanceState);
        v= inflater.inflate(R.layout.fragment_chat,container,false);

        RecyclerView myrecyclerView = (RecyclerView) v.findViewById(R.id.drecyclerview);

        DriverRecycler recyclerViewAdapter = new DriverRecycler(getContext(),driver);
        myrecyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
        myrecyclerView.setAdapter(recyclerViewAdapter);


        return v;

    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        driver = new ArrayList<>();
        driver.add(new Driver("Parth","990909090","0000099888"));
        driver.add(new Driver("Harsh","990909090","0000099888"));
        driver.add(new Driver("Nandan","990909090","0000099888"));
        driver.add(new Driver("Om","990909090","0000099888"));
        driver.add(new Driver("Popat","990909090","0000099888"));
        driver.add(new Driver("Jetha","990909090","0000099888"));
        driver.add(new Driver("Mehta","990909090","0000099888"));






    }
}
