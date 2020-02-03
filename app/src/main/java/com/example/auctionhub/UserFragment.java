package com.example.auctionhub;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.fragment.app.Fragment;

import com.example.auctionhub.Sesson.SessionManager;

public class UserFragment extends Fragment {

    Button l1;
    TextView name,email;
    SessionManager sessionManager;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View  v = inflater.inflate(R.layout.fragment_user, container, false);
        sessionManager=new SessionManager(getActivity());


        name=v.findViewById(R.id.username);
        email=v.findViewById(R.id.useremail);
        l1=v.findViewById(R.id.logbtn);

        Intent intent=getActivity().getIntent();
        String extra_name=intent.getStringExtra("name");
        String extra_email=intent.getStringExtra("email");
        name.setText(extra_name);
        email.setText(extra_email);

        l1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sessionManager.logout();



            }
        });

        return v;
    }





}








