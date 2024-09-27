/*
*********************************************************************************************************
 *  @Java Class Name :   TransactionHistory
 *  @Author          :   Manish Kripalani (manish.kripalani@antrazal.com)
 *  @Company         :   Antrazal
 *  @Date            :   17-09-2024
 *  @Description     :   This class contains a method to retrieve the transaction history for a given 
 *                       PAN card number. It checks if the PAN card exists, fetches the associated 
 *                       account number, and retrieves the transaction details associated with that account.
 *******************************************************************************************************
 *  AWC ID     Developer                                             	  	TITLE  
 *  1633      <Manish Kripalani>(manish.kripalani@antrazal.com)      JAVA ASSIGNMENT
********************************************************************************************************
*/

package Repository.DatabaseRepo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Utils.Constant;

public class TransactionHistory {

    /*
     *********************************************************
     * @Method Name : getTransactionHistory
     * @Author : Manish Kripalani (manish.kripalani@antrazal.com)
     * @Company : Antrazal
     * @Description : This method retrieves the transaction history for the specified PAN card number.
     *                It first checks if the PAN card exists, then fetches the corresponding account number, and finally retrieves the transaction history associated with that account.
     * @param : dbname (String) - The name of the database to connect to.
     *          amount (Integer) - The amount to filter the transactions (if applicable).
     * @param : pancard (String) - The PAN card number for which the transaction history is being requested.
     * @return : String - A formatted string containing the transaction history or error messages.
     *********************************************************
     */
    public static String getTransactionHistory(String dbname, Integer amount, String pancard) {

        StringBuilder result = new StringBuilder();

        try {
            ConnectionDB connectionDB = new ConnectionDB();
            Connection connection = connectionDB.con(dbname);

            // Query to check if pancard exists and get email
            String sql = Constant.PANCARDCHECK;
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, pancard);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    String accountNumber = rs.getString("AccountNumber");

                    // Query to fetch transaction history using account number
                    String sql2 = Constant.TRANSACTIONHISTORY;
                    PreparedStatement ps1 = connection.prepareStatement(sql2);
                    ps1.setString(1, accountNumber);

                    try (ResultSet rs1 = ps1.executeQuery()) {
                        // Loop through the ResultSet to process all rows
                        boolean hasTransaction = false;
                        while (rs1.next()) {
                            hasTransaction = true;
                            result.append("AccountNumber: ").append(rs1.getString("accountNumber"))
                                    .append(" | Type: ").append(rs1.getString("type"))
                                    .append(" | Amount: ").append(rs1.getInt("amount")).append("\n");
                        }
                        if (!hasTransaction) {
                            result.append(Constant.NOTRANSACTION);
                        }
                    }
                    ps1.close();
                } else {
                    result.append(Constant.INVALIDPANCARD);
                }
            }
            ps.close();
            connection.close();

        } catch (Exception e) {
            result.append(e.getMessage()).append("\n");
        }

        return result.toString();
    }
}
