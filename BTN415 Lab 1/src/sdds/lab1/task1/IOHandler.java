package sdds.lab1.task1;

import java.util.Scanner;

/**
 * The <b>IOHandler</b> is a utility class which handles the IO needed for the Cryptor Tester Class.
 * It does not have an explicit constructor.
 *
 * @author Omar Hussein
 * @version 1.0
 * @since 26/01/2022
 */
public class IOHandler {
    /**
     * The <b>GetInput</b> method displays a message and requests user Input.
     *
     * @return User Input
     */
   public static String GetInput() {
        System.out.print("Enter a string to Encrypt, type [q] to quit: ");

        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        return input;
    }

    /**
     * The <b>SendOutput</b> method accepts a String and displays a message followed by the String received.
     *
     * @param output String to be displayed
     * @param mode 'e' for Encrypt, 'd' for Dycrypt
     */
    public static void SendOutput(String output, char mode) {
        System.out.print("The " + ((mode == 'e') ? "Encrypted" : "Decrypted") + " message is: ");
        System.out.println(output);
    }
}
