package view;


import Middleware.ManagerMiddleware; // Importing middleware for manager operations
import Utils.Constant;                // Importing constants for messages
import Utils.Sout;                    // Importing utility for output operations
import Utils.TakingInput;             // Importing utility for taking user input

public class ManagerView {

     public static String takingEmail() throws Exception {
        String email = "";
        while (true) {
            try {
                System.out.print(Constant.ADMINEMAIL);
                email = TakingInput.input().nextLine(); // Read input
                email = ManagerMiddleware.checkEmail(email); // Validate email
                break; // Exit loop if email is valid
            } catch (Exception e) {
                System.out.println(e.getMessage()); // Show error message and re-prompt
            }
        }
        return email;
    }

    public static String takingLoanNumber() throws Exception {
        String loanNumber = "";
        while (true) {
            try {
                System.out.print(Constant.LOANNUMBER);
                loanNumber = TakingInput.input().nextLine();
                loanNumber = ManagerMiddleware.checkPancard(loanNumber); // Assuming checkPancard was a mistake here
                break; // Exit the loop if loan number is valid
            } catch (Exception e) {
                System.out.println(e.getMessage()); // Display the error message and prompt again
            }
        }
        return loanNumber;
    }
    
    public static String takingPancard() throws Exception {
        String pancard = "";
        while (true) {
            try {
                System.out.print(Constant.PANCARD);
                pancard = TakingInput.input().nextLine();
                pancard = ManagerMiddleware.checkPancard(pancard);
                break; // Exit loop if pancard is valid
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return pancard;
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
    
    public static String takingName() throws Exception {
        String name = "";
        while (true) {
            try {
                System.out.print(Constant.NAME);
                name = TakingInput.input().nextLine();
                name = ManagerMiddleware.checkName(name);
                break; // Exit loop if name is valid
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return name;
    }
    
    public static String takingBranchName() throws Exception {
        String branchName = "";
        while (true) {
            try {
                System.out.print(Constant.BRANCHNAME);
                branchName = TakingInput.input().nextLine();
                branchName = ManagerMiddleware.checkName(branchName);
                break; // Exit loop if branch name is valid
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return branchName;
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
    

    public static Integer takingInitialAmount(Integer amountValid) {
        Integer amount = 0;
        while (true) {
            try {
                System.out.print(Constant.POSITIVEAMOUNT);
                amount = TakingInput.input().nextInt();
                amount = (Integer) ManagerMiddleware.Initialamount(amount, amountValid);
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
            String email = takingEmail();
            String username = takingUsername();
            String password = takingPassword();
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
            String email = takingEmail();
            String username = takingUsername();
            String password = takingPassword();
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
            
            String branchName = takingBranchName();
            String name = takingName();
            String pancard =  takingPancard();
            String email = takingEmail();
            Integer amount = takingInitialAmount(amountvalid);
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
            String branchName = takingBranchName();
            String name = takingName();
            String name1 = takingName();
            String pancard =  takingPancard();
            String pancard1 = takingPancard();
            Integer amount = takingInitialAmount(amountvalid);
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
            String name = takingName();
            String email = takingEmail();
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
         
            String pancard = takingPancard();
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
           
            String loannumber = takingLoanNumber();
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
  
            String pancard = takingPancard();
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
           
            String accountNumber = takingAccountNumber();
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
