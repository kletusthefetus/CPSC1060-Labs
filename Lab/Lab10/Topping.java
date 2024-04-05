/**
 * Name(s): James Maner and Chase Harris
 * CPSC 1061: Lab 10: 
 * Section 003
 * 3/30/2023
 */
public class Topping {
    //Declare all relevant private fields
    private String type;
    private double cost = 0;

    /*
        @param type - the type of topping being validated
        @return boolean - returns true if the name of the topping type matches a topping option
    */
    //validates the topping in question as an option
    public boolean validateTopping(String type) {
        return type.equalsIgnoreCase("Sprinkles") || 
            type.equalsIgnoreCase("GummyBears") || 
            type.equalsIgnoreCase("Oreos") || 
            type.equalsIgnoreCase("Done");
    }

    /*
        @param type - the type of topping this object is being set to
        @return void - returns nothing
    */
    //Sets the topping object to the type listed
    public void setType(String type)
    {
        this.type = type;
    }

    //Returns the type of the topping object
    public String getType()
    {
        return type;
    }

    //Calculates and returns the cost of the topping 
    public double getCost()
    {
        cost = 0;
        if (type.equalsIgnoreCase("Sprinkles"))
        {
            cost += 0.15;
        }
        else if (type.equalsIgnoreCase("GummyBears"))
        {
            cost += 0.45;
        }
        else if (type.equalsIgnoreCase("Oreos"))
        {
            cost += 0.38;
        }
        
        return cost;
    }

}
