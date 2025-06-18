package models;

<<<<<<< HEAD
import java.time.LocalDate;
import java.util.ArrayList;

public class Tenant implements Identifiable {
    private String id; // dùng chung cho mọi constructor
=======
public class Tenant implements Identifiable {
    private String tenantID;
>>>>>>> 36fae42 (updateInterface)
    private String name;
    private String phone;
    private LocalDate ngayThue; // ngày thuê

<<<<<<< HEAD
    // Danh sách tenant
    private static ArrayList<Tenant> tenantList = new ArrayList<>();

    // Constructor đầy đủ
    public Tenant(String id, String name, String phone, LocalDate ngayThue) {
        this.id = id;
=======
    public Tenant(String tenantID, String name, String phone) {
        this.tenantID = tenantID;
>>>>>>> 36fae42 (updateInterface)
        this.name = name;
        this.phone = phone;
        this.ngayThue = ngayThue;
    }

<<<<<<< HEAD
    // Constructor không có ngày thuê (test/sample)
    public Tenant(String id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.ngayThue = null;
    }

    // Implement từ interface Identifiable
    @Override
    public String getID() {
        return id;
    }

    // Getter
    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public LocalDate getNgayThue() {
        return ngayThue;
    }

    // Setter
    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setNgayThue(LocalDate ngayThue) {
        this.ngayThue = ngayThue;
    }

    // Hiển thị thông tin tenant
    public void displayInfo() {
        System.out.println("Tenant ID: " + id + ", Name: " + name + ", Phone: " + phone +
            (ngayThue != null ? ", Ngày thuê: " + ngayThue : ""));
    }

    // Override toString
    @Override
    public String toString() {
        return "Tenant ID: " + id + ", Name: " + name + ", Phone: " + phone +
            (ngayThue != null ? ", Ngày thuê: " + ngayThue : "");
    }

    // Thêm tenant vào danh sách
    public static void addTenant(Tenant tenant) {
        tenantList.add(tenant);
        System.out.println("Đã thêm tenant: " + tenant.getID());
    }

    // Cập nhật tenant theo ID
    public static boolean updateTenant(String tenantID, String newName, String newPhone) {
        for (Tenant tenant : tenantList) {
            if (tenant.getID().equals(tenantID)) {
                tenant.setName(newName);
                tenant.setPhone(newPhone);
                System.out.println("Đã cập nhật tenant: " + tenantID);
                return true;
            }
        }
        System.out.println("Không tìm thấy tenant với ID: " + tenantID);
        return false;
    }

    // Xóa tenant theo ID
    public static boolean deleteTenant(String tenantID) {
        for (Tenant tenant : tenantList) {
            if (tenant.getID().equals(tenantID)) {
                tenantList.remove(tenant);
                System.out.println("Đã xóa tenant: " + tenantID);
                return true;
            }
        }
        System.out.println("Không tìm thấy tenant để xóa với ID: " + tenantID);
        return false;
    }

    // Hiển thị tất cả tenants
    public static void displayTenants() {
        if (tenantList.isEmpty()) {
            System.out.println("Danh sách tenant đang rỗng.");
            return;
        }
        System.out.println("Danh sách tenant:");
        for (Tenant tenant : tenantList) {
            tenant.displayInfo();
        }
=======
    public String getID() {
        return tenantID;
    }

    public String toString() {
        return "Tenant: " + tenantID + ", Name: " + name + ", Phone: " + phone;
>>>>>>> 36fae42 (updateInterface)
    }

    // Tenant mẫu (test nhanh)
    public static void printSampleTenant() {
        Tenant t = new Tenant("T001", "Nguyen Van A", "0987654321");
        t.displayInfo();
    }
}
