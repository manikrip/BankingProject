/*
*********************************************************************************************************
 *  @Java Class Name :   CustomerInformationprint
 *  @Author          :   Manish Kripalani (manish.kripalani@antrazal.com)
 *  @Company         :   Antrazal
 *  @Date            :   17-09-2024
 *  @Description     :   This class retrieves customer information based on a provided Pan Card number.
 *                       It queries the database and prints the relevant customer details if found.
 *******************************************************************************************************
*/
package Repository.ManagerRepo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Repository.DatabaseRepo.ConnectionDB;
import Service.ManagerService;
import Utils.Constant;
import Utils.CustomException;

public class CustomerInformationprint {

    /*
    *********************************************************
     *  @Method Name    :   getInfo
     *  @Author         :   Manish Kripalani (manish.kripalani@antrazal.com)
     *  @Company        :   Antrazal
     *  @Description    :   Retrieves customer information based on the provided Pan Card number.
     *                      If found, the information is printed using the ManagerService.
     *  @param          :   databaseName (String) - The name of the database to connect to.
     *  @param          :   amountvalid (Integer) - The valid amount for the transaction.
     *  @param          :   pancard (String) - The Pan Card number to search for.
     *  @throws         :   Exception - If any error occurs during the execution.
     *  @throws         :   CustomException - If the customer is not found in the database.
     *********************************************************
    */
    public static void getInfo(String databaseName, Integer amountvalid, String pancard) throws Exception, CustomException {
        try {
            StringBuilder result = new StringBuilder();
            ConnectionDB connectionDB = new ConnectionDB();
            Connection connection = connectionDB.con(databaseName);
            PreparedStatement selectPreparedStatement = null;
            ResultSet resultSet = null;
            String selectQuery = Constant.PANCARDCHECK;
            selectPreparedStatement = connection.prepareStatement(selectQuery);
            selectPreparedStatement.setString(1, pancard);
            resultSet = selectPreparedStatement.executeQuery();
            if(resultSet.next())
            {
                result.append("Email: ").append(resultSet.getString("email"))
                      .append(" | Accountnumber: ").append(resultSet.getString("accountnumber"))
                      .append(" | Name: ").append(resultSet.getString("name"))
                      .append(" | Amount: ").append(resultSet.getInt("amount")).append("\n");
                ManagerService.printCustomerInformation(result.toString(), databaseName, amountvalid);
            }
            else
            {
                throw new CustomException(Constant.UNSUCCESSFULLYCREATED);
            }

        } catch (Exception e) {
            throw e;
        }
    }

}
