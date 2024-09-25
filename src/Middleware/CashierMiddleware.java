/*
*********************************************************************************************************
 *  @Java Class Name :   CashierMiddleware
 *  @Author          :   Manish Kripalani (Manish.kripalani@antrazal.com)
 *  @Company         :   Antrazal
 *  @Date            :   24-09-2024
 *  @Description     :   This class contains middleware methods for handling cashier login options, 
 *                       validation of user credentials, and deposit options. It ensures that inputs 
 *                       are properly validated before routing them for further processing.
 *********************************************************************************************************
 */

 package Middleware;

 import Pojo.Employee;
 import Pojo.Transaction;
 import Routing.CashierRouting;
 import Utils.Constant;
 import Utils.CustomException;
 import Validators.EmailValidator;
 import Validators.InputValidator;
 import Validators.PasswordValidator;
 import Validators.Positivenumber;
 import view.CashierView;
 import view.HomePageview;
 
 /*
  *********************************************************
  *  @Method Name    :   validateLoginOption
  *  @Author         :   Manish Kripalani (Manish.kripalani@antrazal.com)
  *  @Company        :   Antrazal
  *  @Description    :   This method validates the login option selected by the cashier 
  *                      and routes the option accordingly.
  *  @param          :   databaseName (String) - Name of the database
  *                      amountvalid (Integer) - Validated amount
  *                      option (String) - Option selected by the cashier
  *  @return         :   void
  *********************************************************
  */
 public class CashierMiddleware {
 
     public static void validateLoginOption(String databaseName, Integer amountvalid, String option)
             throws Exception, CustomException {
         try {
             switch (option) {
                 case "1":
                     CashierView.usernameexit(databaseName, amountvalid);
                     break;
                 case "2":
                     // Create a manager for a branch
                     CashierView.usernamenotexit(databaseName, amountvalid);
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
      *  @Method Name    :   cashierexit
      *  @Author         :   Manish Kripalani (Manish.kripalani@antrazal.com)
      *  @Company        :   Antrazal
      *  @Description    :   This method validates cashier credentials (email, username, password)
      *                      and routes them for login if valid.
      *  @param          :   email (String) - Cashier's email address
      *                      username (String) - Cashier's username
      *                      password (String) - Cashier's password
      *                      dbname (String) - Database name
      *                      amount (Integer) - Amount for validation
      *  @return         :   void
      *********************************************************
      */
     public static void cashierexit(String email, String username, String password, String dbname, Integer amount)
             throws Exception {
         try {
            EmailValidator emailValidator = new EmailValidator(email, " EMAIL ");
             String validemail = emailValidator.Validator();
             InputValidator validator2 = new InputValidator(username, " username ");
            String validusername = validator2.Validator();
            PasswordValidator passwordValidator = new PasswordValidator(password, " Password ");
            String validpassword = passwordValidator.Validator();
             Employee emp = new Employee("Cashier", null, null, validemail, validusername, validpassword);
             CashierRouting.usernameexit(emp, dbname, amount);
         } catch (Exception e) {
             throw e;
         }
     }
 
     /*
      *********************************************************
      *  @Method Name    :   cashiernotexit
      *  @Author         :   Manish Kripalani (Manish.kripalani@antrazal.com)
      *  @Company        :   Antrazal
      *  @Description    :   This method handles the creation of a new cashier account by validating
      *                      email, username, and password, and routes the data accordingly.
      *  @param          :   email (String) - Cashier's email address
      *                      username (String) - Cashier's username
      *                      password (String) - Cashier's password
      *                      dbname (String) - Database name
      *                      amount (Integer) - Amount for validation
      *  @return         :   void
      *********************************************************
      */
     public static void cashiernotexit(String email, String username, String password, String dbname, Integer amount)
             throws Exception {
         try {
            EmailValidator emailValidator = new EmailValidator(email, " EMAIL ");
             String validemail = emailValidator.Validator();
             InputValidator validator2 = new InputValidator(username, " username ");
            String validusername = validator2.Validator();
            PasswordValidator passwordValidator = new PasswordValidator(password, " Password ");
            String validpassword = passwordValidator.Validator();
             Employee emp = new Employee("Cashier", null, null, validemail, validusername, validpassword);
             CashierRouting.usernamenotexit(emp, dbname, amount);
         } catch (Exception e) {
             throw e;
         }
     }
 
     /*
      *********************************************************
      *  @Method Name    :   cashierOption
      *  @Author         :   Manish Kripalani (Manish.kripalani@antrazal.com)
      *  @Company        :   Antrazal
      *  @Description    :   This method allows the cashier to choose between different options
      *                      such as creating a single or joint deposit account.
      *  @param          :   databasename (String) - Database name
      *                      amountvalid (Integer) - Validated amount
      *                      option (String) - Option selected by the cashier
      *  @return         :   void
      *********************************************************
      */
     public static void cashierOption(String databasename, Integer amountvalid, String option) throws Exception {
         try {
             switch (option) {
                 case "1":
                     // Option 1: Create a new customer account
                     CashierRouting.singleDeposite(databasename, amountvalid);
                     break;
                 case "2":
                     // Option 2: Create a joint customer account
                     CashierRouting.jointDeposite(databasename, amountvalid);
                     break;
                 case "3":
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
      *  @Method Name    :   singleDeposite
      *  @Author         :   Manish Kripalani (Manish.kripalani@antrazal.com)
      *  @Company        :   Antrazal
      *  @Description    :   This method handles single account deposits by validating the account number 
      *                      and amount, and routing the transaction for further processing.
      *  @param          :   databasename (String) - Database name
      *                      amountvalid (Integer) - Validated amount
      *                      amount (Integer) - Deposit amount
      *                      accountNumber (String) - Account number for deposit
      *  @return         :   void
      *********************************************************
      */
     public static void singleDeposite(String databasename, Integer amountvalid, Integer amount, String accountNumber)
             throws Exception {
         try {
            InputValidator validator2 = new InputValidator(accountNumber, " accountNumber ");
            String validAccountNumber = validator2.Validator();
            Positivenumber positivenumber = new Positivenumber(amount, " validAccountNumber" );
             Integer validAmount = positivenumber.Validator();
             Transaction trans = new Transaction(validAccountNumber, "Deposite", null, validAmount);
             CashierRouting.singleAccountDeposite(databasename, amountvalid, trans);
         } catch (Exception e) {
             throw e;
         }
     }
 
     /*
      *********************************************************
      *  @Method Name    :   jointDeposite
      *  @Author         :   Manish Kripalani (Manish.kripalani@antrazal.com)
      *  @Company        :   Antrazal
      *  @Description    :   This method handles joint account deposits by validating the account number 
      *                      and amount, and routing the transaction for further processing.
      *  @param          :   databasename (String) - Database name
      *                      amountvalid (Integer) - Validated amount
      *                      amount (Integer) - Deposit amount
      *                      accountNumber (String) - Account number for deposit
      *  @return         :   void
      *********************************************************
      */
     public static void jointDeposite(String databasename, Integer amountvalid, Integer amount, String accountNumber)
             throws Exception {
         try {
            InputValidator validator2 = new InputValidator(accountNumber, " accountNumber ");
            String validAccountNumber = validator2.Validator();
            Positivenumber positivenumber = new Positivenumber(amount, " validNumber" );
            Integer validAmount = positivenumber.Validator();
             Transaction trans = new Transaction(validAccountNumber, "Deposite", null, validAmount);
             CashierRouting.jointAccountDeposite(databasename, amountvalid, trans);
         } catch (Exception e) {
             throw e;
         }
     }
 }
 