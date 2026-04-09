package com.restaurant.ss5.bai5.controller;


import com.restaurant.ss5.bai5.service.OrderService;
import com.restaurant.ss5.common.Dish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class DishDetailController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/bai5/detail/{id}")
    public String showDishDetail(@PathVariable("id") Long id, Model model) {
        Dish dish = orderService.getDishById(id);
        if (dish == null) {
            model.addAttribute("errorMessage", "Không tìm thấy món ăn yêu cầu!");
            return "redirect:/bai5/order";
        }
        model.addAttribute("dish", dish);
        return "dish-detail"; // dish-detail.html
    }
}