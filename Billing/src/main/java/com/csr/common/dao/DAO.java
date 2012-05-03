package com.csr.common.dao;

import java.util.*;

public abstract class DAO
{
	public abstract int countAll() throws Exception;

	public abstract List search(String startRecord, int pageSize) throws Exception;

	public Object view(String param) throws Exception
	{
		return null;
	}
}