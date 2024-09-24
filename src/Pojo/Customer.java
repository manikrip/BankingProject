/*
*********************************************************************************************************
 *  @Java Class Name :   Customer
 *  @Author          :   Manish Kripalani (Manish.kripalani@antrazal.com)
 *  @Company         :   Antrazal
 *  @Date            :   17-09-2024
 *  @Description     :   This class represents a Customer with attributes such as name, email, branch name, 
 *                       PAN card number, account number, status, PIN, and amount. It provides a constructor 
 *                       for initializing a Customer object, along with getter and setter methods for each 
 *                       attribute, and a toString method for displaying customer details.
 *********************************************************************************************************
 */

 package Pojo;

 public class Customer {
     private String name;
     private String email;
     private String branchName;
     private String pancard;
     private String accountNumber;
     private String isActive;
     private Integer pin;
     private Integer amount;
 
     /*
      *********************************************************
       *  @Constructor Name :   Customer
       *  @Author           :   Manish Kripalani (Manish.kripalani@antrazal.com)
       *  @Company          :   Antrazal
       *  @Description      :   Constructs a Customer object with the provided parameters.
       *  @param            :   name (String) - Customer's name
       *                      :   email (String) - Customer's email address
       *                      :   branchName (String) - Name of the branch
       *                      :   pancard (String) - Customer's PAN card number
       *                      :   accountNumber (String) - Customer's account number
       *                      :   isActive (String) - Status of the customer (active/inactive)
       *                      :   pin (Integer) - Customer's PIN
       *                      :   amount (Integer) - Amount associated with the customer
       *********************************************************
      */
     public Customer(String name, String email, String branchName, String pancard, String accountNumber, String isActive,
             Integer pin, Integer amount) {
         this.name = name;
         this.email = email;
         this.branchName = branchName;
         this.pancard = pancard;
         this.accountNumber = accountNumber;
         this.isActive = isActive;
         this.pin = pin;
         this.amount = amount;
     }
 
     public String getName() {
         return name;
     }
 
     public void setName(String name) {
         this.name = name;
     }
 
     public String getEmail() {
         return email;
     }
 
     public void setEmail(String email) {
         this.email = email;
     }
 
     public String getBranchName() {
         return branchName;
     }
 
     public void setBranchName(String branchName) {
         this.branchName = branchName;
     }
 
     public String getPancard() {
         return pancard;
     }
 
     public void setPancard(String pancard) {
         this.pancard = pancard;
     }
 
     public String getAccountNumber() {
         return accountNumber;
     }
 
     public void setAccountNumber(String accountNumber) {
         this.accountNumber = accountNumber;
     }
 
     public String getIsActive() {
         return isActive;
     }
 
     public void setIsActive(String isActive) {
         this.isActive = isActive;
     }
 
     public Integer getPin() {
         return pin;
     }
 
     public void setPin(Integer pin) {
         this.pin = pin;
     }
 
     public Integer getAmount() {
         return amount;
     }
 
     public void setAmount(Integer amount) {
         this.amount = amount;
     }
 
     @Override
     public String toString() {
         return "Customer [name=" + name + ", email=" + email + ", branchName=" + branchName + ", pancard=" + pancard
                 + ", accountNumber=" + accountNumber + ", isActive=" + isActive + ", pin=" + pin + ", amount=" + amount
                 + "]";
     }
 }
 