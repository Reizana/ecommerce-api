package com.reizana.ecommerce.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String password;
    private String adress;
    private String paymentMethod;
    private String userOrders;
    @OneToMany
    private List<Order> order;


}
