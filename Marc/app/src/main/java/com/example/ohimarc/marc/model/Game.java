package com.example.ohimarc.marc.model;

/**
 * @author Gustav Albertsson
 * @author Thomas Lee
 * @author Victor Johansson
 * @author Alexander Sandberg
 * <p>
 * Abstract class that contains general things about how a game mode should work and what is should contain
 */
public abstract class Game {
    private final Deck deck;
    final String[][] cardCopies;
    private final Pair[] pairs;
    private final String name;
    private int nextCard = 0;

    /**
     * @param name The name of the game
     * @param deck The deck which the game is being played on
     */
    Game(Deck deck, String name) {
        this.deck = deck;
        this.name = name;
        this.cardCopies = deck.getCardCopies();
        this.pairs = new Pair[deck.getDeckSize()];
    }

    /**
     * Returns the next card in the game, if there are no more cards in the game null will be returned
     *
     * @return Returns an array where the first index is the front of the card and the second index is the back of the card.
     */
    public abstract String[] peekNextCard();

    /**
     * Goes to the next card in the deck
     */
    public void goToNextCard() {
        nextCard++;
    }

    public String getDeckTitle() {
        return deck.getTitle();
    }

    /**
     * questionAnswer creates a Pair of the parameters, which is then added
     * to a list of Pair. If the Pair already exists in the Pair list, the
     * pair currently in the list is replaced.
     *
     * @param index     is expected to equal the spot of the current card
     *                  in its' deck. This index will later be used to add an
     *                  answer at the same index in the Pair list.
     * @param isCorrect is the answer given to the question (Right = true,
     *                  Wrong = false). This answer is later added to the
     *                  Pair list.
     */
    public void questionAnswer(int index, boolean isCorrect) {
        Pair<Integer, Boolean> ans = new Pair<>(index, isCorrect);
        pairs[index] = ans;
    }

    /**
     * @return An array of pairs, the first element in the pair is the question that was answered, the second element in the pair is if the answer was correct or not
     */
    public Pair[] getQuestionAns() {
        return pairs;
    }

    /**
     * @return Returns the name of the game
     */
    public String getName() {
        return name;
    }

    /**
     * @return Returns the index of the next card
     */
    public int getNextCard() {
        return nextCard;
    }

    /**
     * @return Returns the size of the deck that the game is being played on
     */
    public int getDecksize() {
        return deck.getDeckSize();
    }
}
