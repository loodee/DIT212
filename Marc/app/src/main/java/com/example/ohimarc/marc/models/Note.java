package com.example.ohimarc.marc.models;

abstract class Note {
    Card[] cards;

    /**
     * Assigns to `cards` an array of Cards generated from the class's private values.
     * Each call of generateCards() generates a new array with new Cards.
     */
    abstract void generateCards();

    /**
     * Returns an array of tuples containing the information displayed on the card
     * @return Array of tuples of strings, where index 0 contains the info on the front,
     * and index 1 contains the information on the back
     */
    abstract String[][] getCardInfo();

    public Card[] getCards() {
        return cards;
    }
    public int getSize() {
        return cards != null ? cards.length : 0;
    }
}
