/*
*********************************************************************************************************
 *  @Java Class Name :   WithdrawSingle
 *  @Author          :   Manish Kripalani (manish.kripalani@antrazal.com)
 *  @Company         :   Antrazal
 *  @Date            :   17-09-2024
 *  @Description     :   This class contains a method to handle the withdrawal process for single accounts.
 *                       It validates the account number and PIN, checks the current balance, and updates 
 *                       the account and transaction records accordingly.
 *********************************************************************************************************
 */

 package Repository.CustomerRepo;

 import java.sql.Connection;
 import java.sql.PreparedStatement;
 import java.sql.ResultSet;
 import java.time.LocalDateTime;

import Repository.DatabaseRepo.ConnectionDB;
import Utils.Constant;
 import Utils.CustomException;
 import Utils.Sout;
 import view.CustomerView;
 
 public class WithdrawSingle {
 
     /*
     *********************************************************
      *  @Method Name    :   withdraw
      *  @Author         :   Manish Kripalani (manish.kripalani@antrazal.com)
      *  @Company        :   Antrazal
      *  @Description    :   This method processes a withdrawal from a single account. It checks the provided 
      *                      account number and PIN, validates the available balance, and updates the 
      *                      transaction history and account balance.
      *  @param          :   validAccountnumber (String) - The valid account number from which to withdraw.
      *  @param          :   validpin (Integer) - The valid PIN for the single account.
      *  @param          :   amount (Integer) - The amount to withdraw from the account.
      *  @param          :   databasename (String) - The name of the database to connect to.
      *  @param          :   amountvalid (Integer) - The amount related to the user session or transaction.
      *  @throws         :   Exception, CustomException - If an error occurs during the withdrawal process.
      *********************************************************
      */
     public static void withdraw(String validAccountnumber, Integer validpin, Integer amount, String databasename,
             Integer amountvalid) throws Exception, CustomException {
         try {
             Connection connection = ConnectionDB.con(databasename);
             String balanceQuery = Constant.ACCOUNTPIN;
             PreparedStatement balanceStatement = connection.prepareStatement(balanceQuery);
             balanceStatement.setString(1, validAccountnumber);
             balanceStatement.setInt(2, validpin);
             ResultSet balanceResultSet = balanceStatement.executeQuery();
             if (balanceResultSet.next()) {
                 Integer currentBalance = balanceResultSet.getInt("amount");
                 if (amount <= currentBalance) {
                     Integer remainingBalance = currentBalance - amount;
 
                     // Insert the withdrawal transaction into the 'transactions' table
                     String transactionSql = Constant.INSERTTRANSACTION;
                     PreparedStatement transactionStatement = connection.prepareStatement(transactionSql);
                     transactionStatement.setString(1, validAccountnumber);
                     transactionStatement.setInt(2, amount);
                     transactionStatement.setString(3, "Withdraw");
                     transactionStatement.setTimestamp(4, java.sql.Timestamp.valueOf(LocalDateTime.now()));
                     int transactionResult = transactionStatement.executeUpdate();
 
                     // Update the account balance after the withdrawal
                     String updateBalanceSql = Constant.ACCOUNTUPDATETRANSACTION;
                     PreparedStatement updateBalanceStatement = connection.prepareStatement(updateBalanceSql);
                     updateBalanceStatement.setInt(1, remainingBalance);
                     updateBalanceStatement.setString(2, validAccountnumber);
                     int updateResult = updateBalanceStatement.executeUpdate();
 
                     if (transactionResult > 0 && updateResult > 0) {
                        throw new CustomException(Constant.SUCCESSFULLYCREATED);
                     } else {
                         throw new CustomException(Constant.UNSUCCESSFULLYCREATED);
                     }
 
                 } else {
                     throw new CustomException(Constant.INSUFFICIENTAMOUNT);
                 }
 
             } else {
                 throw new CustomException(Constant.INVALIDACCOUNTNUMBER);
             }
 
         } catch (Exception e) {
             throw e;
         }
     }
 }
 