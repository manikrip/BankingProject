package Validators;
import java.util.*;
public class AddressValidator implements Validator{
    public String string ;
    public String msg;
    public AddressValidator(String string, String msg) {
        this.string=string;
        this.msg = msg;
    }


    @Override
    public String Validator() {
         // Regular expression that allows letters, numbers, spaces, commas, and periods
         String addressPattern = "^[a-zA-Z0-9\\s,\\.]+$";  
         Scanner scanner = new Scanner(System.in);
 
         // Loop to keep asking for address until it's valid
         while (!string.matches(addressPattern)) {
             System.out.print("Enter a address " +msg);
             System.out.print("Re-enter your address: ");
             string = scanner.nextLine();
         }
 
     
         return string;
    }



  
}
