package view;

import Middleware.AdminMiddleware; // Importing middleware for admin operations
import Utils.Constant; // Importing constants for messages
import Utils.Sout; // Importing utility for output operations
import Utils.TakingInput; // Importing utility for taking user input

public class Adminview {

    /*
     *********************************************************
     *  @Method Name    :   adminLogin
     *  @Description    :   This method handles the admin login process.
     *                      It collects admin details and calls the middleware for validation.
     *  @param          :   dbname - Name of the database
     *  @return         :   void
     *********************************************************
     */
    public static void adminLogin(String dbname) {
        try {
       
            Sout.print(Constant.ADMINEMAIL); // Prompt for admin email
            String email = TakingInput.input().nextLine(); // Read admin email
            Sout.print(Constant.ADMINNAME); // Prompt for admin name
            String name1 = TakingInput.input().nextLine();
            Sout.print(Constant.ADMINUSERNAME); // Prompt for admin username
            String username = TakingInput.input().nextLine(); // Read admin username
            Sout.print(Constant.ADMINPASSWORD); // Prompt for admin password
            String password = TakingInput.input().nextLine(); // Read admin password
            
            AdminMiddleware.AdminMiddlewarelogin(name1, username, password, email, dbname); // Call middleware for login
        } catch (Exception e) {
            System.out.println(e.getMessage()); // Print error message
            adminLogin(dbname); // Recursive call to handle input again
        }
    }

    /*
     *********************************************************
     *  @Method Name    :   adminSignIn
     *  @Description    :   This method handles the admin signup process.
     *                      It collects admin details and calls the middleware for processing.
     *  @param          :   dbname - Name of the database
     *                      amount - Validated amount for operations
     *  @return         :   void
     *********************************************************
     */
    public static void adminSignIn(String dbname, Integer amount) throws Exception {
        try {
            Sout.print(Constant.USERNAME); // Prompt for username
            String username = TakingInput.input().nextLine(); // Read username
            Sout.print(Constant.PASSWORD); // Prompt for password
            String password = TakingInput.input().nextLine(); // Read password
            Sout.print(Constant.EMAIL); // Prompt for email
            String email = TakingInput.input().nextLine(); // Read email
            AdminMiddleware.AdminMiddlewaresignup(dbname, amount, username, password, email); // Call middleware for signup
        } catch (Exception e) {
            throw e; // Rethrow exception for higher-level handling
        }
    }

    /*
     *********************************************************
     *  @Method Name    :   adminFunction
     *  @Description    :   This method presents the admin with options to perform various functions.
     *                      It calls the middleware based on the chosen option.
     *  @param          :   dbname - Name of the database
     *                      amount - Validated amount for operations
     *  @return         :   void
     *********************************************************
     */
    public static void adminFunction(String dbname, Integer amount) {
        try {
            Constant.Adminoption(); // Display admin options
            String option = TakingInput.input().nextLine(); // Take user input for option
            AdminMiddleware.chooseOption(option, dbname, amount); // Call middleware for selected option
        } catch (Exception e) {
            System.out.println(e.getMessage()); // Print error message
            adminFunction(dbname, amount); // Recursive call to handle input again
        }
    }

    /*
     *********************************************************
     *  @Method Name    :   createManagermail
     *  @Description    :   This method collects data to create a manager's email and calls the middleware.
     *  @param          :   dbname - Name of the database
     *                      amount - Validated amount for operations
     *  @return         :   void
     *********************************************************
     */
    public static void createManagermail(String dbname, Integer amount) throws Exception {
        try {
            Sout.print(Constant.NAME); // Prompt for manager's name
            String name = TakingInput.input().nextLine(); // Read name
            Sout.print(Constant.EMAIL); // Prompt for email
            String email = TakingInput.input().nextLine(); // Read email
            Sout.print(Constant.BRANCHNAME); // Prompt for branch name
            String branchname = TakingInput.input().nextLine(); // Read branch name
            AdminMiddleware.validateManageremail(name, email, branchname, dbname, amount); // Call middleware to validate email
        } catch (Exception e) {
            throw e; // Rethrow exception for higher-level handling
        }
    }

    /*
     *********************************************************
     *  @Method Name    :   createBranch
     *  @Description    :   This method collects data to create a new branch and calls the middleware.
     *  @param          :   dbname - Name of the database
     *                      amount - Validated amount for operations
     *  @return         :   void
     *********************************************************
     */
    public static void createBranch(String dbname, Integer amount) throws Exception {
        try {
            Sout.print(Constant.BRANCHNAME); // Prompt for branch name
            String branchname = TakingInput.input().nextLine(); // Read branch name
            
            Sout.print(Constant.CITY); // Prompt for city
            String city = TakingInput.input().nextLine(); // Read city

            Sout.print(Constant.ADDRESS); // Prompt for address
            String address = TakingInput.input().nextLine(); // Read address

            AdminMiddleware.checkName(dbname, amount, branchname, city, address); // Call middleware to create branch
        } catch (Exception e) {
            throw e; // Rethrow exception for higher-level handling
        }
    }

    /*
     *********************************************************
     *  @Method Name    :   createCashieremail
     *  @Description    :   This method collects data to create a cashier's email and calls the middleware.
     *  @param          :   dbname - Name of the database
     *                      amount - Validated amount for operations
     *  @return         :   void
     *********************************************************
     */
    public static void createCashieremail(String dbname, Integer amount) throws Exception {
        try {
            Sout.print(Constant.NAME); // Prompt for cashier's name
            String name = TakingInput.input().nextLine(); // Read name
            Sout.print(Constant.EMAIL); // Prompt for email
            String email = TakingInput.input().nextLine(); // Read email
            Sout.print(Constant.BRANCHNAME); // Prompt for branch name
            String branchname = TakingInput.input().nextLine(); // Read branch name
            AdminMiddleware.validateCashieremail(name, email, branchname, dbname, amount); // Call middleware to validate email
        } catch (Exception e) {
            throw e; // Rethrow exception for higher-level handling
        }
    }
}
