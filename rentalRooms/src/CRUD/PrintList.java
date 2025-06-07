
package CRUD;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import models.Landlord;
import models.Room;
import models.Tenant;
import models.CrudManager;

public class PrintList {

    // Phương thức nhập phòng, trả về CrudManager<Room> đã được tạo và lưu dữ liệu
    public static CrudManager<Room> nhapPhong() {
        Scanner scanner = new Scanner(System.in);
        CrudManager<Room> roomManager = new CrudManager<>();
        CrudManager<Landlord> landlordManager = new CrudManager<>();
        int soPhong;
        while (true) {
            System.out.print("Bạn muốn nhập bao nhiêu phòng hôm nay? ");
            String input = scanner.nextLine().trim();
            try {
                soPhong = Integer.parseInt(input);
                if (soPhong > 0) break;
                else System.out.println("Số phòng phải lớn hơn 0.");
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập một số nguyên hợp lệ.");
            }
        }
        for (int i = 0; i < soPhong; i++) {
            System.out.println("\nNhập thông tin phòng thứ " + (i + 1) + ":");

            String roomID;
            while (true) {
                System.out.print("Room ID: ");
                roomID = scanner.nextLine().trim();
                if (!roomID.isEmpty()) break;
                System.out.println("Room ID không được để trống.");
            }
            String roomAddress;
            while (true) {
                System.out.print("Địa chỉ phòng: ");
                roomAddress = scanner.nextLine().trim();
                if (!roomAddress.isEmpty()) break;
                System.out.println("Địa chỉ không được để trống.");
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
                    ngayThue = LocalDate.parse(inputDate);
                    break;
                } catch (DateTimeParseException e) {
                    System.out.println("Ngày không hợp lệ. Vui lòng nhập lại theo định dạng yyyy-MM-dd.");
                }
            }
            Tenant tenant = new Tenant(tenantID, tenantName, tenantPhone, ngayThue);

            
            Room room = new Room(roomID, price, landlord, tenant, roomAddress);

            roomManager.create(room);
        }
        return roomManager;
    }
}
