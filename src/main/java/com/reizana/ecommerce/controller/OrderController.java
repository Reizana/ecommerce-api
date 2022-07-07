package com.reizana.ecommerce.controller;

import com.reizana.ecommerce.Order;
import com.reizana.ecommerce.View;
import com.reizana.ecommerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "orders")
@RestController
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<Order> orderList() {
        return orderService.findAll();
    }

    @GetMapping("{orderId}")
    public List<View> findAllOrdersById(@PathVariable("orderId")Integer orderId) {
        return orderService.findAllOrdersById(orderId);
    }
    @PostMapping
    public void addOrdersInfo(@RequestBody Order order) {
        orderService.addOrdersInfo(order);
    }
}
