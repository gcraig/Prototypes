package com.starbucks.ordering.services;

import java.util.List;
import java.util.logging.Logger;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext-test.xml"})
public class OrderDAOTest extends BaseTest {

    private static Logger log = Logger.getLogger("OrderDAOTest.class");

    IOrderDAO orderDAO;

    @Autowired
    public void setOrderDAO(IOrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    @Test
    public void createOrder() throws Exception {
        Integer orderId = orderDAO.createOrder(dummyOrder());
        Assert.assertTrue(orderId > 0);
        log.info(String.format("orderId: %d", orderId));

        IOrder order = orderDAO.retrieveOrderById(orderId);
        Assert.assertNotNull(order);
        Assert.assertEquals(orderId, order.getId());
    }

    @Test
    public void retrieveAllOrdersNotNull() throws Exception {
        List<IOrder> orders = orderDAO.retrieveAllOrders();
        Assert.assertTrue(null != orders && orders.size() >= 0);
    }

    @Test
    public void retrieveAllOrders() throws Exception {
        orderDAO.createOrder(dummyOrder());
        orderDAO.createOrder(dummyOrder());
        List<IOrder> orders = orderDAO.retrieveAllOrders();
        Assert.assertNotNull(orders);
        Assert.assertTrue(orders.size() >= 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void retrieveOrderByNullId() throws Exception {
        orderDAO.retrieveOrderById(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void retrieveOrderByNegativeId() throws Exception {
        orderDAO.retrieveOrderById(Integer.MIN_VALUE);
    }

    @Test(expected = OrderNotFoundException.class)
    public void retrieveOrderByInvalidId() throws Exception {
        orderDAO.retrieveOrderById(Integer.MAX_VALUE);
    }

    @Test
    public void updateOrder() {
        
    }
}
