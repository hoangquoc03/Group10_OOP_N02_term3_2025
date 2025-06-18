import java.util.Scanner;
import models.Landlord;
import models.Room;
import models.Tenant;
import models.CrudManager;

import CRUD.PrintList;
import CRUD.Search;
import CRUD.Output;

import test.testrentalroom;
import test.TestTenant;

public class App {
    public static void main(String[] args) throws Exception {
        // Khởi tạo Scanner và các CRUD manager
        Scanner scanner = new Scanner(System.in);
        CrudManager<Landlord> landlordManager = new CrudManager<>();

        // Thêm một vài landlord để demo (từ nhánh test)
        landlordManager.create(new Landlord("L1", "A", "0912345678"));
        landlordManager.create(new Landlord("L2", "B", "0987654321"));
        landlordManager.readAll();
        landlordManager.update("L1", new Landlord("L1", "A Updated", "0999999999"));
        landlordManager.delete("L2");

        // Nhập danh sách phòng
        CrudManager<Room> roomManager = PrintList.nhapPhong();

        // Hiển thị danh sách phòng
        Output.hienThiBangPhong(roomManager);

        // Tìm kiếm người thuê
        Search.timKiemNguoiThue(roomManager);

        // Kiểm tra ngày đóng tiền
        Search.hienThiPhongDenNgayDongTien(roomManager);

        // Tìm kiếm theo giá phòng
        Search.timKiemTheoGiaPhong(roomManager);

        // Test nhanh từ các class
        System.out.println("Hello, World!");
        testrentalroom.rentalroom();
        Room.hienthiphong();
        Landlord.printinfo();

        // Gọi phương thức test tenant
        TestTenant.test();

        scanner.close();
    }
}
