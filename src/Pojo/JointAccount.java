/*
*********************************************************************************************************
 *  @Java Class Name :   JointAccount
 *  @Author          :   Manish Kripalani (Manish.kripalani@antrazal.com)
 *  @Company         :   Antrazal
 *  @Date            :   24-09-2024
 *  @Description     :   This class represents a JointAccount entity, encapsulating the details
 *                       such as email, branch name, PAN card number, account number, PIN, and 
 *                       account balance amount. It provides methods to get and set these attributes
 *                       and a method to return a string representation of the JointAccount object.
 *********************************************************************************************************
 */

 package Pojo;

 public class JointAccount {
     private String email;         // The email associated with the account
     private String branchName;    // The name of the branch where the account is held
     private String pancard;       // The PAN card number associated with the account
     private String accountNumber;  // The account number
     private Integer pin;          // The PIN for the account
     private Integer amount;       // The balance amount in the account
 
     /*
      *********************************************************
      *  @Constructor     :   JointAccount
      *  @Author          :   Manish Kripalani (Manish.kripalani@antrazal.com)
      *  @Company         :   Antrazal
      *  @Description     :   Constructor to initialize the JointAccount object with email, branch name,
      *                       PAN card number, account number, PIN, and amount.
      *  @param           :   email (String) - The email associated with the account
      *                      branchName (String) - The branch name where the account is held
      *                      pancard (String) - The PAN card number
      *                      accountNumber (String) - The account number
      *                      pin (Integer) - The PIN for the account
      *                      amount (Integer) - The balance amount in the account
      *********************************************************
      */
     public JointAccount(String email, String branchName, String pancard, String accountNumber, Integer pin, Integer amount) {
         this.email = email;
         this.branchName = branchName;
         this.pancard = pancard;
         this.accountNumber = accountNumber;
         this.pin = pin;
         this.amount = amount;
     }
 
     /*
      *********************************************************
      *  @Method Name     :   getEmail
      *  @Author          :   Manish Kripalani (Manish.kripalani@antrazal.com)
      *  @Company         :   Antrazal
      *  @Description     :   Getter method to retrieve the email associated with the account.
      *  @return          :   (String) - The email of the account
      *********************************************************
      */
     public String getEmail() {
         return email;
     }
 
     /*
      *********************************************************
      *  @Method Name     :   setEmail
      *  @Author          :   Manish Kripalani (Manish.kripalani@antrazal.com)
      *  @Company         :   Antrazal
      *  @Description     :   Setter method to set the email associated with the account.
      *  @param           :   email (String) - The email to be set for the account
      *  @return          :   void
      *********************************************************
      */
     public void setEmail(String email) {
         this.email = email;
     }
 
     /*
      *********************************************************
      *  @Method Name     :   getBranchName
      *  @Author          :   Manish Kripalani (Manish.kripalani@antrazal.com)
      *  @Company         :   Antrazal
      *  @Description     :   Getter method to retrieve the branch name where the account is held.
      *  @return          :   (String) - The branch name of the account
      *********************************************************
      */
     public String getBranchName() {
         return branchName;
     }
 
     /*
      *********************************************************
      *  @Method Name     :   setBranchName
      *  @Author          :   Manish Kripalani (Manish.kripalani@antrazal.com)
      *  @Company         :   Antrazal
      *  @Description     :   Setter method to set the branch name where the account is held.
      *  @param           :   branchName (String) - The branch name to be set for the account
      *  @return          :   void
      *********************************************************
      */
     public void setBranchName(String branchName) {
         this.branchName = branchName;
     }
 
     /*
      *********************************************************
      *  @Method Name     :   getPancard
      *  @Author          :   Manish Kripalani (Manish.kripalani@antrazal.com)
      *  @Company         :   Antrazal
      *  @Description     :   Getter method to retrieve the PAN card number associated with the account.
      *  @return          :   (String) - The PAN card number of the account
      *********************************************************
      */
     public String getPancard() {
         return pancard;
     }
 
     /*
      *********************************************************
      *  @Method Name     :   setPancard
      *  @Author          :   Manish Kripalani (Manish.kripalani@antrazal.com)
      *  @Company         :   Antrazal
      *  @Description     :   Setter method to set the PAN card number associated with the account.
      *  @param           :   pancard (String) - The PAN card number to be set for the account
      *  @return          :   void
      *********************************************************
      */
     public void setPancard(String pancard) {
         this.pancard = pancard;
     }
 
     /*
      *********************************************************
      *  @Method Name     :   getAccountNumber
      *  @Author          :   Manish Kripalani (Manish.kripalani@antrazal.com)
      *  @Company         :   Antrazal
      *  @Description     :   Getter method to retrieve the account number.
      *  @return          :   (String) - The account number
      *********************************************************
      */
     public String getAccountNumber() {
         return accountNumber;
     }
 
     /*
      *********************************************************
      *  @Method Name     :   setAccountNumber
      *  @Author          :   Manish Kripalani (Manish.kripalani@antrazal.com)
      *  @Company         :   Antrazal
      *  @Description     :   Setter method to set the account number.
      *  @param           :   accountNumber (String) - The account number to be set for the account
      *  @return          :   void
      *********************************************************
      */
     public void setAccountNumber(String accountNumber) {
         this.accountNumber = accountNumber;
     }
 
     /*
      *********************************************************
      *  @Method Name     :   getPin
      *  @Author          :   Manish Kripalani (Manish.kripalani@antrazal.com)
      *  @Company         :   Antrazal
      *  @Description     :   Getter method to retrieve the PIN for the account.
      *  @return          :   (Integer) - The PIN for the account
      *********************************************************
      */
     public Integer getPin() {
         return pin;
     }
 
     /*
      *********************************************************
      *  @Method Name     :   setPin
      *  @Author          :   Manish Kripalani (Manish.kripalani@antrazal.com)
      *  @Company         :   Antrazal
      *  @Description     :   Setter method to set the PIN for the account.
      *  @param           :   pin (Integer) - The PIN to be set for the account
      *  @return          :   void
      *********************************************************
      */
     public void setPin(Integer pin) {
         this.pin = pin;
     }
 
     /*
      *********************************************************
      *  @Method Name     :   getAmount
      *  @Author          :   Manish Kripalani (Manish.kripalani@antrazal.com)
      *  @Company         :   Antrazal
      *  @Description     :   Getter method to retrieve the balance amount in the account.
      *  @return          :   (Integer) - The balance amount of the account
      *********************************************************
      */
     public Integer getAmount() {
         return amount;
     }
 
     /*
      *********************************************************
      *  @Method Name     :   setAmount
      *  @Author          :   Manish Kripalani (Manish.kripalani@antrazal.com)
      *  @Company         :   Antrazal
      *  @Description     :   Setter method to set the balance amount in the account.
      *  @param           :   amount (Integer) - The amount to be set for the account balance
      *  @return          :   void
      *********************************************************
      */
     public void setAmount(Integer amount) {
         this.amount = amount;
     }
 
     /*
      *********************************************************
      *  @Method Name     :   toString
      *  @Author          :   Manish Kripalani (Manish.kripalani@antrazal.com)
      *  @Company         :   Antrazal
      *  @Description     :   Override of the toString method to provide a string representation 
      *                      of the JointAccount object, including email, branch name, PAN card, 
      *                      account number, PIN, and amount.
      *  @return          :   (String) - String representation of the JointAccount object
      *********************************************************
      */
     @Override
     public String toString() {
         return "JointAccount [email=" + email + ", branchName=" + branchName + ", pancard=" + pancard
                 + ", accountNumber=" + accountNumber + ", pin=" + pin + ", amount=" + amount + "]";
     }
 }
 