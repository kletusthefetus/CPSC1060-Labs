/**
    Name: James Maner & Chase Harris
    Lab Section 003
    CPSC 1061: Lab 7
    Date: 02/28/2023
 */

//Import needed objects
import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;

public class MagicSquare {

    /**
     * Description: Checks if the arrays have the same elements using a set comparison
     *
     * @param arr the 2D integer array to be sorted and compared
     * @return true if the array contains all numbers from 1 to size^2, false otherwise
     */
    public static boolean compareArrays(int arr[][]) {
        Set<Integer> expectedSet = new HashSet<Integer>();
        for (int i = 1; i <= Math.pow(arr.length, 2.0); i++) {
            expectedSet.add(i);
        }

        // Check if the set of array elements is equal to the expected set
        Set<Integer> arrSet = new HashSet<Integer>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arrSet.add(arr[i][j]);
            }
        }
        return arrSet.equals(expectedSet);
    }

    public static void main(String[] args) {
        //Initialize scanner
        Scanner scnr = new Scanner(System.in);

        //Declare all needed variables
        int squareSize;
        int magicNumber;
        int[][] magicArr;
        boolean magical = true;

        //Prompt the user for the square size
        System.out.println("Enter in the magic square size you would like: ");
        squareSize = scnr.nextInt();

        //Loop until the user enters a number greater than 0
        while (squareSize <= 0)
        {
            System.out.println("Please enter in a number in greater than 0");
            squareSize = scnr.nextInt();
        }

        //Calculate the magic number of the square with the size specified
        magicNumber = squareSize * squareSize;
        for (int i = magicNumber - 1; i >= 1; i--)
        {
            magicNumber += i;
        }
        magicNumber /= squareSize;

        //Display the magic number of the square
        //prompt the user for the values of the entries of the square
        System.out.println("The magic number for size " + squareSize + " is " + magicNumber + ".\n");
        System.out.println("Enter in the values: ");
        
        //Initialize the 2D array with the size specified
        magicArr = new int[squareSize][squareSize];

        //Populate the 2D array with the input integers
        for (int i = 0; i < squareSize; i++)
        {
            for (int j = 0; j < squareSize; j++)
            {
                magicArr[i][j] = scnr.nextInt();
            }
        }

        //Print out the 2D array
        System.out.println("You entered: ");

        for (int i = 0; i < squareSize; i++)
        {
            for (int j = 0; j < squareSize; j++)
            {
                System.out.print(magicArr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("Analyzing...");
        System.out.println();

        //Compare the array using the compareArrays function 
        //and display if it is able to be a magic square
        if (!compareArrays(magicArr))
        {
            System.out.println("The input cannot be a magic square! There must be one of each value from 1 to " + (squareSize * squareSize) +".\n");
            magical = false;
        }
        
        //Add up the values in a row and determine if it is equal to the magic number
        //Repeat this process for each row
        for (int i = 0; i < squareSize; i++)
        {
            int rowSum = 0;
            for (int j = 0; j < squareSize; j++)
            {
                rowSum += magicArr[i][j];
            }
            //If the total is not equal to the magic number, print that it does not work
            if (rowSum != magicNumber)
            {
                System.out.print("Row " + i + " does not work! These are the values in row " + i + ": ");
                for (int k = 0; k < squareSize; k++)
            {
                System.out.print(magicArr[i][k] + " ");
            }
                System.out.println();
                magical = false;
            }
        }

        //Add up the values in a column and determine if it is equal to the magic number
        //Repeat this process for each column
        for (int i = 0; i < squareSize; i++)
        {
            int columnSum = 0;
            for (int j = 0; j < squareSize; j++)
            {
                columnSum += magicArr[j][i];
            }
            //If the total is not equal to the magic number, print that it does not work
            if (columnSum != magicNumber)
            {
                System.out.print("Column " + i + " does not work! These are the values in column " + i + ": ");
                for (int k = 0; k < squareSize; k++)
            {
                System.out.print(magicArr[k][i] + " ");
            }
                System.out.println();
                magical = false;
            }
        }

        //Add up the values in the first diagonal and determine if it is equal to the magic number
        int diagonalOneSum = 0;
        for (int i = 0; i < squareSize; i++)
        {
            diagonalOneSum += magicArr[i][i];
        }
        //If the total is not equal to the magic number, print that it does not work
        if (diagonalOneSum != magicNumber)
        {
            System.out.print("Diagonal 1 does not work! These are the values in diagonal 1: ");
            for (int k = 0; k < squareSize; k++)
            {
                System.out.print(magicArr[k][k] + " ");
            }
            System.out.println();
            magical = false;
        }

        //Add up the values in the second diagonal and determine if it is equal to the magic number
        int diagonalTwoSum = 0;
        int h = 0;
        for (int i = squareSize - 1; i >=0 ; i--)
        {
            diagonalTwoSum += magicArr[h][i];
            h++;
        }
        //If the total is not equal to the magic number, print that it does not work
        h = 0;
        if (diagonalTwoSum != magicNumber)
        {
            System.out.print("Diagonal 2 does not work! These are the values in diagonal 2: ");
            for (int k = squareSize - 1; k >= 0; k--)
            {
                System.out.print(magicArr[h][k] + " ");
                h++;
            }
            System.out.println();
            magical = false;
        }

        //Print whether or not this square is magical
        if (magical)
        {

            System.out.println("This is a magic square!");
        }
        else 
        {
            System.out.println();
            System.out.println("This is not a magic square!");
        }
        
    }
}
