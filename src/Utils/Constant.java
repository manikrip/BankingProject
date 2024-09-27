package Utils;

/*
*********************************************************************************************************
 *  @Java Class Name:   Constant
 *  @Author         :   Manish Kripalani (Manish.kripalani@antrazal.com)
 *  @Company        :   Antrazal
 *  @Date           :   24-09-2024
 *  @Description    :   This class represents a constant variable used in the program.
 *******************************************************************************************************
 *  AWC ID     Developer                                             	  	TITLE  
 *  1633      <Manish Kripalani>(manish.kripalani@antrazal.com)      JAVA ASSIGNMENT
********************************************************************************************************
*/

public class Constant {
    public static void viewDatabase() {
        System.out.println("Welcome to the Bank Application.");
        System.out.println("First, you need to create your bank database to proceed.");
        System.out.println("Enter the database name   ");
    }

    public static void Adminoption() {
        // Display the admin panel options
        System.out.println("Admin Panel:");
        System.out.println("1 => Create a new branch for the bank");
        System.out.println("2 => Create a manager for the bank's branch");
        System.out.println("3 => Create a cashier for the bank's branch");
        System.out.println("4 => Return to the home page");
        System.out.println("Please enter your option:");
    }

    public static void cashieroption() {
        // Display the cashier page options
        System.out.println("1 => Enter the amount you want to deposit");
        System.out.println("2 => Enter the amount for a joint deposit");
        System.out.println("3 => Return to the home page");
        System.out.println("Please enter the option:");
    }

    public static void Manageroption() {
        // Display the manager's options menu
        System.out.println("1 => Create a new Single customer account");
        System.out.println("2 => Create a new Joint customer account");
        System.out.println("3 => Update an existing customer account");
        System.out.println("4 => Remove a customer account");
        System.out.println("5 => Approve a customer loan");
        System.out.println("6 => View account details using PAN card");
        System.out.println("7 => Undo the last transaction");
        System.out.println("8 => Return to the home page");
        System.out.println("Please enter your option:");
    }

    public static void customeroption() {
        // Display the customer page options
        System.out.println("1 => Create your PIN  ");
        System.out.println("2 => Create a joint PIN  ");
        System.out.println("3 => Withdraw money from a single account  ");
        System.out.println("4 => Withdraw money from a joint account   ");
        System.out.println("5 => Take a loan  ");
        System.out.println("6 => Print the passbook ");
        System.out.println("7 => Return to the home page ");
        System.out.println("Please enter the option: ");
    }

    public static void LoginSingupOption() {

        System.out.println("1 => If you have username or password");
        System.out.println("2 => If you don't have username or password you want to update");
        System.out.println("Please enter your option:");
    }

