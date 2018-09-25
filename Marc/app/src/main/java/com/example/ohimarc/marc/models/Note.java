package com.example.ohimarc.marc.models;

public abstract class Note {
    Card[] cards;

    /**
     * Assigns to `cards` an array of Cards generated from the class's private values.
     * Each call of generateCards() generates a new array with new Cards.
     */
    abstract void generateCards();

    public Card[] getCards() {
        return cards;
    }
}
