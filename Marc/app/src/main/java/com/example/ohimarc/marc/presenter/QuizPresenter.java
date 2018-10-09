package com.example.ohimarc.marc.presenter;

import com.example.ohimarc.marc.model.Deck;
import com.example.ohimarc.marc.model.Pair;
import com.example.ohimarc.marc.model.QuizGame;
import com.example.ohimarc.marc.view.quizMode.QuizView;

import java.util.ArrayList;

public class QuizPresenter implements Presenter {


    private QuizView view;
    private String[] texts;
    QuizGame g;
    Deck d;

    public QuizPresenter(QuizView view) {
        this.view = view;
        initDeckAndGame();
        texts = g.peekNextCard();
        view.initTexts(texts);
    }

    private void initDeckAndGame() {
        d = new Deck("Djur på svenska");
        d.addBasicNote("Hund", "Dog");
        d.addBasicNote("Katt", "Cat");
        d.addBasicNote("Häst", "Horse");
        d.addBasicNote("Råtta", "Rat");
        d.addBasicNote("Orm", "Snake");
        d.addBasicNote("Sköldpadda", "Turtle");
        d.addBasicNote("Igelkott", "Hedgehog");
        d.addBasicNote("Lejon", "Lion");
        d.addBasicNote("Myrslok", "Anteater");
        g = new QuizGame(d);
    }

    public void questionAnswered(int answer) {
        g.sendAnswer(answer);
        for (int possibleAnswer = 1; possibleAnswer < 5; possibleAnswer++) {
            if (g.isCorrect(possibleAnswer)) {
                view.highlightRightAnswer(possibleAnswer - 1);
                if (!(answer == possibleAnswer)) {
                    view.highlightWrongAnswer(answer - 1);
                }
                break;
            }
        }
    }

    private void setTexts() {
        texts = g.peekNextCard();
    }

    public String getDeckTitle() {
        return d.getTitle();
    }

    public String getGameName() {
        return g.getName();
    }

    public void proceed() {
        g.goToNextCard();
        if (g.peekNextCard() != null) {
            setTexts();
            view.initTexts(texts);
        } else view.changeView();
    }

    public ArrayList<Integer> getAmountCorrectAnswers() {
        ArrayList<Integer> ansAmount = new ArrayList<>();
        int amountCorrect = 0;
        for (Pair p : g.getQuestionAns()) {
            if ((Boolean) p.getElement1()) {
                amountCorrect++;
            }
        }
        int totalDeckSize = g.getDecksize();
        ansAmount.add(amountCorrect);
        ansAmount.add(totalDeckSize);
        return ansAmount;
    }

    @Override
    public void onCreate() {

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
}
