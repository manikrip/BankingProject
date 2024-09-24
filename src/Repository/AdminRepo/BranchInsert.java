/*
*********************************************************************************************************
 *  @Java Class Name :   BranchInsert
 *  @Author          :   Manish Kripalani (Manish.kripalani@antrazal.com)
 *  @Company         :   Antrazal
 *  @Date            :   17-09-2024
 *  @Description     :   This class handles the insertion of branch records into the database. 
 *                       It checks for duplicate branch names and executes the insertion if the branch 
 *                       does not already exist.
 *********************************************************************************************************
 */

 package Repository.AdminRepo;

 import java.sql.Connection;
 import java.sql.PreparedStatement;
 import java.sql.ResultSet;
 import Pojo.Branch;
 import Repository.DatabaseRepo.ConnectionDB;
import Utils.Constant;
 import Utils.CustomException;
 import Utils.Sout;
 import view.Adminview;
 
 public class BranchInsert {
 
     /*
     *********************************************************
      *  @Method Name    :   insert
      *  @Author         :   Manish Kripalani (Manish.kripalani@antrazal.com)
      *  @Company        :   Antrazal
      *  @Description    :   Inserts a new branch into the database after checking for duplicates.
      *  @param          :   br (Branch) - The branch object containing details to be inserted.
      *  @param          :   dbname (String) - The name of the database.
      *  @param          :   amount (Integer) - An amount for admin operations.
      *  @return         :   void
      *  @throws         :   CustomException - If the branch already exists or the insertion fails.
      *                     Exception - For general SQL exceptions.
      *********************************************************
      */
     public static void insert(Branch br, String dbname, Integer amount) throws Exception, CustomException {
         PreparedStatement selectBranchStatement = null;
         PreparedStatement insertBranchStatement = null;
         ResultSet branchResultSet = null;
         ConnectionDB connectionDB = new ConnectionDB();
         Connection connection = null;
 
         try {
             // Establish connection to the database
             connection = connectionDB.con(dbname);
             String selectBranchQuery = Constant.BRANCHQUERY;
             selectBranchStatement = connection.prepareStatement(selectBranchQuery);
             selectBranchStatement.setString(1, br.getName());
             branchResultSet = selectBranchStatement.executeQuery();
 
             // Check if the branch name already exists
             if (branchResultSet.next()) {
                 throw new CustomException(Constant.BRANCHEXIT); // Branch name exists
             } else {
                 String insertBranchQuery = Constant.BRANCHINSERT;
                 insertBranchStatement = connection.prepareStatement(insertBranchQuery);
                 insertBranchStatement.setString(1, br.getName());
                 insertBranchStatement.setString(2, br.getCity());
                 insertBranchStatement.setString(3, br.getAddress());
 
                 // Execute the insert query and check if rows were affected
                 int rowsAffected = insertBranchStatement.executeUpdate();
 
                 if (rowsAffected > 0) {
                     Sout.print(Constant.SUCCESSFULLYCREATED); // Notify success
                     Adminview.adminFunction(dbname, amount); // Redirect to admin functions
                 } else {
                     throw new CustomException(Constant.UNSUCCESSFULLYCREATED); // Notify failure
                 }
             }
         } catch (Exception e) {
             throw e; // Rethrow the exception for handling elsewhere
         } finally {
             // Ensure all resources are closed to prevent memory leaks
             if (branchResultSet != null) {
                 branchResultSet.close();
             }
             if (selectBranchStatement != null) {
                 selectBranchStatement.close();
             }
             if (insertBranchStatement != null) {
                 insertBranchStatement.close();
             }
             if (connection != null) {
                 connection.close();
             }
         }
     }
 }
 