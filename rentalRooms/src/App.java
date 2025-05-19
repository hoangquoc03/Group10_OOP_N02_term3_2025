


//import test.testrentalroom;
import models.Landlord;
//import test.testRoom;
import models.Room;
import models.Tenant;


public class App {
    public static void main(String[] args) throws Exception {
        Room.hienthiphong();
        Landlord.printinfo();
        Tenant tenant1 = new Tenant("T001", "Nguyen Van A", "0987654321");
        tenant1.displayInfo();
    }
}
