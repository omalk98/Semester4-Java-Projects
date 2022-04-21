package sdds.lab1.task1;

/**
 * The <b>Encrypt</b> class Encrypts a raw String of Data.
 * It does not have an explicit constructor.
 * It is a utility class which simply Encrypts a String of data passed into
 * its encrypt() method and returns the Encrypted result.
 * This class also inherits the shuffle functionality from its Superclass
 *
 * @author Omar Hussein
 * @version 1.0
 * @since 26/01/2022
 * @see sdds.lab1.task1.Cryptor
 * @see sdds.lab1.task1.IOHandler
 */
public class Encrypt extends Cryptor
{
    /**
     * The <b>encrypt</b> method will accept a String as input and Encrypt it using its private methods.
     * It receives a string of any length and encrypts it in chucks of 4 characters at a time and returns the result.
     *
     * @param input Raw String to be Encrypted
     * @return Encrypted String
     */
    public static String encrypt(String input)
    {
        input = parseIntArray(shuffle(hash(parseString(input))));
        return input;
    }

    /**
     * The <b>hash</b> method adds m_hash to each element in the input Array then gets the remainder of the division by 10.
     *
     * @param unhashed Raw Array of Integers
     * @return Hashed Array
     */
    private static int[] hash(int[] unhashed)
    {
        for(int i = 0; i < unhashed.length; ++i)
            unhashed[i] = (unhashed[i] + m_hash) % m_base;

        return unhashed;
    }
}
