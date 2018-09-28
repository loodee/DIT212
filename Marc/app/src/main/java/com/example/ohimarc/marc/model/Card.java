package com.example.ohimarc.marc.model;

/**
 * A class that holds the information for a Card, it holds the front and the back of the card.
 * */
public class Card {

    private String front, back;

    /**
    * Creates a card with front and back,
     * if front or back is null they will be set to empty string
     *
     * @param front The front on the card
     * @param back The backside of the card
    * */
    public Card(String front, String back){
        if(front == null){
            front = "";
        }
        if(back == null){
            back = "";
        }

        this.front = front;
        this.back = back;
    }

    public String getFront() {
        return front;
    }

    public String getBack() {
        return back;
    }

    @Override
    public String toString() {
        return "Front = " + front + '\'' + "Back=" + back + '\'';
        //endast för att testa om texten kmr fram på skärmen, tas bort sen
    }
}
