package models;

import java.util.ArrayList;
import java.util.List;

public class Landlord {
    private String landlordID;
    private String name;
    private String sdt;

    public Landlord(String landlordID, String name, String sdt) {
        this.landlordID = landlordID;
        this.name = name;
        this.sdt = sdt;
    }

    public String getLandlordID() {
        return landlordID;
    }

    public void setLandlordID(String landlordID) {
        this.landlordID = landlordID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    // Danh sách để lưu các đối tượng Landlord
    private static List<Landlord> landlords = new ArrayList<>();

    // Create: Thêm một Landlord mới
    public static void createLandlord(String landlordID, String name, String sdt) {
        Landlord newLandlord = new Landlord(landlordID, name, sdt);
        landlords.add(newLandlord);
        System.out.println("Đã thêm Landlord: " + name);
    }

    // Read: Hiển thị thông tin tất cả Landlord
    public static void readAllLandlords() {
        if (landlords.isEmpty()) {
            System.out.println("Không có Landlord nào.");
            return;
        }
        for (Landlord l : landlords) {
            System.out.println("Landlord: " + l.getLandlordID() + " Name: " + l.getName() + " Số điện thoại: " + l.getSdt());
        }
    }

    // Update: Cập nhật thông tin Landlord theo landlordID
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

    // Delete: Xóa Landlord theo landlordID
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

    // Phương thức main để kiểm tra CRUD
    public static void main(String[] args) {
        // Thêm 3 Landlord
        createLandlord("L1234", "ABC", "0912345678");
        createLandlord("L5678", "XYZ", "0987654321");
        createLandlord("L9012", "DEF", "0934567890");

        // Hiển thị tất cả
        System.out.println("Danh sách Landlord:");
        readAllLandlords();

        // Cập nhật thông tin
        updateLandlord("L5678", "XYZ Updated", "0911111111");

        // Hiển thị lại sau khi cập nhật
        System.out.println("\nDanh sách sau khi cập nhật:");
        readAllLandlords();

        // Xóa một Landlord
        deleteLandlord("L1234");

        // Hiển thị lại sau khi xóa
        System.out.println("\nDanh sách sau khi xóa:");
        readAllLandlords();
    }

    // Giữ nguyên phương thức printinfo cũ
    public static void printinfo() {
        Landlord l = new Landlord("L1234", "ABC", "0912345678");
        String lid = l.getLandlordID();
        String name = l.getName();
        String sdt = l.getSdt();
        System.out.println("LandLord:" + lid + " Name :" + name + " So dien thoai:" + sdt);
    }
}