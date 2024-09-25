/*
*********************************************************************************************************
 *  @Java Class Name :   AdminMiddleware
 *  @Author          :   Manish Kripalani (Manish.kripalani@antrazal.com)
 *  @Company         :   Antrazal
 *  @Date            :   24-09-2024
 *  @Description     :   This class contains middleware methods for handling the admin login, signup, 
 *                       and various options. It validates inputs such as name, email, username, and 
 *                       password before passing the data to the routing layer.
 *********************************************************************************************************
 */

 package Middleware;

 import Pojo.Branch;
 import Pojo.Employee;
 import Routing.AdminRouting;
 import Utils.Constant;
 import Utils.CustomException;
 import Utils.Sout;
import Validators.AddressValidator;
import Validators.EmailValidator;
 import Validators.InputValidator;
import Validators.PasswordValidator;
import Validators.*;
import view.HomePageview;
 import java.util.*;
 /*
  *********************************************************
  *  @Method Name    :   AdminMiddlewarelogin
  *  @Author         :   Manish Kripalani (Manish.kripalani@antrazal.com)
  *  @Company        :   Antrazal
  *  @Description    :   This method validates the admin's login credentials including the name, 
  *                      username, password, and email. It creates an Employee object and then 
  *                      routes the data for login.
  *  @param          :   name (String) - Admin's name
  *                      username (String) - Admin's username
  *                      password (String) - Admin's password
  *                      email (String) - Admin's email address
  *                      dbname (String) - The name of the database being used
  *  @return         :   void
  *********************************************************
  */
 public class AdminMiddleware {
    
     public static void AdminMiddlewarelogin(String name, String username, String password, String email, String dbname) throws Exception {
         try {
            // List<Validator> listOfValidations = new List<Validator>();
            // listOfValidations.add(new EmailValidator(email, " EMAIL "));
            // listOfValidations.add(new InputValidator(name, " name "));
            // listOfValidations.add(new InputValidator(username, " username "));
            // listOfValidations.add(new PasswordValidator(password, " Password "));
            // for(Validator vad: listOfValidations){
            //     vad.Validator();
            // }

            EmailValidator emailValidator = new EmailValidator(email, " EMAIL ");
            InputValidator validator = new InputValidator(name, " name ");
             String validName = validator.Validator();
             InputValidator validator1 = new InputValidator(username, " username ");
             String validUserName =  validator1.Validator();
             PasswordValidator passwordValidator = new PasswordValidator(password, " Password ");
             String validPassword = passwordValidator.Validator();
             String validEmail = emailValidator.Validator();
             Employee emp = new Employee("Admin", null, validName, validEmail, validUserName, validPassword);
             AdminRouting.adminLogin(emp, dbname);
         } catch (Exception e) {
             throw e;
         }
     }
 
     /*
      *********************************************************
      *  @Method Name    :   AdminMiddlewaresignup
      *  @Author         :   Manish Kripalani (Manish.kripalani@antrazal.com)
      *  @Company        :   Antrazal
      *  @Description    :   This method handles admin signup by validating the username, password, 
      *                      and email. It creates an Employee object and routes it for admin sign-in.
      *  @param          :   dbname (String) - The name of the database being used
      *                      amount (Integer) - Amount for transaction validation
      *                      username (String) - Admin's username
      *                      password (String) - Admin's password
      *                      email (String) - Admin's email address
      *  @return         :   void
      *********************************************************
      */
     public static void AdminMiddlewaresignup(String dbname, Integer amount, String username, String password, String email) throws Exception {
         try {
            EmailValidator emailValidator = new EmailValidator(email, " EMAIL ");
            InputValidator validator = new InputValidator(username, " username ");
            String validUserName = validator.Validator();
            PasswordValidator passwordValidator = new PasswordValidator(password, " Password ");
            String validPassword = passwordValidator.Validator();
             String validEmail = emailValidator.Validator();
             Employee emp = new Employee("Admin", null, null, validEmail, validUserName, validPassword);
             AdminRouting.adminSignIn(emp, dbname, amount);
         } catch (Exception e) {
             throw e;
         }
     }
 
     /*
      *********************************************************
      *  @Method Name    :   chooseOption
      *  @Author         :   Manish Kripalani (Manish.kripalani@antrazal.com)
      *  @Company        :   Antrazal
      *  @Description    :   This method allows the admin to choose an option for viewing branches, 
      *                      managers, or cashiers. It routes the option accordingly.
      *  @param          :   option (String) - The option selected by the admin
      *                      dbname (String) - The name of the database being used
      *                      amount (Integer) - Amount for transaction validation
      *  @return         :   void
      *********************************************************
      */
     public static void chooseOption(String option, String dbname, Integer amount) throws Exception, CustomException {
         try {
             switch (option) {
                 case "1":
                     AdminRouting.adminbranchView(dbname, amount);
                     break;
                 case "2":
                     AdminRouting.adminmanagerView(dbname, amount);
                     break;
                 case "3":
                     AdminRouting.admincashierView(dbname, amount);
                     break;
                 case "4":
                     Sout.print(Constant.HOMEPAGE);
                     HomePageview.homePage(dbname, amount);
                     break;
                 default:
                     throw new CustomException(Constant.WRONGOPTION);
             }
         } catch (Exception e) {
             throw e;
         }
     }
 
     /*
      *********************************************************
      *  @Method Name    :   validateManageremail
      *  @Author         :   Manish Kripalani (Manish.kripalani@antrazal.com)
      *  @Company        :   Antrazal
      *  @Description    :   This method validates the manager's name and email before routing it 
      *                      for further processing.
      *  @param          :   name (String) - Manager's name
      *                      email (String) - Manager's email address
      *                      branchname (String) - Branch name associated with the manager
      *                      dbname (String) - The name of the database being used
      *                      amount (Integer) - Amount for transaction validation
      *  @return         :   void
      *********************************************************
      */
     public static void validateManageremail(String name, String email, String branchname, String dbname, Integer amount) throws Exception {
         try {
            EmailValidator emailValidator = new EmailValidator(email, " EMAIL ");
            InputValidator validator = new InputValidator(name, "name");
            String validname = validator.Validator();
             String validemail = emailValidator.Validator();
             InputValidator validator1 = new InputValidator(branchname, "Branch");
             String validbranchname = validator1.Validator();
             Employee emp = new Employee("Manager", validbranchname, validname, validemail, null, null);
             AdminRouting.managerEmail(emp, dbname, amount);
         } catch (Exception e) {
             throw e;
         }
     }
 
     /*
      *********************************************************
      *  @Method Name    :   checkName
      *  @Author         :   Manish Kripalani (Manish.kripalani@antrazal.com)
      *  @Company        :   Antrazal
      *  @Description    :   This method validates the branch details (name, city, address) and 
      *                      routes the validated branch data for creation.
      *  @param          :   dbname (String) - The name of the database being used
      *                      amount (Integer) - Amount for transaction validation
      *                      branchname (String) - Branch name
      *                      city (String) - City where the branch is located
      *                      address (String) - Branch address
      *  @return         :   void
      *********************************************************
      */
     public static void checkName(String dbname, Integer amount, String branchname, String city, String address) throws Exception {
         try {
            AddressValidator addresses = new AddressValidator(address," address ");
            InputValidator validator1 = new InputValidator(branchname, "Branch");
             String validbranchname = validator1.Validator();
             InputValidator validator2 = new InputValidator(city, " city ");
             String validcity = validator2.Validator();
             String validaddress = addresses.Validator();
             Branch br = new Branch(validbranchname, validcity, validaddress);
             AdminRouting.branchCreate(br, dbname, amount);
         } catch (Exception e) {
             throw e;
         }
     }
 
     /*
      *********************************************************
      *  @Method Name    :   validateCashieremail
      *  @Author         :   Manish Kripalani (Manish.kripalani@antrazal.com)
      *  @Company        :   Antrazal
      *  @Description    :   This method validates the cashier's name and email before routing it 
      *                      for further processing.
      *  @param          :   name (String) - Cashier's name
      *                      email (String) - Cashier's email address
      *                      branchname (String) - Branch name associated with the cashier
      *                      dbname (String) - The name of the database being used
      *                      amount (Integer) - Amount for transaction validation
      *  @return         :   void
      *********************************************************
      */
     public static void validateCashieremail(String name, String email, String branchname, String dbname, Integer amount) throws Exception {
         try {
            EmailValidator emailValidator = new EmailValidator(email, " EMAIL ");
            
            InputValidator validator = new InputValidator(name, "name");
            String validname = validator.Validator();
             String validemail = emailValidator.Validator();
             InputValidator validator1 = new InputValidator(branchname, "Branch");
             String validbranchname = validator1.Validator();
             Employee emp = new Employee("Cashier", validbranchname, validname, validemail, null, null);
             AdminRouting.cashierEmail(emp, dbname, amount);
         } catch (Exception e) {
             throw e;
         }
     }
 }
 