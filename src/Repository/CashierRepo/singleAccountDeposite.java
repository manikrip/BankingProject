/*
*********************************************************************************************************
 *  @Java Class Name :   singleAccountDeposite
 *  @Author          :   Manish Kripalani (manish.kripalani@antrazal.com)
 *  @Company         :   Antrazal
 *  @Date            :   17-09-2024
 *  @Description     :   This class handles the deposit process for single accounts. It validates the account 
 *                       number, updates the account balance, and records the deposit transaction.
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
 
 public class singleAccountDeposite {
 
     /*
     *********************************************************
      *  @Method Name    :   insert
      *  @Author         :   Manish Kripalani (manish.kripalani@antrazal.com)
      *  @Company        :   Antrazal
      *  @Description    :   This method processes a deposit transaction into a single account. It checks if the 
      *                      account exists, updates the balance after the deposit, and logs the transaction.
      *  @param          :   databasename (String) - The name of the database to connect to.
      *  @param          :   amountvalid (Integer) - The valid amount to be passed for further processing.
      *  @param          :   trans (Transaction) - The Transaction object containing account details and amount.
      *  @return         :   void
      *  @throws         :   Exception - If an error occurs during the deposit process.
      *  @throws         :   CustomException - If the account is invalid or the transaction fails.
      *********************************************************
      */
     public static void insert(String databasename, Integer amountvalid, Transaction trans) throws Exception, CustomException {
         try {
             Connection connection = ConnectionDB.con(databasename); // Establish database connection
             String checkAccountSql = Constant.ACCOUNTCHECK; // SQL query to check if account exists
             PreparedStatement preparedStatement = connection.prepareStatement(checkAccountSql);
             preparedStatement.setString(1, trans.getAccountNumber()); // Set account number parameter
             ResultSet accountResultSet = preparedStatement.executeQuery(); // Execute the query
             
             if (accountResultSet.next()) { // If account exists
                 int currentBalance = accountResultSet.getInt("amount"); // Get current balance
                 // Calculate the new total amount after the deposit
                 int totalAmount = currentBalance + trans.getAmount();
                 
                 // Query to insert the transaction details
                 String insertTransactionSql = Constant.INSERTTRANSACTION;
                 PreparedStatement insertTransactionStatement = connection.prepareStatement(insertTransactionSql);
                 insertTransactionStatement.setString(1, trans.getAccountNumber());
                 insertTransactionStatement.setInt(2, trans.getAmount());
                 insertTransactionStatement.setString(3, "Deposit");
                 insertTransactionStatement.setTimestamp(4, java.sql.Timestamp.valueOf(LocalDateTime.now())); // Set transaction time
                 
                 int transactionResult = insertTransactionStatement.executeUpdate(); // Execute transaction insertion
                 
                 // Query to update the account balance
                 String updateBalanceSql = Constant.ACCOUNTUPDATETRANSACTION;
                 PreparedStatement updateBalanceStatement = connection.prepareStatement(updateBalanceSql);
                 updateBalanceStatement.setDouble(1, totalAmount); // Set new balance
                 updateBalanceStatement.setString(2, trans.getAccountNumber());
                 int balanceUpdateResult = updateBalanceStatement.executeUpdate(); // Execute balance update
 
                 // Output success or failure messages
                 if (transactionResult > 0 && balanceUpdateResult > 0) {
                     Sout.print(Constant.SUCCESSFULLYCREATED); // Print success message
                     CashierView.cashierFunction(databasename, amountvalid); // Navigate to cashier function
                 } else {
                     throw new CustomException(Constant.UNSUCCESSFULLYCREATED); // Throw exception if update fails
                 }
             } else {
                 throw new CustomException(Constant.INVALIDACCOUNTNUMBER); // Throw exception if account is invalid
             }
         } catch (Exception e) {
             throw e; // Rethrow any exception encountered
         }
     }
 }
 