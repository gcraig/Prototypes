package com.starbucks.ordering.services;

import org.springframework.context.annotation.Bean;

import java.util.List;

public interface IOrderDAO {

    public Integer createOrder(IOrder o);

    public IOrder retrieveOrderById(Integer id) throws OrderNotFoundException;

    public List<IOrder> retrieveAllOrders();

    public void updateOrder(IOrder o);
}
