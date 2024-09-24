/*
*********************************************************************************************************
 *  @Java Class Name :   AdminRouting
 *  @Author          :   Manish Kripalani (Manish.kripalani@antrazal.com)
 *  @Company         :   Antrazal
 *  @Date            :   17-09-2024
 *  @Description     :   This class provides routing functionality for admin operations, including 
 *                       logging in, signing in, and managing views related to managers, branches, 
 *                       and cashiers. It delegates requests to the respective controllers and views.
 *********************************************************************************************************
 */

 package Routing;

 import Pojo.Branch;
 import Pojo.Employee;
 import Service.CashierService;
 import controller.AdminController;
 import view.Adminview;
 public class AdminRouting
 {
 
 /*
 *********************************************************
  *  @Method Name    :   adminLogin
  *  @Author         :   Manish Kripalani (Manish.kripalani@antrazal.com)
  *  @Company        :   Antrazal
  *  @Description    :   This method routes the login request for the admin using the provided Employee 
  *                      object and database name.
  *  @param          :   emp (Employee) - The Employee object containing admin credentials.
  *  @param          :   dbname (String) - The name of the database to be accessed.
  *  @return         :   void
  *********************************************************
  */
 public static void adminLogin(Employee emp, String dbname) throws Exception {
     try {
         AdminController.adminLogin(emp, dbname);
     } catch (Exception e) {
         throw e;
     }
 }
 
 /*
 *********************************************************
  *  @Method Name    :   adminSignIn
  *  @Author         :   Manish Kripalani (Manish.kripalani@antrazal.com)
  *  @Company        :   Antrazal
  *  @Description    :   This method routes the sign-in request for the admin using the provided Employee 
  *                      object, database name, and amount.
  *  @param          :   emp (Employee) - The Employee object for the admin signing in.
  *  @param          :   dbname (String) - The name of the database to be accessed.
  *  @param          :   amount (Integer) - The amount related to the sign-in process.
  *  @return         :   void
  *********************************************************
  */
 public static void adminSignIn(Employee emp, String dbname, Integer amount) throws Exception {
     try {
         AdminController.adminSignIn(emp, dbname, amount);
     } catch (Exception e) {
         throw e;
     }
 }
 
 /*
 *********************************************************
  *  @Method Name    :   adminmanagerView
  *  @Author         :   Manish Kripalani (Manish.kripalani@antrazal.com)
  *  @Company        :   Antrazal
  *  @Description    :   This method routes the request to create a manager email view using the database name 
  *                      and amount provided.
  *  @param          :   dbname (String) - The name of the database to be accessed.
  *  @param          :   amount (Integer) - The amount related to the manager view creation.
  *  @return         :   void
  *********************************************************
  */
 public static void adminmanagerView(String dbname, Integer amount) throws Exception {
     try {
         Adminview.createManagermail(dbname, amount);
     } catch (Exception e) {
         throw e;
     }
 }
 
 /*
 *********************************************************
  *  @Method Name    :   adminbranchView
  *  @Author         :   Manish Kripalani (Manish.kripalani@antrazal.com)
  *  @Company        :   Antrazal
  *  @Description    :   This method routes the request to create a branch view using the database name and 
  *                      amount provided.
  *  @param          :   dbname (String) - The name of the database to be accessed.
  *  @param          :   amount (Integer) - The amount related to the branch view creation.
  *  @return         :   void
  *********************************************************
  */
 public static void adminbranchView(String dbname, Integer amount) throws Exception {
     try {
         Adminview.createBranch(dbname, amount);
     } catch (Exception e) {
         throw e;
     }
 }
 
 /*
 *********************************************************
  *  @Method Name    :   admincashierView
  *  @Author         :   Manish Kripalani (Manish.kripalani@antrazal.com)
  *  @Company        :   Antrazal
  *  @Description    :   This method routes the request to create a cashier email view using the database name 
  *                      and amount provided.
  *  @param          :   dbname (String) - The name of the database to be accessed.
  *  @param          :   amount (Integer) - The amount related to the cashier view creation.
  *  @return         :   void
  *********************************************************
  */
 public static void admincashierView(String dbname, Integer amount) throws Exception {
     try {
         Adminview.createCashieremail(dbname, amount);
     } catch (Exception e) {
         throw e;
     }
 }
 
 /*
 *********************************************************
  *  @Method Name    :   managerEmail
  *  @Author         :   Manish Kripalani (Manish.kripalani@antrazal.com)
  *  @Company        :   Antrazal
  *  @Description    :   This method routes the request to send manager email using the provided Employee 
  *                      object, database name, and amount.
  *  @param          :   emp (Employee) - The Employee object for the manager.
  *  @param          :   dbname (String) - The name of the database to be accessed.
  *  @param          :   amount (Integer) - The amount related to the manager email process.
  *  @return         :   void
  *********************************************************
  */
 public static void managerEmail(Employee emp, String dbname, Integer amount) throws Exception {
     try {
         AdminController.managerMail(emp, dbname, amount);
     } catch (Exception e) {
         throw e;
     }
 }
 
 /*
 *********************************************************
  *  @Method Name    :   branchCreate
  *  @Author         :   Manish Kripalani (Manish.kripalani@antrazal.com)
  *  @Company        :   Antrazal
  *  @Description    :   This method routes the request to create a branch using the provided Branch object, 
  *                      database name, and amount.
  *  @param          :   br (Branch) - The Branch object containing branch details.
  *  @param          :   dbname (String) - The name of the database to be accessed.
  *  @param          :   amount (Integer) - The amount related to the branch creation.
  *  @return         :   void
  *********************************************************
  */
 public static void branchCreate(Branch br, String dbname, Integer amount) throws Exception {
     try {
         AdminController.branchCreate(br, dbname, amount);
     } catch (Exception e) {
         throw e;
     }
 }
 
 /*
 *********************************************************
  *  @Method Name    :   cashierEmail
  *  @Author         :   Manish Kripalani (Manish.kripalani@antrazal.com)
  *  @Company        :   Antrazal
  *  @Description    :   This method routes the request to send cashier email using the provided Employee 
  *                      object, database name, and amount.
  *  @param          :   emp (Employee) - The Employee object for the cashier.
  *  @param          :   dbname (String) - The name of the database to be accessed.
  *  @param          :   amount (Integer) - The amount related to the cashier email process.
  *  @return         :   void
  *********************************************************
  */
 public static void cashierEmail(Employee emp, String dbname, Integer amount) throws Exception {
     try {
         AdminController.cashierEmail(emp, dbname, amount);
     } catch (Exception e) {
         throw e;
     }
 }
}