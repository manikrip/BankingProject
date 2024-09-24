/*
*********************************************************************************************************
 *  @Java Class Name :   jointAccountDeposite
 *  @Author          :   Manish Kripalani (manish.kripalani@antrazal.com)
 *  @Company         :   Antrazal
 *  @Date            :   17-09-2024
 *  @Description     :   This class handles the deposit process for joint accounts. It validates the account 
 *                       number, updates the account balance, and records the transaction in the database.
 *********************************************************************************************************
 */


 package Repository.CashierRepo;
 import java.sql.Connection;
 import java.sql.PreparedStatement;
 import java.sql.ResultSet;
 import java.time.LocalDateTime;
 
 import Pojo.Transaction;
 import Repository.DatabaseRepo.ConnectionDB;
import Utils.Constant;
 import Utils.CustomException;
 import Utils.Sout;
 import view.CashierView;
 
 public class jointAccountDeposite {
 
     /*
     *********************************************************
      *  @Method Name    :   insert
      *  @Author         :   Manish Kripalani (manish.kripalani@antrazal.com)
      *  @Company        :   Antrazal
      *  @Description    :   This method processes a deposit into a joint account. It checks if the account 
      *                      number is valid, calculates the new balance after the deposit, and updates the 
      *                      account and transaction records accordingly.
      *  @param          :   databasename (String) - The name of the database to connect to.
      *  @param          :   amountvalid (Integer) - The amount related to the user session or transaction.
      *  @param          :   trans (Transaction) - The transaction object containing details of the deposit.
      *  @throws         :   Exception, CustomException - If an error occurs during the deposit process.
      *********************************************************
      */
     public static void insert(String databasename, Integer amountvalid, Transaction trans)
             throws Exception, CustomException {
         try {
             Connection connection = ConnectionDB.con(databasename);
             String checkAccountSql = Constant.JOINTACCOUNTCHECK;
             PreparedStatement preparedStatement = connection.prepareStatement(checkAccountSql);
             preparedStatement.setString(1, trans.getAccountNumber());
             ResultSet accountResultSet = preparedStatement.executeQuery();
             if (accountResultSet.next()) {
                 int currentBalance = accountResultSet.getInt("amount");
                 // Calculate the new total amount after the deposit
                 int totalAmount = currentBalance + trans.getAmount();
                 // Query to insert the transaction details
                 String insertTransactionSql = Constant.INSERTTRANSACTION;
                 PreparedStatement insertTransactionStatement = connection.prepareStatement(insertTransactionSql);
                 insertTransactionStatement.setString(1, trans.getAccountNumber());
                 insertTransactionStatement.setInt(2, trans.getAmount());
                 insertTransactionStatement.setString(3, "Deposit");
                 insertTransactionStatement.setTimestamp(4, java.sql.Timestamp.valueOf(LocalDateTime.now()));
 
                 int transactionResult = insertTransactionStatement.executeUpdate();
 
                 // Query to update the account balance
                 String updateBalanceSql = Constant.JOINTACCOUNTUPDATETRANSACTION;
                 PreparedStatement updateBalanceStatement = connection.prepareStatement(updateBalanceSql);
                 updateBalanceStatement.setDouble(1, totalAmount);
                 updateBalanceStatement.setString(2, trans.getAccountNumber());
                 int balanceUpdateResult = updateBalanceStatement.executeUpdate();
 
                 // Output success or failure messages
                 if (transactionResult > 0 && balanceUpdateResult > 0) {
                     Sout.print(Constant.SUCCESSFULLYCREATED);
                     CashierView.cashierFunction(databasename, amountvalid);
                 } else {
                     throw new CustomException(Constant.UNSUCCESSFULLYCREATED);
                 }
 
             } else {
                 throw new CustomException(Constant.INVALIDACCOUNTNUMBER);
             }
 
         } catch (Exception e) {
             throw e;
         }
     }
 }
 