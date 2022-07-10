package com.reizana.ecommerce.controller.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductDto {

    private String name;
    private String description;
    private String imageUrl;
    private BigDecimal price;
}
