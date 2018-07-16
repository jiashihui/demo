package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private String orderId;

    private Integer userId;

    private String productId;

    private BigDecimal price;

    private Date orderDate;

    private String orderAddress;

    //和用户表构成一对一的关系，即一个订单只能由一个用户创建
    private User user;
}