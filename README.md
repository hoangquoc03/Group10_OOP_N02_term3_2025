# Group 10 OOP N02 TERM 3 2025
Group 10: OOP Term 3 2025 K17
## Thành viên
Đặng Thanh Tùng
Lê Hồng Quốc
Lê Quang Thắng
## Tiêu đề

Quản lý nhà trọ

## ReadMe Giới thiệu Project
[Link].https://github.com/hoangquoc03/Group10_OOP_N02_term3_2025
## Đối tượng
class Room{
RoomID;
Price;
}
Class Tenant {
nameT;
nameID;
phoneTenant;
phongthue;
}
class Landlord {
lanlordID;
nameL;
phoneLandlord;
}

#Yêu cầu số 3
##Nội dung 01:
Xây dựng ứng dụng Quản lý phòng trọ

Yêu cầu:
- Giao diện Java Spring Boot.
- Có chức năng quản lý Người thuê (Tenant):

+ Thêm, sửa, xóa Tenant

+ Liệt kê thông tin về Name,nameID,phoneTenant có thể lọc ra các người thuê theo tên(nameT),số điện thoại(phoneTenant) hoặc mã người thuê(nameId). 
- Có chức năng quản lý phòng trọ(Room):

+ Thêm, sửa, xóa Room
- Có chức năng gán Tenant cho phòng(Room).
- Mỗi Room chỉ được gán cho một Tenant tại một thời điểm. 

- Dữ liệu được lưu trữ xuống file nhị phân

+ Cần tạo các lớp liên quan đến Room, Tenant, và Landlord để đọc, ghi xuống 1 hay nhiều file.
- TenantService, RoomService, LandlordService để thao tác dữ liệu.
- Khi làm việc với dữ liệu trong bộ nhớ, dữ liệu cần được lưu trữ dưới dạng các Collection tùy chọn như ArrayList, LinkedList, Map, ....
- Arrayist<Room>,LinkedList<Tenant>.
- Sinh viên có thể thêm các chức năng vào chương trình để ứng dụng phong phú hơn bằng cách thêm các nghiệp vụ cho bài toán (tùy chọn)
  ## Nội dung 2:
  <img src ="img/group10noidung2.png">
 Sequence Diagram
 <img src ="img/group10noidung3.png">
 
