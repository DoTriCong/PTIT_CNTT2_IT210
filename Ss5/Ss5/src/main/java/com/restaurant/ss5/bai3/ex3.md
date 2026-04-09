**1.Phân tích luồng dữ liệu (Data Flow)**

- Người dùng đang ở View A (trang danh sách món ăn – dish-list.html từ Bài 2).
- Nhấn nút "Chỉnh sửa" tại một món ăn → gửi request đến /bai3/edit/{id}.
- Controller (AdminDishController) nhận ID từ URL.
- Controller gọi AdminDishService để tìm món ăn theo ID.
- Nếu tìm thấy: đối tượng Dish được đưa vào Model → hiển thị trên View B (edit-dish.html) với dữ liệu cũ tự động điền vào form.
- Nếu không tìm thấy: Controller redirect về /bai2/dishes kèm thông báo lỗi "Không tìm thấy món ăn yêu cầu!".

**2.Sơ đồ I/O:**

View A (dish-list.html) --[click Edit]--> /bai3/edit/{id}

`        `↓

AdminDishController nhận ID

`        `↓

AdminDishService.findById(id)

`        `↓

Nếu có: Model.addAttribute("dish", dish) → View B (edit-dish.html)

Nếu không: redirect:/bai2/dishes + Model.addAttribute("errorMessage")

**3. Thymeleaf sử dụng**

- th:object → bind object
- th:field → bind input
- @{...} → tạo URL động

