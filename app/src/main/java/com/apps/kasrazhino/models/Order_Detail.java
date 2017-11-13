package com.apps.kasrazhino.models;

/**
 * Created by WifiMorfi on 13/11/2017.
 */

public class Order_Detail {
    public int Id ;

    //public int UnitPrice { get; set; }

    public int Quantity ;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public int getProductId() {
        return ProductId;
    }

    public void setProductId(int productId) {
        ProductId = productId;
    }

    public int getOrderId() {
        return OrderId;
    }

    public void setOrderId(int orderId) {
        OrderId = orderId;
    }

    public Product getProduct() {
        return Product;
    }

    public void setProduct(Product product) {
        Product = product;
    }

    public com.apps.kasrazhino.models.Order getOrder() {
        return Order;
    }

    public void setOrder(com.apps.kasrazhino.models.Order order) {
        Order = order;
    }
    //[Display(Name = "تخفیف")]
    //public int Discount { get; set; }

    public int ProductId;

    public int OrderId ;

    //Navigation Properties:
    public  Product Product ;
    public  Order Order ;
}