    public final static String PANCARDD = "Pan Card number must contain only letters and numbers. Please enter a valid Pan Card number:";
    public final static String PANCARDSIZE = "Pan Card number must be exactly 12 characters long. Please enter a valid Pan Card number:";
    public final static String PINSIZE = "Invalid input. Please enter exactly 4 digits: ";
    public final static String LETTERDIGIT = "Invalid input. Please enter only letters and digit. ";
    public final static String MINIMUMAMOUNT = "You are entering less amount then the minimum bank amount set ";
    public final static String POSITIVEVALUE = "Value must be positive. Please enter a positive value f  ";
    public final static String VALIDSTRING = "Invalid input. Please enter only letters. ";
    public final static String EMAILREGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
    public final static String INVALIDEMAIL = "Invalid email format. Please enter a valid email address. ";
    public final static String VALIDEMAILENTER = "Enter the valid mail  ";
    public final static String UPDATEACCOUNT = "UPDATE account SET name = ?, email = ? WHERE pancard = ? AND isActive = TRUE";
    public final static String JOINTEMAILQUERY = "SELECT panCard FROM jointAccount WHERE panCard = ?";
    public final static String EMAILMODIFY = "1@gmail.com";
    public final static String EMAILJOINT = "SELECT email FROM jointAccount WHERE email = ?";
    public final static String PANCARDDIFFERENT = "Pancard numbers for both users should be different.";
    public final static String ACCOUNTINSERTQUERY = "INSERT INTO account (branchName, Name, panCard, Amount, email, accountNumber, isActive) VALUES (?, ?, ?, ?, ?, ?, TRUE)";
    public final static String AMOUNT = "Enter the amount ";
    public final static String ACCOUNTNUMBER = "Enter the Accountnumber ";
    public final static String SETPIN = "UPDATE account SET pin = ? WHERE AccountNumber = ?";
    public final static String SETJOINTPIN = "UPDATE jointaccount SET pin = ? WHERE AccountNumber = ?";
    public final static String PIN = "Enter the 4 digit pin (Number only) ";
    public final static String INVALIDACCOUNTNUMBER = "Invalid Account number ";
    public final static String PANCARD = "Enter the pancard ";
    public final static String LOANNUMBER = "Enter the LOANNUMBER ";
    public final static String LOANINSERT = "INSERT INTO Loan (panCard, loanNumber, loanAmount,status) VALUES (?, ?, ?,?)";
    public final static String APPROVEDREJECTED = "ENTER Approved OR Rejected ";
    public final static String INVALIDPANCARD = "Invalid Pan ";
    public final static String MANAGERALREDYEXIT = "A manager already exists for this branch.";
    public final static String CASHIERALREDYEXIT = "A manager already exists for this branch.";
    public final static String BRANCHDOESNOTEXIT = "Invalid Branch ";
    public final static String BRANCHEXIT = "Branch EXIT!!! ";
    public final static String HOMEPAGE = "Visit to HOMEPAGE";
    public final static String DATABASEERROR = "Database not created successfully";
    public final static String LIMITAMOUNT = "Set the minimum balance for the bank (must be a positive number): ";
    public final static String POSITIVEAMOUNT = "Number should be positive and greater than zero ";
    public final static String VALIDOPTION = "Invalid input. Please enter OPTION ONLY ";
    public final static String VALIDINPUT = "Invalid input. Please enter letters only. ";
    public final static String VALIDATEEMAIL = "SELECT email FROM Employee WHERE email = ? AND designation = ?";
    public final static String VALIDATECUSTOMEREMAIL = "SELECT * FROM account WHERE email = ?";
    public final static String VALIDATELOGIN = "SELECT * FROM passwordstore WHERE username = ? AND password = ?";
    public final static String BRANCHQUERY = "SELECT branchName FROM branch WHERE branchName = ?";
    public final static String BRANCHNAMEDESIGNATION = "SELECT * FROM Employee WHERE branchName = ? AND designation = ?";
    public final static String INSERTEMPLOYEE = "INSERT INTO Employee (branchName, Name, email, designation) VALUES (?, ?, ?, ?)";
    public final static String USERPASSWORD = "INSERT INTO passwordStore (email) VALUES (?)";
    public final static String BRANCHINSERT = "INSERT INTO branch (branchName, City, Address) VALUES (?, ?, ?)";
    public final static String PANCARDCHECK = "SELECT * FROM account WHERE panCard = ? AND isActive = TRUE";
    public final static String INSERTTRANSACTION = "INSERT INTO transactions (accountnumber, amount, type, transaction_time) VALUES (?, ?, ?, ?)";
    public final static String TRANSACTIONHISTORY = "SELECT * FROM TRANSACTIONS WHERE AccountNumber = ?";
    public final static String ACCOUNTCHECK = "SELECT * FROM account WHERE accountnumber = ? AND isActive = TRUE";
    public final static String JOINTACCOUNTCHECK = "SELECT * FROM jointaccount WHERE accountnumber = ?";
    public final static String UPDATECREDENTIAL = "UPDATE passwordstore SET username = ?, password = ? WHERE email = ?";
    public final static String ACCOUNTUPDATETRANSACTION = "UPDATE account SET amount = ? WHERE accountnumber = ?";
    public final static String ACCOUNTPIN = "SELECT * FROM account WHERE accountNumber = ? AND pin = ? AND isActive = TRUE";
    public final static String JOINTACCOUNTPIN = "SELECT * FROM jointaccount WHERE accountNumber = ? AND pin = ?";
    public final static String JOINTACCOUNTUPDATETRANSACTION = "UPDATE jointaccount SET amount = ? WHERE accountnumber = ?";
    public final static String createAccountTable = "CREATE TABLE IF NOT EXISTS account ("
            + "id INT AUTO_INCREMENT PRIMARY KEY,"
            + "name VARCHAR(255) NOT NULL,"
            + "email VARCHAR(255) UNIQUE NOT NULL,"
            + "branchname VARCHAR(255) NOT NULL,"
            + "pancard VARCHAR(255) UNIQUE NOT NULL,"
            + "accountNumber VARCHAR(255) UNIQUE NOT NULL,"
            + "isActive VARCHAR(10) NOT NULL,"
            + "pin INT ,"
            + "amount INT NOT NULL)";
    public final static String Employee = "CREATE TABLE IF NOT EXISTS employee ("
            + "id INT AUTO_INCREMENT PRIMARY KEY,"
            + "name VARCHAR(255) NOT NULL,"
            + "designation VARCHAR(255) NOT NULL,"
            + "branchname VARCHAR(255) ,"
            + "email VARCHAR(255) UNIQUE NOT NULL)";
    public final static String createJointAccountTable = "CREATE TABLE IF NOT EXISTS jointaccount ("
            + "id INT AUTO_INCREMENT PRIMARY KEY,"
            + "email VARCHAR(255) UNIQUE NOT NULL,"
            + "branchname VARCHAR(255) NOT NULL,"
            + "pancard VARCHAR(255) UNIQUE NOT NULL,"
            + "accountNumber VARCHAR(255) UNIQUE NOT NULL,"
            + "pin INT ,"
            + "amount INT NOT NULL)";
    public final static String createLoanTable = "CREATE TABLE IF NOT EXISTS loan ("
            + "id INT AUTO_INCREMENT PRIMARY KEY,"
            + "loannumber VARCHAR(255) UNIQUE NOT NULL,"
            + "pancard VARCHAR(255)  NOT NULL,"
            + "status VARCHAR(10) ,"
            + "loanamount INT NOT NULL)";
    public final static String createBranchTable = "CREATE TABLE IF NOT EXISTS branch ("
            + "id INT AUTO_INCREMENT PRIMARY KEY,"
            + "branchname VARCHAR(255) UNIQUE NOT NULL,"
            + "City VARCHAR(255) NOT NULL,"
            + "Address VARCHAR(255) NOT NULL)";
    public final static String createTransactionsTable = "CREATE TABLE IF NOT EXISTS transactions ("
            + "id INT AUTO_INCREMENT PRIMARY KEY,"
            + "AccountNumber VARCHAR(255) NOT NULL,"
            + "type VARCHAR(255) NOT NULL,"
            + "transaction_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,"
            + "amount INT NOT NULL)";

