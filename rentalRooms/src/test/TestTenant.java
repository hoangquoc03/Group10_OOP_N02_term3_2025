package test;

import models.Tenant;

public class TestTenant {
    public static void main(String[] args) {
        // Tạo tenant mới
        System.out.println("Tạo Tenant:");
        Tenant.createTenant("T001", "Nguyen Van B", "0123456789");
        Tenant.createTenant("T002", "Tran Thi C", "0987654321");

        // Hiển thị danh sách tenant
        System.out.println("\nDanh sách Tenant ban đầu:");
        Tenant.readAllTenants();

        // Cập nhật thông tin tenant
        System.out.println("\nCập nhật Tenant T001:");
        Tenant.updateTenant("T001", "Nguyen Van B Updated", "0999999999");

        // Hiển thị danh sách sau cập nhật
        System.out.println("\nDanh sách sau cập nhật:");
        Tenant.readAllTenants();

        // Xóa tenant
        System.out.println("\nXóa Tenant T002:");
        Tenant.deleteTenant("T002");

        // Hiển thị danh sách sau xóa
        System.out.println("\nDanh sách sau khi xóa:");
        Tenant.readAllTenants();

        // In thông tin cá nhân
        System.out.println("\nTest printinfo():");
        Tenant.printinfo();
    }
}
