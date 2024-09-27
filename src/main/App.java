/*
*********************************************************************************************************
 *  @Java Class Name :   App
 *  @Author          :   Manish Kripalani (Manish.kripalani@antrazal.com)
 *  @Company         :   Antrazal
 *  @Date            :   24-09-2024
 *  @Description     :   This class serves as the entry point for the application. The main method 
 *                       calls the viewDatabase() method from the Databaseview class to initiate the 
 *                       database view functionality.
 *******************************************************************************************************
 *  AWC ID     Developer                                             	  	TITLE  
 *  1633      <Manish Kripalani>(manish.kripalani@antrazal.com)      JAVA ASSIGNMENT
********************************************************************************************************
*/

package main;

import view.Databaseview;

/*
 *********************************************************
 *  @Method Name    :   main
 *  @Author         :   Manish Kripalani (Manish.kripalani@antrazal.com)
 *  @Company        :   Antrazal
 *  @Description    :   This is the main method that serves as the entry point of the application. 
 *                      It invokes the viewDatabase method from the Databaseview class to display the 
 *                      database view options.
 *  @param          :   args (String[]) - Command line arguments passed to the program (not used in this case).
 *  @return         :   void
 *********************************************************
 */
public class App {
    public static void main(String[] args) {
        Databaseview.viewDatabase();
    }
}
