/*
 * Generated by XDoclet - Do not edit!
 */
package com.csr.clients.ejb;

/**
 * Local interface for ClientEntity.
 */
public interface ClientEntityLocal
   extends javax.ejb.EJBLocalObject
{

   public java.lang.Integer getClientID(  ) ;

   public java.lang.String getClientName(  ) ;

   public java.lang.String getClientNumber(  ) ;

   public java.lang.Double getCreditLimit(  ) ;

   public java.lang.Boolean getBillable(  ) ;

   public java.util.Collection getAddresses(  ) ;

}