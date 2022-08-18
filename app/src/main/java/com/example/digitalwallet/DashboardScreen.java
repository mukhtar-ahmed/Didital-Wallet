package com.example.digitalwallet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class DashboardScreen extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    AmountFragment amountFragment = new AmountFragment();
    WalletFragment walletFragment = new WalletFragment();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_dashboard_screen);

        Toolbar toolbar = findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);

        bottomNavigationView = findViewById(R.id.bottom_nav);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,amountFragment).commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected( MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.money:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,amountFragment).commit();
                        return true;
                    case R.id.wallet:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,walletFragment).commit();
                        return true;
                }
                return false;
            }
        });
    }
}