package com.example.ohimarc.marc.model;

/**
 * The Note class holds a list of cards, and information for how to generate them.
 *
 * @author Thomas Li
 */
public abstract class Note {
    Card[] cards;

    /**
     * Assigns to `cards` an array of Cards generated from the class's private values.
     * Each call of generateCards() generates a new array with new Cards.
     */
    abstract void generateCards();

    /**
     * Returns an array of tuples containing the information displayed on the card
     *
     * @return Array of tuples of strings, where index 0 contains the info on the front,
     * and index 1 contains the information on the back
     */
    public String[][] getCardInfo() {
        String[][] cardInfos = new String[cards.length][];
        for (int i = 0; i < cardInfos.length; i++) {
            cardInfos[i] = new String[]{cards[i].getFront(), cards[i].getBack()};
        }
        return cardInfos;
    }

    /**
     * @return The cards contained in the Note.
     */
    public Card[] getCards() {
        return cards;
    }

    /**
     * @return The number of cards contained in the Note.
     */
    public int getSize() {
        return cards != null ? cards.length : 0;
    }
}
