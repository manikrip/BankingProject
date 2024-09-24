package view;

import Middleware.CashierMiddleware; // Importing middleware for cashier operations
import Utils.Constant;                // Importing constants for messages
import Utils.Sout;                    // Importing utility for output operations
import Utils.TakingInput;             // Importing utility for taking user input

public class CashierView {

    /*
     *********************************************************
     *  @Method Name    :   cashierSignInandSignup
     *  @Description    :   This method handles the cashier sign-in and sign-up process.
     *                      It prompts the user for an option and validates it using middleware.
     *  @param          :   databaseName - Name of the database
     *                      amountvalid - Validated amount for operations
     *  @return         :   void
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
     *  @Method Name    :   usernameexit
     *  @Description    :   This method handles the process when the cashier username exists.
     *                      It collects email, username, and password, then calls the middleware.
     *  @param          :   databaseName - Name of the database
     *                      amountvalid - Validated amount for operations
     *  @return         :   void
     *********************************************************
     */
    public static void usernameexit(String databaseName, Integer amountvalid) throws Exception {
        try {
            Sout.print(Constant.EMAIL); // Prompt for email
            String email = TakingInput.input().nextLine(); // Read email
            Sout.print(Constant.USERNAME); // Prompt for username
            String username = TakingInput.input().nextLine(); // Read username
            Sout.print(Constant.PASSWORD); // Prompt for password
            String password = TakingInput.input().nextLine(); // Read password
            CashierMiddleware.cashierexit(email, username, password, databaseName, amountvalid); // Call middleware
        } catch (Exception e) {
            throw e; // Rethrow exception for higher-level handling
        }
    }

    /*
     *********************************************************
     *  @Method Name    :   usernamenotexit
     *  @Description    :   This method handles the process when the cashier username does not exist.
     *                      It collects email, username, and password, then calls the middleware.
     *  @param          :   databaseName - Name of the database
     *                      amountvalid - Validated amount for operations
     *  @return         :   void
     *********************************************************
     */
    public static void usernamenotexit(String databaseName, Integer amountvalid) throws Exception {
        try {
            Sout.print(Constant.EMAIL); // Prompt for email
            String email = TakingInput.input().nextLine(); // Read email
            Sout.print(Constant.USERNAME); // Prompt for username
            String username = TakingInput.input().nextLine(); // Read username
            Sout.print(Constant.PASSWORD); // Prompt for password
            String password = TakingInput.input().nextLine(); // Read password
            CashierMiddleware.cashiernotexit(email, username, password, databaseName, amountvalid); // Call middleware
        } catch (Exception e) {
            throw e; // Rethrow exception for higher-level handling
        }
    }

    /*
     *********************************************************
     *  @Method Name    :   cashierFunction
     *  @Description    :   This method presents the cashier with options to perform various functions.
     *                      It calls the middleware based on the chosen option.
     *  @param          :   databasename - Name of the database
     *                      amountvalid - Validated amount for operations
     *  @return         :   void
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
     *  @Method Name    :   singleAccountDeposite
     *  @Description    :   This method collects data to deposit into a single account and calls the middleware.
     *  @param          :   databasename - Name of the database
     *                      amountvalid - Validated amount for operations
     *  @return         :   void
     *********************************************************
     */
    public static void singleAccountDeposite(String databasename, Integer amountvalid) throws Exception {
        try {
            Sout.print(Constant.ACCOUNTNUMBER); // Prompt for account number
            String accountNumber = TakingInput.input().nextLine(); // Read account number
            Sout.print(Constant.AMOUNT); // Prompt for deposit amount
            Integer amount = TakingInput.input().nextInt(); // Read deposit amount
            CashierMiddleware.singleDeposite(databasename, amountvalid, amount, accountNumber); // Call middleware
        } catch (Exception e) {
            throw e; // Rethrow exception for higher-level handling
        }
    }

    /*
     *********************************************************
     *  @Method Name    :   jointAccountDeposite
     *  @Description    :   This method collects data to deposit into a joint account and calls the middleware.
     *  @param          :   databasename - Name of the database
     *                      amountvalid - Validated amount for operations
     *  @return         :   void
     *********************************************************
     */
    public static void jointAccountDeposite(String databasename, Integer amountvalid) throws Exception {
        try {
            Sout.print(Constant.ACCOUNTNUMBER); // Prompt for account number
            String accountNumber = TakingInput.input().nextLine(); // Read account number
            Sout.print(Constant.AMOUNT); // Prompt for deposit amount
            Integer amount = TakingInput.input().nextInt(); // Read deposit amount
            CashierMiddleware.jointDeposite(databasename, amountvalid, amount, accountNumber); // Call middleware
        } catch (Exception e) {
            throw e; // Rethrow exception for higher-level handling
        }
    }
}
