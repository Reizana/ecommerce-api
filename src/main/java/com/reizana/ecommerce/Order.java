package com.reizana.ecommerce;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String orderStatus;
    private String orderItems;
    private String orderAdress;
    private String orderPaymentInfo;
    private String orderShippingInfo;
    @Column(name = "order_id")
    private Integer orderId;

    public Order() {
    }

    public Order(String orderStatus, String orderItems, String orderAdress, String orderPaymentInfo, String orderShippingInfo, Integer orderId) {
        this.orderStatus = orderStatus;
        this.orderItems = orderItems;
        this.orderAdress = orderAdress;
        this.orderPaymentInfo = orderPaymentInfo;
        this.orderShippingInfo = orderShippingInfo;
        this.orderId = orderId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(String orderItems) {
        this.orderItems = orderItems;
    }

    public String getOrderAdress() {
        return orderAdress;
    }

    public void setOrderAdress(String orderAdress) {
        this.orderAdress = orderAdress;
    }

    public String getOrderPaymentInfo() {
        return orderPaymentInfo;
    }

    public void setOrderPaymentInfo(String orderPaymentInfo) {
        this.orderPaymentInfo = orderPaymentInfo;
    }

    public String getOrderShippingInfo() {
        return orderShippingInfo;
    }

    public void setOrderShippingInfo(String orderShippingInfo) {
        this.orderShippingInfo = orderShippingInfo;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderStatus='" + orderStatus + '\'' +
                ", orderItems='" + orderItems + '\'' +
                ", orderAdress='" + orderAdress + '\'' +
                ", orderPaymentInfo='" + orderPaymentInfo + '\'' +
                ", orderShippingInfo='" + orderShippingInfo + '\'' +
                ", orderId=" + orderId +
                '}';
    }
}

