package com.csr.common.dto;

import java.util.*;

public interface Orderable
{
	public Map getOrder();

	public Map getValues();

	public Iterator iterator();
}