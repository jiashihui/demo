package com.example.demo.service.impl;

import com.example.demo.mapper.OrderMapper;
import com.example.demo.model.Order;
import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public List<Order> getOrders() {
        return orderMapper.getOrders();
    }
}
