package com.csr.clients.dto;

import com.csr.common.dto.BaseDTO;
import java.util.*;

public class Client extends BaseDTO
{
	public String clientID;
	public String clientNumber;
	public String clientName;
	public String creditLimit;
	public String billable;

	public Client()
	{
	}

	public Client(String rownumber, String clientID, String clientNumber, String clientName, String creditLimit,
	String billable)
	{
		this.rownumber = rownumber;
		this.clientID = clientID;
		this.clientNumber = clientNumber;
		this.clientName = clientName;
		this.creditLimit = creditLimit;
		this.billable = billable;
	}

	// Orderable ////////////////////////////////////////////////

	public Map getOrder()
	{
		LinkedHashMap map = new LinkedHashMap();
		map.put("clientID",		"Client ID");
		map.put("clientNumber",	"Client Number");
		map.put("clientName",	"Client Name");
		map.put("creditLimit",	"Credit Limit");
		map.put("billable",		"Billable");
		return map;
	}

	// Properties ////////////////////////////////////////////////

	public String getClientID() { return clientID;  }
	public String getClientNumber() { return clientNumber;  }
	public String getClientName() { return clientName;  }
	public String getCreditLimit() { return creditLimit;  }
	public String getBillable() { return billable;  }

	public void setClientID(String clientID){ this.clientID =  clientID; }
	public void setClientNumber(String clientNumber){ this.clientNumber =  clientNumber; }
	public void setClientName(String clientName){ this.clientName =  clientName; }
	public void setCreditLimit(String creditLimit){ this.creditLimit =  creditLimit; }
	public void setBillable(String billable){ this.billable =  billable; }

	public String toString()
	{
		return
			"Client: " + clientID + " " + clientName + " " + creditLimit + " " + billable + "\n";
	}
}