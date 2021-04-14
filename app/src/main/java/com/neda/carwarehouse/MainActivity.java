package com.neda.carwarehouse;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.neda.carwarehouse.databinding.CarInfoFormBinding;
import com.neda.carwarehouse.databinding.CoordinatorLayoutBinding;

public class MainActivity extends AppCompatActivity {

    private @NonNull CoordinatorLayoutBinding binding;

    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //setContentView(R.layout.coordinator_layout);
        binding = CoordinatorLayoutBinding.inflate(getLayoutInflater());

        View view = binding.getRoot();
        setContentView(view);

        fab = binding.fab;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v,"Hello", Snackbar.LENGTH_SHORT).show();
            }
        });

    }
}