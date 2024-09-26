package view;

import Middleware.AdminMiddleware;
import Middleware.CashierMiddleware; // Importing middleware for cashier operations
import Middleware.ManagerMiddleware;
import Utils.Constant;                // Importing constants for messages
import Utils.Sout;                    // Importing utility for output operations
import Utils.TakingInput;             // Importing utility for taking user input

public class CashierView {
    public static String takingEmail() throws Exception {
        String email = "";
        while (true) {
            try {
                System.out.print(Constant.ADMINEMAIL);
                email = TakingInput.input().nextLine(); // Read input
                email = CashierMiddleware.checkEmail(email); // Validate email
                break; // Exit loop if email is valid
            } catch (Exception e) {
                System.out.println(e.getMessage()); // Show error message and re-prompt
            }
        }
        return email;
    }
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
            String accountNumber = takingAccountNumber();
          
            Integer amount = takingPositiveAmount();// Read deposit amount
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
           
            String accountNumber = takingAccountNumber();
            Integer amount = takingPositiveAmount();// Read deposit amount
            CashierMiddleware.jointDeposite(databasename, amountvalid, amount, accountNumber); // Call middleware
        } catch (Exception e) {
            throw e; // Rethrow exception for higher-level handling
        }
    }
}
