/**
 * @author                        : Shrinivas Bhat
 * @Version                       : 1.0
 *
 * Development Environment        :  Oracle JDeveloper 10g
 * Name of the File               :  OrdersListHandler.java
 * Creation/Modification History  :
 *
 *    Shrinivas Bhat    5-Jul-2004     Created
 *
 */
package oracle.otnsamples.vlh;

// Import List class
import java.util.List;

/**
 * This class holds the list of orders. The presentation layer uses the
 * methods from this class to display the Order information.
 * This class implements the ValueListHandler interface, which provides the
 * necessary methods to iterate through the list.
 */
public class OrdersListHandler implements ValueListHandler {

  private List ordersList = null;
  private int listIndex = -1;
  private int allRecordsSize = -1;

  /**
   * Sets the Orders list
   * @param list - Order List
   */
  public void setList(List list)  {
    ordersList = list;
  }

  /**
   * Returns the size of the list
   * @return - Size
   */
  public int getSize()  {
    return ordersList.size();
  }

  /**
   * Returns true if there are more elements in the list
   * @return - true/false
   */
  public boolean hasNext()  {
    return  ( (listIndex+1) <  ordersList.size() && ordersList.size() > 0 )  ;
  }

  /**
   * Returns the next element in the list
   * @return Next element
   */
  public Object nextElement()  {
    return ordersList.get(++listIndex) ;
  }

  /**
   * Returns the current element in the list
   * @return Current element
   */
  public Object getCurrentElement()  {
    if ( listIndex < 0 || ordersList.size() < 1 )  {
      return null;
    }
    return ordersList.get(listIndex) ;
  }

  /**
   * Resets the index
   */
  public void resetIndex()  {
    listIndex = -1;
  }
}