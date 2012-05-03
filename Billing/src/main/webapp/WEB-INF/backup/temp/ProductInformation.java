/**
 * @author  Shrinivas Bhat
 * @version 1.0
 *
 * Development Environment        :  Oracle JDeveloper 10g
 * Name of the Application        :  ProductInformation.java
 * Creation/Modification History  :
 *
 *    Shrinivas      05-Jul-2004      Created
 */
package oracle.otnsamples.vlh;

/**
 * This class is used as a value object to hold the information of the
 * available products.
 */
public class ProductInformation {

  private String productId;
  private String productName;
  private String productDescription;
  private String categoryId;
  private String categoryName;
  private String listPrice;
  private double minPrice;
  private String orderQuantiy;
  private String productStatus;

  /**
   * Return  product status
   * @return product_status
   */
  public String getProductStatus()  {
    return productStatus;
  }

  /**
   * Return the order quantity
   * @return
   */
  public String getOrderQuantity()  {
    return this.orderQuantiy;
  }

  /**
   * Set the product status
   * @param value
   */
  public void setProductStatus(String value)  {
    productStatus = value;
  }

  /**
   * Set the order quantity
   * @param value
   */
  public void setOrderQuantity(String value)  {
    this.orderQuantiy = value;
  }

  /**
   * Return the unit price
   * @return
   */
  public double getMinimumPrice()  {
    return this.minPrice;
  }

  /**
   * Sets the order item unit price
   * @param value
   */
  public void setMinimumPrice(double value)  {
    this.minPrice = value;
  }

  /**
   * Returns the category id.
   * @return categoryId
   */
  public String getCategoryId() {
    return this.categoryId;
  }

    /**
     * Returns the list price.
     * @return listPrice
     */
  public String getListPrice() {
    return this.listPrice;
  }

    /**
     * Returns the product description.
     * @return productDescription
     */
  public String getProductDescription() {
    return this.productDescription;
  }

    /**
     * Returns the product id.
     * @return productId
     */
  public String getProductId() {
    return this.productId;
  }

    /**
     * Returns product name.
     * @return productName
     */
  public String getProductName() {
    return this.productName;
  }

    /**
     * Return category name.
     * @return categoryName
     */
  public String getCategoryName() {
    return this.categoryName;
  }


    /**
     * Sets the value for category id.
     * @param categoryId
     */
  public void setCategoryId(String categoryId) {
    this.categoryId = categoryId;
  }

    /**
     * Sets the value for list price.
     * @param listPrice
     */
  public void setListPrice(String listPrice) {
    this.listPrice = listPrice;
  }

    /**
     * Sets the value for product description
     * @param productDescription
     */
  public void setProductDescription(String productDescription) {
    this.productDescription = productDescription;
  }

    /**
     * Sets the value for product id
     * @param productId
     */
  public void setProductId(String productId) {
    this.productId = productId;
  }

    /**
     * Sets the value for product name
     * @param productName
     */
  public void setProductName(String productName) {
    this.productName = productName;
  }

    /**
     * Sets the value for category name.
     * @param categoryName
     */
  public void setCategoryName(String categoryName) {
    this.categoryName = categoryName;
  }

}
