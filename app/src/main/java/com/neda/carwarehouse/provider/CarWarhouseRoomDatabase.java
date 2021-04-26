package com.neda.carwarehouse.provider;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.neda.carwarehouse.entity.Car;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


//This is the main access point for the underlying SQLite database connection.
// It also holds information about the various entities and DAOs.

// Abstract class is a restricted class that cannot be used to create objects
@Database(entities = {Car.class}, version = 1)
public abstract class CarWarhouseRoomDatabase extends RoomDatabase {

    public static final String DATABASE_NAME = "car_warehouse_database";

    // can only be used in an abstract class, and it does not have a body.
    // The body is provided by the subclass (inherited from)
    public abstract CarDao getCarDao();

    // Marking the instance as volatile to ensure atomic access to the variable.
    // Volatile variable will instruct JVM threads to read the value of volatile variable
    // from main memory and don’t cache it locally.
    // If a variable is not shared between multiple threads then there is no need to use the volatile keyword.
    private static volatile CarWarhouseRoomDatabase INSTANCE;

    private static final int NUMBER_OF_THREADS = 4;

    // Cannot access database on the main thread since it may potentially lock the UI for a long period of time.
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static CarWarhouseRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (CarWarhouseRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            CarWarhouseRoomDatabase.class, DATABASE_NAME)
                            .build();
                }
            }
        }
        return INSTANCE;
    }


}
