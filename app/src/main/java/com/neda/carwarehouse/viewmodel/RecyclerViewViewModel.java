package com.neda.carwarehouse.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.neda.carwarehouse.entity.Car;
import com.neda.carwarehouse.provider.Repository;

import java.util.List;

public class RecyclerViewViewModel extends AndroidViewModel {
    Repository repository;

    public RecyclerViewViewModel(@NonNull Application application) {
        super(application);
        repository = new Repository(application);
    }

    public LiveData<List<Car>> getAllCars(){
        return repository.getAllCars();
    }
}
