/*
*********************************************************************************************************
 *  @Java Class Name :   EmailValidator
 *  @Author          :   Manish Kripalani (Manish.kripalani@antrazal.com)
 *  @Company         :   Antrazal
 *  @Date            :   17-09-2024
 *  @Description     :   This class provides functionality to validate email addresses. It ensures that
 *                       the provided email address matches a standard email format using a regex pattern.
 *********************************************************************************************************
 */

 package Validators;

 import java.util.Scanner; // Importing Scanner for user input
 import Utils.Constant; // Importing constants for standardized messages
 import Utils.Sout; // Importing custom print utility
 
 /*
  *********************************************************
  *  @Method Name    :   validateEmail
  *  @Author         :   Manish Kripalani (Manish.kripalani@antrazal.com)
  *  @Company        :   Antrazal
  *  @Description    :   This method prompts the user to enter a valid email address. It validates the email
  *                      against a predefined regex pattern and keeps prompting the user until a valid email
  *                      is provided.
  *  @param          :   String email - Initial email address input by the user
  *  @return         :   String - Valid email address
  *********************************************************
  */
 public class EmailValidator  implements Validator{
    public String email ;
    public String msg;
    public EmailValidator(String email, String msg) {
        this.email=email;
        this.msg = msg;
    }  
     /*
      *********************************************************
      *  @Method Name    :   isEmailValid
      *  @Author         :   Manish Kripalani (Manish.kripalani@antrazal.com)
      *  @Company        :   Antrazal
      *  @Description    :   This private method checks if the provided email matches the predefined regex pattern.
      *  @param          :   String email - Email address to be validated
      *  @return         :   boolean - True if email matches the pattern, false otherwise
      *********************************************************
      */
      
     private static boolean isEmailValid(String email) {
         String emailRegex = Constant.EMAILREGEX; // Retrieve regex from constants
         return email.matches(emailRegex); // Check if email matches the pattern
     }

    @Override
    public String Validator()  {
        Scanner scanner = new Scanner(System.in); // Scanner object for reading user input
        
        // Regular expression for validating an email address
        String emailRegex = Constant.EMAILREGEX;
        
        // Check if the email matches the regex pattern
        while (!email.matches(emailRegex)) {
           Sout.print(Constant.INVALIDEMAIL); // Prompt for invalid email
           Sout.print(Constant.VALIDEMAILENTER); // Ask for valid email
            email = scanner.nextLine(); // Read new email input
        }
        
        return email; // Return the valid email
    }
 
 }
 