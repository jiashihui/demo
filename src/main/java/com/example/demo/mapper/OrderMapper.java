package com.example.demo.mapper;

import com.example.demo.model.Order;
import com.example.demo.model.User;

import java.util.List;

public interface OrderMapper {
    int deleteByPrimaryKey(Order key);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Order key);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    //得到订单信息(包含user_id)
    List<Order> getOrderByOrderId();
    //根据用户ID查询用户信息
    User getUserByUserId(int userID);
}