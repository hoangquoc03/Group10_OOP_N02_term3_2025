package models;

public class Tenant {
    private String tenantID;
    private String name;
    private String phone;

    // Constructor
    public Tenant(String tenantID, String name, String phone) {
        this.tenantID = tenantID;
        this.name = name;
        this.phone = phone;
    }

    // Getter and Setter
    public String getTenantID() {
        return tenantID;
    }

    public void setTenantID(String tenantID) {
        this.tenantID = tenantID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    // Method instance in thông tin tenant
    public void displayInfo() {
        System.out.println("Tenant ID: " + tenantID + ", Name: " + name + ", Phone: " + phone);
    }

    // Override toString để in đối tượng dễ dàng hơn
    @Override
    public String toString() {
        return "Tenant ID: " + tenantID + ", Name: " + name + ", Phone: " + phone;
    }

    // Method static in thông tin tenant mẫu
    public static void printSampleTenant() {
        Tenant t = new Tenant("T001", "Nguyen Van A", "0987654321");
        t.displayInfo();
    }
}
