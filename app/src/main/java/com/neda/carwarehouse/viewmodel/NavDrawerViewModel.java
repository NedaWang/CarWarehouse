package com.neda.carwarehouse.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.neda.carwarehouse.entity.Car;
import com.neda.carwarehouse.provider.Repository;

public class NavDrawerViewModel extends AndroidViewModel {
    Repository repository;

    public NavDrawerViewModel(@NonNull Application application) {
        super(application);
        repository = new Repository(application);
    }

    public void addCar(Car car){
        repository.addCar(car);
    }

    public void deleteAllCars(){
        repository.deleteAllCars();
    }
}
