package com.apps.kasrazhino.models;

import java.util.ArrayList;

/**
 * Created by WifiMorfi on 13/11/2017.
 */

public class Customer {

    public int Id ;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String companyName) {
        CompanyName = companyName;
    }

    public int getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public boolean getIsDeleted() {
        return IsDeleted;
    }

    public void setIsDeleted(boolean isDeleted) {
        IsDeleted = isDeleted;
    }

    public ArrayList<Order> getOrders() {
        return Orders;
    }

    public void setOrders(ArrayList<Order> orders) {
        Orders = orders;
    }

    public String Name ;

    public String CompanyName ;

    public int PhoneNumber ;

    public boolean IsDeleted ;

    //Navigation Properties:
    public ArrayList<Order> Orders ;


}
