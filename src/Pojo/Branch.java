/*
*********************************************************************************************************
 *  @Java Class Name :   Branch
 *  @Author          :   Manish Kripalani (Manish.kripalani@antrazal.com)
 *  @Company         :   Antrazal
 *  @Date            :   24-09-2024
 *  @Description     :   This class represents a Branch entity with attributes such as name, city, 
 *                       and address. It provides methods to get and set these attributes and 
 *                       a method to return a string representation of the Branch object.
 *******************************************************************************************************
 *  AWC ID     Developer                                             	  	TITLE  
 *  1633      <Manish Kripalani>(manish.kripalani@antrazal.com)      JAVA ASSIGNMENT
********************************************************************************************************
*/

package Pojo;

public class Branch {
    private String name; // The name of the branch
    private String city; // The city where the branch is located
    private String address; // The address of the branch

    /*
     *********************************************************
     * @Constructor : Branch
     * @Author : Manish Kripalani (Manish.kripalani@antrazal.com)
     * @Company : Antrazal
     * @Description : Constructor to initialize the Branch object with name, city, and address.
     * @param : name (String) - The name of the branch
     *          city (String) - The city where the branch is located
     *          address (String) - The address of the branch
     *********************************************************
     */
    public Branch(String name, String city, String address) {
        this.name = name;
        this.city = city;
        this.address = address;
    }

    /*
     *********************************************************
     * @Method Name : getName
     * @Author : Manish Kripalani (Manish.kripalani@antrazal.com)
     * @Company : Antrazal
     * @Description : Getter method to retrieve the name of the branch.
     * @return : (String) - The name of the branch
     *********************************************************
     */
    public String getName() {
        return name;
    }

    /*
     *********************************************************
     * @Method Name : setName
     * @Author : Manish Kripalani (Manish.kripalani@antrazal.com)
     * @Company : Antrazal
     * @Description : Setter method to set the name of the branch.
     * @param : name (String) - The name to be set for the branch
     * @return : void
     *********************************************************
     */
    public void setName(String name) {
        this.name = name;
    }

    /*
     *********************************************************
     * @Method Name : getCity
     * @Author : Manish Kripalani (Manish.kripalani@antrazal.com)
     * @Company : Antrazal
     * @Description : Getter method to retrieve the city where the branch is located.
     * @return : (String) - The city of the branch
     *********************************************************
     */
    public String getCity() {
        return city;
    }

    /*
     *********************************************************
     * @Method Name : setCity
     * @Author : Manish Kripalani (Manish.kripalani@antrazal.com)
     * @Company : Antrazal
     * @Description : Setter method to set the city where the branch is located.
     * @param : city (String) - The city to be set for the branch
     * @return : void
     *********************************************************
     */
    public void setCity(String city) {
        this.city = city;
    }

    /*
     *********************************************************
     * @Method Name : getAddress
     * @Author : Manish Kripalani (Manish.kripalani@antrazal.com)
     * @Company : Antrazal
     * @Description : Getter method to retrieve the address of the branch.
     * @return : (String) - The address of the branch
     *********************************************************
     */
    public String getAddress() {
        return address;
    }

    /*
     *********************************************************
     * @Method Name : setAddress
     * @Author : Manish Kripalani (Manish.kripalani@antrazal.com)
     * @Company : Antrazal
     * @Description : Setter method to set the address of the branch.
     * @param : address (String) - The address to be set for the branch
     * @return : void
     *********************************************************
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /*
     *********************************************************
     * @Method Name : toString
     * @Author : Manish Kripalani (Manish.kripalani@antrazal.com)
     * @Company : Antrazal
     * @Description : Override of the toString method to provide a string representation of the Branch object, including name, city, and address.
     * @return : (String) - String representation of the Branch object
     *********************************************************
     */
    @Override
    public String toString() {
        return "Branch [name=" + name + ", city=" + city + ", address=" + address + "]";
    }
}
