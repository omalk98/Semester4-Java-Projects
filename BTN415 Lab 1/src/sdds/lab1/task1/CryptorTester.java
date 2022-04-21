package sdds.lab1.task1;

/**
 * The <b>CryptorTester</b> class is a tester class which tests the functionality of the Classes included in the Package.
 * It does not have an explicit constructor.
 * The <b>main</b> function will keep running until the user types <b><u>[q]</u></b>
 *
 * <ul>
 * <li>Workshop 1</li>
 * <li>Course: BTP400 - Semester 4</li>
 * <li>Last Name: Hussein</li>
 * <li>First Name: Omar</li>
 * <li>ID: 118073204</li>
 * <li>Section: NBB</li>
 * <li>This assignment represents my own work in accordance with Seneca Academic Policy.</li>
 * <li>ohussein2@myseneca.ca</li>
 * <li>Date: 26/01/2022</li>
 * </ul>
 *
 * @author Omar Hussein
 * @version 1.0
 * @since 26/01/2022
 * @see sdds.lab1.task1.Encrypt
 * @see sdds.lab1.task1.Decrypt
 */
public class CryptorTester {

    /**
     * The <b>main</b> method that tests the First Task
     *
     * @param args Unused
     */
    public static void main(String[] args)
    {
        boolean keep_going = true;
        String user_input = "";

        while (keep_going) {
            user_input = IOHandler.GetInput();

            keep_going = quitCheck(user_input);

            crypt(user_input, keep_going);
        }
    }

    /**
     * The <b>crypt</b> method calls the Encrypt and Decrypt classes and performs the main task
     * of String Encryption and Decryption.
     * Prints a meassge to the user when quitting.
     *
     * @param input User Input
     * @param ok Quit Status
     */
    public static void crypt(String input, boolean ok)
    {
        if(ok)
        {
            input = Encrypt.encrypt(input);
            IOHandler.SendOutput(input, 'e');

            input = Decrypt.decrypt(input);
            IOHandler.SendOutput(input, 'd');
            System.out.println();
        }
        else
            System.out.println("Goodbye!");
    }

    /**
     * The <b>quitCheck</b> method checks the user input to match if the user requested to quit the program.
     *
     * @param test User Input
     * @return Quit Status
     */
    public static boolean quitCheck(String test)
    {
        return !test.equals("[q]");
    }
}
