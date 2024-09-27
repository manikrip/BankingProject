/*
*********************************************************************************************************
 *  @Java Class Name :   EmailValidator
 *  @Author          :   Manish Kripalani (Manish.kripalani@antrazal.com)
 *  @Company         :   Antrazal
 *  @Date            :   17-09-2024
 *  @Description     :   This class provides functionality to validate email addresses. It ensures that
 *                       the provided email address matches a standard email format using a regex pattern.
 *******************************************************************************************************
 *  AWC ID     Developer                                             	  	TITLE  
 *  1633      <Manish Kripalani>(manish.kripalani@antrazal.com)      JAVA ASSIGNMENT
********************************************************************************************************
*/


package Validators;

import Utils.Constant; // Importing constants for standardized messages
import Utils.CustomException;

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
public class EmailValidator implements Validator {
    public String email;
    public String msg;

    public EmailValidator(String email, String msg) {
        this.email = email;
        this.msg = msg;
    }
    @Override
    public String Validator() throws CustomException {
        String emailRegex = Constant.EMAILREGEX;

        // Validate email against regex
        if (!email.matches(emailRegex)) {
            throw new CustomException(Constant.INVALIDEMAIL); // Throw exception if invalid
        }

        return email; // Return valid email
    }

}
