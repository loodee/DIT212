package com.example.ohimarc.marc.presenter;

import com.example.ohimarc.marc.model.Deck;
import com.example.ohimarc.marc.model.MemorizationTrainingTool;
import com.example.ohimarc.marc.model.Pair;
import com.example.ohimarc.marc.model.QuizGame;
import com.example.ohimarc.marc.view.quizView.QuizView;

import java.util.ArrayList;

/**
 * @author Alexander Sandberg (alexandersand on github)
 * The purpose of this Presenter is to handle any interaction with the model, for the Activity.
 * Whenever data needs to be extracted or edited in the model by QuizActivity, it is
 * supposed to be handled by this Presenter.
 */

public class QuizPresenter {

    private final QuizView view;
    private String[] texts;
    private QuizGame game;
    private Deck deck;
    private final int deckIndex;

    private final MemorizationTrainingTool mtt = MemorizationTrainingTool.getInstance();

    public QuizPresenter(QuizView view, int deckIndex) {
        this.view = view;
        this.deckIndex = deckIndex;
        onCreate();
    }

    /**
     * This function initializes some private values, and tells QuizActivity to set up itself
     * with texts given by QuizGame.
     */

    private void onCreate() {
        deck = mtt.getActiveUser().getDeck(deckIndex);
        game = new QuizGame(deck);
        texts = game.peekNextCard();
        view.initTexts(texts);
    }

    /**
     * This function is called from QuizActivity. It is called when a question has been answered.
     * It loops through four indexes with QuizGame, and checks whether that index marks the correct
     * answer to the question. If it was, it tells the view to mark the answer as correct. If the
     * given answer index is NOT the same as this index, it will tell the view to mark the given
     * answer as incorrect.
     * @param answer is an int, which is the index of the given answer.
     */

    public void questionAnswered(int answer) {
        game.sendAnswer(answer);
        for (int possibleAnswer = 1; possibleAnswer < 5; possibleAnswer++) {
            if (game.isCorrect(possibleAnswer)) {
                view.highlightRightAnswer(possibleAnswer - 1);
                if (!(answer == possibleAnswer)) {
                    view.highlightWrongAnswer(answer - 1);
                }
                break;
            }
        }
    }

    /**
     * This function sets the String list texts with the correct Strings, which is used in
     * QuizActivity.
     */

    private void setTexts() {
        texts = game.peekNextCard();
    }

    /**
     * This function gets the title of a specific deck in the model through the class
     * MemorizationTrainingTool.
     * @return a String, which is the title of a specific deck.
     */

    public String getDeckTitle() {
        return deck.getTitle();
    }

    /**
     * This function gets the name of the QuizGame through the class MemorizationTrainingTool.
     * @return a String, which is the name of the game.
     */

    public String getGameName() {
        return game.getName();
    }

    /**
     * This function contains functionality for getting the next question, and new possible answers
     * to that question. It tells the game to get the next card. If that card isn't null, it updates
     * the private list of Strings and passes it to QuizActivity. If the card is null, it tells
     * QuizActivity that it's time to go to the next view.
     */

    public void proceed() {
        game.goToNextCard();
        if (game.peekNextCard() != null) {
            setTexts();
            view.initTexts(texts);
        } else view.changeView();
    }

    /**
     * This function is written by Victor Johansson (Vroxie on github). This function creates
     * a list, where some data is to be stored, called ansAmount. It cycles through a list of
     * Pair's. If the current Pair is marked as correct, by the Boolean true, amountCorrect
     * is incremented. This will give us the total amount of correct answers in this game.
     * It then proceeds to get the specific deck's size. These values are put in ansAmount.
     * @return an Integer ArrayList, which holds the amount of correct answers in index 0, and
     * the total amount of questions in index 1.
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

}
