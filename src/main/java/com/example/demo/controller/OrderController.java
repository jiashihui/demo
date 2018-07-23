package com.example.demo.controller;

import com.example.demo.model.Order;
import com.example.demo.model.User;
import com.example.demo.service.OrderService;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 测试懒加载
     */
    @RequestMapping(value="/getOrders", method = RequestMethod.GET)
    public void getOrders(){
        List<Order> orders = orderService.getOrders();//第一步
        for(Order order : orders){
            User user = order.getUser();
            System.out.println(user.getUserName());//第二步
        }
    }

    /**
     * 测试分页rowbounds
     */
    @RequestMapping(value="/getOrdersByPage", method = RequestMethod.GET)
    public void getOrdersByPage(){
        //List<Order> orders = orderService.getOrdersByPage(new RowBounds(1,2));
        PageInfo<Order> orders = orderService.selectDocByPage1(1,2);
        for (Order order : orders.getList()) {
            System.out.println(order.toString());
        }
    }
}
