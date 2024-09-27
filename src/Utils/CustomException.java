/*
*********************************************************************************************************
 *  @Java Class Name :   CustomException
 *  @Author         :   Manish Kripalani (Manish.kripalani@antrazal.com)
 *  @Company        :   Antrazal
 *  @Date            :   24-09-2024
 *  @Description     :   This class represents a custom exception that extends the Exception class.
 *                       It provides a mechanism to throw and catch specific exceptions related to the
 *                       application logic. This allows for better error handling and more informative
 *                       error messages.
 *******************************************************************************************************
 *  AWC ID     Developer                                             	  	TITLE  
 *  1633      <Manish Kripalani>(manish.kripalani@antrazal.com)      JAVA ASSIGNMENT
********************************************************************************************************
*/

package Utils;

public class CustomException extends Exception {
    /*
     *********************************************************
     * @Method Name : CustomException
     * @Author : Your Name (your.email@example.com)
     * @Company : Your Company
     * @Date : 24-09-2024
     * @Description : Constructor for the CustomException class that initializes the exception message.
     * @param : String msg - The message to be associated with the exception
     *********************************************************
     */
    public CustomException(String msg) {
        super(msg); // Call the superclass constructor to set the exception message
    }
}
