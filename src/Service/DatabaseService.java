/*
*********************************************************************************************************
 *  @Java Class Name :   DatabaseService
 *  @Author          :   Manish Kripalani (Manish.kripalani@antrazal.com)
 *  @Company         :   Antrazal
 *  @Date            :   17-09-2024
 *  @Description     :   This class provides methods to handle database operations such as inserting a new
 *                       database and creating tables. It interacts with the Databaseinsert repository.
 *********************************************************************************************************
 */

 package Service;

 import Repository.DatabaseRepo.Databaseinsert;
 
 public class DatabaseService {
 
     /*
      *********************************************************
      *  @Method Name    :   Databaseservice
      *  @Author         :   Manish Kripalani (Manish.kripalani@antrazal.com)
      *  @Company        :   Antrazal
      *  @Description    :   This method handles the database creation and table creation operations.
      *                      It calls methods from the Databaseinsert repository to insert a new database
      *                      and create the required tables.
      *  @param          :   dbname (String) - The name of the database to be created
      *  @throws         :   Exception - Throws exception if the database creation or table creation fails
      *********************************************************
      */
     public static void Databaseservice(String dbname) throws Exception {
         try {
             Databaseinsert.databaseInsert(dbname);  // Inserts the database
             Databaseinsert.createTables(dbname);    // Creates tables in the database
         } catch (Exception e) {
             throw e;
             // Removed: Databaseview.viewDatabase(); This part is not required
         }
     }
 }
 