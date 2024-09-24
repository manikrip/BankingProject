package Validators;

import java.util.Scanner; // Importing Scanner for user input

import Utils.Constant; // Importing constants for standardized messages
import Utils.Sout; // Importing custom print utility

/*
 *********************************************************
 *  @Class Name     :   ParamChecker
 *  @Description    :   This class provides validation for 
 *                      two parameters, ensuring that the first 
 *                      parameter is positive and greater than 
 *                      the second parameter. It prompts the user 
 *                      for input until valid values are provided.
 *********************************************************
 */
public class ParamChecker {

    /*
     *********************************************************
     *  @Method Name    :   checkParameters
     *  @Description    :   Validates two integer parameters. 
     *                      It ensures that param1 is positive 
     *                      and greater than param2. If not, 
     *                      it repeatedly prompts the user 
     *                      for valid input until the conditions 
     *                      are met.
     *  @param          :   param1 - The first parameter to be checked
     *  @param          :   param2 - The second parameter to compare against
     *  @return         :   int - A valid value for param1
     *********************************************************
     */
    public static int checkParameters(int param1, int param2) {
        Scanner scanner = new Scanner(System.in); // Creating a scanner object for input

        // Keep asking for a positive parameter until it is greater than zero
        while (param1 <= 0) {
            Sout.print(Constant.POSITIVEVALUE); // Prompt for a positive value
            param1 = scanner.nextInt(); // Read new input
        }

        // Keep asking for parameter one until it is greater than parameter two
        while (param1 <= param2) {
            Sout.print(Constant.MINIMUMAMOUNT); // Prompt for a valid amount
            System.out.print("Please enter a new amount: ");
            param1 = scanner.nextInt(); // Read new input
            
            // Check again if the new input is still positive
            while (param1 <= 0) {
                Sout.print(Constant.POSITIVEVALUE); // Prompt for a positive value
                param1 = scanner.nextInt(); // Read new input
            }
        }

        return param1; // Return the valid parameter value
    }
}
