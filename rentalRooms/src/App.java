
//import test.testrentalroom;
import models.Landlord;
//import test.testRoom;
import models.Room;
import models.Tenant;
import test.TestTenant;

public class App {
    public static void main(String[] args) throws Exception {
        Room.hienthiphong();
        Landlord.printinfo();

        // Phan du lieu o duoi minh cho vao file test như TestTanant
        // Tenant tenant1 = new Tenant("T001", "Nguyen Van A", "0987654321");
        // tenant1.displayInfo();

        TestTenant.test();
    }
}
