package models;

public class Tenant {
    private String name;
    private String cccd;
    private String sdt;
    private Room phongThue;

    public Tenant(String name, String cccd, String sdt, Room phongThue) {
        this.name = name;
        this.cccd = cccd;
        this.sdt = sdt;
        this.phongThue = phongThue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public Room getPhongThue() {
        return phongThue;
    }

    public void setPhongThue(Room phongThue) {
        this.phongThue = phongThue;
    }
}
