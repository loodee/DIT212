package com.example.ohimarc.marc.presenter;

import com.example.ohimarc.marc.model.Deck;
import com.example.ohimarc.marc.model.FlashCardGame;
import com.example.ohimarc.marc.model.MemorizationTrainingTool;
import com.example.ohimarc.marc.model.Pair;
import com.example.ohimarc.marc.view.flashcardView.FlashcardView;

import java.util.ArrayList;

/**
 * Author Victor Johansson (Vroxie on github)
 */

/**
 * This class is the presenter for playing a flashcardgame, tells
 *  The view what to do when buttons are clicked etc.
 */
public class FlashcardPresenter {

    private final MemorizationTrainingTool mtt = MemorizationTrainingTool.getInstance();
    private FlashCardGame game;
    private final FlashcardView view;
    private final int index;


    public FlashcardPresenter(FlashcardView view, int index) {
        this.view = view;
        this.index = index;
        onCreate();
    }


    /**
     * Initializes variables that the presenter needs when it gets created
     * Such as a game with a deck and the deck that shall be played
     */
    private void onCreate() {
        Deck deck = mtt.getActiveUser().getDeck(index);
        game = new FlashCardGame(deck);
        if (game.getDecksize() > 0) {
            view.initTexts(getDeckTitle(), game.peekNextCard()[0]);
        }
    }

    /**
     * Computes how many correct Answers I got from playing the deck
     *
     * @return an arrayList where index 0 is the amount of correct answers
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

    /**
     * @return the title of deck that is being played
     */
    public String getDeckTitle() {
        return game.getDeckTitle();
    }

    /**
     * @return the name of the gamemode that is playing, in this case it Flashcard Game
     */
    public String getGameName() {
        return game.getName();
    }


    /**
     * Handles when the card is clicked
     * Changes the card depending on what side that were active
     *
     * @param frontActive a boolean that says if the front is active or not
     */
    public void flashCardClicked(boolean frontActive) {
        if (game.getDecksize() > 0) {
            if (frontActive) {
                view.flipCardButton("A:", game.peekNextCard()[1]);
            } else {
                view.flipCardButton("Q:", game.peekNextCard()[0]);
            }
        }
    }

    /**
     * Handles when one of the result buttons is clicked
     * Puts the question and the result the array that holds it
     * Also go to next card if it is not the last card, then it
     * Tells the view to change view
     *
     * @param isCorrect the result of the question
     */
    public void resultButtonsClicked(boolean isCorrect) {
        if (game.getDecksize() > 0) {
            if (game.getNextCard() < game.getDecksize() - 1) {
                game.questionAnswer(game.getNextCard(), isCorrect);
                game.goToNextCard();
                view.initTexts("Q:", game.peekNextCard()[0]);
            } else {
                game.questionAnswer(game.getNextCard(), isCorrect);
                view.changeView();
            }
        } else view.changeView();
    }
}
