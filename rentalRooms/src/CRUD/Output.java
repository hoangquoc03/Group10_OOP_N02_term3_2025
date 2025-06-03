package CRUD;

import models.Room;
import models.CrudManager;

public class Output {
    public static void hienThiBangPhong(CrudManager<Room> roomManager) {
        System.out.printf("%-10s %-10s %-20s %-15s %-25s %-12s %-20s %-15s %-12s\n",
            "Room ID", "Price", "Landlord Name", "Phone", "Address", "Tenant ID ","Tenant Name", "Phone", "Ngày thuê");
        System.out.println("----------------------------------------------------------------------------------------------------");

        for (Room room : roomManager.getItems()) {
            System.out.printf("%-10s %-10.2f %-20s %-15s %-25s %-12s %-20s %-15s %-12s\n",
                room.getID(),
                room.getPrice(),
                room.getLandlord().getName(),
                room.getLandlord().getSdt(),
                room.getLandlord().getDiaChi(),
                room.getTenant().getID(),
                room.getTenant().getName(),
                room.getTenant().getPhone(),
                room.getTenant().getNgayThue().toString()
            );
        }
    }
}
