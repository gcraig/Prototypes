package com.csr.common.dao.demo;

import java.util.*;
import com.csr.common.dao.DAO;

public class CommonDemoDAO extends DAO
{
    private static final String MYSQL_VERSION_SQL = " select version() ";

	public String mysqlVersion() throws Exception
	{
		return "4.0";
	}

	public int countAll() throws Exception
	{
		// throw unsupported exception
		return -1;
	}

	public List search(String startRecord, int pageSize) throws Exception
	{
		return null;
	}
}