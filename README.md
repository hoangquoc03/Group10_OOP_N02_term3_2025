# Quản lý nhà trọ - Group 10 - OOP N02 TERM 3 2025

## Nhóm thực hiện
- Đặng Thanh Tùng  
- Lê Hồng Quốc  
- Lê Quang Thắng  

## 🔗 Các liên kết quan trọng
- 🔗 [GitHub Repository](https://github.com/hoangquoc03/Group10_OOP_N02_term3_2025)
- 
- 📺 [Video demo ứng dụng (YouTube)](https://youtu.be/nww_GJxlJE4)
- 📺 [Do lỗi trên Youtube(video trong gg drive)](https://drive.google.com/drive/folders/1zNvW8aUyf9c_HzmPZ3qZWWWQywHfAoGm?usp=sharing)

## 🏠 Giới thiệu Dự án

Ứng dụng **Quản lý phòng trọ** giúp quản lý thông tin về người thuê, phòng trọ và chủ nhà, xây dựng bằng **Java Spring Boot**, sử dụng **file nhị phân** để lưu dữ liệu và các collection trong Java như `ArrayList`, `LinkedList`, `Map`.

---
## Sequence Diagram :

<img src="img/sequenceDiagram.png" alt="Sequence Diagram 1" width="600"/> 

## Class Diagram :

<img src="img/classDiagram1.png" alt="Sequence Diagram 2" width="600"/>

## Lưu đồ thuật toán: Thống kê người dùng/phòng đang thuê

 <img src="img/thuattoann.png" alt="Sequence Diagram 2" width="600"/>

## Lê Hồng Quốc : 
<img src="img/Room2.jpg" alt="Flowchart Algorithm" width="600"/>

## Đặng Thanh Tùng :

<img src="img/demo2.png" alt="Tenant UI Screenshot" width="600"/>

##  Lê Quang Thắng :
<img src="img/demo3.png" alt="Giao diện landlord" width="600"/>

## 📦 Mô hình đối tượng
class Room {
    String roomID;
    double price;
    status ENUM('available', 'occupied', 'maintenance'),
    landlord_id INT,
    tenant_id INT,
    rented_from DATE,
    due_date DATE,
    created_at DATETIME,
    updated_at DATETIME,
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

## 📋 Chức năng chính

| Đối tượng   | Chức năng                                        |
|-------------|--------------------------------------------------|
| Tenant      | Thêm/Sửa/Xoá  danh sách                          |
| Room        | Thêm/Sửa/Xoá,Xem,lọc Xem trạng thái, Gán tenant      |
| Landlord    | Thêm/Sửa/Xoá, Quản lý danh sách phòng sở hữu     |
| Contract    |  Thêm/Sửa/Xoá, Quản lý hợp đồng thuê phòng       |
| Thống kê    | Thống kê số lượng người dùng, phòng đang thuê    |
| phản hồi    | đang được nâng cấp thêm                          |
| hóa đơn     | đang được nâng cấp thêm                          |
| Thông báo   | đang được nâng cấp thêm mới hiện trên dashboard  |

## 🧪 Kiểm thử & Xử lý lỗi

- Sử dụng `try-catch` để bắt lỗi khi thao tác với cơ sở dữ liệu hoặc dữ liệu không hợp lệ.
- API REST sử dụng `ResponseEntity` để trả về mã lỗi HTTP phù hợp.
- Ví dụ:
try {
    // logic
} catch (Exception e) {
    return ResponseEntity.status(500).body("Lỗi: " + e.getMessage());
}

## ☁️ Kết nối Cơ sở dữ liệu:

- Cơ sở dữ liệu sử dụng: **MySQL trên nền tảng Aiven**
- Cấu hình trong `application.properties`:
spring.datasource.url=jdbc:mysql://mysql-1535c414-project-18.b.aivencloud.com:15714/db-onl?sslMode=REQUIRED&serverTimezone=Asia/Ho_Chi_Minh
spring.datasource.username=avnadmin
spring.datasource.password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver


## 👨‍🔧 Phân chia công việc nhóm

| Công việc                             | Lê Hồng Quốc     | Đặng Thanh Tùng | Lê Quang Thắng  |
|---------------------------------------|------------------|-----------------|-----------------|
| Phát triển quản lý người dùng         | 100%             |                 |                 |
| Phát triển quản lý chủ trọ            |                  |                 |100%             |
| Phát triển quản lý người thuê         |                  |100%             |                 |
| Phát triển quản lý phòng              | 100%             |                 |                 |
| Phát triển quản lý phòng sắp đến hạn  | 30%              |30%              |40%              |
| Phát triển quản lý hợp đồng           | 30%              |40%              |30%              |
| Phát triển giao diện người dùng       | 40%              |30%              |30%              |
| Thiết kế database                     | 50%              | 25%             | 25%             |
| Cài đặt database                      | 80%              | 10%             | 10%             |
| Thiết kế giao diện                    | 50%              | 30%             | 20%             |
| Viết báo cáo                          | 10%              | 80%             | 10%             |
| Làm PowerPoint                        | 10%              | 80%             |10%              |
| **Tỷ lệ đóng góp (%)**                | **50%**          | **25%**         | **25%**         |


