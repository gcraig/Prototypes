/*
 * Copyright (c)2005. CSR Development, Inc. All rights reserved.
 *
 * This software is the confidential and proprietary information of 
 * CSR Development, Inc.  You shall not disclose such
 * Confidential Information and shall use it only in accordance with the
 * terms of the license agreement you entered into with CSR.
 */

package com.csr.common.filters;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

// import com.bankone.ckc.security.CKCUser;

/**
 * Filter to authenticate a valid user; in addition, a valid, current 
 * HttpSession will be created.
 *
 * @author craiggx
 */

public class AuthenticationFilter implements Filter
{
	private FilterConfig config;
	private String URL;
	private String AUTH_MODE;
	private String FILTER_NAME;

	public AuthenticationFilter()
	{
	}

	public void init(FilterConfig config)
	{
		this.config = config;
		this.URL = config.getInitParameter("url-pattern");
		this.AUTH_MODE = config.getInitParameter("AUTHENTICATION_MODE");
		this.FILTER_NAME = config.getFilterName();
	}

	public void doFilter(
		ServletRequest req,
		ServletResponse resp,
		FilterChain chain)
		throws IOException, ServletException
	{
		//User user = null;
/*
		CKCUser user = null;
		// if the user has not been authenticated, attempt to log them in
		if (!isUserAuthenticated(req))
		{
			user =
				authenticateUser(
					(HttpServletRequest) req,
					(HttpServletResponse) resp);
			storeUser(user, req); // store in session
		}
		if (isUserAuthenticated(req))
		{
			chain.doFilter(req, resp);
		} else
		{
			throw new ServletException("You have not been adequately authenticated. Please contact an administrator.");
		}
		*/
	}

	public void destroy()
	{
	}

	public FilterConfig getFilterConfig()
	{
		return config;
	}

	public void setFilterConfig(FilterConfig config)
	{
		this.config = config;
	}

	/** Returns a String representation of this Filter object. */
	public String toString()
	{
		return FILTER_NAME + " { " + URL + " } ";
	}

/*
	private boolean isUserAuthenticated(ServletRequest req)
	{
		boolean result = false;
		HttpSession session = ((HttpServletRequest) req).getSession(true);
		return ((CKCUser) session.getAttribute(CKCUser.CKC_USER) == null);
	}

	private void storeUser(CKCUser user, ServletRequest req)
	{
		HttpSession session = ((HttpServletRequest) req).getSession();
		session.setAttribute(CKCUser.CKC_USER, user);
	}

	private CKCUser authenticateUser(
		HttpServletRequest request,
		HttpServletResponse response)
		throws SecurityException
	{
		CKCUser user = null;
		if (AUTH_MODE.equalsIgnoreCase("siteminder"))
		{
			user = authenticateViaSiteminder(request);
		} else if (AUTH_MODE.equalsIgnoreCase("properties"))
		{
			user = authenticateViaProperties();
		} else if (AUTH_MODE.equalsIgnoreCase("container"))
		{
			user = authenticateViaContainer(request);
		} else {
			user = authenticateViaProperties();			
		}
		request.getSession().setAttribute(CKCUser.CKC_USER, user);
		return user;
	}

	// Authenticate and return a valid CKCUser via Siteminder http headers 
	private CKCUser authenticateViaSiteminder(HttpServletRequest request)
		throws SecurityException
	{
		CKCUser user = new CKCUser(request);
		if (user == null)
			throw new SecurityException("Could not authenticate User via Siteminder header entries.");
		return user;
	}

	 // Authenticate and return a valid CKCUser via a container check; it
	 // is assumed the user is valid and is in session as set by the container.
	 
	private CKCUser authenticateViaContainer(HttpServletRequest request)
		throws SecurityException
	{
		HttpSession session = request.getSession();
		CKCUser user =
			(CKCUser) session.getAttribute("allaire.jrun.security.principal");
		if (user == null)
			throw new SecurityException("Could not authenticate User via container.");
		return user;
	}

	// Authenticate and return a valid CKCUser via local properties file. 
	private CKCUser authenticateViaProperties() throws SecurityException
	{
		Properties namedUserProperties = new Properties();
		FileInputStream in = null;
		CKCUser user = null;
		String filename = "";
		try
		{
			filename =
				config.getServletContext().getRealPath("/WEB-INF")
					+ "/data/defaultuser.properties";

			in = new FileInputStream(filename);
			namedUserProperties.load(in);
			user = new CKCUser(namedUserProperties);
		} catch (Exception e)
		{
			throw new SecurityException(
				"Could not authenticate User via properties file."
					+ "["
					+ filename
					+ "].");
		}
		if (user == null)
			throw new SecurityException(
				"Could not authenticate User via invalid properties file values."
					+ "["
					+ namedUserProperties
					+ "].");
		return user;
	}
	*/
}