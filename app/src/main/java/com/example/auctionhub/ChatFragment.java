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

public class ChatFragment extends Fragment {
View v;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v=inflater.inflate(R.layout.fragment_chat,container,false);
        DbHandler db = new DbHandler(getContext());
        ArrayList<HashMap<String, String>> userList = db.GetUsers();
        ListView lv = (ListView)v.findViewById(R.id.user_list);
        ListAdapter adapter = new SimpleAdapter(getContext(), userList, R.layout.list_user,new String[]{"name","phone","licence"}, new int[]{R.id.name, R.id.phone, R.id.licence});
        lv.setAdapter(adapter);
        return v;


    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
}
