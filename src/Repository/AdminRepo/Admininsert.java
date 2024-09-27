/*
*********************************************************************************************************
 *  @Java Class Name :   Admininsert
 *  @Author          :   Manish Kripalani (Manish.kripalani@antrazal.com)
 *  @Company         :   Antrazal
 *  @Date            :   17-09-2024
 *  @Description     :   This class handles the insertion of new admin records into the database, 
 *                       including their credentials and personal information.
 *******************************************************************************************************
 *  AWC ID     Developer                                             	  	TITLE  
 *  1633      <Manish Kripalani>(manish.kripalani@antrazal.com)      JAVA ASSIGNMENT
********************************************************************************************************
*/

package Repository.AdminRepo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Pojo.Employee;
import Repository.DatabaseRepo.ConnectionDB;
import Utils.Constant;
import Utils.CustomException;


public class Admininsert {

    /*
     *********************************************************
     * @Method Name : adminCreation
     * @Author : Manish Kripalani (Manish.kripalani@antrazal.com)
     * @Company : Antrazal
     * @Description : Inserts a new admin's credentials and personal information
     * into the database.
     * @param : dbname (String) - The name of the database.
     *          emp (Employee) - The employee object containing admin details.
     * @return : void
     * @throws : CustomException - If the insertion fails.
     * SQLException - If a SQL error occurs during the operation.
     *********************************************************
     */
    public static void adminCreation(String dbname, Employee emp) throws CustomException, SQLException {
        PreparedStatement insertPasswordStatement = null;
        PreparedStatement insertEmployeeStatement = null;
        ConnectionDB connectionDB = new ConnectionDB();
        Connection connection = null;

        try {
            connection = connectionDB.con(dbname);
            String insertPasswordQuery = Constant.insertPasswordQuery;
            String insertEmployeeQuery = Constant.insertEmployeeQuery;

            // Prepare statements for inserting password and employee data
            insertPasswordStatement = connection.prepareStatement(insertPasswordQuery);
            insertPasswordStatement.setString(1, emp.getEmail());
            insertPasswordStatement.setString(2, emp.getUsername());
            insertPasswordStatement.setString(3, emp.getPassword());

            insertEmployeeStatement = connection.prepareStatement(insertEmployeeQuery);
            insertEmployeeStatement.setString(1, emp.getEmail());
            insertEmployeeStatement.setString(2, emp.getName());
            insertEmployeeStatement.setString(3, emp.getDesignation());

            // Execute the insert operations
            int passwordUpdateCount = insertPasswordStatement.executeUpdate();
            int employeeUpdateCount = insertEmployeeStatement.executeUpdate();

            // Check if both operations were successful
            if (passwordUpdateCount < 0 && employeeUpdateCount < 0) {
                throw new CustomException(Constant.UNSUCCESSFULLYCREATED);
                // Sout.print(Constant.SUCCESSFULLYCREATED);
            }

        } catch (SQLException e) {
            throw e; // Rethrow SQL exceptions for handling elsewhere
        } catch (Exception e) {
            throw new CustomException(Constant.UNSUCCESSFULLYCREATED); // Wrap other exceptions
        } finally {
            // Ensure resources are closed to prevent memory leaks
            if (insertPasswordStatement != null) {
                insertPasswordStatement.close();
            }
            if (insertEmployeeStatement != null) {
                insertEmployeeStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
}
