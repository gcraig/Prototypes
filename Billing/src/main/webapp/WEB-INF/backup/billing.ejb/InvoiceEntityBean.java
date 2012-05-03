package com.csr.billing.ejb;

import com.csr.billing.dto.*;
import java.rmi.*;
import java.util.*;
import java.sql.*;
import javax.naming.*;
import javax.ejb.*;
import javax.rmi.*;

/**
 * @ejb.bean
 *		name="InvoiceEntity"
 *		jndi-name="ejb/InvoiceEntity"
 *		local-jndi-name="ejb/InvoiceEntityLocal"
 *		type="CMP"
 *		cmp-version="2.x"
 *		primkey-field="invoiceNumber"
 *		view-type="both"
 *
 * @ejb.persistence 
 *		table-name="invoice"
 *
 * @ejb.value-object
 *		name="Invoice"
 *		extends="com.csr.common.dto.BaseDTO"
 *
 * @ejb.finder
 *		signature="Collection findAll()"
 *		query="SELECT OBJECT(e) FROM InvoiceEntity AS e"
 *		transaction-type="Supports"
 *		view-type="both"
 *
 * @ejb.finder
 *		signature="InvoiceEntity findByPrimaryKey(java.lang.Integer pk)"
 *		query="SELECT OBJECT(e) FROM InvoiceEntity AS e where e.invoiceID = ?1"
 *		transaction-type="Supports"
 *		view-type="both"
 */

public abstract class InvoiceEntityBean implements EntityBean
{
	/** 
	* @ejb.create-method 
	*/
	public Integer ejbCreate( InvoiceDTO invoice ) throws CreateException
	{
		setinvoiceID( invoice.getinvoiceID );
		setInvoiceNumber( InvoiceNumber );
		setInvoiceName( InvoiceName );
		setCreditLimit( creditLimit );
		setBillable( billable );
		return null;
	}

	public void ejbPostCreate( InvoiceDTO invoice ) throws CreateException
	{
		System.out.println(" ===> created InvoiceEntity <=== ");
	}

	/**
	* @ejb.pk-field
	* @ejb.interface-method
	* @ejb.persistence column-name="invoiceNumber"
	*/
	public abstract String getInvoiceNumber();
	public abstract void setInvoiceNumber(String invoiceNumber);

	/**
	* @ejb.interface-method
	* @ejb.persistence column-name="invoiceDate"
	*/
	public abstract String getInvoiceDate();
	public abstract void setInvoiceDate(String invoiceDate);

	/**
	* @ejb.interface-method
	* @ejb.persistence column-name="terms"
	*/
	public abstract String getTerms();
	public abstract void setTerms(String terms);

	/**
	* @ejb.interface-method
	* @ejb.persistence column-name="purpose"
	*/
	public abstract String getPurpose();
	public abstract void setPurpose( String purpose );

	/**
	* @ejb.interface-method
	* @ejb.persistence column-name="purchaseOrderNum"
	*/
	public abstract String getPurchaseOrderNum();
	public abstract void setPurchaseOrderNum( String purchaseOrderNum );

	/**
	* @ejb.interface-method
	* @ejb.persistence column-name="exempt"
	*/
	public abstract Boolean getExempt();
	public abstract void setExempt(Boolean exempt);

	/**
	* @ejb.interface-method
	* @ejb.persistence column-name="datePrinted"
	*/
	public abstract String getDatePrinted();
	public abstract void setDatePrinted(String datePrinted);

	/**
	* @ejb.interface-method
	*/
	public abstract void setRownumber(String r);
	public abstract String getRownumber();

	///////////////////////////////////////////////////////////////////////////////////////////////////////

	public void addLineItem(InvoiceItemDTO invoiceItem)
	{
		try 
		{
			// todo: cache lookup
			Context context = new InitialContext();
			Object ref = context.lookup("ejb/InvoiceItemEntityLocal"); // local lookup
			InvoiceItemEntityLocalHome home = (InvoiceItemEntityLocalHome) 
				PortableRemoteObject.narrow(ref, InvoiceItemEntityLocalHome.class);
			InvoiceItemEntityLocal invoiceItemEntity = home.create( invoiceItem ); //includes invoiceNumber
		} 
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public List getLineItems()
	{
		Collection invoiceItems = null;
		try 
		{
			Context context = new InitialContext();
			Object ref = context.lookup("ejb/InvoiceItemEntity");
			InvoiceItemEntityHome home = (InvoiceItemEntityHome) 
				PortableRemoteObject.narrow(ref, InvoiceItemEntityHome.class);
			invoiceItems = home.findAllByInvoice( getInvoiceNumber() );
		} 
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return invoiceItems;
	}
}