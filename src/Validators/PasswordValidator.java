/*
*********************************************************************************************************
 *  @Java Class Name :   PasswordValidator
 *  @Author          :   Manish Kripalani (Manish.kripalani@antrazal.com)
 *  @Company         :   Antrazal
 *  @Date            :   17-09-2024
 *  @Description     :   This class contains a method to validate user input. The method ensures that the 
 *                       input string contains only letters and digits. It repeatedly prompts the user 
 *                       until a valid input is provided.
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
  *  @Description    :   This method prompts the user to enter a string that must contain only letters 
  *                      and digits. It validates the input against this requirement and continues to 
  *                      prompt the user until a valid input is received.
  *  @return         :   String - Valid input containing only letters and digits
  *********************************************************
  */
 public class PasswordValidator {
     
    public static String validPassword(String input, String str) {
        Scanner scanner = new Scanner(System.in);
        
        // Check if the input contains only letters
        while (!input.matches("[a-zA-Z0-9]+")) {
            Sout.print(Constant.LETTERDIGIT);
            
            System.out.print("Enter a valid " + str);
            input = scanner.nextLine();
        }
        
        return input; // Return the valid string
    }
     
 }
 