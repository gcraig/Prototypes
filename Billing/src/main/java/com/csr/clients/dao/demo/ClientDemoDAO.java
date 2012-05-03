package com.csr.clients.dao.demo;

import com.csr.common.dao.DAO;
import com.csr.clients.dto.Client;
import java.util.*;

public class ClientDemoDAO extends DAO
{
	private static List clients = new ArrayList();

	static
	{
		clients.add(new Client("1", "0","","Citizens for Weber","5000.00","1"));
		clients.add(new Client("2", "1","","Friends of Kush","5000.00","1"));
		clients.add(new Client("3", "2","","Ace Hardware, Inc.","5000.00","1"));
		clients.add(new Client("4", "3","","SANYO Incorporated","5000.00","1"));
		clients.add(new Client("5", "4","","Comcast Cable Corporation","5000.00","1"));
		clients.add(new Client("6", "5","","FORD Motor Corporation","5000.00","1"));
		clients.add(new Client("7", "6","","Scrabble Word Testers","5000.00","1"));
		clients.add(new Client("8", "7","","Magnavox Vision Systems","5000.00","1"));
		clients.add(new Client("9", "8","","Sun Microsystems, Inc.","5000.00","1"));
		clients.add(new Client("10", "9","","EMS System Support","5000.00","1"));
		clients.add(new Client("11", "10","","Motorola, Inc.","5000.00","1"));
		clients.add(new Client("12", "11","","Microsoft, Inc.","5000.00","1"));
		clients.add(new Client("13", "12","","Wegmans Food Markets","5000.00","1"));
		clients.add(new Client("14", "13","","W. L. Gore","5000.00","1"));
		clients.add(new Client("15", "14","","Republic Bancorp","5000.00","1"));
		clients.add(new Client("16", "15","","Genentech","5000.00","1"));
		clients.add(new Client("17", "16","","Xilinx","5000.00","1"));
		clients.add(new Client("18", "17","","J. M. Smucker","5000.00","1"));
		clients.add(new Client("19", "18","","S. C. Johnson & Son","5000.00","1"));
		clients.add(new Client("20", "19","","Griffin Hospital","5000.00","1"));
		clients.add(new Client("21", "20","","Alston & Bird","5000.00","1"));
		clients.add(new Client("22", "21","","American Cast Iron Pipe Company","5000.00","1"));
		clients.add(new Client("23", "22","","American Century Investments","5000.00","1"));
		clients.add(new Client("24", "23","","Network Appliance","5000.00","1"));
		clients.add(new Client("25", "24","","Bronson Healthcare Group","5000.00","1"));
		clients.add(new Client("26", "25","","CDW Corporation","5000.00","1"));
		clients.add(new Client("27", "26","","Timberland","5000.00","1"));
		clients.add(new Client("28", "27","","Pella","5000.00","1"));
		clients.add(new Client("29", "28","","Marriott International","5000.00","1"));
		clients.add(new Client("30", "29","","St. Luke's Episcopal Health System","5000.00","1"));
		clients.add(new Client("31", "30","","Emmis Communications","5000.00","1"));
		clients.add(new Client("32", "31","","Wm. Wrigley Jr.","5000.00","1"));
		clients.add(new Client("33", "32","","Granite Construction","5000.00","1"));
		clients.add(new Client("34", "33","","Medtronic","5000.00","1"));
		clients.add(new Client("35", "34","","Vanguard Group","5000.00","1"));
		clients.add(new Client("36", "35","","SEI Investments","5000.00","1"));
		clients.add(new Client("37", "40","","Pepsi, Co.","2000.00","1"));
	}

	public ClientDemoDAO()
	{
	}

	public int countAll() throws Exception
	{
		int all = clients.size();
		System.out.println("\ncountAll: " + clients.size());
		return all;
	}

	public List search(String startRecord, int pageSize) throws Exception
	{
		List c = new ArrayList();
		int start = Integer.parseInt(startRecord);

		System.out.println("\nstartRecord: " + startRecord);
		System.out.println("\nstart: " + start);

		for (int i=start; i<pageSize; i++)
		{
			Object o = null;
			try
			{
				o = clients.get(i);
				c.add( o );
			}
			catch (IndexOutOfBoundsException ie)
			{
				break;
			}
		}

		System.out.println("\nc: " + c);
        return c;	 
	}
}