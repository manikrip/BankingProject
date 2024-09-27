/*
*********************************************************************************************************
 *  @Java Class Name :   ExecuteQuery
 *  @Author          :   Manish Kripalani (manish.kripalani@antrazal.com)
 *  @Company         :   Antrazal
 *  @Date            :   17-09-2024
 *  @Description     :   This class provides utility methods for executing SQL queries using a given database connection.
 *******************************************************************************************************
 *  AWC ID     Developer                                             	  	TITLE  
 *  1633      <Manish Kripalani>(manish.kripalani@antrazal.com)      JAVA ASSIGNMENT
********************************************************************************************************
*/
package Repository.DatabaseRepo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ExecuteQuery {

    /*
    *********************************************************
     *  @Method Name    :   executeUpdate
     *  @Author         :   Manish Kripalani (manish.kripalani@antrazal.com)
     *  @Company        :   Antrazal
     *  @Description    :   Executes a SQL UPDATE statement using the provided connection.
     *  @param          :   con (Connection) - The database connection to use.
     *                      query (String) - The SQL UPDATE statement to be executed.
     *  @throws         :   SQLException - If an error occurs while executing the query.
     *********************************************************
    */
    public static void executeUpdate(Connection con, String query) throws SQLException {
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException("Error executing update query: " + e.getMessage(), e);
        }
    }

    /*
    *********************************************************
     *  @Method Name    :   executeQuery
     *  @Author         :   Manish Kripalani (manish.kripalani@antrazal.com)
     *  @Company        :   Antrazal
     *  @Description    :   Executes a SQL query statement using the provided connection.
     *  @param          :   con (Connection) - The database connection to use.
     *                      query (String) - The SQL query statement to be executed.
     *  @throws         :   SQLException - If an error occurs while executing the query.
     *********************************************************
    */
    public static void executeQuery(Connection con, String query) throws SQLException {
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException("Error executing query: " + e.getMessage(), e);
        }
    }
}
