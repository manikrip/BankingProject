/*
*********************************************************************************************************
 *  @Java Class Name :   ValidPancard
 *  @Author          :   Manish Kripalani (Manish.kripalani@antrazal.com)
 *  @Company         :   Antrazal
 *  @Date            :   17-09-2024
 *  @Description     :   This class contains a method to validate the Pan Card number entered by the user.
 *                       The Pan Card number must be exactly 12 characters long. The method repeatedly prompts
 *                       the user until a valid Pan Card number is provided.
 *********************************************************************************************************
 */

 package Validators;

 import java.util.Scanner;
 
 import Utils.Constant;
 import Utils.Sout;
 
 /*
 *********************************************************
  *  @Method Name    :   getValidPancard
  *  @Author         :   Manish Kripalani (Manish.kripalani@antrazal.com)
  *  @Company        :   Antrazal
  *  @Description    :   This method prompts the user to enter a Pan Card number, validates that it is exactly 
  *                      12 characters long, and returns the valid Pan Card number. It keeps prompting the user
  *                      until a valid input is received.
  *  @param          :   scanner (Scanner) - Scanner object for reading user input
  *  @return         :   String - Valid Pan Card number
  *********************************************************
  */
  public class ValidPancard {

    public static String getValidPancard(String panCardNumber) {
        Scanner scanner = new Scanner(System.in); // Create a Scanner instance inside the function

        // Keep asking for input until the provided Pan Card number is valid
        while (panCardNumber.isEmpty() || panCardNumber.length() != 12 || !panCardNumber.matches("[a-zA-Z0-9]+")) {
            if (panCardNumber.isEmpty()) {
                     Sout.print(Constant.INVALIDPANCARD);
            } else if (panCardNumber.length() != 12) {
                Sout.print(Constant.PANCARDSIZE);
            } else if (!panCardNumber.matches("[a-zA-Z0-9]+")) {
                
                Sout.print(Constant.PANCARDD);
            }
            panCardNumber = scanner.nextLine().trim(); // Read and trim input from the user
        }

        return panCardNumber; // Return the valid Pan Card number
    }
 }
 