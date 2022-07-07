package com.reizana.ecommerce.service;

import com.reizana.ecommerce.Order;
import com.reizana.ecommerce.View;
import com.reizana.ecommerce.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public List<View> findAllOrdersById(Integer orderId) {
       List<View> view = orderRepository.findAllOrdersById(orderId);
        return view;
    }

    public void addOrdersInfo(Order order) {
        orderRepository.save(order);
    }
}
