package com.example.hackathon_event;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView; // create a variable for bottom navigation

    HomeFragment homeFragment = new HomeFragment(); // create instance of Home fragment
    ExploreFragment exploreFragment = new ExploreFragment();
    RegisterFragment1 registerFragment1 = new RegisterFragment1();
    FeedbackFragment feedbackFragment = new FeedbackFragment();
    @Override
   protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_nav); // put the value of the bottom nav, finding it from the view, assign it

        getSupportFragmentManager().beginTransaction()  //handle those fragments
                .add(R.id.container, homeFragment, "homeFragment")
                .add(R.id.container, exploreFragment, "exploreFragment").hide(exploreFragment)
                .add(R.id.container, registerFragment1, "registerFragment1").hide(registerFragment1)
                .add(R.id.container, feedbackFragment, "feedbackFragment").hide(feedbackFragment)
                .commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if(id == R.id.home){
                    getSupportFragmentManager().beginTransaction().hide(exploreFragment).hide(registerFragment1).hide(feedbackFragment).show(homeFragment).commit();
                    return true;
                }else if(id == R.id.explore){
                    getSupportFragmentManager().beginTransaction().hide(homeFragment).hide(feedbackFragment).hide(registerFragment1).show(exploreFragment).commit();
                    return true;
                }else if(id == R.id.register){
                    getSupportFragmentManager().beginTransaction().hide(homeFragment).hide(exploreFragment).hide(feedbackFragment).show(registerFragment1).commit();
                    return true;
                }else if(id == R.id.feedback){
                    getSupportFragmentManager().beginTransaction().hide(homeFragment).hide(exploreFragment).hide(registerFragment1).show(feedbackFragment).commit();
                    return true;
                }
                return false;
            }
        });

    }
//
//        public void navigationToRegisterFragment() {
//            bottomNavigationView.setSelectedItemId(R.id.register);
//        }
}






//public class MainActivity extends AppCompatActivity {

//    BottomNavigationView bottomNavigationView;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        bottomNavigationView = findViewById(R.id.bottom_nav);
//        bottomNavigationView.setSelectedItemId(R.id.home);
//
//        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                int id = item.getItemId();
//
//                if(id == R.id.home){
//                    return true;
//                } else if (id == R.id.explore) {
//                    startActivity(new Intent(getApplicationContext(), ExploreActivity.class));
//                    finish();
//                    overridePendingTransition(0, 0);
//                    return true;
//                }
//                return false;
//            }
//        });
//    }
//}