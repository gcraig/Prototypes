/*
 * Generated by XDoclet - Do not edit!
 */
package com.csr.clients.ejb;

/**
 * Home interface for ClientEntity.
 */
public interface ClientEntityHome
   extends javax.ejb.EJBHome
{
   public static final String COMP_NAME="java:comp/env/ejb/ClientEntity";
   public static final String JNDI_NAME="ejb/ClientEntity";

   public com.csr.clients.ejb.ClientEntity create(com.csr.clients.ejb.ClientDTO clientDTO)
      throws javax.ejb.CreateException,java.rmi.RemoteException;

   public com.csr.clients.ejb.ClientEntity create(java.lang.Integer clientID , java.lang.String clientNumber , java.lang.String clientName , java.lang.Double creditLimit , java.lang.Boolean billable)
      throws javax.ejb.CreateException,java.rmi.RemoteException;

   public java.util.Collection findAll()
      throws javax.ejb.FinderException,java.rmi.RemoteException;

   public com.csr.clients.ejb.ClientEntity findByPrimaryKey(java.lang.Integer pk)
      throws javax.ejb.FinderException,java.rmi.RemoteException;

}
