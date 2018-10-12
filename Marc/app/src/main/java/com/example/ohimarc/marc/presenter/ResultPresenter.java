package com.example.ohimarc.marc.presenter;

import com.example.ohimarc.marc.model.MemorizationTrainingTool;
import com.example.ohimarc.marc.view.resultsView.ResultsView;

import java.util.ArrayList;

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

    public String getDeckTitle() {
        return deckTitle;
    }

    public void onCreate() {
        view.initTexts(amountCorrect.get(0), amountCorrect.get(1));
    }

}
