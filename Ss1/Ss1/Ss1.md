Ss1

Ex1:

Đoạn code sai

public RechargeService() {

`    `this.gateway = new InternalPaymentGateway(); 

}

Giải thích lỗi

- Ở đây, RechargeService tự khởi tạo một đối tượng InternalPaymentGateway.
- Điều này tạo ra tight coupling (ràng buộc chặt chẽ) giữa RechargeService và InternalPaymentGateway.

Ex2:\
Trong Spring, khi đánh dấu một lớp với @Component nhưng không chỉ định scope, thì mặc định Bean đó sẽ có scope Singleton.

Bean mặc định là Singleton nên tất cả người chơi dùng chung một đối tượng, dẫn đến cộng/trừ giờ lẫn nhau. Muốn mỗi người chơi có phiên riêng thì phải đổi sang scope Prototype để Spring tạo Bean mới cho từng phiên.

Ex3:

`  `Input :

- Tên món ăn mà khách hàng gọi (ví dụ: "Mì xào bò").
- Tài khoản hội viên (username).
- Số tiền hiện có trong tài khoản.

` `Output :

- Nếu món ăn còn hàng và tài khoản đủ tiền → trừ tiền, giảm số lượng món trong kho, thông báo thành công.
- Nếu món ăn hết hàng hoặc tài khoản không đủ tiền → thông báo lỗi phù hợp

Luồng xử lý 

1 Nhận yêu cầu gọi món (username, foodName, price).

2  Kiểm tra kho:

- Nếu stock = 0 → báo hết hàng.

3  Kiểm tra số dư tài khoản:

- Nếu balance < price → báo không đủ tiền.

4  Nếu hợp lệ → trừ tiền và giảm số lượng món trong kho.

5  Thông báo thành công.

Ex4:

|**Tiêu chí**|**Constructor Injection**|**Field Injection**|
| :- | :- | :- |
|**Tính rõ ràng**|Rõ ràng: phụ thuộc được khai báo ngay trong constructor, dễ thấy khi khởi tạo|Ít rõ ràng hơn, phụ thuộc được tiêm ngầm qua annotation|
|**Immutable (bất biến)**|Các dependency là final, không thể thay đổi sau khi khởi tạo → an toàn hơn|Có thể thay đổi bằng reflection hoặc setter → kém an toàn|
|**Testability (dễ test)**|Dễ viết unit test vì có thể truyền mock vào constructor|Khó test hơn, phải dùng framework hỗ trợ injection|
|**Độ gọn code**|Dài hơn một chút do phải viết constructor|Ngắn gọn, chỉ cần annotation|
|**Xử lý lỗi (ví dụ SMS bị đứt mạng)**|Dễ kiểm soát vì dependency được truyền rõ ràng, có thể mock riêng từng sender|Khó kiểm soát hơn, vì dependency được Spring tiêm ngầm|

