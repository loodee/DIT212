package com.example.ohimarc.marc.presenter;

import com.example.ohimarc.marc.model.Deck;
import com.example.ohimarc.marc.model.FlashCardGame;
import com.example.ohimarc.marc.model.MemorizationTrainingTool;
import com.example.ohimarc.marc.model.Pair;
import com.example.ohimarc.marc.view.FlashcardView;

import java.util.ArrayList;

public class FlashcardPresenter implements Presenter {


    private final MemorizationTrainingTool mtt = MemorizationTrainingTool.getInstance();
    private FlashCardGame game;
    private FlashcardView view;
    private Deck deck;
    private int index;


    public FlashcardPresenter(FlashcardView view, int index) {
        this.view = view;
        this.index = index;
    }

    @Override
    public void onCreate() {
        deck = mtt.getActiveUser().getDeck(index);
        game = new FlashCardGame(deck);
        if (game.getDecksize() > 0) {
            view.initTexts(game.getDeckTitle(), game.peekNextCard()[0]);
        }
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

    /**
     * Computes how many correct Answers I got from playing the deck
     *
     * @return a arraylist where index 0 is the amount of correct answers
     * and index 1 is the deckSize
     */
    public ArrayList<Integer> getAmountCorrectAnswers() {
        ArrayList<Integer> ansAmount = new ArrayList<>();
        int amountCorrect = 0;
        for (Pair p : game.getQuestionAns()) {
            if ((Boolean) p.getElement1()) {
                amountCorrect++;
            }
        }
        int totalDeckSize = game.getDecksize();
        ansAmount.add(amountCorrect);
        ansAmount.add(totalDeckSize);
        return ansAmount;
    }

    public String getDeckTitle() {
        return game.getDeckTitle();
    }

    public String getGameName() {
        return game.getName();
    }


    public void flashCardClicked(boolean frontActive) {
        if (game.getDecksize() > 0) {
            if (frontActive) {
                view.flipCardButton("A:", game.peekNextCard()[1]);
            } else {
                view.flipCardButton("Q:", game.peekNextCard()[0]);
            }
        }
    }

    public void resultButtonsClicked(boolean isCorrect) {
        if (game.getDecksize() > 0) {
            if (game.getNextCard() < game.getDecksize() - 1) {
                game.questionAnswer(game.getNextCard(), isCorrect);
                game.goToNextCard();
                view.flipCardButton("Q:", game.peekNextCard()[0]);
            } else {
                game.questionAnswer(game.getNextCard(), isCorrect);
                view.changeView();
            }
        } else view.changeView();
    }
}
