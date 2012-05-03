package com.csr.billing.dto;

import com.csr.common.dto.BaseDTO;
import java.util.*;

public class Product extends BaseDTO
{
	private String productID;
	private String productCategory;
	private String parentProductID;
	private String productType;
	private String description;
	private String price;
	private String notes;
	private boolean taxable;

	public Product()
	{
	}

	public Product(String productID, int parentProductID, String productType, String description, double price, int taxable)
	{
		this.setProductID(productID);
		this.setParentProductID(parentProductID + "");
		this.setProductType(productType);
		this.setDescription(description);
		this.setPrice(price + "");
		this.setTaxable(true);
	}

	// Orderable ////////////////////////////////////////////////

	public Map getOrder()
	{
		/* possible enhancement */
		LinkedHashMap map = new LinkedHashMap();
		map.put("productID",				"Product ID");
		map.put("productCategory",	"Product Category");
		map.put("parentProductID",	"Parent Product ID");
		map.put("productType",			"Product Type");
		map.put("description",				"Description");
		map.put("price",						"Price");
		map.put("notes",						"Notes");
		map.put("taxable",					"Taxable");
		return map;

		/*
		List order = new ArrayList();
		order.add("Product ID");
		order.add("Product Category");
		order.add("Parent Product ID");
		order.add("Product Type");
		order.add("Description");
		order.add("Price");
		order.add("Notes");
		order.add("Taxable");
		return order;
		*/
	}

	// Properties ////////////////////////////////////////////////

	public String getDescription() 
	{
		return description;
	}

	public void setDescription(String description) 
	{
		this.description = description;
		map.put("Description", description);
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
		map.put("Notes", notes);
	}

	public String getParentProductID() {
		return parentProductID;
	}

	public void setParentProductID(String parentProductID) {
		this.parentProductID = parentProductID;
		map.put("Parent Product ID", parentProductID);
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
		map.put("Price", price);
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
		map.put("Product Category", productCategory);
	}

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
		map.put("Product ID", productID);
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
		map.put("Product Type", productType);
	}

	public boolean isTaxable() {
		return taxable;
	}

	public void setTaxable(boolean taxable) {
		this.taxable = taxable;
		map.put("Taxable", new Boolean(taxable));
	}
}