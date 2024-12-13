package com.pluralsight.CarDealershipAPI.dao;

import com.pluralsight.CarDealershipAPI.models.SalesContract;

public interface SalesDao {
    SalesContract getId(int salesId);

    boolean update(int salesId, SalesContract salesContract);
}
