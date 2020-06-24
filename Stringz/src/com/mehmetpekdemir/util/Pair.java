package com.mehmetpekdemir.util;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 *
 * @param <V> Vowels
 * @param <C> Consonants
 */

public final class Pair<V, C> {

	private final V vowels;
	private final C consonants;

	public Pair(V vowels, C consonants) {
		this.vowels = vowels;
		this.consonants = consonants;
	}

	public static <V, C> Pair<V, C> of(V vowels, C consonants) {
		return new Pair<V, C>(vowels, consonants);
	}

	@Override
	public String toString() {
		return "Pair [vowels=" + vowels + ", consonants=" + consonants + "]";
	}

}
