package com.starbucks.ordering.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of the <code>OrderingService</code>.
 */
public interface OrderingServiceAsync {
	
	void placeOrder(String qty, AsyncCallback<String> callback)
		throws IllegalArgumentException;
	
	void checkStatus(String orderId, AsyncCallback<String> callback)
		throws IllegalArgumentException;	
}
