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
            System.out.printf("%-10s %-10s %-20s %-15s %-15s %-12s %-20s %-15s %-12s\n",
                "Room ID", "Price", "Landlord Name", "Phone", "Address","Tenant ID", "Tenant Name", "Phone", "Ngày thuê");
            System.out.println("------------------------------------------------------------------------------------------");

            for (Room room : roomManager.getItems()) {
                Tenant tenant = room.getTenant();
                if (tenant.getID().toLowerCase().contains(keyword) || tenant.getName().toLowerCase().contains(keyword)) {
                    System.out.printf("%-10s %-10.2f %-20s %-15s %-15s %-12s %-20s %-15s %-12s\n",
                        room.getID(),
                        room.getPrice(),
                        room.getLandlord().getName(),
                        room.getLandlord().getSdt(),
                        room.getLandlord().getDiaChi(),
                        tenant.getID(),
                        tenant.getName(),
                        tenant.getPhone(),
                        tenant.getNgayThue().toString()
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
        System.out.printf("%-10s %-10s %-20s %-15s %-15s %-12s %-20s %-15s %-12s\n",
            "Room ID", "Price", "Landlord Name", "Phone", "Address","Tenant ID", "Tenant Name", "Phone", "Ngày thuê");
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
                System.out.printf("%-10s %-10.2f %-20s %-15s %-15s %-12s %-20s %-15s %-12s\n",
                    room.getID(),
                    room.getPrice(),
                    room.getLandlord().getName(),
                    room.getLandlord().getSdt(),
                    room.getLandlord().getDiaChi(),
                    tenant.getID(),
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
    // Tìm kiếm theo khoảng giá phòng
public static void timKiemTheoGiaPhong(CrudManager<Room> roomManager) {
    Scanner scanner = new Scanner(System.in);
    boolean tiepTucTim = true;

    do {
        double min = 0, max = 0;
        try {
            System.out.print("\nNhập giá tối thiểu: ");
            min = Double.parseDouble(scanner.nextLine().trim());
            System.out.print("Nhập giá tối đa: ");
            max = Double.parseDouble(scanner.nextLine().trim());

            if (min > max) {
                System.out.println("Giá tối thiểu không được lớn hơn giá tối đa. Vui lòng nhập lại.");
                continue;
            }
        } catch (NumberFormatException e) {
            System.out.println("Giá nhập vào không hợp lệ. Vui lòng nhập lại.");
            continue;
        }

        boolean found = false;
        System.out.printf("%-10s %-10s %-20s %-15s %-15s %-12s %-20s %-15s %-12s\n",
            "Room ID", "Price", "Landlord Name", "Phone", "Address","Tenant ID", "Tenant Name", "Phone", "Ngày thuê");
        System.out.println("----------------------------------------------------------------------------------------------------");

        for (Room room : roomManager.getItems()) {
            double price = room.getPrice();
            if (price >= min && price <= max) {
                Tenant tenant = room.getTenant();
                System.out.printf("%-10s %-10.2f %-20s %-15s %-15s %-12s %-20s %-15s %-12s\n",
                    room.getID(),
                    price,
                    room.getLandlord().getName(),
                    room.getLandlord().getSdt(),
                    room.getLandlord().getDiaChi(),
                    tenant.getID(),
                    tenant.getName(),
                    tenant.getPhone(),
                    tenant.getNgayThue().toString()
                );
                found = true;
            }
        }

        if (!found) {
            System.out.println("Không có phòng nào trong khoảng giá từ " + min + " đến " + max);
        }

        System.out.print("Bạn có muốn tìm theo khoảng giá khác không? (y/n): ");
        String luaChon = scanner.nextLine().trim().toLowerCase();
        tiepTucTim = luaChon.equals("y");

    } while (tiepTucTim);
}


}
