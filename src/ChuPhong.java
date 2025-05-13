

public class ChuPhong {
    private String lanlordID; // ID chủ phòng
    private String name; // Tên chủ phòng
    private String soDienThoai; // Số điện thoại

    // Constructor
    public ChuPhong(String lanlordID, String name, String soDienThoai) {
        this.lanlordID = lanlordID;
        this.name = name;
        this.soDienThoai = soDienThoai;
    }

    // Getter và Setter
    public String getLanlordID() {
        return lanlordID;
    }

    public void setLanlordID(String lanlordID) {
        this.lanlordID = lanlordID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    @Override
    public String toString() {
        return "ChuPhong [lanlordID=" + lanlordID + ", name=" + name + ", soDienThoai=" + soDienThoai + "]";
    }
}