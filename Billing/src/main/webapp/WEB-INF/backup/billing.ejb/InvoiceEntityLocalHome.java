/*
 * Generated by XDoclet - Do not edit!
 */
package com.csr.billing.ejb;

/**
 * Local home interface for InvoiceEntity.
 */
public interface InvoiceEntityLocalHome
   extends javax.ejb.EJBLocalHome
{
   public static final String COMP_NAME="java:comp/env/ejb/InvoiceEntityLocal";
   public static final String JNDI_NAME="ejb/InvoiceEntityLocal";

   public com.csr.billing.ejb.InvoiceEntityLocal create(com.csr.billing.ejb.InvoiceDTO invoice)
      throws javax.ejb.CreateException;

   public java.util.Collection findAll()
      throws javax.ejb.FinderException;

   public com.csr.billing.ejb.InvoiceEntityLocal findByPrimaryKey(java.lang.Integer pk)
      throws javax.ejb.FinderException;

}