package com.restaurant.bai1.controller;

import com.restaurant.bai1.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("/bai1/orders")
public class LegacyController {
    private OrderService orderService;

    @Autowired
    public LegacyController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public String getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public String getOrderById(@PathVariable("id") long id) {
        return orderService.getOrderById(id);
    }
}
