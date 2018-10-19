package com.example.ohimarc.marc.model;

/**
 * Class representing a pair of arbitrary elements. The two elements do not need to be of the same type.
 *
 * @param <K> The first type of the pair.
 * @param <V> The second type of the pair.
 * @author Victor Johansson
 */
public class Pair<K, V> {
    private final K element0;
    private final V element1;

    /**
     * Creates a pair of two elements of arbitrary types.
     *
     * @param element0 The first element of the pair.
     * @param element1 The second element of the pair.
     */
    public Pair(K element0, V element1) {
        this.element0 = element0;
        this.element1 = element1;
    }

    /**
     * @return The first element of the pair.
     */
    public K getElement0() {
        return element0;
    }

    /**
     * @return The second element of the pair.
     */
    public V getElement1() {
        return element1;
    }
}
