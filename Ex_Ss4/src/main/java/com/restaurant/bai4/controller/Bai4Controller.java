package com.restaurant.bai4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/bai4")
public class Bai4Controller {
    @GetMapping("/products")
    public String getProducts(
            @RequestParam("category") String category,
            @RequestParam("limit") Integer limit,
            ModelMap modelMap
    ) {
        modelMap.addAttribute("category", category)
                .addAttribute("limit", limit)
                .addAttribute("message", "Tìm kiếm thành công");
        return "products";
    }
}
