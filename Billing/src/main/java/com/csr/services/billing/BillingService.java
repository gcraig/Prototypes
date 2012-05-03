package com.csr.services.billing;

import com.csr.common.dao.DAO;
import java.util.List;

/*
 * BillingService
 * Built on java version 1.4.1
 * 2/2/06 4:11 PM
 */
public class BillingService {
	// make into IBillingService and BillingService class
	public BillingService() {
	}


	public List getInvoices(int pagePtr) { 
		return null;
	}

	//public List getInvoices(int pagePtr, Filter listFilter) {
	//}

	
	private DAO pInvoiceDAO;

	public void setInvoiceDAO(DAO v) {
		pInvoiceDAO = v;
	}

	public DAO getInvoiceDAO() {
	    return pInvoiceDAO;
	}
	
	private DAO pProductDAO;

	public void setProductDAO(DAO v) {
		pProductDAO = v;
	}

	public DAO getProductDAO() {
	    return pProductDAO;
	}
	
	private DAO pAddressDAO;

	public void setAddressDAO(DAO v) {
		pAddressDAO = v;
	}

	public DAO getAddressDAO() {
	    return pAddressDAO;
	}
	
	private DAO pClientDAO;

	public void setClientDAO(DAO v) {
		pClientDAO = v;
	}

	public DAO getClientDAO() {
	    return pClientDAO;
	}
	
	private DAO pContactDAO;

	public void setContactDAO(DAO v) {
		pContactDAO = v;
	}

	public DAO getContactDAO() {
	    return pContactDAO;
	}
	
	private DAO pEmailDAO;

	public void setEmailDAO(DAO v) {
		pEmailDAO = v;
	}

	public DAO getEmailDAO() {
	    return pEmailDAO;
	}
	
	private DAO pPhoneDAO;

	public void setPhoneDAO(DAO v) {
		pPhoneDAO = v;
	}

	public DAO getPhoneDAO() {
	    return pPhoneDAO;
	}
	
	private DAO pUrlDAO;

	public void setUrlDAO(DAO v) {
		pUrlDAO = v;
	}

	public DAO getUrlDAO() {
	    return pUrlDAO;
	}
	
	private DAO pCommonDAO;

	public void setCommonDAO(DAO v) {
		pCommonDAO = v;
	}

	public DAO getCommonDAO() {
	    return pCommonDAO;
	}
	
	public String toString() {
		return "BillingService";
	}
}
