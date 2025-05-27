package models;

public class Tenant implements Identifiable {
    private String tenantID;
    private String name;
    private String phone;

    public Tenant(String tenantID, String name, String phone) {
        this.tenantID = tenantID;
        this.name = name;
        this.phone = phone;
    }

    public String getID() {
        return tenantID;
    }

    public String toString() {
        return "Tenant: " + tenantID + ", Name: " + name + ", Phone: " + phone;
    }
}
