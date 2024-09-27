/*
********************************************************************************************************
 *  @Java Class Name :   Login
 *  @Author          :   Manish Kripalani (Manish.kripalani@antrazal.com)
 *  @Company         :   Antrazal
 *  @Date            :   17-09-2024
 *  @Description     :   This class represents a Login object, which contains information required for user
 *                       authentication, including username, password, and email.
 *******************************************************************************************************
 *  AWC ID     Developer                                             	  	TITLE  
 *  1633      <Manish Kripalani>(manish.kripalani@antrazal.com)      JAVA ASSIGNMENT
********************************************************************************************************
*/

package Pojo;

public class Login {
    private String username; // Username for the login
    private String password; // Password for the login
    private String email; // Email associated with the login

    /*
     *********************************************************
     * @Constructor Name : Login
     * @Author : Manish Kripalani (Manish.kripalani@antrazal.com)
     * @Company : Antrazal
     * @Description : Constructs a Login object with the provided attributes.
     * @param : username (String) - Username for the login
     *          password (String) - Password for the login
     *          email (String) - Email associated with the login
     * @return : void
     *********************************************************
     */
    public Login(String username, String password, String email) {
        this.username = username; // Set the username
        this.password = password; // Set the password
        this.email = email; // Set the email
    }

    // Getters and Setters

    public String getUsername() {
        return username; // Returns the username
    }

    public void setUsername(String username) {
        this.username = username; // Sets the username
    }

    public String getPassword() {
        return password; // Returns the password
    }

    public void setPassword(String password) {
        this.password = password; // Sets the password
    }

    public String getEmail() {
        return email; // Returns the email
    }

    public void setEmail(String email) {
        this.email = email; // Sets the email
    }

    /*
     *********************************************************
     * @Method Name : toString
     * @Author : Manish Kripalani (Manish.kripalani@antrazal.com)
     * @Company : Antrazal
     * @Description : Returns a string representation of the Login object, displaying all its attributes.
     * @return : String - String representation of the Login object
     *********************************************************
     */
    @Override
    public String toString() {
        return "Login [username=" + username + ", password=" + password + ", email=" + email + "]"; // Formats the
                                                                                                    // string output
    }
}
