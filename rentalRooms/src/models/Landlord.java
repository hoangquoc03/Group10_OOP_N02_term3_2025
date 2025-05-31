package models;

public class Landlord implements Identifiable {
    private String landlordID;
    private String name;
    private String sdt;

    public Landlord(String landlordID, String name, String sdt) {
        this.landlordID = landlordID;
        this.name = name;
        this.sdt = sdt;
    }

    public String toString() {
        return "Landlord: " + landlordID + ", Name: " + name + ", SĐT: " + sdt;
    }
    public String getID() {
        return landlordID;
    }

    public String getName() {
        return name;
    }

    public String getSdt() {
        return sdt;
    }

}
