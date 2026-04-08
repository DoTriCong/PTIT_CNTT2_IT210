package com.restaurant.bai5.service;

import com.restaurant.bai5.model.Order;
import com.restaurant.bai5.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("bai5OrderService")
public class OrderService implements IOrderService {
    private OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order findById(int id) {
        return orderRepository.findAll()
                .stream()
                .filter(o -> o.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
