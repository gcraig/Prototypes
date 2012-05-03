package com.csr.billing.dto;

import com.csr.common.dto.BaseDTO;
import java.util.*;

public class InvoiceLineItem extends BaseDTO
{
	public String lineItemNumber;
	public String productID;
	public String description;
	public String units;
	public String price;
	public String total;
	// cost

//public static double rateOfTaxation() {
  //      double rate;
    //    rate = .15;

      //  return rate;
//    }
	public InvoiceLineItem()
	{
	}

	public Map getOrder()
	{
		// todo:  dto-config.properties
		//
		LinkedHashMap map = new LinkedHashMap();
		map.put("lineItemNumber","Line Item Number");
		map.put("productID",	"Product ID");
		map.put("description",	"Description");
		map.put("units",	"Units");
		map.put("price",	"Price");
		map.put("total",		"Total");
		return map;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public String getLineItemNumber()
	{
		return lineItemNumber;
	}

	public void setLineItemNumber(String lineItemNumber)
	{
		this.lineItemNumber = lineItemNumber;
	}

	public String getPrice()
	{
		return price;
	}

	public void setPrice(String price)
	{
		this.price = price;
	}

	public String getProductID()
	{
		return productID;
	}

	public void setProductID(String productID)
	{
		this.productID = productID;
	}

	public String getUnits()
	{
		return units;
	}

	public void setUnits(String units)
	{
		this.units = units;
	}

	public String getTotal()
	{
		return total;
	}

	public void setTotal(String total)
	{
		this.total = total;
	}
}
// invoice line item form bean includes lineitem and product objects