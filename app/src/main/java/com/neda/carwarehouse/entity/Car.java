package com.neda.carwarehouse.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

import static com.neda.carwarehouse.entity.Car.TABLE_NAME;

@Entity (tableName = TABLE_NAME)
public class Car {

    public static final String TABLE_NAME = "cars";

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo (name = "id")
    private int id;
    @ColumnInfo (name = "maker")
    private String maker;
    @ColumnInfo (name = "model")
    private String model;
    @ColumnInfo (name = "year")
    private String year;
    @ColumnInfo (name = "color")
    private String color;
    @ColumnInfo (name = "seats")
    private String seats;
    @ColumnInfo (name = "price")
    private String price;

    public Car() {
    }

    public Car(String maker, String model) {
        this.maker = maker;
        this.model = model;
    }

    public Car(String maker, String model, String year, String color, String seats, String price) {
        this.maker = maker;
        this.model = model;
        this.year = year;
        this.color = color;
        this.seats = seats;
        this.price = price;
    }

    public Car(int id, String maker, String model, String year, String color, String seats, String price) {
        this.id = id;
        this.maker = maker;
        this.model = model;
        this.year = year;
        this.color = color;
        this.seats = seats;
        this.price = price;
    }

    @Override
    public @NotNull String toString() {
        return "maker='" + maker +
                ", model='" + model +
                ", year='" + year +
                ", color='" + color +
                ", seats='" + seats +
                ", price='" + price; // + '\'' +
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSeats() {
        return seats;
    }

    public void setSeats(String seats) {
        this.seats = seats;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
