/*
*********************************************************************************************************
 *  @Java Class Name :   CustomerJointPin
 *  @Author          :   Manish Kripalani (manish.kripalani@antrazal.com)
 *  @Company         :   Antrazal
 *  @Date            :   17-09-2024
 *  @Description     :   This class is responsible for updating the joint account PIN for a customer.
 *                       It checks if the account number is valid and updates the PIN accordingly.
 *******************************************************************************************************
 *  AWC ID     Developer                                             	  	TITLE  
 *  1633      <Manish Kripalani>(manish.kripalani@antrazal.com)      JAVA ASSIGNMENT
********************************************************************************************************
*/
package Repository.CustomerRepo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Repository.DatabaseRepo.ConnectionDB;
import Utils.Constant;
import Utils.CustomException;

public class CustomerJointPin {

    /*
    *********************************************************
     *  @Method Name    :   insert
     *  @Author         :   Manish Kripalani (manish.kripalani@antrazal.com)
     *  @Company        :   Antrazal
     *  @Description    :   Inserts a new PIN for the given account number if the account is valid.
     *                      It checks if the account number exists in the database before updating the PIN.
     *  @param          :   validAccountnumber (String) - The account number for which the PIN is to be updated.
     *  @param          :   validpin (Integer) - The new PIN to set for the account.
     *  @param          :   databasename (String) - The name of the database to connect to.
     *  @param          :   amountvalid (Integer) - The valid amount for the transaction.
     *  @throws         :   Exception - If any general error occurs during execution.
     *  @throws         :   CustomException - If the account number is invalid or if any database error occurs.
     *********************************************************
    */
    public static void insert(String validAccountnumber, Integer validpin, String databasename, Integer amountvalid) throws Exception {
        String sql = Constant.JOINTACCOUNTCHECK;
        String updateSql = Constant.SETJOINTPIN;

        try 
        {
            ConnectionDB connectionDB = new ConnectionDB();
            Connection connection = ConnectionDB.con(databasename);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            System.out.println("I am here ");
            System.out.println(validAccountnumber);
            preparedStatement.setString(1, validAccountnumber); // Set the account number parameter in the query
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                try (PreparedStatement updatePreparedStatement = connection.prepareStatement(updateSql)) {
                    updatePreparedStatement.setInt(1, validpin); // Set the new PIN
                    updatePreparedStatement.setString(2, validAccountnumber); // Set the account number

                    int rowsUpdated = updatePreparedStatement.executeUpdate();
                    if (rowsUpdated > 0) {
                        throw new CustomException(Constant.SUCCESSFULLYCREATED);
                    } else {
                        throw new CustomException(Constant.UNSUCCESSFULLYCREATED);
                    }
                }
            } else {
                throw new CustomException(Constant.INVALIDACCOUNTNUMBER);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Log the SQLException for debugging
            throw new CustomException("Database error occurred: " + e.getMessage());
        } catch (Exception e) {
            throw e;
        }
    }
}
