package com.csr.common.util;

import java.rmi.RemoteException;
import javax.rmi.PortableRemoteObject;
import javax.naming.*;
import javax.ejb.*;

import java.io.*;
import java.util.*;

public class ServiceLocator 
{
	private static ServiceLocator me;
	InitialContext context = null;
    
	private ServiceLocator()
		//throws ServiceLocatorException 
		throws Exception 
	{
		try 
		{

		Properties props = new Properties();
		props.setProperty("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");
		props.setProperty("java.naming.provider.url", "jnp://192.168.1.100:1099");
		props.setProperty("java.naming.factory.url.pkgs", "org.jboss.naming.client");
		props.setProperty("j2ee.clientName", "ClientService");
		context = new InitialContext(props);

//   		InitialContext jndiContext = new InitialContext( props );
			//context = new InitialContext();
		}
		catch(NamingException ne) 
		{
			// throw new ServiceLocatorException(...);
			ne.printStackTrace();
			throw ne;
		}
	}
    
  // Returns the instance of ServiceLocator class
  public static ServiceLocator getInstance() 
  throws Exception {
    if (me == null) {
      me = new ServiceLocator();
    }
    return me;
  }
    
  // Converts the serialized string into EJBHandle 
  // then to EJBObject.
  public EJBObject getService(String id) 
  throws Exception {
//    if (id == null) {
//      throw new ServiceLocatorException(...);
//    }
    try {
      byte[] bytes = new String(id).getBytes();
      InputStream io = new 
        ByteArrayInputStream(bytes);
      ObjectInputStream os = new 
        ObjectInputStream(io);
      javax.ejb.Handle handle = 
        (javax.ejb.Handle)os.readObject();
      return handle.getEJBObject();
    } catch(Exception ex) {
      throw ex;
    }
  }
    
  // Returns the String that represents the given 
  // EJBObject's handle in serialized format.
  protected String getId(EJBObject session) 
  throws Exception {
    try {
      javax.ejb.Handle handle = session.getHandle();
      ByteArrayOutputStream fo = new 
        ByteArrayOutputStream();
      ObjectOutputStream so = new 
        ObjectOutputStream(fo);
      so.writeObject(handle);
      so.flush();
      so.close();
      return new String(fo.toByteArray());
    } catch(RemoteException ex) {
      throw ex;
    } catch(IOException ex1) {
      throw ex1;
    }
 }
    
  // Returns the EJBHome object for requested service 
  // name. Throws ServiceLocatorException If Any Error 
  // occurs in lookup
  public EJBHome getHome(String name, Class clazz) 
  throws Exception {
    try {
      Object objref = context.lookup(name);
      EJBHome home = (EJBHome) 
        PortableRemoteObject.narrow(objref, clazz);
      return home;
    } catch(NamingException ex) {
      //throw new ServiceLocatorException(...);
	  throw ex;
    }
  }
}