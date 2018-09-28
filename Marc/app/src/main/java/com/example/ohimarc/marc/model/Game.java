package com.example.ohimarc.marc.model;

public abstract class Game {
    Deck deck;
    String[][] cardCopies;
    private Pair[] pairs;
    private String name;

    public Game(Deck deck, String name) {
        this.deck = deck;
        this.name = name;
        this.cardCopies = deck.getCardCopies();
        this.pairs = new Pair[deck.getDeckSize()];
    }

    public abstract String[] peekNextCard();

    public abstract void goToNextCard();

    public String getDeckTitle() {
        return deck.getTitle();
    }

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
}
