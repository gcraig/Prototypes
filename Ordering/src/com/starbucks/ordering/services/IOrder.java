package com.starbucks.ordering.services;

import java.util.Date;
import java.util.List;

public interface IOrder {

    public Integer getId();

    public void setId(Integer id);

    public Date getDateTime();

    public void setDateTime(Date datetime);

    public String getStore();

    public void setStore(String store);

    public String getStatus();

    public void setStatus(String status);

    public String getCost();

    public void setCost(String cost);
}
