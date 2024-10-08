/*
*********************************************************************************************************
 *  @Java Class Name :   ManagerSingleAccount
 *  @Author          :   Manish Kripalani (manish.kripalani@antrazal.com)
 *  @Company         :   Antrazal
 *  @Date            :   17-09-2024
 *  @Description     :   This class handles the insertion of single account details into the database. It first 
 *                       checks whether the specified branch exists and then performs the insertion of the 
 *                       customer's details. It also manages the insertion of the customer's email into the 
 *                       password store.
 *******************************************************************************************************
 *  AWC ID     Developer                                             	  	TITLE  
 *  1633      <Manish Kripalani>(manish.kripalani@antrazal.com)      JAVA ASSIGNMENT
********************************************************************************************************
*/


package Repository.ManagerRepo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Pojo.Customer;
import Repository.DatabaseRepo.ConnectionDB;
import Utils.Constant;
import Utils.CustomException;

public class ManagerSingleAccount {

    /*
     *********************************************************
     * @Method Name : insert
     * @Author : Manish Kripalani (manish.kripalani@antrazal.com)
     * @Company : Antrazal
     * @Description : This method inserts a single account into the database. It checks if the specified branch exists before inserting the customer's details and their email into the password store. If the branch does not exist, it throws a custom exception.
     * @param : databaseName (String) - The name of the database to connect to.
     *          amountvalid (Integer) - A parameter indicating a certain amount, potentially for validation.
     *          customer (Customer) - The customer object containing details for insertion.
     * @throws : Exception - If any error occurs during database operations.
     * @throws : CustomException - For specific error conditions like non-existent branches or unsuccessful insertions.
     *********************************************************
     */
    public static void insert(String databaseName, Integer amountvalid, Customer customer)
            throws Exception, CustomException {
        try {
            ConnectionDB connectionDB = new ConnectionDB();
            Connection connection = connectionDB.con(databaseName);
            String branchCheckQuery = Constant.BRANCHQUERY;
            PreparedStatement branchCheckStatement = connection.prepareStatement(branchCheckQuery);
            branchCheckStatement.setString(1, customer.getBranchName());
            ResultSet branchResultSet = branchCheckStatement.executeQuery();
            if (branchResultSet.next()) {
                // Branch exists, proceed to insert account details
                String accountInsertQuery = Constant.ACCOUNTINSERTQUERY;
                // SQL query to insert the email into the password store
                String passwordInsertQuery = Constant.USERPASSWORD;
                PreparedStatement passwordInsertStatement = connection.prepareStatement(passwordInsertQuery);
                passwordInsertStatement.setString(1, customer.getEmail());
                PreparedStatement accountInsertStatement = connection.prepareStatement(accountInsertQuery);
                accountInsertStatement.setString(1, customer.getBranchName());
                accountInsertStatement.setString(2, customer.getName());
                accountInsertStatement.setString(3, customer.getPancard());
                accountInsertStatement.setDouble(4, customer.getAmount());
                accountInsertStatement.setString(5, customer.getEmail());
                accountInsertStatement.setString(6, customer.getAccountNumber());

                // Execute the insert operations
                int passwordRowsAffected = passwordInsertStatement.executeUpdate();
                int accountRowsAffected = accountInsertStatement.executeUpdate();

                // Check if both insertions were successful
                if (passwordRowsAffected > 0) {

                    if (accountRowsAffected > 0) {
                        throw new CustomException(Constant.SUCCESSFULLYCREATED);
                    } else {
                        throw new CustomException(Constant.UNSUCCESSFULLYCREATED);
                    }

                } else {
                    throw new CustomException(Constant.UNSUCCESSFULLYCREATED);
                }
            } else {
                throw new CustomException(Constant.BRANCHDOESNOTEXIT);
            }

        } catch (Exception e) {
            throw e;
        }
    }
}
