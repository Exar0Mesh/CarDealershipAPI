package com.pluralsight.CarDealershipAPI.dao;

import com.pluralsight.CarDealershipAPI.models.Vehicle;

import java.util.List;

public interface VehicleDao {
    List<Vehicle> getAll();
    Vehicle getVin(int vin);
    Vehicle getMinPrice();
    Vehicle getMaxPrice();
    List<Vehicle> getMake(String make);
    List<Vehicle> getModel(String model);
    Vehicle getMinYear();
    Vehicle getMaxYear();
    List<Vehicle> getColor(String color);
    Vehicle getMinMiles();
    Vehicle getMaxMiles();
    List<Vehicle> getType(String type);

    Vehicle insert(Vehicle vehicle);
    boolean update(int vin, Vehicle vehicle);
    boolean delete(int vin);
}
