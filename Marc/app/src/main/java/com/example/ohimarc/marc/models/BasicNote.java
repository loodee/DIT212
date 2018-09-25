package com.example.ohimarc.marc.models;

public class BasicNote extends Note {
    String front, back;

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
