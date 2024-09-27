/*
*********************************************************************************************************
 *  @Java Class Name :   Loan
 *  @Author          :   Manish Kripalani (Manish.kripalani@antrazal.com)
 *  @Company         :   Antrazal
 *  @Date            :   17-09-2024
 *  @Description     :   This class represents a Loan with attributes such as loan number, PAN card number, 
 *                       status, and loan amount. It provides a constructor for initializing a Loan object, 
 *                       along with getter and setter methods for each attribute, and a toString method for 
 *                       displaying loan details.
 *******************************************************************************************************
 *  AWC ID     Developer                                             	  	TITLE  
 *  1633      <Manish Kripalani>(manish.kripalani@antrazal.com)      JAVA ASSIGNMENT
********************************************************************************************************
*/

package Pojo;

public class Loan {
    private String loanNumber;
    private String panCard;
    private String status;
    private Integer loanAmount;

    /*
     *********************************************************
     * @Constructor Name : Loan
     * @Author : Manish Kripalani (Manish.kripalani@antrazal.com)
     * @Company : Antrazal
     * @Description : Constructs a Loan object with the provided parameters.
     * @param : loanNumber (String) - The loan number
     *          panCard (String) - The PAN card number associated with the loan
     *          status (String) - The current status of the loan
     *          loanAmount (Integer) - The amount of the loan
     *********************************************************
     */
    public Loan(String loanNumber, String panCard, String status, Integer loanAmount) {
        this.loanNumber = loanNumber;
        this.panCard = panCard;
        this.status = status;
        this.loanAmount = loanAmount;
    }

    public String getLoanNumber() {
        return loanNumber;
    }

    public void setLoanNumber(String loanNumber) {
        this.loanNumber = loanNumber;
    }

    public String getPanCard() {
        return panCard;
    }

    public void setPanCard(String panCard) {
        this.panCard = panCard;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(Integer loanAmount) {
        this.loanAmount = loanAmount;
    }

    @Override
    public String toString() {
        return "Loan [loanNumber=" + loanNumber + ", panCard=" + panCard + ", status=" + status + ", loanAmount="
                + loanAmount + "]";
    }
}
