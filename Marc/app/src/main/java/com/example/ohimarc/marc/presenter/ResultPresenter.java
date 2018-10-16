package com.example.ohimarc.marc.presenter;

import com.example.ohimarc.marc.model.MemorizationTrainingTool;
import com.example.ohimarc.marc.view.resultsView.ResultsView;

import java.util.ArrayList;

/**
 * @author Victor Johansson (Vroxie on github)
 */
public class ResultPresenter {
    private final ArrayList<Integer> amountCorrect;
    private final ResultsView view;
    private final String deckTitle;

    public ResultPresenter(ResultsView view, ArrayList<Integer> amountCorrect, int deckIndex, String mode) {
        this.view = view;
        this.amountCorrect = amountCorrect;
        MemorizationTrainingTool mtt = MemorizationTrainingTool.getInstance();
        deckTitle = mtt.getActiveUser().getDeck(deckIndex).getTitle();
        mtt.getActiveUser().addNewStatistics(deckIndex, mode, amountCorrect.get(0));
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
