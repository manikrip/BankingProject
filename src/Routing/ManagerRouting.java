/*
*********************************************************************************************************
 *  @Java Class Name :   ManagerRouting
 *  @Author          :   Manish Kripalani (Manish.kripalani@antrazal.com)
 *  @Company         :   Antrazal
 *  @Date            :   17-09-2024
 *  @Description     :   This class routes various functionalities for the manager role in the banking 
 *                       application. It delegates calls to the appropriate controller and view classes 
 *                       based on the specific action required.
 *******************************************************************************************************
 *  AWC ID     Developer                                             	  	TITLE  
 *  1633      <Manish Kripalani>(manish.kripalani@antrazal.com)      JAVA ASSIGNMENT
********************************************************************************************************
*/

package Routing;

import Pojo.Customer;
import Pojo.Employee;
import Pojo.JointAccount;
import Pojo.Loan;
import controller.ManagerController;
import view.ManagerView;

public class ManagerRouting {
    /*
     *********************************************************
     * @Method Name : usernameexit
     * @Author : Manish Kripalani (Manish.kripalani@antrazal.com)
     * @Company : Antrazal
     * @Description : Checks if the user exists in the database.
     * @param : emp (Employee) - The employee object to be checked.
     *          databaseName (String) - The name of the database.
     *          amountvalid (Integer) - A valid amount associated with the operation.
     * @return : void
     *********************************************************
     */
    public static void usernameexit(Employee emp, String databaseName, Integer amountvalid) throws Exception {
        try {
            ManagerController.userexit(emp, databaseName, amountvalid);
        } catch (Exception e) {
            throw e;
        }
    }

    /*
     *********************************************************
     * @Method Name : usernamenotexit
     * @Author : Manish Kripalani (Manish.kripalani@antrazal.com)
     * @Company : Antrazal
     * @Description : Checks if the user does not exist in the database.
     * @param : emp (Employee) - The employee object to be checked.
     *          databaseName (String) - The name of the database.
     *          amountvalid (Integer) - A valid amount associated with the operation.
     * @return : void
     *********************************************************
     */
    public static void usernamenotexit(Employee emp, String databaseName, Integer amountvalid) throws Exception {
        try {
            ManagerController.usernotexit(emp, databaseName, amountvalid);
        } catch (Exception e) {
            throw e;
        }
    }

    /*
     *********************************************************
     * @Method Name : createSingleAccount
     * @Author : Manish Kripalani (Manish.kripalani@antrazal.com)
     * @Company : Antrazal
     * @Description : Routes to the view for creating a single account.
     * @param : databaseName (String) - The name of the database.
     *          amountvalid (Integer) - A valid amount associated with the operation.
     * @return : void
     *********************************************************
     */
    public static void createSingleAccount(String databaseName, Integer amountvalid) throws Exception {
        try {
            ManagerView.createSingleAccount(databaseName, amountvalid);
        } catch (Exception e) {
            throw e;
        }
    }

    /*
     *********************************************************
     * @Method Name : createJointAccount
     * @Author : Manish Kripalani (Manish.kripalani@antrazal.com)
     * @Company : Antrazal
     * @Description : Routes to the view for creating a joint account.
     * @param : databaseName (String) - The name of the database.
     *          amountvalid (Integer) - A valid amount associated with the operation.
     * @return : void
     *********************************************************
     */
    public static void createJointAccount(String databaseName, Integer amountvalid) throws Exception {
        try {
            ManagerView.createJointAccount(databaseName, amountvalid);
        } catch (Exception e) {
            throw e;
        }
    }

    /*
     *********************************************************
     * @Method Name : updation
     * @Author : Manish Kripalani (Manish.kripalani@antrazal.com)
     * @Company : Antrazal
     * @Description : Routes to the view for updating account information.
     * @param : databaseName (String) - The name of the database.
     *          amountvalid (Integer) - A valid amount associated with the operation.
     * @return : void
     *********************************************************
     */
    public static void updation(String databaseName, Integer amountvalid) throws Exception {
        try {
            ManagerView.updation(databaseName, amountvalid);
        } catch (Exception e) {
            throw e;
        }
    }

