package com.example.ohimarc.marc.presenter;

import com.example.ohimarc.marc.model.Deck;
import com.example.ohimarc.marc.model.MemorizationTrainingTool;
import com.example.ohimarc.marc.model.Pair;
import com.example.ohimarc.marc.model.QuizGame;
import com.example.ohimarc.marc.view.quizView.QuizView;

import java.util.ArrayList;

public class QuizPresenter {

    private QuizView view;
    private String[] texts;
    private QuizGame game;
    private Deck deck;
    private int deckIndex;

    private final MemorizationTrainingTool mtt = MemorizationTrainingTool.getInstance();

    public QuizPresenter(QuizView view, int deckIndex) {
        this.view = view;
        this.deckIndex = deckIndex;
    }

    public void onCreate() {
        deck = mtt.getActiveUser().getDeck(deckIndex);
        game = new QuizGame(deck);
        texts = game.peekNextCard();
        view.initTexts(texts);
    }

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

    private void setTexts() {
        texts = game.peekNextCard();
    }

    public String getDeckTitle() {
        return deck.getTitle();
    }

    public String getGameName() {
        return game.getName();
    }

    public void proceed() {
        game.goToNextCard();
        if (game.peekNextCard() != null) {
            setTexts();
            view.initTexts(texts);
        } else view.changeView();
    }

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
