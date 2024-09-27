/*
*********************************************************************************************************
 *  @Java Class Name :   CustomerRouting
 *  @Author          :   Manish Kripalani (Manish.kripalani@antrazal.com)
 *  @Company         :   Antrazal
 *  @Date            :   17-09-2024
 *  @Description     :   This class provides routing functionality for customer operations, including 
 *                       managing username checks, creating PINs, withdrawing money, processing loans,
 *                       and printing passbooks by delegating requests to the respective controllers and views.
 *******************************************************************************************************
 *  AWC ID     Developer                                             	  	TITLE  
 *  1633      <Manish Kripalani>(manish.kripalani@antrazal.com)      JAVA ASSIGNMENT
********************************************************************************************************
*/

package Routing;

import Pojo.Loan;
import Pojo.Login;
import controller.CustomerController;
import view.CustomerView;

public class CustomerRouting {
    /*
     *********************************************************
     * @Method Name : usernamenotexit
     * @Author : Manish Kripalani (Manish.kripalani@antrazal.com)
     * @Company : Antrazal
     * @Description : This method checks if the username does not exist in the system using the provided Login object, database name, and amount.
     * @param : log (Login) - The Login object containing user login details.
     *          dbname (String) - The name of the database to be accessed.
     *          amount (Integer) - The valid amount associated with the operation.
     * @return : void
     *********************************************************
     */
    public static void usernamenotexit(Login log, String dbname, Integer amount) throws Exception {
        try {
            CustomerController.usernamenotexit(log, dbname, amount);
        } catch (Exception e) {
            throw e;
        }
    }

    /*
     *********************************************************
     * @Method Name : usernameexit
     * @Author : Manish Kripalani (Manish.kripalani@antrazal.com)
     * @Company : Antrazal
     * @Description : This method checks if the username already exists in the system using the provided Login object, database name, and amount.
     * @param : log (Login) - The Login object containing user login details.
     *          dbname (String) - The name of the database to be accessed.
     *          amount (Integer) - The valid amount associated with the operation.
     * @return : void
     *********************************************************
     */
    public static void usernameexit(Login log, String dbname, Integer amount) throws Exception {
        try {
            CustomerController.usernameexit(log, dbname, amount);
        } catch (Exception e) {
            throw e;
        }
    }

    /*
     *********************************************************
     * @Method Name : createPin
     * @Author : Manish Kripalani (Manish.kripalani@antrazal.com)
     * @Company : Antrazal
     * @Description : This method initiates the process of creating a PIN for a single account using the provided database name and valid amount.
     * @param : databasename (String) - The name of the database to be accessed.
     *          amountvalid (Integer) - The valid amount associated with the operation.
     * @return : void
     *********************************************************
     */
    public static void createPin(String databasename, Integer amountvalid) throws Exception {
        try {
            CustomerView.createPinSingle(databasename, amountvalid);
        } catch (Exception e) {
            throw e;
        }
    }

    /*
     *********************************************************
     * @Method Name : createJointPin
     * @Author : Manish Kripalani (Manish.kripalani@antrazal.com)
     * @Company : Antrazal
     * @Description : This method initiates the process of creating a PIN for a joint account using the provided database name and valid amount.
     * @param : databasename (String) - The name of the database to be accessed.
     *          amountvalid (Integer) - The valid amount associated with the operation.
     * @return : void
     *********************************************************
     */
    public static void createJointPin(String databasename, Integer amountvalid) throws Exception {
        try {
            CustomerView.createPinJoint(databasename, amountvalid);
        } catch (Exception e) {
            throw e;
        }
    }

    /*
     *********************************************************
     * @Method Name : withdrawMoneySingle
     * @Author : Manish Kripalani (Manish.kripalani@antrazal.com)
     * @Company : Antrazal
     * @Description : This method handles the withdrawal operation for a single account using the
     * provided database name and valid amount.
     * @param : databasename (String) - The name of the database to be accessed.
     *          amountvalid (Integer) - The valid amount for the withdrawal operation.
     * @return : void
     *********************************************************
     */
    public static void withdrawMoneySingle(String databasename, Integer amountvalid) throws Exception {
        try {
            CustomerView.withdrawSingle(databasename, amountvalid);
        } catch (Exception e) {
            throw e;
        }
    }

    /*
     *********************************************************
     * @Method Name : withdrawMoneyJoint
     * @Author : Manish Kripalani (Manish.kripalani@antrazal.com)
     * @Company : Antrazal
     * @Description : This method handles the withdrawal operation for a joint account using the provided database name and valid amount.
     * @param : databasename (String) - The name of the database to be accessed.
     *          amountvalid (Integer) - The valid amount for the withdrawal operation.
     * @return : void
     *********************************************************
     */
    public static void withdrawMoneyJoint(String databasename, Integer amountvalid) throws Exception {
        try {
            CustomerView.withdrawJoint(databasename, amountvalid);
        } catch (Exception e) {
            throw e;
        }
    }

    /*
     *********************************************************
     * @Method Name : loan
     * @Author : Manish Kripalani (Manish.kripalani@antrazal.com)
     * @Company : Antrazal
     * @Description : This method initiates the loan process using the provided database name and valid amount.
     * @param : databasename (String) - The name of the database to be accessed.
     *          amountvalid (Integer) - The valid amount associated with the loan request.
     * @return : void
     *********************************************************
     */
    public static void loan(String databasename, Integer amountvalid) throws Exception {
        try {
            CustomerView.loan(databasename, amountvalid);
        } catch (Exception e) {
            throw e;
        }
    }

