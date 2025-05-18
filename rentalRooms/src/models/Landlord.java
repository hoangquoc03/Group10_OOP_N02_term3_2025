package models;

public class Landlord implements Identifiable {
    private String id;
    private String name;
    private String sdt;
    private String diaChi;

    public Landlord(String id, String name, String sdt, String diaChi) {
        this.id = id;
        this.name = name;
        this.sdt = sdt;
        this.diaChi = diaChi;
    }

    // Nếu dùng phiên bản bên Test không có diaChi, ta có thể thêm constructor này
    public Landlord(String id, String name, String sdt) {
        this.id = id;
        this.name = name;
        this.sdt = sdt;
        this.diaChi = "";
    }

    public String getID() {
        return id;
    }

    public String getLandlordID() {  // bổ sung thêm nếu Test sử dụng
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

    public static void printinfo() {
        Landlord l = new Landlord("L1234", "ABC", "0912345678");
        String lid = l.getLandlordID();
        String name = l.getName();
        String sdt = l.getSdt();
        System.out.println("LandLord: " + lid + " Name: " + name + " So dien thoai: " + sdt);
    }
}
