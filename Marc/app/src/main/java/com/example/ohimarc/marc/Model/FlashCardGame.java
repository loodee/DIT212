package com.example.ohimarc.marc.Model;

public class FlashCardGame extends Game {

    private int nextCard = 0;

    public FlashCardGame(Deck deck){
        super(deck);
    }

    @Override
    public String[] peekNextCard() {
        return deck.getCardInfo(nextCard);
    }
    @Override
    public void goToNextCard() {
        nextCard++;
    }
}
