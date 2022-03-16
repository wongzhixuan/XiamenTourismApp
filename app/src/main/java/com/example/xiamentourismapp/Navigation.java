package com.example.xiamentourismapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class Navigation extends AppCompatActivity {
    int nav_item_index = 0;
   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        // link widgets
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnItemSelectedListener(navListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ExploreFragment()).commit();
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(0);
        menuItem.setChecked(true);

       // retrieve session details
       SessionManager sessionManager = new SessionManager(getApplicationContext());
       String userEmail = sessionManager.getCurrentUserEmail();
       if ( userEmail ==  null){
           Toast.makeText(Navigation.this, "You haven't login!",Toast.LENGTH_SHORT).show();
           loadRegister();
       }

    }
    private NavigationBarView.OnItemSelectedListener navListener = new NavigationBarView.OnItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFrag = null;
            switch (item.getItemId()) {
                case R.id.nav_explore:
                    selectedFrag = new ExploreFragment();
                    nav_item_index = 0;
                    break;
                case R.id.nav_placetostay:
                    selectedFrag = new PlacesFragment();
                    nav_item_index = 1;
                    break;
                case R.id.nav_food:
                    selectedFrag = new FoodFragment();
                    nav_item_index = 2;
                    break;
                case R.id.nav_profile:
                    selectedFrag = new ProfileFragment();
                    nav_item_index = 3;
                    break;

            }
            BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
            Menu menu = bottomNavigationView.getMenu();
            MenuItem menuItem = menu.getItem(nav_item_index);
            menuItem.setChecked(true);
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFrag).commit();
            return false;
        }
    };
    public void loadRegister(){
        Intent intent = new Intent(Navigation.this, Register.class);
        startActivity(intent);
    }

}