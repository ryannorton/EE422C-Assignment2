package Assignment3;

public class Electronics extends Item 
{
// constructors
   /**
    * Create an Electronics item with initial parameters.
    * @param name The name of the item.
    * @param unitPrice The base price per item.
    * @param quantity The number of items.
    * @param weight The weight of a single item in pounds.
    */
   Electronics(String name, float unitPrice, int quantity, int weight)
   {
      super(name, unitPrice, quantity, weight);
   }
}
