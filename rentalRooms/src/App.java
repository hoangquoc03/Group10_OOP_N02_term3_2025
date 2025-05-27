import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

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
    }
}
