package com.reizana.ecommerce;

import javax.persistence.*;

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

    public User() {
    }

    public User(String username, String password, String adress, String paymentMethod, String userOrders) {
        this.username = username;
        this.password = password;
        this.adress = adress;
        this.paymentMethod = paymentMethod;
        this.userOrders = userOrders;
    }

    public User(String username, String adress, String paymentMethod, String userOrders) {
        this.username = username;
        this.adress = adress;
        this.paymentMethod = paymentMethod;
        this.userOrders = userOrders;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getUserOrders() {
        return userOrders;
    }

    public void setUserOrders(String userOrders) {
        this.userOrders = userOrders;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", adress='" + adress + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", userOrders='" + userOrders + '\'' +
                '}';
    }
}
