/*
*********************************************************************************************************
 *  @Java Class Name :   CustomerUserCreated
 *  @Author          :   Manish Kripalani (manish.kripalani@antrazal.com)
 *  @Company         :   Antrazal
 *  @Date            :   17-09-2024
 *  @Description     :   This class handles the creation of a username for a customer. 
 *                       It validates the customer's email before allowing the username and password update.
 *******************************************************************************************************
 *  AWC ID     Developer                                             	  	TITLE  
 *  1633      <Manish Kripalani>(manish.kripalani@antrazal.com)      JAVA ASSIGNMENT
********************************************************************************************************
*/
package Repository.CustomerRepo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Pojo.Login;
import Repository.DatabaseRepo.ConnectionDB;
import Utils.Constant;
import Utils.CustomException;

public class CustomerUserCreated {

    /*
     *********************************************************
     * @Method Name : usernamecreated
     * @Author : Manish Kripalani (manish.kripalani@antrazal.com)
     * @Company : Antrazal
     * @Description : Validates the customer's email and updates their username and password if the email exists in the database.
     * @param : log (Login) - The Login object containing user credentials.
     *          dbname (String) - The name of the database to connect to.
     *          amount (Integer) - The amount associated with the user's account.
     * @throws : Exception - If any general error occurs during execution.
     * @throws : CustomException - If the provided email is invalid or not found in the database.
     *********************************************************
     */
    public static void usernamecreated(Login log, String dbname, Integer amount) throws Exception {
        PreparedStatement preparedStatement = null;
        ConnectionDB connectionDB = new ConnectionDB();
        Connection connection = connectionDB.con(dbname);
        try {
            String query = Constant.VALIDATECUSTOMEREMAIL;
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, log.getEmail());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                // If the email is valid, update the username and password
                UpdateUsernamePassword.updateUserPass(log, dbname, amount);
            } else {
                // Throw an exception if the email is not valid
                throw new CustomException(Constant.VALIDEMAIL);
            }
        } catch (Exception e) {
            throw e; // Rethrow the exception for handling at a higher level
        }
    }
}
