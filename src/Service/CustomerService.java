/*
*********************************************************************************************************
 *  @Java Class Name :   CustomerService
 *  @Author          :   Manish Kripalani (Manish.kripalani@antrazal.com)
 *  @Company         :   Antrazal
 *  @Date            :   17-09-2024
 *  @Description     :   This class provides service methods for customer operations such as validating
 *                       user existence, creating new users, handling PIN creation, withdrawals, loans,
 *                       and printing passbooks. It interacts with respective repository classes.
 *********************************************************************************************************
 */

 package Service;

 import Pojo.Loan;
 import Pojo.Login;
import Repository.CustomerRepo.CustomerJointPin;
import Repository.CustomerRepo.CustomerSinglePin;
import Repository.CustomerRepo.CustomerUserCreated;
import Repository.CustomerRepo.CustomerUservalid;
import Repository.CustomerRepo.GeneratingPassbook;
import Repository.CustomerRepo.WithdrawJoint;
import Repository.CustomerRepo.WithdrawSingle;
import Repository.ManagerRepo.CustomerLoan;
 
 /*
  *********************************************************
  *  @Method Name    :   userexit
  *  @Author         :   Manish Kripalani (Manish.kripalani@antrazal.com)
  *  @Company        :   Antrazal
  *  @Description    :   This method validates if a customer already exists in the system.
  *                      It calls the uservalid method in the CustomerUservalid repository.
  *  @param          :   log (Login) - Login object for validation
  *                      dbname (String) - Database name for validation
  *                      amount (Integer) - Amount for validation
  *  @throws         :   Exception - Throws exception if validation fails
  *********************************************************
  */
 public class CustomerService {
 
     public static void userexit(Login log, String dbname, Integer amount) throws Exception {
         try {
             CustomerUservalid.uservalid(log, dbname, amount);
         } catch (Exception e) {
             throw e;
         }
     }
 
     /*
      *********************************************************
      *  @Method Name    :   usernotexit
      *  @Author         :   Manish Kripalani (Manish.kripalani@antrazal.com)
      *  @Company        :   Antrazal
      *  @Description    :   This method creates a new user if they don't exist by calling
      *                      the usernamecreated method in the CustomerUserCreated repository.
      *  @param          :   log (Login) - Login object for user creation
      *                      dbname (String) - Database name where the user will be created
      *                      amount (Integer) - Amount related to user creation
      *  @throws         :   Exception - Throws exception if user creation fails
      *********************************************************
      */
     public static void usernotexit(Login log, String dbname, Integer amount) throws Exception {
         try {
             CustomerUserCreated.usernamecreated(log, dbname, amount);
         } catch (Exception e) {
             throw e;
         }
     }
 
     /*
      *********************************************************
      *  @Method Name    :   createPinSingle
      *  @Author         :   Manish Kripalani (Manish.kripalani@antrazal.com)
      *  @Company        :   Antrazal
      *  @Description    :   This method creates a PIN for a single account by calling the
      *                      insert method in the CustomerSinglePin repository.
      *  @param          :   validAccountnumber (String) - Valid account number
      *                      validpin (Integer) - Valid PIN to be created
      *                      databasename (String) - Database name where the PIN will be created
      *                      amountvalid (Integer) - Valid amount for validation
      *  @throws         :   Exception - Throws exception if PIN creation fails
      *********************************************************
      */
     public static void createPinSingle(String validAccountnumber, Integer validpin, String databasename,
             Integer amountvalid) throws Exception {
         try {
             CustomerSinglePin.insert(validAccountnumber, validpin, databasename, amountvalid);
         } catch (Exception e) {
             throw e;
         }
     }
 
     /*
      *********************************************************
      *  @Method Name    :   createPinJoint
      *  @Author         :   Manish Kripalani (Manish.kripalani@antrazal.com)
      *  @Company        :   Antrazal
      *  @Description    :   This method creates a PIN for a joint account by calling the
      *                      insert method in the CustomerJointPin repository.
      *  @param          :   validAccountnumber (String) - Valid account number
      *                      validpin (Integer) - Valid PIN to be created
      *                      databasename (String) - Database name where the PIN will be created
      *                      amountvalid (Integer) - Valid amount for validation
      *  @throws         :   Exception - Throws exception if PIN creation fails
      *********************************************************
      */
     public static void createPinJoint(String validAccountnumber, Integer validpin, String databasename,
             Integer amountvalid) throws Exception {
         try {
             CustomerJointPin.insert(validAccountnumber, validpin, databasename, amountvalid);
         } catch (Exception e) {
             throw e;
         }
     }
 
     /*
      *********************************************************
      *  @Method Name    :   withdrawSingle
      *  @Author         :   Manish Kripalani (Manish.kripalani@antrazal.com)
      *  @Company        :   Antrazal
      *  @Description    :   This method processes withdrawals for a single account by calling the
      *                      withdraw method in the WithdrawSingle repository.
      *  @param          :   validAccountnumber (String) - Valid account number
      *                      validpin (Integer) - Valid PIN for withdrawal
      *                      amount (Integer) - Amount to be withdrawn
      *                      databasename (String) - Database name where the transaction will occur
      *                      amountvalid (Integer) - Valid amount for validation
      *  @throws         :   Exception - Throws exception if withdrawal fails
      *********************************************************
      */
     public static void withdrawSingle(String validAccountnumber, Integer validpin, Integer amount, String databasename,
             Integer amountvalid) throws Exception {
         try {
             WithdrawSingle.withdraw(validAccountnumber, validpin, amount, databasename, amountvalid);
         } catch (Exception e) {
             throw e;
         }
     }
 
     /*
      *********************************************************
      *  @Method Name    :   withdrawJoint
      *  @Author         :   Manish Kripalani (Manish.kripalani@antrazal.com)
      *  @Company        :   Antrazal
      *  @Description    :   This method processes withdrawals for a joint account by calling the
      *                      withdraw method in the WithdrawJoint repository.
      *  @param          :   validAccountnumber (String) - Valid account number
      *                      validpin (Integer) - Valid PIN for withdrawal
      *                      amount (Integer) - Amount to be withdrawn
      *                      databasename (String) - Database name where the transaction will occur
      *                      amountvalid (Integer) - Valid amount for validation
      *  @throws         :   Exception - Throws exception if withdrawal fails
      *********************************************************
      */
     public static void withdrawJoint(String validAccountnumber, Integer validpin, Integer amount, String databasename,
             Integer amountvalid) throws Exception {
         try {
             WithdrawJoint.withdraw(validAccountnumber, validpin, amount, databasename, amountvalid);
         } catch (Exception e) {
             throw e;
         }
     }
 
     /*
      *********************************************************
      *  @Method Name    :   createLoan
      *  @Author         :   Manish Kripalani (Manish.kripalani@antrazal.com)
      *  @Company        :   Antrazal
      *  @Description    :   This method processes loan creation by calling the create method
      *                      in the CustomerLoan repository.
      *  @param          :   loan (Loan) - Loan object containing loan details
      *                      databasename (String) - Database name where the loan will be created
      *                      amountvalid (Integer) - Valid amount for validation
      *  @throws         :   Exception - Throws exception if loan creation fails
      *********************************************************
      */
     public static void createLoan(Loan loan, String databasename, Integer amountvalid) throws Exception {
         try {
             CustomerLoan.create(loan, databasename, amountvalid);
         } catch (Exception e) {
             throw e;
         }
     }
 
     /*
      *********************************************************
      *  @Method Name    :   printpassbookCustomer
      *  @Author         :   Manish Kripalani (Manish.kripalani@antrazal.com)
      *  @Company        :   Antrazal
      *  @Description    :   This method prints the passbook for the customer by calling the
      *                      printpassbookCustomer method in the GeneratingPassbook repository.
      *  @param          :   validpannumber (String) - Valid PAN number for customer
      *                      databasename (String) - Database name where the passbook will be printed
      *                      amountvalid (Integer) - Valid amount for validation
      *  @throws         :   Exception - Throws exception if passbook printing fails
      *********************************************************
      */
     public static void printpassbookCustomer(String validpannumber, String databasename, Integer amountvalid) throws Exception {
         try {
             GeneratingPassbook.printpassbookCustomer(validpannumber, databasename, amountvalid);
         } catch (Exception e) {
             throw e;
         }
     }
 }
 