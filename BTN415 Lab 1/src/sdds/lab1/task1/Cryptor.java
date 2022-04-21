package sdds.lab1.task1;

/**
 * The <b>Cryptor</b> class is a Superclass which handles Shuffling and Parsing functionality only.
 * It does not have an explicit constructor.
 * It is a utility Superclass which simply provides a shuffle and parse mechanism for its SubClasses
 *
 * @author Omar Hussein
 * @version 1.0
 * @since 26/01/2022
 */
public class Cryptor {
    /**
     * The number to be added as a hash
     */
    protected static int m_hash = 7;
    /**
     * The base of division, is constantly 10
     */
    protected static final int m_base = 10;

    /**
     * The <b>shuffle</b> method accepts an Integer Array and shuffles it according to the rule:
     * Every 4 Integers get shuffled by swapping the <i>first</i> Integer with the <i>third</i>,
     * and the <i>second</i> Integer with the <i>fourth</i> and returns the result.
     *
     * @param encrypted Partially Encrypted Integer Array
     * @return Shuffled Encrypted Integer Array
     */
    protected static int[] shuffle(int[] encrypted)
    {
        for(int i = 0; i < encrypted.length / 4; ++i)
        {
            int swap = encrypted[4 * i];
            encrypted[4 * i] = encrypted[4 * i + 2];
            encrypted[4 * i + 2] = swap;
            swap = encrypted[4 * i + 1];
            encrypted[4 * i + 1] = encrypted[4 * i + 3];
            encrypted[4 * i + 3] = swap;
        }
        return encrypted;
    }

    /**
     * The <b>parseString</b> method handles the input String and converts it into an Array of Integers,
     * and returns the Array generated from the String input.
     *
     * @param rawInput Raw String to be converted into an Integer Array
     * @return Integer Array from of String
     */
    protected static int[] parseString(String rawInput)
    {
        int[] parsed = new int[rawInput.length()];

        try
        {
            for(int i = 0; i < rawInput.length(); ++i)
                parsed[i] = Integer.parseInt(rawInput.substring(i, i+1));
        }
        catch (Exception e)
        {
            System.out.println("Error: Bad input");
        }

        return parsed;
    }

    /**
     * The <b>parseIntArray</b> method handles the conversion from an Integer Array to a String.
     * After the data is Encrypted/Decrypted and shuffled as an Integer Array in the <strong>iny[] parseString(String)</strong>
     * <strong>int[] shuffle(int[])</strong> methods it is converted back to string format in this method
     * and returned.
     *
     * @param rawArray Raw Integer Array to be converted into a String
     * @return String form of Integer Array
     */
    protected static String parseIntArray(int[] rawArray)
    {
        String parsed = "";
        for (int i = 0; i < rawArray.length; ++i) {
            parsed += rawArray[i];
        }
        return parsed;
    }
}
