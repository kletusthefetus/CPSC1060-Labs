/**
 * Name(s): James Maner and Chase Harris
 * CPSC 1061: Lab 8: Blackjack!
 * Section 003
 * 3/7/2023
 */
//Import important objects and classes
import java.util.*;
import java.util.Scanner;
import java.util.Random;
 
public class BlackJack {

    /*
        @param numCards - the number of cards to deal into the players hand
        @param ranGen - random number generator to pick the card to deal
        @param deck - the selection of cards to pull from
        @return void - return nothing
    */
    //This method is used to issue each player their initial two cards
    public static void deal(int numCards, int player, Random ranGen,
     ArrayList<String> deck, ArrayList<ArrayList<String>> playerDecks)
    {
        ArrayList<String> temp = new ArrayList<String>();
        for (int i = 0; i < numCards; i++)
        {
            int cardNum = ranGen.nextInt(deck.size());
            temp.add( (String) deck.get(cardNum));
            deck.remove(cardNum);
        }

        playerDecks.add(player, temp);

    }

    //This method prints out 20 blank lines in order for the players to
    //effectively take turns on the computer without seeing eachother's cards
    public static void space()
    {
        for (int i = 0; i < 20; i++)
        {
            System.out.println("");
        }
    }

    /*
        @param ranGen - random number generator to pick the card to deal
        @param deck - the selection of cards to pull from
        @return void - return nothing
    */
    //This method is used to add one card to the player's hand
    public static void draw(int player, Random ranGen, ArrayList<String> deck,
     ArrayList<ArrayList<String>> playerDecks)
    {
        ArrayList<String> temp = (ArrayList<String>) playerDecks.get(player);
        int cardNum = ranGen.nextInt(deck.size());
        temp.add( (String) deck.get(cardNum));
        deck.remove(cardNum);
        playerDecks.set(player, temp);
    }

    /*
        @param player - the number of player whos cards will be added
        @param myDeck - the array list that holds the cards in the hands of each player
        @return total - return the sum of the value of the cards as an integer
    */
    //This method is used to add up the values of the cards in the hands of the players
    public static int sum(int player, ArrayList<ArrayList<String>> myDeck)
    {
        boolean usedA = false;
        int total = 0;
        for (int i = 0; i < ( (ArrayList<String>) myDeck.get(player)).size(); i++)
        {
            switch ( ( (String) ( (ArrayList<String>) myDeck.get(player)).get(i))
            .substring(0, ( (String) ( (ArrayList<String>) myDeck.get(player)).get(i)).length() - 1))
            {
                case "A":
                    usedA = true;
                    total += 11;
                    if (total > 21)
                    {
                        total -= 10;
                        usedA = false;
                    }
                    break;
                case "2":
                    total += 2;
                    if (usedA && total > 21)
                    {
                        total -= 10;
                        usedA = false;
                    }
                    break;
                case "3":
                    total += 3;
                    if (usedA && total > 21)
                    {
                        total -= 10;
                        usedA = false;
                    }
                    break;
                case "4":
                    total += 4;
                    if (usedA && total > 21)
                    {
                        total -= 10;
                        usedA = false;
                    }
                    break;
                case "5":
                    total += 5;
                    if (usedA && total > 21)
                    {
                        total -= 10;
                        usedA = false;
                    }
                    break;
                case "6":
                    total += 6;
                    if (usedA && total > 21)
                    {
                        total -= 10;
                        usedA = false;
                    }
                    break;
                case "7":
                    total += 7;
                    if (usedA && total > 21)
                    {
                        total -= 10;
                        usedA = false;
                    }
                    break;
                case "8":
                    total += 8;
                    if (usedA && total > 21)
                    {
                        total -= 10;
                        usedA = false;
                    }
                    break;
                case "9":
                    total += 9;
                    if (usedA && total > 21)
                    {
                        total -= 10;
                        usedA = false;
                    }
                    break;
                case "10":
                    total += 10;
                    if (usedA && total > 21)
                    {
                        total -= 10;
                        usedA = false;
                    }
                    break;
                case "J":
                    total += 10;
                    if (usedA && total > 21)
                    {
                        total -= 10;
                        usedA = false;
                    }
                    break;
                case "Q":
                    total += 10;
                    if (usedA && total > 21)
                    {
                        total -= 10;
                        usedA = false;
                    }
                    break;
                case "K":
                    total += 10;
                    if (usedA && total > 21)
                    {
                        total -= 10;
                        usedA = false;
                    }
                    break;
            }

        }
        return total;
    }

