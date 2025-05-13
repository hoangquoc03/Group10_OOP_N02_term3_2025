public class Main {
    public static void main(String[] arg){
        ChuPhong one = new ChuPhong("23010236","Quang Thang","0999999999999");
        System.out.println(one.toString());
        LoaiPhong one1 = new LoaiPhong("VIP",4000000);
        System.out.println(one1.toString());
        NguoiThuePhong one2 = new NguoiThuePhong("999999999","123456789");
        System.out.println(one2.toString());
    }
}
