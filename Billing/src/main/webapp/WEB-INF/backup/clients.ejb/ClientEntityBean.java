package com.csr.clients.ejb;

import com.csr.clients.dto.*;
import com.csr.common.ejb.BaseEntityBean;
import java.rmi.*;
import java.util.*;
import java.sql.*;
import javax.naming.*;
import javax.ejb.*;
import javax.rmi.*;

/**
 * @ejb.bean
 *		name="ClientEntity"
 *		jndi-name="ejb/ClientEntity"
 *		local-jndi-name="ejb/ClientEntityLocal"
 *		type="CMP"
 *		cmp-version="2.x"
 *		primkey-field="clientID"
 *		view-type="both"
 *
 * @ejb.persistence 
 *		table-name="client"
 *
 * @ejb.value-object
 *		name="Client"
 *		extends="com.csr.common.dto.BaseDTO"
 *
 * @ejb.finder
 *		signature="Collection findAll()"
 *		query="SELECT OBJECT(e) FROM ClientEntity AS e"
 *		transaction-type="Supports"
 *		view-type="both"
 *
 * @ejb.finder
 *		signature="ClientEntity findByPrimaryKey(java.lang.Integer pk)"
 *		query="SELECT OBJECT(e) FROM ClientEntity AS e where e.clientID = ?1"
 *		transaction-type="Supports"
 *		view-type="both"
 */

public abstract class ClientEntityBean extends BaseEntityBean implements EntityBean
{
	/** 
	* @ejb.create-method 
	*/
	public Integer ejbCreate(ClientDTO clientDTO) throws CreateException
	{
			return null;
	}

	/** 
	* @ejb.create-method 
	*/
	public Integer ejbCreate( 
		Integer clientID,
		String clientNumber,
		String clientName,
		Double creditLimit,
		Boolean billable ) throws CreateException
		{
			setClientID( clientID );
			setClientNumber( clientNumber );
			setClientName( clientName );
			setCreditLimit( creditLimit );
			setBillable( billable );
			return null;
		}

	public void ejbPostCreate(
		Integer clientID,
		String clientNumber,
		String clientName,
		Double creditLimit,
		Boolean billable ) throws CreateException
		{
			//System.out.println(" ===> created ClientEntity <=== ");
		}

	/**
	* @ejb.pk-field
	* @ejb.interface-method
	* @ejb.persistence column-name="clientID"
	*/
	public abstract Integer getClientID();
	public abstract void setClientID( Integer clientID );

	/**
	* @ejb.interface-method
	* @ejb.persistence column-name="clientName"
	*/
	public abstract String getClientName();
	public abstract void setClientName( String clientName );

	/**
	* @ejb.interface-method
	* @ejb.persistence column-name="clientNumber"
	*/
	public abstract String getClientNumber();
	public abstract void setClientNumber( String clientNumber );

	/**
	* @ejb.interface-method
	* @ejb.persistence column-name="creditLimit"
	*/
	public abstract Double getCreditLimit();
	public abstract void setCreditLimit( Double creditLimit );

	/**
	* @ejb.interface-method
	* @ejb.persistence column-name="billable"
	*/
	public abstract Boolean getBillable();
	public abstract void setBillable( Boolean billable );

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//access methods for cmr fields

	/**
	* //ejb.interface-method
	*
	* //ejb.relation
	*   name="ClientEntity-AddressEntity"
	*   role-name="ClientEntity-has-many-AddressEntity"
	*/
	//public abstract Set getAddresses();

	/**
	* //ejb.interface-method
	*/
	//public abstract void setAddresses (Set addresses);

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public ClientEntityHome getClientHome()
	{
		Object ref = lookup("ejb/ClientEntity");
		ClientEntityHome home = (ClientEntityHome) 
			PortableRemoteObject.narrow(ref, ClientEntityHome.class);
		return home;
	}

	/**
	* @ejb.interface-method
	*/
	public Collection getAddresses()
	{
		Collection col = null;
		try 
		{
			Context context = new InitialContext();
			Object ref = context.lookup("ejb/AddressEntity");
			AddressEntityHome home = (AddressEntityHome) PortableRemoteObject.narrow(ref, AddressEntityHome.class);
			Integer i = getClientID();
			col = home.findByClient( i );
		} 
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return col;
	}
}