/*
*********************************************************************************************************
 *  @Java Class Name :   CustomerapprovedLoan
 *  @Author          :   Manish Kripalani (manish.kripalani@antrazal.com)
 *  @Company         :   Antrazal
 *  @Date            :   17-09-2024
 *  @Description     :   This class handles the approval or rejection of customer loan requests.
 *                       It checks for pending loans and updates their status accordingly.
 *******************************************************************************************************
 *  AWC ID     Developer                                             	  	TITLE  
 *  1633      <Manish Kripalani>(manish.kripalani@antrazal.com)      JAVA ASSIGNMENT
********************************************************************************************************
*/
package Repository.ManagerRepo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Pojo.Loan;
import Repository.DatabaseRepo.ConnectionDB;
import Utils.Constant;
import Utils.CustomException;


public class CustomerapprovedLoan {

    /*
    *********************************************************
     *  @Method Name    :   decide
     *  @Author         :   Manish Kripalani (manish.kripalani@antrazal.com)
     *  @Company        :   Antrazal
     *  @Description    :   Decides on the approval or rejection of a loan.
     *                      It checks for pending loans and updates their status in the database.
     *  @param          :   databaseName (String) - The name of the database to connect to.
     *                      amountvalid (Integer) - The amount associated with the customer's account.
     *                      loan (Loan) - The Loan object containing loan details such as loan number and status.
     *  @throws         :   Exception - If any general error occurs during execution.
     *                      CustomException - If the loan status update fails or if no pending loan is found.
     *********************************************************
    */
    public static void decide(String databaseName, Integer amountvalid, Loan loan) throws Exception, CustomException {
        try {
            ConnectionDB connectionDB = new ConnectionDB();
            Connection connection = connectionDB.con(databaseName);
            PreparedStatement selectPreparedStatement = null;
            ResultSet resultSet = null;

            // SQL query to display all pending loans
            String selectPendingLoansQuery = Constant.LOANQUERY;
            selectPreparedStatement = connection.prepareStatement(selectPendingLoansQuery);
            selectPreparedStatement.setString(1, "Pending");
            selectPreparedStatement.setString(2, loan.getLoanNumber());
            resultSet = selectPreparedStatement.executeQuery();

            // Check if there is a pending loan
            if (resultSet.next()) {
                // Prepare to update the loan status
                String updateLoanStatusQuery = Constant.UPDATEDLOANQUERY;
                PreparedStatement updatePreparedStatement = connection.prepareStatement(updateLoanStatusQuery);
                updatePreparedStatement.setString(1, loan.getStatus()); // Set the new loan status
                updatePreparedStatement.setString(2, loan.getLoanNumber()); // Set the loan number for the update

                // Execute the update and check if successful
                int rowsAffected = updatePreparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    throw new CustomException(Constant.SUCCESSFULLYCREATED);
                } else {
                    throw new CustomException(Constant.UNSUCCESSFULLYCREATED);
                }

            } else {
                throw new CustomException(Constant.UNSUCCESSFULLYCREATED);
            }
        } catch (Exception e) {
            throw e; // Rethrow the exception for handling at a higher level
        }
    }
}
