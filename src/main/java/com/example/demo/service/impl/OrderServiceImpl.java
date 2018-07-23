package com.example.demo.service.impl;

import com.example.demo.mapper.OrderMapper;
import com.example.demo.model.Order;
import com.example.demo.service.OrderService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value="orderService")
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public List<Order> getOrders() {
        return orderMapper.getOrders();
    }

//    @Override
//    public List<Order> getOrdersByPage(RowBounds rowBounds) {
//        return orderMapper.findRecords(rowBounds);
//    }

    @Override
    public PageInfo<Order> selectDocByPage1(int currentPage, int pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<Order> orders = orderMapper.findRecords();
        PageInfo<Order> pageInfo = new PageInfo<>(orders);
        return pageInfo;
    }
}
