package Assignment3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ShoppingCartDriver 
   {
      public static void main(String[] args) 
      {
    	  
      // TODO Auto-generated method stub
      
      //Open file; file name specified in args (command line)
    	  try 
  		{
    		  FileReader freader = new FileReader(args[0]);
  			BufferedReader reader = new BufferedReader(freader);
  			
  			for (String s = reader.readLine(); s != null; s = reader.readLine()) 
  			{
  				String newString = s;
  				String[] inputs = s.split(" ");
  				String operation = inputs[0];
  				
  				if(operation == "insert"){
  					ArrayList<Item> shoppingCart = new ArrayList<Item>();
  					String category = inputs[1];
  	  				String name = inputs[2];
  	  				float price = Float.parseFloat(inputs[3]);
  	  				int quantity = Integer.parseInt(inputs[4]);
  	  				int weight = Integer.parseInt(inputs[5]);
  	  				if(category == "electronics"){
  	  					String fragile = inputs[6];
  	  					String state = inputs[7];
  	  					Electronics electronic = new Electronics(name, price, quantity, weight);
  	  					shoppingCart.add(electronic);
  	  				}
  	  				if(category == "groceries"){
	  					String perishable = inputs[6];
	  					if(perishable == "P"){
	  						Grocery groc = new Grocery(name, price, quantity, weight, true);
	  						shoppingCart.add(groc);
	  					}
	  					if(perishable == "NP"){
	  						Grocery groc = new Grocery(name, price, quantity, weight, false);
	  						shoppingCart.add(groc);
	  					}
	  					
	  				}
  	  				if(category == "clothing"){
	  					String fragile = inputs[6];
	  					String state = inputs[7];
	  					Clothing cloth = new Clothing(name, price, quantity, weight);
	  					shoppingCart.add(cloth);
	  				}
  	  			
  	  				
  				}
  				if(operation == "search"){
  					String name = inputs[1];
  				}
  				if(operation == "delete"){
  					String name = inputs[1];
  				}
  				if(operation == "update"){
  					String name = inputs[1];
  				}
  				if(operation == "print"){
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
   }
}
