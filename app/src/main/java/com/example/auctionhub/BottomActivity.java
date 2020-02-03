package com.example.auctionhub;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class BottomActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom);
        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom1);
        bottomNavigationView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame1,new HomeFragment()).commit();
    }
    private BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener=new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment fragment=null;
            switch (menuItem.getItemId())
            {
                case R.id.navigation_home:
                    fragment=new HomeFragment(

                    );
                    break;
                case R.id.navigation_history:
                    fragment=new HistoryFragment();
                    break;
                case R.id.navigation_chat:
                    fragment=new ChatFragment();
                    break;
                case R.id.navigation_user:
                    fragment=new UserFragment();
                    break;

            }
            getSupportFragmentManager().beginTransaction().replace(R.id.frame1,fragment).commit();
            return true;


        }
    };
}
