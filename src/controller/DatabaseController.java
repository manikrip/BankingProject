package controller;

import Service.DatabaseService; // Importing DatabaseService for database operations

/*
 *********************************************************
 *  @Class Name     :   DatabaseController
 *  @Description    :   This class acts as a controller for
 *                      database operations, managing calls to
 *                      the DatabaseService to execute actions
 *                      on a specified database.
 *********************************************************
 */
public class DatabaseController {
    
    /*
     *********************************************************
     *  @Method Name    :   databaseController
     *  @Description    :   This method interacts with the DatabaseService to perform
     *                      operations on the specified database.
     *  @param          :   dbname - Name of the database to operate on
     *  @return         :   void
     *********************************************************
     */
    public static void databaseController(String dbname) throws Exception {
        try {
            DatabaseService.Databaseservice(dbname); // Call service to handle database operations
        } catch (Exception e) {
            throw e; // Rethrow exception for higher-level handling
        }
    }
}
