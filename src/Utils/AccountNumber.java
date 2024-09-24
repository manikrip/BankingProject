/*
*********************************************************************************************************
 *  @Java Class Name :   AccountNumber
 *  @Author          :   Manish Kripalani (Manish.kripalani@antrazal.com)
 *  @Company         :   Antrazal
 *  @Date            :   17-09-2024
 *  @Description     :   This class contains a method to generate a random 8-letter string, which can be 
 *                       used as a unique identifier for account numbers. The generated string consists of 
 *                       both uppercase and lowercase letters.
*********************************************************************************************************
*/

package Utils;

import java.util.Random;

/*
 *********************************************************
 *  @Method Name    :   generateRandomString
 *  @Author         :   Manish Kripalani (Manish.kripalani@antrazal.com)
 *  @Company        :   Antrazal
 *  @Description    :   This method generates an 8-letter random string using both uppercase and lowercase
 *                      alphabetic characters. It utilizes a Random object to select characters from the
 *                      defined character set and constructs the random string.
 *  @return         :   String - Randomly generated 8-letter string
 *********************************************************
 */
public class AccountNumber {
    
    public static String generateRandomString() {
        // Define characters to use (lowercase, uppercase)
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder randomString = new StringBuilder();
        Random random = new Random();

        // Generate 8 random characters
        for (int i = 0; i < 8; i++) {
            int index = random.nextInt(characters.length());
            randomString.append(characters.charAt(index));
        }

        return randomString.toString();
    }
}
