package view;

import Middleware.ManagerMiddleware; // Importing middleware for manager operations
import Utils.Constant; // Importing constants for messages
import Utils.Sout; // Importing utility for output operations
import Utils.TakingInput; // Importing utility for taking user input
/*
*********************************************************************************************************
 *  @Java Class Name :   ManagerView
 *  @Author          :   Manish Kripalani (Manish.kripalani@antrazal.com)
 *  @Company         :   Antrazal
 *  @Date            :   17-09-2024
 *  @Description     :   This class contains a view functionality.
 *******************************************************************************************************
 *  AWC ID     Developer                                             	  	TITLE  
 *  1633      <Manish Kripalani>(manish.kripalani@antrazal.com)      JAVA ASSIGNMENT
********************************************************************************************************
*/
public class ManagerView {
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
/*
*********************************************************
 *  @Method Name    :   takingLoanNumber
 *  @Author         :   Manish Kripalani (Manish.kripalani@antrazal.com)
 *  @Company        :   Antrazal
 *  @Description    :   This method prompts the user to enter a loan number. 
 *                      It repeatedly asks for the loan number until a valid one is provided.
 *                      The loan number is validated by the ManagerMiddleware.
 *  @return         :   String - Valid loan number
 *********************************************************
 */
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
/*
*********************************************************
 *  @Method Name    :   takingPancard
 *  @Author         :   Manish Kripalani (Manish.kripalani@antrazal.com)
 *  @Company        :   Antrazal
 *  @Description    :   This method prompts the user to enter a PAN card number. 
 *                      It repeatedly asks for the PAN card number until a valid one is provided.
 *                      The PAN card number is validated by the ManagerMiddleware.
 *  @return         :   String - Valid PAN card number
 *********************************************************
 */
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
 *  @Method Name    :   takingName
 *  @Author         :   Manish Kripalani (Manish.kripalani@antrazal.com)
 *  @Company        :   Antrazal
 *  @Description    :   This method prompts the user to enter a name. 
 *                      It repeatedly asks for the name until a valid one is provided.
 *                      The name is validated by the ManagerMiddleware.
 *  @return         :   String - Valid name
 *********************************************************
 */
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
/*
*********************************************************
 *  @Method Name    :   takingBranchName
 *  @Author         :   Manish Kripalani (Manish.kripalani@antrazal.com)
 *  @Company        :   Antrazal
 *  @Description    :   This method prompts the user to enter a branch name. 
 *                      It repeatedly asks for the branch name until a valid one is provided.
 *                      The branch name is validated by the ManagerMiddleware.
 *  @return         :   String - Valid branch name
 *********************************************************
 */
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
 *  @Method Name    :   takingInitialAmount
 *  @Author         :   Manish Kripalani (Manish.kripalani@antrazal.com)
 *  @Company        :   Antrazal
 *  @Description    :   This method prompts the user to enter the initial amount.
 *                      It repeatedly asks for the amount until a valid value is provided.
 *                      The amount is validated against a pre-defined valid amount by the ManagerMiddleware.
 *  @param          :   amountValid (Integer) - The pre-defined valid amount
 *  @return         :   Integer - Valid initial amount
 *********************************************************
 */
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
     * @Method Name : managerSignInandSignUp
     * @Description : This method handles the sign-in and sign-up process for the manager.
     * It prompts the user for an option and validates it using middleware.
     * @param : databaseName - Name of the database
     *          amountvalid - Validated amount for operations
     * @return : void
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
     * @Method Name : usernameexit
     * @Description : This method handles the process when the username exists. It collects email, username, and password, then calls the middleware.
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
            ManagerMiddleware.managerexit(email, username, password, databaseName, amountvalid); // Call middleware
        } catch (Exception e) {
            throw e; // Rethrow exception for higher-level handling
        }
    }

    /*
     *********************************************************
     * @Method Name : usernamenotexit
     * @Description : This method handles the process when the username does not exist. It collects email, username, and password, then calls the middleware.
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
            ManagerMiddleware.managernotexit(email, username, password, databaseName, amountvalid); // Call middleware
        } catch (Exception e) {
            throw e; // Rethrow exception for higher-level handling
        }
    }

    /*
     *********************************************************
     * @Method Name : managerfunction
     * @Description : This method presents the manager with options to perform various functions. It calls the middleware based on the chosen option.
     * @param : databaseName - Name of the database
     *          amountvalid - Validated amount for operations
     * @return : void
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
     * @Method Name : createSingleAccount
     * @Description : This method collects data to create a single account and calls
     * the middleware.
     * @param : databaseName - Name of the database
     *          amountvalid - Validated amount for operations
     * @return : void
     *********************************************************
     */
    public static void createSingleAccount(String databaseName, Integer amountvalid) throws Exception {
        try {

            String branchName = takingBranchName();
            String name = takingName();
            String pancard = takingPancard();
            String email = takingEmail();
            Integer amount = takingInitialAmount(amountvalid);
            ManagerMiddleware.createSingleAccount(databaseName, amountvalid, branchName, name, pancard, email, amount); // Call
                                                                                                                        // middleware
        } catch (Exception e) {
            throw e; // Rethrow exception for higher-level handling
        }
    }

    /*
     *********************************************************
     * @Method Name : createJointAccount
     * @Description : This method collects data to create a joint account and calls the middleware.
     * @param : databaseName - Name of the database
     *          amountvalid - Validated amount for operations
     * @return : void
     *********************************************************
     */
    public static void createJointAccount(String databaseName, Integer amountvalid) throws Exception {
        try {
            String branchName = takingBranchName();
            String name = takingName();
            String name1 = takingName();
            String pancard = takingPancard();
            String pancard1 = takingPancard();
            Integer amount = takingInitialAmount(amountvalid);
            ManagerMiddleware.createJointAccount(databaseName, amountvalid, branchName, name, name1, pancard, pancard1,
                    amount); // Call middleware
        } catch (Exception e) {
            throw e; // Rethrow exception for higher-level handling
        }
    }

    /*
     *********************************************************
     * @Method Name : updation
     * @Description : This method collects data for updating customer information.
     * @param : databaseName - Name of the database
     *          amountvalid - Validated amount for operations
     * @return : void
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
     * @Method Name : softDelete
     * @Description : This method handles the soft deletion of a customer account based on PAN card number.
     * @param : databaseName - Name of the database
     *           amountvalid - Validated amount for operations
     * @return : void
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
     * @Method Name : approvedLoan
     * @Description : This method handles the approval or rejection of loans.
     * @param : databaseName - Name of the database
     *          amountvalid - Validated amount for operations
     * @return : void
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
     * @Method Name : CustomerInformation
     * @Description : This method retrieves customer information based on PAN card
     * number.
     * @param : databaseName - Name of the database
     *          amountvalid - Validated amount for operations
     * @return : void
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
     * @Method Name : undoLastTransaction
     * @Description : This method allows the manager to undo the last transaction
     * based on account number.
     * @param : databaseName - Name of the database
     *          amountvalid - Validated amount for operations
     * @return : void
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
     * @Method Name : printCustomerInformationl
     * @Description : This method prints customer information and calls the manager function.
     * @param : string - Information to print
     *          databaseName - Name of the database
     *          amountvalid - Validated amount for operations
     * @return : void
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
