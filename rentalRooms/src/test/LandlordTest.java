package test;

import models.Landlord;

public class LandlordTest {
    public static void main(String[] args) {

        // Thêm Landlord
        try {
            System.out.println("Tạo Landlord:");
            Landlord.createLandlord("L001", "Nguyen Van A", "0901234567");
            Landlord.createLandlord("L002", "Tran Thi B", "0912345678");
        } catch (Exception e) {
            System.out.println("Lỗi khi thêm Landlord: " + e.getMessage());
        } finally {
            System.out.println("Hoàn tất bước thêm Landlord.\n");
        }

        // Hiển thị danh sách
        try {
            System.out.println("Danh sách Landlord ban đầu:");
            Landlord.readAllLandlords();
        } catch (Exception e) {
            System.out.println("Lỗi khi hiển thị danh sách: " + e.getMessage());
        } finally {
            System.out.println("Hoàn tất bước hiển thị danh sách.\n");
        }

        // Cập nhật
        try {
            System.out.println("Cập nhật Landlord L001:");
            Landlord.updateLandlord("L001", "Nguyen Van A Updated", "0999999999");
        } catch (Exception e) {
            System.out.println("Lỗi khi cập nhật Landlord: " + e.getMessage());
        } finally {
            System.out.println("Hoàn tất bước cập nhật.\n");
        }

        // Hiển thị sau cập nhật
        try {
            System.out.println("Danh sách sau cập nhật:");
            Landlord.readAllLandlords();
        } catch (Exception e) {
            System.out.println("Lỗi khi hiển thị danh sách sau cập nhật: " + e.getMessage());
        } finally {
            System.out.println("Hoàn tất hiển thị sau cập nhật.\n");
        }

        // Xóa
        try {
            System.out.println("Xóa Landlord L002:");
            Landlord.deleteLandlord("L002");
        } catch (Exception e) {
            System.out.println("Lỗi khi xóa Landlord: " + e.getMessage());
        } finally {
            System.out.println("Hoàn tất bước xóa.\n");
        }

        // Hiển thị sau khi xóa
        try {
            System.out.println("Danh sách sau khi xóa:");
            Landlord.readAllLandlords();
        } catch (Exception e) {
            System.out.println("Lỗi khi hiển thị danh sách sau khi xóa: " + e.getMessage());
        } finally {
            System.out.println("Hoàn tất hiển thị sau khi xóa.\n");
        }

        // Kiểm tra in thông tin cá nhân
        try {
            System.out.println("Test printinfo():");
            Landlord.printinfo();
        } catch (Exception e) {
            System.out.println("Lỗi khi in thông tin cá nhân: " + e.getMessage());
        } finally {
            System.out.println("Hoàn tất kiểm tra printinfo().");
        }
    }
}
