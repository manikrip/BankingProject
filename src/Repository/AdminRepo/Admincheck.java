/*
*********************************************************************************************************
 *  @Java Class Name :   Admincheck
 *  @Author          :   Manish Kripalani (Manish.kripalani@antrazal.com)
 *  @Company         :   Antrazal
 *  @Date            :   17-09-2024
 *  @Description     :   This class handles the validation of admin login credentials. It checks if the 
 *                       provided email exists as an admin and proceeds with the login process.
 *********************************************************************************************************
 */

 package Repository.AdminRepo;

 import Pojo.Employee;
 import Repository.DatabaseRepo.ConnectionDB;
import Repository.DatabaseRepo.loginProcess;
import Utils.Constant;
 import Utils.CustomException;
 import view.Adminview;
 
 import java.sql.Connection;
 import java.sql.PreparedStatement;
 import java.sql.ResultSet;
 import java.sql.SQLException;
 
 public class Admincheck {
 
     /*
     *********************************************************
      *  @Method Name    :   adminUsernamePassword
      *  @Author         :   Manish Kripalani (Manish.kripalani@antrazal.com)
      *  @Company        :   Antrazal
      *  @Description    :   Validates the admin login credentials by checking the provided email 
      *                       against the database. If valid, it initiates the login process.
      *  @param          :   dbname (String) - The name of the database.
      *  @param          :   emp (Employee) - The employee object containing admin login details.
      *  @param          :   amount (Integer) - An amount associated with the admin functions.
      *  @return         :   void
      *  @throws         :   SQLException - If an SQL error occurs.
      *                     CustomException - If the login attempt fails.
      *********************************************************
      */
     public static void adminUsernamePassword(String dbname, Employee emp, Integer amount) throws SQLException, Exception, CustomException {
         
         // Establish connection to the database
         ConnectionDB connectionDB = new ConnectionDB();
         Connection connection = connectionDB.con(dbname);
         
         try {
             // Prepare the SQL query to validate the admin's email
             String validateEmail = Constant.VALIDATEEMAIL;
             PreparedStatement preparedStatement = connection.prepareStatement(validateEmail);
             preparedStatement.setString(1, emp.getEmail());
             preparedStatement.setString(2, "Admin");
             
             // Execute the query and check if an admin with the given email exists
             ResultSet resultSet = preparedStatement.executeQuery();
             if (resultSet.next()) {
                 // If admin email is found, proceed to the login process
                 boolean loginSuccessful = loginProcess.login(emp, dbname);
 
                 if (loginSuccessful) {
                     // Redirect to admin functions if login is successful
                     Adminview.adminFunction(dbname, amount);
                 } else {
                     // Handle incorrect password scenario
                     throw new CustomException(Constant.UNSUCCESSFULLYCREATED);
                 }
             } else {
                 // Handle case where email is not found
                 throw new CustomException(Constant.WRONGEMAIL);
             }
 
         } catch (Exception e) {
             throw e; // Rethrow the exception to be handled by the calling method
         } finally {
             // Ensure the connection is closed to prevent resource leaks
             if (connection != null) {
                 connection.close();
             }
         }
     }
 }
 