    public final static String INSERTJOINTACCOUNTQUERY = "INSERT INTO jointAccount (panCard, amount, branchname, email, accountNumber) VALUES (?, ?, ?, ?, ?)";
    public final static String passwordUsername = "CREATE TABLE IF NOT EXISTS passwordstore ("
            + "id INT AUTO_INCREMENT PRIMARY KEY,"
            + "email VARCHAR(255) UNIQUE NOT NULL,"
            + "username VARCHAR(255) UNIQUE,"
            + "password VARCHAR(255) )";

    public final static String DEELETETRANSACTION = "DELETE FROM transactions WHERE accountnumber = ? AND transaction_time = ?";
    public final static String FETCHDEPOSITE = "UPDATE account SET amount = amount - ? WHERE accountnumber = ? AND isActive = TRUE";
    public final static String FETCHWITHDRAW = "UPDATE account SET amount = amount + ? WHERE accountnumber = ? AND isActive = TRUE";
    public final static String FETCHACCOUNTDETAIL = "SELECT * FROM transactions WHERE Accountnumber = ? ORDER BY transaction_time DESC LIMIT 1";
    public final static String UPDATEDLOANQUERY = "UPDATE loan SET status = ? WHERE loannumber = ?";
    public final static String SUCCESSFULLYCREATED = "Created successfully";
    public final static String ISACTIVE = "UPDATE account SET isActive = FALSE WHERE pancard = ?";
    public final static String UNSUCCESSFULLYCREATED = "Failed !!!";
    public final static String INSUFFICIENTAMOUNT = "Insufficient Amount !!!";
    public final static String UNSUCCESSFULTRANSACTION = "Cannot undo transaction. The last transaction was more than 10 minutes ago.";
    public final static String ACCOUNTEXIT = "account exit";
    public final static String NOTRANSACTION = "No transaction records found for this email";
    public final static String LOANQUERY = "SELECT * FROM loan WHERE Status = ? AND Loannumber = ?";
    // SQL query to insert admin credentials into the 'passwordstore' table
    public final static String insertPasswordQuery = "INSERT INTO passwordstore (email, username, password) VALUES (?, ?, ?)";

    // SQL query to insert admin details into the 'Employee' table with designation
    // as 'Admin'
    public final static String insertEmployeeQuery = "INSERT INTO Employee (email, name, designation) VALUES (?, ?, ?)";
    public final static String VALIDEMAIL = "Invalid email ";
    public final static String ADMINNAME = "Enter the admin name  ";
    public final static String ADMINEMAIL = "Enter the admin email  ";
    public final static String ADMINUSERNAME = "Enter the admin username  ";
    public final static String ADMINPASSWORD = "Enter the admin Password  ";
    public final static String NAME = "Enter the name  ";
    public final static String USERNAME = "Enter the username  ";
    public final static String PASSWORD = "Enter the Password  ";
    public final static String EMAIL = "Enter the Email  ";
    public final static String CUSTOMER = "You are enter into customer  ";
    public final static String MANAGER = "You are enter into manager  ";
    public final static String CASHIER = "You are enter into cashier  ";
    public final static String ADMIN = "You are enter into admin  ";
    public final static String EXIT = "You are existing!!! Thank you for using the application.";
    public final static String WRONGOPTION = "You are entering the wrong option ";
    public final static String WRONGEMAIL = "You are entering the wrong email ";
    public final static String BRANCHNAME = "Enter the Branch name ";
    public final static String CITY = "Enter the CITY name  ";
    public final static String ADDRESS = "Enter the Address name  ";
    public final static String ADDRESSName = "Enter the correct Address name  ";
    public final static String CASHIERLOGIN = "Cashier Successfully login ";
    public final static String MANAGERLOGIN = "Manager Successfully login  ";
    public final static String CUSTOMERLOGIN = "Customer Successfully login  ";
    public final static String USERNAMEPASSWORD = "Successfully updated";

    public static void Homepageoption() {
        // Display the home page options
        System.out.println("1 => Customer");
        System.out.println("2 => Manager");
        System.out.println("3 => Cashier");
        System.out.println("4 => Admin");
        System.out.println("5 => Exit");
        System.out.println("Please enter the option:");
    }
}
