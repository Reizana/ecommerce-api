package com.reizana.ecommerce.service;

import com.reizana.ecommerce.Order;
import com.reizana.ecommerce.View;
import com.reizana.ecommerce.repository.OrderRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public void addOrdersInfo(Order order) {
        orderRepository.save(order);
    }

    @Transactional
    public void updateOrders(Integer orderId, String orderStatus, String orderItems,
                             String orderAdress, String orderPaymentInfo, String orderShippingInfo) {
        Order order = orderRepository
                .findById(orderId).orElseThrow(() -> new IllegalStateException(
                        "Order with id " + orderId + " already exists"));
        if (orderStatus != null && orderStatus.length() > 0 && !Objects.equals(order.getOrderStatus(), orderStatus)) {
            order.setOrderStatus(orderStatus);
        }
        if (orderItems != null && orderItems.length() > 0 && !Objects.equals(order.getOrderItems(), orderItems)) {
            order.setOrderItems(orderItems);
        }
        if (orderAdress != null && orderAdress.length() > 0 && !Objects.equals(order.getOrderAdress(), orderAdress)) {
            order.setOrderAdress(orderAdress);
        }
        if (orderPaymentInfo != null && orderPaymentInfo.length() > 0 && !Objects.equals(order.getOrderPaymentInfo(), orderPaymentInfo)) {
            order.setOrderPaymentInfo(orderPaymentInfo);
        }
        if (orderShippingInfo != null && orderShippingInfo.length() > 0 && !Objects.equals(order.getOrderShippingInfo(), orderShippingInfo)) {
            order.setOrderShippingInfo(orderShippingInfo);
        }
    }

    public void deleteOrder(Integer orderId) {
        orderRepository.deleteById(orderId);
    }
}