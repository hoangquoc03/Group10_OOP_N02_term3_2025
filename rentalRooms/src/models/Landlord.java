package models;

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
}
