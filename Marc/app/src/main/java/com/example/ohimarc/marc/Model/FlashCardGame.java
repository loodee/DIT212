package com.example.ohimarc.marc.Model;

public class FlashCardGame extends Game {

    private int nextCard = 0;

    public FlashCardGame(Deck deck){
        super(deck);

        //Only here for testing for first user story
        deck.addCard("Placeholder front side", "Placeholder back side");
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
