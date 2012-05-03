package com.csr.client.vo;

import com.csr.common.vo.BaseVO;

public class WebSiteVO extends BaseVO
{
	private String type; // intranet, extranet, www

	private String website;

	public String getType()
	{
		return type;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	public String getWebsite()
	{
		return website;
	}

	public void setWebsite(String website)
	{
		this.website = website;
	}
}
