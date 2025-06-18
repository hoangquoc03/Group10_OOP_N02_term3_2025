package com.example.servingwebcontent.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Room {
    private String id;
    private double price;
    private String address;
    private String landlordName;
    private String tenantName;
    private LocalDate paymentDate;

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    // Constructor đầy đủ
    public Room(String id, double price, String address, String landlordName, String tenantName, String paymentDate) {
        this.id = id;
        this.price = price;
        this.address = address;
        this.landlordName = landlordName;
        this.tenantName = tenantName;
        this.paymentDate = LocalDate.parse(paymentDate, formatter);
    }

    // Getters và Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLandlordName() {
        return landlordName;
    }

    public void setLandlordName(String landlordName) {
        this.landlordName = landlordName;
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    // Trả về chuỗi ngày dạng yyyy-MM-dd để hiển thị trong HTML
    public String getFormattedPaymentDate() {
        return paymentDate.format(formatter);
    }
}
