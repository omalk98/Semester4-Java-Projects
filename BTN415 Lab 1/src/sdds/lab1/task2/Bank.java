package sdds.lab1.task2;

/**
 * The <b>Bank</b> class is a utility class which handles the Player balance and logic of winning and losing
 * It does not have an explicit constructor.
 * Also handles wager logic, prevents user from entering values over the current balance, and prevents invalid input
 *
 * @author Omar Hussein
 * @version 1.0
 * @since 26/01/2022
 * @see sdds.lab1.task2.IOHandler
 */
public class Bank {
    /**
     * Player current balance, starts at 1000.00
     */
    private static double m_balance = 1000.00d;
    /**
     * The wager the player enters
     */
    private static double m_wager = 0.00d;

    /**
     * Requests the wager from user input
     * Sets the wager variable to the wager entered, or 0 if invalid input
     *
     * @return The wager entered, = 0 if the input is invalid
     */
    public static double getWager()
    {
        System.out.print("Enter a Wager: ");
        double wager = IOHandler.getDouble();
        m_wager = (checkBalance(wager)) ? wager : 0.00d;
        return m_wager;
    }

    /**
     * Add the equivalent of the wager to the player balance
     */
    public static void naturals()
    {
        System.out.println("Congratulations, You win!");
        m_balance += m_wager;
    }

    /**
     * Subtracts the equivalent of the wager to the player balance
     */
    public static void craps()
    {
        System.out.println("Craps, You lose, Better Luck Next Time!");
        m_balance -= m_wager;
    }

    /**
     * Returns player current balance
     *
     * @return Current balance
     */
    public static double balance()
    {
        return m_balance;
    }

    /**
     * Checks the wager against the current balance
     * returns true if valid wager, i.e: wager is less than the balance
     *
     * @param wager The wager entered
     * @return Is wager valid
     */
    private static boolean checkBalance(double wager)
    {
        return m_balance >= wager;
    }
}
