/*
*********************************************************************************************************
 *  @Java Class Name :   DatabaseMiddleware
 *  @Author          :   Manish Kripalani (Manish.kripalani@antrazal.com)
 *  @Company         :   Antrazal
 *  @Date            :   17-09-2024
 *  @Description     :   This class provides middleware for validating the database name and amount. 
 *                       It ensures that the database name consists of only alphabetic characters and 
 *                       the amount is positive before routing or processing.
 *********************************************************************************************************
 */

 package Middleware;

 import Routing.Databaserouting;
 import Utils.Constant;
 import Utils.CustomException;

 
 /*
  *********************************************************
  *  @Method Name    :   databaseMiddleware
  *  @Author         :   Manish Kripalani (Manish.kripalani@antrazal.com)
  *  @Company        :   Antrazal
  *  @Description    :   This method validates the database name, ensuring it consists of only 
  *                      alphabetic characters. If valid, it routes the database; otherwise, 
  *                      it throws a custom exception.
  *  @param          :   dbname (String) - The name of the database to be validated and routed
  *  @throws         :   Exception - Throws exception if the database name is invalid
  *********************************************************
  */
 public class DatabaseMiddleware extends BaseMiddleware  {
     public static void databaseMiddleware(String dbname) throws Exception {
         try {
             if (dbname.matches("[a-zA-Z]+")) {
                 Databaserouting.databaseRouting(dbname);  
             } else {
                 throw new CustomException(Constant.VALIDINPUT);
             }
         } catch (Exception e) {
             throw e;
         }
     }
 
     /*
      *********************************************************
      *  @Method Name    :   databaseAmount
      *  @Author         :   Manish Kripalani (Manish.kripalani@antrazal.com)
      *  @Company        :   Antrazal
      *  @Description    :   This method validates if the amount entered is a positive number 
      *                      using the Positivenumber class. If valid, it returns the amount; 
      *                      otherwise, an exception is thrown.
      *  @param          :   amount (Integer) - The amount to be validated
      *  @return         :   Integer - Validated positive amount
      *********************************************************
      */
    //  public static Integer databaseAmount(Integer amount) throws Exception{
    //      Integer positivenumber = null; // Declare variable outside the try block
    //      try {
    //          // Assuming Positivenumber is a class with a validatePositiveNumber method
    //          Positivenumber positivenumber1 = new Positivenumber(amount, " validNumber" );
    //          positivenumber = positivenumber1.Validator();
    //      } catch (Exception e) {
    //          throw e;
    //      }
    //      return positivenumber; // Return the positive number
    //  }
 }
 