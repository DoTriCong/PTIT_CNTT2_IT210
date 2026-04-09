package com.restaurant.ss5.bai3.service;


import com.restaurant.ss5.common.Dish;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AdminDishService {
    private static final Map<Long, Dish> dishMap = new HashMap<>();

    static {
        dishMap.put(1L, new Dish(1L, "Phở bò", 45000.0, true));
        dishMap.put(2L, new Dish(2L, "Bún chả", 40000.0, false));
        dishMap.put(3L, new Dish(3L, "Gỏi cuốn", 30000.0, true));
    }

    public Dish findById(Long id) {
        return dishMap.get(id);
    }
}