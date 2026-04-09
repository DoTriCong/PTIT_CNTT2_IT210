package com.restaurant.ss5.bai2.service;


import com.restaurant.ss5.common.Dish;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DishService {
    public List<Dish> getAllDishes() {
        return Arrays.asList(
                new Dish(1L, "Phở bò", 45000.0, true),
                new Dish(2L, "Bún chả", 40000.0, false),
                new Dish(3L, "Gỏi cuốn", 30000.0, true)
        );
    }
}