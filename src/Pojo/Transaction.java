/*
*********************************************************************************************************
 *  @Java Class Name :   Transaction
 *  @Author          :   Manish Kripalani (Manish.kripalani@antrazal.com)
 *  @Company         :   Antrazal
 *  @Date            :   24-09-2024
 *  @Description     :   This class represents a financial transaction associated with a specific 
 *                       account. It encapsulates the details such as account number, transaction 
 *                       type, timestamp, and transaction amount. It provides methods to get and set 
 *                       these attributes, as well as a method to return a string representation 
 *                       of the Transaction object.
 *******************************************************************************************************
 *  AWC ID     Developer                                             	  	TITLE  
 *  1633      <Manish Kripalani>(manish.kripalani@antrazal.com)      JAVA ASSIGNMENT
********************************************************************************************************
*/

package Pojo;

import java.sql.Timestamp; // Corrected import for Timestamp to use java.sql.Timestamp

public class Transaction {
    private String accountNumber; // The account number associated with the transaction
    private String type; // The type of transaction (e.g., deposit, withdrawal)
    private Timestamp time; // The timestamp of when the transaction occurred
    private Integer amount; // The amount involved in the transaction

    /*
     *********************************************************
     * @Constructor : Transaction
     * @Author : Manish Kripalani (Manish.kripalani@antrazal.com)
     * @Company : Antrazal
     * @Description : Constructor to initialize the Transaction object with account number, type, timestamp, and amount.
     * @param : accountNumber (String) - The account number associated with the transaction
     *          type (String) - The type of transaction
     *          time (Timestamp) - The timestamp of the transaction
     *          amount (Integer) - The amount of the transaction
     *********************************************************
     */
    public Transaction(String accountNumber, String type, Timestamp time, Integer amount) {
        this.accountNumber = accountNumber;
        this.type = type;
        this.time = time;
        this.amount = amount;
    }

    /*
     *********************************************************
     * @Method Name : getAccountNumber
     * @Author : Manish Kripalani (Manish.kripalani@antrazal.com)
     * @Company : Antrazal
     * @Description : Getter method to retrieve the account number associated with the transaction.
     * @return : (String) - The account number of the transaction
     *********************************************************
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /*
     *********************************************************
     * @Method Name : setAccountNumber
     * @Author : Manish Kripalani (Manish.kripalani@antrazal.com)
     * @Company : Antrazal
     * @Description : Setter method to set the account number associated with the transaction.
     * @param : accountNumber (String) - The account number to be set for the transaction
     * @return : void
     *********************************************************
     */
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    /*
     *********************************************************
     * @Method Name : getType
     * @Author : Manish Kripalani (Manish.kripalani@antrazal.com)
     * @Company : Antrazal
     * @Description : Getter method to retrieve the type of transaction.
     * @return : (String) - The type of the transaction
     *********************************************************
     */
    public String getType() {
        return type;
    }

    /*
     *********************************************************
     * @Method Name : setType
     * @Author : Manish Kripalani (Manish.kripalani@antrazal.com)
     * @Company : Antrazal
     * @Description : Setter method to set the type of transaction.
     * @param : type (String) - The type of the transaction to be set
     * @return : void
     *********************************************************
     */
    public void setType(String type) {
        this.type = type;
    }

    /*
     *********************************************************
     * @Method Name : getTime
     * @Author : Manish Kripalani (Manish.kripalani@antrazal.com)
     * @Company : Antrazal
     * @Description : Getter method to retrieve the timestamp of the transaction.
     * @return : (Timestamp) - The timestamp of the transaction
     *********************************************************
     */
    public Timestamp getTime() {
        return time;
    }

    /*
     *********************************************************
     * @Method Name : setTime
     * @Author : Manish Kripalani (Manish.kripalani@antrazal.com)
     * @Company : Antrazal
     * @Description : Setter method to set the timestamp of the transaction.
     * @param : time (Timestamp) - The timestamp to be set for the transaction.
     * @return : void
     *********************************************************
     */
    public void setTime(Timestamp time) {
        this.time = time;
    }

    /*
     *********************************************************
     * @Method Name : getAmount
     * @Author : Manish Kripalani (Manish.kripalani@antrazal.com)
     * @Company : Antrazal
     * @Description : Getter method to retrieve the amount of the transaction.
     * @return : (Integer) - The amount involved in the transaction
     *********************************************************
     */
    public Integer getAmount() {
        return amount;
    }

    /*
     *********************************************************
     * @Method Name : setAmount
     * @Author : Manish Kripalani (Manish.kripalani@antrazal.com)
     * @Company : Antrazal
     * @Description : Setter method to set the amount of the transaction.
     * @param : amount (Integer) - The amount to be set for the transaction
     * @return : void
     *********************************************************
     */
    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    /*
     *********************************************************
     * @Method Name : toString
     * @Author : Manish Kripalani (Manish.kripalani@antrazal.com)
     * @Company : Antrazal
     * @Description : Override of the toString method to provide a string representation of the Transaction object, including account number, transaction type, timestamp, and amount.
     * @return : (String) - String representation of the Transaction object
     *********************************************************
     */
    @Override
    public String toString() {
        return "Transaction [accountNumber=" + accountNumber + ", type=" + type + ", time=" + time + ", amount="
                + amount + "]";
    }
}
