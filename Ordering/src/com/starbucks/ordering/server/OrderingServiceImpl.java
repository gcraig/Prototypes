package com.starbucks.ordering.server;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.starbucks.ordering.client.OrderingService;
import com.starbucks.ordering.services.IOrderService;

@SuppressWarnings("serial")
public class OrderingServiceImpl extends RemoteServiceServlet implements
		OrderingService {

	@Autowired
	IOrderService service;
	
	public void setService(IOrderService service) {
		this.service = service;
	}

	public String placeOrder(String qty) throws IllegalArgumentException {
		
		/*
		 * Create an order via the Order Service and obtain
		 * the order id assigned by the datastore
		 */ 
		
		//IOrder order = new Order();
		//order.setStatus("SUBMITTED");
		//Integer orderId = service.createOrder(order);
		//order.setId(orderId);
				
		qty = escapeHtml(qty);
		
		String orderId = "101";
		return String.format("Thank you for your order! orderId=#%s", orderId);
	}

	public String checkStatus(String orderId) throws IllegalArgumentException {
		
		/*
		 * Retrieve the status of the order via the Order Service
		 */
		
		//String status = "";
		//try {
		//	status = service.getOrderStatus(Integer.getInteger(orderId));
		//} catch (OrderNotFoundException e) {
		//	e.printStackTrace();
		//}
		//return status;
		
		orderId = escapeHtml(orderId);
		
		if ("101".equals(orderId))
			return "SERVED";
		else
			return "SUBMITTED";
	}
	
	/**
	 * Escape an html string. Escaping data received from the client helps to
	 * prevent cross-site script vulnerabilities.
	 * 
	 * @param html the html string to escape
	 * @return the escaped string
	 */
	private String escapeHtml(String html) {
		if (html == null) {
			return null;
		}
		return html.replaceAll("&", "&amp;").replaceAll("<", "&lt;")
				.replaceAll(">", "&gt;");
	}
}
