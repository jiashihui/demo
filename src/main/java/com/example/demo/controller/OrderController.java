package com.example.demo.controller;

import com.example.demo.mapper.OrderMapper;
import com.example.demo.model.Order;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderMapper orderMapper;

    @RequestMapping(value="/getOrders", method = RequestMethod.GET)
    public void getOrders(){
        List<Order> orders = orderMapper.getOrderByOrderId();//第一步
        for(Order order : orders){
            User user = order.getUser();
            System.out.println(user.getUserName());//第二步
        }
    }
}
