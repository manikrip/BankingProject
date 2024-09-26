/*********************************************************************************************************
 *  @Java Class Name :   ManagerMiddleware
 *  @Author          :   Manish Kripalani (Manish.kripalani@antrazal.com)
 *  @Company         :   Antrazal
 *  @Date            :   17-09-2024
 *  @Description     :   This class serves as middleware for managing manager-related operations,
 *                       including validating login options, creating accounts, and handling customer
 *                       information and loan approvals.
 *********************************************************************************************************/

package Middleware;

import Pojo.Customer;
import Pojo.Employee;
import Pojo.JointAccount;
import Pojo.Loan;
import Routing.ManagerRouting;
import Utils.AccountNumber;
import Utils.Constant;
import Utils.CustomException;

import view.HomePageview;
import view.ManagerView;

public class ManagerMiddleware extends BaseMiddleware {

    /*
     *********************************************************
     * @Method Name : validateLoginOption
     * 
     * @Author : Manish Kripalani (Manish.kripalani@antrazal.com)
     * 
     * @Company : Antrazal
     * 
     * @Description : Validates the login option for managers and calls the
     * appropriate routing method.
     * 
     * @param : databaseName (String) - The name of the database
     * amountvalid (Integer) - The amount validity check
     * option (String) - The selected option
     * 
     * @throws : Exception, CustomException - For various validation errors
     * 
     * @return : void
     *********************************************************
     */
    public static void validateLoginOption(String databaseName, Integer amountvalid, String option)
            throws Exception, CustomException {
        try {
            switch (option) {
                case "1":
                    ManagerView.usernameexit(databaseName, amountvalid);
                    break;
                case "2":
                    // Create a manager for a branch
                    ManagerView.usernamenotexit(databaseName, amountvalid);
                    break;
                default:
                    // Handle invalid option and retry
                    throw new CustomException(Constant.VALIDOPTION);
            }
        } catch (Exception e) {
            throw e;
        }
    }

    /*
     *********************************************************
     * @Method Name : managerexit
     * 
     * @Author : Manish Kripalani (Manish.kripalani@antrazal.com)
     * 
     * @Company : Antrazal
     * 
     * @Description : Handles the exit of a manager by validating the provided
     * email, username,
     * and password, then routing to the appropriate method.
     * 
     * @param : email (String) - The manager's email
     * username (String) - The manager's username
     * password (String) - The manager's password
     * dbname (String) - The database name
     * amount (Integer) - Amount validity check
     * 
     * @throws : Exception - For various validation errors
     * 
     * @return : void
     *********************************************************
     */
    public static void managerexit(String email, String username, String password, String dbname, Integer amount)
            throws Exception {
        try {

            Employee emp = new Employee("Manager", null, null, email, username, password);
            ManagerRouting.usernameexit(emp, dbname, amount);
        } catch (Exception e) {
            throw e;
        }
    }

    /*
     *********************************************************
     * @Method Name : managernotexit
     * 
     * @Author : Manish Kripalani (Manish.kripalani@antrazal.com)
     * 
     * @Company : Antrazal
     * 
     * @Description : Handles the creation of a new manager by validating the
     * provided details and
     * routing to the appropriate method.
     * 
     * @param : email (String) - The manager's email
     * username (String) - The manager's username
     * password (String) - The manager's password
     * dbname (String) - The database name
     * amount (Integer) - Amount validity check
     * 
     * @throws : Exception - For various validation errors
     * 
     * @return : void
     *********************************************************
     */
    public static void managernotexit(String email, String username, String password, String dbname, Integer amount)
            throws Exception {
        try {

            Employee emp = new Employee("Manager", null, null, email, username, password);
            ManagerRouting.usernamenotexit(emp, dbname, amount);
        } catch (Exception e) {
            throw e;
        }
    }

