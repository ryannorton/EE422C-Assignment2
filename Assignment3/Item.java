package Assignment3;

import java.util.*;

public class Item 
{  
// static variables
   protected static float SALES_TAX_PERCENTAGE = 10;
   protected static float SHIPPING_PRICE_PER_LB = 20;
   protected static float SHIPPING_PREMIUM_PERCENTAGE = 20;
   protected static final String[] STATES_WITH_NO_SALES_TAX = {"TX", "NM", "VA", "AZ", "AK"};
   protected static final String NO_SHIPPING_STATE = "XX";
   
// instance variables
   private String name;
   private float unitPrice;
   private int quantity;
   private int weight;  // in pounds
   private String shippingState;  // 2 letter state abbreviation.

// constructors
   /**
    * Create an Item with initial parameters.
    * @param name The name of the item.
    * @param unitPrice The base price per item.
    * @param quantity The number of items.
    * @param weight The weight of a single item in pounds.
    */
   Item(String name, float unitPrice, int quantity, int weight)
   {
      this(name, unitPrice, quantity, weight, NO_SHIPPING_STATE);
   }

   /**
    * Create an Item with initial parameters.
    * @param name The name of the item.
    * @param unitPrice The base price per item.
    * @param quantity The number of items.
    * @param weight The weight of a single item in pounds.
    * @param shippingState The state to ship the item. 2-letter abbreviation.
    */
   Item(String name, float unitPrice, int quantity, int weight, String shippingState)
   {
      this.name = name;
      this.unitPrice = unitPrice;
      this.quantity = quantity;
      this.weight = weight;
      this.shippingState = shippingState;
   }
   
// public methods
   /**
    * Calculates the price of an item. Includes quantity, shipping, tax.
    * @return The calculated price.
    */
   public float calculatePrice () 
   {
      float final_price = 0;
      final_price += this.calculateSubtotal();
      final_price += this.calculateSalesTax();
      final_price += this.calculateShipping();
      return final_price;
   }
   
   // TODO
   void printItemAttributes () 
   {
      String x;
	   System.out.println("In your shopping cart, there is/are " + this.quantity + this.name + "(s) that costs $" +this.unitPrice + " each. It weighs " + this.weight +" pound(s) and is shipping to " + this.shippingState + ".");
   }
      
// getters
   /**
    * @return The item's name.
    */
   public String getName()
   {
      return this.name;
   }
   
   /**
    * @return The item's unit price.
    */
   public float getUnitPrice()
   {
      return this.unitPrice;
   }
   
   /**
    * @return The quantity of items.
    */
   public int getQuantity()
   {
      return this.quantity;
   }
   
   /**
    * @return The item's weight.
    */
   public int getWeight()
   {
      return this.weight;
   }

// setters
   /**
    * Set the item's name.
    * @param name The item's name.
    */
   public void setName(String name)
   {
      this.name = name;
   }
   
   /**
    * Set the item's unit price.
    * @param unitPrice The item's unit price.
    */
   public void setUnitPrice(float unitPrice)
   {
      this.unitPrice = unitPrice;
   }
   
   /**
    * Set the item's quantity.
    * @param quantity The item's quantity.
    */
   public void setQuantity(int quantity)
   {
      this.quantity = quantity;
   }
   
   /**
    * Set the item's weight in pounds.
    * @param weight The item's weight in pounds.
    */
   public void setWeight(int weight)
   {
      this.weight = weight;
   }
   
// private methods
   /**
    * Calculates the subtotal price. Subtotal = quantity * unit price.
    * @return The subtotal.
    */
   private float calculateSubtotal()
   {
      float subTotal = this.quantity * this.unitPrice;
      return subTotal;
   }
   
   /**
    * Calculate an item's sales tax.
    * @return The calculated sales tax.
    */
   protected float calculateSalesTax()
   {
      if (Arrays.asList(STATES_WITH_NO_SALES_TAX).contains(this.shippingState))
      {
         return 0;
      }
      float subTotal = this.calculateSubtotal();
      float salesTax = subTotal * (SALES_TAX_PERCENTAGE / 100);
      return salesTax;
   }
   
   /**
    * Calculate shipping cost.
    * @return The calculated shipping cost.
    */
   private float calculateShipping()
   {
      float shippingTotal = SHIPPING_PRICE_PER_LB * this.weight * this.quantity;
      if (this.requiresPremiumShipping())
      {
         shippingTotal += shippingTotal * (SHIPPING_PREMIUM_PERCENTAGE / 100);
      }
      return shippingTotal;
   }
   
   /**
    * Determines if an item requires premium shipping or not.
    * @return true if an item requires premium shipping else false.
    */
   protected boolean requiresPremiumShipping()
   {
      return false;
   }
}
