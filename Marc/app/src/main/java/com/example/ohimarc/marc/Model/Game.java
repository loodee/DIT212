package com.example.ohimarc.marc.Model;

public abstract class Game {
    Deck deck;

    public Game(Deck deck){
        this.deck = deck;
    }

    public abstract String[] peekNextCard();

    public abstract void goToNextCard();

    public String getDeckTitle(){
        return deck.getTitle();
    }
}
