package com.csr.client.vo;

import java.util.*;
import com.csr.common.vo.BaseVO;

public class ClientVO extends BaseVO
{

	public static String pad( int i, int len )
	{
		// converts integer to left-zero padded string, len  chars long.
		String s = Integer.toString(i);
		if ( s.length() > len ) return s.substring(0,len);
		else if ( s.length() < len ) // pad on left with zeros
			return "000000000000000000000000000".substring(0, len - s.length ()) + s;
		else return s;
   } // end toLZ
	
	private String id;

	private String creditLimit;

	public void setCreditLimit(String s)
	{
		creditLimit = s;
	}

	public String getCreditLimit()
	{
		return creditLimit;
	}

	private String rownumber;

	public void setRownumber(String rownumber)
	{
		this.rownumber = rownumber;
	}

	public String getRownumber()
	{
		return rownumber;
	}


	private Boolean billable;

	public void setBillable(Boolean billable)
	{
		this.billable  = billable;
	}

	public Boolean getBillable()
	{
		return billable;
	}

	private String clientType;

	private String name;

	private String website;

	private List commentList;

	private List websiteList;

	private List addressList;

	private List phoneList;

	private String primaryOfficerFlag;

	private String officerId;

	private String officerName;

	private String officerAssignedDate;

	private String taxId;

	private String dunsNumberType;

	private String dunsNumberValue;

	private String dateCreated;

	private String dateLastUpdated;

	private String changedBy;

	public ClientVO()
	{
	}

	public String getId()
	{
		return this.id;
	}

	public void setId(String id)
	{
		this.id = id;
		this.id = pad( toInt(id),  5 );
	}

  public int toInt(String strValue)  {
    return (strValue==null|| strValue.trim().length() < 1 ) ?
                                           -1: Integer.parseInt(strValue) ;
  }


	public List getAddressList()
	{
		return addressList;
	}

	public void setAddressList(List addressList)
	{
		this.addressList = addressList;
	}

	public String getChangedBy()
	{
		return changedBy;
	}

	public void setChangedBy(String changedBy)
	{
		this.changedBy = changedBy;
	}

	public String getClientType()
	{
		return clientType;
	}

	public void setClientType(String clientType)
	{
		this.clientType = clientType;
	}

	public List getCommentList()
	{
		return commentList;
	}

	public void setCommentList(List commentList)
	{
		this.commentList = commentList;
	}

	public String getDateCreated()
	{
		return dateCreated;
	}

	public void setDateCreated(String dateCreated)
	{
		this.dateCreated = dateCreated;
	}

	public String getDateLastUpdated()
	{
		return dateLastUpdated;
	}

	public void setDateLastUpdated(String dateLastUpdated)
	{
		this.dateLastUpdated = dateLastUpdated;
	}

	public String getDunsNumberType()
	{
		return dunsNumberType;
	}

	public void setDunsNumberType(String dunsNumberType)
	{
		this.dunsNumberType = dunsNumberType;
	}

	public String getDunsNumberValue()
	{
		return dunsNumberValue;
	}

	public void setDunsNumberValue(String dunsNumberValue)
	{
		this.dunsNumberValue = dunsNumberValue;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getOfficerAssignedDate()
	{
		return officerAssignedDate;
	}

	public void setOfficerAssignedDate(String officerAssignedDate)
	{
		this.officerAssignedDate = officerAssignedDate;
	}

	public String getOfficerId()
	{
		return officerId;
	}

	public void setOfficerId(String officerId)
	{
		this.officerId = officerId;
	}

	public String getOfficerName()
	{
		return officerName;
	}

	public void setOfficerName(String officerName)
	{
		this.officerName = officerName;
	}

	public List getPhoneList()
	{
		return phoneList;
	}

	public void setPhoneList(List phoneList)
	{
		this.phoneList = phoneList;
	}

	public String getPrimaryOfficerFlag()
	{
		return primaryOfficerFlag;
	}

	public void setPrimaryOfficerFlag(String primaryOfficerFlag)
	{
		this.primaryOfficerFlag = primaryOfficerFlag;
	}

	public String getTaxId()
	{
		return taxId;
	}

	public void setTaxId(String taxId)
	{
		this.taxId = taxId;
	}

	public List getWebsiteList()
	{
		return websiteList;
	}

	public void setWebsiteList(List websiteList)
	{
		this.websiteList = websiteList;
	}

	public String getWebsite()
	{
		return website;
	}

	public void setWebsite(String website)
	{
		this.website = website;
	}
	
	public String toString()
	{
		return name + " " + website;
	}

}