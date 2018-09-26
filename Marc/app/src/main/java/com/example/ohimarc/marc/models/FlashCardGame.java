package com.example.ohimarc.marc.models;

public class FlashCardGame extends Game {
    private int nextCard = 0;

    public FlashCardGame(Deck deck){
        super(deck);
    }

    @Override
    public String[] peekNextCard() {
        return nextCard < cardCopies.length ? cardCopies[nextCard] : null;
    }
    @Override
    public void goToNextCard() {
        nextCard++;
    }
}
