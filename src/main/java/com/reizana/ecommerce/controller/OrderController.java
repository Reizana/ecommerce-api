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

    @PostMapping
    public void addOrdersInfo(@RequestBody Order order) {
        orderService.addOrdersInfo(order);
    }

    @PutMapping(path = "{orderId}")
    public void updateOrders(
            @PathVariable("orderId") Integer orderId,
            @RequestParam(required = false) String orderStatus,
            @RequestParam(required = false) String orderItems,
            @RequestParam(required = false) String orderAdress,
            @RequestParam(required = false) String orderPaymentInfo,
            @RequestParam(required = false) String orderShippingInfo) {
        orderService.updateOrders(orderId, orderStatus, orderItems,
                                        orderAdress, orderPaymentInfo, orderShippingInfo);

    }
    @DeleteMapping(path = "{orderId}")
    public void deleteOrder(@PathVariable("orderId") Integer orderId) {
        orderService.deleteOrder(orderId);
    }
}
