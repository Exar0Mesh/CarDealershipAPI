package com.pluralsight.CarDealershipAPI.controllers;


import com.pluralsight.CarDealershipAPI.dao.SalesDao;
import com.pluralsight.CarDealershipAPI.models.SalesContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class SalesContractController {

    private SalesDao salesDao;

    @Autowired
    public SalesContractController(SalesDao salesDao) {
        this.salesDao = salesDao;
    }


    @RequestMapping(path="/salesContract/{id}", method = RequestMethod.GET)
    public SalesContract getAContract(@PathVariable int salesId) {
        return this.salesDao.getId(salesId);
    }
}
