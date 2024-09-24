package controller;

import Pojo.Customer; // Importing Customer class
import Pojo.Employee; // Importing Employee class
import Pojo.JointAccount; // Importing JointAccount class
import Pojo.Loan; // Importing Loan class
import Service.ManagerService; // Importing ManagerService for business logic
import view.ManagerView; // Importing ManagerView for presentation logic

public class ManagaerController {

    /*
     *********************************************************
     *  @Method Name    :   userexit
     *  @Description    :   This method handles user exit based on the employee object.
     *                      It calls the ManagerService to process the exit.
     *  @param          :   emp - Employee object
     *                      databaseName - Name of the database
     *                      amountvalid - Validated amount for operations
     *  @return         :   void
     *********************************************************
     */
    public static void userexit(Employee emp, String databaseName, Integer amountvalid) throws Exception {
        try {
            ManagerService.userexit(emp, databaseName, amountvalid); // Call service to process user exit
        } catch (Exception e) {
            throw e; // Rethrow exception for higher-level handling
        }
    }

    /*
     *********************************************************
     *  @Method Name    :   usernotexit
     *  @Description    :   This method handles cases when a user does not exist.
     *                      It calls the ManagerService to process the situation.
     *  @param          :   emp - Employee object
     *                      databaseName - Name of the database
     *                      amountvalid - Validated amount for operations
     *  @return         :   void
     *********************************************************
     */
    public static void usernotexit(Employee emp, String databaseName, Integer amountvalid) throws Exception {
        try {
            ManagerService.usernotexit(emp, databaseName, amountvalid); // Call service to process non-existing user
        } catch (Exception e) {
            throw e; // Rethrow exception for higher-level handling
        }
    }

    /*
     *********************************************************
     *  @Method Name    :   createSAccount
     *  @Description    :   This method creates a single account using the provided customer details.
     *  @param          :   databaseName - Name of the database
     *                      amountvalid - Validated amount for operations
     *                      customer - Customer object containing details for account creation
     *  @return         :   void
     *********************************************************
     */
    public static void createSAccount(String databaseName, Integer amountvalid, Customer customer) throws Exception {
        try {
            ManagerService.createSAccount(databaseName, amountvalid, customer); // Call service to create single account
        } catch (Exception e) {
            throw e; // Rethrow exception for higher-level handling
        }
    }

    /*
     *********************************************************
     *  @Method Name    :   createJAccount
     *  @Description    :   This method creates a joint account using the provided details.
     *  @param          :   databaseName - Name of the database
     *                      amountvalid - Validated amount for operations
     *                      jointAccount - JointAccount object containing account details
     *                      validpancard1 - Valid PAN card number
     *                      name - Name of the first account holder
     *                      name1 - Name of the second account holder
     *  @return         :   void
     *********************************************************
     */
    public static void createJAccount(String databaseName, Integer amountvalid, JointAccount jointAccount,
            String validpancard1, String name, String name1) throws Exception {
        try {
            ManagerService.createJAccount(databaseName, amountvalid, jointAccount, validpancard1, name, name1); // Call service to create joint account
        } catch (Exception e) {
            throw e; // Rethrow exception for higher-level handling
        }
    }

    /*
     *********************************************************
     *  @Method Name    :   updationPancard
     *  @Description    :   This method updates the PAN card details for a customer.
     *  @param          :   databaseName - Name of the database
     *                      amountvalid - Validated amount for operations
     *                      customer - Customer object containing updated details
     *  @return         :   void
     *********************************************************
     */
    public static void updationPancard(String databaseName, Integer amountvalid, Customer customer) throws Exception {
        try {
            ManagerService.updationPancard(databaseName, amountvalid, customer); // Call service to update PAN card
        } catch (Exception e) {
            throw e; // Rethrow exception for higher-level handling
        }
    }

    /*
     *********************************************************
     *  @Method Name    :   softDelete
     *  @Description    :   This method performs a soft delete operation using the provided PAN card number.
     *  @param          :   databaseName - Name of the database
     *                      amountvalid - Validated amount for operations
     *                      pancard - PAN card number for the operation
     *  @return         :   void
     *********************************************************
     */
    public static void softDelete(String databaseName, Integer amountvalid, String pancard) throws Exception {
        try {
            ManagerService.softDelete(databaseName, amountvalid, pancard); // Call service to perform soft delete
        } catch (Exception e) {
            throw e; // Rethrow exception for higher-level handling
        }
    }

    /*
     *********************************************************
     *  @Method Name    :   approvedLoan
     *  @Description    :   This method approves a loan based on the provided loan details.
     *  @param          :   databaseName - Name of the database
     *                      amountvalid - Validated amount for operations
     *                      loan - Loan object containing details for approval
     *  @return         :   void
     *********************************************************
     */
    public static void approvedLoan(String databaseName, Integer amountvalid, Loan loan) throws Exception {
        try {
            ManagerService.approvedLoan(databaseName, amountvalid, loan); // Call service to approve loan
        } catch (Exception e) {
            throw e; // Rethrow exception for higher-level handling
        }
    }

    /*
     *********************************************************
     *  @Method Name    :   CustomerInformationprint
     *  @Description    :   This method prints customer information based on the provided PAN card number.
     *  @param          :   databaseName - Name of the database
     *                      amountvalid - Validated amount for operations
     *                      pancard - PAN card number for the customer
     *  @return         :   void
     *********************************************************
     */
    public static void CustomerInformationprint(String databaseName, Integer amountvalid, String pancard) throws Exception {
        try {
            ManagerService.CustomerInformationprint(databaseName, amountvalid, pancard); // Call service to print customer information
        } catch (Exception e) {
            throw e; // Rethrow exception for higher-level handling
        }
    }

    /*
     *********************************************************
     *  @Method Name    :   printCustomerInformation
     *  @Description    :   This method delegates the printing of customer information to the ManagerView.
     *  @param          :   string - Information to print
     *                      databaseName - Name of the database
     *                      amountvalid - Validated amount for operations
     *  @return         :   void
     *********************************************************
     */
    public static void printCustomerInformation(String string, String databaseName, Integer amountvalid) throws Exception {
        try {
            ManagerView.printCustomerInformationl(string, databaseName, amountvalid); // Call view to print customer information
        } catch (Exception e) {
            throw e; // Rethrow exception for higher-level handling
        }
    }

    /*
     *********************************************************
     *  @Method Name    :   undoLastTransactioncustomer
     *  @Description    :   This method undoes the last transaction for a customer based on the account number.
     *  @param          :   databaseName - Name of the database
     *                      amountvalid - Validated amount for operations
     *                      validAccountnumber - Valid account number for the customer
     *  @return         :   void
     *********************************************************
     */
    public static void undoLastTransactioncustomer(String databaseName, Integer amountvalid, String validAccountnumber) throws Exception {
        try {
            ManagerService.undoLastTransactioncustomer(databaseName, amountvalid, validAccountnumber); // Call service to undo transaction
        } catch (Exception e) {
            throw e; // Rethrow exception for higher-level handling
        }
    }
}
