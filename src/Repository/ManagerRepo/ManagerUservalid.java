/*
*********************************************************************************************************
 *  @Java Class Name :   ManagerUservalid
 *  @Author          :   Manish Kripalani (manish.kripalani@antrazal.com)
 *  @Company         :   Antrazal
 *  @Date            :   17-09-2024
 *  @Description     :   This class handles the validation of a manager's user credentials. It checks if the 
 *                       provided email and designation are valid and then verifies the login process. If 
 *                       the login is successful, it forwards to the manager functionality.
 *******************************************************************************************************
 *  AWC ID     Developer                                             	  	TITLE  
 *  1633      <Manish Kripalani>(manish.kripalani@antrazal.com)      JAVA ASSIGNMENT
********************************************************************************************************
*/

package Repository.ManagerRepo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Repository.DatabaseRepo.ConnectionDB;
import Repository.DatabaseRepo.loginProcess;
import Pojo.Employee;
import Utils.Constant;
import Utils.CustomException;

public class ManagerUservalid {

    /*
     *********************************************************
     * @Method Name : uservalid
     * @Author : Manish Kripalani (manish.kripalani@antrazal.com)
     * @Company : Antrazal
     * @Description : This method validates the user's email and designation. If valid, it proceeds to verify the login process. If login is successful, it forwards to the manager functionality; otherwise, it throws an exception.
     * @param : emp (Employee) - The employee object containing the email and designation.
     *          databaseName (String) - The name of the database to connect to.
     *          amountvalid (Integer) - A parameter indicating a certain amount, potentially for validation.
     * @throws : Exception - If any error occurs during database operations.
     * @throws : CustomException - For specific error conditions like invalid email or unsuccessful login.
     *********************************************************
     */
    public static void uservalid(Employee emp, String databaseName, Integer amountvalid)
            throws Exception, CustomException {
        PreparedStatement preparedStatement = null;
        ConnectionDB connectionDB = new ConnectionDB();
        Connection connection = connectionDB.con(databaseName);
        try {
            String query = Constant.VALIDATEEMAIL;
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, emp.getEmail());
            preparedStatement.setString(2, emp.getDesignation());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                // If the manager email exists, proceed with password verification
                boolean loginSuccessful = loginProcess.login(emp, databaseName);

                if (loginSuccessful) {
                    throw new CustomException(Constant.MANAGERLOGIN);
                } else {
                    throw new CustomException(Constant.UNSUCCESSFULLYCREATED);
                }
            } else {
                throw new CustomException(Constant.VALIDEMAIL);
            }

        } catch (Exception e) {
            throw e;
        }
    }

}
