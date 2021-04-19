package com.neda.carwarehouse;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.navigation.NavigationView;
import com.neda.carwarehouse.databinding.ActivityNavDrawerBinding;

public class NavDrawerActivity extends AppCompatActivity {

    ActivityNavDrawerBinding binding;

    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityNavDrawerBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        navigationView = binding.navView;
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.go_to_recycler_view){
                    Intent intent = new Intent(NavDrawerActivity.this, RecyclerViewActivity.class);
                    startActivity(intent);
                }
                return true;
            }
        });


    }
}