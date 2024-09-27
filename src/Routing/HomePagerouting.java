/*
*********************************************************************************************************
 *  @Java Class Name :   HomePagerouting
 *  @Author          :   Manish Kripalani (Manish.kripalani@antrazal.com)
 *  @Company         :   Antrazal
 *  @Date            :   17-09-2024
 *  @Description     :   This class routes the user to various views for customer, manager, cashier, 
 *                       and admin functionalities. It delegates calls to the respective view classes 
 *                       based on the type of user.
 *******************************************************************************************************
 *  AWC ID     Developer                                             	  	TITLE  
 *  1633      <Manish Kripalani>(manish.kripalani@antrazal.com)      JAVA ASSIGNMENT
********************************************************************************************************
*/

package Routing;

import view.*;

public class HomePagerouting {
    /*
     *********************************************************
     * @Method Name : Customerview
     * @Author : Manish Kripalani (Manish.kripalani@antrazal.com)
     * @Company : Antrazal
     * @Description : This method routes to the customer view for sign-in and sign-up using the provided database name and valid amount.
     * @param : databaseName (String) - The name of the database to be accessed.
     *          amountvalid (Integer) - The valid amount associated with the operation.
     * @return : void
     *********************************************************
     */
    public static void Customerview(String databaseName, Integer amountvalid) throws Exception {
        try {
            CustomerView.customerSignInandSignup(databaseName, amountvalid);
        } catch (Exception e) {
            throw e;
        }
    }

    /*
     *********************************************************
     * @Method Name : Managerview
     * @Author : Manish Kripalani (Manish.kripalani@antrazal.com)
     * @Company : Antrazal
     * @Description : This method routes to the manager view for sign-in and sign-up using the provided database name and valid amount.
     * @param : databaseName (String) - The name of the database to be accessed.
     *          amountvalid (Integer) - The valid amount associated with the operation.
     * @return : void
     *********************************************************
     */
    public static void Managerview(String databaseName, Integer amountvalid) throws Exception {
        try {
            ManagerView.managerSignInandSignUp(databaseName, amountvalid);
        } catch (Exception e) {
            throw e;
        }
    }

    /*
     *********************************************************
     * @Method Name : Cashierview
     * @Author : Manish Kripalani (Manish.kripalani@antrazal.com)
     * @Company : Antrazal
     * @Description : This method routes to the cashier view for sign-in and sign-up using the provided database name and valid amount.
     * @param : databaseName (String) - The name of the database to be accessed.
     *          amountvalid (Integer) - The valid amount associated with the operation.
     * @return : void
     *********************************************************
     */
    public static void Cashierview(String databaseName, Integer amountvalid) throws Exception {
        try {
            CashierView.cashierSignInandSignup(databaseName, amountvalid);
        } catch (Exception e) {
            throw e;
        }
    }

    /*
     *********************************************************
     * @Method Name : Adminview
     * @Author : Manish Kripalani (Manish.kripalani@antrazal.com)
     * @Company : Antrazal
     * @Description : This method routes to the admin view for sign-in using the provided database name and valid amount.
     * @param : databaseName (String) - The name of the database to be accessed.
     *          amountvalid (Integer) - The valid amount associated with the operation.
     * @return : void
     *********************************************************
     */
    public static void Adminview(String databaseName, Integer amountvalid) throws Exception {
        try {
            Adminview.adminSignIn(databaseName, amountvalid);
        } catch (Exception e) {
            throw e;
        }
    }
}