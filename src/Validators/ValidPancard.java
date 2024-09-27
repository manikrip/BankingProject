/*
*********************************************************************************************************
 *  @Java Class Name :   ValidPancard
 *  @Author          :   Manish Kripalani (Manish.kripalani@antrazal.com)
 *  @Company         :   Antrazal
 *  @Date            :   17-09-2024
 *  @Description     :   This class contains a method to validate the Pan Card number entered by the user.
 *                       The Pan Card number must be exactly 12 characters long. The method repeatedly prompts
 *                       the user until a valid Pan Card number is provided.
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
public class ValidPancard implements Validator {
    public String panCardNumber;
    public String msg;

    public ValidPancard(String panCardNumber, String msg) {
        this.panCardNumber = panCardNumber;
        this.msg = msg;
    }

    @Override
    public String Validator() throws CustomException {
        try {
            if (panCardNumber.isEmpty() || panCardNumber.length() != 12 || !panCardNumber.matches("[a-zA-Z0-9]+")) {
                throw new CustomException(Constant.INVALIDPANCARD);
            }
        } catch (Exception e) {
            throw e;
        }

        return panCardNumber; // Return the valid Pan Card number

    }
}
