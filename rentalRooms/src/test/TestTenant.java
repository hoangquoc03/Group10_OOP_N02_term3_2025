package test;

import models.Tenant;

public class TestTenant {
    public static void main(String[] args) {
        try {
            // Tạo tenant mới
            System.out.println("Tạo Tenant:");
            Tenant.createTenant("T001", "Nguyen Van B", "0123456789");
            Tenant.createTenant("T002", "Tran Thi C", "0987654321");
        } catch (Exception e) {
            System.out.println("Lỗi khi tạo tenant: " + e.getMessage());
        } finally {
            System.out.println("Hoàn tất bước tạo tenant.\n");
        }

        try {
            // Hiển thị danh sách tenant
            System.out.println("Danh sách Tenant ban đầu:");
            Tenant.readAllTenants();
        } catch (Exception e) {
            System.out.println("Lỗi khi đọc danh sách tenant: " + e.getMessage());
        } finally {
            System.out.println("Hoàn tất hiển thị danh sách ban đầu.\n");
        }

        try {
            // Cập nhật thông tin tenant
            System.out.println("Cập nhật Tenant T001:");
            Tenant.updateTenant("T001", "Nguyen Van B Updated", "0999999999");
        } catch (Exception e) {
            System.out.println("Lỗi khi cập nhật tenant: " + e.getMessage());
        } finally {
            System.out.println("Hoàn tất cập nhật.\n");
        }

        try {
            // Hiển thị danh sách sau cập nhật
            System.out.println("Danh sách sau cập nhật:");
            Tenant.readAllTenants();
        } catch (Exception e) {
            System.out.println("Lỗi khi hiển thị danh sách cập nhật: " + e.getMessage());
        } finally {
            System.out.println("Hoàn tất hiển thị danh sách sau cập nhật.\n");
        }

        try {
            // Xóa tenant
            System.out.println("Xóa Tenant T002:");
            Tenant.deleteTenant("T002");
        } catch (Exception e) {
            System.out.println("Lỗi khi xóa tenant: " + e.getMessage());
        } finally {
            System.out.println("Hoàn tất xóa tenant.\n");
        }

        try {
            // Hiển thị danh sách sau xóa
            System.out.println("Danh sách sau khi xóa:");
            Tenant.readAllTenants();
        } catch (Exception e) {
            System.out.println("Lỗi khi hiển thị danh sách sau xóa: " + e.getMessage());
        } finally {
            System.out.println("Hoàn tất hiển thị danh sách sau khi xóa.\n");
        }

        try {
            // In thông tin cá nhân
            System.out.println("Test printinfo():");
            Tenant.printinfo();
        } catch (Exception e) {
            System.out.println("Lỗi khi in thông tin cá nhân: " + e.getMessage());
        } finally {
            System.out.println("Hoàn tất test printinfo().\n");
        }
    }
}