    /*
     *********************************************************
     * @Method Name : printPassbook
     * @Author : Manish Kripalani (Manish.kripalani@antrazal.com)
     * @Company : Antrazal
     * @Description : This method prints the passbook for the customer using the provided database name and valid amount.
     * @param : databasename (String) - The name of the database to be accessed.
     *          amountvalid (Integer) - The valid amount for the operation.
     * @return : void
     *********************************************************
     */
    public static void printPassbook(String databasename, Integer amountvalid) throws Exception {
        try {
            CustomerView.printpassbook(databasename, amountvalid);
        } catch (Exception e) {
            throw e;
        }
    }

    /*
     *********************************************************
     * @Method Name : createPinSingle
     * @Author : Manish Kripalani (Manish.kripalani@antrazal.com)
     * @Company : Antrazal
     * @Description : This method creates a PIN for a single account using the
     * provided account number,
     * valid PIN, database name, and valid amount.
     * @param : validAccountnumber (String) - The account number for which the PIN is to be created.
     *          validpin (Integer) - The valid PIN to be set.
     *          databasename (String) - The name of the database to be accessed.
     *          amountvalid (Integer) - The valid amount associated with the operation.
     * @return : void
     *********************************************************
     */
    public static void createPinSingle(String validAccountnumber, Integer validpin, String databasename,
            Integer amountvalid) throws Exception {
        try {
            CustomerController.createPinSingle(validAccountnumber, validpin, databasename, amountvalid);
        } catch (Exception e) {
            throw e;
        }
    }

    /*
     *********************************************************
     * @Method Name : createPinJoint
     * @Author : Manish Kripalani (Manish.kripalani@antrazal.com)
     * @Company : Antrazal
     * @Description : This method creates a PIN for a joint account using the provided account number, valid PIN, database name, and valid amount.
     * @param : validAccountnumber (String) - The account number for which the PIN is to be created.
     *          validpin (Integer) - The valid PIN to be set.
     *          databasename (String) - The name of the database to be accessed.
     *          amountvalid (Integer) - The valid amount associated with the operation.
     * @return : void
     *********************************************************
     */
    public static void createPinJoint(String validAccountnumber, Integer validpin, String databasename,
            Integer amountvalid) throws Exception {
        try {
            CustomerController.createPinJoint(validAccountnumber, validpin, databasename, amountvalid);
        } catch (Exception e) {
            throw e;
        }
    }

    /*
     *********************************************************
     * @Method Name : withdrawSingle
     * @Author : Manish Kripalani (Manish.kripalani@antrazal.com)
     * @Company : Antrazal
     * @Description : This method handles the withdrawal operation for a single account using the provided account number, valid PIN, amount, database name, and valid amount.
     * @param : validAccountnumber (String) - The account number from which to withdraw money.
     *          validpin (Integer) - The valid PIN for account verification.
     *          amount (Integer) - The amount to be withdrawn.
     *          databasename (String) - The name of the database to be accessed.
     *          amountvalid (Integer) - The valid amount associated with the operation.
     * @return : void
     *********************************************************
     */
    public static void withdrawSingle(String validAccountnumber, Integer validpin, Integer amount, String databasename,
            Integer amountvalid) throws Exception {
        try {
            CustomerController.withdrawSingle(validAccountnumber, validpin, amount, databasename, amountvalid);
        } catch (Exception e) {
            throw e;
        }
    }

    /*
     *********************************************************
     * @Method Name : withdrawJoint
     * @Author : Manish Kripalani (Manish.kripalani@antrazal.com)
     * @Company : Antrazal
     * @Description : This method handles the withdrawal operation for a joint account using the provided account number, valid PIN, amount, database name, and valid amount.
     * @param : validAccountnumber (String) - The account number from which to withdraw money.
     *          validpin (Integer) - The valid PIN for account verification.
     *          amount (Integer) - The amount to be withdrawn.
     *          databasename (String) - The name of the database to be accessed.
     *          amountvalid (Integer) - The valid amount associated with the operation.
     * @return : void
     *********************************************************
     */
    public static void withdrawJoint(String validAccountnumber, Integer validpin, Integer amount, String databasename,
            Integer amountvalid) throws Exception {
        try {
            CustomerController.withdrawJoint(validAccountnumber, validpin, amount, databasename, amountvalid);
        } catch (Exception e) {
            throw e;
        }
    }

    /*
     *********************************************************
     * @Method Name : createLoan
     * @Author : Manish Kripalani (Manish.kripalani@antrazal.com)
     * @Company : Antrazal
     * @Description : This method initiates the loan creation process using the provided Loan object, database name, and valid amount.
     * @param : loan (Loan) - The Loan object containing loan details.
     *          databasename (String) - The name of the database to be accessed.
     *          amountvalid (Integer) - The valid amount associated with the loan request.
     * @return : void
     *********************************************************
     */
    public static void createLoan(Loan loan, String databasename, Integer amountvalid) throws Exception {
        try {
            CustomerController.createLoan(loan, databasename, amountvalid);
        } catch (Exception e) {
            throw e;
        }
    }

    /*
     *********************************************************
     * @Method Name : printpassbookCustomer
     * @Author : Manish Kripalani (Manish.kripalani@antrazal.com)
     * @Company : Antrazal
     * @Description : This method prints the customer's passbook using the provided PAN number, database name, and valid amount.
     * @param : validpannumber (String) - The PAN number of the customer.
     *          databasename (String) - The name of the database to be accessed.
     *          amountvalid (Integer) - The valid amount associated with the operation.
     * @return : void
     *********************************************************
     */
    public static void printpassbookCustomer(String validpannumber, String databasename, Integer amountvalid)
            throws Exception {
        try {
            CustomerController.printpassbookCustomer(validpannumber, databasename, amountvalid);
        } catch (Exception e) {
            throw e;
        }
    }
}