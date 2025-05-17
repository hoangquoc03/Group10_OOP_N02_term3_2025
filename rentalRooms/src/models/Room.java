
package models;

public class Room {

    private String RoomID;
    private double price;

    // constructor

    public Room(String RoomID, double price) {
        this.RoomID = RoomID;
        this.price = price;
    }

    public String getRoomID() {
        return RoomID;
    }

    public void setRoomID(String RoomID) {
        this.RoomID = RoomID;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public static void hienthiphong() {

        Room r = new Room("r12345", 2300);

        String id = r.getRoomID();
        double price = r.getPrice();

        System.out.println("Hien thi thong tin phong:" + id + " sotien: " + price);
    }

}
