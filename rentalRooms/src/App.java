
//import test.testrentalroom;
import models.Landlord;
//import test.testRoom;
import models.Room;
import models.Tenant;
import models.CrudManager;
import models.Identifiable;
public class App {
    public static void main(String[] args) throws Exception {
        // Phan du lieu o duoi minh cho vao file test như TestTanant
        // Tenant tenant1 = new Tenant("T001", "Nguyen Van A", "0987654321");
        // tenant1.displayInfo();
        CrudManager<Landlord> landlordManager = new CrudManager<>();
        landlordManager.create(new Landlord("L1", "A", "0912345678"));
        landlordManager.create(new Landlord("L2", "B", "0987654321"));
        landlordManager.readAll();
        landlordManager.update("L1", new Landlord("L1", "A Updated", "0999999999"));
        landlordManager.delete("L2");

        System.out.println("\nQuản lý phòng:");
        CrudManager<Room> roomManager = new CrudManager<>();
        roomManager.create(new Room("R1", 1000));
        roomManager.readAll();

        System.out.println("\nQuản lý tenant:");
        CrudManager<Tenant> tenantManager = new CrudManager<>();
        tenantManager.create(new Tenant("T1", "Nguyen Van A", "0123456789"));
        tenantManager.readAll();
    }
}
