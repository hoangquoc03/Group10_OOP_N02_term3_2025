import java.util.Scanner;
import models.Landlord;
import models.Room;
import models.Tenant;
import models.CrudManager;

import CRUD.PrintList;
import CRUD.Search;
import CRUD.Output;

import test.TestTenant;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // CRUD cho Landlord
            CrudManager<Landlord> landlordManager = new CrudManager<>();
            landlordManager.create(new Landlord("L1", "A", "0912345678"));
            landlordManager.create(new Landlord("L2", "B", "0987654321"));
            landlordManager.readAll();
            landlordManager.update("L1", new Landlord("L1", "A Updated", "0999999999"));
            landlordManager.delete("L2");

            // CRUD cho Room
            CrudManager<Room> roomManager = PrintList.nhapPhong();

            // Hiển thị bảng phòng
            Output.hienThiBangPhong(roomManager);

            // Tìm kiếm người thuê
            Search.timKiemNguoiThue(roomManager);

            // Hiển thị phòng gần đến ngày đóng tiền
            Search.hienThiPhongDenNgayDongTien(roomManager);

            // Tìm kiếm theo giá phòng
            Search.timKiemTheoGiaPhong(roomManager);

            // Một số hàm test
            System.out.println("\n=== TEST ===");
            Room.hienthiphong();
            Landlord.printinfo();

            // Gọi kiểm thử tenant (tự định nghĩa nếu cần)
            System.out.println("\n=== Test Tenant ===");
            TestTenant.main(null);  // gọi trực tiếp main() nếu chưa có test()

        } catch (Exception e) {
            System.out.println("Lỗi tổng quát trong chương trình: " + e.getMessage());
            e.printStackTrace();
        } finally {
            scanner.close();
            System.out.println("\nĐã đóng Scanner. Kết thúc chương trình.");
        }
    }
}
