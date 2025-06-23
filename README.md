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
<img src="img/sequenceDiagram.png" alt="Sequence Diagram 1" width="400"/> 
## Class Diagram
<img src="img/classDiagram.png" alt="Sequence Diagram 2" width="400"/>
## Lưu đồ thuật toán: Thống kê người dùng/phòng đang thuê
 <img src="img/thuattoann.png" alt="Sequence Diagram 2" width="400"/>

## Lê Hồng Quốc : 
<img src="img/demo1.png" alt="Flowchart Algorithm" width="600"/>

## Đặng Thanh Tùng :

<img src="img/demo2.png" alt="Tenant UI Screenshot" width="600"/>

##  Lê Quang Thắng :
<img src="img/demo3.png" alt="Giao diện landlord" width="600"/>

## 📦 Mô hình đối tượng


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

Mã người thuê (nameID)

🔸 Quản lý Phòng trọ (Room)
Thêm, sửa, xoá phòng

Gán Tenant cho Room

Mỗi phòng chỉ có 1 tenant tại một thời điểm

🔸 Quản lý Chủ nhà (Landlord)
Thêm, sửa, xoá thông tin chủ nhà
