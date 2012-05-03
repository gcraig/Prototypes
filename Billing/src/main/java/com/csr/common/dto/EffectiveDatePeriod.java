package com.csr.common.dto;

import java.util.*;

public class EffectiveDatePeriod implements java.io.Serializable
{
	private Date startDate; // creation date
	private Date endDate; // close date

	public boolean isCurrent(Date date)
	{
		// check if date is within start/end date
		return false;
	}

	public boolean isElegible(Date date)
	{
		return isCurrent(date);
	}

	public boolean isIneligible(Date date)
	{
		return !isCurrent(date);
	}

	public boolean isPrior(Date date)
	{
		// check if date is before start/end date
		return false;
	}

	public boolean isAfter(Date date)
	{
		// check if date is after start/end date
		return false;
	}
}

/*
	Account <-->*  Program { 
					Name
					Description
					EffectiveDatePeriod
					Status
					}
*/