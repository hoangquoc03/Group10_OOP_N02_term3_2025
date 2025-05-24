package models;

import java.util.ArrayList;

public class Tenant {
    private String tenantID;
    private String name;
    private String phone;

    // Danh sách tenant
    private static ArrayList<Tenant> tenantList = new ArrayList<>();

    // Constructor
    public Tenant(String tenantID, String name, String phone) {
        this.tenantID = tenantID;
        this.name = name;
        this.phone = phone;
    }

    // Getter và Setter
    public String getTenantID() {
        return tenantID;
    }

    public void setTenantID(String tenantID) {
        this.tenantID = tenantID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    // Hiển thị thông tin tenant
    public void displayInfo() {
        System.out.println("Tenant ID: " + tenantID + ", Name: " + name + ", Phone: " + phone);
    }

    @Override
    public String toString() {
        return "Tenant ID: " + tenantID + ", Name: " + name + ", Phone: " + phone;
    }

    // Thêm tenant vào danh sách
    public static void addTenant(Tenant tenant) {
        tenantList.add(tenant);
        System.out.println("Đã thêm tenant: " + tenant.getTenantID());
    }

    // Cập nhật tenant theo tenantID
    public static boolean updateTenant(String tenantID, String newName, String newPhone) {
        for (Tenant tenant : tenantList) {
            if (tenant.getTenantID().equals(tenantID)) {
                tenant.setName(newName);
                tenant.setPhone(newPhone);
                System.out.println("Đã cập nhật tenant: " + tenantID);
                return true;
            }
        }
        System.out.println("Không tìm thấy tenant với ID: " + tenantID);
        return false;
    }

    // Xóa tenant theo tenantID
    public static boolean deleteTenant(String tenantID) {
        for (Tenant tenant : tenantList) {
            if (tenant.getTenantID().equals(tenantID)) {
                tenantList.remove(tenant);
                System.out.println("Đã xóa tenant: " + tenantID);
                return true;
            }
        }
        System.out.println("Không tìm thấy tenant để xóa với ID: " + tenantID);
        return false;
    }

    // Hiển thị tất cả tenant
    public static void displayTenants() {
        if (tenantList.isEmpty()) {
            System.out.println("Danh sách tenant đang rỗng.");
            return;
        }
        System.out.println("Danh sách tenant:");
        for (Tenant tenant : tenantList) {
            tenant.displayInfo();
        }
    }
}
