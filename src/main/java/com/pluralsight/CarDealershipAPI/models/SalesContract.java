package com.pluralsight.CarDealershipAPI.models;

public class SalesContract {
    private int salesId, VIN;
    private String customerDate, customerName, customerEmail;
    private Double totalPrice, monthlyPayment;

    public SalesContract(int salesId, int VIN, String customerDate, String customerName, String customerEmail, Double totalPrice, Double monthlyPayment) {
        this.salesId = salesId;
        this.VIN = VIN;
        this.customerDate = customerDate;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.totalPrice = totalPrice;
        this.monthlyPayment = monthlyPayment;
    }

    public int getSalesId() {
        return salesId;
    }

    public int getVIN() {
        return VIN;
    }

    public String getCustomerDate() {
        return customerDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public Double getMonthlyPayment() {
        return monthlyPayment;
    }
}
