package com.example.ohimarc.marc.model;

/**
 * Class containing information for
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

    @Override
    public void generateCards() {
        cards = new Card[]{new Card(front, back)};
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
