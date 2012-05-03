/**
 * @author                        : Shrinivas Bhat
 * @Version                       : 1.0
 *
 * Development Environment        :  Oracle JDeveloper 10g
 * Name of the File               :  ClientBean.java
 * Creation/Modification History  :
 *
 *    Shrinivas Bhat    5-Jul-2004     Created
 *
 */
package oracle.otnsamples.vlh;

/**
 * The JSPs in this application instantiates this class and retrieves the
 * orders, orderitmes or product information from the database.
 */
public class ClientBean  {
  private DBManager dbManager = null;

  /**
   * Default private constructor
   */
  public ClientBean() {
       try  {
         dbManager = new DBManager();
       } catch (Exception ex)  {
         ex.printStackTrace();
       }
  }

  /**
    * Returns product information for the given product id
    * @param productId Product Id
    * @return ProductInformation
    */
  public ProductInformation getProductInfo(int productId)  {
    ProductInformation prodInfo = null;
    try  {
      if ( dbManager == null ) {
        dbManager = new DBManager();
      }
      // Get the product information
      prodInfo = dbManager.getProductInformation( productId );
    } catch (Exception ex)  {
      ex.printStackTrace();
    }
    return prodInfo;
  }

  /**
    * Get the order items for the current page
    * @param currentIndex - Current page index
    * @param pageSize - Number of items to be displayed in the page
    * @param orderId - Order Id
    * @return - OrderListHandler
    */
   public ValueListHandler getOrderItemsPage(String strCurIndex,
                                           String strPageSize,
                                           String strOrderId)  {
     ValueListHandler listHandler = new OrdersListHandler();
     // Get the integer values
     int currentIndex = toInteger(strCurIndex);
     int pageSize = toInteger(strPageSize);
     // Set the default values if the values are less than zero
     if(currentIndex < 1 || pageSize < 1 )  {
       currentIndex = 1;
       pageSize = 5;
     }
     try  {
       if ( dbManager == null ) {
         dbManager = new DBManager();
       }
       // Return the order items value list handler
       listHandler = dbManager.getOrderItems((currentIndex-1)*pageSize + 1,
                                                  ((currentIndex) * pageSize),
                                                  toInteger(strOrderId));
     } catch (Exception ex)  {
       ex.printStackTrace();
     }
     return listHandler;
  }

  /**
   * Returns the Orders for the current page
   * @param currentIndex - Current page index
   * @param pageSize - Number of items to be displayed in the page
   * @return OrdersListHandler
   */
  public ValueListHandler getOrdersPage(String  strCurIndex, String strPageSize) {
    ValueListHandler ordersValueList = null;
    // Get the integer values
    int currentIndex = toInteger(strCurIndex);
    int pageSize = toInteger(strPageSize);
    // Set the default values if the values are less than zero
    if(currentIndex < 1 || pageSize < 1 )  {
      currentIndex = 1;
      pageSize = 10;
    }
    try  {
      if ( dbManager == null ) {
        dbManager = new DBManager();
      }
      // Get the orders for the current page
      ordersValueList = dbManager.
                                   getOrders((currentIndex-1)*pageSize + 1,
                                                 ((currentIndex) * pageSize) );
    } catch (Exception ex)  {
      ex.printStackTrace();
    }
    return ordersValueList ;
  }

  /**
   * This method converts a string into an integer value
   * @param strValue - String value
   * @return - int
   */
  public int toInteger(String strValue)  {
    return (strValue==null|| strValue.trim().length() < 1 ) ?
                                           -1: Integer.parseInt(strValue) ;
  }

  /**
   * Returns the total orders present in the database
   * @return Order size
   */
  public int getOrdersListSize()  {
    return dbManager.getAllOrdersSize();
  }

  /**
   * Returns order items size for the give order id
   * @param orderId - Order Id
   * @return - Number of Order items
   */
  public int getOrderItemsListSize(String strOrderId)  {
    return dbManager.getAllOrderItemsSize(toInteger(strOrderId));
  }
}
