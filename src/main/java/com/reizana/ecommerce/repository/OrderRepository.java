package com.reizana.ecommerce.repository;

import com.reizana.ecommerce.Order;
import com.reizana.ecommerce.View;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    @Query(value = "SELECT u.id 'userId',\n" +
            "u.username 'username',\n" +
            "u.adress 'adress',\n" +
            "u.payment_method 'paymentMethod',\n" +
            "u.user_orders 'userOrders', \n" +
            "o.id 'orderId',\n" +
            "o.order_payment_info 'orderPaymentInfo',\n" +
            "o.order_shipping_info 'orderShippingInfo',\n" +
            "o.order_status 'orderStatus',\n" +
            "s.product 'product'\n" +
            "FROM user u INNER JOIN order_items o \n" +
            "ON u.id = o.order_id INNER JOIN store s\n" +
            "ON s.product_id = o.id\n" +
            "WHERE 1=1\n" +
            "AND u.id = :orderId\n" +
            "ORDER BY u.id;", nativeQuery = true)
    List<View> findAllOrdersById(@Param("orderId") Integer orderId);
}
