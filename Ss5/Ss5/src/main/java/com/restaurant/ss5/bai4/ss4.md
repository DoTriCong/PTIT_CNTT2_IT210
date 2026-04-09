**Bảng so sánh hai cách tiếp cận**

|**Tiêu chí**|**(A) Copy-paste Header/Footer**|**(B) Sử dụng layout:decorate (Layout Dialect)**|
| :- | :- | :- |
|**Ưu điểm**|- Đơn giản, dễ hiểu.<br>- Không cần thêm thư viện.|- DRY (Don't Repeat Yourself): tránh lặp lại code.<br>- Dễ bảo trì: sửa header/footer một lần, áp dụng cho tất cả trang.<br>- Cấu trúc rõ ràng, tách biệt layout và nội dung.|
|**Nhược điểm**|- Lặp lại nhiều đoạn code giống nhau.<br>- Khó bảo trì: thay đổi logo/footer phải sửa từng file.<br>- Dễ gây lỗi không đồng bộ.|- Cần thêm thư viện thymeleaf-layout-dialect.<br>- Phải cấu hình thêm trong SpringTemplateEngine.<br>- Ban đầu hơi phức tạp hơn cho người mới.|

**Kết luận**

- **Cách A (copy-paste)**: nhanh nhưng khó bảo trì.
- **Cách B (layout:decorate)**: DRY, dễ mở rộng, chuyên nghiệp hơn.
- Để dùng Layout Dialect, cần đăng ký Bean LayoutDialect trong SpringTemplateEngine.

