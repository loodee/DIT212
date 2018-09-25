package com.example.ohimarc.marc.Model;


import java.util.ArrayList;

public abstract class Game {
    Deck deck;
    private ArrayList<Pair> questionAns = new ArrayList<>();
    private String name;

    public Game(Deck deck,String name){
        this.deck = deck;
        this.name = name;
    }

    public abstract String[] peekNextCard();

    public abstract void goToNextCard();

    public String getDeckTitle(){
        return deck.getTitle();
    }

    public void questionAnswer(int index,boolean isCorrect){
        Pair<Integer,Boolean> ans = new Pair<>(index,isCorrect);
        questionAns.add(ans);
    }

    public ArrayList<Pair> getQuestionAns() {
        return questionAns;
    }

    public String getName() {
        return name;
    }
}
