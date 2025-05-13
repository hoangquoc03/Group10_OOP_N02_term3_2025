

public class NguoiThuePhong {
    private String cccd; // Căn cước công dân
    private String soDienThoai; // Số điện thoại

    // Constructor
    public NguoiThuePhong(String cccd, String soDienThoai) {
        this.cccd = cccd;
        this.soDienThoai = soDienThoai;
    }

    // Getter và Setter
    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    @Override
    public String toString() {
        return "NguoiThuePhong [cccd=" + cccd + ", soDienThoai=" + soDienThoai + "]";
    }
}