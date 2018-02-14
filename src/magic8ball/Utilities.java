package magic8ball;

/**
 * This class contains helper methods for the other classes to use.
 * 
 * @author LexusDrumgold
 *
 */
public class Utilities {

	/**
	 * Helper method thats takes a string for an argument and returns that string if
	 * it has length greater than 0. If the length is less than or equal to zero, an
	 * exception is thrown.
	 * 
	 * @param string
	 *            text to check
	 * @return String text to check
	 * @throws IllegalArgumentException
	 */
	static String validateString(String string) throws IllegalArgumentException {
		if (string.length() >= 0) {
			return string;
		} else {
			throw new IllegalArgumentException("Invalid input");
		}
	}


}
