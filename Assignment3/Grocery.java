package Assignment3;

public class Grocery extends Item {
// instance variables
   private boolean isPerishable;  // perishable items require premium shipping
   
//constructors
   /**
    * Create a Grocery item with initial parameters.
    * @param name The name of the item.
    * @param unitPrice The base price per item.
    * @param quantity The number of items.
    * @param weight The weight of a single item in pounds.
    * @param isPerishable Whether or not the item is perishable.
    */
   Grocery(String name, float unitPrice, int quantity, int weight, boolean isPerishable)
   {
      super(name, unitPrice, quantity, weight);
      this.isPerishable = isPerishable;
   }

// getters
   /**
    * @return The item's isPerishable attribute.
    */
   public boolean getIsPerishable()
   {
      return this.isPerishable;
   }
   
// setters
   /**
    * Set the item's isPerishable attribute.
    * @param isPerishable Whether or not the item is perishable.
    */
   public void setIsPerishable(boolean isPerishable)
   {
      this.isPerishable = isPerishable;
   }
   
// override methods
   /**
    * Override method to calculate sales tax.
    * Groceries have no sales tax.
    * @return The calculated sales tax. 0 for groceries.
    */
   @Override
   protected float calculateSalesTax()
   {
      return 0;
   }
   
   /**
    * Determines if an item requires premium shipping or not.
    * Perishable groceries require premium shipping.
    * @return true if an item requires premium shipping else false.
    */
   @Override
   protected boolean requiresPremiumShipping()
   {
      return this.isPerishable;
   }
   
}
