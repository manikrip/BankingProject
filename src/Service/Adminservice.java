/*
*********************************************************************************************************
 *  @Java Class Name :   Adminservice
 *  @Author          :   Manish Kripalani (Manish.kripalani@antrazal.com)
 *  @Company         :   Antrazal
 *  @Date            :   17-09-2024
 *  @Description     :   This class provides service methods for admin operations such as login, 
 *                       sign-in, email creation for managers and cashiers, and branch creation. 
 *                       It handles interaction with the respective repository classes.
 *********************************************************************************************************
 */

 package Service;

 import Pojo.Branch;
 import Pojo.Employee;
import Repository.AdminRepo.Admincheck;
import Repository.AdminRepo.Admininsert;
import Repository.AdminRepo.BranchInsert;
import Repository.AdminRepo.CashierEmailInsert;
import Repository.AdminRepo.ManagerEmailInsert;
 
 /*
  *********************************************************
  *  @Method Name    :   adminLogin
  *  @Author         :   Manish Kripalani (Manish.kripalani@antrazal.com)
  *  @Company        :   Antrazal
  *  @Description    :   This method is responsible for handling the admin login process by 
  *                      calling the adminCreation method in the Admininsert repository.
  *  @param          :   emp (Employee) - Employee object with admin credentials
  *                      dbname (String) - Database name to perform the operation on
  *  @throws         :   Exception - Throws exception if login fails
  *********************************************************
  */
 public class Adminservice {
 
     public static void adminLogin(Employee emp, String dbname) throws Exception {
         try {
             Admininsert.adminCreation(dbname, emp);
         } catch (Exception e) {
             throw e;
         }
     }
 
     /*
      *********************************************************
      *  @Method Name    :   adminSignIn
      *  @Author         :   Manish Kripalani (Manish.kripalani@antrazal.com)
      *  @Company        :   Antrazal
      *  @Description    :   This method allows the admin to sign in by checking the username 
      *                      and password using the Admincheck repository.
      *  @param          :   emp (Employee) - Employee object with admin credentials
      *                      dbname (String) - Database name to validate credentials
      *                      amount (Integer) - Amount associated with admin sign-in
      *  @throws         :   Exception - Throws exception if sign-in fails
      *********************************************************
      */
     public static void adminSignIn(Employee emp, String dbname, Integer amount) throws Exception {
         try {
             Admincheck.adminUsernamePassword(dbname, emp, amount);
         } catch (Exception e) {
             throw e;
         }
     }
 
     /*
      *********************************************************
      *  @Method Name    :   managerMail
      *  @Author         :   Manish Kripalani (Manish.kripalani@antrazal.com)
      *  @Company        :   Antrazal
      *  @Description    :   This method is responsible for creating manager emails by calling 
      *                      the emailCreated method in the ManagerEmailInsert repository.
      *  @param          :   emp (Employee) - Employee object representing the manager
      *                      dbname (String) - Database name where the operation is performed
      *                      amount (Integer) - Amount linked to the email creation
      *  @throws         :   Exception - Throws exception if email creation fails
      *********************************************************
      */
     public static void managerMail(Employee emp, String dbname, Integer amount) throws Exception {
         try {
             ManagerEmailInsert.emailCreated(emp, dbname, amount);
         } catch (Exception e) {
             throw e;
         }
     }
 
     /*
      *********************************************************
      *  @Method Name    :   branchCreate
      *  @Author         :   Manish Kripalani (Manish.kripalani@antrazal.com)
      *  @Company        :   Antrazal
      *  @Description    :   This method creates a new branch by calling the insert method in 
      *                      the BranchInsert repository.
      *  @param          :   br (Branch) - Branch object containing branch details
      *                      dbname (String) - Database name for branch insertion
      *                      amount (Integer) - Amount associated with branch creation
      *  @throws         :   Exception - Throws exception if branch creation fails
      *********************************************************
      */
     public static void branchCreate(Branch br, String dbname, Integer amount) throws Exception {
         try {
             BranchInsert.insert(br, dbname, amount);
         } catch (Exception e) {
             throw e;
         }
     }
 
     /*
      *********************************************************
      *  @Method Name    :   cashierMail
      *  @Author         :   Manish Kripalani (Manish.kripalani@antrazal.com)
      *  @Company        :   Antrazal
      *  @Description    :   This method is responsible for creating cashier emails by calling 
      *                      the emailCreated method in the CashierEmailInsert repository.
      *  @param          :   emp (Employee) - Employee object representing the cashier
      *                      dbname (String) - Database name where the operation is performed
      *                      amount (Integer) - Amount linked to the email creation
      *  @throws         :   Exception - Throws exception if email creation fails
      *********************************************************
      */
     public static void cashierMail(Employee emp, String dbname, Integer amount) throws Exception {
         try {
             CashierEmailInsert.emailCreated(emp, dbname, amount);
         } catch (Exception e) {
             throw e;
         }
     }
 }
 