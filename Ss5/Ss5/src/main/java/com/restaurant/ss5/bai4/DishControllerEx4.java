package com.restaurant.ss5.bai4;

import com.restaurant.ss5.common.Dish;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Arrays;
import java.util.List;

@Controller
public class DishControllerEx4 {

    @GetMapping("/bai4/dishes")
    public String showDishList(Model model) {
        List<Dish> dishes = Arrays.asList(
                new Dish(1L, "Phở bò", 45000.0, true),
                new Dish(2L, "Bún chả", 40000.0, false),
                new Dish(3L, "Gỏi cuốn", 30000.0, true)
        );
        model.addAttribute("dishes", dishes);
        return "dish-list"; // View này sẽ dùng layout:decorate
    }

    @GetMapping("/bai4/detail/{id}")
    public String showDishDetail(@PathVariable("id") Long id, Model model) {
        Dish dish = new Dish(id, "Món demo", 50000.0, true);
        model.addAttribute("dish", dish);
        return "dish-detail"; // View này cũng dùng layout:decorate
    }
}