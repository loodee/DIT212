package com.example.ohimarc.marc.models;

/**
 * Class containing information for
 */
public class BasicNote extends Note {
    private String front, back;

    /**
     * Creates a BasicNote with `front` and `back` string values for generating cards.
     * @param front The text that will appear on the front of generated Cards.
     * @param back The text that will appear on the back of generated Cards.
     */
    public BasicNote(String front, String back) {
        this.front = front;
        this.back = back;
    }

    @Override
    public void generateCards() {
        Card[] newCards = {new Card(front, back)};
        cards = newCards;
    }

    public String getFront() {
        return front;
    }
    public void setFront(String front) {
        this.front = front;
    }
    public String getBack() {
        return back;
    }
    public void setBack(String back) {
        this.back = back;
    }
}
