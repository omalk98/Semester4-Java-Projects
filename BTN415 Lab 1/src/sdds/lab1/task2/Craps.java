package sdds.lab1.task2;

/**
 * The <b>Craps</b> class is a game class which implements the simple game of craps.
 * It does not have an explicit constructor.
 * The <b>run</b> function will keep the game loop running until player busts,
 * or requests to quit
 *
 * @author Omar Hussein
 * @version 1.0
 * @since 26/01/2022
 * @see sdds.lab1.task2.Bank
 */
public class Craps
{
    /**
     * Established Point if the Player does not Roll one of the Craps special Numbers
     */
    private static int m_point = 0;

    /**
     * The main loop of the game
     * This method will setup a player balance, start the loop and handle the game IO
     */
    public static void run()
    {
        boolean keep_going = true, enter_wager = true;
        System.out.println("Welcome to Craps!");
        while(keep_going)
        {
            if(Bank.balance() == 0.00d)
            {
                System.out.println("Sorry, you Busted! Try again later. Goodbye!");
                keep_going = false;
                break;
            }
            if(enter_wager)
            {
                System.out.printf("You have $%.2f in your Balance.\n", Bank.balance());
                if (Bank.getWager() == 0.00d)
                {
                    System.out.println("Invalid input.");
                    continue;
                }
            }

            System.out.print("Press enter to roll, type [c] to change wager, [q] to quit: ");
            String check = IOHandler.getString();

            if(check.equals("[q]"))
            {
                System.out.println("Goodbye!");
                keep_going = false;
                break;
            }
            else if (check.equals("[c]")) {
                enter_wager = true;
                continue;
            }

            enter_wager = true;

            switch(checkDice(rollDice()))
            {
                case 0:
                    Bank.craps();
                    m_point = 0;
                    break;
                case 1:
                    Bank.naturals();
                    m_point = 0;
                    break;
                case 2:
                case 3:
                    enter_wager = false;
                    break;
            }

            IOHandler.chatter();
        }
    }

    /**
     * Generates 2 random numbers between (1-6)
     * simulating 2 die rolls, and returns the sum of the 2 die rolls.
     *
     * @return Sum of dice roll
     */
    private static int rollDice()
    {
        int dice1 = (int)(Math.random() * 5) + 1, dice2 = (int)(Math.random() * 5) + 1;

        System.out.println("You Rolled...");
        System.out.println(dice1 + " + " + dice2 + " = " + (dice1+dice2));

        return dice1 + dice2;
    }

    /**
     * Checks the sum of the dice roll and returns a status code for each condition.
     * <ul>
     *     <li>Code 0: fail (Craps)</li>
     *     <li>Code 1: win (Naturals)</li>
     *     <li>Code 2: Established Point</li>
     *     <li>Code 3: Keep Trying</li>
     * </ul>
     *
     * @param diceSum The sum of the Dice Roll
     * @return Status code
     */
    private static int checkDice(int diceSum)
    {

        if(diceSum == 12 || diceSum == 2 || diceSum == 3)
            return 0;
        else if(diceSum == 7 || diceSum == 11 || diceSum == m_point)
            return 1;
        else if(m_point == 0) {
            m_point = diceSum;
            System.out.println("Point (Established), set to: "+ m_point);
            return 2;
        }
        else return 3;
    }
}
