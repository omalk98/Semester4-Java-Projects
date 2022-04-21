package ca.seneca.Lab2;

import java.io.*;
import java.util.ArrayList;

/**
 * Defines common functionality to read Java Serialized files (binary).
 * Handles loading serialized classes into memory, writing Binary Serialized files, and writing to the log file.
 * Utility class, cannot be instantiated.
 *
 * @version 1.1
 * @since 9/Feb/2022
 * @see java.io.Serializable
 */
public class FileMatch {
    /**
     * Accepts an ArrayList of TransactionRecords and file name and loads the data from the file into the transaction array
     * @param list ArrayList to be loaded with data
     * @param filename Data file
     */
    public static void loadTransactions(ArrayList<TransactionRecord> list, String filename) {
        File f = new File(filename);
        try (FileInputStream fis = new FileInputStream(f);
             ObjectInputStream obj = new ObjectInputStream(fis);)
        {
            boolean keepGoing = true;
            while(keepGoing) {
                TransactionRecord newRec = (TransactionRecord) obj.readObject();
                if(newRec != null)
                    list.add(newRec);
                else
                    keepGoing = false;
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Can't Open File!");
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            System.out.println("Can't Read Object from File!");
            e.printStackTrace();
        }
        catch (EOFException e) {

        }
        catch (IOException e) {
            System.out.println("Can't Serialize File!");
            e.printStackTrace();
        }
        catch (Exception e) {
            System.out.println("Can't Finish Serializing!");
            e.printStackTrace();
        }
    }

    /**
     * Accepts an ArrayList of Accounts and file name and loads the data from the file into the account array
     * @param list ArrayList to be loaded with data
     * @param filename Data file
     */
    public static void loadAccounts(ArrayList<Account> list, String filename) {
        File f = new File(filename);
        try (FileInputStream fis = new FileInputStream(f);
             ObjectInputStream obj = new ObjectInputStream(fis);)
        {
            boolean keepGoing = true;
            while(keepGoing) {
                Account newAcc = (Account) obj.readObject();
                if(newAcc != null)
                    list.add(newAcc);
                else
                    keepGoing = false;
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Can't Open File!");
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            System.out.println("Can't Read Object from File!");
            e.printStackTrace();
        }
        catch (EOFException e) {

        }
        catch (IOException e) {
            System.out.println("Can't Serialize File!");
            e.printStackTrace();
        }
        catch (Exception e) {
            System.out.println("Can't Finish Serializing!");
            e.printStackTrace();
        }
    }

    /**
     * Writes a message in the log file
     * @param logEvent Message to be logged
     */
    public static void writeToLog(String logEvent) {
        File log = new File("res/log.txt");
        try (FileWriter logger = new FileWriter(log, true);
             PrintWriter printer = new PrintWriter(logger);)
        {
            printer.println(logEvent);
        }
        catch (IOException e) {
            System.out.println("Logfile had issues");
            e.printStackTrace();
        }
    }

    /**
     * Generates a new serialized master file in binary format
     * @param mastList List to be printed
     * @param filename target filename with no extension
     */
    public static void printSerializedMaster(ArrayList<Account> mastList, String filename) {
        File master = new File(filename + ".bin");
        try (FileOutputStream fos = new FileOutputStream(master);
             ObjectOutputStream obj = new ObjectOutputStream(fos);)
        {
            for(Account acc : mastList)
                obj.writeObject(acc);

            writeToLog("Generated account binary.");
        }
        catch (IOException e) {
            System.out.println("Encountered Issues Generating Binary File");
            e.printStackTrace();
        }
    }

    /**
     * Generates a new serialized transaction file in binary format
     * @param tranList List to be printed
     * @param filename target filename with no extension
     */
    public static void printSerializedTransaction(ArrayList<TransactionRecord> tranList, String filename) {
        File master = new File(filename + ".bin");
        try (FileOutputStream fos = new FileOutputStream(master);
             ObjectOutputStream obj = new ObjectOutputStream(fos);)
        {
            for(TransactionRecord trans : tranList)
                obj.writeObject(trans);

            writeToLog("Generated transaction binary.");
        }
        catch (IOException e) {
            System.out.println("Encountered Issues Generating Binary File");
            e.printStackTrace();
        }
    }

    /**
     * Merges master transaction list with new transactions and logs any unmatched records to the log file
     *
     * @param oldMast Original master list
     * @param trans Transactions list
     */
    public static void mergeTransactions(ArrayList<Account> oldMast, ArrayList<TransactionRecord> trans) {
        for(Account account : oldMast) {
            for(int i = 0; i < trans.size(); ++i) {
                if (trans.get(i).compare(account)) {
                    account.addBalance(trans.get(i).getTransTotal());
                    trans.remove(i--);
                }
            }
        }
        for(TransactionRecord transaction : trans)
            writeToLog("Unmatched transaction record for account number " + transaction.getAccNum());
    }
}
