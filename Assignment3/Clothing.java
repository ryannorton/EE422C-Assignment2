/**
 Class to represent Clothing
 @author Ryan Norton
 @author Atreya Misra
 @version 1.0 2016-02-22
*/ 

package Assignment3;

public class Clothing extends Item 
{
// constructors
   /**
    * Create a Clothin item with initial parameters.
    * @param name The name of the item.
    * @param unitPrice The base price per item.
    * @param quantity The number of items.
    * @param weight The weight of a single item in pounds.
    */
   Clothing(String name, float unitPrice, int quantity, int weight)
   {
      super(name, unitPrice, quantity, weight);
   }
}
