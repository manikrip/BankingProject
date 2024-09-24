package view;

import Middleware.CustomerMiddleware; // Importing middleware for customer operations
import Utils.Constant;                // Importing constants for messages
import Utils.Sout;                    // Importing utility for output operations
import Utils.TakingInput;             // Importing utility for taking user input

public class CustomerView {

    /*
     *********************************************************
     *  @Method Name    :   customerSignInandSignup
     *  @Description    :   This method handles the customer sign-in and sign-up process.
     *                      It prompts the user for an option and validates it using middleware.
     *  @param          :   databaseName - Name of the database
     *                      amountvalid - Validated amount for operations
     *  @return         :   void
     *********************************************************
     */
    public static void customerSignInandSignup(String databaseName, Integer amountvalid) throws Exception {
        try {
            Constant.LoginSingupOption(); // Display login/signup options
            String option = TakingInput.input().nextLine(); // Take user input for option
            CustomerMiddleware.validateLoginOption(databaseName, amountvalid, option); // Validate the option
        } catch (Exception e) {
            throw e; // Rethrow exception for higher-level handling
        }
    }

    /*
     *********************************************************
     *  @Method Name    :   usernameexit
     *  @Description    :   This method handles the process when the username exists.
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
            CustomerMiddleware.customerexit(email, username, password, databaseName, amountvalid); // Call middleware
        } catch (Exception e) {
            throw e; // Rethrow exception for higher-level handling
        }
    }

    /*
     *********************************************************
     *  @Method Name    :   usernamenotexit
     *  @Description    :   This method handles the process when the username does not exist.
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
            CustomerMiddleware.customernotexit(email, username, password, databaseName, amountvalid); // Call middleware
        } catch (Exception e) {
            throw e; // Rethrow exception for higher-level handling
        }
    }

    /*
     *********************************************************
     *  @Method Name    :   customerFunction
     *  @Description    :   This method presents the customer with options to perform various functions.
     *                      It calls the middleware based on the chosen option.
     *  @param          :   databasename - Name of the database
     *                      amountvalid - Validated amount for operations
     *  @return         :   void
     *********************************************************
     */
    public static void customerFunction(String databasename, Integer amountvalid) throws Exception {
        try {
            Constant.customeroption(); // Display customer options
            String option = TakingInput.input().nextLine(); // Take user input for option
            CustomerMiddleware.customerOption(databasename, amountvalid, option); // Call middleware
        } catch (Exception e) {
            System.out.println(e.getMessage()); // Print error message
            customerFunction(databasename, amountvalid); // Recursive call to handle input again
        }
    }

    /*
     *********************************************************
     *  @Method Name    :   createPinSingle
     *  @Description    :   This method collects data to create a PIN for a single account and calls the middleware.
     *  @param          :   databasename - Name of the database
     *                      amountvalid - Validated amount for operations
     *  @return         :   void
     *********************************************************
     */
    public static void createPinSingle(String databasename, Integer amountvalid) throws Exception {
        try {
            Sout.print(Constant.ACCOUNTNUMBER); // Prompt for account number
            String accountNumber = TakingInput.input().nextLine(); // Read account number
            Sout.print(Constant.PIN); // Prompt for PIN
            Integer pin = TakingInput.input().nextInt(); // Read PIN
            CustomerMiddleware.createPinSingle(accountNumber, pin, databasename, amountvalid); // Call middleware
        } catch (Exception e) {
            throw e; // Rethrow exception for higher-level handling
        }
    }

    /*
     *********************************************************
     *  @Method Name    :   createPinJoint
     *  @Description    :   This method collects data to create a PIN for a joint account and calls the middleware.
     *  @param          :   databasename - Name of the database
     *                      amountvalid - Validated amount for operations
     *  @return         :   void
     *********************************************************
     */
    public static void createPinJoint(String databasename, Integer amountvalid) throws Exception {
        try {
            Sout.print(Constant.ACCOUNTNUMBER); // Prompt for account number
            String accountNumber = TakingInput.input().nextLine(); // Read account number
            Sout.print(Constant.PIN); // Prompt for PIN
            Integer pin = TakingInput.input().nextInt(); // Read PIN
            CustomerMiddleware.createPinJoint(accountNumber, pin, databasename, amountvalid); // Call middleware
        } catch (Exception e) {
            throw e; // Rethrow exception for higher-level handling
        }
    }

