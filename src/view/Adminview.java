package view;

import Middleware.AdminMiddleware; // Importing middleware for admin operations
import Middleware.ManagerMiddleware;
import Utils.Constant; // Importing constants for messages
import Utils.Sout; // Importing utility for output operations
import Utils.TakingInput; // Importing utility for taking user input
/*
*********************************************************************************************************
 *  @Java Class Name :   Adminview
 *  @Author          :   Manish Kripalani (Manish.kripalani@antrazal.com)
 *  @Company         :   Antrazal
 *  @Date            :   17-09-2024
 *  @Description     :   This class contains a view functionality.
 *******************************************************************************************************
 *  AWC ID     Developer                                             	  	TITLE  
 *  1633      <Manish Kripalani>(manish.kripalani@antrazal.com)      JAVA ASSIGNMENT
********************************************************************************************************
*/
public class Adminview {

    /*
*********************************************************
 *  @Method Name    :   takingPassword
 *  @Author         :   Manish Kripalani (Manish.kripalani@antrazal.com)
 *  @Company        :   Antrazal
 *  @Description    :   This method prompts the user to enter a password. 
 *                      It repeatedly asks for the password until a valid one is provided.
 *                      The password is validated by the ManagerMiddleware.
 *  @return         :   String - Valid password
 *********************************************************
 */
public static String takingPassword() throws Exception {
    String password = "";
    while (true) {
        try {
            System.out.print(Constant.PASSWORD);
            password = TakingInput.input().nextLine();
            password = ManagerMiddleware.checkPassword(password);
            break; // Exit loop if password is valid
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    return password;
}
/*
*********************************************************
 *  @Method Name    :   takingEmail
 *  @Author         :   Manish Kripalani (Manish.kripalani@antrazal.com)
 *  @Company        :   Antrazal
 *  @Description    :   This method prompts the user to enter an email address. 
 *                      It repeatedly asks for the email until a valid one is provided.
 *                      The email is validated by the AdminMiddleware.
 *  @return         :   String - Valid email address
 *********************************************************
 */
public static String takingEmail() throws Exception {
    String email = "";
    while (true) {
        try {
            System.out.print(Constant.ADMINEMAIL);
            email = TakingInput.input().nextLine(); // Read input
            email = AdminMiddleware.checkEmail(email); // Validate email
            break; // Exit loop if email is valid
        } catch (Exception e) {
            System.out.println(e.getMessage()); // Show error message and re-prompt
        }
    }
    return email;
}
/*
*********************************************************
 *  @Method Name    :   takingName
 *  @Author         :   Manish Kripalani (Manish.kripalani@antrazal.com)
 *  @Company        :   Antrazal
 *  @Description    :   This method prompts the user to enter a name. 
 *                      It repeatedly asks for the name until a valid one is provided.
 *                      The name is validated by the ManagerMiddleware.
 *  @return         :   String - Valid name
 *********************************************************
 */
public static String takingName() throws Exception {
    String name = "";
    while (true) {
        try {
            System.out.print(Constant.NAME);
            name = TakingInput.input().nextLine(); // Read name
            name = ManagerMiddleware.checkName(name); // Validate name
            break; // Exit loop if name is valid
        } catch (Exception e) {
            System.out.println(e.getMessage()); // Show error message
        }
    }
    return name;
}
/*
*********************************************************
 *  @Method Name    :   takingBranchName
 *  @Author         :   Manish Kripalani (Manish.kripalani@antrazal.com)
 *  @Company        :   Antrazal
 *  @Description    :   This method prompts the user to enter a branch name. 
 *                      It repeatedly asks for the branch name until a valid one is provided.
 *                      The branch name is validated by the ManagerMiddleware.
 *  @return         :   String - Valid branch name
 *********************************************************
 */
public static String takingBranchName() throws Exception {
    String branchName = "";
    while (true) {
        try {
            System.out.print(Constant.BRANCHNAME);
            branchName = TakingInput.input().nextLine(); // Read branch name
            branchName = ManagerMiddleware.checkName(branchName); // Validate branch name
            break; // Exit loop if branch name is valid
        } catch (Exception e) {
            System.out.println(e.getMessage()); // Show error message
        }
    }
    return branchName;
}
/*
*********************************************************
 *  @Method Name    :   takingaddress
 *  @Author         :   Manish Kripalani (Manish.kripalani@antrazal.com)
 *  @Company        :   Antrazal
 *  @Description    :   This method prompts the user to enter an address. 
 *                      It repeatedly asks for the address until a valid one is provided.
 *                      The address is validated by the AdminMiddleware.
 *  @return         :   String - Valid address
 *********************************************************
 */
public static String takingaddress() throws Exception {
    String address = "";
    while (true) {
        try {
            Sout.print(Constant.ADDRESS);
            address = TakingInput.input().nextLine(); // Read address
            address = AdminMiddleware.checkAddress(address); // Validate address
            break; // Exit loop if address is valid
        } catch (Exception e) {
            System.out.println(e.getMessage()); // Show error message
        }
    }
    return address;
}
/*
*********************************************************
 *  @Method Name    :   takingcity
 *  @Author         :   Manish Kripalani (Manish.kripalani@antrazal.com)
 *  @Company        :   Antrazal
 *  @Description    :   This method prompts the user to enter a city name. 
 *                      It repeatedly asks for the city name until a valid one is provided.
 *                      The city name is validated by the AdminMiddleware.
 *  @return         :   String - Valid city name
 *********************************************************
 */
public static String takingcity() throws Exception {
    String city = "";
    while (true) {
        try {
            Sout.print(Constant.CITY);
            city = TakingInput.input().nextLine(); // Read city
            city = AdminMiddleware.checkAddress(city); // Validate city
            break; // Exit loop if city is valid
        } catch (Exception e) {
            System.out.println(e.getMessage()); // Show error message
        }
    }
    return city;
}
/*
*********************************************************
 *  @Method Name    :   takingUsername
 *  @Author         :   Manish Kripalani (Manish.kripalani@antrazal.com)
 *  @Company        :   Antrazal
 *  @Description    :   This method prompts the user to enter a username. 
 *                      It repeatedly asks for the username until a valid one is provided.
 *                      The username is validated by the ManagerMiddleware.
 *  @return         :   String - Valid username
 *********************************************************
 */
public static String takingUsername() throws Exception {
    String username = "";
    while (true) {
        try {
            System.out.print(Constant.USERNAME);
            username = TakingInput.input().nextLine(); // Read username
            username = ManagerMiddleware.checkUserName(username); // Validate username
            break; // Exit loop if username is valid
        } catch (Exception e) {
            System.out.println(e.getMessage()); // Show error message
        }
    }
    return username;
}
/*
*********************************************************
 *  @Method Name    :   adminLogin
 *  @Author         :   Manish Kripalani (Manish.kripalani@antrazal.com)
 *  @Company        :   Antrazal
 *  @Description    :   This method handles the admin login process by prompting the 
 *                      user to input the email, name, username, and password. The input 
 *                      values are validated before being passed to the AdminMiddleware 
 *                      for login functionality.
 *  @param          :   dbname (String) - Database name
 *  @return         :   void
 *********************************************************
 */


    public static void adminLogin(String dbname) {
        try {
            // Prompt for admin email
            String email = takingEmail(); // Read and validate admin email

            String name = takingName(); // Read admin name
            String username = takingUsername(); // Read admin username
            String password = takingPassword(); // Read admin password

            // Call middleware for login
            AdminMiddleware.AdminMiddlewarelogin(name, username, password, email, dbname);
        } catch (Exception e) {
            System.out.println(e.getMessage()); // Print error message
            adminLogin(dbname); // Recursive call to handle input again
        }
    }

    /*
     *********************************************************
     * @Method Name : adminSignIn
     * @Description : This method handles the admin signup process.
     *                   It collects admin details and calls the middleware for processing.
     * @param : dbname - Name of the database
     *          amount - Validated amount for operations
     * @return : void
     *********************************************************
     */
    public static void adminSignIn(String dbname, Integer amount) throws Exception {
        try {
            String username = takingUsername();
            String password = takingPassword();
            String email = takingEmail();// Read admin email
            AdminMiddleware.AdminMiddlewaresignup(dbname, amount, username, password, email); // Call middleware for
                                                                                              // signup
        } catch (Exception e) {
            if (e.getMessage().equals(Constant.SUCCESSFULLYCREATED)) {
                Adminview.adminFunction(dbname, amount);
            } else {
                throw e;
            }
            // Rethrow exception for higher-level handling
        }
    }

    /*
     *********************************************************
     * @Method Name : adminFunction
     * @Description : This method presents the admin with options to perform various functions. It calls the middleware based on the chosen option.
     * @param : dbname - Name of the database
     *          amount - Validated amount for operations
     * @return : void
     *********************************************************
     */
    public static void adminFunction(String dbname, Integer amount) {
        try {
            Constant.Adminoption(); // Display admin options
            String option = TakingInput.input().nextLine(); // Take user input for option
            AdminMiddleware.chooseOption(option, dbname, amount); // Call middleware for selected option
        } catch (Exception e) {
            System.out.println(e.getMessage()); // Print error message
            adminFunction(dbname, amount); // Recursive call to handle input again
        }
    }

    /*
     *********************************************************
     * @Method Name : createManagermail
     * @Description : This method collects data to create a manager's email and calls the middleware.
     * @param : dbname - Name of the database
     *          amount - Validated amount for operations
     * @return : void
     *********************************************************
     */
    public static void createManagermail(String dbname, Integer amount) throws Exception {
        try {
            String name = takingName();
            String email = takingEmail();// Read admin email
            String branchname = takingBranchName();
            AdminMiddleware.validateManageremail(name, email, branchname, dbname, amount); // Call middleware to
                                                                                           // validate email
        } catch (Exception e) {
            throw e; // Rethrow exception for higher-level handling
        }
    }

    /*
     *********************************************************
     * @Method Name : createBranch
     * @Description : This method collects data to create a new branch and calls the middleware.
     * @param : dbname - Name of the database
     * amount - Validated amount for operations
     * @return : void
     *********************************************************
     */
    public static void createBranch(String dbname, Integer amount) throws Exception {
        try {
            String branchname = takingBranchName();

            String city = takingcity();

            String address = takingaddress();

            AdminMiddleware.checkName(dbname, amount, branchname, city, address); // Call middleware to create branch
        } catch (Exception e) {
            throw e; // Rethrow exception for higher-level handling
        }
    }

    /*
     *********************************************************
     * @Method Name : createCashieremail
     * @Description : This method collects data to create a cashier's email and calls the middleware.
     * @param : dbname - Name of the database
     * amount - Validated amount for operations
     * @return : void
     *********************************************************
     */
    public static void createCashieremail(String dbname, Integer amount) throws Exception {
        try {
            String name = takingName();
            String email = takingEmail();// Read admin email

            String branchname = takingBranchName();
            AdminMiddleware.validateCashieremail(name, email, branchname, dbname, amount); // Call middleware to
                                                                                           // validate email
        } catch (Exception e) {
            throw e; // Rethrow exception for higher-level handling
        }
    }
}
