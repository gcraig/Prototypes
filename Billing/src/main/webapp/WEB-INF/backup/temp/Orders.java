/**
 * @author  Shrinivas Bhat
 * @version 1.0
 *
 * Development Environment        :  Oracle JDeveloper 10g
 * Name of the Application        :  Orders.java
 * Creation/Modification History  :
 *
 *    Shrinivas      05-Jul-2004      Created
 */
package oracle.otnsamples.vlh;

/**
 * This class is used as value object to hold the information related 
 * to orders.
 */
public class Orders {

    private int productId;
    private int orderId;
    private String customerName;
    private String orderDate;
    private double unitPrice;
    private String orderMode;
    private String orderStatus;

    /**
     * Returns customer name.
     * @return customerName
     */
    public String getCustomerName() {
        return this.customerName;
    }

    /**
     * Returns order date.
     * @return orderDate
     */
    public String getOrderDate() {
        return this.orderDate;
    }

    /**
     * Returns order id.
     * @return orderId
     */
    public int getOrderId() {
        return this.orderId;
    }

    /**
     * Returns the status of the order.
     * @return orderStatus
     */
    public String getOrderStatus() {
        return this.orderStatus;
    }

    /**
     * Returns order quantity.
     * @return orderQty
     */
    public String getOrderMode() {
        return this.orderMode;
    }
   /**
    * Returns unit price of an item.
    * @return unitPrice
    */
    public double getUnitPrice() {
        return this.unitPrice;
    }

    /**
     * Sets the value for customer name.
     * @param customerName
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * Sets the order date.
     * @param orderDate
     */
    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    /**
     * Sets the order id.
     * @param orderId
     */
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    /**
     * Sets the order status.
     * @param orderStatus
     */
    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
    
    /**
     * Sets the order quantity.
     * @param orderQty
     */
    public void setOrderMode(String orderMode) {
        this.orderMode = orderMode;
    }    
    /**
     * Sets the unit price.
     * @param unitPrice
     */
    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }
    
}
