/*
*********************************************************************************************************
 *  @Java Class Name :   Databaserouting
 *  @Author          :   Manish Kripalani (Manish.kripalani@antrazal.com)
 *  @Company         :   Antrazal
 *  @Date            :   17-09-2024
 *  @Description     :   This class provides routing functionality for database operations. 
 *                       It facilitates the control of database access by delegating requests 
 *                       to the DatabaseController class.
 *********************************************************************************************************
 */

 package Routing;

 import controller.DatabaseController;
 
 /*
 *********************************************************
  *  @Method Name    :   databaseRouting
  *  @Author         :   Manish Kripalani (Manish.kripalani@antrazal.com)
  *  @Company        :   Antrazal
  *  @Description    :   This method routes database requests to the appropriate controller based on 
  *                      the provided database name. It throws an exception if any error occurs during 
  *                      the routing process.
  *  @param          :   dbname (String) - The name of the database to route the request.
  *  @return         :   void
  *********************************************************
  */
 public class Databaserouting {
     public static void databaseRouting(String dbname) throws Exception {
         try {
             DatabaseController.databaseController(dbname);
         } catch (Exception e) {
             throw e;        
         }
     }
 }
 