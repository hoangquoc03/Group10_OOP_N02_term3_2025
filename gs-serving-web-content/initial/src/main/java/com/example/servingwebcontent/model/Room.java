package com.example.servingwebcontent.model;

public class Room {
    private String id;
    private String name;
    private double price;
    private String tenant;

    public Room() {}

    public Room(String id, String name, double price, String tenant) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.tenant = tenant;
    }

    // Getter và Setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getTenant() {
        return tenant;
    }

    public void setTenant(String tenant) {
        this.tenant = tenant;
    }
}
