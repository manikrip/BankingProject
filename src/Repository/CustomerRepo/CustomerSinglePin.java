/*
*********************************************************************************************************
 *  @Java Class Name :   CustomerSinglePin
 *  @Author          :   Manish Kripalani (manish.kripalani@antrazal.com)
 *  @Company         :   Antrazal
 *  @Date            :   17-09-2024
 *  @Description     :   This class handles the process of updating the PIN for a single customer account.
 *                       It verifies the account number and updates the PIN in the database if the account is valid.
 *******************************************************************************************************
*/
package Repository.CustomerRepo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Repository.DatabaseRepo.ConnectionDB;
import Utils.Constant;
import Utils.CustomException;
import Utils.Sout;
import view.CustomerView;

public class CustomerSinglePin {

    /*
    *********************************************************
     *  @Method Name    :   insert
     *  @Author         :   Manish Kripalani (manish.kripalani@antrazal.com)
     *  @Company        :   Antrazal
     *  @Description    :   Inserts a new PIN for the specified account number if the account exists in the database.
     *                      If the account is found, it updates the PIN and confirms the success of the operation.
     *  @param          :   validAccountnumber (String) - The valid account number to be updated.
     *  @param          :   validpin (Integer) - The new PIN to be set for the account.
     *  @param          :   databasename (String) - The name of the database to connect to.
     *  @param          :   amountvalid (Integer) - The valid amount for the transaction.
     *  @throws         :   Exception - If any general error occurs during execution.
     *  @throws         :   CustomException - If the account number is invalid or if any database error occurs.
     *********************************************************
    */
    public static void insert(String validAccountnumber, Integer validpin, String databasename, Integer amountvalid)
            throws Exception, CustomException {
        try {
            ConnectionDB connectionDB = new ConnectionDB();
            Connection connection = connectionDB.con(databasename);
            String sql = Constant.ACCOUNTCHECK;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, validAccountnumber); // Set the account number parameter in the query
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                // SQL query to update the PIN for the account
                String updateSql = Constant.SETPIN;
                PreparedStatement updatePreparedStatement = connection.prepareStatement(updateSql);
                updatePreparedStatement.setInt(1, validpin); // Set the new PIN
                updatePreparedStatement.setString(2, validAccountnumber); // Set the account number

                // Execute the update query and check if rows were updated
                int rowsUpdated = updatePreparedStatement.executeUpdate();
                if (rowsUpdated > 0) {
                    Sout.print(Constant.SUCCESSFULLYCREATED);
                    CustomerView.customerFunction(databasename, amountvalid);
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
