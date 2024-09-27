/*
*********************************************************************************************************
 *  @Java Class Name :   ManagerJointAccount
 *  @Author          :   Manish Kripalani (manish.kripalani@antrazal.com)
 *  @Company         :   Antrazal
 *  @Date            :   17-09-2024
 *  @Description     :   This class handles the insertion of joint account details into the database. It checks 
 *                       whether the specified branch and PAN card details are valid before performing the 
 *                       insertion. It also manages the creation of unique email addresses for joint account holders.
 *******************************************************************************************************
 *  AWC ID     Developer                                             	  	TITLE  
 *  1633      <Manish Kripalani>(manish.kripalani@antrazal.com)      JAVA ASSIGNMENT
********************************************************************************************************
*/

package Repository.ManagerRepo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Pojo.JointAccount;
import Repository.DatabaseRepo.ConnectionDB;
import Utils.Constant;
import Utils.CustomException;

public class ManagerJointAccount {

    /*
     *********************************************************
     * @Method Name : insert
     * @Author : Manish Kripalani (manish.kripalani@antrazal.com)
     * @Company : Antrazal
     * @Description : This method inserts a joint account into the database. It first checks if the branch exists and validates the provided PAN card numbers. It then generates a unique email for the joint account and inserts the data into the respective tables.
     * @param : databaseName (String) - The name of the database to connect to.
     *          amountvalid (Integer) - A parameter indicating a certain amount, potentially for validation.
     *          jointAccount (JointAccount) - The joint account object containing details for insertion.
     *          validpancard1 (String) - The second PAN card number to be validated.
     *          name (String) - The first name for creating an email address.
     *          name1 (String) - The second part of the name for creating an email address.
     * @throws : Exception - If any error occurs during database operations.
     * @throws : CustomException - For specific error conditions like existing accounts or branches.
     *********************************************************
     */
    public static void insert(String databaseName, Integer amountvalid, JointAccount jointAccount, String validpancard1,
            String name, String name1) throws Exception, CustomException {
        try {
            ConnectionDB connectionDB = new ConnectionDB();
            Connection connection = connectionDB.con(databaseName);
            String branchCheckQuery = Constant.BRANCHQUERY;
            PreparedStatement branchCheckStatement = connection.prepareStatement(branchCheckQuery);
            branchCheckStatement.setString(1, jointAccount.getBranchName());
            ResultSet branchResultSet = branchCheckStatement.executeQuery();
            if (branchResultSet.next()) {
                // Branch exists, now check PAN card validity
                String checkpancard = Constant.PANCARDCHECK;
                PreparedStatement checkAccount1 = connection.prepareStatement(checkpancard);
                PreparedStatement checkAccount2 = connection.prepareStatement(checkpancard);

                checkAccount1.setString(1, jointAccount.getPancard());
                checkAccount2.setString(1, validpancard1);
                ResultSet resultSet1 = checkAccount1.executeQuery();
                ResultSet resultSet2 = checkAccount2.executeQuery();
                if (resultSet1.next() && resultSet2.next()) {
                    // Create email variations
                    String emailForward = name + name1 + "@gmail.com";

                    // Check if email already exists
                    String emailCheckQuery = Constant.EMAILJOINT;
                    PreparedStatement checkEmail = connection.prepareStatement(emailCheckQuery);
                    checkEmail.setString(1, emailForward);
                    ResultSet emailResultSet = checkEmail.executeQuery();
                    if (emailResultSet.next()) {
                        emailForward = name + name1 + Constant.EMAILMODIFY; // Update email if already exists
                    }

                    // Check if a joint account with either email variation already exists
                    String jointAccountCheckQuery = Constant.JOINTEMAILQUERY;
                    PreparedStatement checkJointAccount1 = connection.prepareStatement(jointAccountCheckQuery);
                    PreparedStatement checkJointAccount2 = connection.prepareStatement(jointAccountCheckQuery);

                    checkJointAccount1.setString(1, jointAccount.getPancard() + validpancard1);
                    checkJointAccount2.setString(1, validpancard1 + jointAccount.getPancard());

                    ResultSet jointAccountResultSet1 = checkJointAccount1.executeQuery();
                    ResultSet jointAccountResultSet2 = checkJointAccount2.executeQuery();

                    if (jointAccountResultSet1.next() || jointAccountResultSet2.next()) {
                        throw new CustomException(Constant.ACCOUNTEXIT);
                    } else {
                        // Insert the joint account details into the database
                        String insertJointAccountQuery = Constant.INSERTJOINTACCOUNTQUERY;
                        PreparedStatement insertJointAccount = connection.prepareStatement(insertJointAccountQuery);
                        insertJointAccount.setString(1, jointAccount.getPancard() + validpancard1);
                        insertJointAccount.setDouble(2, jointAccount.getAmount());
                        insertJointAccount.setString(3, jointAccount.getBranchName());
                        insertJointAccount.setString(4, emailForward);
                        insertJointAccount.setString(5, jointAccount.getAccountNumber());

                        int jointAccountInsertResult = insertJointAccount.executeUpdate();

                        // Insert email into password store
                        String insertEmailQuery = Constant.USERPASSWORD;
                        PreparedStatement insertEmail = connection.prepareStatement(insertEmailQuery);
                        insertEmail.setString(1, emailForward);
                        int emailInsertResult = insertEmail.executeUpdate();

                        if (jointAccountInsertResult > 0 && emailInsertResult > 0) {
                            throw new CustomException(Constant.SUCCESSFULLYCREATED);
                        } else {
                            throw new CustomException(Constant.UNSUCCESSFULLYCREATED);
                        }
                    }
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
