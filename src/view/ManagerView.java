package view;

import Middleware.ManagerMiddleware; // Importing middleware for manager operations
import Utils.Constant;                // Importing constants for messages
import Utils.Sout;                    // Importing utility for output operations
import Utils.TakingInput;             // Importing utility for taking user input

public class ManagerView {

    /*
     *********************************************************
     *  @Method Name    :   managerSignInandSignUp
     *  @Description    :   This method handles the sign-in and sign-up process for the manager.
     *                      It prompts the user for an option and validates it using middleware.
     *  @param          :   databaseName - Name of the database
     *                      amountvalid - Validated amount for operations
     *  @return         :   void
     *********************************************************
     */
    public static void managerSignInandSignUp(String databaseName, Integer amountvalid) throws Exception {
        try {
            Constant.LoginSingupOption(); // Display login/signup options
            String option = TakingInput.input().nextLine(); // Take user input for option
            ManagerMiddleware.validateLoginOption(databaseName, amountvalid, option); // Validate the option
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
            ManagerMiddleware.managerexit(email, username, password, databaseName, amountvalid); // Call middleware
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
            ManagerMiddleware.managernotexit(email, username, password, databaseName, amountvalid); // Call middleware
        } catch (Exception e) {
            throw e; // Rethrow exception for higher-level handling
        }
    }

    /*
     *********************************************************
     *  @Method Name    :   managerfunction
     *  @Description    :   This method presents the manager with options to perform various functions.
     *                      It calls the middleware based on the chosen option.
     *  @param          :   databaseName - Name of the database
     *                      amountvalid - Validated amount for operations
     *  @return         :   void
     *********************************************************
     */
    public static void managerfunction(String databaseName, Integer amountvalid) {
        try {
            Constant.Manageroption(); // Display manager options
            String option = TakingInput.input().nextLine(); // Take user input for option
            ManagerMiddleware.ManagerOption(databaseName, amountvalid, option); // Call middleware
        } catch (Exception e) {
            System.out.println(e.getMessage()); // Print error message
            managerfunction(databaseName, amountvalid); // Recursive call to handle input again
        }
    }

    /*
     *********************************************************
     *  @Method Name    :   createSingleAccount
     *  @Description    :   This method collects data to create a single account and calls the middleware.
     *  @param          :   databaseName - Name of the database
     *                      amountvalid - Validated amount for operations
     *  @return         :   void
     *********************************************************
     */
    public static void createSingleAccount(String databaseName, Integer amountvalid) throws Exception {
        try {
            Sout.print(Constant.BRANCHNAME); // Prompt for branch name
            String branchName = TakingInput.input().nextLine(); // Read branch name
            Sout.print(Constant.NAME); // Prompt for account holder's name
            String name = TakingInput.input().nextLine(); // Read name
            Sout.print(Constant.PANCARD); // Prompt for PAN card number
            String pancard = TakingInput.input().nextLine(); // Read PAN card number
            Sout.print(Constant.EMAIL); // Prompt for email
            String email = TakingInput.input().nextLine(); // Read email
            Sout.print(Constant.AMOUNT); // Prompt for amount
            Integer amount = TakingInput.input().nextInt(); // Read amount
            ManagerMiddleware.createSingleAccount(databaseName, amountvalid, branchName, name, pancard, email, amount); // Call middleware
        } catch (Exception e) {
            throw e; // Rethrow exception for higher-level handling
        }
    }

    /*
     *********************************************************
     *  @Method Name    :   createJointAccount
     *  @Description    :   This method collects data to create a joint account and calls the middleware.
     *  @param          :   databaseName - Name of the database
     *                      amountvalid - Validated amount for operations
     *  @return         :   void
     *********************************************************
     */
    public static void createJointAccount(String databaseName, Integer amountvalid) throws Exception {
        try {
            Sout.print(Constant.BRANCHNAME); // Prompt for branch name
            String branchName = TakingInput.input().nextLine(); // Read branch name
            Sout.print(Constant.NAME); // Prompt for first account holder's name
            String name = TakingInput.input().nextLine(); // Read first name
            Sout.print(Constant.NAME); // Prompt for second account holder's name
            String name1 = TakingInput.input().nextLine(); // Read second name
            Sout.print(Constant.PANCARD); // Prompt for first PAN card number
            String pancard = TakingInput.input().nextLine(); // Read first PAN card number
            Sout.print(Constant.PANCARD); // Prompt for second PAN card number
            String pancard1 = TakingInput.input().nextLine(); // Read second PAN card number
            Sout.print(Constant.AMOUNT); // Prompt for amount
            Integer amount = TakingInput.input().nextInt(); // Read amount
            ManagerMiddleware.createJointAccount(databaseName, amountvalid, branchName, name, name1, pancard, pancard1, amount); // Call middleware
        } catch (Exception e) {
            throw e; // Rethrow exception for higher-level handling
        }
    }

