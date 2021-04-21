package com.neda.carwarehouse;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;


import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.neda.carwarehouse.databinding.CoordinatorLayoutBinding;
import com.neda.carwarehouse.entity.Car;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private CoordinatorLayoutBinding binding;
    //private CarInfoFormBinding carInfoFormBinding;

    private FloatingActionButton fab;
    private EditText maker;
    private EditText modle;
    private EditText year;
    private EditText color;
    private EditText seats;
    private EditText price;
    private ListView listView;
    private ArrayList<Car> cars = new ArrayList<>();
    private ArrayList<String> carsString = new ArrayList<>();
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //setContentView(R.layout.coordinator_layout);
        binding = CoordinatorLayoutBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        // get binding for included layouts
        // carInfoFormBinding = carInfoFormBinding.bind(view);
        maker = binding.carInfoForm.edMaker;
        modle = binding.carInfoForm.etModle;
        year = binding.carInfoForm.etYear;
        color = binding.carInfoForm.etColor;
        price = binding.carInfoForm.etPrice;
        seats = binding.carInfoForm.etSeats;
        listView = binding.carInfoForm.listview;
        adapter = new ArrayAdapter<>(this,R.layout.textview_for_listview,carsString);
        listView.setAdapter(adapter);

        fab = binding.fab;
        fab.setOnClickListener(v -> {
            Car car = makeCar();
            cars.add(car);
            carsString.add(car.toString());
            adapter.notifyDataSetChanged();
        });
    }

    @Contract(" -> new")
    private @NotNull Car makeCar(){
        return new Car(maker.getText().toString(),
                modle.getText().toString(),
                year.getText().toString(),
                color.getText().toString(),
                seats.getText().toString(),
                price.getText().toString());
    }
}