    /*
     *********************************************************
     * @Method Name : ManagerOption
     * 
     * @Author : Manish Kripalani (Manish.kripalani@antrazal.com)
     * 
     * @Company : Antrazal
     * 
     * @Description : Executes the selected option for manager functionalities.
     * 
     * @param : databaseName (String) - The name of the database
     * amountvalid (Integer) - The amount validity check
     * option (String) - The selected option
     * 
     * @throws : Exception, CustomException - For various validation errors
     * 
     * @return : void
     *********************************************************
     */
    public static void ManagerOption(String databaseName, Integer amountvalid, String option) throws Exception {
        try {
            switch (option) {
                case "1":
                    // Option 1: Create a new customer account
                    ManagerRouting.createSingleAccount(databaseName, amountvalid);
                    break;
                case "2":
                    // Option 2: Create a joint account
                    ManagerRouting.createJointAccount(databaseName, amountvalid);
                    break;
                case "3":
                    // Option 3: Update an existing customer account
                    ManagerRouting.updation(databaseName, amountvalid);
                    break;
                case "4":
                    // Option 4: Remove a customer account (soft delete)
                    ManagerRouting.softDelete(databaseName, amountvalid);
                    break;
                case "5":
                    // Option 5: Approve a customer loan
                    ManagerRouting.approvedLoan(databaseName, amountvalid);
                    break;
                case "6":
                    // Option 6: View account details using PAN card
                    ManagerRouting.CustomerInformation(databaseName, amountvalid);
                    break;
                case "7":
                    // Option 7: Undo the last transaction
                    ManagerRouting.undoLastTransaction(databaseName, amountvalid);
                    break;
                case "8":
                    // Option 8: Return to the home page
                    HomePageview.homePage(databaseName, amountvalid);
                    break;
                default:

                    throw new CustomException(Constant.VALIDOPTION);
            }
        } catch (Exception e) {
            throw e;
        }
    }

    /*
     *********************************************************
     * @Method Name : createSingleAccount
     * 
     * @Author : Manish Kripalani (Manish.kripalani@antrazal.com)
     * 
     * @Company : Antrazal
     * 
     * @Description : Creates a single customer account after validating all input
     * parameters.
     * 
     * @param : databaseName (String) - The name of the database
     * amountvalid (Integer) - The amount validity check
     * branchName (String) - The branch name for the account
     * name (String) - The name of the customer
     * pancard (String) - The customer's PAN card number
     * email (String) - The customer's email
     * amount (Integer) - The amount to deposit
     * 
     * @throws : Exception - For various validation errors
     * 
     * @return : void
     *********************************************************
     */
    public static void createSingleAccount(String databaseName, Integer amountvalid, String branchName, String name,
            String pancard, String email, Integer amount) throws Exception {
        try {

            String accountNumber = AccountNumber.generateRandomString();
            Customer customer = new Customer(name, email, branchName, pancard, accountNumber,
                    "True", null, amount);
            ManagerRouting.createSAccount(databaseName, amountvalid, customer);
        } catch (Exception e) {
            throw e;
        }
    }

    /*
     *********************************************************
     * @Method Name : createJointAccount
     * 
     * @Author : Manish Kripalani (Manish.kripalani@antrazal.com)
     * 
     * @Company : Antrazal
     * 
     * @Description : Creates a joint customer account after validating all input
     * parameters.
     * 
     * @param : databaseName (String) - The name of the database
     * amountvalid (Integer) - The amount validity check
     * branchName (String) - The branch name for the account
     * name (String) - The name of the first customer
     * name1 (String) - The name of the second customer
     * pancard (String) - The first customer's PAN card number
     * pancard1 (String) - The second customer's PAN card number
     * amount (Integer) - The amount to deposit
     * 
     * @throws : Exception - For various validation errors
     * 
     * @return : void
     *********************************************************
     */
    public static void createJointAccount(String databaseName, Integer amountvalid, String branchName, String name,
            String name1, String pancard, String pancard1, Integer amount) throws Exception {
        try {

            String accountNumber = AccountNumber.generateRandomString();
            if (pancard.equals(pancard1)) {
                throw new CustomException(Constant.PANCARDDIFFERENT);
            } else {
                JointAccount jointAccount = new JointAccount(null, branchName, pancard, accountNumber, null,
                        amount);
                ManagerRouting.createJAccount(databaseName, amountvalid, jointAccount, pancard1, name, name1);
            }
        } catch (Exception e) {
            throw e;
        }
    }

