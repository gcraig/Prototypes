package com.csr.services.client.ejb;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import javax.naming.*;
import javax.ejb.*;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import javax.ejb.CreateException;

/**
 * XDoclet-based session bean. The class must be declared public according to
 * the EJB specification.
 * 
 * To generate the EJB related files to this EJB: - Add Standard EJB module to
 * XDoclet project properties - Customize XDoclet configuration for your
 * appserver - Run XDoclet
 * 
 * Below are the xdoclet-related tags needed for this EJB.
 * 
 * @ejb.bean name="ClientService" display-name="Client Service"
 *           description="Provides maintenance supports for Client"
 *           jndi-name="ejb/ClientService" type="Stateless" view-type="remote"

 * @ejb.util generate="physical"
 */
public class ClientServiceBean implements SessionBean
{
    // protected Logger logger = Logger.getLogger(getClass().getName());

    /** The session context */
    private SessionContext context;

    /**
     * An example business method
     *
     * @ejb.interface-method view-type = "both"
     * @throws EJBException Thrown if method fails due to system-level error.
     */
    public void addClient() throws EJBException
    {
		System.out.println("Adding client ...");
	}

    /**
     * @ejb.interface-method view-type = "both"
     * @throws EJBException
     */
    public String getClient(int i) throws EJBException
    {
		String result = "not found";
	
		try
		{

			InitialContext initialContext = new InitialContext();
			javax.sql.DataSource ds = (javax.sql.DataSource) initialContext.lookup("java:/MySqlDS");
			java.sql.Connection con = ds.getConnection();

			PreparedStatement ps = con.prepareStatement("select * from client where clientID = ?");
			ps.setInt(1, i);
			ResultSet rs = ps.executeQuery();

			if(rs.next())
			{
				result = rs.getString(2);
			}

			rs.close();
			con.close();
		}
		catch (Exception e)
		{
			throw new EJBException(e.toString());
		}

        return result;		
	}

	/**
     * Set the associated session context. The container calls this method 
     * after the instance creation.
     * 
     * The enterprise bean instance should store the reference to the context 
     * object in an instance variable.
     * 
     * This method is called with no transaction context. 
     * 
     * @throws EJBException Thrown if method fails due to system-level error.
     */
    public void setSessionContext(SessionContext newContext) throws EJBException {
        context = newContext;
    }

    /* (non-Javadoc)
     * @see javax.ejb.SessionBean#ejbRemove()
     */
    public void ejbRemove() throws EJBException, RemoteException {
    }

    /* (non-Javadoc)
     * @see javax.ejb.SessionBean#ejbActivate()
     */
    public void ejbActivate() throws EJBException, RemoteException {
    }

    /* (non-Javadoc)
     * @see javax.ejb.SessionBean#ejbPassivate()
     */
    public void ejbPassivate() throws EJBException, RemoteException {
    }

    /**
     * An ejbCreate method as required by the EJB specification.
     * 
     * The container calls the instance?s <code>ejbCreate</code> method whose
     * signature matches the signature of the <code>create</code> method invoked
     * by the client. The input parameters sent from the client are passed to
     * the <code>ejbCreate</code> method. Each session bean class must have at
     * least one <code>ejbCreate</code> method. The number and signatures
     * of a session bean?s <code>create</code> methods are specific to each 
     * session bean class.
     * 
     * @throws CreateException Thrown if method fails due to system-level error.
     * 
     * @ejb.create-method
     * 
     */
    public void ejbCreate() throws CreateException {
    }
}
