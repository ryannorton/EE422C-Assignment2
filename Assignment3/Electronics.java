/**
 Class to represent Electronics
 @author Ryan Norton
 @author Atreya Misra
 @version 1.0 2016-02-22
*/ 


package Assignment3;

public class Electronics extends Item 
{
// instance variables
   private boolean isFragile;  // fragile items require premium shipping

// constructors
   /**
    * Create an Electronics item with initial parameters.
    * @param name The name of the item.
    * @param unitPrice The base price per item.
    * @param quantity The number of items.
    * @param weight The weight of a single item in pounds.
    * @param isFragile If the item is fragile or not.
    * @param shippingState The state to ship the item to.
    */
   Electronics(String name, float unitPrice, int quantity, int weight, boolean isFragile, String shippingState)
   {
      super(name, unitPrice, quantity, weight, shippingState);
      this.isFragile = isFragile;
   }
   
// override methods
   /**
    * Determines if an item requires premium shipping or not.
    * Fragile electronics require premium shipping.
    * @return true if an item requires premium shipping else false.
    */
   @Override
   protected boolean requiresPremiumShipping()
   {
      return this.isFragile;
   }
}
