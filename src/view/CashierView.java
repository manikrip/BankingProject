package view;

import Middleware.CashierMiddleware; // Importing middleware for cashier operations
import Middleware.ManagerMiddleware;
import Utils.Constant; // Importing constants for messages
import Utils.TakingInput; // Importing utility for taking user input
/*
*********************************************************************************************************
 *  @Java Class Name :   CashierView
 *  @Author          :   Manish Kripalani (Manish.kripalani@antrazal.com)
 *  @Company         :   Antrazal
 *  @Date            :   17-09-2024
 *  @Description     :   This class contains a view functionality.
 *******************************************************************************************************
 *  AWC ID     Developer                                             	  	TITLE  
 *  1633      <Manish Kripalani>(manish.kripalani@antrazal.com)      JAVA ASSIGNMENT
********************************************************************************************************
*/
public class CashierView {
    /*
*********************************************************
 *  @Method Name    :   takingEmail
 *  @Author         :   Manish Kripalani (Manish.kripalani@antrazal.com)
 *  @Company        :   Antrazal
 *  @Description    :   This method prompts the user to enter an email address. 
 *                      It repeatedly asks for the email until a valid one is provided.
 *                      The email is validated by the AdminMiddleware.
 *  @return         :   String - Valid email address
 *********************************************************
 */
    public static String takingEmail() throws Exception {
        String email = "";
        while (true) {
            try {
                System.out.print(Constant.EMAIL);
                email = TakingInput.input().nextLine(); // Read input
                email = CashierMiddleware.checkEmail(email); // Validate email
                break; // Exit loop if email is valid
            } catch (Exception e) {
                System.out.println(e.getMessage()); // Show error message and re-prompt
            }
        }
        return email;
    }
/*
*********************************************************
 *  @Method Name    :   takingAccountNumber
 *  @Author         :   Manish Kripalani (Manish.kripalani@antrazal.com)
 *  @Company        :   Antrazal
 *  @Description    :   This method prompts the user to enter an account number. 
 *                      It repeatedly asks for the account number until a valid one is provided.
 *                      The account number is validated by the ManagerMiddleware.
 *  @return         :   String - Valid account number
 *********************************************************
 */
    public static String takingAccountNumber() throws Exception {
        String accountNumber = "";
        while (true) {
            try {
                System.out.print(Constant.ACCOUNTNUMBER);
                accountNumber = TakingInput.input().nextLine();
                accountNumber = ManagerMiddleware.checkAccountnumber(accountNumber);
                break; // Exit loop if account number is valid
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return accountNumber;
    }
/*
*********************************************************
 *  @Method Name    :   takingPositiveAmount
 *  @Author         :   Manish Kripalani (Manish.kripalani@antrazal.com)
 *  @Company        :   Antrazal
 *  @Description    :   This method prompts the user to enter a positive amount.
 *                      It repeatedly asks for the amount until a valid positive value is provided.
 *                      The amount is validated by the ManagerMiddleware.
 *  @return         :   Integer - Valid positive amount
 *********************************************************
 */
    public static Integer takingPositiveAmount() {
        Integer amount = 0;
        while (true) {
            try {
                System.out.print(Constant.POSITIVEAMOUNT);
                amount = TakingInput.input().nextInt();
                amount = ManagerMiddleware.positivenumber(amount);
                break; // Exit loop if amount is valid
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return amount;
    }
/*
*********************************************************
 *  @Method Name    :   takingUsername
 *  @Author         :   Manish Kripalani (Manish.kripalani@antrazal.com)
 *  @Company        :   Antrazal
 *  @Description    :   This method prompts the user to enter a username. 
 *                      It repeatedly asks for the username until a valid one is provided.
 *                      The username is validated by the ManagerMiddleware.
 *  @return         :   String - Valid username
 *********************************************************
 */
    public static String takingUsername() throws Exception {
        String username = "";
        while (true) {
            try {
                System.out.print(Constant.USERNAME);
                username = TakingInput.input().nextLine();
                username = ManagerMiddleware.checkUserName(username);
                break; // Exit loop if username is valid
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return username;
    }
/*
*********************************************************
 *  @Method Name    :   takingPassword
 *  @Author         :   Manish Kripalani (Manish.kripalani@antrazal.com)
 *  @Company        :   Antrazal
 *  @Description    :   This method prompts the user to enter a password. 
 *                      It repeatedly asks for the password until a valid one is provided.
 *                      The password is validated by the ManagerMiddleware.
 *  @return         :   String - Valid password
 *********************************************************
 */
    public static String takingPassword() throws Exception {
        String password = "";
        while (true) {
            try {
                System.out.print(Constant.PASSWORD);
                password = TakingInput.input().nextLine();
                password = ManagerMiddleware.checkPassword(password);
                break; // Exit loop if password is valid
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return password;
    }

    /*
     *********************************************************
     * @Method Name : cashierSignInandSignup
     * @Description : This method handles the cashier sign-in and sign-up process. It prompts the user for an option and validates it using middleware.
     * @param : databaseName - Name of the database
     *          amountvalid - Validated amount for operations
     * @return : void
     *********************************************************
     */
    public static void cashierSignInandSignup(String databaseName, Integer amountvalid) throws Exception {
        try {
            Constant.LoginSingupOption(); // Display login/signup options
            String option = TakingInput.input().nextLine(); // Take user input for option
            CashierMiddleware.validateLoginOption(databaseName, amountvalid, option); // Validate the option
        } catch (Exception e) {
            throw e; // Rethrow exception for higher-level handling
        }
    }

    /*
     *********************************************************
     * @Method Name : usernameexit
     * @Description : This method handles the process when the cashier username exists.
     * It collects email, username, and password, then calls the middleware.
     * @param : databaseName - Name of the database
     *          amountvalid - Validated amount for operations
     * @return : void
     *********************************************************
     */
    public static void usernameexit(String databaseName, Integer amountvalid) throws Exception {
        try {
            String email = takingEmail();

            String username = takingUsername();

            String password = takingPassword();
            CashierMiddleware.cashierexit(email, username, password, databaseName, amountvalid); // Call middleware
        } catch (Exception e) {
            throw e; // Rethrow exception for higher-level handling
        }
    }

    /*
     *********************************************************
     * @Method Name : usernamenotexit
     * @Description : This method handles the process when the cashier username does not exist. It collects email, username, and password, then calls the middleware.
     * @param : databaseName - Name of the database
     *          amountvalid - Validated amount for operations
     * @return : void
     *********************************************************
     */
    public static void usernamenotexit(String databaseName, Integer amountvalid) throws Exception {
        try {
            String email = takingEmail();
            String username = takingUsername();
            String password = takingPassword();
            CashierMiddleware.cashiernotexit(email, username, password, databaseName, amountvalid); // Call middleware
        } catch (Exception e) {
            throw e; // Rethrow exception for higher-level handling
        }
    }

    /*
     *********************************************************
     * @Method Name : cashierFunction
     * @Description : This method presents the cashier with options to perform various functions. It calls the middleware based on the chosen option.
     * @param : databasename - Name of the database
     *           amountvalid - Validated amount for operations
     * @return : void
     *********************************************************
     */
    public static void cashierFunction(String databasename, Integer amountvalid) throws Exception {
        try {
            Constant.cashieroption(); // Display cashier options
            String option = TakingInput.input().nextLine(); // Take user input for option
            CashierMiddleware.cashierOption(databasename, amountvalid, option); // Call middleware
        } catch (Exception e) {
            System.out.println(e.getMessage()); // Print error message
            cashierFunction(databasename, amountvalid); // Recursive call to handle input again
        }
    }

    /*
     *********************************************************
     * @Method Name : singleAccountDeposite
     * @Description : This method collects data to deposit into a single account and calls the middleware.
     * @param : databasename - Name of the database
     *          amountvalid - Validated amount for operations
     * @return : void
     *********************************************************
     */
    public static void singleAccountDeposite(String databasename, Integer amountvalid) throws Exception {
        try {
            String accountNumber = takingAccountNumber();

            Integer amount = takingPositiveAmount();// Read deposit amount
            CashierMiddleware.singleDeposite(databasename, amountvalid, amount, accountNumber); // Call middleware
        } catch (Exception e) {
            throw e; // Rethrow exception for higher-level handling
        }
    }

    /*
     *********************************************************
     * @Method Name : jointAccountDeposite
     * @Description : This method collects data to deposit into a joint account and calls the middleware.
     * @param : databasename - Name of the database
     *           amountvalid - Validated amount for operations
     * @return : void
     *********************************************************
     */
    public static void jointAccountDeposite(String databasename, Integer amountvalid) throws Exception {
        try {

            String accountNumber = takingAccountNumber();
            Integer amount = takingPositiveAmount();// Read deposit amount
            CashierMiddleware.jointDeposite(databasename, amountvalid, amount, accountNumber); // Call middleware
        } catch (Exception e) {
            throw e; // Rethrow exception for higher-level handling
        }
    }
}
