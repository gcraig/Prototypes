/**
 * @author                        : Shrinivas Bhat
 * @Version                       : 1.0
 *
 * Development Environment        :  Oracle JDeveloper 10g
 * Name of the File               :  DBManager.java
 * Creation/Modification History  :
 *
 *    Shrinivas Bhat    5-Jul-2004     Created
 *
 */
package oracle.otnsamples.vlh;

// Import SQL classes
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// Import Util classes
import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to get the database connection and execute the required
 * query. The methods in this class retrieve the data from Orders, Order_Items
 * and Products table.
 */
public class DBManager  {
  // ConnectionManager object
  ConnectionManager connManager = null;
  OrdersListHandler valueList = null;

  /**
   * Default constructor
   */
  public DBManager() {
    try  {
     // Get the instance of ConnectionManager
     connManager = ConnectionManager.getInstance();
    } catch (Exception ex)  {
     ex.printStackTrace();
    }
  }

  public ProductInformation getProductInformation(int productId)  throws Exception {
    // Connection from the Connection Cache
    Connection conn = null;

    // PreparedStatement and ResultSet Object for
    // fetching the Product Information
    PreparedStatement pstmt = null;
    ResultSet rset = null;
    // ProductInformation object to hold product details
    ProductInformation productInfo = null;
      try {
        // Get Connection from the Cache
        conn = connManager.getConnection();

        // Query
        String productsQuery = " SELECT p.product_id, p.product_name, " +
                               " p.product_description, p.list_price, " +
                               " p.min_price, "+
                               " c.category_name, p.product_status FROM " +
                               " product_information p, categories_tab c "+
                               " WHERE "+
                               " p.category_id = c.category_id "+
                               " AND p.product_id = ? " ;

        pstmt = conn.prepareStatement(productsQuery);
        // Set the value for the bind variable
        pstmt.setInt(1,productId);
        // Execute Statement to get product Information from the Database
        rset = pstmt.executeQuery();
        productInfo = new ProductInformation();
        if (rset.next()) {
          productInfo = new ProductInformation();
          // Set the values in ProductInformation
          productInfo.setProductId(""+rset.getInt(1));
          productInfo.setProductName(rset.getString(2) );
          productInfo.setProductDescription(rset.getString(3) );
          productInfo.setListPrice(""+rset.getFloat(4));
          productInfo.setMinimumPrice(rset.getDouble(5));
          productInfo.setCategoryName(rset.getString(6));
          productInfo.setProductStatus(rset.getString(7));
        }
      } catch (SQLException ex) { // Catch Sql Exceptions
        ex.printStackTrace();
        throw new Exception("SQL Error : \n" + ex.toString());
      } finally {
        try {
          // Close ResultSet, Statement and Connection
          rset.close();
          pstmt.close();
          conn.close();

        } catch (Exception ex) { // Catch All Exceptions
          throw new Exception("SQL Error while closing objects = " +
                                ex.toString() );
        }
      }
    return productInfo; // Return ProductInformation
  }

  /**
   * Returns the total number of rows in the order_items table
   * for the given orderId
   * @param orderId - Order_ID
   * @return Number of order items
   */
  public int getAllOrderItemsSize(int orderId)  {
    Connection conn = null;
    int count = -1;

    // PreparedStatement and ResultSet objects
    PreparedStatement pstmt = null;
    ResultSet rset = null;
    // Fetch size from the database
    try {
      // Get Connection from the Connection Cache
      conn = connManager.getConnection();
      pstmt = conn.prepareStatement(" SELECT COUNT(ORDER_ID) FROM ORDER_ITEMS "+
                                    " WHERE ORDER_ID = ?"   );
      // Set the value for Order_Id
      pstmt.setInt(1,orderId);
      // Execute the query
      rset = pstmt.executeQuery();
      if ( rset != null && rset.next()== true )  {
        // Get the count
        count = rset.getInt(1);
      }
    } catch (Exception ex)  {
      ex.printStackTrace();
    }
    return count;
  }

  /**
   * Get the number of rows in the ORDERS table
   * @return Number of rows
   */
  public int getAllOrdersSize()  {
    Connection conn = null;
    int count = -1;

    // PreparedStatement and ResultSet objects
    PreparedStatement pstmt = null;
    ResultSet rset = null;
    // Fetch information from the database
    try {
      // Get Connection from the Connection Cache.
      conn = connManager.getConnection();
      // Prepare statement
      pstmt = conn.prepareStatement("SELECT COUNT(ORDER_ID) FROM ORDERS ");
      // Execute query
      rset = pstmt.executeQuery();
      if ( rset != null && rset.next()== true )  {
        // Get the count
        count = rset.getInt(1);
      }
    } catch (Exception ex)  {
      ex.printStackTrace();
    }
    return count;
  }