    /*
     *********************************************************
     *  @Method Name    :   withdrawSingle
     *  @Description    :   This method handles the withdrawal process for a single account.
     *                      It collects necessary data and calls the middleware.
     *  @param          :   databasename - Name of the database
     *                      amountvalid - Validated amount for operations
     *  @return         :   void
     *********************************************************
     */
    public static void withdrawSingle(String databasename, Integer amountvalid) throws Exception {
        try {
            Sout.print(Constant.ACCOUNTNUMBER); // Prompt for account number
            String accountNumber = TakingInput.input().nextLine(); // Read account number
            Sout.print(Constant.PIN); // Prompt for PIN
            Integer pin = TakingInput.input().nextInt(); // Read PIN
            Sout.print(Constant.AMOUNT); // Prompt for withdrawal amount
            Integer amount = TakingInput.input().nextInt(); // Read withdrawal amount
            CustomerMiddleware.withdrawSingle(accountNumber, pin, amount, databasename, amountvalid); // Call middleware
        } catch (Exception e) {
            throw e; // Rethrow exception for higher-level handling
        }
    }

    /*
     *********************************************************
     *  @Method Name    :   withdrawJoint
     *  @Description    :   This method handles the withdrawal process for a joint account.
     *                      It collects necessary data and calls the middleware.
     *  @param          :   databasename - Name of the database
     *                      amountvalid - Validated amount for operations
     *  @return         :   void
     *********************************************************
     */
    public static void withdrawJoint(String databasename, Integer amountvalid) throws Exception {
        try {
            Sout.print(Constant.ACCOUNTNUMBER); // Prompt for account number
            String accountNumber = TakingInput.input().nextLine(); // Read account number
            Sout.print(Constant.PIN); // Prompt for PIN
            Integer pin = TakingInput.input().nextInt(); // Read PIN
            Sout.print(Constant.AMOUNT); // Prompt for withdrawal amount
            Integer amount = TakingInput.input().nextInt(); // Read withdrawal amount
            CustomerMiddleware.withdrawJoint(accountNumber, pin, amount, databasename, amountvalid); // Call middleware
        } catch (Exception e) {
            throw e; // Rethrow exception for higher-level handling
        }
    }

    /*
     *********************************************************
     *  @Method Name    :   loan
     *  @Description    :   This method handles the process of applying for a loan.
     *                      It collects necessary data and calls the middleware.
     *  @param          :   databasename - Name of the database
     *                      amountvalid - Validated amount for operations
     *  @return         :   void
     *********************************************************
     */
    public static void loan(String databasename, Integer amountvalid) throws Exception {
        try {
            Sout.print(Constant.PANCARD); // Prompt for PAN card number
            String panNumber = TakingInput.input().nextLine(); // Read PAN card number
            Sout.print(Constant.LOANNUMBER); // Prompt for loan number
            String loanNumber = TakingInput.input().nextLine(); // Read loan number
            Sout.print(Constant.AMOUNT); // Prompt for loan amount
            Integer loanAmount = TakingInput.input().nextInt(); // Read loan amount
            CustomerMiddleware.createloan(panNumber, loanNumber, loanAmount, databasename, amountvalid); // Call middleware
        } catch (Exception e) {
            throw e; // Rethrow exception for higher-level handling
        }
    }

    /*
     *********************************************************
     *  @Method Name    :   printpassbook
     *  @Description    :   This method prints the passbook information based on the PAN card number.
     *  @param          :   databasename - Name of the database
     *                      amountvalid - Validated amount for operations
     *  @return         :   void
     *********************************************************
     */
    public static void printpassbook(String databasename, Integer amountvalid) throws Exception {
        try {
            Sout.print(Constant.PANCARD); // Prompt for PAN card number
            String panNumber = TakingInput.input().nextLine(); // Read PAN card number
            CustomerMiddleware.printpassbook(panNumber, databasename, amountvalid); // Call middleware
        } catch (Exception e) {
            throw e; // Rethrow exception for higher-level handling
        }
    }
}
