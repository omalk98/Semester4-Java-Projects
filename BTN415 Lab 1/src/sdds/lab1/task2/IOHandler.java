package sdds.lab1.task2;

import java.util.Scanner;

/**
 * The <b>IOHandler</b> class is a utility class which handles the IO needed for the Craps Tester Class class
 * It does not have an explicit constructor.
 *
 * @author Omar Hussein
 * @version 1.0
 * @since 26/01/2022
 */
public class IOHandler {

    /**
     * Handles input for wager input, warns for invalid input
     *
     * @return The number entered
     */
    public static double getDouble()
    {
        double wager = 0.00d;
        Scanner scan = new Scanner(System.in);

        try
        {
            wager = scan.nextDouble();
        }
        catch (Exception e)
        {
            System.out.println("Invalid input.");
        }
        if (wager < 0.00d)
        {
            wager = 0.00d;
            System.out.println("Invalid input.");
        }

        return wager;
    }

    /**
     * Handles user input to interact with game options
     *
     * @return Input String
     */
    public static String getString()
    {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        return input;
    }

    /**
     * Generates a random string of chatter to the console
     */
    public static void chatter()
    {
        String[] chat = {
                "Oh, you’re going for broke, huh?\n",
                "Aw c’mon, take a chance!\n",
                "You’re up big. Now’s the time to cash in your chips!\n",
                "You're on a roll! Keep it going!\n",
                "Throw in a little more next time?\n",
                "Check your balance, good to keep an eye!\n",
                "Hit that roll button harder!\n",
                "Tell your friends to grab the snacks!\n"
        };

        System.out.println(chat[(int)(Math.random() * chat.length)]);
    }
}
