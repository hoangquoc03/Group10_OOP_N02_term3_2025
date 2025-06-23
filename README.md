# Quản lý nhà trọ - Group 10 OOP N02 TERM 3 2025

## Nhóm thực hiện
- Đặng Thanh Tùng  
- Lê Hồng Quốc  
- Lê Quang Thắng  

## Repository
🔗 [GitHub Repository](https://github.com/hoangquoc03/Group10_OOP_N02_term3_2025)

---

## 🏠 Giới thiệu Dự án

Ứng dụng **Quản lý phòng trọ** giúp quản lý thông tin về người thuê, phòng trọ và chủ nhà, xây dựng bằng **Java Spring Boot**, sử dụng **file nhị phân** để lưu dữ liệu và các collection trong Java như `ArrayList`, `LinkedList`, `Map`.

---
## Sequence Diagram
<img src="img/group10noidung2.png" alt="Sequence Diagram 1" width="400"/> <img src="img/group10noidung3.png" alt="Sequence Diagram 2" width="400"/>
## Lưu đồ thuật toán: kiemTraNgayDongTien()
 <img src="img/thuattoanbai5.png" alt="Sequence Diagram 2" width="400"/>

## Lê Hồng Quốc : 
<img src="img/demo1.png" alt="Flowchart Algorithm" width="600"/>

## Đặng Thanh Tùng :

<img src="img/demo2.png" alt="Tenant UI Screenshot" width="600"/>

##  Lê Quang Thắng :
<img src="img/demo3.png" alt="Giao diện landlord" width="600"/>

## 📦 Mô hình đối tượng

```java
class Room {
    String roomID;
    double price;
}

class Tenant {
    String nameT;
    String nameID;
    String phoneTenant;
    String phongThue;
}

class Landlord {
    String landlordID;
    String nameL;
    String phoneLandlord;
}
Chức năng chính
🔸 Quản lý Người thuê (Tenant)
Thêm, sửa, xoá tenant

Liệt kê thông tin tenant: nameT, nameID, phoneTenant

Lọc tenant theo:

Tên (nameT)

Số điện thoại (phoneTenant)

Mã người thuê (nameID)

🔸 Quản lý Phòng trọ (Room)
Thêm, sửa, xoá phòng

Gán Tenant cho Room

Mỗi phòng chỉ có 1 tenant tại một thời điểm

🔸 Quản lý Chủ nhà (Landlord)
Thêm, sửa, xoá thông tin chủ nhà


💾 Lưu trữ dữ liệu
Dữ liệu được lưu dưới dạng file nhị phân

Dùng các class Room, Tenant, Landlord để đọc/ghi file

Sử dụng các lớp RoomService, TenantService, LandlordService để thao tác dữ liệu

Dữ liệu trong bộ nhớ được lưu dưới dạng:

ArrayList<Room>

LinkedList<Tenant>

Map<String, Landlord>

📈 Sơ đồ & Thuật toán
🔹 Sequence Diagram
<img src="img/group10noidung2.png" alt="Sequence Diagram 1" width="400"/> <img src="img/group10noidung3.png" alt="Sequence Diagram 2" width="400"/>
🔹 Lưu đồ thuật toán: kiemTraNgayDongTien()
<img src="img/bai7_room-Le-hong-quoc.png" alt="Flowchart Algorithm" width="600"/>
