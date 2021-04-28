package com.neda.carwarehouse.provider;

import android.database.Cursor;

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
    int deleteAllCars();

    @Query("delete from cars where year < :year")
    int deleteCarsByYear(String year);

    @Query("select * from cars where year < :year")
    Cursor findCarsByYear(String year);

    @Query("select * from cars")
    Cursor getAllCarsCursor();

    @Query("select * from cars where maker = :maker")
    Cursor findCarsByMaker(String maker);
}
