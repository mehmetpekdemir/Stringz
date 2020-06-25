package com.mehmetpekdemir.main;

import java.util.Arrays;

import com.mehmetpekdemir.stringz.Stringz;
import com.mehmetpekdemir.util.Sort;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.8
 *
 */
public class Main {

	private static final String TEXT = "MEHMET";
	private static final String[] STRINGS = { "one", "two", "three", "four", "five" };
	private static final String[] TEXTS = { "abc", "abcd", "abcde", "ab", "abcd", "abcdef" };

	public static void main(String[] args) {
		System.out.println(Stringz.countDuplicateCharacters(TEXT));
		System.out.println(Stringz.firstNonRepeatedCharacter(TEXT));
		System.out.println(Stringz.reverse(TEXT));
		System.out.println(Stringz.containsOnlyDigits("123a"));
		System.out.println(Stringz.countVowelsAndConsonants(TEXT).toString());
		System.out.println(Stringz.countOccurencesOfACertainCharacter(TEXT, 'M'));
		System.out.println(Stringz.removeWhiteSpaces("Mehmet     Pekdemir       "));
		System.out.println(Stringz.joinByDelimiter(' ', "Mehmet", "Pekdemir", "Test"));
		System.out.println(Stringz.permuteAndStore("ABC"));
		System.out.println(Stringz.isPalindrome("NOON"));
		System.out.println(Stringz.removeDuplicates(TEXT));
		System.out.println(Stringz.removeCharacter(TEXT, 'M'));
		System.out.println(Stringz.maxOccurenceCharacter(TEXT));
		Stringz.sortArrayByLength(STRINGS, Sort.DESCENDING);
		System.out.println(Arrays.toString(STRINGS));
		System.out.println(Stringz.contains(TEXT, "MEH"));
		System.out.println(Stringz.countStringInString(TEXT, "ME"));
		System.out.println(Stringz.isAnagram(TEXT, "MEHTME"));
		System.out.println(Stringz.concatRepeat(TEXT, 10));
		System.out.println(Stringz.longestCommonPrefix(TEXTS));
		
	}

}
