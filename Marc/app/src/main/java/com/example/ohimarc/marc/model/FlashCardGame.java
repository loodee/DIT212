package com.example.ohimarc.marc.model;

public class FlashCardGame extends Game {

    public FlashCardGame(Deck deck){
        super(deck,"Flashcard Game");
    }

    @Override
    public String[] peekNextCard() {
        return getNextCard() < cardCopies.length ? cardCopies[getNextCard()] : null;
    }

}
