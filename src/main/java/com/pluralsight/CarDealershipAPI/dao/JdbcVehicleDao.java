package com.pluralsight.CarDealershipAPI.dao;

import com.pluralsight.CarDealershipAPI.models.Vehicle;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcVehicleDao implements VehicleDao{

    private DataSource dataSource;
    private List<Vehicle> vehicles;

    public JdbcVehicleDao(DataSource dataSource) {
        this.dataSource = dataSource;
        this.vehicles = new ArrayList<>();
    }

    @Override
    public List<Vehicle> getAll() {
        this.vehicles.clear();
        String sql = "SELECT VIN, year, make, model, vehicleType, color, odometer, price FROM vehicles;";
        try(Connection connection = dataSource.getConnection()){
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rows = statement.executeQuery();
            while(rows.next()){
                this.vehicles.add(new Vehicle(rows.getInt(1), rows.getInt(2), rows.getString(3),
                        rows.getString(4), rows.getString(5), rows.getString(6), rows.getInt(7),
                        rows.getDouble(8)));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return this.vehicles;
    }

    @Override
    public Vehicle getVin(int vin) {
        Vehicle vehicle = null;
        String sql = "SELECT VIN, year, make, model, vehicleType, color, odometer, price FROM vehicles WHERE VIN = ?;";
        try(Connection connection = dataSource.getConnection()){
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, vin);
            ResultSet rows = statement.executeQuery();
            while(rows.next()){
                vehicle = new Vehicle(rows.getInt(1), rows.getInt(2), rows.getString(3),
                        rows.getString(4), rows.getString(5), rows.getString(6), rows.getInt(7),
                        rows.getDouble(8));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return vehicle;
    }

    @Override
    public Vehicle getMinPrice() {
        Vehicle vehicle = null;
        String sql = "SELECT * FROM vehicles WHERE price = (SELECT MIN(price) FROM vehicles);";
        try(Connection connection = dataSource.getConnection()){
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rows = statement.executeQuery();
            while(rows.next()){
                vehicle = new Vehicle(rows.getInt(1), rows.getInt(2), rows.getString(3),
                        rows.getString(4), rows.getString(5), rows.getString(6), rows.getInt(7),
                        rows.getDouble(8));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return vehicle;
    }

    @Override
    public Vehicle getMaxPrice() {
            Vehicle vehicle = null;
            String sql = "SELECT * FROM vehicles WHERE price = (SELECT MAX(price) FROM vehicles);";
            try(Connection connection = dataSource.getConnection()){
                PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet rows = statement.executeQuery();
                while(rows.next()){
                    vehicle = new Vehicle(rows.getInt(1), rows.getInt(2), rows.getString(3),
                            rows.getString(4), rows.getString(5), rows.getString(6), rows.getInt(7),
                            rows.getDouble(8));
                }
            }
            catch (SQLException e){
                e.printStackTrace();
            }
            return vehicle;
        }

    @Override
    public List<Vehicle> getMake(String make) {
        Vehicle vehicle = null;
        String sql = "SELECT VIN, year, make, model, vehicleType, color, odometer, price FROM vehicles WHERE make = ?;";
        try(Connection connection = dataSource.getConnection()){
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,make);
            ResultSet rows = statement.executeQuery();
            while(rows.next()){
                this.vehicles.add(new Vehicle(rows.getInt(1), rows.getInt(2), rows.getString(3),
                        rows.getString(4), rows.getString(5), rows.getString(6), rows.getInt(7),
                        rows.getDouble(8)));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return vehicles;
    }

    @Override
    public List<Vehicle> getModel(String model) {
        this.vehicles.clear();
        String sql = "SELECT VIN, year, make, model, vehicleType, color, odometer, price FROM vehicles WHERE model = ?;";
        try(Connection connection = dataSource.getConnection()){
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,model);
            ResultSet rows = statement.executeQuery();
            while(rows.next()){
                this.vehicles.add(new Vehicle(rows.getInt(1), rows.getInt(2), rows.getString(3),
                        rows.getString(4), rows.getString(5), rows.getString(6), rows.getInt(7),
                        rows.getDouble(8)));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return this.vehicles;
    }

    @Override
    public Vehicle getMinYear() {
            Vehicle vehicle = null;
            String sql = "SELECT * FROM vehicles WHERE year = (SELECT MIN(year) FROM vehicles);";
            try(Connection connection = dataSource.getConnection()){
                PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet rows = statement.executeQuery();
                while(rows.next()){
                    vehicle = new Vehicle(rows.getInt(1), rows.getInt(2), rows.getString(3),
                            rows.getString(4), rows.getString(5), rows.getString(6), rows.getInt(7),
                            rows.getDouble(8));
                }
            }
            catch (SQLException e){
                e.printStackTrace();
            }
            return vehicle;
        }

    @Override
    public Vehicle getMaxYear() {
        Vehicle vehicle = null;
        String sql = "SELECT * FROM vehicles WHERE year = (SELECT MAX(year) FROM vehicles);";
        try(Connection connection = dataSource.getConnection()){
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rows = statement.executeQuery();
            while(rows.next()){
                vehicle = new Vehicle(rows.getInt(1), rows.getInt(2), rows.getString(3),
                        rows.getString(4), rows.getString(5), rows.getString(6), rows.getInt(7),
                        rows.getDouble(8));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return vehicle;
    }

    @Override
    public List<Vehicle> getColor(String color) {
        this.vehicles.clear();
        String sql = "SELECT VIN, year, make, model, vehicleType, color, odometer, price FROM vehicles WHERE color = ?;";
        try(Connection connection = dataSource.getConnection()){
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,color);
            ResultSet rows = statement.executeQuery();
            while(rows.next()){
                this.vehicles.add(new Vehicle(rows.getInt(1), rows.getInt(2), rows.getString(3),
                        rows.getString(4), rows.getString(5), rows.getString(6), rows.getInt(7),
                        rows.getDouble(8)));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return vehicles;
    }

    @Override
    public Vehicle getMinMiles() {
        Vehicle vehicle = null;
        String sql = "SELECT * FROM vehicles WHERE odometer = (SELECT MIN(odometer) FROM vehicles);";
        try(Connection connection = dataSource.getConnection()){
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rows = statement.executeQuery();
            while(rows.next()){
                vehicle = new Vehicle(rows.getInt(1), rows.getInt(2), rows.getString(3),
                        rows.getString(4), rows.getString(5), rows.getString(6), rows.getInt(7),
                        rows.getDouble(8));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return vehicle;
    }

    @Override
    public Vehicle getMaxMiles() {
        Vehicle vehicle = null;
        String sql = "SELECT * FROM vehicles WHERE odometer = (SELECT MAX(odometer) FROM vehicles);";
        try(Connection connection = dataSource.getConnection()){
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rows = statement.executeQuery();
            while(rows.next()){
                vehicle = new Vehicle(rows.getInt(1), rows.getInt(2), rows.getString(3),
                        rows.getString(4), rows.getString(5), rows.getString(6), rows.getInt(7),
                        rows.getDouble(8));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return vehicle;
    }

    @Override
    public List<Vehicle> getType(String type) {
        this.vehicles.clear();
        String sql = "SELECT VIN, year, make, model, vehicleType, color, odometer, price FROM vehicles WHERE type = ?;";
        try(Connection connection = dataSource.getConnection()){
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,type);
            ResultSet rows = statement.executeQuery();
            while(rows.next()){
                this.vehicles.add(new Vehicle(rows.getInt(1), rows.getInt(2), rows.getString(3),
                        rows.getString(4), rows.getString(5), rows.getString(6), rows.getInt(7),
                        rows.getDouble(8)));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return vehicles;
    }

    @Override
    public Vehicle insert(Vehicle vehicle) {
        Vehicle createdVehicle = null;
        String sql = "INSERT INTO vehicles(VIN, year, make, model, vehicleType, color, odometer, price) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try(Connection connection = dataSource.getConnection()){
            PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            statement.setInt(1, vehicle.getVin());
            statement.setInt(2, vehicle.getYear());
            statement.setString(3, vehicle.getMake());
            statement.setString(4, vehicle.getModel());
            statement.setString(5, vehicle.getVehicleType());
            statement.setString(6, vehicle.getColor());
            statement.setInt(7, vehicle.getOdometer());
            statement.setDouble(8, vehicle.getPrice());

            statement.executeUpdate();

            // Retrieve the generated key
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if(generatedKeys.next()) {
                createdVehicle = getVin(generatedKeys.getInt(1));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return createdVehicle;
    }

    @Override
    public boolean update(int vin, Vehicle vehicle) {
        int yearPos = 0;
        int makePos = 0;
        int modelPos = 0;
        int typePos = 0;
        int colorPos = 0;
        int milePos = 0;
        int pPos = 0;
        int vinPos = 0;
        String updateParamStatement = "";

        if(vehicle.getYear() != 0) {
            yearPos+=1;
            vinPos++;
            String comma = "";
            if (updateParamStatement.length() > 0) {
                comma=",";
            }
            updateParamStatement+=comma+" year=? ";
        }

        if(vehicle.getMake() != null) {
            makePos+=yearPos+1;
            vinPos++;
            updateParamStatement+=" make=? ";
        }

        if(vehicle.getModel() != null) {
            modelPos+=yearPos+makePos+1;
            vinPos++;
            updateParamStatement+=" model=? ";
        }

        if(vehicle.getVehicleType() != null) {
            typePos+=yearPos+makePos+modelPos+1;
            vinPos++;
            updateParamStatement+=" vehicleType=? ";
        }

        if(vehicle.getColor() != null) {
            colorPos+=yearPos+makePos+modelPos+typePos+1;
            vinPos++;
            updateParamStatement+=" color=? ";
        }

        if(vehicle.getOdometer() != 0) {
            milePos+=yearPos+makePos+modelPos+typePos+colorPos+1;
            vinPos++;
            String comma = "";
            if (updateParamStatement.length() > 0) {
                comma=",";
            }
            updateParamStatement+=comma+" odometer=? ";
        }

        if(vehicle.getPrice() != 0.0) {
            pPos+=yearPos+makePos+modelPos+typePos+colorPos+milePos+1;
            vinPos++;
            String comma = "";
            if (updateParamStatement.length() > 0) {
                comma=",";
            }
            updateParamStatement+=comma+" price=? ";
        }

        String sql = "UPDATE vehicles SET " + updateParamStatement + " WHERE VIN=?";
        try(Connection connection = dataSource.getConnection()){
            PreparedStatement statement = connection.prepareStatement(sql);

            System.out.println(vehicle);

            if(vehicle.getYear() != 0) {
                statement.setInt(yearPos, vehicle.getYear());
            }

            if(vehicle.getMake() != null) {
                statement.setString(makePos, vehicle.getMake());
            }

            if(vehicle.getModel() != null) {
                statement.setString(modelPos, vehicle.getModel());
            }
            if(vehicle.getVehicleType() != null) {
                statement.setString(modelPos, vehicle.getVehicleType());
            }
            if(vehicle.getColor() != null) {
                statement.setString(modelPos, vehicle.getColor());
            }
            if(vehicle.getOdometer() != 0) {
                statement.setInt(modelPos, vehicle.getOdometer());
            }
            if(vehicle.getPrice() != 0.0) {
                statement.setDouble(modelPos, vehicle.getPrice());
            }

            statement.setInt(vinPos+1, vin);

            statement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(int vin) {
        String sql = "DELETE FROM vehicles WHERE VIN=?";

        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, vin);

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected == 0) {
                System.out.println("No vehicle found with: " + vin);
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }
}
