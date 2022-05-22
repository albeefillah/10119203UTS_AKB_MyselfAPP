/*
 *     Tanggal Pengerjaan : 17/5/2022
 *     Nim : 10119203
 *     Nama : Albee Akbar Fillah
 */

package com.albee.myselfapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.widget.Toast;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity{

    MeowBottomNavigation bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigation = findViewById(R.id.bottom_nav);
        bottomNavigation.add(new MeowBottomNavigation.Model(1, R.drawable.home));
        bottomNavigation.add(new MeowBottomNavigation.Model(2, R.drawable.daily));
        bottomNavigation.add(new MeowBottomNavigation.Model(3, R.drawable.gallery));
        bottomNavigation.add(new MeowBottomNavigation.Model(4, R.drawable.media));
        bottomNavigation.add(new MeowBottomNavigation.Model(5, R.drawable.profile));
//        loadFragment (new HomeFragment());
//        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);
//        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        bottomNavigation.setOnShowListener(new MeowBottomNavigation.ShowListener() {
            @Override
            public void onShowItem(MeowBottomNavigation.Model item) {
                Fragment fragment = null;
                if (item.getId() == 1) {
                    fragment = new HomeFragment();
                } else if (item.getId() == 2) {
                    fragment = new DailyFragment();
                } else if (item.getId() == 3) {
                    fragment = new GalleryFragment();
                } else if (item.getId() == 4) {
                    fragment = new MediaFragment();
                } else if (item.getId() == 5) {
                    fragment = new ProfilFragment();
                }

                loadFragment(fragment);
            }
        });

        bottomNavigation.show(1, true);

        bottomNavigation.setOnClickMenuListener(new MeowBottomNavigation.ClickListener() {
            @Override
            public void onClickItem(MeowBottomNavigation.Model item) {
                String selected = null;
                if (item.getId() == 1) {
                    selected = "Home";
                } else if (item.getId() == 2) {
                    selected = "Daily Activity";
                } else if (item.getId() == 3) {
                    selected = "Gallery";
                } else if (item.getId() == 4) {
                    selected = "Music & Video";
                } else if (item.getId() == 5) {
                    selected = "Profile";
                }
                Toast.makeText(getApplicationContext(), selected, Toast.LENGTH_SHORT).show();
            }
        });

        bottomNavigation.setOnReselectListener(new MeowBottomNavigation.ReselectListener() {
            @Override
            public void onReselectItem(MeowBottomNavigation.Model item) {
                Toast.makeText(getApplicationContext(), " You Reselected " + item.getId(), Toast.LENGTH_SHORT).show();
            }
        });

    }


    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frameContainer, fragment, null)
                .commit();
    }

}