/*
*********************************************************************************************************
 *  @Java Class Name :   TakingInput
 *  @Author         :   Manish Kripalani (Manish.kripalani@antrazal.com)
 *  @Company        :   Antrazal
 *  @Date            :   24-09-2024
 *  @Description     :   This class provides a utility for taking user input using a Scanner instance.
 *                       It allows for easy retrieval of the Scanner for reading input throughout the application.
 *******************************************************************************************************
 *  AWC ID     Developer                                             	  	TITLE  
 *  1633      <Manish Kripalani>(manish.kripalani@antrazal.com)      JAVA ASSIGNMENT
********************************************************************************************************
*/


package Utils;

import java.util.Scanner; // Importing Scanner for user input

/*
 *********************************************************
 *  @Method Name    :   input
 *  @Author         :   Manish Kripalani (Manish.kripalani@antrazal.com)
 *  @Company        :   Antrazal
 *  @Description    :   This method returns a static Scanner instance for reading user input.
 *  @return         :   Scanner - Scanner instance for user input
 *********************************************************
 */
public class TakingInput {
  public static Scanner input() {
    Scanner scanner = new Scanner(System.in);
    return scanner;
  }

}
