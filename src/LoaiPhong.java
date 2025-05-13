

public class LoaiPhong {
    private String maPhong; // Mã phòng
    private double gia; // Giá thuê (VNĐ)

    // Constructor
    public LoaiPhong(String maPhong, double gia) {
        this.maPhong = maPhong;
        this.gia = gia;
    }

    // Getter và Setter
    public String getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    @Override
    public String toString() {
        return "LoaiPhong [maPhong=" + maPhong + ", gia=" + gia + "]";
    }
}