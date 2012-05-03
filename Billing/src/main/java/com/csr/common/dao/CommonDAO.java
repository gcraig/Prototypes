package com.csr.common.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;

import com.csr.common.dao.ConnectionManager;
import java.util.*;

public class CommonDAO extends DAO
{
    private static final String MYSQL_VERSION_SQL = " select version() ";

	public String mysqlVersion() throws Exception
	{
        Connection con = ConnectionManager.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = null;        
        rs = stmt.executeQuery(MYSQL_VERSION_SQL);
		String ver = "";
        if(rs.next())
        {
			ver = rs.getString(1);
        }
        rs.close();
        con.close();
		return ver;		
	}

	public int countAll() throws Exception
	{
		return -1;
	}

	public List search(String startRecord, int pageSize) throws Exception
	{
		return null;
	}
}