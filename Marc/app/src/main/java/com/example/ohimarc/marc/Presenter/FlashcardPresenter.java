package com.example.ohimarc.marc.Presenter;


import com.example.ohimarc.marc.Model.Card;
import com.example.ohimarc.marc.Model.Deck;
import com.example.ohimarc.marc.Model.FlashCardGame;
import com.example.ohimarc.marc.Model.Pair;
import com.example.ohimarc.marc.View.FlashcardView;
import com.example.ohimarc.marc.View.ResultsView;

import java.util.ArrayList;

public class FlashcardPresenter implements Presenter {

    private FlashCardGame game;
    private FlashcardView view;
    private  ResultsView resultsView;
    private Deck testDeck;


    public FlashcardPresenter(FlashcardView view){
        Card testCard1 = new Card("Hej","Alexander");
        Card testCard2 = new Card("Hej","Victor");
        testDeck = new Deck("testdeck");
        testDeck.addCard(testCard1.getFront(),testCard1.getBack());
        testDeck.addCard(testCard2.getFront(),testCard2.getBack());
        this.view = view;
        game = new FlashCardGame(testDeck);
    }
    @Override
    public void onCreate() {
        game = new FlashCardGame(testDeck);
        view.initTexts(game.getDeckTitle(),game.peekNextCard()[0]);
    }

    @Override
    public void onPause() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onDestroy() {

    }

    /*
    public ArrayList<Pair> getAnsList() {
        return game.getQuestionAns();
    }*/

    public int getAmountCorrectAnswers(){
        int amountCorrect = 0;
        for(Pair p : game.getQuestionAns()){
            if((Boolean)p.getElement1()){
                amountCorrect++;
            }
        }
        return amountCorrect;
    }

    public void flashCardClicked(boolean frontActive){
        if(frontActive){
            view.flipCardButton("A:",game.peekNextCard()[1]);
        }
        else{
            view.flipCardButton("Q:",game.peekNextCard()[0]);
        }
    }

    public void resultButtonsClicked(boolean isCorrect){
        if(game.getNextCard() < game.getDecksize()) {
            game.questionAnswer(game.getNextCard(), isCorrect);
            game.goToNextCard();
            view.flipCardButton("Q:", game.peekNextCard()[0]);
        }
        else{
            game.questionAnswer(game.getNextCard(),isCorrect);
            view.changeView();
        }
    }

}
