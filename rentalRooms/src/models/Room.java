package models;

import java.util.ArrayList;

public class Room {

    private String roomID;
    private double price;

    // Danh sách phòng
    private static ArrayList<Room> roomList = new ArrayList<>();

    // Constructor
    public Room(String roomID, double price) {
        this.roomID = roomID;
        this.price = price;
    }

    // Getter và Setter
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

    // Ví dụ hiển thị phòng đơn
    public static void hienthiphong() {
        Room r = new Room("r12345", 2300);
        String id = r.getRoomID();
        double price = r.getPrice();

        System.out.println("Hiển thị thông tin phòng: " + id + ", Số tiền: " + price);
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

    // Xóa phòng theo ID
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

    // Hiển thị danh sách tất cả các phòng
    public static void displayRooms() {
        System.out.println("Danh sách các phòng:");
        for (Room room : roomList) {
            System.out.println("Room ID: " + room.getRoomID() + ", Price: " + room.getPrice());
        }
    }
}
