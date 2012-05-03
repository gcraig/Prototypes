package com.starbucks.ordering.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("order")
public interface OrderingService extends RemoteService {
	
	String placeOrder(String qty) throws IllegalArgumentException;
	
	String checkStatus(String orderId) throws IllegalArgumentException;
	
    public static class App {
        private static OrderingServiceAsync ourInstance = GWT.create(OrderingService.class);

        public static synchronized OrderingServiceAsync getInstance() {
            return ourInstance;
        }
    }	
}
