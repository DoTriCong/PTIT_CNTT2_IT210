package org.example.ss2.model;

import java.util.Date;

public class Order {
    private String name;
    private double price;
    private Date createdAt;

    public Order(String name, double price) {
        this.name = name;
        this.price = price;
        createdAt = new Date();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
