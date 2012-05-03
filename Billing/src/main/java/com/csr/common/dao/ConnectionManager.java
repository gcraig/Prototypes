package com.csr.common.dao;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
//import java.sql.DriverManager;

import java.util.Hashtable;
import javax.naming.NamingException;
import javax.naming.Context;
import javax.naming.InitialContext;

public class ConnectionManager
{
	public ConnectionManager() 
	{
		super();
	}

	public  static java.sql.Connection getConnection() throws SQLException,NamingException
	{
		// Declarations and Initialisations	
		//final String DATA_SOURCE = "serial://datasources/boca/bocaOracle";
		//final String DATA_SOURCE = AppConstants.DATA_SOURCE_NAME;
		//String userId = null;
		//String password = null;

		final String DATA_SOURCE = "java:comp/env/jdbc/BizDB";
		String userId = "root";
		String password = "rainwater99";
		
		String contextFactory = null;
		Connection dbConnection = null;
		DataSource ds = null;

		// EJB lookup to get connection
		try
		{
			Hashtable parms = new Hashtable();
			//parms.put(Context.INITIAL_CONTEXT_FACTORY, contextFactory);
			//Context ctx = new InitialContext(parms);
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup(DATA_SOURCE);
			dbConnection = ds.getConnection();
			ctx.close();
			// getting connection to the database
			// setting Auto commit to false - This will require all the individual
			// transactions to be committed separately .
			//dbConnection.setAutoCommit(false);
		}
		
		catch (SQLException e)
		{
			//Logger.log(1,ConnectionManager.class, e.getMessage());
			e.printStackTrace() ;
			throw e;
		}

		catch (NamingException ne)
		{
			 //Logger.log(1,ConnectionManager.class, ne.getMessage());
			throw ne;
		}
		
		catch(Throwable e)
		{
			e.printStackTrace();
		}

		return dbConnection;
	}

	public static void closeConnection(Connection dbConnection)
	{
		// if connection is already dead then no processing is done ..
		if (dbConnection == null)
			return;
		else
		{
		// otherwise close method is called to close the connnection
			try
			{
				dbConnection.close();
			}
			catch (SQLException e)
			{
			  // Logger.log(Logger.WARNING,ConnectionManager.class,"SQL Exception in closeConnection", e);
			}
		}
		return;
	}

}