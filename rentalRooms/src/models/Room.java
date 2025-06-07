package models;

public class Room implements Identifiable {
    private String roomID;
    private double price;
    private Landlord landlord;
    private Tenant tenant;
    private String address; // Thêm thuộc tính address

    // Constructor mới có thêm address
    public Room(String roomID, double price, Landlord landlord, Tenant tenant, String address) {
        this.roomID = roomID;
        this.price = price;
        this.landlord = landlord;
        this.tenant = tenant;
        this.address = address;
    }

    @Override
    public String getID() {
        return roomID;
    }

    public double getPrice() {
        return price;
    }

    public Landlord getLandlord() {
        return landlord;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Room ID: " + roomID +
               ", Price: " + price +
               ", Address: " + address +
               ", Landlord: [" + landlord + "]" +
               ", Tenant: [" + tenant + "]";
    }
} 
