package com.example.auctionhub;

import android.database.Cursor;
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
    ArrayList<Driver> dataholder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      //  return super.onCreateView(R.layout.fragment_home, container, savedInstanceState);
        v= inflater.inflate(R.layout.fragment_chat,container,false);

        RecyclerView myrecyclerView = (RecyclerView) v.findViewById(R.id.drecyclerview);
        myrecyclerView.setLayoutManager(new GridLayoutManager(getContext(),3));

        DriverRecycler adapter=new DriverRecycler(dataholder);
        myrecyclerView.setAdapter(adapter);

        return v;

    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Cursor cursor=new DBHelper(getContext()).readallData();
        while(cursor.moveToNext())
        {
            Driver obj=new Driver(cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4));
            dataholder.add(obj);
        }







    }
}
