/*
*********************************************************************************************************
 *  @Java Class Name :   Databaseview
 *  @Author          :   Manish Kripalani (Manish.kripalani@antrazal.com)
 *  @Company         :   Antrazal
 *  @Date            :   24-09-2024
 *  @Description     :   This class handles the database view functionality. It prompts the user to input a 
 *                       database name, validates the database, and proceeds to further actions such as 
 *                       admin login and navigating to the homepage based on user inputs.
 *********************************************************************************************************
 */

 package view;

 import Middleware.DatabaseMiddleware;
 import Utils.Constant;
 import Utils.Sout;
 import Utils.TakingInput;
 
 /*
  *********************************************************
  *  @Method Name    :   viewDatabase
  *  @Author         :   Manish Kripalani (Manish.kripalani@antrazal.com)
  *  @Company        :   Antrazal
  *  @Description    :   This method prompts the user to enter a database name and handles the middleware
  *                      to validate the database. It also takes input for a limit amount, logs the user
  *                      in as admin, and navigates to the home page. In case of any exception, the method
  *                      recalls itself for a new database input.
  *  @param          :   None
  *  @return         :   void
  *********************************************************
  */
 public class Databaseview {
     public static void viewDatabase() {
         try {
             // Display available databases to the user
             Constant.viewDatabase();
             
             // Take user input for the database name
             String DatabaseName = TakingInput.input().nextLine();
             
             // Validate the database name using middleware
             DatabaseMiddleware.databaseMiddleware(DatabaseName);
             
             // Prompt the user to enter a limit amount
             Sout.print(Constant.LIMITAMOUNT);
             Integer amount = TakingInput.input().nextInt();
 
             // Validate the amount using middleware
             Integer amountvalid = DatabaseMiddleware.databaseAmount(amount);
             
             // Proceed with admin login
             Adminview.adminLogin(DatabaseName);
 
             // Navigate to the home page after successful login of admin
             HomePageview.homePage(DatabaseName, amountvalid);
         } catch (Exception e) {
             // Print the error message and recursively prompt for a new database name in case of failure
             System.out.println(e.getMessage());
             Databaseview.viewDatabase();
         }
     }
 }
 