/*
*********************************************************************************************************
 *  @Java Class Name :   ManagerUserCreated
 *  @Author          :   Manish Kripalani (manish.kripalani@antrazal.com)
 *  @Company         :   Antrazal
 *  @Date            :   17-09-2024
 *  @Description     :   This class handles the creation of a username for an employee. It validates the 
 *                       employee's email and designation before proceeding to update the username and 
 *                       password for the employee in the database.
 *********************************************************************************************************
 */

 package Repository.ManagerRepo;

 import java.sql.Connection;
 import java.sql.PreparedStatement;
 import java.sql.ResultSet;
 
 import Pojo.Employee;
import Repository.CustomerRepo.UpdateUsernamePassword;
import Repository.DatabaseRepo.*;
import Utils.Constant;
 import Utils.CustomException;
 
 public class ManagerUserCreated {
 
     /*
     *********************************************************
      *  @Method Name    :   usernamecreated
      *  @Author         :   Manish Kripalani (manish.kripalani@antrazal.com)
      *  @Company        :   Antrazal
      *  @Description    :   This method validates the employee's email and designation. If the email is valid,
      *                      it proceeds to update the username and password for the employee. If the email is 
      *                      invalid, a custom exception is thrown.
      *  @param          :   emp (Employee) - The employee object containing email and designation details.
      *  @param          :   databaseName (String) - The name of the database to connect to.
      *  @param          :   amountvalid (Integer) - A parameter indicating a certain amount, potentially for validation.
      *  @throws         :   Exception - If any error occurs during database operations.
      *  @throws         :   CustomException - For specific error conditions like invalid email.
      *********************************************************
     */
     public static void usernamecreated(Employee emp, String databaseName, Integer amountvalid) throws Exception, CustomException {
         PreparedStatement preparedStatement = null;
         ConnectionDB connectionDB = new ConnectionDB();
         Connection connection = connectionDB.con(databaseName);
         try {
             String query = Constant.VALIDATEEMAIL;
             preparedStatement = connection.prepareStatement(query);
             preparedStatement.setString(1, emp.getEmail());
             preparedStatement.setString(2, emp.getDesignation());
             ResultSet resultSet = preparedStatement.executeQuery();
             if (resultSet.next()) {
                 UpdateUsernamePassword.updateUserPass(emp, databaseName, amountvalid);
             } else {
                 throw new CustomException(Constant.VALIDEMAIL);
             }
         } catch (Exception e) {
             throw e;
         }
     }
 
 }
 