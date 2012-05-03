package com.csr.client.vo;

import com.csr.common.vo.BaseVO;

public class AddressVO extends BaseVO
{
	private String address1;

	private String address2;

	private String address3;

	private String city;

	private String state;

	private String postalCode;

	private String country;

	private String type;

	public AddressVO()
	{
	}

	public AddressVO(String addr1, String addr2, String addr3, String city,
			String state, String postalCode, String country, String type)
	{
		this.address1 = addr1;
		this.address2 = addr2;
		this.address3 = addr3;
		this.city = city;
		this.state = state;
		this.postalCode = postalCode;
		this.country = country;
		this.type = type;
	}

	public AddressVO(String address[], String city, String state,
			String postalCode, String country, String type)
	{
		this.address1 = address[0];
		this.address2 = address[1];
		this.address3 = address[2];
		this.city = city;
		this.state = state;
		this.postalCode = postalCode;
		this.country = country;
		this.type = type;
	}

	public String getType()
	{
		return this.type;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	public String getAddress1()
	{
		return this.address1;
	}

	public void setAddress1(String address1)
	{
		this.address1 = address1;
	}

	public String getAddress2()
	{
		return this.address2;
	}

	public void setAddress2(String address2)
	{
		this.address2 = address2;
	}

	public String getAddress3()
	{
		return this.address3;
	}

	public void setAddress3(String address3)
	{
		this.address3 = address3;
	}

	public String getCity()
	{
		return this.city;
	}

	public void setCity(String city)
	{
		this.city = city;
	}

	public String getState()
	{
		return this.state;
	}

	public void setState(String state)
	{
		this.state = state;
	}

	public String getPostalCode()
	{
		return this.postalCode;
	}

	public void setPostalCode(String postalCode)
	{
		this.postalCode = postalCode;
	}

	public String getCountry()
	{
		return this.country;
	}

	public void setCountry(String country)
	{
		this.country = country;
	}
}