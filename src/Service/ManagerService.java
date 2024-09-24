/*
*********************************************************************************************************
 *  @Java Class Name :   ManagerService
 *  @Author          :   Manish Kripalani (Manish.kripalani@antrazal.com)
 *  @Company         :   Antrazal
 *  @Date            :   17-09-2024
 *  @Description     :   This class contains various methods that provide services related to managers. 
 *                       These services include managing employee accounts, joint accounts, approving loans, 
 *                       soft-deleting accounts, and handling transactions.
 *********************************************************************************************************
 */

 package Service;

 import Pojo.Customer;
 import Pojo.Employee;
 import Pojo.JointAccount;
 import Pojo.Loan;
import Repository.ManagerRepo.CustomerInformationprint;
import Repository.ManagerRepo.CustomerUndoTransaction;
import Repository.ManagerRepo.CustomerapprovedLoan;
import Repository.ManagerRepo.CustomersoftDelete;
import Repository.ManagerRepo.ManagerJointAccount;
import Repository.ManagerRepo.ManagerSingleAccount;
import Repository.ManagerRepo.ManagerUpdateAccount;
import Repository.ManagerRepo.ManagerUserCreated;
import Repository.ManagerRepo.ManagerUservalid;
import Routing.ManagerRouting;
 
 /*
 *********************************************************
  *  @Method Name    :   userexit
  *  @Author         :   Manish Kripalani (Manish.kripalani@antrazal.com)
  *  @Company        :   Antrazal
  *  @Description    :   This method validates if a manager exists by checking their credentials 
  *                      in the given database. Throws an exception in case of any errors.
  *  @param          :   emp (Employee) - Manager employee object.
  *                      databaseName (String) - The name of the database to query.
  *                      amountvalid (Integer) - Validation integer.
  *  @return         :   void
  *********************************************************
  */
 public class ManagerService {
 
     public static void userexit(Employee emp, String databaseName, Integer amountvalid) throws Exception {
         try {
             ManagerUservalid.uservalid(emp, databaseName, amountvalid);
         } catch (Exception e) {
             throw e;
         }
     }
 
     /*
     *********************************************************
      *  @Method Name    :   usernotexit
      *  @Author         :   Manish Kripalani (Manish.kripalani@antrazal.com)
      *  @Company        :   Antrazal
      *  @Description    :   This method creates a new manager if the manager doesn't already exist 
      *                      in the system.
      *  @param          :   emp (Employee) - Manager employee object.
      *                      databaseName (String) - The name of the database to insert into.
      *                      amountvalid (Integer) - Validation integer.
      *  @return         :   void
     *********************************************************
     */
     public static void usernotexit(Employee emp, String databaseName, Integer amountvalid) throws Exception {
         try {
             ManagerUserCreated.usernamecreated(emp, databaseName, amountvalid);
         } catch (Exception e) {
             throw e;
         }
     }
 
     /*
     *********************************************************
      *  @Method Name    :   createSAccount
      *  @Author         :   Manish Kripalani (Manish.kripalani@antrazal.com)
      *  @Company        :   Antrazal
      *  @Description    :   This method creates a single account for the given customer 
      *                      in the database.
      *  @param          :   databaseName (String) - The name of the database.
      *                      amountvalid (Integer) - Validation integer.
      *                      customer (Customer) - The customer object for whom the account is created.
      *  @return         :   void
     *********************************************************
     */
     public static void createSAccount(String databaseName, Integer amountvalid, Customer customer) throws Exception {
         try {
             ManagerSingleAccount.insert(databaseName, amountvalid, customer);
         } catch (Exception e) {
             throw e;
         }
     }
 
     /*
     *********************************************************
      *  @Method Name    :   createJAccount
      *  @Author         :   Manish Kripalani (Manish.kripalani@antrazal.com)
      *  @Company        :   Antrazal
      *  @Description    :   This method creates a joint account for the given customers 
      *                      in the database.
      *  @param          :   databaseName (String) - The name of the database.
      *                      amountvalid (Integer) - Validation integer.
      *                      jointAccount (JointAccount) - Joint account object.
      *                      validpancard1 (String) - The PAN card of one of the account holders.
      *                      name (String) - First account holder's name.
      *                      name1 (String) - Second account holder's name.
      *  @return         :   void
     *********************************************************
     */
     public static void createJAccount(String databaseName, Integer amountvalid, JointAccount jointAccount,
             String validpancard1, String name, String name1) throws Exception {
         try {
             ManagerJointAccount.insert(databaseName, amountvalid, jointAccount, validpancard1, name, name1);
         } catch (Exception e) {
             throw e;
         }
     }
 
     /*
     *********************************************************
      *  @Method Name    :   updationPancard
      *  @Author         :   Manish Kripalani (Manish.kripalani@antrazal.com)
      *  @Company        :   Antrazal
      *  @Description    :   This method updates the PAN card number for the given customer 
      *                      in the database.
      *  @param          :   databaseName (String) - The name of the database.
      *                      amountvalid (Integer) - Validation integer.
      *                      customer (Customer) - The customer object with updated PAN details.
      *  @return         :   void
     *********************************************************
     */
     public static void updationPancard(String databaseName, Integer amountvalid, Customer customer) throws Exception {
         try {
             ManagerUpdateAccount.update(databaseName, amountvalid, customer);
         } catch (Exception e) {
             throw e;
         }
     }
 
     /*
     *********************************************************
      *  @Method Name    :   softDelete
      *  @Author         :   Manish Kripalani (Manish.kripalani@antrazal.com)
      *  @Company        :   Antrazal
      *  @Description    :   This method soft deletes a customer account by activating a soft delete flag 
      *                      for the given PAN card.
      *  @param          :   databaseName (String) - The name of the database.
      *                      amountvalid (Integer) - Validation integer.
      *                      pancard (String) - PAN card of the customer.
      *  @return         :   void
     *********************************************************
     */
     public static void softDelete(String databaseName, Integer amountvalid, String pancard) throws Exception {
         try {
             CustomersoftDelete.activate(databaseName, amountvalid, pancard);
         } catch (Exception e) {
             throw e;
         }
     }
 
     /*
     *********************************************************
      *  @Method Name    :   approvedLoan
      *  @Author         :   Manish Kripalani (Manish.kripalani@antrazal.com)
      *  @Company        :   Antrazal
      *  @Description    :   This method approves a loan for a customer based on the information provided.
      *  @param          :   databaseName (String) - The name of the database.
      *                      amountvalid (Integer) - Validation integer.
      *                      loan (Loan) - Loan details for the approval.
      *  @return         :   void
     *********************************************************
     */
     public static void approvedLoan(String databaseName, Integer amountvalid, Loan loan) throws Exception {
         try {
             CustomerapprovedLoan.decide(databaseName, amountvalid, loan);
         } catch (Exception e) {
             throw e;
         }
     }
 
     /*
     *********************************************************
      *  @Method Name    :   CustomerInformationprint
      *  @Author         :   Manish Kripalani (Manish.kripalani@antrazal.com)
      *  @Company        :   Antrazal
      *  @Description    :   This method prints customer information based on the provided PAN card.
      *  @param          :   databaseName (String) - The name of the database.
      *                      amountvalid (Integer) - Validation integer.
      *                      pancard (String) - The customer's PAN card.
      *  @return         :   void
     *********************************************************
     */
     public static void CustomerInformationprint(String databaseName, Integer amountvalid, String pancard) throws Exception {
         try {
             CustomerInformationprint.getInfo(databaseName, amountvalid, pancard);
         } catch (Exception e) {
             throw e;
         }
     }
 
     /*
     *********************************************************
      *  @Method Name    :   printCustomerInformation
      *  @Author         :   Manish Kripalani (Manish.kripalani@antrazal.com)
      *  @Company        :   Antrazal
      *  @Description    :   This method prints customer information using ManagerRouting.
      *  @param          :   string (String) - Additional parameter for printing details.
      *                      databaseName (String) - The name of the database.
      *                      amountvalid (Integer) - Validation integer.
      *  @return         :   void
     *********************************************************
     */
     public static void printCustomerInformation(String string, String databaseName, Integer amountvalid) throws Exception {
         try {
             ManagerRouting.printCustomerInformation(string, databaseName, amountvalid);
         } catch (Exception e) {
             throw e;
         }
     }
 
     /*
     *********************************************************
      *  @Method Name    :   undoLastTransactioncustomer
      *  @Author         :   Manish Kripalani (Manish.kripalani@antrazal.com)
      *  @Company        :   Antrazal
      *  @Description    :   This method undoes the last transaction for a customer based on the account number.
      *  @param          :   databaseName (String) - The name of the database.
      *                      amountvalid (Integer) - Validation integer.
      *                      validAccountnumber (String) - Customer's account number.
      *  @return         :   void
     *********************************************************
     */
     public static void undoLastTransactioncustomer(String databaseName, Integer amountvalid, String validAccountnumber) throws Exception {
         try {
             CustomerUndoTransaction.undo(databaseName, amountvalid, validAccountnumber);
         } catch (Exception e) {
             throw e;
         }
     }
 }
 