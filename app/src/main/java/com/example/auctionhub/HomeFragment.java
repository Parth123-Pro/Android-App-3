package com.example.auctionhub;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


import java.util.ArrayList;
import java.util.HashMap;


public class HomeFragment extends Fragment  {
    View v;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v=inflater.inflate(R.layout.fragment_home,container,false);
        DbHandler db = new DbHandler(getContext());
        ArrayList<HashMap<String, String>> userList = db.GetAverage();
        ListView lv = (ListView)v.findViewById(R.id.average_list);
        ListAdapter adapter = new SimpleAdapter(getContext(), userList, R.layout.list_average,new String[]{"date","time","DId2","liter","average"}, new int[]{R.id.date, R.id.time, R.id.did1,R.id.liter,R.id.average});
        lv.setAdapter(adapter);
        return v;


    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
}
