package com.csr.client.vo;

import com.csr.common.vo.BaseVO;

public class ContactVO extends BaseVO
{
	private String prefix;

	private String lastName;

	private String firstName;

	private String middleInitial;

	private String suffix;

	private String occupation;

	private String dateOfBirth;

	private String maritalStatus;

	private String spouseName;

	private String salutation;

	private String primaryContactMethod;

	private String mailPreference;

	public ContactVO()
	{
	}

	public String getDateOfBirth()
	{
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth)
	{
		this.dateOfBirth = dateOfBirth;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public String getMailPreference()
	{
		return mailPreference;
	}

	public void setMailPreference(String mailPreference)
	{
		this.mailPreference = mailPreference;
	}

	public String getMaritalStatus()
	{
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus)
	{
		this.maritalStatus = maritalStatus;
	}

	public String getMiddleInitial()
	{
		return middleInitial;
	}

	public void setMiddleInitial(String middleInitial)
	{
		this.middleInitial = middleInitial;
	}

	public String getOccupation()
	{
		return occupation;
	}

	public void setOccupation(String occupation)
	{
		this.occupation = occupation;
	}

	public String getPrefix()
	{
		return prefix;
	}

	public void setPrefix(String prefix)
	{
		this.prefix = prefix;
	}

	public String getPrimaryContactMethod()
	{
		return primaryContactMethod;
	}

	public void setPrimaryContactMethod(String primaryContactMethod)
	{
		this.primaryContactMethod = primaryContactMethod;
	}

	public String getSalutation()
	{
		return salutation;
	}

	public void setSalutation(String salutation)
	{
		this.salutation = salutation;
	}

	public String getSpouseName()
	{
		return spouseName;
	}

	public void setSpouseName(String spouseName)
	{
		this.spouseName = spouseName;
	}

	public String getSuffix()
	{
		return suffix;
	}

	public void setSuffix(String suffix)
	{
		this.suffix = suffix;
	}
}