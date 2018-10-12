package com.example.ohimarc.marc.model;

/**
 * The Card class holds two fields of information, representing the front and the back of the card
 * @author Thomas Li
 * @author Gustav Albertsson
 * @author Alexander Sandberg
 */
public class Card {

    private final String front, back;

    /**
     * Creates a card with front and back,
     * if front or back is null they will be set to an empty string
     *
     * @param front The front on the card
     * @param back  The backside of the card
     */
    public Card(String front, String back) {
        this.front = front != null ? front : "";
        this.back = back != null ? back : "";
    }

    public String getFront() {
        return front;
    }

    public String getBack() {
        return back;
    }
}
