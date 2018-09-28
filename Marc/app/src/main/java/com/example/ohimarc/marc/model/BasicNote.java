package com.example.ohimarc.marc.model;

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
        this.front = front != null ? front : "";
        this.back = back != null ? back : "";
        generateCards();
    }

    @Override
    public void generateCards() {
        Card[] newCards = {new Card(front, back)};
        cards = newCards;
    }

    @Override
    public String[][] getCardInfo() {
        String[][] cardInfos = new String[cards.length][];
        for (int i = 0; i < cardInfos.length; i++) {
            cardInfos[i] = new String[] {cards[i].getFront(), cards[i].getBack()};
        }
        return cardInfos;
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
