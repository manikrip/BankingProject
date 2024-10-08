package Validators;

import Utils.Constant; // Importing constants for standardized messages
import Utils.CustomException;


/*
*********************************************************************************************************
 *  @Java Class Name :   Positivenumber
 *  @Author          :   Manish Kripalani (Manish.kripalani@antrazal.com)
 *  @Company         :   Antrazal
 *  @Date            :   17-09-2024
 *  @Description     :   This class provides validation for 
 *                      ensuring that a given number is positive.
 *                      It prompts the user for input until 
 *                      a valid positive number is provided.
 *******************************************************************************************************
 *  AWC ID     Developer                                             	  	TITLE  
 *  1633      <Manish Kripalani>(manish.kripalani@antrazal.com)      JAVA ASSIGNMENT
********************************************************************************************************
*/

public class Positivenumber implements Validator {

    public Integer number;
    public String msg;

    public Positivenumber(Integer number, String msg) {
        this.number = number;
        this.msg = msg;
    }
/*
     *********************************************************
     * @Method Name : Validator
     * @Description : Validates that the provided number is positive. If not, it repeatedly prompts the user for a valid input until a positive integer is entered.
     * @param : number - The number to be validated
     * @return : int - A valid positive number
     *********************************************************
     */
    @Override
    public Integer Validator() throws CustomException {
        try {
            if (number <= 0) {
                throw new CustomException(Constant.POSITIVEVALUE);
            }
        } catch (Exception e) {
            throw e;
        }

        // Check if the number is positive
        return number; // Return the valid positive number
    }
    

}
