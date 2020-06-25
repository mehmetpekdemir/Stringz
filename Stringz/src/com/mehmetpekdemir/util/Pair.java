package com.mehmetpekdemir.util;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.8
 *
 * @param <V> v
 * @param <C> c
 */

public final class Pair<V, C> {

	private final V v;
	private final C c;

	public Pair(V v, C c) {
		this.v = v;
		this.c = c;
	}

	public static <V, C> Pair<V, C> of(V v, C c) {
		return new Pair<V, C>(v, c);
	}

	@Override
	public String toString() {
		return "Pair [v=" + v + ", c=" + c + "]";
	}

}
