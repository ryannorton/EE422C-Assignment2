package Assignment3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ShoppingCartDriver 
{
   private static ArrayList<Item> shoppingCart = new ArrayList<Item>();

   public static void main(String[] args) 
   {
 	  
      //Open file; file name specified in args (command line)
    	try 
   	{
    	   FileReader freader = new FileReader(args[0]);
   		BufferedReader reader = new BufferedReader(freader);
   		
   		for (String s = reader.readLine(); s != null; s = reader.readLine()) 
   		{
   			String newString = s;
   			String[] inputs = s.split("\\s+");
   			String operation = inputs[0];
   			
   			System.out.println(s);
   			
   			if (operation.equals("insert"))
   			{
   				String category = inputs[1];
     				String name = inputs[2];
     				float price = Float.parseFloat(inputs[3]);
     				int quantity = Integer.parseInt(inputs[4]);
     				int weight = Integer.parseInt(inputs[5]);

     				if (category.equals("electronics"))
     				{
     					boolean fragile;
     					if (inputs[6].equals("F"))
     					{
     					   fragile = true;
     					}
     					else
     					{
     					   fragile = false;
     					}
     					String state = inputs[7];
     					Electronics electronic = new Electronics(name, price, quantity, weight, fragile, state);
     					shoppingCart.add(electronic);
     				}
     				if (category.equals("groceries"))
     				{
     					String perishable = inputs[6];
     					boolean isPerishable = false;
     					if (perishable.equals("P")) isPerishable = true;
  						Grocery groc = new Grocery(name, price, quantity, weight, isPerishable);
  						shoppingCart.add(groc);
     				}
     				if (category.equals("clothing"))
     				{
     					Clothing cloth = new Clothing(name, price, quantity, weight);
     					shoppingCart.add(cloth);
     				}
     				sortShoppingCart();
   			}
   			else if (operation.equals("search"))
   			{
   				String name = inputs[1];
   				ArrayList<Item> results = new ArrayList<Item>();
   			   for (Item i: shoppingCart)
   			   {
   			      if(i.getName().equals(name))
   			      {
   			         results.add(i);
   			      }
   			   }
   			   int numResults = results.size();
   			   System.out.println("Found " + numResults + " items with name " + name);
   			}
   			else if (operation.equals("delete"))
   			{
   				String name = inputs[1];
   				Iterator<Item> i = shoppingCart.iterator();
   				int numDeleted = 0;
               while (i.hasNext()) 
               {
                  if (i.next().getName().equals(name))
                  {
                     i.remove();
                     numDeleted++;
                  }
               }
               System.out.println(numDeleted + " items deleted.");
   			}
   			else if (operation.equals("update"))
   			{
   				String name = inputs[1];
   				int quantity = Integer.parseInt(inputs[2]);
   				for (Item i: shoppingCart)
               {
   				   if(i.getName().equals(name))
                  {
                     i.setQuantity(quantity);
                     i.printItemAttributes();
                     return;
                  }
               }
   			}
   			else if (operation.equals("print"))
   			{
   			   float totalCost = 0;
   			   for (Item i: shoppingCart)
               {
                  i.printItemAttributes();
                  totalCost += i.calculatePrice();
               }
   			   System.out.println("The total cost of all items is: $" + String.format("%.2f", totalCost));
   			}
   		}
   	}
   	catch (FileNotFoundException e) 
   	{
   		System.err.println ("Error: File not found. Exiting...");
   		e.printStackTrace();
   		System.exit(-1);
   	} catch (IOException e) 
   	{
   		System.err.println ("Error: IO exception. Exiting...");
   		e.printStackTrace();
   		System.exit(-1);
   	}
   }
   
   private static void sortShoppingCart()
   {
      Collections.sort(shoppingCart, new Comparator<Item>() {
         @Override
         public int compare(Item i1, Item i2) {
             return i1.getName().compareToIgnoreCase(i2.getName());
         }
      });
   }
}
