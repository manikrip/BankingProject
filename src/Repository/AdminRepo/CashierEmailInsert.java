/*
*********************************************************************************************************
 *  @Java Class Name :   CashierEmailInsert
 *  @Author          :   Manish Kripalani (Manish.kripalani@antrazal.com)
 *  @Company         :   Antrazal
 *  @Date            :   17-09-2024
 *  @Description     :   This class handles the insertion of cashier details into the database.
 *                       It checks for the existence of the branch and ensures no other cashier
 *                       is assigned to the same branch before performing the insertion.
 *********************************************************************************************************
 */

 package Repository.AdminRepo;

 import java.sql.Connection;
 import java.sql.PreparedStatement;
 import java.sql.ResultSet;
 import Pojo.Employee;
import Repository.DatabaseRepo.ConnectionDB;
import Utils.Constant;
 import Utils.CustomException;
 import Utils.Sout;
 import view.Adminview;
 
 public class CashierEmailInsert {
 
     /*
     *********************************************************
      *  @Method Name    :   emailCreated
      *  @Author         :   Manish Kripalani (Manish.kripalani@antrazal.com)
      *  @Company        :   Antrazal
      *  @Description    :   Creates a new cashier by inserting their details into the database.
      *                      It checks for the existence of the branch and ensures that no other 
      *                      cashier is already assigned to that branch.
      *  @param          :   emp (Employee) - The employee object containing cashier details.
      *  @param          :   dbname (String) - The name of the database.
      *  @param          :   amount (Integer) - An amount for admin operations.
      *  @return         :   void
      *  @throws         :   CustomException - If the branch does not exist, a cashier is already assigned,
      *                     or if the insertion fails.
      *                     Exception - For general SQL exceptions.
      *********************************************************
      */
     public static void emailCreated(Employee emp, String dbname, Integer amount) throws Exception, CustomException {
         PreparedStatement selectBranchStatement = null;
         PreparedStatement selectCashierStatement = null;
         PreparedStatement insertEmployeeStatement = null;
         PreparedStatement insertPasswordStatement = null;
         ResultSet branchResultSet = null;
         ResultSet cashierResultSet = null;
         ConnectionDB connectionDB = new ConnectionDB();
         Connection connection = null;
 
         try {
             // Establish connection to the database
             connection = connectionDB.con(dbname);
             
             // Check if the branch exists
             String selectBranchQuery = Constant.BRANCHQUERY;
             selectBranchStatement = connection.prepareStatement(selectBranchQuery);
             selectBranchStatement.setString(1, emp.getBranchName());
             branchResultSet = selectBranchStatement.executeQuery();
 
             if (branchResultSet.next()) {
                 // Branch exists, now check if a cashier is already assigned to this branch
                 String selectCashierQuery = Constant.BRANCHNAMEDESIGNATION;
                 selectCashierStatement = connection.prepareStatement(selectCashierQuery);
                 selectCashierStatement.setString(1, emp.getBranchName());
                 selectCashierStatement.setString(2, "Cashier");
                 cashierResultSet = selectCashierStatement.executeQuery();
 
                 if (cashierResultSet.next()) {
                     // Cashier already exists for this branch
                     throw new CustomException(Constant.CASHIERALREDYEXIT);
                 }
 
                 // Prepare the SQL queries for insertion
                 String insertEmployeeQuery = Constant.INSERTEMPLOYEE;
                 insertEmployeeStatement = connection.prepareStatement(insertEmployeeQuery);
                 insertEmployeeStatement.setString(1, emp.getBranchName());
                 insertEmployeeStatement.setString(2, emp.getName());
                 insertEmployeeStatement.setString(3, emp.getEmail());
                 insertEmployeeStatement.setString(4, "Cashier");
 
                 String insertPasswordQuery = Constant.USERPASSWORD;
                 insertPasswordStatement = connection.prepareStatement(insertPasswordQuery);
                 insertPasswordStatement.setString(1, emp.getEmail());
 
                 // Execute both insert statements
                 int rowsAffectedEmployee = insertEmployeeStatement.executeUpdate();
                 int rowsAffectedPassword = insertPasswordStatement.executeUpdate();
 
                 if (rowsAffectedEmployee > 0 && rowsAffectedPassword > 0) {
                     // If both inserts were successful, notify the admin
                     Sout.print(Constant.SUCCESSFULLYCREATED);
                     Adminview.adminFunction(dbname, amount);
                 } else {
                     // If any insert failed, notify the admin
                     throw new CustomException(Constant.UNSUCCESSFULLYCREATED);
                 }
 
             } else {
                 // Branch does not exist
                 throw new CustomException(Constant.BRANCHDOESNOTEXIT);
             }
 
         } catch (Exception e) {
             throw e; // Rethrow the exception for handling elsewhere
         } finally {
             // Ensure all resources are closed to prevent memory leaks
             if (branchResultSet != null) {
                 branchResultSet.close();
             }
             if (cashierResultSet != null) {
                 cashierResultSet.close();
             }
             if (selectBranchStatement != null) {
                 selectBranchStatement.close();
             }
             if (selectCashierStatement != null) {
                 selectCashierStatement.close();
             }
             if (insertEmployeeStatement != null) {
                 insertEmployeeStatement.close();
             }
             if (insertPasswordStatement != null) {
                 insertPasswordStatement.close();
             }
             if (connection != null) {
                 connection.close();
             }
         }
     }
 }
 