package com.example.auctionhub;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.auctionhub.AddProduct.AddproActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class BottomActivity extends AppCompatActivity {
  FloatingActionButton floatingActionButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom);
        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom1);
        floatingActionButton=findViewById(R.id.floatingActionButton);
        bottomNavigationView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame1,new HomeFragment()).commit();

        floatingActionButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                Intent i=new Intent(getApplicationContext(),AddproActivity.class);
                startActivity(i);
            }
        });
    }


    private final BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener=new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment fragment=null;
            switch (menuItem.getItemId())
            {
                case R.id.navigation_home:
                    fragment=new HomeFragment();
                    break;

                case R.id.navigation_chat:
                    fragment=new ChatFragment();
                    break;


            }
            assert fragment != null;
            getSupportFragmentManager().beginTransaction().replace(R.id.frame1,fragment).commit();
            return true;


        }
    };
}
