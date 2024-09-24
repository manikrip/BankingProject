/*
*********************************************************************************************************
 *  @Java Class Name :   HomePageview
 *  @Author          :   Manish Kripalani (Manish.kripalani@antrazal.com)
 *  @Company         :   Antrazal
 *  @Date            :   17-09-2024
 *  @Description     :   This class contains a method to display the home page of the application. It prompts 
 *                       the user to select an option and processes the input using the HomepageMiddleware 
 *                       class. If an exception occurs, it handles the error and allows the user to retry.
 *********************************************************************************************************
 */

 package view;

 import Middleware.HomepageMiddleware;
 import Utils.Constant;
 import Utils.TakingInput;
 
 /*
  *********************************************************
   *  @Method Name    :   homePage
   *  @Author         :   Manish Kripalani (Manish.kripalani@antrazal.com)
   *  @Company        :   Antrazal
   *  @Description    :   This method displays the home page options, retrieves user input, and delegates 
   *                      processing to the HomepageMiddleware. It also handles exceptions and allows for 
   *                      retrying the home page display in case of errors.
   *  @param          :   databaseName (String) - The name of the database being used
   *                      amountvalid (Integer) - The valid amount entered by the user
   *  @throws         :   Exception - Throws an exception in case of an error
   *********************************************************
   */
 public class HomePageview {
 
     public static void homePage(String databaseName, Integer amountvalid) throws Exception {
         try {
             Constant.Homepageoption();
             String option = TakingInput.input().nextLine();
             HomepageMiddleware.homepageMiddleware(option, databaseName, amountvalid);
         } catch (Exception e) {
             System.out.println(e.getMessage());
             homePage(databaseName, amountvalid);
         }
     }
 }
 