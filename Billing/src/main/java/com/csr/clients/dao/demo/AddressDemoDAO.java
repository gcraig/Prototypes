package com.csr.clients.dao.demo;

import com.csr.common.dao.DAO;
import com.csr.clients.dto.Address;
import java.util.*;

public class AddressDemoDAO extends DAO
{
	private static List addresses = new ArrayList();

	static
	{
		addresses.add(new Address("0","0","1231 South Joliet St.","","","Joliet","Illinois","60343","USA","Billing"));
		addresses.add(new Address("1","0","110 Arcadia Ave.","","","Romeoville","Illinois","60441","USA","Billing"));
		addresses.add(new Address("2","0","543 Michigan Ave.","","","South Cart","Michigan","55312","USA","Billing"));
		addresses.add(new Address("3","1","401 Dernst Court","","","Carnville","Indiana","34343","USA","Billing"));
		addresses.add(new Address("4","0","752 Farragut Avenue","","","Romeoville","IL","60442","USA","Billing"));
		addresses.add(new Address("6","0","23 Orchard rd","","","Chicago","IL","43442","US",""));
		addresses.add(new Address("8","0","123 My street","Unit 24313","","Oswego","IL","54254","USA",""));
	}

	public AddressDemoDAO()
	{
	}

	public int countAll() throws Exception
	{
		int all = addresses.size();
		System.out.println("\ncountAll: " + addresses.size());
		return all;
	}

	public List search(String startRecord, int pageSize) throws Exception
	{
		List a = new ArrayList();
		int start = Integer.parseInt(startRecord);

		System.out.println("\nstartRecord: " + startRecord);
		System.out.println("\nstart: " + start);

		for (int i=start; i<pageSize; i++)
		{
			Object o = null;
			try
			{
				o = addresses.get(i);
				a.add( o );
			}
			catch (IndexOutOfBoundsException ie)
			{
				break;
			}
		}

		System.out.println("\na: " + a);
        return a;
	}
}