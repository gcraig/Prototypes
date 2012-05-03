package com.csr.common.ejb;

import javax.ejb.*;
import java.util.*;

import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * This is an account bean. It is an example of how to use the XDoclet tags.
 * There are several jboss tags that cannot be used together: autoincrement and unknown-pk for instance.
 *
 * @ejb.bean
 *   name="UserEJB"
 *   type="CMP"
 *   cmp-version="2.x"
 *   primkey-field="id"
 *   view-type="local"
 *
 * @ejb.value-object
 * 
 * @ejb.finder
 *   signature="Collection findAll()"
 *   query="SELECT OBJECT(e) FROM UserEJB AS e"
 *   transaction-type="Supports"
 */
public abstract class UserBean implements EntityBean
{
  /** 
   * @ejb.create-method 
   */
  public Integer ejbCreate( Integer id,
			   String firstName,
			   String lastName,
			   String address,
			   String city,
			   String state,
			   String zip,
			   String email ) throws CreateException
  {
    setId( id );
	setFirstName( firstName );
	setLastName( lastName );
	setAddress( address );
	setCity( city );
	setState( state );
	setZip( zip );
	setEmail( email );
    return null;
  }

  public void ejbPostCreate( Integer id,
			   String firstName,
			   String lastName,
			   String address,
			   String city,
			   String state,
			   String zip,
			   String email ) throws CreateException
  {
  }
						 
  /**
   * Id of this user.
   *
   * @ejb.pk-field
   * @ejb.persistence column-name="user_id"
   * @ejb.interface-method
   */
  public abstract Integer getId();
  public abstract void setId( Integer id );

  /**
   * @ejb.persistence column-name="user_firstname"
   * @ejb.interface-method
   */
  public abstract String getFirstName();
  public abstract void setFirstName( String firstName );

  /**
   * @ejb.persistence column-name="user_lastname"
   * @ejb.interface-method
   */
  public abstract String getLastName();
  public abstract void setLastName( String lastName );

  /**
   * @ejb.persistence column-name="user_address"
   * @ejb.interface-method
   */
  public abstract String getAddress();
  public abstract void setAddress( String address );

  /**
   * @ejb.persistence column-name="user_city"
   * @ejb.interface-method
   */
  public abstract String getCity();
  public abstract void setCity( String city );

  /**
   * @ejb.persistence column-name="user_state"
   * @ejb.interface-method
   */
  public abstract String getState();
  public abstract void setState( String state );

  /**
   * @ejb.persistence column-name="user_zip"
   * @ejb.interface-method
   */
  public abstract String getZip();
  public abstract void setZip( String zip );

  /**
   * @ejb.persistence column-name="user_email"
   * @ejb.interface-method
   */
  public abstract String getEmail();
  public abstract void setEmail( String email );

  //public abstract UserValue getUserValue();
}