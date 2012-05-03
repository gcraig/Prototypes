package com.csr.billing.dao.demo;

import com.csr.common.dao.DAO;
import com.csr.billing.dto.Product;
import java.util.*;

public class ProductDemoDAO extends DAO
{
	private static List products = new ArrayList();

	static
	{
		products.add(new Product("0",32,"Good","Wicker Pink Hat",432432.43,1));
		products.add(new Product("121",543543,"","53",543543.00,1));
		products.add(new Product("S04303",59445,"Service","Wash wicker table!",324.43,1));
		products.add(new Product("S100",2,"Service","Site Procurement and Hosting!",15.00,0));
		products.add(new Product("S101",2,"Service","Virtual Site Bannerless Hosting!",15.00,0));
		products.add(new Product("S102",2,"Service","Web Site Creation: General Development",20.00,0));
		products.add(new Product("S103",2,"Service","Support",15.00,0));
		products.add(new Product("S222",43,"Good","Wicker Chair",1300.00,1));
		products.add(new Product("S333",43,"Good","Wicker Car",54354.00,1));
		products.add(new Product("S54545",42342,"","Corvette",4324324.43,1));
		products.add(new Product("S764576",897,"","Paper clips",432.43,1));
		products.add(new Product("S777",54,"Good","Wicker Mustache",4500.00,1));
		products.add(new Product("S888",43,"Good","Wicker Table",4323.00,1));
		products.add(new Product("S999",42,"Good","Wicker Hat",43.00,1));
	}

	public ProductDemoDAO()
	{
	}

	public int countAll() throws Exception
	{
		int all = products.size();
		System.out.println("\ncountAll: " + products.size());
		return all;
	}

	public List search(String startRecord, int pageSize) throws Exception
	{
		List p = new ArrayList();
		int start = Integer.parseInt(startRecord);

		System.out.println("\nstartRecord: " + startRecord);
		System.out.println("\nstart: " + start);

		for (int i=start; i<pageSize; i++)
		{
			Object o = null;
			try
			{
				o = products.get(i);
				p.add( o );
			}
			catch (IndexOutOfBoundsException ie)
			{
				break;
			}
		}

		System.out.println("\np: " + p);
        return p;
	}
}