/*
*********************************************************************************************************
 *  @Java Class Name :   Databaseinsert
 *  @Author          :   Manish Kripalani (manish.kripalani@antrazal.com)
 *  @Company         :   Antrazal
 *  @Date            :   17-09-2024
 *  @Description     :   This class provides functionality for creating a database and its tables. 
 *                       It includes methods to execute SQL queries for database creation and table creation.
 *******************************************************************************************************
 */

 package Repository.DatabaseRepo;

 import java.sql.Connection;
 import java.sql.PreparedStatement;
 import java.sql.SQLException;
 
 import Utils.Constant;
 import Utils.CustomException;
 import Utils.Sout;
 
 public class Databaseinsert {
 
     /*
     *********************************************************
      *  @Method Name    :   databaseInsert
      *  @Author         :   Manish Kripalani (manish.kripalani@antrazal.com)
      *  @Company        :   Antrazal
      *  @Description    :   This method creates a new database with the specified name.
      *  @param          :   dbname (String) - The name of the database to be created.
      *  @throws         :   CustomException - If an error occurs during database creation.
      *********************************************************
     */
     public static void databaseInsert(String dbname) throws CustomException {
         try {
             ConnectionDB connectionDB = new ConnectionDB();
             Connection connection = connectionDB.con("");  // Connect to the default database
             
             // SQL query to create the database
             String createDatabaseSQL = "CREATE DATABASE " + dbname;
             PreparedStatement preparedStatement = connection.prepareStatement(createDatabaseSQL);
 
             // Execute the SQL query to create the database
             int result = preparedStatement.executeUpdate();
 
             // Check if the database was successfully created
             if (result < 0) {
                Error er = new Error();
                throw new CustomException(Constant.DATABASEERROR); 
             } 
 
             // Clean up resources by closing the statement and connection
             preparedStatement.close();
             connection.close();
 
         } catch (Exception e) {
             throw new CustomException(e.getMessage());
         }
     }
 
     /*
     *********************************************************
      *  @Method Name    :   createTables
      *  @Author         :   Manish Kripalani (manish.kripalani@antrazal.com)
      *  @Company        :   Antrazal
      *  @Description    :   This method creates the necessary tables in the specified database.
      *  @param          :   dbName (String) - The name of the database where the tables will be created.
      *  @throws         :   Exception - If an error occurs during table creation.
      *********************************************************
     */
     public static void createTables(String dbName) throws Exception {
         try {
             ConnectionDB connectionDB = new ConnectionDB();
             Connection connection = connectionDB.con(dbName); 
 
             // Create account table
             String createAccountTable = Constant.createAccountTable;
             ExecuteQuery.executeUpdate(connection, createAccountTable);
 
             // Create employee table
             String Employee = Constant.Employee;
             ExecuteQuery.executeUpdate(connection, Employee);
 
             // Create joint account table
             String createJointAccountTable = Constant.createJointAccountTable;
             ExecuteQuery.executeUpdate(connection, createJointAccountTable);
 
             // Create loan table
             String createLoanTable = Constant.createLoanTable;
             ExecuteQuery.executeUpdate(connection, createLoanTable);
 
             // Create branch table
             String createBranchTable = Constant.createBranchTable;
             ExecuteQuery.executeUpdate(connection, createBranchTable);
 
             // Create transactions table
             String createTransactionsTable = Constant.createTransactionsTable;
             ExecuteQuery.executeUpdate(connection, createTransactionsTable);
             
             // Create password and username table
             String passwordUsername = Constant.passwordUsername;
             ExecuteQuery.executeUpdate(connection, passwordUsername);
 
             Sout.print(Constant.SUCCESSFULLYCREATED);
 
         } catch (SQLException e) {
             throw e;
         }
     }
 }
 