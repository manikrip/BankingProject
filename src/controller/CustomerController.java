package controller;

import Pojo.Loan; // Importing Loan class for loan-related operations
import Pojo.Login; // Importing Login class for user login operations
import Service.CustomerService; // Importing CustomerService to handle business logic related to customers

/*
 *********************************************************
 *  @Class Name     :   CustomerController
 *  @Description    :   This class acts as a controller for 
 *                      customer-related operations. It manages 
 *                      interactions between the user interface 
 *                      and the CustomerService for handling login, 
 *                      account management, withdrawals, loans, 
 *                      and passbook printing.
 *********************************************************
 */
public class CustomerController {

    /*
     *********************************************************
     *  @Method Name    :   usernamenotexit
     *  @Description    :   Checks if the username does not exist 
     *                      in the database and processes accordingly.
     *  @param          :   log - Login object containing login details
     *                      dbname - Database name
     *                      amount - Valid amount for operation
     *  @return         :   void
     *********************************************************
     */
    public static void usernamenotexit(Login log, String dbname, Integer amount) throws Exception {
        try {
            CustomerService.usernotexit(log, dbname, amount);
        } catch (Exception e) {
            throw e;
        }
    }

    /*
     *********************************************************
     *  @Method Name    :   usernameexit
     *  @Description    :   Checks if the username exists in the 
     *                      database and processes accordingly.
     *  @param          :   log - Login object containing login details
     *                      dbname - Database name
     *                      amount - Valid amount for operation
     *  @return         :   void
     *********************************************************
     */
    public static void usernameexit(Login log, String dbname, Integer amount) throws Exception {
        try {
            CustomerService.userexit(log, dbname, amount);
        } catch (Exception e) {
            throw e;
        }
    }

    /*
     *********************************************************
     *  @Method Name    :   createPinSingle
     *  @Description    :   Creates a single account PIN for the user.
     *  @param          :   validAccountnumber - Account number for which to create the PIN
     *                      validpin - The PIN to be created
     *                      databasename - Database name
     *                      amountvalid - Valid amount for operation
     *  @return         :   void
     *********************************************************
     */
    public static void createPinSingle(String validAccountnumber, Integer validpin, String databasename, Integer amountvalid) throws Exception {
        try {
            CustomerService.createPinSingle(validAccountnumber, validpin, databasename, amountvalid);
        } catch (Exception e) {
            throw e;
        }
    }

    /*
     *********************************************************
     *  @Method Name    :   createPinJoint
     *  @Description    :   Creates a joint account PIN for the user.
     *  @param          :   validAccountnumber - Account number for which to create the PIN
     *                      validpin - The PIN to be created
     *                      databasename - Database name
     *                      amountvalid - Valid amount for operation
     *  @return         :   void
     *********************************************************
     */
    public static void createPinJoint(String validAccountnumber, Integer validpin, String databasename, Integer amountvalid) throws Exception  {
        try {
            CustomerService.createPinJoint(validAccountnumber, validpin, databasename, amountvalid);
        } catch (Exception e) {
            throw e;
        }
    }

    /*
     *********************************************************
     *  @Method Name    :   withdrawSingle
     *  @Description    :   Handles withdrawal from a single account.
     *  @param          :   validAccountnumber - Account number to withdraw from
     *                      validpin - The PIN for account verification
     *                      amount - The amount to withdraw
     *                      databasename - Database name
     *                      amountvalid - Valid amount for operation
     *  @return         :   void
     *********************************************************
     */
    public static void withdrawSingle(String validAccountnumber, Integer validpin, Integer amount, String databasename, Integer amountvalid) throws Exception {
        try {
            CustomerService.withdrawSingle(validAccountnumber, validpin, amount, databasename, amountvalid);
        } catch (Exception e) {
            throw e;
        }
    }

    /*
     *********************************************************
     *  @Method Name    :   withdrawJoint
     *  @Description    :   Handles withdrawal from a joint account.
     *  @param          :   validAccountnumber - Account number to withdraw from
     *                      validpin - The PIN for account verification
     *                      amount - The amount to withdraw
     *                      databasename - Database name
     *                      amountvalid - Valid amount for operation
     *  @return         :   void
     *********************************************************
     */
    public static void withdrawJoint(String validAccountnumber, Integer validpin, Integer amount, String databasename, Integer amountvalid) throws Exception {
        try {
            CustomerService.withdrawJoint(validAccountnumber, validpin, amount, databasename, amountvalid);
        } catch (Exception e) {
            throw e;
        }
    }

    /*
     *********************************************************
     *  @Method Name    :   createLoan
     *  @Description    :   Processes loan creation for a customer.
     *  @param          :   loan - Loan object containing loan details
     *                      databasename - Database name
     *                      amountvalid - Valid amount for operation
     *  @return         :   void
     *********************************************************
     */
    public static void createLoan(Loan loan, String databasename, Integer amountvalid) throws Exception {
        try {
            CustomerService.createLoan(loan, databasename, amountvalid);
        } catch (Exception e) {
            throw e;
        }
    }

    /*
     *********************************************************
     *  @Method Name    :   printpassbookCustomer
     *  @Description    :   Prints the passbook for the customer.
     *  @param          :   validpannumber - PAN number of the customer
     *                      databasename - Database name
     *                      amountvalid - Valid amount for operation
     *  @return         :   void
     *********************************************************
     */
    public static void printpassbookCustomer(String validpannumber, String databasename, Integer amountvalid) throws Exception {
        try {
            CustomerService.printpassbookCustomer(validpannumber, databasename, amountvalid);
        } catch (Exception e) {
            throw e;
        }
    }
}
