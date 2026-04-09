package com.restaurant.ss5.bai3.controller;


import com.restaurant.ss5.bai3.service.AdminDishService;
import com.restaurant.ss5.common.Dish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AdminDishController {

    @Autowired
    private AdminDishService adminDishService;

    @GetMapping("/bai3/edit/{id}")
    public String editDish(@PathVariable("id") Long id, Model model) {
        Dish dish = adminDishService.findById(id);
        if (dish == null) {
            model.addAttribute("errorMessage", "Không tìm thấy món ăn yêu cầu!");
            return "redirect:/bai2/dishes";
        }
        model.addAttribute("dish", dish);
        return "edit-dish"; // trỏ tới edit-dish.html
    }
}