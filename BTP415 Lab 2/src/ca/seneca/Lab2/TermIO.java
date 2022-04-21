package ca.seneca.Lab2;

import java.util.ArrayList;

/**
 * Handles printing output to the terminal, displays java classes with formatted output.
 * Utility class, cannot be instantiated.
 *
 * @version 1.0
 * @since 9/Feb/2022
 * @see ca.seneca.Lab2.Account
 * @see ca.seneca.Lab2.TransactionRecord
 */
public class TermIO {
    /**
     * Prints account details in neat format to terminal
     *
     * @param accs List of accounts to display
     */
    public static void printAccToScreen(ArrayList<Account> accs) {

        System.out.printf("%-10s%-18s%-10s%n--------------------------------------%n", "Acc Num", "Name", "Balance");
        for(Account acc : accs){
            System.out.printf("%-10s%-18s%-10.2f%n", acc.getAccountNum(), acc.getFirstName() + " " + acc.getLastName(), acc.getBalance());
        }
        System.out.println("--------------------------------------\n");
    }

    /**
     * Prints transaction details in neat format to terminal
     *
     * @param trans List of transactions to display
     */
    public static void printTranToScreen(ArrayList<TransactionRecord> trans) {
        System.out.printf("%-10s%-10s%n--------------------%n", "Acc Num", "Total");
        for(TransactionRecord tran : trans){
            System.out.printf("%-10s%-10.2f%n", tran.getAccNum(), tran.getTransTotal());
        }
        System.out.println("--------------------\n");
    }
}
