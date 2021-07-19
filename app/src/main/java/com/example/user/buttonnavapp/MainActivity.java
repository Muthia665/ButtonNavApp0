 package com.example.user.buttonnavapp;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.user.buttonnavapp.fragment.HomeFragment;
import com.example.user.buttonnavapp.fragment.NewsFragment;
import com.example.user.buttonnavapp.fragment.ProfileFragment;

 public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    Fragment fragment;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.inflateMenu(R.menu.bottom_navigations_item);

        fragmentManager = getSupportFragmentManager();

        //untuk inisialisasi fragmenbt pertamakali
        fragmentManager.beginTransaction().replace(R.id.main_container, new HomeFragment()).commit();

        //Memberikan listener(aksi) saat menu item di bottom navigation di klik
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();

                switch (id){
                    case R.id.menu_home:
                        fragment = new HomeFragment();
                        break;
                    case R.id.menu_profile:
                        fragment = new ProfileFragment();
                        break;
                    case R.id.menu_news:
                        fragment = new NewsFragment();
                        break;
                }

                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.main_container, fragment).commit();
                return true;
            }
        });


    }
}
