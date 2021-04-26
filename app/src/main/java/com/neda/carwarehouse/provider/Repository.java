package com.neda.carwarehouse.provider;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.neda.carwarehouse.entity.Car;

import java.util.List;

public class Repository {

    CarDao carDao;

    public Repository(Application application) {
        CarWarhouseRoomDatabase database = CarWarhouseRoomDatabase.getDatabase(application);
        carDao = database.getCarDao();
    }

    public LiveData<List<Car>> getAllCars(){
        return carDao.getAllCars();
    }

    public void deleteAllCars(){
        CarWarhouseRoomDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                carDao.deleteAllCars();
            }
        });
    }

    public void addCar(Car car){
        CarWarhouseRoomDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                carDao.addCar(car);
            }
        });
    }


}
