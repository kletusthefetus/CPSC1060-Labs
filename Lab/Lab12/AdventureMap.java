/**
 * Name(s): James Maner and Chase Harris
 * CPSC 1061: Lab 12
 * Section 003
 * 4/11/2023
 */
import java.util.HashMap;

public class AdventureMap
{
    //Declare needed variables
    HashMap<String, Room> map;

    /**
     * Constructor for the adventure map
     */
    public AdventureMap()
    {
        map = new HashMap<>();
    }

    /**
     * returns true if the name in question is also the name of a room
     * @param check name of the room to be checked
     * @return boolean return true or false depending on the valid boolean
     */
    public boolean validName(String check)
    {
        boolean valid = false;

        if (map.containsKey(check))
        {
            valid = true;
        }

        return valid;
    }

    /**
     * Adds a room to the AdventureMap
     * The name associated in the room must be lowercase
     * @param room Room to be added to the AdventureMap
     */
    public void addRoom(Room room)
    {
        map.put(room.getName(), room);
    }

    /**
     * Returns the Room assocaited with the string name given
     * @param roomName the name of the room to be returned, room name must be valid
     * @return the Room object assocaited with the name, the name will be in lowercase
     */
    public Room getRoom(String roomName)
    {
        return map.get(roomName);
    }
}
