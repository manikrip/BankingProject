package Validators;

import Utils.Constant; // Importing constants for standardized messages
import Utils.CustomException;
/*
*********************************************************************************************************
 *  @Java Class Name :   PinSize
 *  @Author          :   Manish Kripalani (Manish.kripalani@antrazal.com)
 *  @Company         :   Antrazal
 *  @Date            :   17-09-2024
 *  @Description     :   This class provides validation for 
 *                      ensuring that a given PIN is a 4-digit 
 *                      number. It prompts the user for input 
 *                      until a valid PIN is provided.
 *******************************************************************************************************
 *  AWC ID     Developer                                             	  	TITLE  
 *  1633      <Manish Kripalani>(manish.kripalani@antrazal.com)      JAVA ASSIGNMENT
********************************************************************************************************
*/


public class PinSize implements Validator {

    public Integer pin;
    public String msg;

    public PinSize(Integer pin, String msg) {
        this.pin = pin;
        this.msg = msg;
    }

    /*
     *********************************************************
     * @Method Name : Validator
     * @Description : Validates that the provided PIN is
     * a 4-digit number. If not, it repeatedly
     * prompts the user for a valid input
     * until a valid 4-digit PIN is entered.
     * @param : pin - The PIN to be validated
     * @return : int - A valid 4-digit PIN
     *********************************************************
     */
    @Override
    public Integer Validator() throws CustomException {

        try {
            if (pin <= 1000 && pin >= 9999) {
                throw new CustomException(Constant.PINSIZE);
            }
        } catch (Exception e) {
            throw e;
        }

        return pin;
    }


}