    /*
     *********************************************************
     *  @Method Name    :   updation
     *  @Description    :   This method collects data for updating customer information.
     *  @param          :   databaseName - Name of the database
     *                      amountvalid - Validated amount for operations
     *  @return         :   void
     *********************************************************
     */
    public static void updation(String databaseName, Integer amountvalid) throws Exception {
        try {
            Sout.print(Constant.PANCARD); // Prompt for PAN card number
            String pancard = TakingInput.input().nextLine(); // Read PAN card number
            Sout.print(Constant.NAME); // Prompt for name
            String name = TakingInput.input().nextLine(); // Read name
            Sout.print(Constant.EMAIL); // Prompt for email
            String email = TakingInput.input().nextLine(); // Read email
            ManagerMiddleware.updationPancard(databaseName, amountvalid, pancard, name, email); // Call middleware
        } catch (Exception e) {
            throw e; // Rethrow exception for higher-level handling
        }
    }

    /*
     *********************************************************
     *  @Method Name    :   softDelete
     *  @Description    :   This method handles the soft deletion of a customer account based on PAN card number.
     *  @param          :   databaseName - Name of the database
     *                      amountvalid - Validated amount for operations
     *  @return         :   void
     *********************************************************
     */
    public static void softDelete(String databaseName, Integer amountvalid) throws Exception {
        try {
            Sout.print(Constant.PANCARD); // Prompt for PAN card number
            String pancard = TakingInput.input().nextLine(); // Read PAN card number
            ManagerMiddleware.softDelete(databaseName, amountvalid, pancard); // Call middleware
        } catch (Exception e) {
            throw e; // Rethrow exception for higher-level handling
        }
    }

    /*
     *********************************************************
     *  @Method Name    :   approvedLoan
     *  @Description    :   This method handles the approval or rejection of loans.
     *  @param          :   databaseName - Name of the database
     *                      amountvalid - Validated amount for operations
     *  @return         :   void
     *********************************************************
     */
    public static void approvedLoan(String databaseName, Integer amountvalid) throws Exception {
        try {
            Sout.print(Constant.LOANNUMBER); // Prompt for loan number
            String loannumber = TakingInput.input().nextLine(); // Read loan number
            Sout.print(Constant.APPROVEDREJECTED); // Prompt for approval/rejection status
            String approvedrejected = TakingInput.input().nextLine(); // Read approval/rejection input
            ManagerMiddleware.approvedLoan(databaseName, amountvalid, loannumber, approvedrejected); // Call middleware
        } catch (Exception e) {
            throw e; // Rethrow exception for higher-level handling
        }
    }

    /*
     *********************************************************
     *  @Method Name    :   CustomerInformation
     *  @Description    :   This method retrieves customer information based on PAN card number.
     *  @param          :   databaseName - Name of the database
     *                      amountvalid - Validated amount for operations
     *  @return         :   void
     *********************************************************
     */
    public static void CustomerInformation(String databaseName, Integer amountvalid) throws Exception {
        try {
            Sout.print(Constant.PANCARD); // Prompt for PAN card number
            String pancard = TakingInput.input().nextLine(); // Read PAN card number
            ManagerMiddleware.CustomerInformation(databaseName, amountvalid, pancard); // Call middleware
        } catch (Exception e) {
            throw e; // Rethrow exception for higher-level handling
        }
    }

    /*
     *********************************************************
     *  @Method Name    :   undoLastTransaction
     *  @Description    :   This method allows the manager to undo the last transaction based on account number.
     *  @param          :   databaseName - Name of the database
     *                      amountvalid - Validated amount for operations
     *  @return         :   void
     *********************************************************
     */
    public static void undoLastTransaction(String databaseName, Integer amountvalid) throws Exception {
        try {
            Sout.print(Constant.ACCOUNTNUMBER); // Prompt for account number
            String accountNumber = TakingInput.input().nextLine(); // Read account number
            ManagerMiddleware.undoLastTransaction(databaseName, amountvalid, accountNumber); // Call middleware
        } catch (Exception e) {
            throw e; // Rethrow exception for higher-level handling
        }
    }

    /*
     *********************************************************
     *  @Method Name    :   printCustomerInformationl
     *  @Description    :   This method prints customer information and calls the manager function.
     *  @param          :   string - Information to print
     *                      databaseName - Name of the database
     *                      amountvalid - Validated amount for operations
     *  @return         :   void
     *********************************************************
     */
    public static void printCustomerInformationl(String string, String databaseName, Integer amountvalid) {
        try {
            Sout.print(string); // Print the provided information
            ManagerView.managerfunction(databaseName, amountvalid); // Call manager function
        } catch (Exception e) {
            throw e; // Rethrow exception for higher-level handling
        }
    }
}
