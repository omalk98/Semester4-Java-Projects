package ca.seneca.Lab2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Handles data generation and file creation for the program.
 * Deals with csv and bin fines.
 * Utility class, cannot be instantiated.
 *
 * @version 1.0
 * @since 9/Feb/2022
 * @see ca.seneca.Lab2.FileMatch
 */
public class CreateData {
    /**
     * Generate binary format files from original csv version
     */
    public static void genBinary() {
        readCSV("res/oldmast");
        readCSV("res/trans");
    }

    /**
     * Generate csv file for account list
     *
     * @param mastList List to be printed
     * @param filename Name of file no extension
     */
    public static void writeCSV(ArrayList<Account> mastList, String filename) {
        File f = new File(filename + ".csv");
        try(PrintWriter printer = new PrintWriter(f);)
        {
            for(Account acc : mastList)
                printer.printf("%d,%s %s,%.2f%n", acc.getAccountNum(), acc.getFirstName(), acc.getLastName(), acc.getBalance());
        }
        catch (FileNotFoundException e) {
            System.out.println("Encountered issues writing csv");
            e.printStackTrace();
        }
        FileMatch.writeToLog("Generated account csv file.");
    }

    /**
     * Read csv file and parse into Java object, then parse to binary file
     *
     * @param filename File to read no extension
     */
    private static void readCSV(String filename) {
        File f = new File(filename + ".csv");

        ArrayList<TransactionRecord> newTran = new ArrayList<>();
        ArrayList<Account> newAcc = new ArrayList<>();

        try (Scanner scan = new Scanner(f);) {
            while (scan.hasNextLine()) {
                String data = scan.nextLine();
                String parsed[] = data.split(",");

                if (parsed.length == 4) {
                    newAcc.add(new Account(Integer.parseInt(parsed[0]), Double.parseDouble(parsed[3]), parsed[1], parsed[2]));
                } else {
                    newTran.add(new TransactionRecord(Integer.parseInt(parsed[0]), Double.parseDouble(parsed[1])));
                }
            }

            if(newAcc.size() > 0)
                genAccBin(newAcc);
            if(newTran.size() > 0)
                genTransBin(newTran);
            newAcc.clear();
            newTran.clear();
        }
        catch (FileNotFoundException e) {
            System.out.println("File not Found!");
            e.printStackTrace();
        }

    }

    /**
     * Parses Java object transaction list into binary file
     *
     * @param transList List to be loaded
     */
    private static void genTransBin(ArrayList<TransactionRecord> transList) {
        FileMatch.printSerializedTransaction(transList, "res/trans");
    }

    /**
     * Parses Java object accounts list into binary file
     *
     * @param accList List to be loaded
     */
    private static void genAccBin(ArrayList<Account> accList) {
        FileMatch.printSerializedMaster(accList, "res/oldmast");
    }
}
