package com.example.ohimarc.marc.presenter;

import com.example.ohimarc.marc.model.MemorizationTrainingTool;
import com.example.ohimarc.marc.view.resultsView.ResultsView;

import java.util.ArrayList;

/**
 * @author Victor Johansson (Vroxie on github)
 */
public class ResultPresenter {
    private final ArrayList<Integer> amountCorrect;
    private ResultsView view;
    String deckTitle;

    private final MemorizationTrainingTool mtt = MemorizationTrainingTool.getInstance();

    public ResultPresenter(ResultsView view, ArrayList<Integer> amountCorrect, int deckIndex) {
        this.view = view;
        this.amountCorrect = amountCorrect;
        deckTitle = mtt.getActiveUser().getDeck(deckIndex).getTitle();
    }

    /**
     * @return the deck that has being played title
     */
    public String getDeckTitle() {
        return deckTitle;
    }

    /**
     * Tells the view the result
     * Where the first element in amountCorrect is amount of correct answers
     * And the second element is total amount of questions
     */
    public void onCreate() {
        view.initTexts(amountCorrect.get(0), amountCorrect.get(1));
    }

}
