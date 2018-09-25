package com.example.ohimarc.marc.models;

public abstract class Game {
    Deck deck;
    String[][] cardCopies;

    public Game(Deck deck){
        this.deck = deck;
        this.cardCopies = deck.getCardCopies();
    }

    public abstract String[] peekNextCard();

    public abstract void goToNextCard();

    public String getDeckTitle(){
        return deck.getTitle();
    }
}
