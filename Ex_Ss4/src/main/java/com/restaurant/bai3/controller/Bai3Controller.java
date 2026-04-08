package com.restaurant.bai3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class Bai3Controller {
    // Cách A: số 5 nằm trong URI Path, lấy bằng @PathVariable, thể hiện rõ ràng tài nguyên cụ thể (đơn hàng ID = 5).
    // Cách B: số 5 nằm trong Query String, lấy bằng @RequestParam, thường dùng để lọc hoặc tìm kiếm dữ liệu.
    //  Khi cần lấy một đối tượng cụ thể (ví dụ đơn hàng ID = 5), Cách A phù hợp hơn vì nó tuân theo chuẩn RESTful và thể hiện rõ ràng tài nguyên.
    @GetMapping("/bai3/orders/{id}")
    public String orders(@PathVariable("id") long id) {
        return "Chi tiet don hang so " + id;
    }
}
