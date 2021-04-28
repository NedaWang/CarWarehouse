package com.neda.carwarehouse.provider;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.neda.carwarehouse.entity.Car;

import java.util.List;

public class Repository {

    CarDao carDao;
    DatabaseReference firebaseDB;

    public Repository(Application application) {
        CarWarhouseRoomDatabase database = CarWarhouseRoomDatabase.getDatabase(application);
        carDao = database.getCarDao();
        //may need to go to Project->App->Google-services.json
        // and manually add "firebase_url": "https://...firebaseio.com"
        // which is the url showed in firebase console
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseDB = firebaseDatabase.getReference("/cars");
    }

    public LiveData<List<Car>> getAllCars(){
        return carDao.getAllCars();
    }

    public void deleteAllCars(){
        firebaseDB.removeValue();
        CarWarhouseRoomDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                carDao.deleteAllCars();
            }
        });
    }

    public void addCar(Car car){
        //add into firebase without id
        // push into firebase with a unique key
        firebaseDB.push().setValue(car);
        CarWarhouseRoomDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                carDao.addCar(car);
            }
        });
    }


}
