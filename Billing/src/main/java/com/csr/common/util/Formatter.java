package com.csr.common.util;

import java.text.*;
import java.util.*;

public class Formatter
{
	public static String formatDate(String strdate)
	{
		String s = strdate;

		try
		{
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/YYYY");
			DateFormat formatter = new SimpleDateFormat("YYYY-MM-dd");
			Date date = (Date)formatter.parse( strdate );
			s = sdf.format(date);
		}
		catch (Exception e)
		{
			s = strdate;
		}

		return s;
	}	

	public static String formatCurrency(String strcurrency)
	{
		String s = strcurrency;

		try
		{
		// Format for the default locale
		s = NumberFormat.getNumberInstance().format(strcurrency);
		}
		catch (Exception e)
		{
			s = strcurrency;
		}

		return s;
	}	
}