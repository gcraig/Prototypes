/*
 * Generated by XDoclet - Do not edit!
 */
package com.csr.clients.ejb;

/**
 * Home interface for AddressEntity.
 */
public interface AddressEntityHome
   extends javax.ejb.EJBHome
{
   public static final String COMP_NAME="java:comp/env/ejb/AddressEntity";
   public static final String JNDI_NAME="ejb/AddressEntity";

   public com.csr.clients.ejb.AddressEntity create(com.csr.clients.ejb.AddressDTO addressDTO)
      throws javax.ejb.CreateException,java.rmi.RemoteException;

   public com.csr.clients.ejb.AddressEntity create(java.lang.Integer addressID , java.lang.Integer clientID , java.lang.String address1 , java.lang.String address2 , java.lang.String address3 , java.lang.String city , java.lang.String state , java.lang.String postalCode , java.lang.String country , java.lang.String type)
      throws javax.ejb.CreateException,java.rmi.RemoteException;

   public java.util.Collection findAll()
      throws javax.ejb.FinderException,java.rmi.RemoteException;

   public com.csr.clients.ejb.AddressEntity findByPrimaryKey(java.lang.Integer pk)
      throws javax.ejb.FinderException,java.rmi.RemoteException;

   public java.util.Collection findByClient(java.lang.Integer pk)
      throws javax.ejb.FinderException,java.rmi.RemoteException;

   public java.util.Collection findByCity(java.lang.String city)
      throws javax.ejb.FinderException,java.rmi.RemoteException;

   public java.util.Collection findByState(java.lang.String state)
      throws javax.ejb.FinderException,java.rmi.RemoteException;

   public java.util.Collection findByPostalCode(java.lang.String postalCode)
      throws javax.ejb.FinderException,java.rmi.RemoteException;

}
