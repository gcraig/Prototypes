package com.csr.clients.ejb;

import java.rmi.*;
import java.util.*;
import java.sql.*;
import javax.naming.*;
import javax.ejb.*;
import com.csr.clients.dto.*;

/**
 * @ejb.bean
 *		name="AddressEntity"
 *		jndi-name="ejb/AddressEntity"
 *		local-jndi-name="ejb/AddressEntityLocal"
 *		type="CMP"
 *		cmp-version="2.x"
 *		primkey-field="addressID"
 *		view-type="both"
 *
 * @ejb.persistence table-name="address"
 *
 * @ejb.value-object
 *		name="Address"
 *		extends="com.csr.common.dto.BaseDTO"
 *
 * @ejb.finder
 *		signature="Collection findAll()"
 *		query="SELECT OBJECT(e) FROM AddressEntity AS e"
 *		transaction-type="Supports"
 *		view-type="both"
 *
 * @ejb.finder
 *		signature="AddressEntity findByPrimaryKey(java.lang.Integer pk)"
 *		query="SELECT OBJECT(e) FROM AddressEntity AS e where e.addressID = ?1"
 *		transaction-type="Supports"
 *		view-type="both"
 *
 * @ejb.finder
 *		signature="Collection findByClient(java.lang.Integer pk)"
 *		query="SELECT OBJECT(e) FROM AddressEntity AS e where e.clientID = ?1"
 *		transaction-type="Supports"
 *		view-type="both"
 *
 * @ejb.finder
 *		signature="Collection findByCity(java.lang.String city)"
 *		query="SELECT OBJECT(e) FROM AddressEntity AS e where e.city = ?1"
 *		transaction-type="Supports"
 *		view-type="both"
 *
 * @ejb.finder
 *		signature="Collection findByState(java.lang.String state)"
 *		query="SELECT OBJECT(e) FROM AddressEntity AS e where e.state = ?1"
 *		transaction-type="Supports"
 *		view-type="both"
 *
 * @ejb.finder
 *		signature="Collection findByPostalCode(java.lang.String postalCode)"
 *		query="SELECT OBJECT(e) FROM AddressEntity AS e where e.postalCode = ?1"
 *		transaction-type="Supports"
 *		view-type="both"
 */

public abstract class AddressEntityBean implements EntityBean
{
//	'Mailing', 'Billing', 'Other'
	/** 
	* @ejb.create-method 
	*/
	public Integer ejbCreate(AddressDTO addressDTO) throws CreateException
	{
			return null;
	}

	/** 
	* @ejb.create-method 
	*/
	public Integer ejbCreate( 
		Integer addressID,
		Integer clientID,
		String address1,
		String address2,
		String address3,
		String city,
		String state,
		String postalCode,
		String country,
		String type) throws CreateException
	{
		setAddressID( addressID );
		setClientID( clientID );
		setAddress1( address1 );
		setAddress2( address2 );
		setAddress3( address3 );
		setCity( city );
		setState( state );
		setPostalCode( postalCode );
		setCountry( country );
		setAddressType( type );
		return null;
	}

	public void ejbPostCreate(
		Integer addressID,
		Integer clientID,
		String address1,
		String address2,
		String address3,
		String city,
		String state,
		String postalCode,
		String country,
		String type) throws CreateException
	{
		//System.out.println(" ===> created AddressEntity <=== ");
	}

	/**
	* @ejb.pk-field
	* @ejb.interface-method
	* @ejb.persistence column-name="addressID"
	*/
	public abstract Integer getAddressID();
	public abstract void setAddressID( Integer addressID );

	/**
	* @ejb.interface-method
	* @ejb.persistence column-name="clientID"
	*/
	public abstract Integer getClientID();
	public abstract void setClientID( Integer clientID );

	/**
	* @ejb.interface-method
	* @ejb.persistence column-name="address1"
	*/
	public abstract String getAddress1();
	public abstract void setAddress1( String address1 );

	/**
	* @ejb.interface-method
	* @ejb.persistence column-name="address2"
	*/
	public abstract String getAddress2();
	public abstract void setAddress2( String address2 );

	/**
	* @ejb.interface-method
	* @ejb.persistence column-name="address3"
	*/
	public abstract String getAddress3();
	public abstract void setAddress3( String address3 );

	/**
	* @ejb.interface-method
	* @ejb.persistence column-name="city"
	*/
	public abstract String getCity();
	public abstract void setCity( String city );

	/**
	* @ejb.interface-method
	* @ejb.persistence column-name="state"
	*/
	public abstract String getState();
	public abstract void setState( String state );

	/**
	* @ejb.interface-method
	* @ejb.persistence column-name="postalCode"
	*/
	public abstract String getPostalCode();
	public abstract void setPostalCode( String postalCode );

	/**
	* @ejb.interface-method
	* @ejb.persistence column-name="country"
	*/
	public abstract String getCountry();
	public abstract void setCountry( String country );

	/**
	* @ejb.interface-method
	* @ejb.persistence column-name="addressType"
	*/
	public abstract String getAddressType();
	public abstract void setAddressType( String addressType );

	public AddressEntityHome getAddressHome()
	{
		Object ref = lookup("ejb/AddressEntity");
		AddressEntityHome home = (AddressEntityHome) 
			PortableRemoteObject.narrow(ref, AddressEntityHome.class);
		return home;
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//access methods for cmr fields

	/**
	* //ejb.interface-method
	*
	* //ejb.relation
	*   name="ClientEntity-AddressEntity"
	*   role-name="AddressEntity-belongs-to-ClientEntity"
	*/
	//public abstract ClientEntityLocal getClientEntity();

	/**
	* //ejb.interface-method
	*/
	//public abstract void setClientEntity( ClientEntityLocal client );

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}