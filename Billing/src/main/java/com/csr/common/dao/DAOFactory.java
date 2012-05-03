package com.csr.common.dao;

import java.io.*;
import java.util.*;

public class DAOFactory
{
	// todo:
	//GenericDAO dao = new GenericDAO(clazz, HibernateUtil.currentSession());

	private static DAOFactory factory = new DAOFactory();
	
	private static Properties daoConfig = new Properties();

	private static Properties daoProps = new Properties();

	static
	{
		String daoValue = null;

		try
		{
			// load dao properties
			
			log("DAO Configuration .....................");
			log("Initializing dao-config.properties");
			
			daoConfig.load(
				factory.getClass().getResourceAsStream ("/dao-config.properties"));
			
			String daoLayer = daoConfig.getProperty("dao.layer");
			// dao-demo.properties
			// dao-hibernate.properties

			daoProps.load(
				factory.getClass().getResourceAsStream ("/" + daoLayer));

			log("DAO properties loaded: " + daoLayer + "\n");

			// initialize all daos
			//Enumeration e = daoProps.propertyNames();
			//while (e.hasMoreElements())
			//{
			//	String key = (String) e.nextElement();
			//	daoValue = daoProps.getProperty(key);
			//	log("DAO buffer: " + key + " : " + daoValue);
			//	Object obj = Class.forName(daoValue).newInstance();
			//	log("Storing DAO: " + obj);
			//	daoBuffer.put(key, obj);
			//}
			
			//log("DAO Initializing complete.");
		}
		catch (IOException ioe)
		{
			// todo: log error
			System.err.println("Error: Cannot read from dao-config.properties file(s).");
			ioe.printStackTrace();
		}
	}

	private DAOFactory()
	{
	}

	public static DAO obtain(String daoName)
	{
		Object obj = null;

		// i.e., obtain("invoice");
		log("DAO Fetching " + daoName);
		//return (DAO) daoBuffer.get(daoName);

		String daoValue = daoProps.getProperty(daoName);
		log("DAO requested: " + daoName + " : " + daoValue);

		try
		{
			obj = Class.forName(daoValue).newInstance();
		}
		catch (ClassNotFoundException cnf)
		{
			// todo: log error
			System.err.println("Error: Cannot find DAO class file: " + daoValue);
			cnf.printStackTrace();
		}
		catch (IllegalAccessException ie)
		{
			System.err.println("Error: Insufficient access to load DAO class file: " + daoValue);
			ie.printStackTrace();
		}
		catch (InstantiationException ie)
		{
			System.err.println("Error: Cannot instantiate DAO class file: " + daoValue);
			ie.printStackTrace();
		}

		return (DAO) obj;
	}

	private static void log(String msg)
	{
		System.out.println(msg);
	}
}