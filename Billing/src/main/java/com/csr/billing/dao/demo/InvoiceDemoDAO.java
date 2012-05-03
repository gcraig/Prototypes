package com.csr.billing.dao.demo;

import com.csr.common.dao.DAO;
import com.csr.billing.dto.Invoice;
import com.csr.billing.dto.InvoiceLineItem;
import java.util.*;

public class InvoiceDemoDAO extends DAO
{
	private static List invoices = new ArrayList();

	static
	{
		invoices.add(new Invoice("1",  "1525", "01/02/2006", "3", "", "Net 30", "421324.43", "01/02/2006"));
		invoices.add(new Invoice("2",  "1526", "01/02/2006", "5", "", "Net 30", "543543.00", "01/02/2006"));
		invoices.add(new Invoice("3",  "1546", "01/05/2006", "5", "", "Net 30", "324.43", "01/02/2006"));
		invoices.add(new Invoice("4",  "1567", "01/22/2006", "2", "", "Net 30", "15.00", "01/02/2006"));
		invoices.add(new Invoice("5",  "1568", "02/02/2006", "2", "", "Net 30", "15.00", "01/02/2006"));
		invoices.add(new Invoice("6",  "1578", "03/02/2006", "2", "", "Net 30", "20.00", "01/02/2006"));
		invoices.add(new Invoice("7",  "1579", "04/02/2006", "2", "", "Net 30", "15.00", "01/02/2006"));
		invoices.add(new Invoice("8",  "1580", "04/02/2006", "4", "", "Net 30", "1300.00", "01/02/2006"));
		invoices.add(new Invoice("9",  "1581", "04/22/2006", "4", "", "Net 30", "54354.00", "01/02/2006"));
		invoices.add(new Invoice("10", "1583", "05/02/2006", "4", "", "Net 30", "4324324.43", "01/02/2006"));
		invoices.add(new Invoice("11", "1589", "06/02/2006", "8", "", "Net 30", "432.43", "01/02/2006"));
		invoices.add(new Invoice("12", "1590", "07/12/2006", "5", "", "Net 30", "4500.00", "01/02/2006"));
		invoices.add(new Invoice("13", "1605", "08/02/2006", "4", "", "Net 30", "4323.00", "01/02/2006"));
		invoices.add(new Invoice("14", "1625", "09/02/2006", "4", "", "Net 30", "43.00", "01/02/2006"));

		/*
		invoices.add(new Invoice("1",  "S313",32,"Good","Wicker Pink Hat",432432.43,1));
		invoices.add(new Invoice("2",  "121",543543,"","53",543543.00,1));
		invoices.add(new Invoice("3",  "S04303",59445,"Service","Wash wicker table!",324.43,1));
		invoices.add(new Invoice("4",  "S100",2,"Service","Site Procurement and Hosting!",15.00,0));
		invoices.add(new Invoice("5",  "S101",2,"Service","Virtual Site Bannerless Hosting!",15.00,0));
		invoices.add(new Invoice("6",  "S102",2,"Service","Web Site Creation: General Development",20.00,0));
		invoices.add(new Invoice("7",  "S103",2,"Service","Support",15.00,0));
		invoices.add(new Invoice("8",  "S222",43,"Good","Wicker Chair",1300.00,1));
		invoices.add(new Invoice("9",  "S333",43,"Good","Wicker Car",54354.00,1));
		invoices.add(new Invoice("10", "S54545",42342,"","Corvette",4324324.43,1));
		invoices.add(new Invoice("11", "S764576",897,"","Paper clips",432.43,1));
		invoices.add(new Invoice("12", "S777",54,"Good","Wicker Mustache",4500.00,1));
		invoices.add(new Invoice("13", "S888",43,"Good","Wicker Table",4323.00,1));
		invoices.add(new Invoice("14", "S999",42,"Good","Wicker Hat",43.00,1));
		*/
	}

	public InvoiceDemoDAO()
	{
	}

    public Object view(String param) throws Exception
    {
		Invoice invoice = null;
		for (int i=0; i<invoices.size(); i++)
		{
			invoice = (Invoice) invoices.get(i);
			if (invoice.invoiceNumber.equals(param))
				break;
		}
		return (Object) invoice;
	}

	public int countAll() throws Exception
	{
		int all = invoices.size();
		System.out.println("\ncountAll: " + invoices.size());
		return all;
	}

	public List search(String startRecord, int pageSize) throws Exception
	{
		List v = new ArrayList();
		int start = Integer.parseInt(startRecord);

		System.out.println("\nstartRecord: " + startRecord);
		System.out.println("\nstart: " + start);

		for (int i=start; i<pageSize; i++)
		{
			Object o = null;
			try
			{
				o = invoices.get(i);
				v.add( o );
			}
			catch (IndexOutOfBoundsException ie)
			{
				break;
			}
		}

		System.out.println("\nv: " + v);
        return v;
	}
}