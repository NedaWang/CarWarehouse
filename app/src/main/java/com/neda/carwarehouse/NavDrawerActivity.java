package com.neda.carwarehouse;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;

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
    private ConstraintLayout constraintLayout;


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

        viewModel = new ViewModelProvider(this).get(NavDrawerViewModel.class);

        bindViews();
        setToolbar();
        defineNavDrawerItems();
        getSupportActionBar().setTitle("Car Warehouse");

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.addCar(createCar());
            }
        });



//        constraintLayout.setOnTouchListener(new View.OnTouchListener() {
//            float x = 0;
//            float y = 0;
//            float price_f = 0;
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                switch (event.getActionMasked()){
//                    case MotionEvent.ACTION_DOWN:
//                        x = event.getRawX();
//                        y = event.getRawY();
//                        Log.d("Week10Log","down, "+event.getRawX()+", "+event.getRawY());
//                        return true;
//                    case MotionEvent.ACTION_MOVE:
//                        price_f += event.getRawY();
//                        Log.d("Week10Log","move, "+event.getRawX()+", "+event.getRawY());
//                        return true;
//                    case MotionEvent.ACTION_UP:
//                        Log.d("Week10Log","up, "+(Math.abs(event.getRawX() - x))+", "+(y-event.getRawY())+", y="+y+", newY="+event.getRawY());
//
//                        if ((Math.abs(event.getRawX() - x) <50) && (y-event.getRawY()) >50){
//                            price.setText(""+price_f);
//                            //viewModel.addCar(createCar());
//                            return true;
//                        }
//                    default:
//                        return false;
//                }
//            }
//        });


    }

    Car createCar(){
        return new Car(maker.getText().toString(),
                model.getText().toString(),
                year.getText().toString(),
                color.getText().toString(),
                seats.getText().toString(),
                price.getText().toString());
    }

    void bindViews(){

        binding = ActivityNavDrawerBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        fab = binding.coordinatorLayout.fab;
        maker = binding.coordinatorLayout.carInfoForm.etMaker;
        model = binding.coordinatorLayout.carInfoForm.etModel;
        year = binding.coordinatorLayout.carInfoForm.etYear;
        color = binding.coordinatorLayout.carInfoForm.etColor;
        seats = binding.coordinatorLayout.carInfoForm.etSeats;
        price = binding.coordinatorLayout.carInfoForm.etPrice;

        toolbar = binding.coordinatorLayout.toolbar;
        drawerLayout = binding.drawerLayout;
        navigationView = binding.navView;
        constraintLayout = binding.coordinatorLayout.carInfoForm.carInfoFormConstraintLayout;

    }

    void setToolbar(){
        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }

    void defineNavDrawerItems(){
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
                        viewModel.deleteAllCars();
                        break;
                    case R.id.go_to_gesture:
                        Intent intent2 = new Intent(NavDrawerActivity.this, GestureActivity.class);
                        startActivity(intent2);
                        break;
                    case R.id.go_to_scale:
                        Intent intent3 = new Intent(NavDrawerActivity.this, ScaleActivity.class);
                        startActivity(intent3);
                        break;
                    case R.id.go_to_multi:
                        Intent intent4 = new Intent(NavDrawerActivity.this, MultiPointerActivity.class);
                        startActivity(intent4);
                        break;
                }
                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    /*
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        switch (itemId){
            case R.id.op_clear_field:
                maker.setText("");
                model.setText("");
                year.setText("");
                color.setText("");
                seats.setText("");
                price.setText("");
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    */

}