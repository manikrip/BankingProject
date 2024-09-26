/*
*********************************************************************************************************
 *  @Java Class Name :   ManagerUpdateAccount
 *  @Author          :   Manish Kripalani (manish.kripalani@antrazal.com)
 *  @Company         :   Antrazal
 *  @Date            :   17-09-2024
 *  @Description     :   This class handles the update of account details for a customer in the database. 
 *                       It checks whether the specified Pan Card number exists and then updates the 
 *                       customer's name and email accordingly.
 *********************************************************************************************************
 */

 package Repository.ManagerRepo;

 import java.sql.Connection;
 import java.sql.PreparedStatement;
 import java.sql.ResultSet;
 
 import Pojo.Customer;
 import Repository.DatabaseRepo.ConnectionDB;
import Utils.Constant;
 import Utils.CustomException;
 import Utils.Sout;
 import view.ManagerView;
 
 public class ManagerUpdateAccount {
 
     /*
     *********************************************************
      *  @Method Name    :   update
      *  @Author         :   Manish Kripalani (manish.kripalani@antrazal.com)
      *  @Company        :   Antrazal
      *  @Description    :   This method updates the account details of a customer in the database. It checks 
      *                      for the existence of the specified Pan Card number before updating the customer's 
      *                      name and email. If the update is successful, it notifies the user; otherwise, 
      *                      it throws a custom exception.
      *  @param          :   databaseName (String) - The name of the database to connect to.
      *  @param          :   amountvalid (Integer) - A parameter indicating a certain amount, potentially for validation.
      *  @param          :   customer (Customer) - The customer object containing updated details.
      *  @throws         :   Exception - If any error occurs during database operations.
      *  @throws         :   CustomException - For specific error conditions like unsuccessful updates.
      *********************************************************
     */
     public static void update(String databaseName, Integer amountvalid, Customer customer) throws Exception, CustomException {
         PreparedStatement selectPreparedStatement = null;
         PreparedStatement updatePreparedStatement = null;
         ConnectionDB connectionDB = new ConnectionDB();
         Connection connection = connectionDB.con(databaseName);
         ResultSet resultSet = null;
         try {
             String selectQuery = Constant.PANCARDCHECK;
             selectPreparedStatement = connection.prepareStatement(selectQuery);
             selectPreparedStatement.setString(1, customer.getPancard());
             resultSet = selectPreparedStatement.executeQuery();
             if (resultSet.next()) {
                 String updateQuery = Constant.UPDATEACCOUNT;
                 updatePreparedStatement = connection.prepareStatement(updateQuery);
                 updatePreparedStatement.setString(1, customer.getName());
                 updatePreparedStatement.setString(2, customer.getEmail());
                 updatePreparedStatement.setString(3, customer.getPancard());
 
                 // Execute the update and check if rows were affected
                 int rowsAffected = updatePreparedStatement.executeUpdate();
 
                 // Notify user of the success or failure of the update
                 if (rowsAffected > 0) {
                    throw new CustomException(Constant.SUCCESSFULLYCREATED);
                 } else {
                     throw new CustomException(Constant.UNSUCCESSFULLYCREATED);
                 }
             }
         } catch (Exception e) {
             throw e;
         }
     }
 }
 