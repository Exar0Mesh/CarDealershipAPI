package com.pluralsight.CarDealershipAPI.controllers;


import com.pluralsight.CarDealershipAPI.dao.VehicleDao;
import com.pluralsight.CarDealershipAPI.models.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VehicleController {

    private VehicleDao vehicleDao;

    @Autowired
    public VehicleController(VehicleDao vehicleDao) {
        this.vehicleDao = vehicleDao;
    }


    @RequestMapping(path="/vehicles", method = RequestMethod.GET)
    public List<Vehicle> getAllVehicles() {
        return this.vehicleDao.getAll();
    }

    @RequestMapping(path="/vehicles/{vin}", method = RequestMethod.GET)
    public Vehicle getAVehicle(@PathVariable int vin) {
        return this.vehicleDao.getVin(vin);
    }


    @RequestMapping(path="/vehicles/minPrice", method = RequestMethod.GET)
    public Vehicle getVehicleMinPrice() {
        return this.vehicleDao.getMinPrice();
    }

    @RequestMapping(path="/vehicles/maxPrice", method = RequestMethod.GET)
    public Vehicle getVehicleMaxPrice() {
        return this.vehicleDao.getMaxPrice();
    }

    @RequestMapping(path="/vehicles/{make}", method = RequestMethod.GET)
    public List<Vehicle> getVehicleMake(@PathVariable String make) {
        return this.vehicleDao.getMake(make);
    }

    @RequestMapping(path="/vehicles/{model}", method = RequestMethod.GET)
    public List<Vehicle> getVehicleModel(@PathVariable String model) {
        return this.vehicleDao.getModel(model);
    }

    @RequestMapping(path="/vehicles/minYear", method = RequestMethod.GET)
    public Vehicle getVehicleMinYear() {
        return this.vehicleDao.getMinYear();
    }

    @RequestMapping(path="/vehicles/maxYear", method = RequestMethod.GET)
    public Vehicle getVehicleMaxYear() {
        return this.vehicleDao.getMaxYear();
    }

    @RequestMapping(path="/vehicles/{color}", method = RequestMethod.GET)
    public List<Vehicle> getVehicleColor(@PathVariable String color) {
        return this.vehicleDao.getColor(color);
    }

    @RequestMapping(path="/vehicles/minMiles", method = RequestMethod.GET)
    public Vehicle getVehicleMinMiles() {
        return this.vehicleDao.getMinMiles();
    }

    @RequestMapping(path="/vehicles/maxMiles", method = RequestMethod.GET)
    public Vehicle getVehicleMaxMiles() {
        return this.vehicleDao.getMaxMiles();
    }

    @RequestMapping(path="/vehicles/{type}", method = RequestMethod.GET)
    public List<Vehicle> getVehicleType(@PathVariable String type) {
        return this.vehicleDao.getType(type);
    }


    @RequestMapping(path="/vehicles", method = RequestMethod.POST)
    public Vehicle addAVehicle(@RequestBody Vehicle vehicle) {
        return this.vehicleDao.insert(vehicle);
    }

    @RequestMapping(path="/vehicles/{vin}", method=RequestMethod.PUT)
    public boolean updateAProduct(@PathVariable int id, @RequestBody Vehicle vehicle) {
        return this.vehicleDao.update(id, vehicle);
    }

    @RequestMapping(path="/vehicle/{id}", method=RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public boolean deleteVehicle (@PathVariable int vin) {
        return this.vehicleDao.delete(vin);
    }


}
