package com.reizana.ecommerce.domain;

import lombok.Data;

import javax.persistence.*;

@Data
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
    private User user;

}

