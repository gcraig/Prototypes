package com.csr.client.vo;

import com.csr.common.vo.BaseVO;

public class PhoneNumberVO extends BaseVO
{
	private String number;

	private String extension;

	private String primaryIndicator;

	private String type;

	private String desc;

	private String countryCode;

	private String sourceCode;

	public PhoneNumberVO()
	{
	}

	public PhoneNumberVO(String number, String extension)
	{
		this.number = number;
		this.extension = extension;
	}

	public String getNumber()
	{
		return this.number;
	}

	public void setNumber(String phoneNumber)
	{
		this.number = phoneNumber;
	}

	public String getExtension()
	{
		return this.extension;
	}

	public void setExtension(String extension)
	{
		this.extension = extension;
	}

	public String getPrimaryIndicator()
	{
		return this.primaryIndicator;
	}

	public void setPrimaryIndicator(String indicator)
	{
		this.primaryIndicator = indicator;
	}

	public String getType()
	{
		return this.type;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	public String getDesc()
	{
		return this.desc;
	}

	public void setDesc(String desc)
	{
		this.desc = desc;
	}

	public String getCountryCode()
	{
		return this.countryCode;
	}

	public void setCountryCode(String code)
	{
		this.countryCode = code;
	}

	public String getSourceCode()
	{
		return this.sourceCode;
	}

	public void setSourceCode(String code)
	{
		this.sourceCode = code;
	}

	public String toString()
	{
		return number + " " + extension;
	}
}