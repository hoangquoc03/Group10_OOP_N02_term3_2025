
package models;

public class room {

    private String RoomID;
    private double price;

    // constructor

    public room(String RoomID, double price) {
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

        room r = new room("r12345", 2300);

        String id = r.getRoomID();
        double price = r.getPrice();

        System.out.println("Hien thi thong tin phong:" + id + " sotien: " + price);

        System.out.println("test:");

    }

}
