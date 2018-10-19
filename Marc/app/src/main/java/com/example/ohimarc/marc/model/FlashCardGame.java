package com.example.ohimarc.marc.model;

/**
 * @author Gustav Albertsson
 * @author Thomas Li
 *
 * An implementation of Game, this class contains everything needed to play a flashcard game
 * */
public class FlashCardGame extends Game {

    /**
     * Creates an flashcard game on a given deck
     * @param deck The deck to play the flashcard game on
     * */
    public FlashCardGame(Deck deck){
        super(deck,"Flashcard Game");
    }

    @Override
    public String[] peekNextCard() {
        return getNextCard() < cardCopies.length ? cardCopies[getNextCard()] : null;
    }

}
