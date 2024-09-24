/*
*********************************************************************************************************
 *  @Java Class Name :   CustomerUndoTransaction
 *  @Author          :   Manish Kripalani (manish.kripalani@antrazal.com)
 *  @Company         :   Antrazal
 *  @Date            :   17-09-2024
 *  @Description     :   This class handles the process of undoing a recent transaction for a customer account.
 *                       It checks if the transaction can be undone based on the time elapsed since it was made
 *                       and adjusts the account balance accordingly.
 *******************************************************************************************************
*/
package Repository.ManagerRepo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;

import Repository.DatabaseRepo.ConnectionDB;

import java.time.Duration;
import Utils.Constant;
import Utils.CustomException;
import Utils.Sout;
import view.ManagerView;

public class CustomerUndoTransaction {

    /*
    *********************************************************
     *  @Method Name    :   undo
     *  @Author         :   Manish Kripalani (manish.kripalani@antrazal.com)
     *  @Company        :   Antrazal
     *  @Description    :   Undoes the last transaction of the specified account if it was made within the last 10 minutes.
     *                      Updates the account balance and optionally deletes the transaction record.
     *  @param          :   databaseName (String) - The name of the database to connect to.
     *  @param          :   amountvalid (Integer) - The valid amount for the transaction.
     *  @param          :   validAccountnumber (String) - The valid account number for which the transaction is to be undone.
     *  @throws         :   Exception - If any general error occurs during execution.
     *  @throws         :   CustomException - If the account number is invalid or if the transaction cannot be undone.
     *********************************************************
    */
    public static void undo(String databaseName, Integer amountvalid, String validAccountnumber)
            throws Exception, CustomException {
        try {
            Connection connection = ConnectionDB.con(databaseName);
            String fetchLastTransactionQuery = Constant.FETCHACCOUNTDETAIL;
            PreparedStatement fetchTransactionPs = connection.prepareStatement(fetchLastTransactionQuery);
            fetchTransactionPs.setString(1, validAccountnumber);
            ResultSet transactionResultSet = fetchTransactionPs.executeQuery();
            if (transactionResultSet.next()) {
                // Retrieve the timestamp of the last transaction
                LocalDateTime transactionTime = transactionResultSet.getTimestamp("transaction_time").toLocalDateTime();
                LocalDateTime currentTime = LocalDateTime.now();

                // Calculate the time difference between the transaction and the current time
                Duration timeDifference = Duration.between(transactionTime, currentTime);
                long minutesPassed = timeDifference.toMinutes();

                // Check if the transaction was made within the last 10 minutes
                if (minutesPassed <= 10) {
                    // Retrieve the transaction amount and type (Withdraw/Deposit)
                    int transactionAmount = transactionResultSet.getInt("amount");
                    String transactionType = transactionResultSet.getString("type");
                    int updateResult = 0;

                    // Reverse the transaction based on its type
                    if (transactionType.equals("Withdraw")) {
                        // Reverse the transaction by adding the withdrawn amount back to the account
                        String updateBalanceQuery = Constant.FETCHWITHDRAW;
                        PreparedStatement updateBalancePs = connection.prepareStatement(updateBalanceQuery);
                        updateBalancePs.setInt(1, transactionAmount);
                        updateBalancePs.setString(2, validAccountnumber);
                        updateResult = updateBalancePs.executeUpdate();
                    } else {
                        // Reverse the transaction by deducting the deposited amount from the account
                        String updateBalanceQuery = Constant.FETCHDEPOSITE;
                        PreparedStatement updateBalancePs = connection.prepareStatement(updateBalanceQuery);
                        updateBalancePs.setInt(1, transactionAmount);
                        updateBalancePs.setString(2, validAccountnumber);
                        updateResult = updateBalancePs.executeUpdate();
                    }

                    // If the account balance was successfully updated
                    if (updateResult > 0) {
                        // Optionally, delete the last transaction record
                        String deleteTransactionQuery = Constant.DEELETETRANSACTION;
                        PreparedStatement deleteTransactionPs = connection.prepareStatement(deleteTransactionQuery);
                        deleteTransactionPs.setString(1, validAccountnumber);
                        deleteTransactionPs.setTimestamp(2, transactionResultSet.getTimestamp("transaction_time"));
                        int deleteResult = deleteTransactionPs.executeUpdate();

                        if (deleteResult > 0) {
                            Sout.print(Constant.SUCCESSFULLYCREATED);
                            ManagerView.managerfunction(databaseName, amountvalid);
                        } else {
                            throw new CustomException(Constant.UNSUCCESSFULLYCREATED);
                        }
                        deleteTransactionPs.close();
                    } else {
                        throw new CustomException(Constant.UNSUCCESSFULLYCREATED);
                    }

                } else {
                    throw new CustomException(Constant.UNSUCCESSFULTRANSACTION);
                }
            } else {
                throw new CustomException(Constant.INVALIDACCOUNTNUMBER);
            }

        } catch (Exception e) {
            throw e;
        }
    }
}
