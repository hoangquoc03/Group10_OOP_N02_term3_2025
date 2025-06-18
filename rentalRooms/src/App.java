import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import models.Landlord;
import models.Room;
import models.Tenant;
import models.CrudManager;
<<<<<<< HEAD

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

        // Gọi các hàm từ nhánh khác
        System.out.println("Hello, World!");
        testrentalroom.rentalroom();
        Room.hienthiphong();
        Landlord.printinfo();

        // Gọi phương thức test tenant
        TestTenant.test();
=======
import models.Identifiable;
public class App {
    public static void main(String[] args) throws Exception {
        // Phan du lieu o duoi minh cho vao file test như TestTanant
        // Tenant tenant1 = new Tenant("T001", "Nguyen Van A", "0987654321");
        // tenant1.displayInfo();
        CrudManager<Landlord> landlordManager = new CrudManager<>();
        landlordManager.create(new Landlord("L1", "A", "0912345678"));
        landlordManager.create(new Landlord("L2", "B", "0987654321"));
        landlordManager.readAll();
        landlordManager.update("L1", new Landlord("L1", "A Updated", "0999999999"));
        landlordManager.delete("L2");

        System.out.println("\nQuản lý phòng:");
        CrudManager<Room> roomManager = new CrudManager<>();
        roomManager.create(new Room("R1", 1000));
        roomManager.readAll();

        System.out.println("\nQuản lý tenant:");
        CrudManager<Tenant> tenantManager = new CrudManager<>();
        tenantManager.create(new Tenant("T1", "Nguyen Van A", "0123456789"));
        tenantManager.readAll();
>>>>>>> 36fae42 (updateInterface)
    }
}
