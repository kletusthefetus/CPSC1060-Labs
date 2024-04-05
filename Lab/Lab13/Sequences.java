/**
 * Name(s): James Maner and Chase Harris
 * CPSC 1061: Lab 13
 * Section 003
 * 4/20/2023
 */
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Sequences
{
    /**
     * exception check for the integer input value
     * @param scnr name of the scanner to get input from
     * @return int to return the integer input by the user
     */
    public static int getVal(Scanner scnr)
    {
        int fig;
        try
        {
            fig = scnr.nextInt();
        }
        catch (InputMismatchException e)
        {
            System.out.println("Please enter a valid input.");
            scnr.nextLine();
            fig = getVal(scnr);
        }
        return fig;
    }

    /**
     * creates an arraylist representing a fibonacci sequence with val entries
     * @param val determines the length of the sequence
     * @return Arraylist<Integer> is the list of integers set in fibonacci sequence
     */
    public static ArrayList<Integer> fibonacci(int val)
    {
        //Create a new arrayList of ints
        ArrayList<Integer> fibonList = new ArrayList<>();

        //If there are 0 entries, return an empty list
        if (val <= 0)
        {
            return fibonList;
        }
        //If only 1 entry, return the first entry in a fibonacci sequence
        else if (val == 1)
        {
            fibonList.add(0);
            return fibonList;
        }
        else if (val == 2)
        {
            fibonList.add(0);
            fibonList.add(1);
            return fibonList;
        }
        //Make the current arraylist equal to the arraylist with val - 1 and then add the "val"-th entry
        else
        {
            fibonList = fibonacci(val - 1);
            fibonList.add(fibonList.get(val - 2) + fibonList.get(val - 3));
            return fibonList;
        }
    }

    /**
     * Creates a list of numbers representative of a factorial sequence
     * @param val the number of entries in the factorial
     * @return ArrayList<Integer> is the list containing the factorial entries
     */
    public static ArrayList<Integer> factorial(int val)
    {
        //Create a new arraylist to populate with factorials
        ArrayList<Integer> factList = new ArrayList<>();
        int fact = val;

        //If there are 0 entries, return an empty list
        if (val == 0)
        {
            return factList;
        }
        //If only 1 entry, return the first entry in a factorial sequence
        else if (val == 1)
        {
            factList.add(1);
            return factList;
        }
        else 
        {
            //Set the current list equal to the list of val - 1
            factList = factorial(val - 1);
            
            //Calculate the new factorial for val
            for (int i = val - 1; i > 0; i--)
            {
                fact *= i;
            }

            //Add the "val"-th entry
            factList.add(fact);
            return factList;
        }
    }

    public static void main(String[] args)
    {
        Scanner scnr = new Scanner(System.in);

        //Prompt the user for the number used for the sequence
        System.out.println("Please input a number that you want to generate for each sequence.");
        int inputVal = getVal(scnr);

        //Create the arrays corresponding to the value from input
        ArrayList<Integer> fibonacci = fibonacci(inputVal);
        ArrayList<Integer> factorial = factorial(inputVal);

        //Create a file name based on the number inputted
        String fileName = String.format("%dFibAndFactSequences.txt", inputVal);
        FileOutputStream outStream = null;

        //Attempt to create a file based on the file name, catch this exception if the file cannot be found
        try
        {
            outStream = new FileOutputStream(fileName);
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Cannot find " + fileName);
        }

        //Create a print writer and enter all the outputs into the file using it.
        PrintWriter workingPrint = new PrintWriter(outStream);
        workingPrint.print("Fibonacci: " + fibonacci);
        workingPrint.println();
        workingPrint.print("Factorial: " + factorial);
        workingPrint.println();
        workingPrint.close();
    }
}