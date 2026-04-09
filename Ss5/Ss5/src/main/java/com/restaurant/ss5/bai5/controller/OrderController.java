package com.restaurant.ss5.bai5.controller;


import com.restaurant.ss5.bai5.service.OrderService;
import com.restaurant.ss5.common.Dish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/bai5/order")
    public String showOrderPage(Model model) {
        model.addAttribute("dishes", orderService.getAllDishes());
        return "order"; // order.html
    }

    @PostMapping("/bai5/order")
    public String placeOrder(@RequestParam Long dishId,
                             @RequestParam int quantity,
                             Model model) {
        Dish dish = orderService.getDishById(dishId);
        if (dish == null) {
            model.addAttribute("errorMessage", "Không tìm thấy món ăn yêu cầu!");
            return "order";
        }
        double total = orderService.calculateTotal(dish, quantity);
        model.addAttribute("message", "Đặt món thành công! Tổng tiền: " + total);
        return "order";
    }
}