package com.example.ohimarc.marc.model;

public abstract class Game {
    Deck deck;
    String[][] cardCopies;
    private Pair[] pairs;
    private String name;
    int nextCard = 0;

    public Game(Deck deck, String name) {
        this.deck = deck;
        this.name = name;
        this.cardCopies = deck.getCardCopies();
        this.pairs = new Pair[deck.getDeckSize()];
    }

    /**
     * Returns the next card in the game, if there are no more cards in the game null will be returned
     * @return Returns an array where the first index is the front of the card and the second index is the back of the card.
     * */
    public abstract String[] peekNextCard();

    /**
     * Goes to the next card in the deck
    * */
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
     * @param index is expected to equal the spot of the current card
     *              in its' deck. This index will later be used to add an
     *              answer at the same index in the Pair list.
     * @param isCorrect is the answer given to the question (Right = true,
     *                  Wrong = false). This answer is later added to the
     *                  Pair list.
     */
    public void questionAnswer(int index, boolean isCorrect) {
        Pair<Integer, Boolean> ans = new Pair<>(index, isCorrect);
        pairs[index] = ans;
    }

    public Pair[] getQuestionAns() {
        return pairs;
    }

    public String getName() {
        return name;
    }

    public int getNextCard(){
        return nextCard;
    }

    public int getDecksize(){
        return deck.getDeckSize();
    }
}
