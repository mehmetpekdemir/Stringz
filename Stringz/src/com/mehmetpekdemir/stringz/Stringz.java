package com.mehmetpekdemir.stringz;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 *
 */
public final class Stringz {

	/**
	 * Private constructor.
	 * 
	 */
	private Stringz() {
		throw new AssertionError("Cannot be instantiated ! ");
	}

	/**
	 * Check string.
	 * 
	 * @param str
	 */
	private static void isEmpty(String str) {
		if (str == null || str.isBlank()) {
			throw new IllegalArgumentException();
		}
	}

	/**
	 * Counts duplicate characters from a given string.
	 * 
	 * @param str
	 * @return duplicate character
	 */
	public static Map<Character, Integer> countDuplicateCharacters(String str) {
		isEmpty(str);

		Map<Character, Integer> result = new HashMap<Character, Integer>();
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);

			result.compute(ch, (k, v) -> (v == null) ? 1 : ++v);
		}

		return result;
	}

	/**
	 * Returns the first non-repeated character from a given string.
	 * 
	 * @param str
	 * @return The first non-reapted character
	 */
	public static char firstNonRepeatedCharacter(String str) {
		isEmpty(str);

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);

			int count = 0;
			for (int j = 0; j < str.length(); j++) {
				if (ch == str.charAt(j) && i != j) {
					count++;
					break;
				}
			}

			if (count == 0) {
				return ch;
			}

		}

		return Character.MIN_VALUE;
	}

	/**
	 * Reverses words of a given string.
	 * 
	 * @param str
	 * @return reverse word
	 */
	public static String reverse(String str) {
		isEmpty(str);
		return new StringBuilder(str).reverse().toString();
	}

	/**
	 * Checks if the given string contains only digits.
	 * 
	 * @param str
	 * @return true = only digit , false = not only digit.
	 */
	public static boolean containsOnlyDigits(String str) {
		isEmpty(str);
		return str.matches("[0-9]+");
	}
}
