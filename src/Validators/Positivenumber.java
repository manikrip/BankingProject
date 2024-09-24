package Validators;

import java.util.Scanner; // Importing Scanner for user input
import Utils.Constant; // Importing constants for standardized messages
import Utils.Sout; // Importing custom print utility

/*
 *********************************************************
 *  @Class Name     :   Positivenumber
 *  @Description    :   This class provides validation for 
 *                      ensuring that a given number is positive.
 *                      It prompts the user for input until 
 *                      a valid positive number is provided.
 *********************************************************
 */
public class Positivenumber {

    /*
     *********************************************************
     *  @Method Name    :   validatePositiveNumber
     *  @Description    :   Validates that the provided number 
     *                      is positive. If not, it repeatedly 
     *                      prompts the user for a valid input 
     *                      until a positive integer is entered.
     *  @param          :   number - The number to be validated
     *  @return         :   int - A valid positive number
     *********************************************************
     */
    public static int validatePositiveNumber(int number) {
        Scanner scanner = new Scanner(System.in); // Creating a scanner object for input
        
        // Check if the number is positive
        while (number <= 0) {
            Sout.print(Constant.POSITIVEVALUE); // Prompt for positive number
            // Validate that the input is an integer
            while (!scanner.hasNextInt()) {
                Sout.print(Constant.POSITIVEVALUE); // Prompt again if input is invalid
                scanner.next(); // Clear invalid input
            }
            number = scanner.nextInt(); // Read the integer input
        }
        
        return number; // Return the valid positive number
    }
}
