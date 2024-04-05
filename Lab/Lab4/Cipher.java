// Create header and rename file to Cipher.java
/*
	James Maner & Chase Harris
	CPSC 1061: Lab 4
	Lab Section 003
	2/7/2023
*/
// Import Statements
import java.util.Scanner;

public class Cipher {
	public static void main(String[] args) {
		// Create scanner object
		Scanner scnr = new Scanner(System.in);

		//initialize any future needed variables outside of loops or if statements
		int key = 0;
		int cipherInt = 0;
		char cipherChar = ' ';
		int subStringInt = 0;
		String ceasarText = "";
		boolean keyNotValid;
		String plainText;

		//Prompt user for key value
		System.out.print("Key Value: ");
		//String str = scnr.nextLine();

		//quit if user is trying to put letters into the key
			if (scnr.hasNextInt())
				{
					key = scnr.nextInt();
					scnr.nextLine();
					System.out.println();
				}
			else 
			{
				System.out.println();
				System.out.println("Please enter a valid non-negative integer");
				System.exit(0);
			}
		

		//loop until user stops using negative integers
		while (!(key > 0))
		{
			System.out.println("Usage: Try again, please enter a valid non-negative integer");
			System.out.println("");
			System.out.print("Key Value: ");
			key = scnr.nextInt();
			scnr.nextLine();
			System.out.println();
		}

		//Prompt user for plaintext to encode with the key
		System.out.print("String to encode with key " + key + ": ");
		plainText = scnr.nextLine();
		System.out.println("");
		//System.out.println(plainText);

		//Go through each letter of the plaintext string to encode it
		System.out.print("Caesar Cipher: ");
		for (int i = 0; i <= plainText.length() - 1; i++)
		{
			if (Character.isLetter(plainText.charAt(i)))
			{
				if (Character.isUpperCase(plainText.charAt(i)))
			{
				cipherInt = (int) plainText.charAt(i);
				cipherInt = (cipherInt + (key % 26));
				//System.out.println("DEBUG: cipherInt before modulo = " + cipherInt );
				while (cipherInt > 90)
				{
					cipherInt = (cipherInt % 90) + 64;
				}
				//System.out.println("DEBUG: cipherInt after modulo = " + cipherInt );
			    cipherChar = (char) cipherInt;
			}
			else if (Character.isLowerCase(plainText.charAt(i)))
			{
				cipherInt = (int) plainText.charAt(i);
				cipherInt = (cipherInt + (key % 26));
				//System.out.println("DEBUG: cipherInt before modulo = " + cipherInt );
				if (cipherInt > 122)
				{
					cipherInt = (cipherInt % 122) + 96;
				}
				//System.out.println("DEBUG: cipherInt after modulo = " + cipherInt );
			    cipherChar = (char) cipherInt;
			}
			}
			else 
			{
				cipherChar = plainText.charAt(i);
			}
			System.out.print(cipherChar);
			ceasarText = ceasarText + cipherChar;
		}
		//In 33 years the CIA

		//Get the midway point of the string
		subStringInt = ceasarText.length() / 2;
		System.out.println("");
		//System.out.println("DEBUG ceasarText: " + ceasarText);
		
		//Display the encoded message with the front and back ends of the string swapped
		System.out.println("Ciphertext: " + ceasarText.substring(subStringInt) + ceasarText.substring(0, subStringInt));
		System.out.println("");

		//Prompt the user to either quit or encode another message 
		System.out.print("Type q to quit, any other to continue: ");
		char contChar = scnr.nextLine().charAt(0);
		//scnr.nextLine();
		System.out.println();

		//Repeat the process until the user quits with the q key at the end.
		while (contChar != 'q')
		{
			ceasarText = "";
			System.out.print("Key Value: ");
			

			if (scnr.hasNextInt())
				{
					key = scnr.nextInt();
					scnr.nextLine();
					System.out.println();
				}
			else
			{
				System.out.println();
				System.out.println("Please enter a valid non-negative integer");
				System.exit(0);
			}

			while (!(key > 0))
		{
				System.out.println("Usage: Try again, please enter a valid non-negative integer");
				System.out.println("");
				System.out.print("Key Value: ");
				key = scnr.nextInt();
				scnr.nextLine();
				System.out.println();
		}

			System.out.print("String to encode with key " + key + ": ");
			plainText = scnr.nextLine();
			System.out.println();

			System.out.print("Caesar Cipher: ");
		for (int i = 0; i <= plainText.length() - 1; i++)
		{
			if (Character.isLetter(plainText.charAt(i)))
			{
				if (Character.isUpperCase(plainText.charAt(i)))
			{
				cipherInt = (int) plainText.charAt(i);
				cipherInt = (cipherInt + (key % 26));
				//System.out.println("DEBUG: cipherInt before modulo = " + cipherInt );
				while (cipherInt > 90)
				{
					cipherInt = (cipherInt % 90) + 64;
				}
				//System.out.println("DEBUG: cipherInt after modulo = " + cipherInt );
			    cipherChar = (char) cipherInt;
			}
			else if (Character.isLowerCase(plainText.charAt(i)))
			{
				cipherInt = (int) plainText.charAt(i);
				cipherInt = (cipherInt + (key % 26));
				//System.out.println("DEBUG: cipherInt before modulo = " + cipherInt );
				while (cipherInt > 122)
				{
					cipherInt = (cipherInt % 122) + 96;
				}
				//System.out.println("DEBUG: cipherInt after modulo = " + cipherInt );
			    cipherChar = (char) cipherInt;
			}
			}
			else 
			{
				cipherChar = plainText.charAt(i);
			}
			System.out.print(cipherChar);
			ceasarText = ceasarText + cipherChar;
		}

		subStringInt = ceasarText.length() / 2;
		System.out.println("");
		//System.out.println("DEBUG ceasarText: " + ceasarText);
		
		System.out.println("Ciphertext: " + ceasarText.substring(subStringInt) + ceasarText.substring(0, subStringInt));
		System.out.println("");

		System.out.print("Type q to quit, any other to continue: ");
		contChar = scnr.next().charAt(0);
		scnr.nextLine();
		System.out.println();
		}

		// Close scanner object
	}
}
