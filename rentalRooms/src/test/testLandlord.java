package test;

import models.Landlord;

<<<<<<< HEAD
public class LandlordTest {
    public static void main(String[] args) {
        // Thêm Landlord
        System.out.println("Tạo Landlord:");
        Landlord.createLandlord("L001", "Nguyen Van A", "0901234567");
        Landlord.createLandlord("L002", "Tran Thi B", "0912345678");

        // Hiển thị danh sách
        System.out.println("\nDanh sách Landlord ban đầu:");
        Landlord.readAllLandlords();

        // Cập nhật
        System.out.println("\nCập nhật Landlord L001:");
        Landlord.updateLandlord("L001", "Nguyen Van A Updated", "0999999999");

        // Hiển thị sau cập nhật
        System.out.println("\nDanh sách sau cập nhật:");
        Landlord.readAllLandlords();

        // Xóa
        System.out.println("\nXóa Landlord L002:");
        Landlord.deleteLandlord("L002");

        // Hiển thị sau khi xóa
        System.out.println("\nDanh sách sau khi xóa:");
        Landlord.readAllLandlords();

        // Kiểm tra in thông tin cá nhân
        System.out.println("\nTest printinfo():");
        Landlord.printinfo();
    }
}
=======
public class testLandlord {
    
}
>>>>>>> 36fae42 (updateInterface)
