package com.mehmetpekdemir.main;

import com.mehmetpekdemir.stringz.Stringz;
/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 *
 */
public class Main {

	public static void main(String[] args) {
		System.out.println(Stringz.countDuplicateCharacters("MEHMET"));
		System.out.println(Stringz.firstNonRepeatedCharacter("MEHMET"));
		System.out.println(Stringz.reverse("MEHMET"));
		System.out.println(Stringz.containsOnlyDigits("123a"));
		System.out.println(Stringz.countVowelsAndConsonants("MEHMET"));
		System.out.println(Stringz.countOccurencesOfACertainCharacter("MEHMET", 'M'));
		System.out.println(Stringz.removeWhiteSpaces("Mehmet     Pekdemir       "));
		System.out.println(Stringz.joinByDelimiter(' ', "Mehmet","Pekdemir","Test"));
		System.out.println(Stringz.permuteAndStore("ABC"));
	}

}
