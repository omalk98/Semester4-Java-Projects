package ca.seneca.Lab2;

import java.util.ArrayList;

/**
 * Tester class, wraps all functionality and calls appropriate functions for data handling
 *
 * <ul>
 * <li>Workshop 2</li>
 * <li>Course: BTN415</li>
 * <li>Last Name: Hussein</li>
 * <li>First Name: Omar</li>
 * <li>ID: 118073204</li>
 * <li>Section: NBB</li>
 * <li>This assignment represents my own work in accordance with Seneca Academic Policy.</li>
 * <li>Signature OmarHussein</li>
 * <li>Date: 9/Feb/2022</li>
 * </ul>
 *
 * @author Omar Hussein
 * @version 1.1
 * @since 9/Feb/2022
 */
public class Test {
    /**
     * Starts main tester run
     *
     * @param args Not used
     */
    public static void main(String[] args) {
        CreateData.genBinary();

        ArrayList<Account> accounts = new ArrayList<>();
        ArrayList<TransactionRecord> transactions = new ArrayList<>();

        FileMatch.loadAccounts(accounts, "res/oldmast.bin");
        FileMatch.loadTransactions(transactions, "res/trans.bin");

        TermIO.printAccToScreen(accounts);
        TermIO.printTranToScreen(transactions);

        FileMatch.mergeTransactions(accounts, transactions);
        TermIO.printAccToScreen(accounts);

        FileMatch.printSerializedMaster(accounts, "res/newmast");
        CreateData.writeCSV(accounts, "res/newmast");
    }
}
