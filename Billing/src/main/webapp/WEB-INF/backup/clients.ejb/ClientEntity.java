/*
 * Generated by XDoclet - Do not edit!
 */
package com.csr.clients.ejb;

/**
 * Remote interface for ClientEntity.
 */
public interface ClientEntity
   extends javax.ejb.EJBObject
{

   public java.lang.Integer getClientID(  )
      throws java.rmi.RemoteException;

   public java.lang.String getClientName(  )
      throws java.rmi.RemoteException;

   public java.lang.String getClientNumber(  )
      throws java.rmi.RemoteException;

   public java.lang.Double getCreditLimit(  )
      throws java.rmi.RemoteException;

   public java.lang.Boolean getBillable(  )
      throws java.rmi.RemoteException;

   public java.util.Collection getAddresses(  )
      throws java.rmi.RemoteException;

}