  /**
   * Returns a list of all orders present in the database
   * @param productId
   * @return - List of Order Information
   * @throws Exception
   */
  public ValueListHandler getOrders(int startIndex, int endIndex)
                                                           throws Exception {
    //  List holding order information
    List orderList = new ArrayList();
    valueList = new OrdersListHandler ();
    Orders orderEntry = null;

    // Connection from the Connection Cache
    Connection conn = null;

    // PreparedStatement and ResultSet objects
    PreparedStatement pstmt = null;
    ResultSet rset = null;
    // Fetch Order Information from the database
    try {
      // Get Connection from the Connection Cache.
      conn = connManager.getConnection();

      // Query to fetch the Order Information
      String query = "SELECT * FROM "+
                        " (SELECT unique o.order_id, c.cust_first_name, " +
                              " c.cust_last_name, o.order_date, " +
                              " TO_CHAR(o.order_date, 'DD-MON-YYYY')," +
                              " o.order_total, o.order_mode, o.order_status, "+
                              " ROWNUM rnum "+
                              " FROM orders o, customers c "+
                              " WHERE c.customer_id = o.customer_id  "+
                              " ORDER BY order_date desc ) "+
                              " WHERE rnum BETWEEN ? AND ?" ;

      // Prepare statement
      pstmt = conn.prepareStatement( query );
      // Set the values for bind variables
      pstmt.setInt(1,startIndex);
      pstmt.setInt(2,endIndex);
      // Execute Query
      rset = pstmt.executeQuery();

      // Loop through the result set and set the order details in the
      // Orders value object.
      while (rset.next()) {
        orderEntry = new Orders();
        orderEntry.setOrderId(rset.getInt(1));
        orderEntry.setCustomerName(rset.getString(2)+" "+rset.getString(3));
        orderEntry.setOrderDate(rset.getString(5));
        orderEntry.setUnitPrice(rset.getDouble(6));
        orderEntry.setOrderMode(rset.getString(7));
        orderEntry.setOrderStatus( getOrderStatus(rset.getInt(8)) );

        // Add the orders value object to the array list
        orderList.add(orderEntry);
      }
      // Set the orders list the OrdersListHandler object
      valueList.setList(orderList);
    } catch (java.sql.SQLException ex) { // Catch SQL Exceptions
       ex.printStackTrace();
       throw new Exception("SQL Error = " + ex.toString());
    } finally {
      try {
        // Close ResultSet, PreparedStatement and Connection
        rset.close();
        pstmt.close();
        conn.close();
      } catch (Exception ex) { // Catch All exceptions
         ex.printStackTrace();
         throw new Exception("SQL Error while closing objects = " +
                              ex.toString() );
      }
    }
    return valueList ; // Return OrderListHandler
  }

  /**
   * Returns a string indicating the status of the order
   * @param statusCode - Status code
   * @return - Status
   */
  private String getOrderStatus(int statusCode) {
    String orderStatus ;
     switch (statusCode)  {
     case 0: {
       orderStatus = "Not fully entered";
     }
     break;
     case 1: {
       orderStatus = "Entered";
     }
     break;
     case 2: {
       orderStatus = "Canceled - bad credit";
     }
     break;
     case 3: {
       orderStatus = "Canceled - by customer";
     }
     break;
     case 4: {
       orderStatus = "Shipped - whole order";
     }
     break;
     case 5: {
       orderStatus = "Shipped - replacement items";
     }
     break;
     case 6: {
       orderStatus = "Shipped - backlog on items";
     }
     break;
     case 7: {
       orderStatus = "Shipped - special delivery";
     }
     break;
     case 8: {
       orderStatus = "Shipped - billed";
     }
     break;
     case 9: {
       orderStatus = "Shipped - payment plan";
     }
     break;
     case 10: {
       orderStatus = "Shipped - paid";
     }
     break;
     default: {
       orderStatus = "N/A";
     }
     break;
   }
    return orderStatus;
  }

  /**
   *  Returns a list of order details for a given order id
   * @param orderId
   * @return
   * @throws java.lang.Exception
   */
  public ValueListHandler getOrderItems(int startIndex,
                                        int endIndex,
                                        int orderId)  throws Exception {
     valueList = new OrdersListHandler();

    // Declare ArrayList to hold OrderItems Information
    List ordersList = new ArrayList();

    // Connection from the Connection Cache
    Connection conn = null;

    // PreparedStatement and ResultSet objects
    PreparedStatement pstmt = null;
    ResultSet rset = null;

    try {
      // Get Connection from the Cache
      conn = connManager.getConnection();
      // Query
      String productsQuery = " SELECT * FROM ( "+
                             " SELECT oi.line_item_id, p.product_id, " +
                             " p.product_name, p.product_description, " +
                             " oi.unit_price, oi.quantity, ROWNUM rnum " +
                             " FROM " +
                             " product_information p, order_items oi "+
                             " WHERE "+
                             " p.product_id = oi.product_id " +
                             " AND order_id = ? " +
                             " ORDER BY oi.line_item_id asc )"+
                             " WHERE rnum BETWEEN ? AND ?";
      // Prepare statement
      pstmt = conn.prepareStatement(productsQuery);
      pstmt.setInt(1,orderId); // Set the value for order_id
      pstmt.setInt(2,startIndex); // Set the starting row index
      pstmt.setInt(3,endIndex);  // Set the end row index

      // Execute the query
      rset = pstmt.executeQuery();
      OrderItems orderItems = null;
      // Loop through the Result Set  and set values in the order items objects
      while (rset.next()) {
        orderItems = new OrderItems();
        orderItems.setLineItemId(rset.getInt(1));
        orderItems.setProductId(rset.getInt(2));
        orderItems.setProductName(rset.getString(3) );
        orderItems.setProductDescription(rset.getString(4) );
        orderItems.setUnitPrice(rset.getDouble(5));
        orderItems.setQuantity(rset.getInt(6));
        ordersList.add(orderItems);
      }
      valueList.setList(ordersList);
    } catch (SQLException ex) { // Catch Sql Exceptions
      ex.printStackTrace();
      throw new Exception("SQL Error : \n" + ex.toString());
    } finally {
      try {
        // Close ResultSet, PreparedStatement and Connection
        rset.close();
        pstmt.close();
        conn.close();
      } catch (Exception ex) { // Catch Exception
        throw new Exception("SQL Error while closing objects = " +
                              ex.toString() );
      }
    }

    return valueList; // Return OrdersListHandler
  }
}