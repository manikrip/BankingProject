/*
*********************************************************************************************************
 *  @Java Class Name :   loginProcess
 *  @Author          :   Manish Kripalani (manish.kripalani@antrazal.com)
 *  @Company         :   Antrazal
 *  @Date            :   17-09-2024
 *  @Description     :   This class handles the login process for users. It validates user credentials 
 *                       against the database and determines if the login attempt is successful.
 *********************************************************************************************************
 */

 package Repository.DatabaseRepo;

 import java.sql.Connection;
 import java.sql.PreparedStatement;
 import java.sql.ResultSet;
 
 import Pojo.Employee;
 import Pojo.Login;
 import Utils.Constant;
 import Utils.Sout;
 
 public class loginProcess {
 
     /*
     *********************************************************
      *  @Method Name    :   login
      *  @Author         :   Manish Kripalani (manish.kripalani@antrazal.com)
      *  @Company        :   Antrazal
      *  @Description    :   This method validates the login credentials of an Employee against the database.
      *                      It returns true if the login is successful, otherwise false.
      *  @param          :   emp (Employee) - The Employee object containing username and password.
      *  @param          :   dbname (String) - The name of the database to connect to.
      *  @return         :   boolean - True if login is successful, otherwise false.
      *  @throws         :   Exception - If an error occurs during the login process.
      *********************************************************
      */
     public static boolean login(Employee emp, String dbname) throws Exception {
         boolean loginSuccessful = false; 
         try {
             ConnectionDB connectionDB = new ConnectionDB();
             Connection connection = connectionDB.con(dbname);
             String sql = Constant.VALIDATELOGIN;
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             preparedStatement.setString(1, emp.getUsername()); // Set the username in the query
             preparedStatement.setString(2, emp.getPassword()); // Set the password in the query
             ResultSet resultSet = preparedStatement.executeQuery(); // Execute the query
             
             // If the query returns a result, the login is successful
             if (resultSet.next()) {
                 loginSuccessful = true;
                 return loginSuccessful;
             } 
         } catch (Exception e) {
             throw e;
         }
         return loginSuccessful;
     }
 
     /*
     *********************************************************
      *  @Method Name    :   login
      *  @Author         :   Manish Kripalani (manish.kripalani@antrazal.com)
      *  @Company        :   Antrazal
      *  @Description    :   This method validates the login credentials of a user represented by the Login 
      *                      object against the database. It returns true if the login is successful, 
      *                      otherwise false.
      *  @param          :   log (Login) - The Login object containing username and password.
      *  @param          :   dbname (String) - The name of the database to connect to.
      *  @return         :   boolean - True if login is successful, otherwise false.
      *  @throws         :   Exception - If an error occurs during the login process.
      *********************************************************
      */
     public static boolean login(Login log, String dbname) throws Exception {
         boolean loginSuccessful = false; 
         try {
             ConnectionDB connectionDB = new ConnectionDB();
             Connection connection = connectionDB.con(dbname);
             String sql = Constant.VALIDATELOGIN;
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             preparedStatement.setString(1, log.getUsername()); // Set the username in the query
             preparedStatement.setString(2, log.getPassword()); // Set the password in the query
             ResultSet resultSet = preparedStatement.executeQuery(); // Execute the query
             
             // If the query returns a result, the login is successful
             if (resultSet.next()) {
                 loginSuccessful = true;
                 return loginSuccessful;
             } 
         } catch (Exception e) {
             throw e;
         }
         return loginSuccessful;
     }
 }
 