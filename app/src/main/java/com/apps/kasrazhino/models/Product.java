package com.apps.kasrazhino.models;

import java.util.ArrayList;

/**
 * Created by WifiMorfi on 13/11/2017.
 */

public class Product {

    public int Id;

    public String Name;

    public int UnitPrice;

    public int UnitsInStock;

    public int SupplierId;

    public  Supplier Supplier;

    public ArrayList<Order_Detail> Order_Details;

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

    public int getUnitPrice() {
        return UnitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        UnitPrice = unitPrice;
    }

    public int getUnitsInStock() {
        return UnitsInStock;
    }

    public void setUnitsInStock(int unitsInStock) {
        UnitsInStock = unitsInStock;
    }

    public int getSupplierId() {
        return SupplierId;
    }

    public void setSupplierId(int supplierId) {
        SupplierId = supplierId;
    }

    public com.apps.kasrazhino.models.Supplier getSupplier() {
        return Supplier;
    }

    public void setSupplier(com.apps.kasrazhino.models.Supplier supplier) {
        Supplier = supplier;
    }

    public ArrayList<Order_Detail> getOrder_Details() {
        return Order_Details;
    }

    public void setOrder_Details(ArrayList<Order_Detail> order_Details) {
        Order_Details = order_Details;
    }
}
