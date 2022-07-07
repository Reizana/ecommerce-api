package com.reizana.ecommerce;

import javax.persistence.*;

@Entity
@Table(name = "order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String orderStatus;
    private String orderItems;
    private String orderAdress;
    private String orderPaymentInfo;
    private String orderShippingInfo;
}
