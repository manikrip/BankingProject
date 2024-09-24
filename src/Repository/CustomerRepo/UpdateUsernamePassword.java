/*
*********************************************************************************************************
 *  @Java Class Name :   UpdateUsernamePassword
 *  @Author          :   Manish Kripalani (manish.kripalani@antrazal.com)
 *  @Company         :   Antrazal
 *  @Date            :   17-09-2024
 *  @Description     :   This class contains methods to update the username and password of an employee 
 *                       or user in the database. It interacts with the database to execute the update 
 *                       queries and handles any potential exceptions.
 *********************************************************************************************************
 */

 package Repository.CustomerRepo;

 import java.sql.Connection;
 import java.sql.PreparedStatement;
 
 import Pojo.Employee;
 import Pojo.Login;
import Repository.DatabaseRepo.ConnectionDB;
import Utils.Constant;
 import Utils.CustomException;
 import Utils.Sout;
 import view.HomePageview;
 
 public class UpdateUsernamePassword {
 
     /*
     *********************************************************
      *  @Method Name    :   updateUserPass
      *  @Author         :   Manish Kripalani (manish.kripalani@antrazal.com)
      *  @Company        :   Antrazal
      *  @Description    :   This method updates the username and password of an Employee in the database.
      *                      It checks how many rows were affected by the update query and proceeds to the 
      *                      home page if the update is successful.
      *  @param          :   emp (Employee) - The Employee object containing the updated credentials.
      *  @param          :   Database (String) - The name of the database to connect to.
      *  @param          :   amount (Integer) - The amount related to the user session or transaction.
      *  @throws         :   Exception, CustomException - If an error occurs during the update process.
      *********************************************************
      */
     public static void updateUserPass(Employee emp, String Database, Integer amount) throws Exception, CustomException {
         boolean loginSuccessful = false; 
         try {
             Connection connection = ConnectionDB.con(Database);
             String updateCredentialsQuery = Constant.UPDATECREDENTIAL;
             PreparedStatement updateStatement = connection.prepareStatement(updateCredentialsQuery);
             updateStatement.setString(1, emp.getUsername());
             updateStatement.setString(2, emp.getPassword());
             updateStatement.setString(3, emp.getEmail());
             int rowsAffected = updateStatement.executeUpdate();
  
             if (rowsAffected > 0) {
                 HomePageview.homePage(Database, amount);
             } else {
                 throw new CustomException(Constant.UNSUCCESSFULLYCREATED);
             }
         } catch (Exception e) {
             throw e;
         }
     }
 
     /*
     *********************************************************
      *  @Method Name    :   updateUserPass
      *  @Author         :   Manish Kripalani (manish.kripalani@antrazal.com)
      *  @Company        :   Antrazal
      *  @Description    :   This method updates the username and password of a Login object in the database.
      *                      Similar to the previous method, it verifies the success of the update and 
      *                      notifies the user accordingly.
      *  @param          :   log (Login) - The Login object containing the updated credentials.
      *  @param          :   dbname (String) - The name of the database to connect to.
      *  @param          :   amount (Integer) - The amount related to the user session or transaction.
      *  @throws         :   Exception - If an error occurs during the update process.
      *********************************************************
      */
     public static void updateUserPass(Login log, String dbname, Integer amount) throws Exception {
         boolean loginSuccessful = false; 
         try {
             Connection connection = ConnectionDB.con(dbname);
             String updateCredentialsQuery = Constant.UPDATECREDENTIAL;
             PreparedStatement updateStatement = connection.prepareStatement(updateCredentialsQuery);
             updateStatement.setString(1, log.getUsername());
             updateStatement.setString(2, log.getPassword());
             updateStatement.setString(3, log.getEmail());
             int rowsAffected = updateStatement.executeUpdate();
  
             if (rowsAffected > 0) {
                 Sout.print(Constant.SUCCESSFULLYCREATED);
                 HomePageview.homePage(dbname, amount);
             } else {
                 throw new CustomException(Constant.UNSUCCESSFULLYCREATED);
             }
         } catch (Exception e) {
             throw e;
         }
     }
 }
 