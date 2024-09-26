package Validators;

import java.util.Scanner; // Importing Scanner for user input

import Utils.Constant; // Importing constants for standardized messages
import Utils.CustomException;
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
public class ParamChecker implements Validator {

    Integer param1;
    Integer param2;

    public ParamChecker(Integer param1, Integer param2) {
        this.param1 = param1;
        this.param2 = param2;

    }

    /*
     *********************************************************
     * @Method Name : checkParameters
     * 
     * @Description : Validates two integer parameters.
     * It ensures that param1 is positive
     * and greater than param2. If not,
     * it repeatedly prompts the user
     * for valid input until the conditions
     * are met.
     * 
     * @param : param1 - The first parameter to be checked
     * 
     * @param : param2 - The second parameter to compare against
     * 
     * @return : int - A valid value for param1
     *********************************************************
     */
    
    @Override
    public Object Validator() throws CustomException, Exception {
        try {

            if (param1 <= param2) {
                throw new CustomException(Constant.MINIMUMAMOUNT);
            }
        } catch (Exception e) {
            throw e;
        }

        return param1; // Return the valid parameter value
    }
}
