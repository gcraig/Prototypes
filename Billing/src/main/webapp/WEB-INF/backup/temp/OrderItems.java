/**
 * @author                        : Shrinivas Bhat
 * @Version                       : 1.0
 *
 * Development Environment        :  Oracle JDeveloper 10g
 * Name of the File               :  OrderItems.java
 * Creation/Modification History  :
 *
 *    Shrinivas Bhat    5-Jul-2004     Created
 *
 */
package oracle.otnsamples.vlh;

/**
 * This class is used as a value object to hold the data from the ORDER_ITMES
 * table.
 */
public class OrderItems {

  private int orderId;
  private int lineItemId;
  private int productId;
  private double unitPrice;
  private int quantity;
  private String productDescription;
  private String productName;

  /**
   * Returns the line item id
   * @return LineItem_ID
   */
  public int getLineItemId() {
    return this.lineItemId;
  }
  /**
   * Returns order id
   * @return order_id
   */
  public int getOrderId() {
    return this.orderId;
  }
  /**
   * Returns product id
   * @return procut_id
   */
  public int getProductId() {
    return this.productId;
  }
  /**
   * Returns the order quantity
   * @return quantity
   */
  public int getQuantity() {
    return this.quantity;
  }
  /**
   * Returns the unit price of the product
   * @return unit_price
   */
  public double getUnitPrice() {
    return this.unitPrice;
  }

  /**
   * Returns product name.
   * @return product_name
   */
  public String getProductName() {
    return this.productName;
  }

  /**
   * Returns the product description.
   * @return product_description
   */
  public String getProductDescription() {
    return this.productDescription;
  }

  /**
   * Sets the value for product id
   * @param product_id
   */
  public void setProductId(int productId) {
    this.productId = productId;
  }

  /**
   * Sets the value for product description
   * @param product_description
   */
  public void setProductDescription(String productDescription) {
    this.productDescription = productDescription;
  }

  /**
   * Sets the value for product name
   * @param productName
   */
  public void setProductName(String productName) {
    this.productName = productName;
  }

  /**
   * Sets the line item id
   * @param lineItemId
   */
  public void setLineItemId(int lineItemId) {
    this.lineItemId = lineItemId;
  }

  /**
   * Sets the order id
   * @param orderId
   */
  public void setOrderId(int orderId) {
    this.orderId = orderId;
  }

  /**
   * Sets the order quantity
   * @param quantity
   */
  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  /**
   * Sets the unit price
   * @param unitPrice
   */
  public void setUnitPrice(double unitPrice) {
    this.unitPrice = unitPrice;
  }

}
