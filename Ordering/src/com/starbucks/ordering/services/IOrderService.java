package com.starbucks.ordering.services;

import java.util.List;

public interface IOrderService {

    public Integer createOrder(IOrder o);

    public String getOrderStatus(Integer orderId) throws OrderNotFoundException;

    public IOrder getOrder(Integer orderId) throws OrderNotFoundException;

    public List<IOrder> getAllOrders();

    public void fillOrder(Integer id) throws OrderNotFoundException;
}
