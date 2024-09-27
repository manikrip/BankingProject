/*
*********************************************************************************************************
 *  @Java Class Name :   BaseMiddleware
 *  @Author          :   Manish Kripalani (Manish.kripalani@antrazal.com)
 *  @Company         :   Antrazal
 *  @Date            :   24-09-2024
 *  @Description     :   This class contains middleware methods that validate various inputs like email, name, 
 *                       username, password, PAN card, account number, positive number, initial amount, PIN size, 
 *                       and address. Each method delegates the validation process to corresponding validator classes. 
 *******************************************************************************************************
 *  AWC ID     Developer                                             	  	TITLE  
 *  1633      <Manish Kripalani>(manish.kripalani@antrazal.com)      JAVA ASSIGNMENT
********************************************************************************************************
*/

package Middleware;

import Validators.AddressValidator;
import Validators.EmailValidator;
import Validators.InputValidator;
import Validators.ParamChecker;
import Validators.PasswordValidator;
import Validators.PinSize;
import Validators.Positivenumber;
import Validators.ValidPancard;

/*
 *********************************************************
 *  @Method Name    :   checkEmail
 *  @Author         :   Manish Kripalani (Manish.kripalani@antrazal.com)
 *  @Company        :   Antrazal
 *  @Description    :   This method validates the email address using the EmailValidator class.
 *  @param          :   email (String) - The email address to be validated
 *  @return         :   String - Validated email address
 *********************************************************
 */
public class BaseMiddleware {
    public static String checkEmail(String email) throws Exception {
        try {
            EmailValidator emailValidator = new EmailValidator(email, " email ");
            return emailValidator.Validator(); // Validate the email and return the result
        } catch (Exception e) {
            throw e; // Propagate exception if validation fails
        }
    }

    /*
     *********************************************************
     * @Method Name : checkName
     * @Author : Manish Kripalani (Manish.kripalani@antrazal.com)
     * @Company : Antrazal
     * @Description : This method validates the name using the InputValidator class.
     * @param : name (String) - The name to be validated
     * @return : String - Validated name
     *********************************************************
     */
    public static String checkName(String name) throws Exception {
        String namecheck;
        try {
            InputValidator input = new InputValidator(name, " name ");
            namecheck = input.Validator();
        } catch (Exception e) {
            throw e;
        }
        return namecheck;
    }

    /*
     *********************************************************
     * @Method Name : checkUserName
     * @Author : Manish Kripalani (Manish.kripalani@antrazal.com)
     * @Company : Antrazal
     * @Description : This method validates the username using the InputValidator class.
     * @param : username (String) - The username to be validated
     * @return : String - Validated username
     *********************************************************
     */
    public static String checkUserName(String username) throws Exception {
        String usernamenamecheck;
        try {
            InputValidator input = new InputValidator(username, " username ");
            usernamenamecheck = input.Validator();
        } catch (Exception e) {
            throw e;
        }
        return usernamenamecheck;
    }

    /*
     *********************************************************
     * @Method Name : checkPassword
     * @Author : Manish Kripalani (Manish.kripalani@antrazal.com)
     * @Company : Antrazal
     * @Description : This method validates the password using the PasswordValidator class.
     * @param : password (String) - The password to be validated
     * @return : String - Validated password
     *********************************************************
     */
    public static String checkPassword(String password) throws Exception {
        String passwordCheck;
        try {
            PasswordValidator passwordValidator = new PasswordValidator(password, "passwordCheck");
            passwordCheck = passwordValidator.Validator();
        } catch (Exception e) {
            throw e;
        }
        return passwordCheck;
    }

    /*
     *********************************************************
     * @Method Name : checkPancard
     * @Author : Manish Kripalani (Manish.kripalani@antrazal.com)
     * @Company : Antrazal
     * @Description : This method validates the PAN card number using the ValidPancard class.
     * @param : pancard (String) - The PAN card number to be validated
     * @return : String - Validated PAN card number
     *********************************************************
     */
    public static String checkPancard(String pancard) throws Exception {
        String pancardCheck;
        try {
            ValidPancard validpancard = new ValidPancard(pancard, "pancardCheck");
            pancardCheck = validpancard.Validator();
        } catch (Exception e) {
            throw e;
        }
        return pancardCheck;
    }

    /*
     *********************************************************
     * @Method Name : positivenumber
     * @Author : Manish Kripalani (Manish.kripalani@antrazal.com)
     * @Company : Antrazal
     * @Description : This method validates that the number is positive using the Positivenumber class.
     * @param : number (Integer) - The number to be validated
     * @return : Integer - Validated positive number
     *********************************************************
     */
    public static Integer positivenumber(Integer number) throws Exception {
        Integer positivenumberCheck;
        try {
            Positivenumber validpositivenumber = new Positivenumber(number, " number");
            positivenumberCheck = validpositivenumber.Validator();
        } catch (Exception e) {
            throw e;
        }
        return positivenumberCheck;
    }

    /*
     *********************************************************
     * @Method Name : Initialamount
     * @Author : Manish Kripalani (Manish.kripalani@antrazal.com)
     * @Company : Antrazal
     * @Description : This method validates the initial amount against a bank amount
     * using the ParamChecker class.
     * @param : number (Integer), bankamount (Integer) - Amounts to be validated
     * @return : Object - Validated result based on the comparison
     *********************************************************
     */
    public static Object Initialamount(Integer number, Integer bankamount) throws Exception {
        Object positivenumberCheck;
        try {
            ParamChecker paramChecker = new ParamChecker(number, bankamount);
            positivenumberCheck = paramChecker.Validator();
        } catch (Exception e) {
            throw e;
        }
        return positivenumberCheck;
    }

    /*
     *********************************************************
     * @Method Name : pinsize
     * @Author : Manish Kripalani (Manish.kripalani@antrazal.com)
     * @Company : Antrazal
     * @Description : This method validates the size of a PIN using the PinSize class.
     * @param : pin (Integer) - The PIN to be validated
     * @return : Integer - Validated PIN
     *********************************************************
     */
    public static Integer pinsize(Integer pin) throws Exception {
        Integer pincheck;
        try {
            PinSize validpin = new PinSize(pin, " number");
            pincheck = validpin.Validator();
        } catch (Exception e) {
            throw e;
        }
        return pincheck;
    }

    /*
     *********************************************************
     * @Method Name : checkAccountnumber
     * @Author : Manish Kripalani (Manish.kripalani@antrazal.com)
     * @Company : Antrazal
     * @Description : This method validates the account number using the InputValidator class.
     * @param : accountnumber (String) - The account number to be validated
     * @return : String - Validated account number
     *********************************************************
     */
    public static String checkAccountnumber(String accountnumber) throws Exception {
        String checkAccountnumber;
        try {
            InputValidator input = new InputValidator(accountnumber, " accountnumber ");
            checkAccountnumber = input.Validator();
        } catch (Exception e) {
            throw e;
        }
        return checkAccountnumber;
    }

    /*
     *********************************************************
     * @Method Name : checkAddress
     * @Author : Manish Kripalani (Manish.kripalani@antrazal.com)
     * @Company : Antrazal
     * @Description : This method validates the address using the AddressValidator class.
     * @param : address (String) - The address to be validated
     * @return : String - Validated address
     *********************************************************
     */
    public static String checkAddress(String address) throws Exception {
        String checkAddress;
        try {
            AddressValidator addressValidator = new AddressValidator(address, "checkAddress");
            checkAddress = addressValidator.Validator();
        } catch (Exception e) {
            throw e;
        }
        return checkAddress;
    }
}
