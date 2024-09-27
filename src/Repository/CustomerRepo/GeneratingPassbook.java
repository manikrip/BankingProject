/*
*********************************************************************************************************
 *  @Java Class Name :   GeneratingPassbook
 *  @Author          :   Manish Kripalani (manish.kripalani@antrazal.com)
 *  @Company         :   Antrazal
 *  @Date            :   17-09-2024
 *  @Description     :   This class is responsible for generating a passbook for the customer by 
 *                       writing their transaction history to a text file. The passbook is named 
 *                       according to the valid PAN number provided by the user.
 *******************************************************************************************************
 *  AWC ID     Developer                                             	  	TITLE  
 *  1633      <Manish Kripalani>(manish.kripalani@antrazal.com)      JAVA ASSIGNMENT
********************************************************************************************************
*/

package Repository.CustomerRepo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import Repository.DatabaseRepo.ConnectionDB;
import Repository.DatabaseRepo.TransactionHistory;
import Utils.Constant;
import Utils.CustomException;

public class GeneratingPassbook {

    /*
     *********************************************************
     * @Method Name : printpassbookCustomer
     * @Author : Manish Kripalani (manish.kripalani@antrazal.com)
     * @Company : Antrazal
     * @Description : This method retrieves the transaction history for a customer and writes it to a passbook file named after the customer's PAN number. If the transaction history is empty, it prints a success message without creating a file.
     * @param : validpannumber (String) - The PAN number of the customer used for naming the file.
     *          databasename (String) - The name of the database to retrieve transaction history from.
     *          amountvalid (Integer) - A parameter indicating a certain amount, potentially for validation.
     * @throws : Exception - If an error occurs during file writing or database access.
     *********************************************************
     */
    public static void printpassbookCustomer(String validpannumber, String databasename, Integer amountvalid)
            throws Exception {
        try {
            ConnectionDB connectionDB = new ConnectionDB();
            Connection connection = connectionDB.con(databasename);
            String transactionHistory = TransactionHistory.getTransactionHistory(databasename, amountvalid,
                    validpannumber);
            String filePath = "./" + validpannumber + ".txt"; // Write the transaction history to the file

            // Check if transaction history is empty
            if (transactionHistory == null || transactionHistory.isEmpty()) {
                throw new CustomException(Constant.SUCCESSFULLYCREATED);
            }

            // Write the transaction history to the file
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                writer.write(transactionHistory); // Write transaction history to the file
                writer.flush(); // Ensure all data is written to the file before closing

                throw new CustomException(Constant.SUCCESSFULLYCREATED);
            } catch (IOException e) {
                throw new CustomException(Constant.UNSUCCESSFULLYCREATED);
            }

        } catch (Exception e) {
            throw e;
        }
    }
}
