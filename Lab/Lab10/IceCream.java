/**
 * Name(s): James Maner and Chase Harris
 * CPSC 1061: Lab 10: 
 * Section 003
 * 3/30/2023
 */
import java.util.ArrayList;

public class IceCream {
    //Declare all relevant private fields
    private String flavor;
    private int numScoops;
    private double pricePerScoop = 0;
    private double totalCost = 0;
    private boolean isDeluxeBrand;
    private ArrayList<Topping> toppings;

    /*
        @param flavor - the listed flavor of the ice cream
        @return boolean - returns a boolean according to if the flavor is valid or not
    */
    //Validates the name of a flavor compared to the options listed
    public boolean validateFlavor(String flavor) {
        return flavor.equalsIgnoreCase("Vanilla") || 
            flavor.equalsIgnoreCase("Chocolate") || 
            flavor.equalsIgnoreCase("Strawberry");
    }

    /*
        @param flavor - the new listed flavor of the ice cream
        @return void - returns nothing
    */
    //Sets the flavor of this ice cream object
    public void setFlavor(String flavor)
    {
        this.flavor = flavor;
    }

    //Gets the flavor of this ice cream object
    public String getFlavor()
    {
        return this.flavor;
    }

    /*
        @param isDeluxeBrand - the listed flavor of the ice cream
        @return void - returns nothing
    */
    //Sets the ice cream object to a deluxe brand
    public void setDeluxeBrand(boolean isDeluxeBrand)
    {
        this.isDeluxeBrand = isDeluxeBrand;
    }

    //Gets the string representing the boolean isDeluxeBrand
    public String getDeluxeBrand()
    {
        if (isDeluxeBrand)
        {
            return "true";
        }
        else 
        {
            return "false";
        }
    }

    /*
        @param numScoops - the number of scoops of this ice cream
        @return void - returns nothing
    */
    //Sets the number of scoops of this ice cream
    public void setNumScoops(int numScoops)
    {
        this.numScoops = numScoops;
    }

    //Returns the number of scoops of this ice cream
    public int getNumScoops()
    {
        return numScoops;
    }

    /*
        @param toppings - the arraylist of all the toppings on this ice cream object
        @return void - returns nothing
    */
    //Sets the toppings that are associated with this ice cream object
    public void setToppings(ArrayList<Topping> toppings)
    {
        this.toppings = toppings;
    }

    //Returns all of the toppings on this ice cream object
    public String getToppings()
    {
        String toppingString = "";
        if (toppings.size() == 0)
        {
            return "NONE";
        }
        else
        {
            for (Topping top: toppings)
            {
                toppingString += top.getType();
                toppingString += " ";
            }
        }

        return toppingString;
    }

    //Calculate the cost and return it to the call
    public double getCost()
    {
        totalCost = 0;
        pricePerScoop = 0;
        if (flavor.equalsIgnoreCase("Vanilla"))
        {
            pricePerScoop += 1.05;
        }
        else if (flavor.equalsIgnoreCase("Chocolate"))
        {
            pricePerScoop += 1.12;
        }
        else if (flavor.equalsIgnoreCase("Strawberry"))
        {
            pricePerScoop += 1.32;
        }

        if (isDeluxeBrand)
        {
            pricePerScoop *= 1.42;
        }

        totalCost = pricePerScoop * numScoops;

        for (Topping top: toppings)
        {
            totalCost += top.getCost();
        }

        return totalCost;
    }
}
