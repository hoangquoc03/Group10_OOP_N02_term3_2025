


import models.Room;






public class testRoom{


    public static void hienthiphong(){

     Room r = new Room("r12345", 2300);

     String id = r.getRoomID();
     double price= r.getPrice();


     System.out.println("Hien thi thong tin phong:"+ id +" sotien: " +price); 

     System.out.println("test:");
        
    }



}