package com.csr.billing.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.csr.common.dao.DAO;
import com.csr.common.dao.ConnectionManager;
import com.csr.billing.dto.Invoice;
import com.csr.billing.dto.InvoiceLineItem;

public class InvoiceJDBCDAO extends DAO
{
	private static final String COUNT_SQL = 
		" select count(*) from invoice";

	private static final String LIST_SQL = 
		" select i.invoiceNumber, i.invoiceDate, c.clientName, i.terms, a.totalAmount, i.datePrinted "
            + " from invoice i, client c, invoice_adj_amounts a "
            + " where i.clientID = c.clientID and i.invoiceNumber = a.invoiceNumber ";

    private static final String VIEW_SQL = 
		" select i.invoiceNumber, i.invoiceDate, i.terms, i.purpose, i.exempt, c.clientName, a.address1, a.city, a.state, a.postalCode "
            + " from invoice i, client c, address a "
            + " where invoiceNumber = ? and i.clientID = c.clientID and i.clientBillingAddressID = a.addressID ";

    private static final String VIEW_SQL_ITEMS = 
		" select i.lineItemNumber, p.productID, p.description, i.units, p.price, i.total "
            + " from invoice_line_items i, product p "
            + " where i.productID = p.productID and i.invoiceNumber = ?";

	private static final String SEARCH_SQL = 
		" select i.invoiceNumber, i.invoiceDate, c.clientName, i.terms, a.totalAmount, i.datePrinted "
            + " from invoice i, client c, invoice_adj_amounts a "
            + " where i.clientID = c.clientID and i.invoiceNumber = a.invoiceNumber limit ?,?";

    public List listAll() throws Exception
    {
        List invoices = new ArrayList();
        Connection conn = ConnectionManager.getConnection();
        if (conn != null)
        {
            Statement stmt = conn.createStatement();
            ResultSet rs = null;
            rs = stmt.executeQuery(LIST_SQL);
            while (rs.next())
            {
                Invoice invoice = new Invoice();
                invoice.invoiceNumber = rs.getString(1);
                invoice.invoiceDate = rs.getString(2);
                invoice.name = rs.getString(3);
                invoice.terms = rs.getString(4);
                invoice.totalAmount = rs.getString(5);
                invoice.datePrinted = rs.getString(6);
                invoices.add(invoice);
            }
            rs.close();
            conn.close();
        }
        return invoices;
    }

    public Object view(String param) throws Exception
    {
        Invoice invoice = new Invoice();
        Connection con = ConnectionManager.getConnection();
        PreparedStatement ps = con.prepareStatement(VIEW_SQL);
        ps.setString(1, param);
        ResultSet rs = null;

        rs = ps.executeQuery();
        if (rs.next())
        {
            invoice.invoiceNumber = rs.getString(1);
            invoice.invoiceDate = rs.getString(2);
            invoice.terms = rs.getString(3);
            invoice.purpose = rs.getString(4);
            invoice.exempt = rs.getString(5);
            invoice.name = rs.getString(6);
            invoice.addr1 = rs.getString(7);
            invoice.city = rs.getString(8);
            invoice.state = rs.getString(9);
            invoice.postalCode = rs.getString(10);
        }

        rs.close();
        ps = con.prepareStatement(VIEW_SQL_ITEMS);
        ps.setString(1, param);

        rs = ps.executeQuery();
        while (rs.next())
        {
            InvoiceLineItem lineItem = new InvoiceLineItem();
            lineItem.lineItemNumber = rs.getString(1);
            lineItem.productID = rs.getString(2);
            lineItem.description = rs.getString(3);
            lineItem.units = rs.getString(4);
            lineItem.price = rs.getString(5);
            lineItem.total = rs.getString(6);
            invoice.addLineItem(lineItem);
        }

        rs.close();
        con.close();
        return invoice;
    }

	public int countAll() throws Exception
	{
        Connection con = ConnectionManager.getConnection();
        
        Statement stmt = con.createStatement();
        ResultSet rs = null;        
        rs = stmt.executeQuery(COUNT_SQL);
        
		int count = 0;

        if(rs.next())
        {
			count = rs.getInt(1);
        }

        rs.close();
        con.close();

		return count;		
	}

	public List search(String startRecord, int pageSize) throws Exception
	{
		List invoices = new ArrayList();

		Connection con = ConnectionManager.getConnection();
        PreparedStatement ps = con.prepareStatement(SEARCH_SQL);

		int x = toInt(startRecord);
        ps.setInt(1, x);
        ps.setInt(2, pageSize);
		ResultSet rs = ps.executeQuery();

		int rowCtr = x;
        while(rs.next())
        {
                Invoice invoice = new Invoice();
                invoice.setRownumber(++rowCtr + ".");
                invoice.invoiceNumber = rs.getString(1);
                invoice.invoiceDate = rs.getString(2);
                invoice.name = rs.getString(3);
                invoice.terms = rs.getString(4);
                invoice.totalAmount = rs.getString(5);
                invoice.datePrinted = rs.getString(6);
                invoices.add(invoice);
        }

        rs.close();
        con.close();
        return invoices;		
	}

	public int toInt(String strValue)  
	{
		return 
			(strValue==null|| strValue.trim().length() < 1 ) ? 
				-1: Integer.parseInt(strValue) ;
	 }

}