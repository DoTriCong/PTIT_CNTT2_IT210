**Đối tượng dữ liệu:** 

Dish (package com.restaurant.common)

- id: Long
- name: String
- price: Double
- isAvailable: boolean

**Luồng dữ liệu từ Controller sang View:**

Mã

Client (HTTP GET /bai2/dishes)

`        `↓

DishController → DishService → List<Dish>

`        `↓

Model.addAttribute("dishes", list)

`        `↓

dish-list.html (Thymeleaf hiển thị)

- **Input:** Người dùng truy cập đường dẫn /bai2/dishes.
- **Process:** Controller gọi Service để lấy danh sách món ăn.
- **Output:** View dish-list.html hiển thị danh sách. Nếu danh sách rỗng, hiển thị thông báo thay thế.

