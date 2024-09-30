/*
*********************************************************************************************************
 *  @Java Class Name :   CashierService
 *  @Author          :   Manish Kripalani (Manish.kripalani@antrazal.com)
 *  @Company         :   Antrazal
 *  @Date            :   17-09-2024
 *  @Description     :   This class provides service methods for cashier operations such as validating
 *                       user existence, creating new users, and handling deposits for both single and
 *                       joint accounts. It interacts with respective repository classes.
 *******************************************************************************************************
 *  AWC ID     Developer                                                 TITLE  
 *  1633      <Manish Kripalani>(manish.kripalani@antrazal.com)      JAVA ASSIGNMENT
********************************************************************************************************
*/

package Service;

import Pojo.Employee;
import Pojo.Transaction;
import Repository.CashierRepo.CashierUserCreated;
import Repository.CashierRepo.CashierUservalid;

/*
 *********************************************************
 *  @Method Name    :   userexit
 *  @Author         :   Manish Kripalani (Manish.kripalani@antrazal.com)
 *  @Company        :   Antrazal
 *  @Description    :   This method validates whether the user exists in the system by
 *                      calling the uservalid method in the CashierUservalid repository.
 *  @param          :   emp (Employee) - Employee object to validate
 *                      databaseName (String) - Database name for validation
 *                      amountvalid (Integer) - Amount to validate
 *  @throws         :   Exception - Throws exception if validation fails
 *********************************************************
 */
public class CashierService {

    public static void userexit(Employee emp, String databaseName, Integer amountvalid) throws Exception {
        try {
            CashierUservalid.uservalid(emp, databaseName, amountvalid);
        } catch (Exception e) {
            throw e;
        }
    }

    /*
     *********************************************************
    * @Method Name : usernotexit
    * @Author : Manish Kripalani (Manish.kripalani@antrazal.com)
    * @Company : Antrazal
    * @Description : This method creates a new user if they do not exist by calling the usernamecreated method in the CashierUserCreated repository.
    * @param : emp (Employee) - Employee object for creating a new user databaseName (String) - Database name where the user will be created amountvalid (Integer) - Amount related to user creation
    * @throws : Exception - Throws exception if user creation fails
    *********************************************************
    */
    public static void usernotexit(Employee emp, String databaseName, Integer amountvalid) throws Exception {
        try {
            CashierUserCreated.usernamecreated(emp, databaseName, amountvalid);
        } catch (Exception e) {
            throw e;
        }
    }

    /*
    *********************************************************
    * @Method Name : singleAccountDeposite
    * @Author : Manish Kripalani (Manish.kripalani@antrazal.com)
    * @Company : Antrazal
    * @Description : This method handles deposit transactions for a single account by calling the insert method in the singleAccountDeposite repository.
    * @param : databasename (String) - Database name where the transaction occurs
    *          amountvalid (Integer) - Validated amount for the deposit
    *            trans (Transaction) - Transaction object containing details of the deposit
    * @throws : Exception - Throws exception if the deposit operation fails
    *********************************************************
    */
    public static void singleAccountDeposite(String databasename, Integer amountvalid, Transaction trans)
            throws Exception {
        try {
            Repository.CashierRepo.singleAccountDeposite.insert(databasename, amountvalid, trans);
        } catch (Exception e) {
            throw e;
        }
    }

    /*
    *********************************************************
    * @Method Name : jointAccountDeposite
    * @Author : Manish Kripalani (Manish.kripalani@antrazal.com)
    * @Company : Antrazal
    * @Description : This method handles deposit transactions for a joint account by calling the insert method in the jointAccountDeposite repository.
    * @param : databasename (String) - Database name where the transaction occurs
    *            amountvalid (Integer) - Validated amount for the deposit
    *            trans (Transaction) - Transaction object containing details of the deposit
    * @throws : Exception - Throws exception if the deposit operation fails
    *********************************************************
    */
    public static void jointAccountDeposite(String databasename, Integer amountvalid, Transaction trans)
            throws Exception {
        try {
            Repository.CashierRepo.jointAccountDeposite.insert(databasename, amountvalid, trans);
        } catch (Exception e) {
            throw e;
        }
    }
}
