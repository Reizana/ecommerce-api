package com.reizana.ecommerce;

import javax.persistence.*;

@Entity
@Table(name = "stores")
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String product;
    @Column(name = "product_id")
    private Integer productId;

    public Store() {
    }

    public Store(String product, Integer productId) {
        this.product = product;
        this.productId = productId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
        this.productId = productId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "Store{" +
                "id=" + id +
                ", product='" + product + '\'' +
                ", productId=" + productId +
                '}';
    }
}
