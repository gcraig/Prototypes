package com.csr.tags;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.io.*;
import java.net.*;

import com.csr.common.util.*;

public class NextButtonTag
	extends TagSupport
	implements Tag  
	{

	private String href;

	public int doStartTag() throws JspException 
	{
		return SKIP_BODY;
	}

	public int doEndTag() throws JspException 
	{
		try 
		{
			prn();
		} 
		catch (Exception e) 
		{
			e.printStackTrace(); 
		}      
		return EVAL_PAGE;
	}

	public void setHref(String href) 
	{
		this.href = href;
	}

	public String getHref() 
	{
		return href;
	}

  private void prn()
    throws IOException, ProtocolException, UnknownHostException 
	{

		ServletRequest r = pageContext.getRequest();
		HttpServletRequest request = (HttpServletRequest) r;
		ValueListHandler handler = (ValueListHandler) request.getAttribute("handler");

		int total = handler.getTotal();
		int start = handler.getStart();
		int end = handler.getEnd();
		int pgPtr = handler.getPgPtr();
		int pgPtrSize = handler.getPgPtrSize();
		int prev = pgPtr - 1;
		int next = pgPtr +1;

		if (!(next > pgPtrSize))
		{
			pageContext.getOut().print(
				"<input type=\"button\" value=\"Next\" class=\"submit3\" onClick=\"location.href='" + href + "?pgPtr=" + next + "'\">");

			pageContext.getOut().print("&nbsp;");

			pageContext.getOut().print(
				"<input type=\"button\" value=\">>\" class=\"submit3\" onClick=\"location.href='" + href + "?pgPtr=" + pgPtrSize + "'\">");
		}

	}
}