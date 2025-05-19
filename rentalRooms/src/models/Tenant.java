package models;

import java.time.LocalDate;

public class Tenant implements Identifiable {
    private String id;
    private String name;
    private String phone;
    private LocalDate ngayThue; // ✅ Thêm thuộc tính ngày thuê

    // Constructor có ngày thuê
    public Tenant(String id, String name, String phone, LocalDate ngayThue) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.ngayThue = ngayThue;
    }

    // Constructor không có ngày thuê (dùng cho test/sample)
    public Tenant(String id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.ngayThue = null;
    }

    // Getter
    public String getID() { return id; }
    public String getName() { return name; }
    public String getPhone() { return phone; }
    public LocalDate getNgayThue() { return ngayThue; }

    // Setter
    public void setName(String name) { this.name = name; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setNgayThue(LocalDate ngayThue) { this.ngayThue = ngayThue; }

    // In thông tin tenant
    public void displayInfo() {
        System.out.println("Tenant ID: " + id + ", Name: " + name + ", Phone: " + phone +
            (ngayThue != null ? ", Ngày thuê: " + ngayThue.toString() : ""));
    }

    // Override toString để dễ in
    @Override
    public String toString() {
        return "Tenant ID: " + id + ", Name: " + name + ", Phone: " + phone +
            (ngayThue != null ? ", Ngày thuê: " + ngayThue.toString() : "");
    }

    // Tenant mẫu
    public static void printSampleTenant() {
        Tenant t = new Tenant("T001", "Nguyen Van A", "0987654321");
        t.displayInfo();
    }
}
