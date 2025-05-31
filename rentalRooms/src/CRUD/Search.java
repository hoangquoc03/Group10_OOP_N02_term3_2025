package CRUD;

import models.Room;
import models.Tenant;
import models.CrudManager;
import java.time.LocalDate;
import java.util.Scanner;

public class Search {
    // Tìm kiếm người thuê
    public static void timKiemNguoiThue(CrudManager<Room> roomManager) {
        Scanner scanner = new Scanner(System.in);
        String keyword;
        boolean tiepTucTim;

        do {
            System.out.println("\nNhập thông tin người thuê cần tìm kiếm (ID hoặc tên):");
            keyword = scanner.nextLine().trim().toLowerCase();

            boolean found = false;
            System.out.printf("%-10s %-10s %-20s %-15s %-20s %-15s\n",
                "Room ID", "Price", "Landlord Name", "Phone", "Tenant Name", "Phone");
            System.out.println("------------------------------------------------------------------------------------------");

            for (Room room : roomManager.getItems()) {
                Tenant tenant = room.getTenant();
                if (tenant.getID().toLowerCase().contains(keyword) || tenant.getName().toLowerCase().contains(keyword)) {
                    System.out.printf("%-10s %-10.2f %-20s %-15s %-20s %-15s\n",
                        room.getID(),
                        room.getPrice(),
                        room.getLandlord().getName(),
                        room.getLandlord().getSdt(),
                        tenant.getName(),
                        tenant.getPhone()
                    );
                    found = true;
                }
            }

            if (!found) {
                System.out.println("Không tìm thấy người thuê phù hợp với từ khóa: " + keyword);
            }

            System.out.print("Bạn có muốn tìm tiếp không? (y/n): ");
            String luaChon = scanner.nextLine().trim().toLowerCase();
            tiepTucTim = luaChon.equals("y");

        } while (tiepTucTim);
    }

    // Hiển thị phòng đến ngày đóng tiền
    public static void hienThiPhongDenNgayDongTien(CrudManager<Room> roomManager) {
        LocalDate today = LocalDate.now();
        boolean found = false;

        System.out.println("\n--- PHÒNG ĐẾN HẠN ĐÓNG TIỀN TRỌ ---");
        System.out.printf("%-10s %-10s %-20s %-15s %-25s %-20s %-15s %-12s\n",
            "Room ID", "Price", "Landlord Name", "Phone", "Address", "Tenant Name", "Phone", "Ngày thuê");
        System.out.println("----------------------------------------------------------------------------------------------------");

        for (Room room : roomManager.getItems()) {
            Tenant tenant = room.getTenant();
            LocalDate rentDate = tenant.getNgayThue();

            long monthsBetween = java.time.temporal.ChronoUnit.MONTHS.between(
                rentDate.withDayOfMonth(1),
                today.withDayOfMonth(1)
            );

            LocalDate nextPaymentDate = rentDate.plusMonths(monthsBetween);
            if (nextPaymentDate.equals(today)) {
                System.out.printf("%-10s %-10.2f %-20s %-15s %-25s %-20s %-15s %-12s\n",
                    room.getID(),
                    room.getPrice(),
                    room.getLandlord().getName(),
                    room.getLandlord().getSdt(),
                    room.getLandlord().getDiaChi(),
                    tenant.getName(),
                    tenant.getPhone(),
                    tenant.getNgayThue().toString()
                );
                found = true;
            }
        }

        if (!found) {
            System.out.println("Không có phòng nào đến ngày đóng tiền hôm nay.");
        }
    }
}
