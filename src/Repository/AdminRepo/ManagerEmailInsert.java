/*
*********************************************************************************************************
 *  @Java Class Name :   ManagerEmailInsert
 *  @Author          :   Manish Kripalani (manish.kripalani@antrazal.com)
 *  @Company         :   Antrazal
 *  @Date            :   17-09-2024
 *  @Description     :   This class handles the insertion of a manager's email into the database. It checks 
 *                       whether the specified branch exists and if a manager is already assigned to that branch 
 *                       before performing the insertion.
 *******************************************************************************************************
 *  AWC ID     Developer                                             	  	TITLE  
 *  1633      <Manish Kripalani>(manish.kripalani@antrazal.com)      JAVA ASSIGNMENT
********************************************************************************************************
*/

package Repository.AdminRepo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Pojo.Employee;
import Utils.Constant;
import Utils.CustomException;
import Repository.DatabaseRepo.ConnectionDB;

public class ManagerEmailInsert {

    /*
     *********************************************************
     * @Method Name : emailCreated
     * @Author : Manish Kripalani (manish.kripalani@antrazal.com)
     * @Company : Antrazal
     * @Description : This method creates a new manager email entry in the database.It first checks if the branch exists and if a manager is already assigned. If all checks pass, it inserts
     *                the employee's details and the password into the respective tables.
     * @param : emp (Employee) - The employee object containing details of the manager to be inserted.
     *          dbname (String) - The name of the database where the entries will be made.
     *          amount (Integer) - A parameter indicating a certain amount, potentially for validation.
     * @throws : Exception - If any error occurs during database operations.
     * @throws : CustomException - For specific error conditions like existing manager or branch issues.
     *********************************************************
     */
    public static void emailCreated(Employee emp, String dbname, Integer amount) throws Exception, CustomException {
        PreparedStatement selectBranchStatement = null;
        PreparedStatement selectManagerStatement = null;
        PreparedStatement insertEmployeeStatement = null;
        PreparedStatement insertPasswordStatement = null;
        ResultSet branchResultSet = null;
        ResultSet managerResultSet = null;
        ConnectionDB connectionDB = new ConnectionDB();
        Connection connection = connectionDB.con(dbname);

        try {
            String selectBranchQuery = Constant.BRANCHQUERY;
            selectBranchStatement = connection.prepareStatement(selectBranchQuery);
            selectBranchStatement.setString(1, emp.getBranchName());
            branchResultSet = selectBranchStatement.executeQuery();

            if (branchResultSet.next()) {
                // Branch exists, now check if a manager is already assigned to this branch
                String selectManagerQuery = Constant.BRANCHNAMEDESIGNATION;
                selectManagerStatement = connection.prepareStatement(selectManagerQuery);
                selectManagerStatement.setString(1, emp.getBranchName());
                selectManagerStatement.setString(2, "Manager");
                managerResultSet = selectManagerStatement.executeQuery();

                if (managerResultSet.next()) {
                    // Manager already exists for this branch
                    throw new CustomException(Constant.MANAGERALREDYEXIT);
                }

                // Prepare to insert the employee data
                String insertEmployeeQuery = Constant.INSERTEMPLOYEE;
                insertEmployeeStatement = connection.prepareStatement(insertEmployeeQuery);
                insertEmployeeStatement.setString(1, emp.getBranchName());
                insertEmployeeStatement.setString(2, emp.getName());
                insertEmployeeStatement.setString(3, emp.getEmail());
                insertEmployeeStatement.setString(4, "Manager");

                // SQL query to insert manager email into the passwordStore table
                String insertPasswordQuery = Constant.USERPASSWORD;
                insertPasswordStatement = connection.prepareStatement(insertPasswordQuery);
                insertPasswordStatement.setString(1, emp.getEmail());

                // Execute both insert statements
                int rowsAffectedEmployee = insertEmployeeStatement.executeUpdate();
                int rowsAffectedPassword = insertPasswordStatement.executeUpdate();

                if (rowsAffectedEmployee > 0 && rowsAffectedPassword > 0) {

                    throw new CustomException(Constant.SUCCESSFULLYCREATED);
                } else {
                    // If any insert failed, notify the admin
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
