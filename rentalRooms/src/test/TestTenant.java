package test;

import models.Tenant;

public class TestTenant {
    public static void main(String[] args) {
        // Thêm tenant
        Tenant.addTenant(new Tenant("T001", "Nguyen Van A", "0123456789"));
        Tenant.addTenant(new Tenant("T002", "Tran Thi B", "0987654321"));
        Tenant.addTenant(new Tenant("T003", "Le Van C", "0911222333"));

        // Hiển thị tất cả tenant
        System.out.println("Danh sách tenant sau khi thêm:");
        Tenant.displayTenants();

        // Cập nhật tenant
        Tenant.updateTenant("T002", "Tran Thi B Updated", "0999888777");

        // Xóa tenant
        Tenant.deleteTenant("T001");

        // Hiển thị lại danh sách sau cập nhật và xóa
        System.out.println("\nDanh sách tenant sau khi cập nhật và xóa:");
        Tenant.displayTenants();
    }
}
