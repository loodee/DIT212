package com.example.ohimarc.marc.presenter;

import android.util.Log;

import com.example.ohimarc.marc.model.MemorizationTrainingTool;
import com.example.ohimarc.marc.view.ResultsView;

import java.util.ArrayList;

public class ResultPresenter implements Presenter {
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

    @Override
    public void onCreate() {
        view.initTexts(amountCorrect.get(0), amountCorrect.get(1));
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
