package com.example.demo.service;

import com.example.demo.model.Order;

import java.util.List;

public interface OrderService {
    /**
     * get orders
     * @return
     */
    List<Order> getOrders();
}
