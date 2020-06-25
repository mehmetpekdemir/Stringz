package com.mehmetpekdemir.stringz;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.StringJoiner;

import com.mehmetpekdemir.util.Pair;
import com.mehmetpekdemir.util.Sort;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.8
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
	 * consonants (e.g. ,in Turkish there are 8 vowels.)
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
	 * Determines if the given string is palindrome or not.
	 * 
	 * @param str
	 * @return true: palindrome , false : is not palindrome
	 */
	public static boolean isPalindrome(String str) {
		isEmpty(str);

		return str.equals(new StringBuilder(str).reverse().toString());
	}

	/**
	 * Removes the duplicate characters from the given string.
	 * 
	 * @param str
	 * @return str
	 */
	public static String removeDuplicates(String str) {
		isEmpty(str);

		StringBuilder sb = new StringBuilder();
		Set<Character> characters = new HashSet<Character>();

		final char[] chArray = str.toCharArray();
		for (char ch : chArray) {
			if (characters.add(ch)) {
				// Return Value: The function returns True if the element is not present in the
				// HashSet otherwise False if the element is already present in the HashSet.
				sb.append(ch);
			}
		}

		return sb.toString();
	}

	/**
	 * Removes the given character from the given string.
	 * 
	 * @param str
	 * @param ch
	 * @return str
	 */
	public static String removeCharacter(String str, char ch) {
		isEmpty(str);

		StringBuilder sb = new StringBuilder();

		final char[] chArray = str.toCharArray();
		for (char c : chArray) {
			if (c != ch) {
				sb.append(c);
			}
		}
		return sb.toString();
	}

	/**
	 * Finds the character with the most appearances in the given string.
	 * 
	 * Ignoring space character !
	 * 
	 * @param str
	 * @return most repeating character format: [character-name , sum-character]
	 */
	public static Pair<Character, Integer> maxOccurenceCharacter(String str) {
		isEmpty(str);

		HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();

		final char[] chArray = str.toCharArray();
		for (int i = 0; i < chArray.length; i++) {
			char ch = chArray[i];
			if (!Character.isWhitespace(ch)) {
				Integer number = hashMap.get(ch);
				if (number == null) {
					hashMap.put(ch, 1);
				} else {
					hashMap.put(ch, ++number);
				}
			}
		}

		int maxOccurences = Collections.max(hashMap.values());

		char maxCharacter = Character.MIN_VALUE;
		for (Entry<Character, Integer> entry : hashMap.entrySet()) {
			if (entry.getValue() == maxOccurences) {
				maxCharacter = entry.getKey();
			}
		}

		return Pair.of(maxCharacter, maxOccurences);
	}

	/**
	 * Check Sort
	 * 
	 * @param direction
	 * @throws IllegalArgumentException
	 */
	private static void isEmpty(Sort direction) {
		if (direction == null) {
			throw new IllegalArgumentException();
		}
	}

	/**
	 * Sorts by length the given array of strings.
	 * 
	 * @param strings
	 * @param direction
	 */
	public static void sortArrayByLength(String[] strings, Sort direction) {
		isEmpty(strings);
		isEmpty(direction);
		if (direction.equals(Sort.ASCENDING)) {
			Arrays.sort(strings, Comparator.comparingInt(String::length));
		} else {
			Arrays.sort(strings, Comparator.comparingInt(String::length).reversed());
		}
	}

	/**
	 * Checks if the given string contains the given substring.
	 * 
	 * @param text
	 * @param subText
	 * @return True : contain , False : does not contain
	 */
	public static boolean contains(String text, String subText) {
		isEmpty(text);
		isEmpty(subText);
		return text.indexOf(subText) != -1; // Search a string for the first occurrence of subText.
	}

	/**
	 * Count the occurrences of a given string in another given string.
	 * 
	 * @param str
	 * @param toFind
	 * @return count
	 */
	public static int countStringInString(String str, String toFind) {
		isEmpty(str);
		isEmpty(toFind);

		int position = 0;
		int count = 0;
		int n = toFind.length();

		while ((position = str.indexOf(toFind, position)) != -1) {
			position = position + n;
			count++;
		}

		return count;
	}

	/**
	 * Checks if two strings are anagrams. Consider that an anagram of a string is a
	 * permutation of this string ignoring capitalization and whitespaces.
	 * 
	 * @param str1
	 * @param str2
	 * @return true : Anagram , False : is not anagram
	 */
	public static boolean isAnagram(String str1, String str2) {
		isEmpty(str1);
		isEmpty(str2);

		char[] chArray1 = str1.replaceAll("\\s", "").toLowerCase().toCharArray();
		char[] chArray2 = str2.replaceAll("\\s", "").toLowerCase().toCharArray();

		if (chArray1.length != chArray2.length) {
			return false;
		}

		// Analysis of QuickSort : Best Case : O(nLogn) , Worst Case : O(n^2).
		Arrays.sort(chArray1);
		Arrays.sort(chArray2);

		return Arrays.equals(chArray1, chArray2);
	}

	/**
	 * Concatenates the same string of a given number of times.
	 * 
	 * @param str
	 * @param count
	 * @return combined string
	 * @throw {@link OutOfMemoryError}
	 */

	public static String concatRepeat(String str, int count) {
		isEmpty(str);

		if (count <= 0) {
			return str;
		}

		if (Integer.MAX_VALUE / count < str.length()) {
			throw new OutOfMemoryError("Maximum size of a String will be exceeded ! ");
		}

		StringBuilder sb = new StringBuilder(str.length() * count);
		for (int i = 0; i < count; i++) {
			sb.append(str + " ");
		}

		return sb.toString();
	}

	/**
	 * Finds the longest common prefix of given strings.
	 * 
	 * @param strings
	 * @return common prefix
	 */
	public static String longestCommonPrefix(String[] strings) {
		isEmpty(strings);
		if (strings.length == 1) {
			return strings[0];
		}

		int firstLength = strings[0].length();
		for (int prefixLength = 0; prefixLength < firstLength; prefixLength++) {

			char ch = strings[0].charAt(prefixLength);
			for (int i = 1; i < strings.length; i++) {
				if (prefixLength >= strings[i].length() || strings[i].charAt(prefixLength) != ch) {
					return strings[i].substring(0, prefixLength);
				}
			}
		}

		return strings[0];
	}

}
