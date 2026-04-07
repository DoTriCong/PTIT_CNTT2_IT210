Ex1:\
Phần 1 — Phân tích logic

Câu 1: Lỗi trong MyWebAppInitializer.java

- Khi bạn cấu hình DispatcherServlet với mapping "/api/\*", nghĩa là mọi request phải bắt đầu bằng /api/ mới được DispatcherServlet xử lý.
- Nói cách khác, DispatcherServlet chỉ “nghe” các URL có prefix /api/.

Câu 2: Lỗi trong WebConfig.java

- Bạn dùng @ComponentScan(basePackages = "com.demo.service").
- Điều này khiến Spring chỉ quét các class trong package com.demo.service.
- Nhưng @Controller của bạn lại nằm trong package khác (ví dụ com.demo.controller hoặc org.example.ss2.controller).
- Kết quả: Spring không tìm thấy bất kỳ Controller nào → DispatcherServlet không ánh xạ được URL → lỗi 404 hoặc 500 khi phân giải view.

Ex2:

|#|Vị trí|Loại vấn đề|Mô tả hậu quả|
| :- | :- | :- | :- |
|1|<%! private int requestCounter = 0; %>|` `Race Condition + Declaration|Biến toàn cục dùng chung cho nhiều request → nhiều user truy cập cùng lúc sẽ bị sai dữ liệu (không thread-safe)|
|2|<% requestCounter++; %>|` `Logic trong View|JSP không nên xử lý logic (tăng counter) → vi phạm nguyên tắc Thin View|
|3|<% List<Student> list = ... %>|Scriptlet|Lấy dữ liệu bằng Java code trong JSP → làm code rối, khó bảo trì|
|4|<%= title %>|` `Expression cũ|Dùng <%= %> thay vì ${} → không theo chuẩn hiện đại (EL)|
|5|<%= sv.getFullName() %>|` `XSS|Nếu tên chứa <script> → bị inject script → nguy hiểm bảo mật|
|6|<%= sv.getScore()%>;|` `Syntax lỗi|Dư dấu ; → hiển thị sai giao diện|
|7|for-loop Java trong JSP|` `Logic trong View|Vi phạm MVC: View chỉ hiển thị, không xử lý business logic|
|8|if-else xếp loại|` `Business logic sai chỗ|Logic xếp loại nên đặt ở Controller hoặc Service|
|9|<!-- comment -->|` `HTML Comment|Không phải JSP comment → vẫn render ra HTML (lộ code nội bộ)|
|10|import trong JSP|Design smell|JSP không nên import class → trách nhiệm này thuộc Controller|


Ex3:

\
1\. Vì sao thông báo lỗi đăng nhập phải lưu vào Request Scope?

Thông báo lỗi đăng nhập chỉ có ý nghĩa trong một lần request duy nhất (khi người dùng submit form). Do đó, Request Scope là lựa chọn phù hợp vì:

- Dữ liệu chỉ tồn tại trong vòng đời của một HTTP request. 
- Sau khi reload hoặc chuyển trang, dữ liệu sẽ tự động bị xoá. 

Nếu lưu nhầm vào Session Scope:

- Thông báo lỗi sẽ tồn tại lâu hơn cần thiết. 
- Khi người dùng đăng nhập thành công, thông báo lỗi cũ vẫn có thể hiển thị lại. 
- Gây nhầm lẫn và trải nghiệm người dùng kém

2\. Vì sao totalViewCount phải lưu vào Application Scope?

Biến totalViewCount đại diện cho:

Tổng số lượt xem đơn hàng của toàn bộ hệ thống

Do đó, cần sử dụng Application Scope vì:

- Dữ liệu được chia sẻ cho tất cả người dùng. 
- Tồn tại xuyên suốt vòng đời của ứng dụng. 

Nếu dùng Session Scope:

- Mỗi người dùng sẽ có một bản riêng của biến. 
- Kết quả hiển thị sẽ khác nhau giữa các user.

3\. Race Condition là gì?

`  `Nhiều thread cùng truy cập và thay đổi một dữ liệu chung tại cùng thời điểm, dẫn đến kết quả không chính xác.

Ex4:

1\. XSS là lỗ hổng bảo mật xảy ra khi:

Ứng dụng hiển thị lại dữ liệu do người dùng nhập mà không kiểm soát, cho phép chèn và thực thi mã JavaScript độc hại trên trình duyệt.

2\. So sánh <c:if> và <c:choose>

- <c:if> được dùng để kiểm tra một điều kiện đơn giản, không có nhánh else. 
- <c:choose> (kết hợp <c:when> và <c:otherwise>) dùng để thay thế cấu trúc if–else–if, phù hợp khi có nhiều điều kiện cần xử lý. 

3\. Vai trò của <c:url>

- <c:url> giúp tự động thêm context path của ứng dụng vào URL. 
- Nhờ đó, đường dẫn luôn đúng dù ứng dụng được deploy ở bất kỳ context path nào.

