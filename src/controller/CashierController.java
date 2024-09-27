package controller;

import Pojo.Employee; // Importing Employee class for employee-related operations
import Pojo.Transaction; // Importing Transaction class for transaction-related operations
import Service.CashierService; // Importing CashierService to handle business logic related to cashiers

/*
*********************************************************************************************************
 *  @JAVA Class Name :   CashierController
 *  @Author          :   <Manish Kripalani>(manish.kripalani@antrazal.com)
 *  @Company         :   Antrazal
 *  @Date            :   27-09-2024
 *  @Description    :   This class acts as a controller for 
 *                      cashier-related operations. It manages 
 *                      interactions between the user interface 
 *                      and the CashierService for handling 
 *                      user validation, deposits for single 
 *                      and joint accounts.
 *******************************************************************************************************
 *  AWC ID     Developer                                             	  	TITLE  
 *  1633      <Manish Kripalani>(manish.kripalani@antrazal.com)      JAVA ASSIGNMENT
********************************************************************************************************
*/
public class CashierController {

    /*
     *********************************************************
     *  @Method Name    :   usernameexit
     *  @author         :   <Manish Kripalani>(manish.kripalani@antrazal.com)
     *  @Company        :   Antrazal
     *  @Description    :   Checks if the username exists in 
     *                      the database and processes accordingly.
     *  @param          :   emp - Employee object containing 
     *                      employee details
     *                      databaseName - Database name
     *                      amountvalid - Valid amount for operation
     *  @return         :   void
     *********************************************************
     */
    public static void usernameexit(Employee emp, String databaseName, Integer amountvalid) throws Exception {
        try {
            CashierService.userexit(emp, databaseName, amountvalid);
        } catch (Exception e) {
            throw e;
        }
    }

    /*
     *********************************************************
     *  @Method Name    :   usernamenotexit
     *  @author         :   <Manish Kripalani>(manish.kripalani@antrazal.com)
     *  @Company        :   Antrazal
     *  @Description    :   Checks if the username does not 
     *                      exist in the database and processes 
     *                      accordingly.
     *  @param          :   emp - Employee object containing 
     *                      employee details
     *                      databaseName - Database name
     *                      amountvalid - Valid amount for operation
     *  @return         :   void
     *********************************************************
     */
    public static void usernamenotexit(Employee emp, String databaseName, Integer amountvalid) throws Exception {
        try {
            CashierService.usernotexit(emp, databaseName, amountvalid);
        } catch (Exception e) {
            throw e;
        }
    }

    /*
     *********************************************************
     *  @Method Name    :   singleAccountDeposite
     *  @author         :   <Manish Kripalani>(manish.kripalani@antrazal.com)
     *  @Company        :   Antrazal
     *  @Description    :   Processes a deposit transaction for 
     *                      a single account.
     *  @param          :   databasename - Database name
     *                      amountvalid - Valid amount for operation
     *                      trans - Transaction object containing 
     *                      transaction details
     *  @return         :   void
     *********************************************************
     */
    public static void singleAccountDeposite(String databasename, Integer amountvalid, Transaction trans) throws Exception {
        try {
            CashierService.singleAccountDeposite(databasename, amountvalid, trans);
        } catch (Exception e) {
            throw e;
        }
    }

    /*
     *********************************************************
     *  @Method Name    :   jointAccountDeposite
     *  @author         :   <Manish Kripalani>(manish.kripalani@antrazal.com)
     *  @Company        :   Antrazal
     *  @Description    :   Processes a deposit transaction for 
     *                      a joint account.
     *  @param          :   databasename - Database name
     *                      amountvalid - Valid amount for operation
     *                      trans - Transaction object containing 
     *                      transaction details
     *  @return         :   void
     *********************************************************
     */
    public static void jointAccountDeposite(String databasename, Integer amountvalid, Transaction trans) throws Exception {
        try {
            CashierService.jointAccountDeposite(databasename, amountvalid, trans);
        } catch (Exception e) {
            throw e;
        }
    }
}
