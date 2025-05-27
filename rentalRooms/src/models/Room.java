package models;

public class Room implements Identifiable {
    private String roomID;
    private double price;

    public Room(String roomID, double price) {
        this.roomID = roomID;
        this.price = price;
    }

    public String getID() {
        return roomID;
    }

    public String toString() {
        return "Room ID: " + roomID + ", Price: " + price;
    }
}