    /*
     *********************************************************
     * @Method Name : updationPancard
     * 
     * @Author : Manish Kripalani (Manish.kripalani@antrazal.com)
     * 
     * @Company : Antrazal
     * 
     * @Description : Updates the PAN card information for a customer after
     * validation.
     * 
     * @param : databaseName (String) - The name of the database
     * amountvalid (Integer) - The amount validity check
     * pancard (String) - The customer's new PAN card number
     * name (String) - The customer's name
     * email (String) - The customer's email
     * 
     * @throws : Exception - For various validation errors
     * 
     * @return : void
     *********************************************************
     */
    public static void updationPancard(String databaseName, Integer amountvalid, String pancard, String name,
            String email) throws Exception {
        try {

            Customer customer = new Customer(name, email, null, pancard, null, null, null, null);
            ManagerRouting.updationPancard(databaseName, amountvalid, customer);
        } catch (Exception e) {
            throw e;
        }
    }

    /*
     *********************************************************
     * @Method Name : softDelete
     * 
     * @Author : Manish Kripalani (Manish.kripalani@antrazal.com)
     * 
     * @Company : Antrazal
     * 
     * @Description : Performs a soft delete on a customer account using the
     * provided PAN card number.
     * 
     * @param : databaseName (String) - The name of the database
     * amountvalid (Integer) - The amount validity check
     * pancard (String) - The PAN card number of the customer
     * 
     * @throws : Exception - For various validation errors
     * 
     * @return : void
     *********************************************************
     */
    public static void softDelete(String databaseName, Integer amountvalid, String pancard) throws Exception {
        try {

            ManagerRouting.softDelete(databaseName, amountvalid, pancard);
        } catch (Exception e) {
            throw e;
        }
    }

    /*
     *********************************************************
     * @Method Name : approvedLoan
     * 
     * @Author : Manish Kripalani (Manish.kripalani@antrazal.com)
     * 
     * @Company : Antrazal
     * 
     * @Description : Approves or rejects a loan based on the provided loan number
     * and status.
     * 
     * @param : databaseName (String) - The name of the database
     * amountvalid (Integer) - The amount validity check
     * loannumber (String) - The loan number to be approved/rejected
     * approvedrejected (String) - The approval status
     * 
     * @throws : Exception, CustomException - For various validation errors
     * 
     * @return : void
     *********************************************************
     */
    public static void approvedLoan(String databaseName, Integer amountvalid, String loannumber,
            String approvedrejected) throws Exception, CustomException {
        try {

            if (approvedrejected.equals("Approved") || approvedrejected.equals("Rejected")) {
                Loan loan = new Loan(loannumber, null, approvedrejected, null);
                ManagerRouting.approvedLoan(databaseName, amountvalid, loan);
            } else {
                throw new CustomException(Constant.WRONGOPTION);
            }
        } catch (Exception e) {
            throw e;
        }
    }

    /*
     *********************************************************
     * @Method Name : CustomerInformation
     * 
     * @Author : Manish Kripalani (Manish.kripalani@antrazal.com)
     * 
     * @Company : Antrazal
     * 
     * @Description : Retrieves and prints customer information based on the
     * provided PAN card number.
     * 
     * @param : databaseName (String) - The name of the database
     * amountvalid (Integer) - The amount validity check
     * pancard (String) - The PAN card number of the customer
     * 
     * @throws : Exception - For various validation errors
     * 
     * @return : void
     *********************************************************
     */
    public static void CustomerInformation(String databaseName, Integer amountvalid, String pancard) throws Exception {
        try {

            ManagerRouting.CustomerInformationprint(databaseName, amountvalid, pancard);
        } catch (Exception e) {
            throw e;
        }
    }

    /*
     *********************************************************
     * @Method Name : undoLastTransaction
     * 
     * @Author : Manish Kripalani (Manish.kripalani@antrazal.com)
     * 
     * @Company : Antrazal
     * 
     * @Description : Undoes the last transaction for the specified account number.
     * 
     * @param : databaseName (String) - The name of the database
     * amountvalid (Integer) - The amount validity check
     * accountNumber (String) - The account number to undo the transaction for
     * 
     * @throws : Exception - For various validation errors
     * 
     * @return : void
     *********************************************************
     */
    public static void undoLastTransaction(String databaseName, Integer amountvalid, String accountNumber)
            throws Exception {
        try {

            ManagerRouting.undoLastTransactioncustomer(databaseName, amountvalid, accountNumber);
        } catch (Exception e) {
            throw e;
        }
    }

}
