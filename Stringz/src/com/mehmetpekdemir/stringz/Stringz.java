package com.mehmetpekdemir.stringz;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringJoiner;

import com.mehmetpekdemir.util.Pair;

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
	 * @throws IllegalArgumentException
	 */
	private static void isEmpty(String str) {
		if (str == null || str.isBlank() || str.isEmpty()) {
			throw new IllegalArgumentException();
		}
	}

	/**
	 * Check string[] args.
	 * 
	 * @param args
	 * @throws IllegalArgumentException
	 */
	private static void isEmpty(String... args) {
		if (args == null || args.length == 0) {
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

	/**
	 * Counts the number of vowels and consonants in a given string. in English
	 * there are 5 vowels : ( a , e , i , o , u ).
	 * 
	 * Also, note that languages can have a different number of vowels and
	 * consonants (e.g. ,in Turkish there are 8 vowels: a , e , ý , i , o , ö , u, ü
	 * 
	 * @param str
	 * @return vowels and consonants
	 */
	public static Pair<Integer, Integer> countVowelsAndConsonants(String str) {
		isEmpty(str);
		str = str.toLowerCase();

		final Set<Character> allWovels = new HashSet<Character>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

		int vowels = 0;
		int consonants = 0;
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (allWovels.contains(ch)) {
				vowels++;
			} else if ((ch >= 'a' && ch <= 'z')) {
				consonants++;
			}
		}

		return Pair.of(vowels, consonants);
	}

	/**
	 * Counts occurrences of a certain character in a given string.
	 * 
	 * @param str
	 * @param ch
	 * @return count
	 */
	public static long countOccurencesOfACertainCharacter(String str, char ch) {
		isEmpty(str);

		long count = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ch) {
				count++;
			}
		}
		return count;

		// return str.chars().filter(c -> c == ch).count(); // Java 9 or newer !
	}

	/**
	 * Removes all whitespaces from the given string.
	 * 
	 * @param str
	 * @return str
	 */
	public static String removeWhiteSpaces(String str) {
		isEmpty(str);
		return str.replaceAll("\\s", "");
	}

	/**
	 * Joins the given strings by the given delimiter.
	 * 
	 * @param delimiter
	 * @param args
	 * @return str
	 */
	public static String joinByDelimiter(char delimiter, String... args) {
		isEmpty(args);

		StringJoiner joiner = new StringJoiner(String.valueOf(delimiter));

		for (String arg : args) {
			joiner.add(arg);
		}

		return joiner.toString();
	}

	/**
	 * Generates all permutations of a given string.
	 * 
	 * @param str
	 * @return permuteAndStore(prefix,str)
	 */
	public static Set<String> permuteAndStore(String str) {
		isEmpty(str);
		return permuteAndStore("", str); // This is a private method.
	}

	/**
	 * 
	 * @param prefix
	 * @param str
	 * @return Set<String>
	 */
	private static Set<String> permuteAndStore(String prefix, String str) {
		Set<String> permutations = new HashSet<String>();

		int length = str.length();
		if (length == 0) {
			permutations.add(prefix);
		} else {
			for (int i = 0; i < length; i++) {
				permutations.addAll(
						permuteAndStore(prefix + str.charAt(i), str.substring(i + 1, length) + str.substring(0, i)));
			}
		}

		return permutations;
	}
}
