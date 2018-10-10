package com.example.ohimarc.marc.presenter;

import com.example.ohimarc.marc.model.FlashCardGame;
import com.example.ohimarc.marc.view.ResultsView;

import java.util.ArrayList;

public class ResultPresenter implements Presenter {
    private final ArrayList<Integer> amountCorret;
    private ResultsView view;

    public ResultPresenter(ArrayList<Integer> amountCorret, ResultsView view) {
        this.view = view;
        this.amountCorret = amountCorret;
    }

    @Override
    public void onCreate() {
        view.initTexts(amountCorret.get(0), amountCorret.get(1));
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
