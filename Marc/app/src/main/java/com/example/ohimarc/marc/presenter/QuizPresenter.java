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
        d = new Deck("Djur på svenska");
        d.addBasicNote("Hund", "Dog");
        d.addBasicNote("Katt", "Cat");
        d.addBasicNote("Häst", "Horse");
        d.addBasicNote("Råtta", "Rat");
        g = new QuizGame(d);
        texts = g.peekNextCard();
        view.initTexts(texts[0], texts[1], texts[2], texts[3], texts[4]);

    }

    public void questionAnswered(int answer) {
        g.sendAnswer(answer);                                                   //1-4
        for (int possibleAnswer = 1; possibleAnswer < 5; possibleAnswer++) {    //1-4
            if (g.isCorrect(possibleAnswer)) {
                view.highlightRightA(possibleAnswer - 1);
                if (!(answer == possibleAnswer)) {
                    view.highlightWrongA(answer - 1);
                }
                break;
            }
        }
    }

    private void getNextTexts(QuizGame g) {
        g.goToNextCard();
        texts = g.peekNextCard();

    }

    public void proceed() {
        getNextTexts(g);
        view.initTexts(texts[0], texts[1], texts[2], texts[3], texts[4]);
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
