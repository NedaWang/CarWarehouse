package com.neda.carwarehouse;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.neda.carwarehouse.databinding.ActivityNavDrawerBinding;
import com.neda.carwarehouse.entity.Car;
import com.neda.carwarehouse.viewmodel.NavDrawerViewModel;

public class NavDrawerActivity extends AppCompatActivity {

    ActivityNavDrawerBinding binding;

    private NavigationView navigationView;
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;

    private NavDrawerViewModel viewModel;

    private FloatingActionButton fab;
    private EditText maker;
    private EditText model;
    private EditText year;
    private EditText color;
    private EditText seats;
    private EditText price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityNavDrawerBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        viewModel = new ViewModelProvider(this).get(NavDrawerViewModel.class);

        fab = binding.coordinatorLayout.fab;
        maker = binding.coordinatorLayout.carInfoForm.etMaker;
        model = binding.coordinatorLayout.carInfoForm.etModel;
        year = binding.coordinatorLayout.carInfoForm.etYear;
        color = binding.coordinatorLayout.carInfoForm.etColor;
        seats = binding.coordinatorLayout.carInfoForm.etSeats;
        price = binding.coordinatorLayout.carInfoForm.etPrice;

        toolbar = binding.coordinatorLayout.toolbar;
        setSupportActionBar(toolbar);

        drawerLayout = binding.drawerLayout;

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = binding.navView;
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id){
                    case R.id.go_to_recycler_view:
                        Intent intent = new Intent(NavDrawerActivity.this, RecyclerViewActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.add_car:
                        viewModel.addCar(createCar());
                        break;
                    case R.id.remove_last_car:
                        break;
                    case R.id.remove_all_cars:
                        break;
                }
                return true;
            }
        });
    }

    Car createCar(){
        return new Car(maker.getText().toString(),
                model.getText().toString(),
                year.getText().toString(),
                color.getText().toString(),
                seats.getText().toString(),
                price.getText().toString());
    }
}