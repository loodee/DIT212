package com.example.ohimarc.marc.Presenter;

import com.example.ohimarc.marc.models.Card;
import com.example.ohimarc.marc.models.Deck;
import com.example.ohimarc.marc.models.FlashCardGame;
import com.example.ohimarc.marc.View.FlashcardView;

public class FlashcardPresenter implements Presenter {

    private FlashCardGame game;
    private FlashcardView view;
    private Deck testDeck;


    public FlashcardPresenter(FlashcardView view){
        testDeck = new Deck("testdeck");
        testDeck.addBasicNote("hund (front)", "dog");
        testDeck.addBasicNote("katt (front)", "katt");
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


    public void flashCardClicked(boolean frontActive){
        if(frontActive){
            view.flipCardButton("A:",game.peekNextCard()[1]);
        }
        else{
            view.flipCardButton("Q:",game.peekNextCard()[0]);
        }
    }

    public void correctButtonClicked(){

    }

    public void incrrectButtonClicked(){

    }
}