    /*
     *********************************************************
     * @Method Name : softDelete
     * @Author : Manish Kripalani (Manish.kripalani@antrazal.com)
     * @Company : Antrazal
     * @Description : Routes to the view for performing a soft delete on an account.
     * @param : databaseName (String) - The name of the database.
     *          amountvalid (Integer) - A valid amount associated with the operation.
     * @return : void
     *********************************************************
     */
    public static void softDelete(String databaseName, Integer amountvalid) throws Exception {
        try {
            ManagerView.softDelete(databaseName, amountvalid);
        } catch (Exception e) {
            throw e;
        }
    }

    /*
     *********************************************************
     * @Method Name : approvedLoan
     * @Author : Manish Kripalani (Manish.kripalani@antrazal.com)
     * @Company : Antrazal
     * @Description : Routes to the view for approving loans.
     * @param : databaseName (String) - The name of the database.
     *          amountvalid (Integer) - A valid amount associated with the operation.
     * @return : void
     *********************************************************
     */
    public static void approvedLoan(String databaseName, Integer amountvalid) throws Exception {
        try {
            ManagerView.approvedLoan(databaseName, amountvalid);
        } catch (Exception e) {
            throw e;
        }
    }

    /*
     *********************************************************
     * @Method Name : CustomerInformation
     * @Author : Manish Kripalani (Manish.kripalani@antrazal.com)
     * @Company : Antrazal
     * @Description : Routes to the view for displaying customer information.
     * @param : databaseName (String) - The name of the database.
     *          amountvalid (Integer) - A valid amount associated with the operation.
     * @return : void
     *********************************************************
     */
    public static void CustomerInformation(String databaseName, Integer amountvalid) throws Exception {
        try {
            ManagerView.CustomerInformation(databaseName, amountvalid);
        } catch (Exception e) {
            throw e;
        }
    }

    /*
     *********************************************************
     * @Method Name : undoLastTransaction
     * @Author : Manish Kripalani (Manish.kripalani@antrazal.com)
     * @Company : Antrazal
     * @Description : Routes to the view for undoing the last transaction.
     * @param : databaseName (String) - The name of the database. 
     *          amountvalid (Integer) - A valid amount associated with the operation.
     * @return : void
     *********************************************************
     */
    public static void undoLastTransaction(String databaseName, Integer amountvalid) throws Exception {
        try {
            ManagerView.undoLastTransaction(databaseName, amountvalid);
        } catch (Exception e) {
            throw e;
        }
    }

    /*
     *********************************************************
     * @Method Name : createSAccount
     * @Author : Manish Kripalani (Manish.kripalani@antrazal.com)
     * @Company : Antrazal
     * @Description : Creates a single account and routes the information to the controller.
     * @param : databaseName (String) - The name of the database.
     *          amountvalid (Integer) - A valid amount associated with the operation.
     *          customer (Customer) - The customer object containing details.
     * @return : void
     *********************************************************
     */
    public static void createSAccount(String databaseName, Integer amountvalid, Customer customer) throws Exception {
        try {
            ManagerController.createSAccount(databaseName, amountvalid, customer);
        } catch (Exception e) {
            throw e;
        }
    }

    /*
     *********************************************************
     * @Method Name : createJAccount
     * @Author : Manish Kripalani (Manish.kripalani@antrazal.com)
     * @Company : Antrazal
     * @Description : Creates a joint account and routes the information to the controller.
     * @param : databaseName (String) - The name of the database.
     *          amountvalid (Integer) - A valid amount associated with the operation.
     *          jointAccount (JointAccount) - The joint account object containing details.
     *          validpancard1 (String) - The valid PAN card number for the first account holder.
     *          name (String) - The name of the first account holder.
     *          name1 (String) - The name of the second account holder.
     * @return : void
     *********************************************************
     */
    public static void createJAccount(String databaseName, Integer amountvalid, JointAccount jointAccount,
            String validpancard1, String name, String name1) throws Exception {
        try {
            ManagerController.createJAccount(databaseName, amountvalid, jointAccount, validpancard1, name, name1);
        } catch (Exception e) {
            throw e;
        }
    }

