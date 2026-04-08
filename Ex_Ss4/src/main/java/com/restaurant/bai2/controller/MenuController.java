package com.restaurant.bai2.controller;

import com.restaurant.bai1.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class MenuController {
    private OrderService orderService;

    @Autowired
    public MenuController(OrderService orderService) {
        this.orderService = orderService;
    }

//    @GetMapping("/bai1/orders")
//    public String getAllOrders() {
//        return orderService.getAllOrders();
//    }
//
//    @GetMapping("/bai1/orders/{id}")
//    public String getOrderById(@PathVariable("id") long id) {
//        return orderService.getOrderById(id);
//    }

    @GetMapping("/bai2/menu")
    public String getMenu(@RequestParam(value = "category", required = false, defaultValue = "chay") String category) {
        return "Danh sach menu" + category;
    }
}
