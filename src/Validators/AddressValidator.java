package Validators;


import Utils.Constant;
import Utils.CustomException;


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
