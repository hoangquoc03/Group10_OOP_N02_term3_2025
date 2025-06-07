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
                "Room ID", "Price", "Landlord Name", "Phone", "Address", "Tenant ID", "Tenant Name", "Phone", "Ngày thuê");
            System.out.println("----------------------------------------------------------------------------------------------------");

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

    // Hiển thị phòng sắp đến hạn đóng tiền trong vòng thresholdDays ngày
    public static void hienThiPhongSapDenHanDongTien(CrudManager<Room> roomManager) {
        LocalDate today = LocalDate.now();
        boolean found = false;
        int thresholdDays = 5;  // Số ngày sắp đến hạn

        System.out.println("\n--- PHÒNG SẮP ĐẾN HẠN ĐÓNG TIỀN TRỌ (trong vòng " + thresholdDays + " ngày tới) ---");
        System.out.printf("%-10s %-10s %-20s %-15s %-15s %-12s %-20s %-15s %-12s\n",
            "Room ID", "Price", "Landlord Name", "Phone", "Address", "Tenant ID", "Tenant Name", "Phone", "Ngày thuê");
        System.out.println("----------------------------------------------------------------------------------------------------");

        for (Room room : roomManager.getItems()) {
            Tenant tenant = room.getTenant();
            LocalDate rentDate = tenant.getNgayThue();

            // Tính số ngày đã thuê từ ngày thuê đến hôm nay
            long daysBetween = java.time.temporal.ChronoUnit.DAYS.between(rentDate, today);

            // Chu kỳ đóng tiền 30 ngày
            long daysPassedInCycle = daysBetween % 30;  // số ngày đã qua trong chu kỳ hiện tại
            long daysToDue = 30 - daysPassedInCycle;    // số ngày còn lại đến hạn đóng tiền

            if (daysToDue <= thresholdDays && daysToDue > 0) {
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
            System.out.println("Không có phòng nào sắp đến hạn đóng tiền trong vòng " + thresholdDays + " ngày tới.");
        }
    }

    // Hiển thị phòng đúng ngày đến hạn đóng tiền hôm nay
    public static void hienThiPhongDenNgayDongTien(CrudManager<Room> roomManager) {
        LocalDate today = LocalDate.now();
        boolean found = false;

        System.out.println("\n--- PHÒNG ĐẾN HẠN ĐÓNG TIỀN TRỌ (30 ngày mỗi tháng) ---");
        System.out.printf("%-10s %-10s %-20s %-15s %-15s %-12s %-20s %-15s %-12s\n",
            "Room ID", "Price", "Landlord Name", "Phone", "Address", "Tenant ID", "Tenant Name", "Phone", "Ngày thuê");
        System.out.println("----------------------------------------------------------------------------------------------------");

        for (Room room : roomManager.getItems()) {
            Tenant tenant = room.getTenant();
            LocalDate rentDate = tenant.getNgayThue();

            // Cộng 30 ngày liên tục đến khi vượt today
            LocalDate nextPaymentDate = rentDate;
            while (!nextPaymentDate.isAfter(today)) {
                nextPaymentDate = nextPaymentDate.plusDays(30);
            }

            // Ngày đóng tiền gần nhất trước hoặc bằng hôm nay
            LocalDate lastPaymentDue = nextPaymentDate.minusDays(30);

            if (lastPaymentDue.equals(today)) {
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
                "Room ID", "Price", "Landlord Name", "Phone", "Address", "Tenant ID", "Tenant Name", "Phone", "Ngày thuê");
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
