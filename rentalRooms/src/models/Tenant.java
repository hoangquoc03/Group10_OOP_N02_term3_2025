package models;

import java.time.LocalDate;

public class Tenant {
    private String id;
    private String name;
    private String phone;
    private LocalDate ngayThue; // ✅ Thêm thuộc tính này

    public Tenant(String id, String name, String phone, LocalDate ngayThue) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.ngayThue = ngayThue;
    }

    // Getter
    public String getID() { return id; }
    public String getName() { return name; }
    public String getPhone() { return phone; }
    public LocalDate getNgayThue() { return ngayThue; }

    // Setter (nếu cần)
    public void setNgayThue(LocalDate ngayThue) { this.ngayThue = ngayThue; }
}
