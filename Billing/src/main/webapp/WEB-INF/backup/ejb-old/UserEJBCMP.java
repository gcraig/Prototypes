/*
 * Generated by XDoclet - Do not edit!
 */
package com.csr.common.ejb;

/**
 * CMP layer for UserEJB.
 */
public abstract class UserEJBCMP
   extends com.csr.common.ejb.UserBean
   implements javax.ejb.EntityBean
{

   public void ejbLoad() 
   {
   }

   public void ejbStore() 
   {
   }

   public void ejbActivate() 
   {
   }

   public void ejbPassivate() 
   {

   }

   public void setEntityContext(javax.ejb.EntityContext ctx) 
   {
   }

   public void unsetEntityContext() 
   {
   }

   public void ejbRemove() throws javax.ejb.RemoveException
   {

   }

   public abstract java.lang.Integer getId() ;

   public abstract void setId( java.lang.Integer id ) ;

   public abstract java.lang.String getFirstName() ;

   public abstract void setFirstName( java.lang.String firstName ) ;

   public abstract java.lang.String getLastName() ;

   public abstract void setLastName( java.lang.String lastName ) ;

   public abstract java.lang.String getAddress() ;

   public abstract void setAddress( java.lang.String address ) ;

   public abstract java.lang.String getCity() ;

   public abstract void setCity( java.lang.String city ) ;

   public abstract java.lang.String getState() ;

   public abstract void setState( java.lang.String state ) ;

   public abstract java.lang.String getZip() ;

   public abstract void setZip( java.lang.String zip ) ;

   public abstract java.lang.String getEmail() ;

   public abstract void setEmail( java.lang.String email ) ;

}