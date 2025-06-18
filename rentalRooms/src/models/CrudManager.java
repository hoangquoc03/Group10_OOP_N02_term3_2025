package models;

import java.util.ArrayList;
import java.util.List;

<<<<<<< HEAD

=======
/**
 * Lớp tổng quát quản lý CRUD cho mọi đối tượng có ID (Identifiable)
 */
>>>>>>> 36fae42 (updateInterface)
public class CrudManager<T extends Identifiable> {
    private List<T> items = new ArrayList<>();

    // Create: thêm đối tượng mới
    public void create(T item) {
        items.add(item);
        System.out.println("Đã thêm: " + item.getID());
    }

    // Read: hiển thị tất cả đối tượng
    public void readAll() {
        if (items.isEmpty()) {
            System.out.println("Danh sách trống.");
            return;
        }
        for (T item : items) {
            System.out.println(item);
        }
    }

    // Update: cập nhật đối tượng theo ID (thay thế bằng đối tượng mới)
    public void update(String id, T newItem) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getID().equals(id)) {
                items.set(i, newItem);
                System.out.println("Đã cập nhật: " + id);
                return;
            }
        }
        System.out.println("Không tìm thấy ID: " + id);
    }

    // Delete: xóa đối tượng theo ID
    public void delete(String id) {
        for (T item : items) {
            if (item.getID().equals(id)) {
                items.remove(item);
                System.out.println("Đã xóa: " + id);
                return;
            }
        }
        System.out.println("Không tìm thấy ID: " + id);
    }
<<<<<<< HEAD
    
    public List<T> getItems() {
        return items;
    }
=======
>>>>>>> 36fae42 (updateInterface)
} 
