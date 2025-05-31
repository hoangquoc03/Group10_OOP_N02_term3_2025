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

    public String getID() {
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

    
}
