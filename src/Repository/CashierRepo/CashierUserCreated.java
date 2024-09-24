/*
*********************************************************************************************************
 *  @Java Class Name :   CashierUserCreated
 *  @Author          :   Manish Kripalani (manish.kripalani@antrazal.com)
 *  @Company         :   Antrazal
 *  @Date            :   17-09-2024
 *  @Description     :   This class handles the creation of a cashier user. It checks if the provided 
 *                       email is valid for the cashier's designation. If valid, it proceeds to update 
 *                       the username and password.
 *********************************************************************************************************
 */

 package Repository.CashierRepo;

 import java.sql.Connection;
 import java.sql.PreparedStatement;
 import java.sql.ResultSet;
 import Pojo.Employee;
import Utils.Constant;
 import Utils.CustomException;
import Repository.CustomerRepo.UpdateUsernamePassword;
import Repository.DatabaseRepo.ConnectionDB;
 public class CashierUserCreated {
 
     /*
     *********************************************************
      *  @Method Name    :   usernamecreated
      *  @Author         :   Manish Kripalani (manish.kripalani@antrazal.com)
      *  @Company        :   Antrazal
      *  @Description    :   Checks if the given email is valid for the cashier's designation. If valid,
      *                      it updates the username and password.
      *  @param          :   emp (Employee) - The employee object containing cashier details.
      *  @param          :   databaseName (String) - The name of the database.
      *  @param          :   amountvalid (Integer) - An amount for further processing.
      *  @return         :   void
      *  @throws         :   Exception - For general exceptions.
      *                     CustomException - If the email is not valid.
      *********************************************************
      */
     public static void usernamecreated(Employee emp, String databaseName, Integer amountvalid) throws Exception, CustomException {
         PreparedStatement preparedStatement = null;
         Connection connection = ConnectionDB.con(databaseName);
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
 