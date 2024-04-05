/**
 * Name(s): James Maner and Chase Harris
 * CPSC 1061: Lab 10: 
 * Section 003
 * 3/30/2023
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Ordering {
    // // Validates ice cream name
    // public static boolean validateIceCream(String name) {
    //     return name.equalsIgnoreCase("Vanilla") || 
    //         name.equalsIgnoreCase("Chocolate") || 
    //         name.equalsIgnoreCase("Strawberry");
    // }

    // Validates topping name
    // public static boolean validateToppingName(String name) {
    //     return name.equalsIgnoreCase("Sprinkles") || 
    //         name.equalsIgnoreCase("GummyBears") || 
    //         name.equalsIgnoreCase("Oreos") || 
    //         name.equalsIgnoreCase("Done");
    // }

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        Receipt rec = new Receipt();
        
        // Welcome user, ask for name, set name in Receipt
        System.out.println("Welcome to Adkins' Scoop City!");
        System.out.println("What is your name?");
        String name = scnr.next();
        rec.setName(name);
        
        // Initialize done check var
        boolean done = false;
        
        // Order ice cream until user is done
        while (!done) {

            // Create basic ice cream object
            IceCream iceCream = new IceCream();

            // Get ice cream name
            System.out.println("What Flavor of ice cream would you like to order?");
            System.out.println("Your options are: Vanilla, Strawberry, Chocolate.");
            String iceCreamFlavor = scnr.next();
            
            // Validate ice cream Flavor
            while(!iceCream.validateFlavor(iceCreamFlavor)) {
                System.out.println("Please put in a valid ice cream flavor.");
                iceCreamFlavor = scnr.next();
            }
            
            //Set the ice cream object's Flavor
            iceCream.setFlavor(iceCreamFlavor);


            // Ask if user wants ice cream deluxe, defaults to false
            boolean deluxe = false;
            System.out.println("Would you like the deluxe brand? (Yes/No)");
            String deluxeString = scnr.next();
            while(!(deluxeString.equalsIgnoreCase("Yes") || deluxeString.equalsIgnoreCase("No"))) {
                System.out.println("Please input Yes or No!");
                deluxeString = scnr.next(); 
            }
            if (deluxeString.equalsIgnoreCase("Yes")) {
                deluxe = true;
            }

            // Set the ice cream object's deluxe-ness
            iceCream.setDeluxeBrand(deluxe);


            // Ask for number of scoops
            System.out.println("How many scoops would you like to order?");
            int numScoops = Integer.parseInt(scnr.next());
            
            // Validate more than 0 scoops
            while (numScoops < 0) {
                System.out.println("Please enter a number greater than 0");
                numScoops = Integer.parseInt(scnr.next());
            }

            // Set ice cream object's number of scoops
            iceCream.setNumScoops(numScoops);

            // Process Toppings
            System.out.println("Which toppings would you like? Type done if you do not want any."); 
            System.out.println("Your options are: Sprinkles, GummyBears, Oreos.");
            
            // Create arraylist to store toppings
            ArrayList<Topping> topTemp = new ArrayList<Topping>();

            // Initialize with blank topping name
            String toppingType = "";
            
            // Ask for user toppings until "Done" is given
            while (!toppingType.equalsIgnoreCase("Done")) {

                // Create new topping object
                Topping topping = new Topping();
                
                // Get topping
                toppingType = scnr.next();

                // Validate topping
                while(!(topping.validateTopping(toppingType))) {
                    System.out.println("Please put in a valid topping type.");
                    toppingType = scnr.next();
                }

                if (!toppingType.equalsIgnoreCase("Done")) {
                    // Once you have valid topping type, set topping object's type
                    topping.setType(toppingType);
                    
                    // Add topping to array if valid
                    topTemp.add(topping);
                    
                    // Print Topping Info
                    System.out.printf("Topping %s added for %.2f.\n", topping.getType(), topping.getCost());
                    System.out.println("Type Done if you are done selecting toppings, or enter another topping.");
                }
            }

            // Set ice cream object's toppings
            iceCream.setToppings(topTemp);

            // Add ice cream object to receipt
            rec.add(iceCream);

            // Print the user's order so far:
            System.out.println("Your order so far:");
            rec.printReceipt();

            // Prompt user to keep ordering or quit
            System.out.println("Would you like to order another ice cream? (Yes/No)");
            String anotherOne = scnr.next();

            // Validate user input
            while(!(anotherOne.equalsIgnoreCase("Yes") || anotherOne.equalsIgnoreCase("No"))) {
                System.out.println("Please input Yes or No!");
                anotherOne = scnr.next(); 
            }
            // Set done to true and break out of loop if user is done
            if (anotherOne.equalsIgnoreCase("No")) {
                done = true;
            }
        }

        // After order is complete, print receipt and close Scanner
        rec.printReceipt();
        scnr.close();
    }  

    
}
