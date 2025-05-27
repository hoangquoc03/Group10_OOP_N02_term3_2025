
package test;

import models.Landlord;

public class LandlordTest {
    public static void main(String[] args) {
        // Thêm Landlord
        System.out.println(" Tạo Landlord ");
        Landlord.createLandlord("L001", "Nguyen Van A", "0901234567");
        Landlord.createLandlord("L002", "Tran Thi B", "0912345678");

        // Hiển thị danh sách
        System.out.println("\n Danh sách Landlord ban đầu ");
        Landlord.readAllLandlords();

        // Cập nhật
        System.out.println("\n Cập nhật Landlord L001 ");
        Landlord.updateLandlord("L001", "Nguyen Van A Updated", "0999999999");

        // Hiển thị sau cập nhật
        System.out.println("\n Danh sách sau cập nhật ");
        Landlord.readAllLandlords();

        // Xóa
        System.out.println("\n Xóa Landlord L002 ");
        Landlord.deleteLandlord("L002");

        // Hiển thị sau khi xóa
        System.out.println("\n Danh sách sau khi xóa ");
        Landlord.readAllLandlords();

        // Kiểm tra in thông tin cá nhân
        System.out.println("\n Test printinfo() ");
        Landlord.printinfo();
    }
}