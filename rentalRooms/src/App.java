import java.util.Scanner;
import models.Landlord;
import models.Room;
import models.Tenant;
import models.CrudManager;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import CRUD.PrintList;
import CRUD.Search;
import CRUD.Output;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CrudManager<Landlord> landlordManager = new CrudManager<>();
        
        // Chỉ khai báo roomManager một lần
        CrudManager<Room> roomManager = PrintList.nhapPhong();

        // Hiển thị danh sách phòng
        Output.hienThiBangPhong(roomManager);

        // Tìm kiếm người thuê
        Search.timKiemNguoiThue(roomManager);

        // Kiểm tra nếu hôm nay là ngày đóng tiền tháng mới
        Search.hienThiPhongDenNgayDongTien(roomManager);

        // Tìm kiếm giá phòng
        Search.timKiemTheoGiaPhong(roomManager);

    }
}
