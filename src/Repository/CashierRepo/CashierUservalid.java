/*
*********************************************************************************************************
 *  @Java Class Name :   CashierUservalid
 *  @Author          :   Manish Kripalani (manish.kripalani@antrazal.com)
 *  @Company         :   Antrazal
 *  @Date            :   17-09-2024
 *  @Description     :   This class validates a cashier user by checking if the provided email is associated
 *                       with the correct designation. It also verifies the password and redirects to 
 *                       the cashier functionality upon successful login.
 *******************************************************************************************************
 *  AWC ID     Developer                                             	  	TITLE  
 *  1633      <Manish Kripalani>(manish.kripalani@antrazal.com)      JAVA ASSIGNMENT
********************************************************************************************************
*/

package Repository.CashierRepo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Pojo.Employee;
import Utils.Constant;
import Utils.CustomException;
import Repository.DatabaseRepo.ConnectionDB;
import Repository.DatabaseRepo.loginProcess;

public class CashierUservalid {

    /*
     *********************************************************
     * @Method Name : uservalid
     * @Author : Manish Kripalani (manish.kripalani@antrazal.com)
     * @Company : Antrazal
     * @Description : Validates the cashier user by checking if the provided email exists for the specified designation. If valid, it verifies the password and proceeds to the cashier's functionality.
     * @param : emp (Employee) - The employee object containing cashier details.
     *          databaseName (String) - The name of the database.
     *          amountvalid (Integer) - An amount for further processing.
     * @return : void
     * @throws : Exception - For general exceptions.
     * CustomException - If the email is not valid or login fails.
     *********************************************************
     */
    public static void uservalid(Employee emp, String databaseName, Integer amountvalid)
            throws Exception, CustomException {
        PreparedStatement preparedStatement = null;
        Connection connection = ConnectionDB.con(databaseName);
        try {
            String query = Constant.VALIDATEEMAIL;
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, emp.getEmail());
            preparedStatement.setString(2, emp.getDesignation());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                // If the cashier email exists, proceed with password verification
                boolean loginSuccessful = loginProcess.login(emp, databaseName);

                if (loginSuccessful) {
                    throw new CustomException(Constant.CASHIERLOGIN);
                    // If login is successful, forward to cashier functionality

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
