package Validators;
/*
*********************************************************************************************************
 *  @Java Class Name :   AddressValidator
 *  @Author          :   Manish Kripalani (Manish.kripalani@antrazal.com)
 *  @Company         :   Antrazal
 *  @Date            :   17-09-2024
 *  @Description     :   This class provides functionality to validate  addresses. It ensures that
 *                       the provided  address matches a standard  format using a regex pattern.
 *******************************************************************************************************
 *  AWC ID     Developer                                             	  	TITLE  
 *  1633      <Manish Kripalani>(manish.kripalani@antrazal.com)      JAVA ASSIGNMENT
********************************************************************************************************
*/
import Utils.Constant;
import Utils.CustomException;

/*
 *********************************************************
 *  @Method Name    :   validateEmail
 *  @Author         :   Manish Kripalani (Manish.kripalani@antrazal.com)
 *  @Company        :   Antrazal
 *  @Description    :   This method prompts the user to enter a valid  address. It validates the email
 *                      against a predefined regex pattern and keeps prompting the user until a valid email
 *                      is provided.
 *  @param          :   String address - Initial  address input by the user
 *  @return         :   String - Valid  address
 *********************************************************
 */
public class AddressValidator implements Validator {
    public String string;
    public String msg;

    public AddressValidator(String string, String msg) {
        this.string = string;
        this.msg = msg;
    }

    @Override
    public String Validator() throws CustomException {
        // Regular expression that allows letters, numbers, spaces, commas, and periods
        String addressPattern = "^[a-zA-Z0-9\\s,\\.]+$";
        try {
            if (!string.matches(addressPattern)) {
                throw new CustomException(Constant.ADDRESSName);
            }

        } catch (Exception e) {
            throw e;
        }

        return string;
    }

}
