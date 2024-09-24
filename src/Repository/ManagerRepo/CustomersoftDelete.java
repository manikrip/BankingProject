/*
*********************************************************************************************************
 *  @Java Class Name :   CustomersoftDelete
 *  @Author          :   Manish Kripalani (manish.kripalani@antrazal.com)
 *  @Company         :   Antrazal
 *  @Date            :   17-09-2024
 *  @Description     :   This class handles the soft deletion of customer accounts 
 *                       by marking them as inactive based on their PAN card number.
 *******************************************************************************************************
*/
package Repository.ManagerRepo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Repository.DatabaseRepo.ConnectionDB;
import Utils.Constant;
import Utils.CustomException;
import Utils.Sout;
import view.ManagerView;

public class CustomersoftDelete {

    /*
    *********************************************************
     *  @Method Name    :   activate
     *  @Author         :   Manish Kripalani (manish.kripalani@antrazal.com)
     *  @Company        :   Antrazal
     *  @Description    :   Activates (soft deletes) a customer account by setting the 'isActive' flag to FALSE.
     *                      It checks if the provided PAN card number exists in the database.
     *  @param          :   databaseName (String) - The name of the database to connect to.
     *  @param          :   amountvalid (Integer) - The amount associated with the customer's account.
     *  @param          :   pancard (String) - The PAN card number of the customer.
     *  @throws         :   Exception - If any general error occurs during execution.
     *  @throws         :   CustomException - If the PAN card is invalid or if the update fails.
     *********************************************************
    */
    public static void activate(String databaseName, Integer amountvalid, String pancard)
            throws Exception, CustomException {
        try {
            PreparedStatement selectPreparedStatement = null;
            PreparedStatement updatePreparedStatement = null;
            ResultSet resultSet = null;
            ConnectionDB connectionDB = new ConnectionDB();
            Connection connection = connectionDB.con(databaseName);

            // Prepare the query to check for the existence of the PAN card
            String selectQuery = Constant.PANCARDCHECK;
            selectPreparedStatement = connection.prepareStatement(selectQuery);
            selectPreparedStatement.setString(1, pancard);
            resultSet = selectPreparedStatement.executeQuery();
 
            // If the PAN card exists, perform a soft delete by setting 'isActive' to FALSE
            if (resultSet.next()) {
                // Prepare the update query to set 'isActive' to FALSE
                String updateQuery = Constant.ISACTIVE;
                updatePreparedStatement = connection.prepareStatement(updateQuery);
                updatePreparedStatement.setString(1, pancard); // Set the PAN card in the update statement
                int rowsAffected = updatePreparedStatement.executeUpdate();
 
                // Check if the update was successful
                if (rowsAffected > 0) {
                    Sout.print(Constant.SUCCESSFULLYCREATED);
                    ManagerView.managerfunction(databaseName, amountvalid); // Redirect to manager functionality
                } else {
                    throw new CustomException(Constant.UNSUCCESSFULLYCREATED);
                }

            } else {
                throw new CustomException(Constant.INVALIDPANCARD); // Handle case where PAN card is not found
            }

        } catch (Exception e) {
            throw e; // Rethrow the exception for handling at a higher level
        }
    }
}
