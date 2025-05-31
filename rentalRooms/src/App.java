import java.util.Scanner;
import models.Landlord;
import models.Room;
import models.Tenant;
import models.CrudManager;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CrudManager<Landlord> landlordManager = new CrudManager<>();
        CrudManager<Room> roomManager = new CrudManager<>();

        System.out.print("Bạn muốn nhập bao nhiêu phòng hôm nay? ");
        int soPhong = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < soPhong; i++) {
            System.out.println("\nNhập thông tin phòng thứ " + (i + 1) + ":");

            String roomID;
            while (true) {
                System.out.print("Room ID: ");
                roomID = scanner.nextLine().trim();
                if (!roomID.isEmpty()) break;
                System.out.println("Room ID không được để trống.");
            }

            double price;
            while (true) {
                System.out.print("Price: ");
                try {
                    price = Double.parseDouble(scanner.nextLine());
                    if (price > 0) break;
                    System.out.println("Giá phòng phải lớn hơn 0.");
                } catch (NumberFormatException e) {
                    System.out.println("Giá phòng phải là số.");
                }
            }

            System.out.println("Nhập thông tin chủ trọ:");
            String landlordID, landlordName, landlordPhone;
            while (true) {
                System.out.print("Landlord ID(CCCD): ");
                landlordID = scanner.nextLine().trim();
                if (!landlordID.isEmpty()) break;
                System.out.println("Landlord ID không được để trống.");
            }
            while (true) {
                System.out.print("Tên chủ trọ: ");
                landlordName = scanner.nextLine().trim();
                if (!landlordName.isEmpty()) break;
                System.out.println("Tên không được để trống.");
            }
            while (true) {
                System.out.print("SĐT chủ trọ: ");
                landlordPhone = scanner.nextLine().trim();
                if (!landlordPhone.isEmpty()) break;
                System.out.println("SĐT không được để trống.");
            }
            String landlordDiaChi;
            while (true) {
                System.out.print("Địa chỉ chủ trọ: ");
                landlordDiaChi = scanner.nextLine().trim();
                if (!landlordDiaChi.isEmpty()) break;
                System.out.println("Địa chỉ không được để trống.");
            }
            Landlord landlord = new Landlord(landlordID, landlordName, landlordPhone, landlordDiaChi);
            landlordManager.create(landlord);

            System.out.println("Nhập thông tin người thuê:");
            String tenantID, tenantName, tenantPhone;
            while (true) {
                System.out.print("Tenant ID(CCCCD): ");
                tenantID = scanner.nextLine().trim();
                if (!tenantID.isEmpty()) break;
                System.out.println("Tenant ID không được để trống.");
            }
            while (true) {
                System.out.print("Tên người thuê: ");
                tenantName = scanner.nextLine().trim();
                if (!tenantName.isEmpty()) break;
                System.out.println("Tên không được để trống.");
            }
            while (true) {
                System.out.print("SĐT người thuê: ");
                tenantPhone = scanner.nextLine().trim();
                if (!tenantPhone.isEmpty()) break;
                System.out.println("SĐT không được để trống.");
            }
            LocalDate ngayThue;
            while (true) {
                System.out.print("Ngày thuê (định dạng yyyy-MM-dd): ");
                String inputDate = scanner.nextLine().trim();
                try {
                    ngayThue = LocalDate.parse(inputDate); // định dạng yyyy-MM-dd
                    break;
                } catch (DateTimeParseException e) {
                    System.out.println("Ngày không hợp lệ. Vui lòng nhập lại theo định dạng yyyy-MM-dd.");
                }
            }
            Tenant tenant = new Tenant(tenantID, tenantName, tenantPhone, ngayThue);

            Room room = new Room(roomID, price, landlord, tenant);
            roomManager.create(room);
        }

        // Hiển thị danh sách phòng
        System.out.println("\n--- DANH SÁCH PHÒNG ---");
        hienThiBangPhong(roomManager);

        // Tìm kiếm người thuê
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

    //  HÀM hiển thị bảng phòng
    public static void hienThiBangPhong(CrudManager<Room> roomManager) {
        System.out.printf("%-10s %-10s %-20s %-15s %-25s %-20s %-15s %-12s\n",
    "Room ID", "Price", "Landlord Name", "Phone", "Address", "Tenant Name", "Phone", "Ngày thuê");
        System.out.println("----------------------------------------------------------------------------------------------------");

        for (Room room : roomManager.getItems()) {
            System.out.printf("%-10s %-10.2f %-20s %-15s %-25s %-20s %-15s %-12s\n",
                room.getID(),
                room.getPrice(),
                room.getLandlord().getName(),
                room.getLandlord().getSdt(),
                room.getLandlord().getDiaChi(),
                room.getTenant().getName(),
                room.getTenant().getPhone(),
                room.getTenant().getNgayThue().toString()
            );
        }
    }
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

        
        long monthsBetween = java.time.temporal.ChronoUnit.MONTHS.between(rentDate.withDayOfMonth(1), today.withDayOfMonth(1));

        // Kiểm tra nếu hôm nay là ngày đóng tiền tháng mới
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
