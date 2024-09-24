/*
*********************************************************************************************************
 *  @Java Class Name :   ConnectionDB
 *  @Author          :   Manish Kripalani (manish.kripalani@antrazal.com)
 *  @Company         :   Antrazal
 *  @Date            :   17-09-2024
 *  @Description     :   Class for establishing a connection with a MySQL Database.
 *******************************************************************************************************
*/
package Repository.DatabaseRepo;

import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {

    /*
    *********************************************************
     *  @Method Name    :   con
     *  @Author         :   Manish Kripalani (manish.kripalani@antrazal.com)
     *  @Company        :   Antrazal
     *  @Description    :   Establishes a connection to the MySQL database using the provided database name.
     *  @param          :   dbname (String) - The name of the database to connect to.
     *  @return         :   java.sql.Connection - The connection object for the specified database.
     *********************************************************
    */
    public static java.sql.Connection con(String dbname) {
        
        String url = "jdbc:mysql://localhost:3306/" + dbname;
        String userName = "root";
        String pass = "admin";
        
        java.sql.Connection conn = null; 
        
        try {
            conn = DriverManager.getConnection(url, userName, pass);  
            

        } catch (SQLException e) {
            System.out.println("Error connecting to MySQL: " + e.getMessage());
            e.printStackTrace();
        } 
        return conn; 
    }
}
