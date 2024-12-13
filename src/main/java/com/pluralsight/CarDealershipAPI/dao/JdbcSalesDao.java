package com.pluralsight.CarDealershipAPI.dao;

import com.pluralsight.CarDealershipAPI.models.SalesContract;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcSalesDao implements SalesDao{

    private DataSource dataSource;
    private List<SalesContract> salesContracts;

    public JdbcSalesDao(DataSource dataSource) {
        this.dataSource = dataSource;
        this.salesContracts = new ArrayList<>();
    }

    @Override
    public SalesContract getId(int salesId) {
        SalesContract salesContract = null;
        String sql = "SELECT sales_id, VIN, customerDate, customerName, customerEmail, totalPrice, monthlyPayment FROM sales_contracts WHERE sales_id = ?;";
        try(Connection connection = dataSource.getConnection()){
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, salesId);
            ResultSet rows = statement.executeQuery();
            while(rows.next()){
                salesContract = new SalesContract(rows.getInt(1), rows.getInt(2), rows.getString(3),
                        rows.getString(4), rows.getString(5), rows.getDouble(6), rows.getDouble(7));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return salesContract;
    }

    @Override
    public boolean update(int salesId, SalesContract salesContract) {
        return false;
    }
}
