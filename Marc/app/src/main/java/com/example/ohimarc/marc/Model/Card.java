package com.example.ohimarc.marc.Model;

public class Card {

    private String front, back;
    
    public Card(String front, String back){
        this.front = front;
        this.back = back;
    }

    public String getFront() {
        return front;
    }

    public String getBack() {
        return back;
    }

}
