/*
*********************************************************************************************************
 *  @Java Class Name :   DatabaseMiddleware
 *  @Author          :   Manish Kripalani (Manish.kripalani@antrazal.com)
 *  @Company         :   Antrazal
 *  @Date            :   17-09-2024
 *  @Description     :   This class provides middleware for validating the database name and amount. 
 *                       It ensures that the database name consists of only alphabetic characters and 
 *                       the amount is positive before routing or processing.
 *******************************************************************************************************
 *  AWC ID     Developer                                             	  	TITLE  
 *  1633      <Manish Kripalani>(manish.kripalani@antrazal.com)      JAVA ASSIGNMENT
********************************************************************************************************
*/

package Middleware;

import Routing.Databaserouting;
import Utils.Constant;
import Utils.CustomException;

/*
 *********************************************************
 *  @Method Name    :   databaseMiddleware
 *  @Author         :   Manish Kripalani (Manish.kripalani@antrazal.com)
 *  @Company        :   Antrazal
 *  @Description    :   This method validates the database name, ensuring it consists of only 
 *                      alphabetic characters. If valid, it routes the database; otherwise, 
 *                      it throws a custom exception.
 *  @param          :   dbname (String) - The name of the database to be validated and routed
 *  @throws         :   Exception - Throws exception if the database name is invalid
 *********************************************************
 */
public class DatabaseMiddleware extends BaseMiddleware {
    public static void databaseMiddleware(String dbname) throws Exception {
        try {
            if (dbname.matches("[a-zA-Z]+")) {
                Databaserouting.databaseRouting(dbname);
            } else {
                throw new CustomException(Constant.VALIDINPUT);
            }
        } catch (Exception e) {
            throw e;
        }
    }

}
