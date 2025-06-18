package test;

import models.Room;

public class testRoom {

    public static void main(String[] args) {
        try {
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

        } catch (Exception e) {
            System.err.println("Lỗi xảy ra trong quá trình testRoom: " + e.getMessage());
            e.printStackTrace();
        } finally {
            System.out.println("Hoàn thành kiểm tra testRoom.");
        }
    }

    // Test hiển thị thông tin phòng đơn
    public static void hienthiphong() {
        try {
            Room r = new Room("r12345", 2300);
            String id = r.getRoomID();
            double price = r.getPrice();

            System.out.println("Hiển thị thông tin phòng: " + id + " | Số tiền: " + price);
            System.out.println("Test:");
        } catch (Exception e) {
            System.err.println("Lỗi trong hienthiphong(): " + e.getMessage());
            e.printStackTrace();
        } finally {
            System.out.println("Kết thúc hiển thị thông tin phòng.");
        }
    }
}
