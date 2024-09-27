/*
********************************************************************************************************
 *  @Java Class Name :   Employee
 *  @Author          :   Manish Kripalani (Manish.kripalani@antrazal.com)
 *  @Company         :   Antrazal
 *  @Date            :   17-09-2024
 *  @Description     :   This class represents an Employee object, which contains information such as 
 *                       designation, branch name, personal details, and credentials of the employee.
 *******************************************************************************************************
 *  AWC ID     Developer                                             	  	TITLE  
 *  1633      <Manish Kripalani>(manish.kripalani@antrazal.com)      JAVA ASSIGNMENT
********************************************************************************************************
*/
package Pojo;

public class Employee {
    private String designation; // Designation of the employee
    private String branchName; // Branch name where the employee works
    private String name; // Name of the employee
    private String email; // Email of the employee
    private String username; // Username of the employee
    private String password; // Password of the employee

    /*
     *********************************************************
     * @Constructor Name : Employee
     * @Author : Manish Kripalani (Manish.kripalani@antrazal.com)
     * @Company : Antrazal
     * @Description : Constructs an Employee object with the provided attributes.
     * @param : designation (String) - Designation of the employee
     *          branchName (String) - Branch name where the employee works
     *          name (String) - Name of the employee
     *          email (String) - Email of the employee
     *          username (String) - Username of the employee
     *          password (String) - Password of the employee
     * @return : void
     *********************************************************
     */
    public Employee(String designation, String branchName, String name, String email, String username,
            String password) {
        this.designation = designation;
        this.branchName = branchName;
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    // Getters and Setters

    public String getBranchName() {
        return branchName; // Returns the branch name
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName; // Sets the branch name
    }

    public String getName() {
        return name; // Returns the name
    }

    public void setName(String name) {
        this.name = name; // Sets the name
    }

    public String getEmail() {
        return email; // Returns the email
    }

    public void setEmail(String email) {
        this.email = email; // Sets the email
    }

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

    public String getDesignation() {
        return designation; // Returns the designation
    }

    public void setDesignation(String designation) {
        this.designation = designation; // Sets the designation
    }

    /*
     *********************************************************
     * @Method Name : toString
     * @Author : Manish Kripalani (Manish.kripalani@antrazal.com)
     * @Company : Antrazal
     * @Description : Returns a string representation of the Employee object, displaying all its attributes.
     * @return : String - String representation of the Employee object
     *********************************************************
     */
    @Override
    public String toString() {
        return "Employee [designation=" + designation + ", branchName=" + branchName + ", name=" + name + ", email="
                + email + ", username=" + username + ", password=" + password + "]"; // Formats the string output
    }
}
