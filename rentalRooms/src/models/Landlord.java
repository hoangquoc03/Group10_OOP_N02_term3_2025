package models;

import java.util.ArrayList;
import java.util.List;

public class Landlord implements Identifiable {
    private String id;
    private String name;
    private String sdt;
    private String diaChi;

    // Constructor đầy đủ
    public Landlord(String id, String name, String sdt, String diaChi) {
        this.id = id;
        this.name = name;
        this.sdt = sdt;
        this.diaChi = diaChi;
    }

    // Constructor không có địa chỉ
    public Landlord(String id, String name, String sdt) {
        this(id, name, sdt, "");
    }

    // Getter
    public String getID() {
        return id;
    }

    public String getLandlordID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSdt() {
        return sdt;
    }

    public String getDiaChi() {
        return diaChi;
    }

    // Setter
    public void setName(String name) {
        this.name = name;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    // ======= CRUD Static List =======
    private static List<Landlord> landlords = new ArrayList<>();

    // Create
    public static void createLandlord(String landlordID, String name, String sdt) {
        Landlord newLandlord = new Landlord(landlordID, name, sdt);
        landlords.add(newLandlord);
        System.out.println("Đã thêm Landlord: " + name);
    }

    // Read
    public static void readAllLandlords() {
        if (landlords.isEmpty()) {
            System.out.println("Không có Landlord nào.");
            return;
        }
        for (Landlord l : landlords) {
            System.out.println("Landlord: " + l.getLandlordID() + " Name: " + l.getName() + " Số điện thoại: " + l.getSdt());
        }
    }

    // Update
    public static void updateLandlord(String landlordID, String newName, String newSdt) {
        for (Landlord l : landlords) {
            if (l.getLandlordID().equals(landlordID)) {
                l.setName(newName);
                l.setSdt(newSdt);
                System.out.println("Đã cập nhật thông tin Landlord: " + landlordID);
                return;
            }
        }
        System.out.println("Không tìm thấy Landlord với ID: " + landlordID);
    }

    // Delete
    public static void deleteLandlord(String landlordID) {
        for (int i = 0; i < landlords.size(); i++) {
            if (landlords.get(i).getLandlordID().equals(landlordID)) {
                landlords.remove(i);
                System.out.println("Đã xóa Landlord với ID: " + landlordID);
                return;
            }
        }
        System.out.println("Không tìm thấy Landlord với ID: " + landlordID);
    }

    // printinfo đơn giản
    public static void printinfo() {
        Landlord l = new Landlord("L1234", "ABC", "0912345678");
        System.out.println("LandLord: " + l.getLandlordID() + " Name: " + l.getName() + " So dien thoai: " + l.getSdt());
    }

    // toString override
    @Override
    public String toString() {
        return "Landlord: " + id + ", Name: " + name + ", SĐT: " + sdt;
    }

    // Kiểm tra nhanh
    public static void main(String[] args) {
        createLandlord("L1234", "ABC", "0912345678");
        createLandlord("L5678", "XYZ", "0987654321");
        createLandlord("L9012", "DEF", "0934567890");

        System.out.println("Danh sách Landlord:");
        readAllLandlords();

        updateLandlord("L5678", "XYZ Updated", "0911111111");
        System.out.println("\nDanh sách sau khi cập nhật:");
        readAllLandlords();

        deleteLandlord("L1234");
        System.out.println("\nDanh sách sau khi xóa:");
        readAllLandlords();
    }
}
