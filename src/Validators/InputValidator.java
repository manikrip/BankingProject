/*
*********************************************************************************************************
 *  @Java Class Name :   InputValidator
 *  @Author          :   Manish Kripalani (Manish.kripalani@antrazal.com)
 *  @Company         :   Antrazal
 *  @Date            :   17-09-2024
 *  @Description     :   This class contains a method to validate user input. The method ensures that the 
 *                       input string contains only letters. It repeatedly prompts the user until a valid 
 *                       input is provided.
 *******************************************************************************************************
 *  AWC ID     Developer                                             	  	TITLE  
 *  1633      <Manish Kripalani>(manish.kripalani@antrazal.com)      JAVA ASSIGNMENT
********************************************************************************************************
*/

package Validators;

import Utils.Constant;
import Utils.CustomException;

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
public class InputValidator implements Validator {
    public String input;
    public String msg;

    public InputValidator(String input, String msg) {
        this.input = input;
        this.msg = msg;
    }

    @Override
    public String Validator() throws CustomException {

        try {
            if (!input.matches("[a-zA-Z]+")) {
                throw new CustomException(Constant.VALIDSTRING);
            }

        } catch (Exception e) {
            throw e;
        }
        // Check if the input contains only letters

        return input; // Return the valid string
    }

}
