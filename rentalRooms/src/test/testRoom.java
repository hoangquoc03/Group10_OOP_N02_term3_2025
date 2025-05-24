package test;

import models.Room;

public class testRoom {
    public static void main(String[] args) {
        // Thêm phòng
        Room.addRoom(new Room("R001", 1000));
        Room.addRoom(new Room("R002", 1200));
        Room.addRoom(new Room("R003", 1500));

        // Hiển thị danh sách
        Room.displayRooms();

        // Sửa giá phòng
        Room.updateRoom("R002", 1300);

        // Xóa phòng
        Room.deleteRoom("R001");

        // Hiển thị lại danh sách
        Room.displayRooms();
    }
}
