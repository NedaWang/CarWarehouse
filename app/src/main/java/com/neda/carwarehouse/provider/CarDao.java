package com.neda.carwarehouse.provider;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.neda.carwarehouse.entity.Car;

import java.util.List;

@Dao
public interface CarDao {

    @Query("select * from cars")
    LiveData<List<Car>> getAllCars();

    @Insert
    void addCar(Car car);

    @Query("delete from cars")
    void deleteAllCars();

    @Query("select * from cars where year < :year")
    void getCarsByYear(String year);
}
