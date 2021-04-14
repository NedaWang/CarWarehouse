package com.neda.carwarehouse;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.neda.carwarehouse.databinding.CarInfoFormBinding;
import com.neda.carwarehouse.databinding.CoordinatorLayoutBinding;

public class MainActivity extends AppCompatActivity {

    private @NonNull CoordinatorLayoutBinding binding = CoordinatorLayoutBinding.inflate(getLayoutInflater());;
    private CarInfoFormBinding carInfoFormBinding;

    private FloatingActionButton fab;
    private EditText maker;
    private EditText modle;
    private EditText year;
    private EditText color;
    private EditText seats;
    private EditText price;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //setContentView(R.layout.coordinator_layout);
        View view = binding.getRoot();
        setContentView(view);

        // get binding for included layouts
        carInfoFormBinding = carInfoFormBinding.bind(view);
        maker = carInfoFormBinding.edMaker;
        modle = carInfoFormBinding.etModle;
        year = carInfoFormBinding.etYear;
        color = carInfoFormBinding.etColor;
        price = carInfoFormBinding.etPrice;
        seats = carInfoFormBinding.etSeats;

        fab = binding.fab;
        fab.setOnClickListener(v -> Snackbar.make(v,"Hello", Snackbar.LENGTH_SHORT).show());
    }

    private String getCarInfoString(){
        return maker.getText().toString() + " |" +
                modle.getText().toString() + " |" +
                year.getText().toString() + " |" +
                color.getText().toString() + " |" +
                seats.getText().toString() + " |" +
                price.getText().toString();
    }
}