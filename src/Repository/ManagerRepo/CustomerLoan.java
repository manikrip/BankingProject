/*
*********************************************************************************************************
 *  @Java Class Name :   CustomerLoan
 *  @Author          :   Manish Kripalani (manish.kripalani@antrazal.com)
 *  @Company         :   Antrazal
 *  @Date            :   17-09-2024
 *  @Description     :   This class handles the loan creation process for customers. 
 *                       It validates the customer's PAN card and inserts loan details into the database.
 *******************************************************************************************************
*/
package Repository.ManagerRepo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Pojo.Loan;
import Repository.DatabaseRepo.ConnectionDB;
import Utils.Constant;
import Utils.CustomException;
import Utils.Sout;
import view.CustomerView;

public class CustomerLoan {

    /*
    *********************************************************
     *  @Method Name    :   create
     *  @Author         :   Manish Kripalani (manish.kripalani@antrazal.com)
     *  @Company        :   Antrazal
     *  @Description    :   Creates a new loan for a customer if the provided PAN card is valid.
     *                      It checks the loan amount to determine the status of the loan.
     *                      If the loan amount is greater than 50,000, it sets the status to "Pending",
     *                      otherwise it sets the status to "Approved".
     *  @param          :   loan (Loan) - The loan object containing loan details.
     *  @param          :   databasename (String) - The name of the database to connect to.
     *  @param          :   amountvalid (Integer) - The valid amount for the transaction.
     *  @throws         :   Exception - If any general error occurs during execution.
     *  @throws         :   CustomException - If the PAN card is invalid or if any database error occurs.
     *********************************************************
    */
    public static void create(Loan loan, String databasename, Integer amountvalid) throws Exception, CustomException {
        try {
            Connection connection = ConnectionDB.con(databasename);
            String validateAccountSql = Constant.PANCARDCHECK;
            PreparedStatement validateAccountStatement = connection.prepareStatement(validateAccountSql);
            validateAccountStatement.setString(1, loan.getPanCard());
            ResultSet accountResultSet = validateAccountStatement.executeQuery();
            if (accountResultSet.next()) {
                if (loan.getLoanAmount() > 50000) {
                    String insertLoanSql = Constant.LOANINSERT;
                    PreparedStatement insertLoanStatement = connection.prepareStatement(insertLoanSql);
                    insertLoanStatement.setString(1, loan.getPanCard());
                    insertLoanStatement.setString(2, loan.getLoanNumber());
                    insertLoanStatement.setInt(3, loan.getLoanAmount());
                    insertLoanStatement.setString(4, "Pending");
                    int resultSet = insertLoanStatement.executeUpdate();
                    if (resultSet > 0) {
                        Sout.print(Constant.SUCCESSFULLYCREATED);
                        CustomerView.customerFunction(databasename, amountvalid);
                    } else {
                        throw new CustomException(Constant.UNSUCCESSFULLYCREATED);
                    }

                } else {
                    String insertLoanSql = Constant.LOANINSERT;
                    PreparedStatement insertLoanStatement = connection.prepareStatement(insertLoanSql);
                    insertLoanStatement.setString(1, loan.getPanCard());
                    insertLoanStatement.setString(2, loan.getLoanNumber());
                    insertLoanStatement.setInt(3, loan.getLoanAmount());
                    insertLoanStatement.setString(4, "Approved");
                    int resultSet = insertLoanStatement.executeUpdate();
                    if (resultSet > 0) {
                        Sout.print(Constant.SUCCESSFULLYCREATED);
                        CustomerView.customerFunction(databasename, amountvalid);
                    } else {
                        throw new CustomException(Constant.UNSUCCESSFULLYCREATED);
                    }
                }
            } else {
                throw new CustomException(Constant.INVALIDPANCARD);
            }

        } catch (Exception e) {
            throw e;
        }
    }
}
