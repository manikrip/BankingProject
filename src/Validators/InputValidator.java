/*
*********************************************************************************************************
 *  @Java Class Name :   InputValidator
 *  @Author          :   Manish Kripalani (Manish.kripalani@antrazal.com)
 *  @Company         :   Antrazal
 *  @Date            :   17-09-2024
 *  @Description     :   This class contains a method to validate user input. The method ensures that the 
 *                       input string contains only letters. It repeatedly prompts the user until a valid 
 *                       input is provided.
 *********************************************************************************************************
 */

 package Validators;

 import java.util.Scanner;

import Utils.Constant;
import Utils.Sout;
 
 /*
 *********************************************************
  *  @Method Name    :   getValidString
  *  @Author         :   Manish Kripalani (Manish.kripalani@antrazal.com)
  *  @Company        :   Antrazal
  *  @Description    :   This method prompts the user to enter a string that must contain only letters. 
  *                      It validates the input against this requirement and continues to prompt the user 
  *                      until a valid input is received.
  *  @return         :   String - Valid input containing only letters
  *********************************************************
  */
 public class InputValidator {

    public static String validateString(String input, String str) {
        Scanner scanner = new Scanner(System.in);
        
        // Check if the input contains only letters
        while (!input.matches("[a-zA-Z]+")) {
           Sout.print(Constant.VALIDSTRING);
            System.out.print("Enter a valid " +str);
            input = scanner.nextLine();
        }
        
        return input; // Return the valid string
    }
    // Method to validate the address passed as a parameter
    public static String validateAddress(String address) {
        // Regular expression that allows letters, numbers, spaces, commas, and periods
        String addressPattern = "^[a-zA-Z0-9\\s,\\.]+$";  
        Scanner scanner = new Scanner(System.in);

        // Loop to keep asking for address until it's valid
        while (!address.matches(addressPattern)) {
            System.out.println("Invalid address. Please enter a valid address containing letters, numbers, spaces, commas, or periods.");
            System.out.print("Re-enter your address: ");
            address = scanner.nextLine();
        }

    
        return address;
    }
 }
 