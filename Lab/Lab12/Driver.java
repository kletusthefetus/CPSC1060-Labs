/**
 * Name(s): James Maner and Chase Harris
 * CPSC 1061: Lab 12
 * Section 003
 * 4/11/2023
 */
import java.util.HashMap;
import java.util.Scanner;

public class Driver
{
    public static void main(String[] args)
    {
        //Delcare all needed variables
        Room guest = new Room("Guest Room", "A room filled with numerous torture devices. Who said anything about welcome guests?");
        Room library = new Room("Library", "Better version of the study. It has all of the different books that one may want. Make sure that you stay quiet or the mean librarian will slap you!");
        Room kitchen = new Room("Kitchen", "This amazing culinary art studio has it all: cheese cellar, wine racks, and a 16 stove burner. With its pizza oven, it makes for the perfect Italian getaway.");
        Room study = new Room("Study", "Do you love being disturbed while working? This room has it all. It is the central hub to the whole house. It has a giant wall of computers and amazing lighting, but doors that exit out into numerous different rooms.");
        Room holo = new Room("Holodeck", "A room that can disguise itself in a variety of ways. Experience a lush, humid rainforest, a speakeasy of the 1920’s, or the dungeons of Cooper Library.");
        Room trophy = new Room("Trophy Room", "Spacious room with oak wood as far as the eye can see, shelves filled to the brim with trophies and obscure collections, it really makes you wonder who they belong to.");
        Room bed = new Room("Bedroom", "A lavished bed adorns the center of this room, with long curtains, beautiful rugs, and gilded furniture acting as little details to truly make this a great bedroom.");
        AdventureMap adMap = new AdventureMap();
        Scanner scnr = new Scanner(System.in);
        String playerSelection;
        String currRoom;
        System.out.println("\nWelcome to the Adkins house! Entering the study room. To leave the house, please type exit to jump out of the nearest window.\n");

        /*
         * Guest Room: A room filled with numerous torture devices. Who said anything about welcome guests? :: Kitchen
         * Library: Better version of the study. It has all of the different books that one may want. Make sure that you stay quiet or the mean librarian will slap you! :: Holodeck, Trophy Room, Study
         * Kitchen: This amazing culinary art studio has it all: cheese cellar, wine racks, and a 16 stove burner. With its pizza oven, it makes for the perfect Italian getaway. :: Study, Guest Room
         * Study: Do you love being disturbed while working? This room has it all. It is the central hub to the whole house. It has a giant wall of computers and amazing lighting, but doors that exit out into numerous different rooms. :: Kitchen, Library, Bedroom
         * Holodeck: A room that can disguise itself in a variety of ways. Experience a lush, humid rainforest, a speakeasy of the 1920’s, or the dungeons of Cooper Library. :: Library
         * Trophy Room: Spacious room with oak wood as far as the eye can see, shelves filled to the brim with trophies and obscure collections, it really makes you wonder who they belong to. :: Bedroom, Library
         * Bedroom: A lavished bed adorns the center of this room, with long curtains, beautiful rugs, and gilded furniture acting as little details to truly make this a great bedroom. :: Study, Trophy Room
         */
        
        //Populare the rooms with their assigned exits
        guest.addExit("Kitchen");
        library.addExit("Holodeck");
        library.addExit("Trophy Room");
        library.addExit("Study");
        kitchen.addExit("Study");
        kitchen.addExit("Guest Room");
        study.addExit("Kitchen");
        study.addExit("Library");
        study.addExit("Bedroom");
        holo.addExit("Library");
        trophy.addExit("Bedroom");
        trophy.addExit("Library");
        bed.addExit("Study");
        bed.addExit("Trophy Room");

        //Populate the map with the rooms
        adMap.addRoom(guest);
        adMap.addRoom(library);
        adMap.addRoom(kitchen);
        adMap.addRoom(study);
        adMap.addRoom(holo);
        adMap.addRoom(trophy);
        adMap.addRoom(bed);

        /*
         * Create a scanner, put the inital room (entrance) to study
         * While the user's input is not exit, continue to traverse the map. 
         * If there is an invalid selection, then print out "Invalid exit."
         * After you are done selecting, print out "Please choose an exit" and get next exit
         */

        //Assign the study as the starting room, prompt the user for the input of the next exit
        System.out.println(study);
        System.out.println("Please choose an exit");
        playerSelection = scnr.nextLine();
        System.out.println();
        currRoom = "Study";

        //Loop until the user decides to exit
        while (!playerSelection.equalsIgnoreCase("Exit"))
        {
            //If the input exit is a valid exit for the current room
            if (adMap.getRoom(currRoom).validExit(playerSelection))
            {
                currRoom = playerSelection;
                System.out.println(adMap.getRoom(playerSelection));
                System.out.println("Please choose an exit");
                playerSelection = scnr.nextLine();
                System.out.println();
            }
            else
            {
                //Print if the exit is not valid
                System.out.println("Invalid exit.");
                System.out.println("Please choose an exit");
                playerSelection = scnr.nextLine();
                System.out.println();
            }
        }
        
    }

}

