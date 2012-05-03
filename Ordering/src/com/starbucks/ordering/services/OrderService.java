package com.starbucks.ordering.services;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OrderService implements IOrderService {

    @Autowired
    private IOrderDAO orderDao;

    public void setOrderDao(IOrderDAO orderDao) {
        this.orderDao = orderDao;
    }

    public Integer createOrder(IOrder o) {
        return orderDao.createOrder(o);
    }

    public String getOrderStatus(Integer orderId) throws OrderNotFoundException {
        return orderDao.retrieveOrderById(orderId).getStatus();
    }

    public IOrder getOrder(Integer orderId) throws OrderNotFoundException {
        return orderDao.retrieveOrderById(orderId);
    }

    public List<IOrder> getAllOrders() {
        return orderDao.retrieveAllOrders();
    }

    public void fillOrder(Integer orderId) throws OrderNotFoundException {
        IOrder order = orderDao.retrieveOrderById(orderId);
        order.setStatus("COMPLETED");
        orderDao.updateOrder(order);
    }
}
