/*
*********************************************************************************************************
 *  @Java Class Name :   CustomerUservalid
 *  @Author          :   Manish Kripalani (manish.kripalani@antrazal.com)
 *  @Company         :   Antrazal
 *  @Date            :   17-09-2024
 *  @Description     :   This class handles the validation of a customer's login credentials.
 *                       It checks if the provided email exists and verifies the password.
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
import Repository.DatabaseRepo.loginProcess;
import Utils.Constant;
import Utils.CustomException;


public class CustomerUservalid {

    /*
    *********************************************************
     *  @Method Name    :   uservalid
     *  @Author         :   Manish Kripalani (manish.kripalani@antrazal.com)
     *  @Company        :   Antrazal
     *  @Description    :   Validates the customer's email and password.
     *                      If the email is valid, it proceeds to verify the password.
     *                      On successful login, it redirects to customer functionality.
     *  @param          :   log (Login) - The Login object containing user credentials.
     *  @param          :   dbname (String) - The name of the database to connect to.
     *  @param          :   amount (Integer) - The amount associated with the user's account.
     *  @throws         :   Exception - If any general error occurs during execution.
     *  @throws         :   CustomException - If the provided email is invalid or login fails.
     *********************************************************
    */
    public static void uservalid(Login log, String dbname, Integer amount) throws Exception {
        PreparedStatement preparedStatement = null;
        ConnectionDB connectionDB = new ConnectionDB();
        Connection connection = connectionDB.con(dbname);
        try {
            String query = Constant.VALIDATECUSTOMEREMAIL;
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, log.getEmail());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                // If the customer email exists, proceed with password verification
                boolean loginSuccessful = loginProcess.login(log, dbname);

                if (loginSuccessful) {
                    throw new CustomException(Constant.CUSTOMERLOGIN);
                } else {
                    // Throw an exception if the password verification fails
                    throw new CustomException(Constant.UNSUCCESSFULLYCREATED);
                }
            } else {
                // Throw an exception if the email is not valid
                throw new CustomException(Constant.VALIDEMAIL);
            }

        } catch (Exception e) {
            throw e; // Rethrow the exception for handling at a higher level
        }
    }
}
