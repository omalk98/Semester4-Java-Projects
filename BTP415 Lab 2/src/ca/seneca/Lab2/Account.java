package ca.seneca.Lab2;

import java.io.Serializable;

/**
 * Defines the state and functionality for a common account within the program.
 * Contains an account number, first and last name, and a total account balance.
 * Can be serialized into Binary format.
 *
 * @version 1.1
 * @since 9/Feb/2022
 * @see java.io.Serializable
 * @see ca.seneca.Lab2.TransactionRecord
 */
public class Account implements Serializable {
    /**
     * Unique account number
     */
    private int accountNum = 0;
    /**
     * Current account balance
     */
    private double balance = 0.0d;
    /**
     * Customer first name
     */
    private String firstName = "";
    /**
     * Customer last name
     */
    private String lastName = "";

    /**
     * Initializes all values to empty or 0
     */
    public Account() {
        this(0, 0.0, "", "");
    }

    /**
     * Accepts account number, initial balance, first and last name
     *
     * @param accountNum Customer account number
     * @param balance Customer initial balance
     * @param firstName Customer first name
     * @param lastName Customer last name
     */
    public Account(int accountNum, double balance, String firstName, String lastName) {
        setAccountNum(accountNum);
       addBalance(balance);
       setFirstName(firstName);
        setLastName(lastName);
    }

    /**
     * Get Customer account number
     *
     * @return Account number
     */
    public int getAccountNum() {
        return accountNum;
    }

    /**
     * Set Customer unique account number
     *
     * @param accountNum Account number
     */
    public void setAccountNum(int accountNum) {
        this.accountNum = accountNum;
    }

    /**
     * Get current customer balance
     *
     * @return Current balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Add/Subtract specified amount from account balance
     *
     * @param balance Value to add/subtract
     */
    public void addBalance(double balance) {
        this.balance += balance;
    }

    /**
     * Get Customer first name
     *
     * @return First name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set customer first name
     *
     * @param firstName First name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Get Customer last name
     *
     * @return Last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Set Customer last name
     *
     * @param lastName Last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
