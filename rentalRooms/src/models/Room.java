package models;

public class Room implements Identifiable {
    private String roomID;
    private double price;
    private Landlord landlord;
    private Tenant tenant;

    public Room(String roomID, double price, Landlord landlord, Tenant tenant) {
        this.roomID = roomID;
        this.price = price;
        this.landlord = landlord;
        this.tenant = tenant;
    }

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

    public String toString() {
        return "Room ID: " + roomID +
               ", Price: " + price +
               ", Landlord: [" + landlord + "]" +
               ", Tenant: [" + tenant + "]";
    }
}
