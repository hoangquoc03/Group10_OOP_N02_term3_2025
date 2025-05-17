package test;

import models.room;

public class testRoom {

    public static void hienthiphong() {
        room r = new room("r12345", 2300);

        String id = r.getRoomID();
        double price = r.getPrice();

        System.out.println("Hiển thị thông tin phòng: " + id + " | Số tiền: " + price);
        System.out.println("test:");
    }
}
