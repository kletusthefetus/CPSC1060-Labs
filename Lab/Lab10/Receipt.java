/**
 * Name(s): James Maner and Chase Harris
 * CPSC 1061: Lab 10: 
 * Section 003
 * 3/30/2023
 */
import java.util.ArrayList;

public class Receipt {
    //Initialize needed private fields
    private String name;
    private ArrayList<IceCream> iceCreams;

    //Constructor function which initializes the arraylist of ice creams
    public Receipt() {
        iceCreams = new ArrayList<IceCream>();
    }

    /*
        @param name - the name of the customer
        @return void - returns nothing
    */
    //Sets the name of the customer onto the receipt
    public void setName(String name)
    {
        this.name = name;
    }

    //Returns the name of the customer
    public String getName()
    {
        return this.name;
    }

    /*
        @param ic - the ice cream object being added to the receipt
        @return void - returns nothing
    */
    //Adds an icecream object to the receipt's arraylist
    public void add(IceCream ic)
    {
        iceCreams.add(ic);
    }

    //Prints all the information in the receipt object
    public void printReceipt()
    {
        double finalTotal = 0;
        System.out.println("Adkins' Scoop City Receipt");
        System.out.println("Customer Name: " + name + "\n");

        for (IceCream ic: iceCreams)
        {
            System.out.println("Flavor: " + ic.getFlavor());
            System.out.println("Scoops: " + ic.getNumScoops());
            System.out.println("Deluxe: " + ic.getDeluxeBrand());
            System.out.println("Toppings: " + ic.getToppings());
            System.out.printf("Total: $%.2f\n", ic.getCost());
            System.out.println();
            finalTotal += ic.getCost();
        }
        
        System.out.printf("Final Total: $%.2f\n", finalTotal);
        
    }


    
}
