package view;

import Middleware.CustomerMiddleware; // Importing middleware for customer operations
import Middleware.ManagerMiddleware;
import Utils.Constant; // Importing constants for messages
import Utils.TakingInput; // Importing utility for taking user input
/*
*********************************************************************************************************
 *  @Java Class Name :   CustomerView
 *  @Author          :   Manish Kripalani (Manish.kripalani@antrazal.com)
 *  @Company         :   Antrazal
 *  @Date            :   17-09-2024
 *  @Description     :   This class contains a view functionality.
 *******************************************************************************************************
 *  AWC ID     Developer                                             	  	TITLE  
 *  1633      <Manish Kripalani>(manish.kripalani@antrazal.com)      JAVA ASSIGNMENT
********************************************************************************************************
*/
public class CustomerView {
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
                email = CustomerMiddleware.checkEmail(email); // Validate email
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
 *  @Method Name    :   takingPin
 *  @Author         :   Manish Kripalani (Manish.kripalani@antrazal.com)
 *  @Company        :   Antrazal
 *  @Description    :   This method prompts the user to enter a PIN. 
 *                      It repeatedly asks for the PIN until a valid one is provided.
 *                      The PIN is validated by the CustomerMiddleware for correct size.
 *  @return         :   Integer - Valid PIN
 *********************************************************
 */
    public static Integer takingPin() {
        Integer pin = 0;
        while (true) {
            try {
                System.out.print(Constant.PIN);
                pin = TakingInput.input().nextInt(); // Get pin input
                pin = (Integer) CustomerMiddleware.pinsize(pin); // Validate pin size
                break; // Exit loop if pin is valid
            } catch (Exception e) {
                System.out.println(e.getMessage()); // Display error message and prompt again
            }
        }
        return pin;
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
                username = ManagerMiddleware.checkName(username);
                break; // Exit loop if username is valid
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return username;
    }

    /*
     *********************************************************
     * @Method Name : customerSignInandSignup
     * @Description : This method handles the customer sign-in and sign-up process.It prompts the user for an option and validates it using middleware.
     * @param : databaseName - Name of the database
     *          amountvalid - Validated amount for operations
     * @return : void
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
     * @Method Name : usernameexit
     * @Description : This method handles the process when the username exists.It collects email, username, and password, then calls the middleware.
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
            CustomerMiddleware.customerexit(email, username, password, databaseName, amountvalid); // Call middleware
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
            CustomerMiddleware.customernotexit(email, username, password, databaseName, amountvalid); // Call middleware
        } catch (Exception e) {
            throw e; // Rethrow exception for higher-level handling
        }
    }

    /*
     *********************************************************
     * @Method Name : customerFunction
     * @Description : This method presents the customer with options to perform various functions.It calls the middleware based on the chosen option.
     * @param : databasename - Name of the database
     *           amountvalid - Validated amount for operations
     * @return : void
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
     * @Method Name : createPinSingle
     * @Description : This method collects data to create a PIN for a single account and calls the middleware.
     * @param : databasename - Name of the database
     *          amountvalid - Validated amount for operations
     * @return : void
     *********************************************************
     */
    public static void createPinSingle(String databasename, Integer amountvalid) throws Exception {
        try {

            String accountNumber = takingAccountNumber();
            Integer pin = takingPin();
            CustomerMiddleware.createPinSingle(accountNumber, pin, databasename, amountvalid); // Call middleware
        } catch (Exception e) {
            throw e; // Rethrow exception for higher-level handling
        }
    }

    /*
     *********************************************************
     * @Method Name : createPinJoint
     * @Description : This method collects data to create a PIN for a joint account and calls the middleware.
     * @param : databasename - Name of the database
     *           amountvalid - Validated amount for operations
     * @return : void
     *********************************************************
     */
    public static void createPinJoint(String databasename, Integer amountvalid) throws Exception {
        try {
            String accountNumber = takingAccountNumber();
            Integer pin = takingPin();
            CustomerMiddleware.createPinJoint(accountNumber, pin, databasename, amountvalid); // Call middleware
        } catch (Exception e) {
            throw e; // Rethrow exception for higher-level handling
        }
    }

    /*
     *********************************************************
     * @Method Name : withdrawSingle
     * @Description : This method handles the withdrawal process for a single account. It collects necessary data and calls the middleware.
     * @param : databasename - Name of the database
     *          amountvalid - Validated amount for operations
     * @return : void
     *********************************************************
     */
    public static void withdrawSingle(String databasename, Integer amountvalid) throws Exception {
        try {
            String accountNumber = takingAccountNumber();
            Integer pin = takingPin();
            Integer amount = takingPositiveAmount();
            CustomerMiddleware.withdrawSingle(accountNumber, pin, amount, databasename, amountvalid); // Call middleware
        } catch (Exception e) {
            throw e; // Rethrow exception for higher-level handling
        }
    }

    /*
     *********************************************************
     * @Method Name : withdrawJoint
     * @Description : This method handles the withdrawal process for a joint account. It collects necessary data and calls the middleware.
     * @param : databasename - Name of the database
     * amountvalid - Validated amount for operations
     * @return : void
     *********************************************************
     */
    public static void withdrawJoint(String databasename, Integer amountvalid) throws Exception {
        try {

            String accountNumber = takingAccountNumber();
            Integer pin = takingPin();

            Integer amount = takingPositiveAmount();
            CustomerMiddleware.withdrawJoint(accountNumber, pin, amount, databasename, amountvalid); // Call middleware
        } catch (Exception e) {
            throw e; // Rethrow exception for higher-level handling
        }
    }

    /*
     *********************************************************
     * @Method Name : loan
     * @Description : This method handles the process of applying for a loan. It collects necessary data and calls the middleware.
     * @param : databasename - Name of the database
     *          amountvalid - Validated amount for operations
     * @return : void
     *********************************************************
     */
    public static void loan(String databasename, Integer amountvalid) throws Exception {
        try {
            String panNumber = takingPancard();

            String loanNumber = takingAccountNumber();

            Integer loanAmount = takingPositiveAmount();
            CustomerMiddleware.createloan(panNumber, loanNumber, loanAmount, databasename, amountvalid); // Call
                                                                                                         // middleware
        } catch (Exception e) {
            throw e; // Rethrow exception for higher-level handling
        }
    }

    /*
     *********************************************************
     * @Method Name : printpassbook
     * @Description : This method prints the passbook information based on the PAN card number.
     * @param : databasename - Name of the database
     *          amountvalid - Validated amount for operations
     * @return : void
     *********************************************************
     */
    public static void printpassbook(String databasename, Integer amountvalid) throws Exception {
        try {
            String panNumber = takingPancard();
            CustomerMiddleware.printpassbook(panNumber, databasename, amountvalid); // Call middleware
        } catch (Exception e) {
            throw e; // Rethrow exception for higher-level handling
        }
    }
}