    /*
     *********************************************************
     * @Method Name : updationPancard
     * @Author : Manish Kripalani (Manish.kripalani@antrazal.com)
     * @Company : Antrazal
     * @Description : Updates the PAN card information for a customer.
     * @param : databaseName (String) - The name of the database.
     *          amountvalid (Integer) - A valid amount associated with the operation.
     *          customer (Customer) - The customer object containing details.
     * @return : void
     *********************************************************
     */
    public static void updationPancard(String databaseName, Integer amountvalid, Customer customer) throws Exception {
        try {
            ManagerController.updationPancard(databaseName, amountvalid, customer);
        } catch (Exception e) {
            throw e;
        }
    }

    /*
     *********************************************************
     * @Method Name : softDelete
     * @Author : Manish Kripalani (Manish.kripalani@antrazal.com)
     * @Company : Antrazal
     * @Description : Performs a soft delete based on the provided PAN card number.
     * @param : databaseName (String) - The name of the database.
     *          amountvalid (Integer) - A valid amount associated with the operation.
     *          pancard (String) - The PAN card number of the account to be soft deleted.
     * @return : void
     *********************************************************
     */
    public static void softDelete(String databaseName, Integer amountvalid, String pancard) throws Exception {
        try {
            ManagerController.softDelete(databaseName, amountvalid, pancard);
        } catch (Exception e) {
            throw e;
        }
    }

    /*
     *********************************************************
     * @Method Name : approvedLoan
     * @Author : Manish Kripalani (Manish.kripalani@antrazal.com)
     * @Company : Antrazal
     * @Description : Approves a loan and routes the information to the controller.
     * @param : databaseName (String) - The name of the database.
     *          amountvalid (Integer) - A valid amount associated with the
     * operation.
     *          loan (Loan) - The loan object containing details.
     * @return : void
     *********************************************************
     */
    public static void approvedLoan(String databaseName, Integer amountvalid, Loan loan) throws Exception {
        try {
            ManagerController.approvedLoan(databaseName, amountvalid, loan);
        } catch (Exception e) {
            throw e;
        }
    }

    /*
     *********************************************************
     * @Method Name : CustomerInformationprint
     * @Author : Manish Kripalani (Manish.kripalani@antrazal.com)
     * @Company : Antrazal
     * @Description : Prints the customer information based on the provided PAN card number.
     * @param : databaseName (String) - The name of the database.
     *          amountvalid (Integer) - A valid amount associated with the operation.
     *          pancard (String) - The PAN card number of the customer.
     * @return : void
     *********************************************************
     */
    public static void CustomerInformationprint(String databaseName, Integer amountvalid, String pancard)
            throws Exception {
        try {
            ManagerController.CustomerInformationprint(databaseName, amountvalid, pancard);
        } catch (Exception e) {
            throw e;
        }
    }

    /*
     *********************************************************
     * @Method Name : printCustomerInformation
     * @Author : Manish Kripalani (Manish.kripalani@antrazal.com)
     * @Company : Antrazal
     * @Description : Prints the customer information based on the provided criteria.
     * @param : string (String) - The search criteria for customer information.
     *          databaseName (String) - The name of the database.
     *          amountvalid (Integer) - A valid amount associated with the operation.
     * @return : void
     *********************************************************
     */
    public static void printCustomerInformation(String string, String databaseName, Integer amountvalid)
            throws Exception {
        try {
            ManagerView.printCustomerInformationl(string, databaseName, amountvalid);
        } catch (Exception e) {
            throw e;
        }
    }

    /*
     *********************************************************
     * @Method Name : undoLastTransactioncustomer
     * @Author : Manish Kripalani (Manish.kripalani@antrazal.com)
     * @Company : Antrazal
     * @Description : Undoes the last transaction for a customer based on account number.
     * @param : databaseName (String) - The name of the database.
     *          amountvalid (Integer) - A valid amount associated with the operation.
     *          validAccountnumber (String) - The account number to undo the transaction for.
     * @return : void
     *********************************************************
     */
    public static void undoLastTransactioncustomer(String databaseName, Integer amountvalid, String validAccountnumber)
            throws Exception {
        try {
            ManagerController.undoLastTransactioncustomer(databaseName, amountvalid, validAccountnumber);
        } catch (Exception e) {
            throw e;
        }
    }
}