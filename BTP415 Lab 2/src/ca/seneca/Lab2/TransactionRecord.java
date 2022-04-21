package ca.seneca.Lab2;

import java.io.Serializable;

/**
 * Defines the state and functionality for a common transaction within the program.
 * Contains an account number and a transaction total.
 * Can be serialized into Binary format.
 *
 * @version 1.1
 * @since 9/Feb/2022
 * @see java.io.Serializable
 * @see ca.seneca.Lab2.Account
 */
public class TransactionRecord implements Serializable {
    /**
     * Account number tied to transaction
     */
    private int accNum;
    /**
     * Total transaction amount
     */
    private double transTotal = 0.0d;

    /**
     * Initializes all values to empty or 0
     */
    public TransactionRecord() {
        this(0, 0.0);
    }
    /**
     * Accepts account number and initial transaction total
     *
     * @param acc Account number
     * @param total Initial transaction total
     */
    public TransactionRecord(int acc, double total){
        setAccNum(acc);
        setTransTotal(total);
    }

    /**
     * Get current transaction total
     * @return Transaction total
     */
    public double getTransTotal() {
        return transTotal;
    }

    /**
     * Get Account number
     * @return Account number
     */
    public int getAccNum() {
        return accNum;
    }

    /**
     * Sets transaction account number
     * @param accNum Initializing account number
     */
    private void setAccNum(int accNum) {
        this.accNum = accNum;
    }

    /**
     * Get total Transaction Record amount
     * @param transTotal Value to be added
     */
    public void setTransTotal(double transTotal) {
        this.transTotal = transTotal;
    }

    /**
     * Compares the current Transaction account number to the incoming Account number
     * @param comp Account to compare
     * @return Are from same Account
     */
    public boolean compare(Account comp) {
        return this.accNum == comp.getAccountNum();
    }
}
