package com.csr.billing.dto;

import com.csr.common.dto.BaseDTO;

import java.util.*;

public class Invoice extends BaseDTO {

    // private Client client;
    // invoice decorators
    // line item decorators
    // fees (late), freight, sales tax, subtotal,
    // events: processed, printed, late, open, closed

    private Long id;

    public String invoiceNumber;
    public String invoiceDate;
    public String status;
    public String terms;
    public String purpose;
    public String exempt;

    private List<InvoiceLineItem> lineItems = new ArrayList<InvoiceLineItem>();

    public String datePrinted;
    public String totalAmount;

    private String rownumber;

    public String clientID;
    public String clientBillingAddressID;

    public String name;
    public String addr1;
    public String city;
    public String state;
    public String postalCode;

    public Invoice() {
    }

    public Invoice(
            String rownumber,
            String invoiceNumber,
            String invoiceDate,
            String clientID,
            String name,
            String terms,
            String totalAmount,
            String datePrinted) {
        this.rownumber = rownumber;
        this.invoiceNumber = invoiceNumber;
        this.invoiceDate = invoiceDate;
        this.clientID = clientID;
        this.name = name;
        this.terms = terms;
        this.totalAmount = totalAmount;
        this.datePrinted = datePrinted;
    }

    // Orderable ////////////////////////////////////////////////

    public Map getOrder() {
        // todo:  dto-config.properties
        //
        LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
        map.put("invoiceNumber", "Invoice Number");
        map.put("invoiceDate", "Invoice Date");
        map.put("status", "Status");
        map.put("terms", "Terms");
        map.put("purpose", "Purpose");
        map.put("exempt", "Exempt");
        map.put("datePrinted", "Date Printed");
        map.put("totalAmount", "Total Amount");
        return map;
    }

    public double totalSum() {
        // double runningsum;
        // double taxfactor = 1 + Invoice.rateOfTaxation();
        // runningsum = lineItem1Cost + lineItem2Cost;
        // runningsum = runningsum * taxfactor;
        // return runningsum;
        return (double) 0;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void addLineItem(InvoiceLineItem li) {
        lineItems.add(li);
    }

    public List<InvoiceLineItem> getLineItems() {
        return lineItems;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getInvoiceDate() {
        return invoiceDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setTerms(String terms) {
        this.terms = terms;
    }

    public String getTerms() {
        return terms;
    }

    public void setDatePrinted(String date) {
        this.datePrinted = date;
    }

    public String getDatePrinted() {
        return datePrinted;
    }

    public void setRownumber(String r) {
        this.rownumber = r;
    }

    public String getRownumber() {
        return this.rownumber;
    }

    public String toString() {
        return invoiceNumber + " " + invoiceDate + " " + name;
    }
}