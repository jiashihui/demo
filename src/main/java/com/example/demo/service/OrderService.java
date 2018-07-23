package com.example.demo.service;

import com.example.demo.model.Order;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface OrderService {
    /**
     * get orders
     * @return
     */
    List<Order> getOrders();

    /**
     * get ordersbypage
     * @return
     */
    //List<Order> getOrdersByPage(RowBounds rowBounds);

    /**
     * get
     * @return
     */
    PageInfo<Order> selectDocByPage1(int currentPage, int pageSize);
}
