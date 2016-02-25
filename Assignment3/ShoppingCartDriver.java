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
   			}
   			else if (operation.equals("search"))
   			{
   				String name = inputs[1];
   				ArrayList<Item> results = new ArrayList<Item>();
   			   for (Item i: shoppingCart)
   			   {
   			      if(i.getName().contains(name))
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
   			}
   			else if (operation.equals("update"))
   			{
   				String name = inputs[1];
   			}
   			if (operation.equals("print"))
   			{
   				String name = inputs[1];
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
      //Parse input, take appropriate actions.
      
      //Stub for arraylist.
      ArrayList<Item> shoppingCart = new ArrayList<Item>(); 
      
      // General code example for how to iterate an array list. You will have to modify this heavily, to suit your needs.
      Iterator<Item> i = shoppingCart.iterator();
      while (i.hasNext()) 
      {
         Item temp = i.next();
         temp.calculatePrice(); 
         temp.printItemAttributes();
         //This (above) works because of polymorphism: a determination is made at runtime, 
         //based on the inherited class type, as to which method is to be invoked. Eg: If it is an instance
         // of Grocery, it will invoke the calculatePrice () method defined in Grocery.
      }
      
      // sort shopping cart by item name
      Collections.sort(shoppingCart, new Comparator<Item>() {
         @Override
         public int compare(Item i1, Item i2) {
             return i1.getName().compareToIgnoreCase(i2.getName());
         }
     });
   }
}
