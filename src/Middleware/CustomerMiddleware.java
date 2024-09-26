/*
*********************************************************************************************************
 *  @Java Class Name :   CustomerMiddleware
 *  @Author          :   Manish Kripalani (Manish.kripalani@antrazal.com)
 *  @Company         :   Antrazal
 *  @Date            :   24-09-2024
 *  @Description     :   This class contains middleware methods for handling customer login options,
 *                       validating user inputs for various customer actions such as creating PINs,
 *                       withdrawing money, and loan processing.
 *********************************************************************************************************
 */

 package Middleware;

 import Pojo.Loan;
 import Pojo.Login;
 import Routing.CustomerRouting;
 import Utils.Constant;
 import Utils.CustomException;
 import view.CustomerView;
 import view.HomePageview;
 
 /*
  *********************************************************
  *  @Method Name    :   validateLoginOption
  *  @Author         :   Manish Kripalani (Manish.kripalani@antrazal.com)
  *  @Company        :   Antrazal
  *  @Description    :   This method validates the login option selected by the customer 
  *                      and routes the option accordingly.
  *  @param          :   databaseName (String) - Name of the database
  *                      amountvalid (Integer) - Validated amount
  *                      option (String) - Option selected by the customer
  *  @return         :   void
  *********************************************************
  */
 public class CustomerMiddleware extends BaseMiddleware {
 
     public static void validateLoginOption(String databaseName, Integer amountvalid, String option)
             throws Exception, CustomException {
         try {
             switch (option) {
                 case "1":
                     CustomerView.usernameexit(databaseName, amountvalid);
                     break;
                 case "2":
                     // Create a manager for a branch
                     CustomerView.usernamenotexit(databaseName, amountvalid);
                     break;
                 default:
                     // Handle invalid option and retry
                     throw new CustomException(Constant.VALIDOPTION);
             }
         } catch (Exception e) {
             throw e;
         }
     }
 
     /*
      *********************************************************
      *  @Method Name    :   customerexit
      *  @Author         :   Manish Kripalani (Manish.kripalani@antrazal.com)
      *  @Company        :   Antrazal
      *  @Description    :   This method validates customer credentials (email, username, password)
      *                      and routes them for login if valid.
      *  @param          :   email (String) - Customer's email address
      *                      username (String) - Customer's username
      *                      password (String) - Customer's password
      *                      dbname (String) - Database name
      *                      amount (Integer) - Amount for validation
      *  @return         :   void
      *********************************************************
      */
     public static void customerexit(String email, String username, String password, String dbname, Integer amount)
             throws Exception {
         try {
           
             Login log = new Login(username, password, email);
             CustomerRouting.usernameexit(log, dbname, amount);
         } catch (Exception e) {
             throw e;
         }
     }
 
     /*
      *********************************************************
      *  @Method Name    :   customernotexit
      *  @Author         :   Manish Kripalani (Manish.kripalani@antrazal.com)
      *  @Company        :   Antrazal
      *  @Description    :   This method handles the creation of a new customer account by validating
      *                      email, username, and password, and routes the data accordingly.
      *  @param          :   email (String) - Customer's email address
      *                      username (String) - Customer's username
      *                      password (String) - Customer's password
      *                      dbname (String) - Database name
      *                      amount (Integer) - Amount for validation
      *  @return         :   void
      *********************************************************
      */
     public static void customernotexit(String email, String username, String password, String dbname, Integer amount)
             throws Exception {
         try {
            
      
             Login log = new Login(username, password, email);
             CustomerRouting.usernamenotexit(log, dbname, amount);
         } catch (Exception e) {
             throw e;
         }
     }
 
     /*
      *********************************************************
      *  @Method Name    :   customerOption
      *  @Author         :   Manish Kripalani (Manish.kripalani@antrazal.com)
      *  @Company        :   Antrazal
      *  @Description    :   This method allows the customer to choose between different actions such as 
      *                      creating a PIN, withdrawing money, or applying for a loan.
      *  @param          :   databasename (String) - Database name
      *                      amountvalid (Integer) - Validated amount
      *                      option (String) - Option selected by the customer
      *  @return         :   void
      *********************************************************
      */
     public static void customerOption(String databasename, Integer amountvalid, String option) throws Exception {
         try {
             switch (option) {
                 case "1":
                     CustomerRouting.createPin(databasename, amountvalid);
                     break;
                 case "2":
                     CustomerRouting.createJointPin(databasename, amountvalid);
                     break;
                 case "3":
                     CustomerRouting.withdrawMoneySingle(databasename, amountvalid);
                     break;
                 case "4":
                     CustomerRouting.withdrawMoneyJoint(databasename, amountvalid);
                     break;
                 case "5":
                     CustomerRouting.loan(databasename, amountvalid);
                     break;
                 case "6":
                     CustomerRouting.printPassbook(databasename, amountvalid);
                     break;
                 case "7":
                     HomePageview.homePage(databasename, amountvalid);
                     break;
                 default:
                     throw new CustomException(Constant.VALIDOPTION);
             }
         } catch (Exception e) {
             throw e;
         }
     }
 
     /*
      *********************************************************
      *  @Method Name    :   createPinSingle
      *  @Author         :   Manish Kripalani (Manish.kripalani@antrazal.com)
      *  @Company        :   Antrazal
      *  @Description    :   This method handles PIN creation for single accounts by validating the
      *                      account number and PIN, then routes the data accordingly.
      *  @param          :   accountNumber (String) - Account number for PIN creation
      *                      pin (Integer) - PIN to be set
      *                      databasename (String) - Database name
      *                      amountvalid (Integer) - Validated amount
      *  @return         :   void
      *********************************************************
      */
     public static void createPinSingle(String accountNumber, Integer pin, String databasename, Integer amountvalid)
             throws Exception {
         try {
            
             CustomerRouting.createPinSingle(accountNumber, pin, databasename, amountvalid);
         } catch (Exception e) {
             // Handle exceptions here
         }
     }
 
     /*
      *********************************************************
      *  @Method Name    :   createPinJoint
      *  @Author         :   Manish Kripalani (Manish.kripalani@antrazal.com)
      *  @Company        :   Antrazal
      *  @Description    :   This method handles PIN creation for joint accounts by validating the
      *                      account number and PIN, then routes the data accordingly.
      *  @param          :   accountNumber (String) - Account number for PIN creation
      *                      pin (Integer) - PIN to be set
      *                      databasename (String) - Database name
      *                      amountvalid (Integer) - Validated amount
      *  @return         :   void
      *********************************************************
      */
     public static void createPinJoint(String accountNumber, Integer pin, String databasename, Integer amountvalid)
             throws Exception {
         try {
          
             CustomerRouting.createPinJoint(accountNumber, pin, databasename, amountvalid);
         } catch (Exception e) {
             // Handle exceptions here
         }
     }
 
     /*
      *********************************************************
      *  @Method Name    :   withdrawSingle
      *  @Author         :   Manish Kripalani (Manish.kripalani@antrazal.com)
      *  @Company        :   Antrazal
      *  @Description    :   This method handles single account withdrawals by validating the account number, 
      *                      PIN, and amount before routing the transaction for further processing.
      *  @param          :   accountNumber (String) - Account number for withdrawal
      *                      pin (Integer) - PIN for authentication
      *                      amount (Integer) - Amount to be withdrawn
      *                      databasename (String) - Database name
      *                      amountvalid (Integer) - Validated amount
      *  @return         :   void
      *********************************************************
      */
     public static void withdrawSingle(String accountNumber, Integer pin, Integer amount, String databasename,
             Integer amountvalid) throws Exception {
         try {
          
             CustomerRouting.withdrawSingle(accountNumber, pin, amount, databasename, amountvalid);
         } catch (Exception e) {
             throw e;
         }
     }
 
     /*
      *********************************************************
      *  @Method Name    :   withdrawJoint
      *  @Author         :   Manish Kripalani (Manish.kripalani@antrazal.com)
      *  @Company        :   Antrazal
      *  @Description    :   This method handles joint account withdrawals by validating the account number, 
      *                      PIN, and amount before routing the transaction for further processing.
      *  @param          :   accountNumber (String) - Account number for withdrawal
      *                      pin (Integer) - PIN for authentication
      *                      amount (Integer) - Amount to be withdrawn
      *                      databasename (String) - Database name
      *                      amountvalid (Integer) - Validated amount
      *  @return         :   void
      *********************************************************
      */
     public static void withdrawJoint(String accountNumber, Integer pin, Integer amount, String databasename,
             Integer amountvalid) throws Exception {
         try {
           
             CustomerRouting.withdrawJoint(accountNumber, pin, amount, databasename, amountvalid);
         } catch (Exception e) {
             throw e;
         }
     }
 
     /*
      *********************************************************
      *  @Method Name    :   createloan
      *  @Author         :   Manish Kripalani (Manish.kripalani@antrazal.com)
      *  @Company        :   Antrazal
      *  @Description    :   This method processes loan requests by validating PAN number, loan number, 
      *                      and loan amount, then routes the loan request for further processing.
      *  @param          :   panNumber (String) - Customer's PAN number
      *                      loanNumber (String) - Customer's loan number
      *                      loanAmount (Integer) - Loan amount requested
      *                      databasename (String) - Database name
      *                      amountvalid (Integer) - Validated amount
      *  @return         :   void
      *********************************************************
      */
     public static void createloan(String panNumber, String loanNumber, Integer loanAmount, String databasename,
             Integer amountvalid) throws Exception {
         try {
           
             Loan loan = new Loan(loanNumber, panNumber, "Pending", loanAmount);
             CustomerRouting.createLoan(loan, databasename, amountvalid);
         } catch (Exception e) {
             throw e;
         }
     }
 
     /*
      *********************************************************
      *  @Method Name    :   printpassbook
      *  @Author         :   Manish Kripalani (Manish.kripalani@antrazal.com)
      *  @Company        :   Antrazal
      *  @Description    :   This method validates the PAN number and routes the request to print the passbook.
      *  @param          :   panNumber (String) - Customer's PAN number
      *                      databasename (String) - Database name
      *                      amountvalid (Integer) - Validated amount
      *  @return         :   void
      *********************************************************
      */
     public static void printpassbook(String panNumber, String databasename, Integer amountvalid) throws Exception {
         try {
          
             CustomerRouting.printpassbookCustomer(panNumber, databasename, amountvalid);
         } catch (Exception e) {
             throw e;
         }
     }

    
 }
 