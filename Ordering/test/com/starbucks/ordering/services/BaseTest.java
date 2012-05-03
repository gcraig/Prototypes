package com.starbucks.ordering.services;

import java.util.Date;

public class BaseTest {

    public IOrder dummyOrder() {
        IOrder order = new Order();
        order.setDateTime(new Date());
        order.setStore("Chicago #42");
        order.setStatus("SUBMITTED");
        return order;
    }
}
