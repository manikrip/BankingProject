package controller;

import Pojo.Branch; // Importing Branch class for branch-related operations
import Pojo.Employee; // Importing Employee class for employee-related operations
import Service.Adminservice; // Importing Adminservice to handle business logic related to admin operations

/*
 *********************************************************
 *  @Class Name     :   AdminController
 *  @Description    :   This class acts as a controller for 
 *                      admin-related operations. It manages 
 *                      interactions between the user interface 
 *                      and the Adminservice for handling 
 *                      admin login, sign-in, branch creation, 
 *                      and managing emails for managers and cashiers.
 *********************************************************
 */
public class AdminController {

    /*
     *********************************************************
     *  @Method Name    :   adminLogin
     *  @Description    :   Handles the admin login process.
     *  @param          :   emp - Employee object containing 
     *                      admin details
     *                      dbname - Database name
     *  @return         :   void
     *********************************************************
     */
    public static void adminLogin(Employee emp, String dbname) throws Exception {
        try {
            Adminservice.adminLogin(emp, dbname);
        } catch (Exception e) {
            throw e;
        }
    }

    /*
     *********************************************************
     *  @Method Name    :   adminSignIn
     *  @Description    :   Handles the admin sign-in process.
     *  @param          :   emp - Employee object containing 
     *                      admin details
     *                      dbname - Database name
     *                      amount - Valid amount for operation
     *  @return         :   void
     *********************************************************
     */
    public static void adminSignIn(Employee emp, String dbname, Integer amount) throws Exception {
        try {
            Adminservice.adminSignIn(emp, dbname, amount);
        } catch (Exception e) {
            throw e;
        }
    }

    /*
     *********************************************************
     *  @Method Name    :   managerMail
     *  @Description    :   Handles the creation or validation 
     *                      of manager email.
     *  @param          :   emp - Employee object containing 
     *                      manager details
     *                      dbname - Database name
     *                      amount - Valid amount for operation
     *  @return         :   void
     *********************************************************
     */
    public static void managerMail(Employee emp, String dbname, Integer amount) throws Exception {
        try {
            Adminservice.managerMail(emp, dbname, amount);
        } catch (Exception e) {
            throw e;
        }
    }

    /*
     *********************************************************
     *  @Method Name    :   branchCreate
     *  @Description    :   Handles the creation of a new branch.
     *  @param          :   br - Branch object containing 
     *                      branch details
     *                      dbname - Database name
     *                      amount - Valid amount for operation
     *  @return         :   void
     *********************************************************
     */
    public static void branchCreate(Branch br, String dbname, Integer amount) throws Exception {
        try {
            Adminservice.branchCreate(br, dbname, amount);
        } catch (Exception e) {
            throw e;
        }
    }

    /*
     *********************************************************
     *  @Method Name    :   cashierEmail
     *  @Description    :   Handles the creation or validation 
     *                      of cashier email.
     *  @param          :   emp - Employee object containing 
     *                      cashier details
     *                      dbname - Database name
     *                      amount - Valid amount for operation
     *  @return         :   void
     *********************************************************
     */
    public static void cashierEmail(Employee emp, String dbname, Integer amount) throws Exception {
        try {
            Adminservice.cashierMail(emp, dbname, amount);
        } catch (Exception e) {
            throw e;
        }
    }
}
