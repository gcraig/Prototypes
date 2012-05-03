package com.starbucks.ordering.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Ordering implements EntryPoint {
	
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";

	/**
	 * Create a remote service proxy to talk to the server-side Ordering service.
	 */
	private final OrderingServiceAsync orderingService = GWT.create(OrderingService.class);

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		
		/*
		 * Construct and display the GUI widgets
		 */
		final TextBox tbQty = new TextBox();
		final Label lblQty = new Label("Quantity:");
		final Button btnSend = new Button("Send");
		final TextBox tbOrderId = new TextBox();
		final Label lblOrderId = new Label("Order Id:");
		final Button btnCheckStatus = new Button("Check Status");
		final Label lblResponse = new Label();
				
		tbQty.setWidth("40px");
		tbOrderId.setWidth("60px");
		
		RootPanel.get("slot1").add(lblQty);
		RootPanel.get("slot1").add(tbQty);
		RootPanel.get("slot1").add(btnSend);
		
		RootPanel.get("slot2").add(lblResponse);		
		
		RootPanel.get("slot3").add(lblOrderId);
		RootPanel.get("slot3").add(tbOrderId);
		RootPanel.get("slot3").add(btnCheckStatus);
		
		tbQty.setFocus(true);
		tbQty.selectAll();	

		/*
		 * Place an order
		 */
		btnSend.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                if (lblResponse.getText().equals("")) {
                	OrderingService.App.getInstance().placeOrder(tbQty.getText(), 
                			new ResponseAsyncCallback(lblResponse));
                } else {
                	lblResponse.setText("");
                }
            }
        });

		/*
		 * Check on the status of the order
		 */
		btnCheckStatus.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
				final DialogBox dialogBox = new DialogBox();
				Label lblStatus = new Label();
				OrderingService.App.getInstance().checkStatus(tbOrderId.getText(), 
						new ResponseAsyncCallback(lblStatus));
				dialogBox.setText("Status");
				dialogBox.setAnimationEnabled(true);
				final Button btnClose = new Button("Close");
				btnClose.getElement().setId("closeButton");
				VerticalPanel vpanel = new VerticalPanel();
				vpanel.add(lblStatus);
				vpanel.add(btnClose);
				dialogBox.setWidget(vpanel);
				dialogBox.center();
				btnClose.setFocus(true);
            }
        });
	
	}
	
	/*
	 * Generic callback to update a label
	 * with the server's response to an AJAX call
	 */
    class ResponseAsyncCallback implements AsyncCallback<String> {
        private Label label;

        public ResponseAsyncCallback(Label label) {
            this.label = label;
        }

        public void onSuccess(String result) {
            label.getElement().setInnerHTML(result);
        }

        public void onFailure(Throwable throwable) {
            label.setText("Error in callback");
        }
    }	
}
