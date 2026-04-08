**Bẫy dữ liệu:**
**\
` `Nếu người dùng nhập sai kiểu (ví dụ gõ chữ thay vì số cho ID), hệ thống sẽ ném lỗi. Cần bắt ngoại lệ bằng try-catch hoặc @ExceptionHandler để trả về thông báo dễ hiểu thay vì crash.

**Báo cáo Phân tích (Idempotent)**

`  `DELETE (hủy đơn hàng): Idempotent → gọi nhiều lần kết quả cuối cùng vẫn giống nhau, đơn hàng bị xóa hoặc không tồn tại, nên an toàn dù nhân viên bấm liên tục.

POST (tạo đơn hàng): Không idempotent → mỗi lần gọi sẽ sinh thêm một đơn hàng mới, bấm 3 lần sẽ tạo ra 3 đơn hàng rác, gây rủi ro dữ liệu.

