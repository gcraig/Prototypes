package com.csr.billing.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.csr.common.dao.ConnectionManager;
import com.csr.common.dao.DAO;
import com.csr.billing.dto.Product;

public class ProductJDBCDAO extends DAO
{
	private static final String LIST_SQL = 
		"select productID, productType, description, price from product";

    private static final String SEARCH_SQL = 
		"select productID, productType, description, price from product order by productID limit ?, ?";

	private static final String COUNT_SQL = " select count(*) from product";

	private static final String INSERT_SQL = 
		"insert into product (productID, productType, description, price) values (?, ?, ?, ?)";

    public List listAll() throws Exception
    {
        List products = new ArrayList();
        Connection conn = ConnectionManager.getConnection();
        if (conn != null)
        {
            Statement stmt = conn.createStatement();
            ResultSet rs = null;
            rs = stmt.executeQuery(LIST_SQL);
            while (rs.next())
            {
                Product product = new Product();
                product.setProductID(rs.getString(1));
                product.setProductType(rs.getString(2));
                product.setDescription(rs.getString(3));
                product.setPrice(rs.getString(4));
                products.add(product);
            }
            rs.close();
            conn.close();
        }
        return products;
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

    public Object view(String param) throws Exception
	{
		return null;
	}
	 
	public List search(String startRecord, int pageSize) throws Exception
	{
		List products = new ArrayList();

		Connection con = ConnectionManager.getConnection();
        PreparedStatement ps = con.prepareStatement(SEARCH_SQL);

		int x = toInt(startRecord);
        ps.setInt(1, x);
        ps.setInt(2, pageSize);
		ResultSet rs = ps.executeQuery();

		int rowCtr = x;
        while(rs.next())
        {
                Product product = new Product();
				product.setRownumber(++rowCtr + ".");
                product.setProductID(rs.getString(1));
                product.setProductType(rs.getString(2));
                product.setDescription(rs.getString(3));
                product.setPrice(rs.getString(4));
                products.add(product);
        }

        rs.close();
        con.close();
        return products;		
	}

	public int toInt(String strValue)  
	{
		return 
			(strValue==null|| strValue.trim().length() < 1 ) ? 
				-1: Integer.parseInt(strValue) ;
	 }

}