    public static void main(String[] args) {
        //Initialize scanner
        Scanner scnr = new Scanner(System.in);

        //Declare needed variables
        int seed;
        int playerCount;
        Random ranGen;
        int[] scores;
        /*
         * This is the deck of cards, do not edit it unless you want to change the variable name
         */
        ArrayList<String> deck = new ArrayList<String>(Arrays.asList(
            "AH", "2H", "3H", "4H", "5H", "6H", "7H", "8H", "9H", "10H", "JH", "QH", "KH",
            "AD", "2D", "3D", "4D", "5D", "6D", "7D", "8D", "9D", "10D", "JD", "QD", "KD",
            "AC", "2C", "3C", "4C", "5C", "6C", "7C", "8C", "9C", "10C", "JC", "QC", "KC",
            "AS", "2S", "3S", "4S", "5S", "6S", "7S", "8S", "9S", "10S", "JS", "QS", "KS"
        ));

        //This is the collection of the cards in players hands
        ArrayList<ArrayList<String>> playerDecks;

        /*
         * Here are all of the print statements that you need
         * Change these print statement variables (if desired) to fit your naming conventions
         * i is the iterator for each of the loops
         * myDeck is the deck variable for each of the players
         * arr is the way that we store each of the decks
         * maxScoreIndicies are the indicies of the highest scores of the decks
         * maxScore is the highest score
         */
        //Promt the user for and set the seed for the random number generator
        System.out.println("Give me a seed.");
        seed = scnr.nextInt();
        ranGen = new Random(seed);

        //Prompt the user for and set the number of players
        System.out.println("How many humans would you like to play with?");
        playerCount = scnr.nextInt();
        scores = new int[playerCount];
        playerDecks = new ArrayList<ArrayList<String>>(playerCount);
        
        //Deal each player a randomly selected pair of cards
        for (int i = 0; i < playerCount; i++)
        {
            deal(2, i, ranGen, deck, playerDecks);
            System.out.println("Player " + i + "'s cards:");
            System.out.println(playerDecks.get(i));
            System.out.println("Acknowledge that you have seen your cards player "
             + i + " by entering any key.");
            char input = scnr.next().charAt(0);
            space();
        }
            
        System.out.println("Now that everybody knows their cards, let's play!");
        
        //Prompt each player whether they would like to draw another card or not
        for (int i = 0; i < playerCount; i++)
        {
            System.out.println("Player " + i + "'s cards:");
            System.out.println(playerDecks.get(i));
            System.out.println("Player " + i + " would you like to hit or stick?");
            String response = scnr.next();

            //Loop until the player decides not to hit
            while (response.equalsIgnoreCase("Hit"))
            {
                draw(i, ranGen, deck, playerDecks);
                System.out.println("Player " + i + "'s cards: " + playerDecks.get(i));
                if (sum(i, playerDecks) > 21)
                {
                    System.out.println("Player " + i + 
                    " you have busted. Enter any key to acknowledge this.");
                    char input = scnr.next().charAt(0);
                    break;
                }
                else 
                {
                    System.out.println("Player " + i + " would you like to hit or stick?");
                    response = scnr.next();
                }
            }
            space();
        }

        //Tally up the scores on the blackjack players, setting their score to 0 if they bust
        for (int i = 0; i < playerCount; i++)
        {
            if (sum(i, playerDecks) <= 21)
            {
                scores[i] = sum(i, playerDecks);
            }
            else 
            {
                scores[i] = 0;
            }
        }

        //Find the max score and the index of that score
        int maxScore = scores[0];
        int maxIndex = 0;
        for (int i = 0; i < playerCount; i++)
        {
            if (scores[i] > maxScore)
            {
                maxScore = scores[i];
                maxIndex = i;
            }
        }

        //Determine if the highest scorer is tied with anyone else
        int tiedNums = 0;
        int[] tiedIndices = new int[playerCount];
        int tieIndex = 0;
        for (int i = 0; i < playerCount; i++)
        {
            if (scores[i] == maxScore)
            {
                tiedNums++;
                tiedIndices[tieIndex] = i;
                tieIndex++;
            }
        }

        //Print out the winner (or winners), and losers
        int lossCount = 0;
        for (int i = 0; i < playerCount; i++)
        {
            if (scores[i] == 0)
            {
                System.out.println("Player " + i + " has busted.");
                lossCount++;
            }
            else if (tiedNums > 1)
            {
                System.out.print("Players ");
                System.out.print(tiedIndices[0]);
                for (int j = 1; j < tiedNums; j++)
                {
                    System.out.print(" and " + tiedIndices[j]);
                }
                System.out.println(" tied for the highest score of " + maxScore);
            }
            else if (i == tiedIndices[0])
            {
                System.out.println("Player " + tiedIndices[0] + 
                " got the highest score of " + maxScore + ".");
            }


        }
        
        //If every player busts, nobody wins
        if (lossCount == playerCount)
        {
            System.out.println("Nobody won.");
        }
        
    }
}