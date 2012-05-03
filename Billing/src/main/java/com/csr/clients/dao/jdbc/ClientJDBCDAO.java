package com.csr.clients.dao.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import com.csr.clients.dto.ClientDTO;
import com.csr.common.dao.ConnectionManager;
import com.csr.common.dao.DAO;

import java.util.*;

public class ClientJDBCDAO extends DAO
{
    private static final String LIST_SQL = " select clientID,  clientName, creditLimit, billable from client";
	private static final String COUNT_SQL = " select count(clientID) from client";
	private static final String FILTER_COUNT_SQL = " select count(clientID) from client where clientID > ?";
    private static final String SEARCH_SQL = " select clientID,  clientName, creditLimit, billable from client order by clientName limit ?, ?";

	public Object view(String param) throws Exception
	{
		return null;
	}

	public int countAll() throws Exception
	{
        Connection con = ConnectionManager.getConnection();
        
        Statement stmt = con.createStatement();
        ResultSet rs = null;        
        rs = stmt.executeQuery(COUNT_SQL);
        
		int count = 0;

        if(rs.next())
        {
			count = rs.getInt(1);
        }

        rs.close();
        con.close();

		return count;		
	}

/*
	public List listAll() throws Exception
	{
        Connection con = ConnectionManager.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = null;        
        rs = stmt.executeQuery(LIST_SQL);
        
		List clients = new ArrayList();

        while(rs.next())
        {
        	ClientDTO client = new ClientDTO();
			client.setId( rs.getString(1) );
			client.setName( rs.getString(2) );
			client.setCreditLimit( rs.getString(3) );
			client.setBillable( new Boolean(rs.getBoolean(4)) );

			clients.add( client );
        }

        rs.close();
        con.close();
        return clients;		
	}
*/

	public int toInt(String strValue)  
	{
		return 
			(strValue==null|| strValue.trim().length() < 1 ) ? 
				-1: Integer.parseInt(strValue) ;
	 }

	// change to int
	public List search(String startRecord, int pageSize) throws Exception
	{
		List clients = new ArrayList();

		Connection con = ConnectionManager.getConnection();
        PreparedStatement ps = con.prepareStatement(SEARCH_SQL);

		int x = toInt(startRecord);
        ps.setInt(1, x);
        ps.setInt(2, pageSize);
		ResultSet rs = ps.executeQuery();

		int rowCtr = x;
        while(rs.next())
        {
			ClientDTO client = new ClientDTO();
			client.setRownumber(++rowCtr + ".");
			client.setClientID( new Integer(rs.getInt(1)) );
			client.setClientName( rs.getString(2) );
			client.setCreditLimit( new Double(rs.getDouble(3)) );
			client.setBillable( new Boolean(rs.getBoolean(4)) );
			clients.add( client );
        }

        rs.close();
        con.close();
        return clients;		
	}
}