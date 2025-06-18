package models;

import java.time.LocalDate;
import java.util.ArrayList;

public class Tenant implements Identifiable {
    private String id;
    private String name;
    private String phone;
    private LocalDate ngayThue; // ngày thuê

    private static ArrayList<Tenant> tenantList = new ArrayList<>();

    public Tenant(String id, String name, String phone, LocalDate ngayThue) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.ngayThue = ngayThue;
    }

    public Tenant(String id, String name, String phone) {
        this(id, name, phone, null);
    }

    @Override
    public String getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public LocalDate getNgayThue() {
        return ngayThue;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setNgayThue(LocalDate ngayThue) {
        this.ngayThue = ngayThue;
    }

    public void displayInfo() {
        System.out.println("Tenant ID: " + id + ", Name: " + name + ", Phone: " + phone +
                (ngayThue != null ? ", Ngày thuê: " + ngayThue : ""));
    }

    @Override
    public String toString() {
        return "Tenant ID: " + id + ", Name: " + name + ", Phone: " + phone +
                (ngayThue != null ? ", Ngày thuê: " + ngayThue : "");
    }

    // ---------------------------
    // STATIC METHODS WITH TRY-CATCH
    // ---------------------------

    public static void addTenant(Tenant tenant) {
        try {
            tenantList.add(tenant);
            System.out.println("Đã thêm tenant: " + tenant.getID());
        } catch (Exception e) {
            System.out.println("Lỗi khi thêm tenant: " + e.getMessage());
        } finally {
            System.out.println("Thực hiện thêm tenant xong.");
        }
    }

    public static boolean updateTenant(String tenantID, String newName, String newPhone) {
        try {
            for (Tenant tenant : tenantList) {
                if (tenant.getID().equals(tenantID)) {
                    tenant.setName(newName);
                    tenant.setPhone(newPhone);
                    System.out.println("Đã cập nhật tenant: " + tenantID);
                    return true;
                }
            }
            System.out.println("Không tìm thấy tenant với ID: " + tenantID);
        } catch (Exception e) {
            System.out.println("Lỗi khi cập nhật tenant: " + e.getMessage());
        } finally {
            System.out.println("Thực hiện cập nhật tenant xong.");
        }
        return false;
    }

    public static boolean deleteTenant(String tenantID) {
        try {
            for (Tenant tenant : tenantList) {
                if (tenant.getID().equals(tenantID)) {
                    tenantList.remove(tenant);
                    System.out.println("Đã xóa tenant: " + tenantID);
                    return true;
                }
            }
            System.out.println("Không tìm thấy tenant để xóa với ID: " + tenantID);
        } catch (Exception e) {
            System.out.println("Lỗi khi xóa tenant: " + e.getMessage());
        } finally {
            System.out.println("Thực hiện xóa tenant xong.");
        }
        return false;
    }

    public static void displayTenants() {
        try {
            if (tenantList.isEmpty()) {
                System.out.println("Danh sách tenant đang rỗng.");
                return;
            }
            System.out.println("Danh sách tenant:");
            for (Tenant tenant : tenantList) {
                tenant.displayInfo();
            }
        } catch (Exception e) {
            System.out.println("Lỗi khi hiển thị tenants: " + e.getMessage());
        } finally {
            System.out.println("Kết thúc hiển thị danh sách tenants.");
        }
    }

    public static void printSampleTenant() {
        try {
            Tenant t = new Tenant("T001", "Nguyen Van A", "0987654321");
            t.displayInfo();
        } catch (Exception e) {
            System.out.println("Lỗi khi in tenant mẫu: " + e.getMessage());
        } finally {
            System.out.println("Hoàn thành in tenant mẫu.");
        }
    }

    // ---------------------------
    // CÁC PHƯƠNG THỨC DÙNG CHO TEST FILE
    // ---------------------------

    public static void createTenant(String id, String name, String phone) {
        try {
            Tenant newTenant = new Tenant(id, name, phone);
            addTenant(newTenant);
        } catch (Exception e) {
            System.out.println("Lỗi khi tạo tenant từ createTenant(): " + e.getMessage());
        } finally {
            System.out.println("Kết thúc createTenant().");
        }
    }

    public static void readAllTenants() {
        displayTenants();
    }

    public static void printinfo() {
        printSampleTenant();
    }
}
