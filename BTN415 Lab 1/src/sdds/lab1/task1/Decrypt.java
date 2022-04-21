package sdds.lab1.task1;

/**
 * The <b>Decrypt</b> class Decrypts a String of data Encrypted by the <b>Encrypt</b> class.
 * It does not have an explicit constructor.
 * It is a utility class which simply Encrypts a string of data passed into
 * its Encrypt method and returns the Encrypted result.
 * This class also inherits the shuffle functionality from its Superclass
 *
 * @author Omar Hussein
 * @version 1.0
 * @since 26/01/2022
 * @see sdds.lab1.task1.Cryptor
 * @see sdds.lab1.task1.IOHandler
 */

public class Decrypt extends Cryptor
{
    /**
     * The <b>encrypt</b> method will accept a String as input and Decrypt it using its private methods.
     * It receives a string of any length and Decrypts it in chucks of 4 characters at a time and returns the result.
     *
     * @param input Encrypted String to be Decrypted
     * @return Dycrypted String
     */
    public static String decrypt(String input)
    {
        input = parseIntArray(shuffle(unhash(parseString(input))));

        return input;
    }

    /**
     * The <b>hash</b> method adds (m_hash - 10) to each element in the input Array then gets the remainder of the division by 10.
     *
     * @param hashed Hashed Array of Integers
     * @return Raw Array
     */
    private static int[] unhash(int[] hashed)
    {
        for(int i = 0; i < hashed.length; ++i)
            hashed[i] = (hashed[i] + (m_base - m_hash)) % m_base;

        return hashed;
    }
}
