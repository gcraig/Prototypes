package com.csr.common.util;

import java.io.*;
import java.net.*;
import java.util.*;

public class AppConfig
{
	static
	{
		AppConfig.init();
	}

	private static StringBuffer retrieveConfigFile(String configFileURL)
	{
		BufferedInputStream bis = null;
		StringBuffer buf = null;

		try
		{
			URL url = new URL( configFileURL );
			bis = new BufferedInputStream( url.openStream() );
			buf = new StringBuffer();

			int byte_;
			while ((byte_ = bis.read ()) != -1)
				buf.append( (char) byte_ );
		}
		catch (FileNotFoundException fnf)
		{
			throw new RuntimeException(AppConstants.CONFIG_FILE_EXC_NOTFOUND, fnf);
		}
		catch (MalformedURLException mue)
		{
			throw new RuntimeException(AppConstants.CONFIG_FILE_EXC_URLMALFORMED, mue);
		}
		catch (UnknownHostException uhe)
		{
			throw new RuntimeException(AppConstants.CONFIG_FILE_EXC_HOSTNOTFOUND, uhe);
		}
		catch (IOException e)
		{
			throw new RuntimeException(AppConstants.CONFIG_FILE_EXC_NOTREAD, e);
		}
		finally
		{
			if (bis != null)
				try { bis.close (); } catch (IOException e) {}
		}

		System.out.println("-- Retrieved remote configuration file.");
		return buf;
	}


	private static StringBuffer retrieveConfigFile()
	{
		return retrieveConfigFile( AppConstants.CONFIG_FILE_URL );
	}


	private static void storeConfigFileBuffer(StringBuffer buf)
	{
		BufferedOutputStream bos = null;

		try
		{
			File output = new File( AppConstants.CONFIG_FILE_NAME );
			bos = new BufferedOutputStream( new FileOutputStream(output) );

			for (int i=0; i<buf.length(); i++)
				bos.write( (char)buf.charAt(i) );
			bos.flush();
		}
		catch (IOException e)
		{
			throw new RuntimeException(AppConstants.CONFIG_FILE_EXC_NOTSTORED, e);
		}
		finally
		{
			if (bos != null)
				try { bos.close (); } catch (IOException e) {}
		}

		System.out.println("-- Stored configuration file, locally.");
	}


	private static void loadConfigFileConstants()
	{
		try
		{
			InputStream is = AppConfig.class.getClass().
				getResourceAsStream(AppConstants.CONFIG_FILE_NAME);
			props.load(is);
		}
		catch (IOException e) 
		{
			throw new RuntimeException(AppConstants.CONFIG_FILE_EXC_NOTLOADED, e);
		}
		loaded = true;
		System.out.println("-- Loaded configuration file into memory.");
	}

	
	public static String getProperty(String name) 
	{
	  return props.getProperty(name);
	}


	public static String getProperty(String name, String defaultValue) 
	{
	  return props.getProperty(name, defaultValue);
	}


	public static void init(String configFileURL)
	{
		System.out.println("Initializing application configuration ...");
		StringBuffer buf = null;

		if (null == configFileURL)
			buf = retrieveConfigFile();
		else
			buf = retrieveConfigFile(configFileURL);

		storeConfigFileBuffer( buf );		
		loadConfigFileConstants();

		if (null == configFileURL)
			System.out.println("-- Configuration values read from default file: " + 
				AppConstants.CONFIG_FILE_URL + "\n-- Since: " + new Date());
		else
			System.out.println("-- Configuration values read from file: " +
				configFileURL + "\n-- Since: " + new Date());
	}


	public static void init()
	{
		init(null);
	}


	public static void touch()
    {
    }



	public static void main(String[] args) 
	{
		AppConfig.init();
	}


	private static Properties props = new Properties();

	private static boolean loaded;
}

	
	// reads remote config file, only if changed =)
/*
			try
			{
				String rf = MD5.getStrBufHash(buf);
				String lf = MD5.getFileHash(output);
				System.out.println(rf + "\tsum of file read into buffer.");
				System.out.println(lf + "\tsum of file written.");
				String results = (rf.equals(lf)) ? "MATCH OK" : "error. do not match.";
				System.out.println(results);
			} catch (Exception e) {}
*/