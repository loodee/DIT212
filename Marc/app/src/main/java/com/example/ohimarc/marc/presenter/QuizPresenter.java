package com.example.ohimarc.marc.presenter;

import com.example.ohimarc.marc.model.Deck;
import com.example.ohimarc.marc.model.QuizGame;
import com.example.ohimarc.marc.view.quizMode.QuizView;

public class QuizPresenter implements Presenter {


    private QuizView view;


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
        String[] texts = g.peekNextCard();
        view.initTexts(texts[0], texts[1], texts[2], texts[3], texts[4]);
    }

    public void questionAnswered(int i) {

    }

    public void proceed() {

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
