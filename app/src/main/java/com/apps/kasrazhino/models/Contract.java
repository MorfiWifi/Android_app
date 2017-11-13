package com.apps.kasrazhino.models;

import com.apps.kasrazhino.ui.ListActivity;

import java.util.ArrayList;

/**
 * Created by WifiMorfi on 13/11/2017.
 */

public class Contract {
    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int Id ;

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String Content;

    public ArrayList<Order> getOrders() {
        return Orders;
    }

    public void setOrders(ArrayList<Order> orders) {
        Orders = orders;
    }

    public ArrayList <Order> Orders;
}
