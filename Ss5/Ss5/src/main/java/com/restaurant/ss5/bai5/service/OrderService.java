package com.restaurant.ss5.bai5.service;


import com.restaurant.ss5.bai5.repository.OrderRepository;
import com.restaurant.ss5.common.Dish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Dish getDishById(Long id) {
        return orderRepository.findById(id);
    }

    public Iterable<Dish> getAllDishes() {
        return orderRepository.findAll();
    }

    // Logic tính toán giá trị đơn hàng (ví dụ tổng tiền) sẽ nằm ở đây
    public double calculateTotal(Dish dish, int quantity) {
        return dish.getPrice() * quantity;
    }
}