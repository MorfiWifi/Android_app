package com.apps.kasrazhino.models;

import java.util.ArrayList;

/**
 * Created by WifiMorfi on 13/11/2017.
 */

public class Order {

    public int Id ;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getOrderDate() {
        return OrderDate;
    }

    public void setOrderDate(String orderDate) {
        OrderDate = orderDate;
    }

    public String getRequiredDate() {
        return RequiredDate;
    }

    public void setRequiredDate(String requiredDate) {
        RequiredDate = requiredDate;
    }

    public int getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(int customerId) {
        CustomerId = customerId;
    }

    public int getContractId() {
        return ContractId;
    }

    public void setContractId(int contractId) {
        ContractId = contractId;
    }

    public ArrayList<Order_Detail> getOrder_Details() {
        return Order_Details;
    }

    public void setOrder_Details(ArrayList<Order_Detail> order_Details) {
        Order_Details = order_Details;
    }

    public com.apps.kasrazhino.models.Customer getCustomer() {
        return Customer;
    }

    public void setCustomer(com.apps.kasrazhino.models.Customer customer) {
        Customer = customer;
    }

    public com.apps.kasrazhino.models.Contract getContract() {
        return Contract;
    }

    public void setContract(com.apps.kasrazhino.models.Contract contract) {
        Contract = contract;
    }

    public String OrderDate ; // TILL NOW!

    public String RequiredDate; // TILL NOW!

    public int CustomerId ;

    public int ContractId ;

    public ArrayList<Order_Detail> Order_Details ;
//    public virtual ApplicationUser ApplicationUser { get; set; }
    public  Customer Customer ;
    public  Contract Contract ;


}
