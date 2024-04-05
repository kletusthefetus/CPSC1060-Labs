/**
 * Name(s): James Maner and Chase Harris
 * CPSC 1061: Lab 12
 * Section 003
 * 4/11/2023
 */
import java.util.ArrayList;

public class Room
{
    //Delcare all needed variables
    String name;
    String description;
    ArrayList<String> exits;
    
    /**
     * Initialize a room
     * @param name the name of the room
     * @param description the description of the room
     */
    public Room(String name, String description)
    {
        exits = new ArrayList<>();
        this.name = name;
        this.description = description;
    }
    /* Generate getters and setters for the naems and descriptions */
    
    /**
     * Adds an exit to the room
     * @param exit room name of the exit to be added to the room
     */
    public void addExit(String exit)
    {
        this.exits.add(exit);
    }

    /**
     * Checks if the exit string matches an exit for the room
     * @param exit room name of the exit to be checked
     * @return returns true if the exit name is valid
     */
    public boolean validExit(String exit)
    {
        boolean valid = false;
        for (String str: exits)
        {
            if (exit.equals(str))
            {
                valid = true;
            }
        }
        return valid;
    }

    /**
     * List all of the rooms as a string
     * @return returns all of the names of the rooms on new lines
     */
    public String listExits()
    {
        String exitStr = "";
        for (int i = 0; i < this.exits.size(); i++)
        {
            exitStr += (exits.get(i)  + "\n");
        }
        return exitStr;
    }

    /**
     * Returns the name of the room
     */
    public String getName()
    {
        return this.name;
    }

    /**
     * Generates a string representation of the room using the name and description and lists all of the exits.
     */
    public String toString()
    {
        String str = "";
        str += this.name + ": ";
        str += this.description + "\n\n";
        str += "Exits:\n";
        str += this.listExits();

        return str;
    }
}
