package com.starbucks.ordering.services;

public class OrderNotFoundException extends Exception {

    public OrderNotFoundException() {
    }

    public OrderNotFoundException(String message) {
        super(message);
    }
}
