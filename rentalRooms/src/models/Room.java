package models;

import java.util.ArrayList;

public class Room implements Identifiable {
    private String roomID;
    private double price;
    private Landlord landlord;
    private Tenant tenant;
    private String address;

    // Danh sách các phòng
    private static ArrayList<Room> roomList = new ArrayList<>();

    // Constructor đầy đủ thông tin
    public Room(String roomID, double price, Landlord landlord, Tenant tenant, String address) {
        this.roomID = roomID;
        this.price = price;
        this.landlord = landlord;
        this.tenant = tenant;
        this.address = address;
    }

    // Constructor đơn giản để test nhanh
    public Room(String roomID, double price) {
        this.roomID = roomID;
        this.price = price;
    }

    // Getter và Setter
    @Override
    public String getID() {
        return roomID;
    }

    public String getRoomID() {
        return roomID;
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Landlord getLandlord() {
        return landlord;
    }

    public void setLandlord(Landlord landlord) {
        this.landlord = landlord;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // Thêm phòng
    public static void addRoom(Room room) {
        roomList.add(room);
        System.out.println("Đã thêm phòng: " + room.getRoomID());
    }

    // Sửa thông tin phòng
    public static boolean updateRoom(String roomID, double price) {
        for (Room room : roomList) {
            if (room.getRoomID().equals(roomID)) {
                room.setPrice(price);
                System.out.println("Đã cập nhật giá cho phòng: " + roomID);
                return true;
            }
        }
        System.out.println("Không tìm thấy phòng: " + roomID);
        return false;
    }

    // Xóa phòng
    public static boolean deleteRoom(String roomID) {
        for (Room room : roomList) {
            if (room.getRoomID().equals(roomID)) {
                roomList.remove(room);
                System.out.println("Đã xóa phòng: " + roomID);
                return true;
            }
        }
        System.out.println("Không tìm thấy phòng để xóa: " + roomID);
        return false;
    }

    // Hiển thị danh sách các phòng
    public static void displayRooms() {
        System.out.println("Danh sách các phòng:");
        for (Room room : roomList) {
            System.out.println(room);
        }
    }

    // Hiển thị thông tin phòng đơn (test)
    public static void hienthiphong() {
        Room r = new Room("r12345", 2300);
        System.out.println("Hiển thị thông tin phòng: " + r.getRoomID() + ", Số tiền: " + r.getPrice());
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
