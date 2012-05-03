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
public class OrderServiceTest extends BaseTest {

    private static Logger log = Logger.getLogger("OrderServiceTest.class");

    IOrderService service;
    IOrderDAO orderDAO;

    @Autowired
    public void setService(IOrderService service) {
        this.service = service;
    }

    @Autowired
    public void setOrderDAO(IOrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    @Test
    public void createOrder() throws OrderNotFoundException {
        Integer orderId = service.createOrder(dummyOrder());
        Assert.assertTrue(orderId > 0);
        IOrder order = orderDAO.retrieveOrderById(orderId);
        log.info(String.format("orderId: %d", orderId));
        Assert.assertNotNull(order);
        Assert.assertEquals(orderId, order.getId());
    }

    @Test
    public void getOrderStatus() throws OrderNotFoundException {
        IOrder dummyOrder = dummyOrder();
        Integer orderId = service.createOrder(dummyOrder);
        String controlStatus = dummyOrder.getStatus();
        IOrder order = service.getOrder(orderId);
        String testStatus = order.getStatus();
        log.info(String.format("orderStatus: %s", testStatus));
        Assert.assertEquals(controlStatus, testStatus);
    }

    @Test
    public void getAllOrders() {
        List<IOrder> orders = service.getAllOrders();
        log.info(String.format("Orders size: %d", orders.size()));
        Assert.assertTrue(orders.size() >= 0);
    }

    @Test
    public void fillOrder() throws OrderNotFoundException {
        IOrder dummyOrder = dummyOrder();
        Integer orderId = service.createOrder(dummyOrder);
        service.fillOrder(orderId);
        String testStatus = service.getOrder(orderId).getStatus();
        log.info(String.format("orderStatus: %s", testStatus));
        Assert.assertEquals("COMPLETED", testStatus);
    }
}
