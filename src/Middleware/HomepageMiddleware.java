/*
*********************************************************************************************************
 *  @Java Class Name :   HomepageMiddleware
 *  @Author          :   Manish Kripalani (Manish.kripalani@antrazal.com)
 *  @Company         :   Antrazal
 *  @Date            :   17-09-2024
 *  @Description     :   This class contains a method to handle the middleware logic for the home page 
 *                       based on the user's selected option. It directs the user to various views depending 
 *                       on the option chosen.
 *********************************************************************************************************
 */

 package Middleware;

 import Routing.HomePagerouting;
 import Utils.Constant;
 import Utils.Sout;
 import view.HomePageview;
 
 /*
  *********************************************************
   *  @Method Name    :   homepageMiddleware
   *  @Author         :   Manish Kripalani (Manish.kripalani@antrazal.com)
   *  @Company        :   Antrazal
   *  @Description    :   This method processes the user's selected option and directs them to the appropriate 
   *                      view (Customer, Manager, Cashier, Admin) or exits the application. It throws an 
   *                      exception if an error occurs during the process.
   *  @param          :   option (String) - The option selected by the user
   *                      databaseName (String) - The name of the database being used
   *                      amountvalid (Integer) - The valid amount entered by the user
   *  @throws         :   Exception - Throws an exception in case of an error
   *********************************************************
   */
 public class HomepageMiddleware {
 
     public static void homepageMiddleware(String option, String databaseName, Integer amountvalid) throws Exception {
         try {
             switch (option) {
                 case "1":
                     Sout.print(Constant.CUSTOMER);
                     HomePagerouting.Customerview(databaseName, amountvalid);
                     break;
                 case "2":
                     Sout.print(Constant.MANAGER);
                     HomePagerouting.Managerview(databaseName, amountvalid);
                     break;
                 case "3":
                     Sout.print(Constant.CASHIER);
                     HomePagerouting.Cashierview(databaseName, amountvalid);
                     break;
                 case "4":
                     Sout.print(Constant.ADMIN);
                     HomePagerouting.Adminview(databaseName, amountvalid);
                     break;
                 case "5":
                     Sout.print(Constant.EXIT);
                     break;
                 default:
                     Sout.print(Constant.WRONGOPTION);
                     HomePageview.homePage(databaseName, amountvalid);
                     break;
             }
         } catch (Exception e) {
             throw e;
         }
     }
 }
 