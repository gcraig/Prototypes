package com.starbucks.ordering.services;

import java.util.*;

public class HashMapOrderDAO implements IOrderDAO {

    private Map<Integer, IOrder> datastore;

    static private Integer idSequence = 100;

    public HashMapOrderDAO() {
        datastore = new HashMap<Integer, IOrder>();
    }

    public Integer createOrder(IOrder o) {
        /*
         * Referential integrity of database ensures no duplicate orders,
         * should throw an exception on save
         */

        /* Sequence returned from RDBMS counter */
        Integer id = ++ idSequence;
        o.setId(id);
        datastore.put(id, o);
        return id;
    }

    public IOrder retrieveOrderById(Integer id) throws OrderNotFoundException {

        if (null == id || id < 1)
            throw new IllegalArgumentException("Order id cannot be null or negative.");

        IOrder order = datastore.get(id);

        if (null == order)
            throw new OrderNotFoundException(String.format("Order: %s not found.", id));

        return order;
    }

    public List<IOrder> retrieveAllOrders() {
        ArrayList<IOrder> orders = new ArrayList<IOrder>();
        orders.addAll(datastore.values());
        return orders;
    }

    public void updateOrder(IOrder order) {
        datastore.put(order.getId(), order);
    }
}
