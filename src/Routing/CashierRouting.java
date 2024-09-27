/*
*********************************************************************************************************
 *  @Java Class Name :   CashierRouting
 *  @Author          :   Manish Kripalani (Manish.kripalani@antrazal.com)
 *  @Company         :   Antrazal
 *  @Date            :   17-09-2024
 *  @Description     :   This class provides routing functionality for cashier operations, including 
 *                       handling username checks, deposits for single and joint accounts, and delegating 
 *                       requests to the respective controllers and views.
 *******************************************************************************************************
 *  AWC ID     Developer                                             	  	TITLE  
 *  1633      <Manish Kripalani>(manish.kripalani@antrazal.com)      JAVA ASSIGNMENT
********************************************************************************************************
*/


package Routing;

import Pojo.Employee;
import Pojo.Transaction;
import controller.CashierController;
import view.CashierView;

public class CashierRouting {
    /*
     *********************************************************
     * @Method Name : usernameexit
     * @Author : Manish Kripalani (Manish.kripalani@antrazal.com)
     * @Company : Antrazal
     * @Description : This method checks if the username already exists in the system using the provided Employee object, database name, and valid amount.
     * @param : emp (Employee) - The Employee object containing cashier details.
     *          databaseName (String) - The name of the database to be accessed.
     *          amountvalid (Integer) - The valid amount associated with the operation.
     * @return : void
     *********************************************************
     */
    public static void usernameexit(Employee emp, String databaseName, Integer amountvalid) throws Exception {
        try {
            CashierController.usernameexit(emp, databaseName, amountvalid);
        } catch (Exception e) {
            throw e;
        }
    }

    /*
     *********************************************************
     * @Method Name : usernamenotexit
     * @Author : Manish Kripalani (Manish.kripalani@antrazal.com)
     * @Company : Antrazal
     * @Description : This method checks if the username does not exist in the system using the provided Employee object, database name, and valid amount.
     * @param : emp (Employee) - The Employee object containing cashier details.
     *          databaseName (String) - The name of the database to be accessed.
     *          amountvalid (Integer) - The valid amount associated with the
     * operation.
     * @return : void
     *********************************************************
     */
    public static void usernamenotexit(Employee emp, String databaseName, Integer amountvalid) throws Exception {
        try {
            CashierController.usernamenotexit(emp, databaseName, amountvalid);
        } catch (Exception e) {
            throw e;
        }
    }

    /*
     *********************************************************
     * @Method Name : singleDeposite
     * @Author : Manish Kripalani (Manish.kripalani@antrazal.com)
     * @Company : Antrazal
     * @Description : This method handles the deposit operation for single accounts using the database name and valid amount provided.
     * @param : databasename (String) - The name of the database to be accessed.
     *          amountvalid (Integer) - The valid amount for the deposit operation.
     * @return : void
     *********************************************************
     */
    public static void singleDeposite(String databasename, Integer amountvalid) throws Exception {
        try {
            CashierView.singleAccountDeposite(databasename, amountvalid);
        } catch (Exception e) {
            throw e;
        }
    }

    /*
     *********************************************************
     * @Method Name : jointDeposite
     * @Author : Manish Kripalani (Manish.kripalani@antrazal.com)
     * @Company : Antrazal
     * @Description : This method handles the deposit operation for joint accounts using the database name and valid amount provided.
     * @param : databasename (String) - The name of the database to be accessed.
     *          amountvalid (Integer) - The valid amount for the deposit operation.
     * @return : void
     *********************************************************
     */
    public static void jointDeposite(String databasename, Integer amountvalid) throws Exception {
        try {
            CashierView.jointAccountDeposite(databasename, amountvalid);
        } catch (Exception e) {
            throw e;
        }
    }

    /*
     *********************************************************
     * @Method Name : singleAccountDeposite
     * @Author : Manish Kripalani (Manish.kripalani@antrazal.com)
     * @Company : Antrazal
     * @Description : This method handles the deposit operation for a specific single account using the
     * provided database name, valid amount, and transaction details.
     * @param : databasename (String) - The name of the database to be accessed.
     *          amountvalid (Integer) - The valid amount for the deposit operation.
     *          trans (Transaction) - The Transaction object containing deposit details.
     * @return : void
     *********************************************************
     */
    public static void singleAccountDeposite(String databasename, Integer amountvalid, Transaction trans)
            throws Exception {
        try {
            CashierController.singleAccountDeposite(databasename, amountvalid, trans);
        } catch (Exception e) {
            throw e;
        }
    }

    /*
     *********************************************************
     * @Method Name : jointAccountDeposite
     * @Author : Manish Kripalani (Manish.kripalani@antrazal.com)
     * @Company : Antrazal
     * @Description : This method handles the deposit operation for a specific joint account using the provided database name, valid amount, and transaction details.
     * @param : databasename (String) - The name of the database to be accessed.
     *          amountvalid (Integer) - The valid amount for the deposit operation.
     *          trans (Transaction) - The Transaction object containing deposit details.
     * @return : void
     *********************************************************
     */
    public static void jointAccountDeposite(String databasename, Integer amountvalid, Transaction trans)
            throws Exception {
        try {
            CashierController.jointAccountDeposite(databasename, amountvalid, trans);
        } catch (Exception e) {
            throw e;
        }
    }
}