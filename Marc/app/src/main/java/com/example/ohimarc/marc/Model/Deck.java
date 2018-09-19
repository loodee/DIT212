package com.example.ohimarc.marc.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Class containing groups of Card objects and functions for retrieving information from the cards.
 */
public class Deck {
    private List<Card> cards;
    private String title;

    /**
     * Creates a new Deck with a provided title.
     * @param title Defaults to a preset default if null is provided as a title.
     */
    public Deck(String title) {
        this.cards = new ArrayList<>();
        this.title = title != null ? title : "Default title";
    }

    public void addCard(String front, String back) {
        cards.add(new Card(front, back));
    }

    /**
     * Given an index of an existing card in the deck, returns
     * an array containing the string values of the front and back
     * of the card.
     * @param index Index of the desired card from the deck.
     * @return A String array of size 2, where index 0 corresponds to the front of the card,
     * and index 1 corresponds to the back.
     */
    public String[] getCardInfo(int index) {
        Card c = cards.get(index);
        return new String[] {c.getFront(), c.getBack()};
    }

    public String getTitle() {
        return title;
    }

    public int getDeckSize() {
        return cards.size();
    }
}
