package com.csr.clients.dto;

import com.csr.common.dto.BaseDTO;
import java.util.*;

public class Address extends BaseDTO
{
	public String addressID;
	public String clientID;
	public String address1;
	public String address2;
	public String address3;
	public String city;
	public String state;
	public String postalCode;
	public String country;
	public String addressType;

	public Address()
	{
	}

	public Address(
		String addressID, String clientID,
		String address1, String address2, String address3,
		String city, String state, String postalCode,
		String country, String addressType)
	{
		this.addressID = addressID;
		this.clientID = clientID;
		this.address1 = address1;
		this.address2 = address2;
		this.address3 = address3;
		this.city = city;
		this.state = state;
		this.postalCode = postalCode;
		this.country = country;
		this.addressType = addressType;
	}

	// Orderable ////////////////////////////////////////////////

	public Map getOrder()
	{
		LinkedHashMap map = new LinkedHashMap();
		map.put("addressID","Address ID");
		map.put("clientID",	"Client ID");
		map.put("address1",	"Address1");
		map.put("address2",	"Address2");
		map.put("address3",	"Address3");
		map.put("city",		"City");
		map.put("state",	"State");
		map.put("postalCode", 	"Postal Code");
		map.put("country",		"Country");
		map.put("addressType",	"Address Type");
		return map;
	}

	// Properties ////////////////////////////////////////////////

	public String getAddressID()
		{ return addressID;  }
	public String getClientID()
		{ return clientID;  }
	public String getAddress1()
		{ return address1;  }
	public String getAddress2()
		{ return address2;  }
	public String getAddress3()
		{ return address3;  }
	public String getCity()
		{ return city;  }
	public String getState()
		{ return state;  }
	public String getPostalCode()
		{ return postalCode;  }
	public String getCountry()
		{ return country;  }
	public String getAddressType()
		{ return addressType;  }

	public void setAddressID(String addressID)
		{ this.addressID =  addressID;  map.put("Address ID", addressID); }
	public void setClientID(String clientID)
		{ this.clientID =  clientID;  map.put("Client ID", clientID); }
	public void setAddress1(String address1)
		{ this.address1 =  address1;  map.put("Address1", address1); }
	public void setAddress2(String address2)
		{ this.address2 =  address2;  map.put("Address2", address2); }
	public void setAddress3(String address3)
		{ this.address3 =  address3;  map.put("Address3", address3); }
	public void setCity(String city)
		{ this.city =  city;  map.put("City", city); }
	public void setState(String state)
		{ this.state =  state;  map.put("State", state); }
	public void setPostalCode(String postalCode)
		{ this.postalCode =  postalCode;  map.put("Postal Code", postalCode); }
	public void setCountry(String country)
		{ this.country =  country;  map.put("Country", country); }
	public void setAddressType(String addressType)
		{ this.addressType =  addressType;  map.put("Address Type", addressType); }
}