package com.example.ohimarc.marc.model;

public class FlashCardGame extends Game {

    public FlashCardGame(Deck deck){
        super(deck,"Flashcard Game");
    }

    @Override
    public String[] peekNextCard() {
        return nextCard < cardCopies.length ? cardCopies[nextCard] : null;
    }

}
