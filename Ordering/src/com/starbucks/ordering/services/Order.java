package com.starbucks.ordering.services;

import java.io.Serializable;
import java.util.Date;

public class Order implements IOrder, Serializable {

    private Integer id;
    private Date datetime;
    private String store;
    private String status;
    private String cost;

    private enum Status {SUBMITTED, PROCESSING, COMPLETE}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateTime() {
        return datetime;
    }

    public void setDateTime(Date datetime) {
        this.datetime = datetime;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }
}
