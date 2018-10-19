package com.example.ohimarc.marc.model;

/**
 * Class containing information for storing and generating cards of the "Basic" type.
 *
 * @author Thomas Li
 */
public class BasicNote extends Note {
    private String front, back;

    /**
     * Creates a BasicNote with `front` and `back` string values for generating cards.
     *
     * @param front The text that will appear on the front of generated Cards.
     * @param back  The text that will appear on the back of generated Cards.
     */
    public BasicNote(String front, String back) {
        this.front = front != null ? front : "";
        this.back = back != null ? back : "";
        generateCards();
    }

    /**
     * Generates the cards according to the Note type (no special rules for BasicNotes)
     */
    @Override
    public void generateCards() {
        cards = new Card[]{new Card(front, back)};
    }

    /**
     * @return The text representing the "front" of the Note.
     */
    public String getFront() {
        return front;
    }

    /**
     * @param front The text to set the "front" value to.
     */
    public void setFront(String front) {
        this.front = front;
    }

    /**
     * @return The text representing the "back" of the Note.
     */
    public String getBack() {
        return back;
    }

    /**
     * @param back The text to set the "back" value to.
     */
    public void setBack(String back) {
        this.back = back;
    }
}
