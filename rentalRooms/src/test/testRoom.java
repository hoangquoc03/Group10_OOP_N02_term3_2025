package test;

import models.Room;  // Đảm bảo bạn import đúng tên class (Room viết hoa)

public class testRoom {

    public static void main(String[] args) {
        // Test hàm hienthiphong() riêng lẻ
        hienthiphong();

        // Thêm phòng
        Room.addRoom(new Room("R001", 1000));
        Room.addRoom(new Room("R002", 1200));
        Room.addRoom(new Room("R003", 1500));

        // Hiển thị danh sách phòng
        Room.displayRooms();

        // Sửa giá phòng R002
        Room.updateRoom("R002", 1300);

        // Xóa phòng R001
        Room.deleteRoom("R001");

        // Hiển thị lại danh sách sau khi xóa
        Room.displayRooms();
    }

    // Test hiển thị thông tin phòng đơn
    public static void hienthiphong() {
        Room r = new Room("r12345", 2300);

        String id = r.getRoomID();
        double price = r.getPrice();

        System.out.println("Hiển thị thông tin phòng: " + id + " | Số tiền: " + price);
        System.out.println("Test:");
    }
}
