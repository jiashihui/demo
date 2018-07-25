package com.example.demo.mapper;

import com.example.demo.model.Order;
import com.example.demo.model.User;
import org.apache.ibatis.session.RowBounds;

import java.util.HashMap;
import java.util.List;

public interface OrderMapper {

    /**
     * 测试rowBounds分页
     * @param rowBounds
     * @return
     */
    List<Order> findRecords();
    //List<Order> findRecords(RowBounds rowBounds);

    int deleteByPrimaryKey(Order key);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Order key);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    //得到订单信息(包含user_id)
    List<Order> getOrders();
    //根据用户ID查询用户信息
    User getUserByUserId(int userID);
}