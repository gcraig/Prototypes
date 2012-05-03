package com.csr.common.util;

public class AppConstants
{

	// constants

	public static final String CONFIG_FILE_NAME = "/AppConfig.properties";
	
	public static final String CONFIG_FILE_URL = "http://localhost/AppConfig.properties";
	
	public static final String CONFIG_FILE_EXC_NOTFOUND = "Fatal error. Configuration file not found remotely.";

	public static final String CONFIG_FILE_EXC_NOTREAD = "Fatal error. Configuration file, found, but not read remotely.";
	
	public static final String CONFIG_FILE_EXC_NOTSTORED = "Fatal error. Configuration file could not be stored locally.";

	public static final String CONFIG_FILE_EXC_NOTLOADED = "Fatal error. Configuration file could not be loaded locally.";
	
	public static final String CONFIG_FILE_EXC_URLMALFORMED = "Fatal error. URL, where configuration file is found, is malformed.";

	public static final String CONFIG_FILE_EXC_HOSTNOTFOUND = "Fatal error. Host, serving configuration file, not found.";

	//public static final String CONFIG_FILE_URL = "file:///g:/Apache Group/Apache2/htdocs/AppConfig.properties";



	// variable constants (i.e., per environment)

	public static String DATA_SOURCE_NAME = AppConfig.getProperty("DATA_SOURCE_NAME");
} 