package com.restaurant.ss5.bai5.repository;

import com.restaurant.ss5.common.Dish;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class OrderRepository {
    private final Map<Long, Dish> dishMap = new HashMap<>();

    public OrderRepository() {
        dishMap.put(1L, new Dish(1L, "Phở bò", 45000.0, true));
        dishMap.put(2L, new Dish(2L, "Bún chả", 40000.0, false));
        dishMap.put(3L, new Dish(3L, "Gỏi cuốn", 30000.0, true));
    }

    public Dish findById(Long id) {
        return dishMap.get(id);
    }

    public Collection<Dish> findAll() {
        return dishMap.values();
    }
}
