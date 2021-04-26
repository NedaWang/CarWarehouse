package com.neda.carwarehouse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.neda.carwarehouse.adapter.RecyclerAdapter;
import com.neda.carwarehouse.databinding.ActivityRecyclerViewBinding;
import com.neda.carwarehouse.entity.Car;
import com.neda.carwarehouse.provider.Repository;
import com.neda.carwarehouse.viewmodel.RecyclerViewViewModel;

import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {

    ActivityRecyclerViewBinding binding;
    RecyclerView recyclerView;
    RecyclerAdapter adapter;

    RecyclerViewViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_recycler_view);
        bindViews();

        viewModel = new ViewModelProvider(this).get(RecyclerViewViewModel.class);
        viewModel.getAllCars().observe(this, new Observer<List<Car>>() {
            @Override
            public void onChanged(List<Car> cars) {
                adapter.setCars(cars);
                adapter.notifyDataSetChanged();
            }
        });


    }

    void bindViews(){
        binding = ActivityRecyclerViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        recyclerView = binding.recyclerView;
        adapter = new RecyclerAdapter();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}